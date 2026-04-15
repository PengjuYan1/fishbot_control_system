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
constexpr long long kMapCacheFallbackMs = 5000;
constexpr long long kDeletedMapSuppressionMs = 15000;

long long steady_clock_millis() {
    return std::chrono::duration_cast<std::chrono::milliseconds>(
        std::chrono::steady_clock::now().time_since_epoch()).count();
}

bool charging_detected_from_robot_status(bool charging, const RobotStatus& status) {
    if (charging) {
        return true;
    }

    switch (status.charge_status_code) {
        case 45:
        case 46:
        case 47:
        case 48:
            return true;
        default:
            return false;
    }
}

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

void assign_default_map_ids(const std::vector<MapDescriptor>& maps, PointRecord* point) {
    if (point == nullptr || (point->floor_id > 0 && point->map_id > 0) || maps.empty()) {
        return;
    }

    for (const auto& map : maps) {
        if (map.is_default_floor && map.is_default_map) {
            point->floor_id = map.floor_id;
            point->map_id = map.map_id;
            return;
        }
    }

    for (const auto& map : maps) {
        if (map.is_default_floor) {
            point->floor_id = map.floor_id;
            point->map_id = map.map_id;
            return;
        }
    }

    point->floor_id = maps.front().floor_id;
    point->map_id = maps.front().map_id;
}

void prune_placeholder_points(PointRepository* repository, const std::vector<PointRecord>& native_points) {
    if (repository == nullptr) {
        return;
    }

    bool native_has_charge = false;
    bool native_has_initial = false;
    for (const auto& point : native_points) {
        if (point.type == "charge" && point.point_id > 0) {
            native_has_charge = true;
        } else if (point.type == "initial" && point.point_id > 0) {
            native_has_initial = true;
        }
    }

    if (!native_has_charge && !native_has_initial) {
        return;
    }

    const auto local_points = repository->list_points();
    for (const auto& point : local_points) {
        if (point.id <= 0 || point.point_id > 0) {
            continue;
        }

        if ((native_has_charge && point.type == "charge") ||
            (native_has_initial && point.type == "initial")) {
            (void) repository->delete_point(point.id);
        }
    }
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

bool MapService::save_map(const std::string& map_name) {
    const bool ok = adapter_.save_map(map_name);
    if (!ok) {
        return false;
    }

    if (point_repository_ != nullptr) {
        bool should_backfill = false;
        {
            std::lock_guard<std::mutex> lock(state_mutex_);
            should_backfill = mapping_active_ && !mapping_seed_done_;
        }

        if (should_backfill) {
            const auto status = adapter_.get_robot_status();
            if (charging_detected_from_robot_status(adapter_.is_charging(), status)) {
                (void) try_seed_mapping_points_once();
            }
        }
    }

    std::lock_guard<std::mutex> lock(state_mutex_);
    mapping_active_ = false;
    mapping_seed_done_ = true;
    mapping_seed_inflight_.store(false);
    return true;
}

bool MapService::load_map(long floor_id, long map_id) const {
    if (floor_id <= 0 || map_id <= 0) {
        return false;
    }
    return adapter_.load_map(std::to_string(floor_id) + ":" + std::to_string(map_id));
}

std::vector<MapDescriptor> MapService::list_maps() const {
    std::vector<MapDescriptor> maps;
    const bool ok = adapter_.list_maps(&maps);
    const auto now_ms = steady_clock_millis();

    std::lock_guard<std::mutex> lock(state_mutex_);
    prune_suppressed_maps(now_ms);

    auto filter_maps = [this](const std::vector<MapDescriptor>& input) {
        std::vector<MapDescriptor> filtered;
        filtered.reserve(input.size());
        for (const auto& map : input) {
            if (!map_suppressed(map.floor_id, map.map_id)) {
                filtered.push_back(map);
            }
        }
        return filtered;
    };

    if (!ok) {
        return cached_maps_;
    }

    const auto filtered_maps = filter_maps(maps);
    if (filtered_maps.empty() && maps.empty() && !cached_maps_.empty() &&
        (now_ms - last_maps_success_ms_) <= kMapCacheFallbackMs) {
        return cached_maps_;
    }

    cached_maps_ = filtered_maps;
    last_maps_success_ms_ = now_ms;
    return cached_maps_;
}

bool MapService::delete_map(long floor_id, long map_id) const {
    if (!adapter_.delete_map(floor_id, map_id)) {
        return false;
    }

    std::lock_guard<std::mutex> lock(state_mutex_);
    suppressed_maps_.push_back(SuppressedMapIdentity{
        floor_id,
        map_id,
        steady_clock_millis() + kDeletedMapSuppressionMs,
    });
    cached_maps_.erase(
        std::remove_if(
            cached_maps_.begin(),
            cached_maps_.end(),
            [floor_id, map_id](const MapDescriptor& map) {
                return map.floor_id == floor_id && map.map_id == map_id;
            }),
        cached_maps_.end());
    if (point_repository_ != nullptr) {
        (void) point_repository_->delete_points_by_map(floor_id, map_id);
    }
    return true;
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

    std::vector<MapDescriptor> maps;
    (void) adapter_.list_maps(&maps);

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
        assign_default_map_ids(maps, &created_charge);
        created_charge.id = point_repository_->upsert_point(created_charge);
        charge_point = created_charge;
    }

    native_points.clear();
    if (adapter_.list_native_points(&native_points)) {
        point_repository_->merge_native_points(native_points);
        prune_placeholder_points(point_repository_, native_points);
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
    assign_default_map_ids(maps, &initial_point);
    initial_point.point_id = 0;
    point_repository_->insert_point(initial_point);
    return true;
}

void MapService::prune_suppressed_maps(long long now_ms) const {
    suppressed_maps_.erase(
        std::remove_if(
            suppressed_maps_.begin(),
            suppressed_maps_.end(),
            [now_ms](const SuppressedMapIdentity& item) { return item.expires_ms < now_ms; }),
        suppressed_maps_.end());
}

bool MapService::map_suppressed(long floor_id, long map_id) const {
    const auto now_ms = steady_clock_millis();
    for (const auto& item : suppressed_maps_) {
        if (item.expires_ms < now_ms) {
            continue;
        }
        if (item.floor_id == floor_id && item.map_id == map_id) {
            return true;
        }
    }
    return false;
}
