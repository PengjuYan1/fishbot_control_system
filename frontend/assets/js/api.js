window.fishbotApi = {
  async getSystemStatus() {
    return {
      battery: 78,
      pose: { x: 1.0, y: 2.0, theta: 0.5 },
      task: { status: 'idle', current_target: '' },
      connection: { healthy: true, last_error: '', reconnect_attempts: 0, adapter_mode: 'rosbridge' },
    };
  },
  async getPoints() {
    return [
      { id: 1, name: 'C1', type: 'charge' },
      { id: 2, name: 'F1', type: 'feed' },
    ];
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
