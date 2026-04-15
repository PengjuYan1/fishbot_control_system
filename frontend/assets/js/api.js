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
    return requestJson('/api/map/save', { method: 'POST', body: name || 'web_map' });
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
    return requestJson('/api/maps/delete', {
      method: 'POST',
      headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
      body,
    });
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
    return requestJson('/api/points/charge/current', { method: 'POST', body: '' });
  },
  async createCurrentNavPoint() {
    return requestJson('/api/points/nav/current', { method: 'POST', body: '' });
  },
  async createCurrentFeedPoint() {
    return requestJson('/api/points/feed/current', { method: 'POST', body: '' });
  },
  async deletePoint(id) {
    const body = new URLSearchParams({ id: String(id) }).toString();
    return requestJson('/api/points/delete', {
      method: 'POST',
      headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
      body,
    });
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
