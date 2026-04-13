window.fishbotWs = {
  connect() {
    return {
      onmessage: null,
      simulate(message) {
        if (typeof this.onmessage === 'function') {
          this.onmessage({ data: JSON.stringify(message) });
        }
      },
    };
  },
};
