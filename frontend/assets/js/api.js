window.fishbotApi = {
  async getSystemStatus() {
    return {
      battery: 78,
      pose: { x: 1.0, y: 2.0, theta: 0.5 },
      task: { status: 'idle', current_target: '' },
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
  async createSchedule() {
    return { id: 1 };
  },
};
