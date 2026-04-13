document.addEventListener('DOMContentLoaded', async () => {
  const batteryNode = document.getElementById('battery-value');
  const taskStatusNode = document.getElementById('task-status-text');
  const taskTargetNode = document.getElementById('task-target');

  if (!window.fishbotApi || !window.fishbotStore) {
    return;
  }

  const status = await window.fishbotApi.getSystemStatus();
  window.fishbotStore.setRobotPose(status.pose);
  window.fishbotStore.setPoints([
    { name: 'C1', type: 'charge', x: 72, y: 62 },
    { name: 'F1', type: 'feed', x: 60, y: 26 },
    { name: 'F2', type: 'feed', x: 42, y: 48 },
  ]);

  if (typeof window.renderMapOverlay === 'function') {
    window.fishbotStore.subscribe(window.renderMapOverlay);
    window.renderMapOverlay();
  }

  if (batteryNode) {
    batteryNode.textContent = `${status.battery}%`;
  }

  if (taskStatusNode) {
    taskStatusNode.textContent = status.task.status === 'idle'
      ? '等待手动启动或定时计划'
      : status.task.status;
  }

  if (taskTargetNode) {
    taskTargetNode.textContent = status.task.current_target || '--';
  }
});
