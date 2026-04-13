function updateDashboardStatus() {
  if (!window.fishbotStore) {
    return;
  }

  const state = window.fishbotStore.getState();
  const batteryNode = document.getElementById('battery-value');
  const localizationNode = document.getElementById('localization-value');
  const navigationNode = document.getElementById('navigation-value');
  const chargingNode = document.getElementById('charging-value');
  const taskStatusNode = document.getElementById('task-status-text');
  const taskTargetNode = document.getElementById('task-target');
  const modeNode = document.getElementById('runtime-mode');

  if (batteryNode) {
    batteryNode.textContent = `${state.system.battery}%`;
  }

  if (localizationNode) {
    localizationNode.textContent = state.system.localized ? '正常' : '未定位';
  }

  if (navigationNode) {
    navigationNode.textContent = state.system.task.status === 'idle' ? '待命' : state.system.task.status;
  }

  if (chargingNode) {
    chargingNode.textContent = state.system.charging ? '是' : '否';
  }

  if (taskStatusNode) {
    taskStatusNode.textContent = state.system.task.status === 'idle'
      ? '等待手动启动或定时计划'
      : state.system.task.status;
  }

  if (taskTargetNode) {
    taskTargetNode.textContent = state.system.task.current_target || '--';
  }

  if (modeNode) {
    modeNode.textContent = state.system.connection.adapter_mode || '离线';
  }
}

function bindRealtimeStatusSocket() {
  if (!window.fishbotWs || !window.fishbotStore) {
    return;
  }

  const socket = window.fishbotWs.connect('/ws/status');
  if (!socket) {
    return;
  }

  socket.onmessage = (event) => {
    try {
      const message = JSON.parse(event.data);
      if (!message || !message.type) {
        return;
      }

      if (message.type === 'system_snapshot') {
        window.fishbotStore.setSystemSnapshot(message.payload || {});
      } else if (message.type === 'robot_pose') {
        window.fishbotStore.setRobotPose(message.payload || {});
      } else if (message.type === 'map_snapshot') {
        window.fishbotStore.setMapSnapshot(message.payload || {});
      }
    } catch (error) {
    }
  };
}

document.addEventListener('DOMContentLoaded', async () => {
  if (!window.fishbotApi || !window.fishbotStore) {
    return;
  }

  const [status, points, map] = await Promise.all([
    window.fishbotApi.getSystemStatus(),
    window.fishbotApi.getPoints(),
    window.fishbotApi.getMapSnapshot ? window.fishbotApi.getMapSnapshot() : Promise.resolve(null),
  ]);

  window.fishbotStore.setSystemSnapshot(status || {});
  window.fishbotStore.setPoints(points || []);
  if (map) {
    window.fishbotStore.setMapSnapshot(map);
  }

  window.fishbotStore.subscribe(() => {
    updateDashboardStatus();
    if (typeof window.renderMapOverlay === 'function') {
      window.renderMapOverlay();
    }
  });
  updateDashboardStatus();
  if (typeof window.renderMapOverlay === 'function') {
    window.renderMapOverlay();
  }

  bindRealtimeStatusSocket();
});
