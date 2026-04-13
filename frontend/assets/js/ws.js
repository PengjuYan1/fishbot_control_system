window.fishbotWs = {
  connect(path = '/ws/status') {
    if (typeof window.WebSocket === 'function') {
      try {
        const protocol = window.location.protocol === 'https:' ? 'wss:' : 'ws:';
        return new window.WebSocket(`${protocol}//${window.location.host}${path}`);
      } catch (error) {
      }
    }

    return {
      onmessage: null,
      close() {},
      simulate(message) {
        if (typeof this.onmessage === 'function') {
          this.onmessage({ data: JSON.stringify(message) });
        }
      },
    };
  },
};
