const mockState = {
  points: [
    { id: 1, name: 'C1', type: 'charge', x: 1.2, y: 2.8, theta: 0.0, floor_id: 1, map_id: 11, point_id: 101 },
    { id: 2, name: 'F1', type: 'feed', x: 6.5, y: 9.1, theta: 1.57, floor_id: 1, map_id: 11, point_id: 201 },
  ],
  map: {
    width: 12,
    height: 10,
    resolution: 0.5,
    origin_x: 0,
    origin_y: 0,
    occupancy_data: [
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 100, 100, 100, 0, 0, 0, 0, 50, 50, 0, 0,
      0, 0, 0, 100, 0, 0, 0, 0, 50, 50, 0, 0,
      0, 0, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
    ],
  },
};

async function requestJson(path, options) {
  if (!window.fetch) {
    throw new Error('fetch_unavailable');
  }

  const response = await window.fetch(path, options);
  if (!response.ok) {
    throw new Error(`http_${response.status}`);
  }
  return response.json();
}

window.fishbotApi = {
  async getSystemStatus() {
    try {
      return await requestJson('/api/system/status');
    } catch (error) {
      return {
        battery: 78,
        pose: { x: 1.0, y: 2.0, theta: 0.5 },
        charging: false,
        connected: true,
        localized: true,
        task: { status: 'idle', current_target: '' },
        connection: { healthy: true, last_error: '', reconnect_attempts: 0, adapter_mode: 'rosbridge' },
      };
    }
  },
  async getMapSnapshot() {
    try {
      return await requestJson('/api/map/snapshot');
    } catch (error) {
      return { ...mockState.map };
    }
  },
  async startMapping() {
    try {
      return await requestJson('/api/map/start-mapping', { method: 'POST', body: '' });
    } catch (error) {
      return { status: 'started' };
    }
  },
  async saveMap(name) {
    try {
      return await requestJson('/api/map/save', { method: 'POST', body: name || 'web_map' });
    } catch (error) {
      return { status: 'saved' };
    }
  },
  async getPoints() {
    try {
      return await requestJson('/api/points');
    } catch (error) {
      return mockState.points.slice();
    }
  },
  async createPoint(type, payload) {
    const body = new URLSearchParams(payload).toString();
    try {
      const response = await requestJson(`/api/points/${type}`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body,
      });
      return response;
    } catch (error) {
      const id = mockState.points.length + 1;
      mockState.points.push({
        id,
        name: payload.name,
        type,
        x: Number(payload.x),
        y: Number(payload.y),
        theta: Number(payload.theta),
        floor_id: Number(payload.floor_id || 0),
        map_id: Number(payload.map_id || 0),
        point_id: Number(payload.point_id || 0),
      });
      return { id, type };
    }
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
    try {
      return await requestJson('/api/tasks/start', { method: 'POST', body: '' });
    } catch (error) {
      return { status: 'running', current_target_name: 'F1' };
    }
  },
  async goCharge() {
    try {
      return await requestJson('/api/tasks/go-charge', { method: 'POST', body: '' });
    } catch (error) {
      return { status: 'charging', current_target_name: 'C1' };
    }
  },
  async outOfCharge() {
    try {
      return await requestJson('/api/control/out-of-charge', { method: 'POST', body: '' });
    } catch (error) {
      return { status: 'out_of_charge_requested' };
    }
  },
  async manualMove(linear, angular) {
    const body = new URLSearchParams({
      linear: String(linear),
      angular: String(angular),
    }).toString();
    try {
      return await requestJson('/api/control/move', {
        method: 'POST',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body,
      });
    } catch (error) {
      return { status: 'moving', linear, angular };
    }
  },
  async stopManualMove() {
    try {
      return await requestJson('/api/control/stop', { method: 'POST', body: '' });
    } catch (error) {
      return { status: 'stopped' };
    }
  },
};
