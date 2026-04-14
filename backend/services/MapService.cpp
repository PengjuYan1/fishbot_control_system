#include "backend/services/MapService.h"

#include <stdexcept>

namespace {
bool has_point_kind(const std::vector<PointRecord>& points, const std::string& point_kind) {
    for (const auto& point : points) {
        if (point.point_kind == point_kind) {
            return true;
        }
    }
    return false;
}
}  // namespace

MapService::MapService(IRobotAdapter& adapter, PointRepository& point_repository)
    : adapter_(adapter), point_repository_(point_repository) {}

bool MapService::start_mapping() {
    if (!adapter_.start_mapping()) {
        return false;
    }
    mapping_active_ = true;
    return true;
}

bool MapService::stop_mapping() {
    return adapter_.stop_mapping();
}

bool MapService::save_map(const std::string& map_name) {
    const auto workflow = build_workflow_status();
    if (!workflow.can_save_map) {
        throw std::runtime_error("map_requires_charge_and_initial_points");
    }
    if (!adapter_.save_map(map_name)) {
        return false;
    }
    mapping_active_ = false;
    return true;
}

MapSnapshot MapService::get_snapshot() const {
    return adapter_.get_map_snapshot();
}

MapWorkflowStatus MapService::get_workflow_status() const {
    return build_workflow_status();
}

MapWorkflowStatus MapService::build_workflow_status() const {
    const auto points = point_repository_.list_points();
    MapWorkflowStatus status;
    status.mapping_active = mapping_active_;
    status.has_charge_point = has_point_kind(points, "charge");
    status.has_initial_point = has_point_kind(points, "initial");
    status.can_save_map = status.has_charge_point && status.has_initial_point;

    if (!status.mapping_active) {
        status.next_step = "未处于新建地图流程。开始建图后，先在充电桩前约0.5米处面向充电桩旋转一圈，再上桩并确认已建立充电点和初始点。";
        return status;
    }

    if (!status.has_charge_point && !status.has_initial_point) {
        status.next_step = "建图初始化未完成：请按手册先在充电桩前约0.5米处面向充电桩旋转一圈，再上桩；若底层未自动建点，请手动补建充电点和初始点。";
        return status;
    }

    if (!status.has_charge_point) {
        status.next_step = "已缺少充电点。请将机器人放到充电桩前标准姿态，确认面向充电桩后创建充电点。";
        return status;
    }

    if (!status.has_initial_point) {
        status.next_step = "已缺少初始点。请在完成建图初始化后创建初始点，否则地图不能保存。";
        return status;
    }

    status.next_step = "建图初始化已完成，可以保存地图；投喂点可按导航点继续补建。";
    return status;
}
