const apiCache = {
  systemStatus: null,
  mapSnapshot: null,
  maps: [],
  points: [],
};

async function requestJson(path, options) {
  if (!window.fetch) {
    throw new Error('fetch_unavailable');
  }

  const response = await window.fetch(path, options);
  const body = await response.text();
  if (!response.ok) {
    throw new Error(body || `http_${response.status}`);
  }
  return body ? JSON.parse(body) : {};
}

window.fishbotApi = {
  async getSystemStatus() {
    try {
      const payload = await requestJson('/api/system/status');
      apiCache.systemStatus = payload;
      return payload;
    } catch (error) {
      return apiCache.systemStatus || {
        battery: 78,
        pose: { x: 1.0, y: 2.0, theta: 0.5 },
        charging: false,
        connected: true,
        localized: true,
        task: { status: 'idle', current_target: '' },
        connection: { healthy: true, last_error: '', reconnect_attempts: 0, adapter_mode: 'rosbridge' },
        manual_control: {
          phase: 'idle',
          desired_linear: 0,
          desired_angular: 0,
          session_active: false,
          pending_motion: false,
        },
      };
    }
  },
  async getMapSnapshot() {
    try {
      const payload = await requestJson('/api/map/snapshot');
      apiCache.mapSnapshot = payload;
      return payload;
    } catch (error) {
      return apiCache.mapSnapshot || {
        width: 0,
        height: 0,
        resolution: 0,
        origin_x: 0,
        origin_y: 0,
        occupancy_data: [],
      };
    }
  },
  async startMapping() {
    return requestJson('/api/map/start-mapping', { method: 'POST', body: '' });
  },
  async saveMap(name) {
    const response = await requestJson('/api/map/save', { method: 'POST', body: name || 'web_map' });
    return response;
  },
  async loadMap(floorId, mapId) {
    const body = new URLSearchParams({
      floor_id: String(floorId),
      map_id: String(mapId),
    }).toString();
    return requestJson('/api/map/load', {
      method: 'POST',
      headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
      body,
    });
  },
  async getMaps() {
    try {
      const payload = await requestJson('/api/maps');
      apiCache.maps = Array.isArray(payload.maps) ? payload.maps : [];
      return apiCache.maps.slice();
    } catch (error) {
      return apiCache.maps.slice();
    }
  },
  async deleteMap(floorId, mapId) {
    const body = new URLSearchParams({
      floor_id: String(floorId),
      map_id: String(mapId),
    }).toString();
    const response = await requestJson('/api/maps/delete', {
      method: 'POST',
      headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
      body,
    });
    apiCache.maps = apiCache.maps.filter((map) =>
      !(Number(map.floor_id) === Number(floorId) && Number(map.map_id) === Number(mapId)));
    apiCache.points = apiCache.points.filter((point) =>
      !(Number(point.floor_id) === Number(floorId) && Number(point.map_id) === Number(mapId)));
    return response;
  },
  async getPoints() {
    try {
      const payload = await requestJson('/api/points');
      apiCache.points = Array.isArray(payload) ? payload : [];
      return apiCache.points.slice();
    } catch (error) {
      return apiCache.points.slice();
    }
  },
  async createPoint(type, payload) {
    const body = new URLSearchParams(payload).toString();
    return requestJson(`/api/points/${type}`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
      body,
    });
  },
  async createCurrentChargePoint() {
    const point = await requestJson('/api/points/charge/current', { method: 'POST', body: '' });
    apiCache.points = apiCache.points
      .filter((item) => !(item.type === 'charge' && Number(item.id) === Number(point.id)))
      .concat([point]);
    return point;
  },
  async createCurrentNavPoint() {
    const point = await requestJson('/api/points/nav/current', { method: 'POST', body: '' });
    apiCache.points = apiCache.points.concat([point]);
    return point;
  },
  async createCurrentFeedPoint() {
    const point = await requestJson('/api/points/feed/current', { method: 'POST', body: '' });
    apiCache.points = apiCache.points.concat([point]);
    return point;
  },
  async deletePoint(id) {
    const body = new URLSearchParams({ id: String(id) }).toString();
    const point = await requestJson('/api/points/delete', {
      method: 'POST',
      headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
      body,
    });
    apiCache.points = apiCache.points.filter((item) => Number(item.id) !== Number(id));
    return point;
  },
  async getSchedules() {
    return [
      { id: 1, name: 'Morning Feed', cron: '0 8 * * *', enabled: true },
    ];
  },
  async getAlerts() {
    return [
      { id: 1, level: 'warning', category: 'battery_low', message: 'Battery below return threshold' },
    ];
  },
  async createSchedule() {
    return { id: 1 };
  },
  async startTask() {
    return requestJson('/api/tasks/start', { method: 'POST', body: '' });
  },
  async navigateToPoint(id) {
    const body = new URLSearchParams({ id: String(id) }).toString();
    return requestJson('/api/tasks/navigate-point', {
      method: 'POST',
      headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
      body,
    });
  },
  async startSelfCharge() {
    return requestJson('/api/tasks/self-charge', { method: 'POST', body: '' });
  },
  async goCharge() {
    return requestJson('/api/tasks/go-charge', { method: 'POST', body: '' });
  },
  async outOfCharge() {
    return requestJson('/api/control/out-of-charge', { method: 'POST', body: '' });
  },
  async undockFromChargePile() {
    return requestJson('/api/control/undock', { method: 'POST', body: '' });
  },
  async exitNavigationMode() {
    return requestJson('/api/control/exit-navigation-mode', { method: 'POST', body: '' });
  },
  async manualMove(linear, angular) {
    const body = new URLSearchParams({
      linear: String(linear),
      angular: String(angular),
    }).toString();
    return requestJson('/api/control/move', {
      method: 'POST',
      headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
      body,
    });
  },
  async stopManualMove() {
    return requestJson('/api/control/stop', { method: 'POST', body: '' });
  },
};
