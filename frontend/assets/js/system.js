document.addEventListener('DOMContentLoaded', async () => {
  if (!window.fishbotApi) {
    return;
  }

  const status = await (window.fishbotApi.getSystemStatus ? window.fishbotApi.getSystemStatus() : null);
  const alerts = await (window.fishbotApi.getAlerts ? window.fishbotApi.getAlerts() : []);

  if (status && status.connection) {
    const healthNode = document.getElementById('connection-health');
    const modeNode = document.getElementById('connection-mode');
    const errorNode = document.getElementById('connection-error');
    const retriesNode = document.getElementById('connection-retries');

    if (healthNode) {
      healthNode.textContent = status.connection.healthy ? '正常' : '异常';
    }
    if (modeNode) {
      modeNode.textContent = status.connection.adapter_mode || '--';
    }
    if (errorNode) {
      errorNode.textContent = status.connection.last_error || '--';
    }
    if (retriesNode) {
      retriesNode.textContent = String(status.connection.reconnect_attempts || 0);
    }
  }

  const alertList = document.getElementById('alert-list');
  if (alertList) {
    alertList.innerHTML = alerts.map((alert) => (
      `<div class="metric-card"><span>${alert.level}</span><strong>${alert.category}</strong><small>${alert.message}</small></div>`
    )).join('');
  }
});
