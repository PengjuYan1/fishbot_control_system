const mockState = {
  points: [
    { id: 1, name: 'C1', type: 'charge', x: 1.2, y: 2.8, theta: 0.0, floor_id: 1, map_id: 11, point_id: 101 },
    { id: 2, name: 'F1', type: 'feed', x: 6.5, y: 9.1, theta: 1.57, floor_id: 1, map_id: 11, point_id: 201 },
  ],
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
        task: { status: 'idle', current_target: '' },
        connection: { healthy: true, last_error: '', reconnect_attempts: 0, adapter_mode: 'rosbridge' },
      };
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
};
