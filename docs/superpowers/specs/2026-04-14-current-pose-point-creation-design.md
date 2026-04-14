# 当前位姿一键建点设计

## 背景

当前首页的“设充电点 / 新增投喂点”会跳转到 `frontend/map.html`，要求用户手工拾取坐标并录入 `floor_id / map_id / point_id`。这个流程不适合现场作业，也和实际需求不符。

用户需要的是：

- 点击首页按钮后，直接按机器人当前位姿创建正式点位
- 创建结果要能直接用于后续自动导航任务
- 不再默认进入“地图与点位管理”手工录入页

## 约束

- 当前自动导航链路最终依赖机器人原生点位：
  - `TaskService::navigate_to_point()` 会把 `floor_id / map_id / point_id` 传给适配器
  - `RosbridgeAdapter::navigate_to_pose()` 当前通过 `navi_targegoalplan` 调用原生导航点服务
- 因此不能只把 `x / y / theta` 记到本地数据库，否则会出现“界面有点、任务不可导航”的假成功
- APK 反编译确认可用原生接口：
  - `pointmanu_set`
  - `list_navi_points`
  - `get_maps`

## 方案

### 首页行为

- “设充电点”按钮：
  - 不再跳转 `map.html`
  - 读取当前机器人位姿
  - 自动生成名称 `C1 / C2 / ...`
  - 调用原生建点接口创建正式点位
  - 成功后把完整点位信息写入本地数据库
  - 刷新首页点位覆盖层

- “新增投喂点”按钮：
  - 同样不再跳转 `map.html`
  - 读取当前机器人位姿
  - 自动生成名称 `F1 / F2 / ...`
  - 调用原生建点接口创建正式点位
  - 成功后写入本地数据库并刷新首页

### 原生建点链路

新增适配器能力：

- 从当前机器人 pose 取 `x / y / theta`
- 通过 `pointmanu_set` 创建原生点位，拿到 `point_id`
- 通过 `get_maps` 获取当前默认 `floor_id / map_id`
- 如有必要再通过 `list_navi_points` 校验该点位确实已存在，并补齐名称/坐标

最终得到完整记录：

- `name`
- `type`
- `x`
- `y`
- `theta`
- `floor_id`
- `map_id`
- `point_id`

### 失败策略

- 任一原生步骤失败：
  - 前端提示失败
  - 不写本地数据库
- 保持“本地数据库只保存可导航正式点位”

## 接口变更

新增后端接口：

- `POST /api/points/charge/current`
- `POST /api/points/feed/current`

请求体可为空，名称由后端自动生成。

响应返回：

- 本地点位 `id`
- `name`
- `type`
- `floor_id`
- `map_id`
- `point_id`

## 兼容性

- `frontend/map.html` 保留为高级/维护工具页，但不再作为首页主流程入口
- 现有 `POST /api/points/charge` 和 `POST /api/points/feed` 继续保留，避免影响已有调试流程

## 测试

- 后端：
  - 当前位姿建充电点成功时会同时保存原生 ids
  - 当前位姿建投喂点成功时会同时保存原生 ids
  - 原生建点失败时不落库
  - 自动名称递增正确

- 前端：
  - 首页按钮不再跳转 `map.html`
  - 点击后直接调用新接口
  - 成功后刷新首页点位列表/地图覆盖层
