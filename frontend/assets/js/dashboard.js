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

function bindControlButtons() {
  const startMappingButton = document.getElementById('start-mapping-button');
  const saveMapButton = document.getElementById('save-map-button');
  const startTaskButton = document.getElementById('start-task-button');
  const goChargeButton = document.getElementById('go-charge-button');
  const outOfChargeButton = document.getElementById('out-of-charge-button');
  const manualStopButton = document.getElementById('manual-stop-button');
  const driveStopCenterButton = document.getElementById('drive-stop-center');
  const driveButtons = Array.from(document.querySelectorAll('.drive-button[data-linear]'));
  const mapEditorButton = document.getElementById('goto-map-editor-button');
  const feedEditorButton = document.getElementById('goto-map-editor-feed-button');
  let moveTimer = null;
  let activeDrivePointerId = null;

  const stopDriving = async () => {
    if (moveTimer) {
      window.clearInterval(moveTimer);
      moveTimer = null;
    }
    activeDrivePointerId = null;
    await window.fishbotApi.stopManualMove();
  };

  const startDriving = async (linear, angular, pointerId) => {
    await stopDriving();
    activeDrivePointerId = pointerId;
    await window.fishbotApi.manualMove(linear, angular);
    moveTimer = window.setInterval(() => {
      window.fishbotApi.manualMove(linear, angular);
    }, 150);
  };

  if (startMappingButton) {
    startMappingButton.addEventListener('click', async () => {
      await window.fishbotApi.startMapping();
    });
  }

  if (saveMapButton) {
    saveMapButton.addEventListener('click', async () => {
      const name = window.prompt ? window.prompt('请输入地图名称', 'web_map') : 'web_map';
      if (!name) {
        return;
      }
      await window.fishbotApi.saveMap(name);
    });
  }

  if (startTaskButton) {
    startTaskButton.addEventListener('click', async () => {
      const result = await window.fishbotApi.startTask();
      const nextSnapshot = { ...window.fishbotStore.getState().system, task: {
        status: result.status || 'running',
        current_target: result.current_target_name || '',
      } };
      window.fishbotStore.setSystemSnapshot(nextSnapshot);
    });
  }

  if (goChargeButton) {
    goChargeButton.addEventListener('click', async () => {
      const result = await window.fishbotApi.goCharge();
      const nextSnapshot = { ...window.fishbotStore.getState().system, charging: true, task: {
        status: result.status || 'charging',
        current_target: result.current_target_name || '',
      } };
      window.fishbotStore.setSystemSnapshot(nextSnapshot);
    });
  }

  if (outOfChargeButton) {
    outOfChargeButton.addEventListener('click', async () => {
      await window.fishbotApi.outOfCharge();
    });
  }

  if (manualStopButton) {
    manualStopButton.addEventListener('click', stopDriving);
  }

  if (driveStopCenterButton) {
    driveStopCenterButton.addEventListener('click', stopDriving);
  }

  driveButtons.forEach((button) => {
    const linear = Number(button.dataset.linear || 0);
    const angular = Number(button.dataset.angular || 0);
    button.addEventListener('pointerdown', async (event) => {
      event.preventDefault();
      if (button.setPointerCapture && event.pointerId !== undefined) {
        button.setPointerCapture(event.pointerId);
      }
      await startDriving(linear, angular, event.pointerId);
    });
    button.addEventListener('pointerup', async (event) => {
      if (activeDrivePointerId === null || activeDrivePointerId === event.pointerId) {
        await stopDriving();
      }
    });
    button.addEventListener('pointerleave', async (event) => {
      if (activeDrivePointerId === null || activeDrivePointerId === event.pointerId) {
        await stopDriving();
      }
    });
    button.addEventListener('pointercancel', async (event) => {
      if (activeDrivePointerId === null || activeDrivePointerId === event.pointerId) {
        await stopDriving();
      }
    });
  });

  window.addEventListener('pointerup', async (event) => {
    if (moveTimer && (activeDrivePointerId === null || activeDrivePointerId === event.pointerId)) {
      await stopDriving();
    }
  });

  window.addEventListener('blur', () => {
    if (moveTimer) {
      stopDriving();
    }
  });

  document.addEventListener('visibilitychange', () => {
    if (document.hidden && moveTimer) {
      stopDriving();
    }
  });

  if (mapEditorButton) {
    mapEditorButton.addEventListener('click', () => {
      window.location.href = 'map.html';
    });
  }

  if (feedEditorButton) {
    feedEditorButton.addEventListener('click', () => {
      window.location.href = 'map.html';
    });
  }
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

  bindControlButtons();
  bindRealtimeStatusSocket();
});
