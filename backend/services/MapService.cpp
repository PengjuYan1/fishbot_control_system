#include "backend/services/MapService.h"

#include <algorithm>
#include <cctype>
#include <optional>
#include <thread>
#include <vector>

#include "backend/model/PointRecord.h"
#include "backend/services/NativePointSync.h"
#include "storage/repositories/PointRepository.h"

namespace {
std::string next_point_name(const std::vector<PointRecord>& points, const std::string& prefix,
                            const std::string& type) {
    int max_index = 0;
    for (const auto& point : points) {
        if (point.type != type || point.name.size() <= prefix.size() || point.name.rfind(prefix, 0) != 0) {
            continue;
        }

        bool numeric_suffix = true;
        for (std::size_t index = prefix.size(); index < point.name.size(); ++index) {
            if (std::isdigit(static_cast<unsigned char>(point.name[index])) == 0) {
                numeric_suffix = false;
                break;
            }
        }
        if (!numeric_suffix) {
            continue;
        }

        try {
            max_index = std::max(max_index, std::stoi(point.name.substr(prefix.size())));
        } catch (const std::exception&) {
        }
    }

    return prefix + std::to_string(max_index + 1);
}

bool has_point_type(const std::vector<PointRecord>& points, const std::string& type) {
    for (const auto& point : points) {
        if (point.type == type) {
            return true;
        }
    }
    return false;
}

std::optional<PointRecord> first_point_by_type(const std::vector<PointRecord>& points, const std::string& type) {
    for (const auto& point : points) {
        if (point.type == type) {
            return point;
        }
    }
    return std::nullopt;
}
}  // namespace

MapService::MapService(IRobotAdapter& adapter, PointRepository* point_repository)
    : adapter_(adapter), point_repository_(point_repository) {}

bool MapService::start_mapping() {
    const bool ok = adapter_.start_mapping();
    if (ok) {
        std::lock_guard<std::mutex> lock(state_mutex_);
        mapping_active_ = true;
        mapping_seed_done_ = false;
        mapping_seed_inflight_.store(false);
    }
    return ok;
}

bool MapService::stop_mapping() {
    const bool ok = adapter_.stop_mapping();
    std::lock_guard<std::mutex> lock(state_mutex_);
    mapping_active_ = false;
    mapping_seed_inflight_.store(false);
    return ok;
}

bool MapService::save_map(const std::string& map_name) const {
    return adapter_.save_map(map_name);
}

MapSnapshot MapService::get_snapshot() const {
    return adapter_.get_map_snapshot();
}

void MapService::observe_system_snapshot(const SystemSnapshot& snapshot) {
    if (point_repository_ == nullptr || !charging_detected(snapshot)) {
        return;
    }

    {
        std::lock_guard<std::mutex> lock(state_mutex_);
        if (!mapping_active_ || mapping_seed_done_) {
            return;
        }
    }

    bool expected = false;
    if (!mapping_seed_inflight_.compare_exchange_strong(expected, true)) {
        return;
    }

    std::thread([this]() { run_seed_worker(); }).detach();
}

bool MapService::charging_detected(const SystemSnapshot& snapshot) const {
    if (snapshot.charging) {
        return true;
    }

    switch (snapshot.control.charge_status_code) {
        case 45:
        case 46:
        case 47:
        case 48:
            return true;
        default:
            return false;
    }
}

void MapService::run_seed_worker() {
    bool seeded = false;
    try {
        seeded = try_seed_mapping_points_once();
    } catch (const std::exception&) {
        seeded = false;
    }

    {
        std::lock_guard<std::mutex> lock(state_mutex_);
        if (seeded) {
            mapping_seed_done_ = true;
        }
    }
    mapping_seed_inflight_.store(false);
}

bool MapService::try_seed_mapping_points_once() {
    if (point_repository_ == nullptr) {
        return false;
    }

    std::vector<PointRecord> native_points;
    if (adapter_.list_native_points(&native_points)) {
        point_repository_->merge_native_points(native_points);
    }

    bool native_has_charge = false;
    bool native_has_initial = false;
    for (const auto& point : native_points) {
        if (point.type == "charge") {
            native_has_charge = true;
        } else if (point.type == "initial") {
            native_has_initial = true;
        }
    }
    if (native_has_charge && native_has_initial) {
        return true;
    }

    auto points = point_repository_->list_points();
    std::optional<PointRecord> charge_point = first_point_by_type(points, "charge");
    if (!native_has_charge && !charge_point.has_value()) {
        PointRecord created_charge;
        const auto charge_name = next_point_name(points, "C", "charge");
        if (!adapter_.create_current_pose_point(charge_name, 1, &created_charge)) {
            return false;
        }
        created_charge.name = created_charge.name.empty() ? charge_name : created_charge.name;
        created_charge.type = "charge";
        created_charge.id = point_repository_->upsert_point(created_charge);
        charge_point = created_charge;
    }

    native_points.clear();
    if (adapter_.list_native_points(&native_points)) {
        point_repository_->merge_native_points(native_points);
    }

    native_has_initial = false;
    for (const auto& point : native_points) {
        if (point.type == "initial") {
            native_has_initial = true;
            break;
        }
    }
    if (native_has_initial) {
        return true;
    }

    points = point_repository_->list_points();
    if (has_point_type(points, "initial")) {
        return true;
    }

    if (!charge_point.has_value()) {
        charge_point = first_point_by_type(points, "charge");
    }
    if (!charge_point.has_value()) {
        return false;
    }

    PointRecord initial_point;
    initial_point.name = next_point_name(points, "I", "initial");
    initial_point.type = "initial";
    initial_point.x = charge_point->x;
    initial_point.y = charge_point->y;
    initial_point.theta = charge_point->theta;
    initial_point.floor_id = charge_point->floor_id;
    initial_point.map_id = charge_point->map_id;
    initial_point.point_id = 0;
    point_repository_->insert_point(initial_point);
    return true;
}
