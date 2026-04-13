window.fishbotApi = {
  async getSystemStatus() {
    return {
      battery: 78,
      pose: { x: 1.0, y: 2.0, theta: 0.5 },
      task: { status: 'idle', current_target: '' },
    };
  },
};
