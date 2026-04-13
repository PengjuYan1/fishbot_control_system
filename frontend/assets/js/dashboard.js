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
  const actionFeedbackNode = document.getElementById('action-feedback');
  let moveTimer = null;
  let activeDrivePointerId = null;

  const setActionFeedback = (message, level) => {
    if (!actionFeedbackNode) {
      return;
    }
    actionFeedbackNode.textContent = message;
    actionFeedbackNode.className = `action-feedback${level ? ` ${level}` : ''}`;
  };

  const formatError = (error) => {
    if (!error || !error.message) {
      return '未知错误';
    }
    if (error.message.startsWith('{')) {
      try {
        const payload = JSON.parse(error.message);
        return payload.error || error.message;
      } catch (parseError) {
      }
    }
    return error.message;
  };

  const stopDriving = async () => {
    if (moveTimer) {
      window.clearInterval(moveTimer);
      moveTimer = null;
    }
    activeDrivePointerId = null;
    try {
      await window.fishbotApi.stopManualMove();
      setActionFeedback('机器人已发送停止指令。', 'success');
    } catch (error) {
      setActionFeedback(`停止失败：${formatError(error)}`, 'error');
      throw error;
    }
  };

  const startDriving = async (linear, angular, pointerId) => {
    if (moveTimer) {
      window.clearInterval(moveTimer);
      moveTimer = null;
    }
    activeDrivePointerId = pointerId;
    await window.fishbotApi.manualMove(linear, angular);
    setActionFeedback(`已发送移动指令：线速度 ${linear.toFixed(2)}，角速度 ${angular.toFixed(2)}。`, 'success');
    moveTimer = window.setInterval(() => {
      window.fishbotApi.manualMove(linear, angular).catch(async (error) => {
        window.clearInterval(moveTimer);
        moveTimer = null;
        activeDrivePointerId = null;
        setActionFeedback(`移动失败：${formatError(error)}`, 'error');
        try {
          await window.fishbotApi.stopManualMove();
        } catch (stopError) {
        }
      });
    }, 150);
  };

  if (startMappingButton) {
    startMappingButton.addEventListener('click', async () => {
      try {
        await window.fishbotApi.startMapping();
        setActionFeedback('已发送开始建图指令。', 'success');
      } catch (error) {
        setActionFeedback(`开始建图失败：${formatError(error)}`, 'error');
      }
    });
  }

  if (saveMapButton) {
    saveMapButton.addEventListener('click', async () => {
      const name = window.prompt ? window.prompt('请输入地图名称', 'web_map') : 'web_map';
      if (!name) {
        return;
      }
      try {
        await window.fishbotApi.saveMap(name);
        setActionFeedback(`地图 ${name} 已发送保存请求。`, 'success');
      } catch (error) {
        setActionFeedback(`保存地图失败：${formatError(error)}`, 'error');
      }
    });
  }

  if (startTaskButton) {
    startTaskButton.addEventListener('click', async () => {
      try {
        const result = await window.fishbotApi.startTask();
        const nextSnapshot = { ...window.fishbotStore.getState().system, task: {
          status: result.status || 'running',
          current_target: result.current_target_name || '',
        } };
        window.fishbotStore.setSystemSnapshot(nextSnapshot);
        setActionFeedback('任务已启动。', 'success');
      } catch (error) {
        setActionFeedback(`启动任务失败：${formatError(error)}`, 'error');
      }
    });
  }

  if (goChargeButton) {
    goChargeButton.addEventListener('click', async () => {
      try {
        const result = await window.fishbotApi.goCharge();
        const nextSnapshot = { ...window.fishbotStore.getState().system, charging: true, task: {
          status: result.status || 'charging',
          current_target: result.current_target_name || '',
        } };
        window.fishbotStore.setSystemSnapshot(nextSnapshot);
        setActionFeedback('已发送回充指令。', 'success');
      } catch (error) {
        setActionFeedback(`回充失败：${formatError(error)}`, 'error');
      }
    });
  }

  if (outOfChargeButton) {
    outOfChargeButton.addEventListener('click', async () => {
      try {
        await window.fishbotApi.outOfCharge();
        setActionFeedback('已发送脱离充电 / 解锁指令。', 'success');
      } catch (error) {
        setActionFeedback(`脱离充电失败：${formatError(error)}`, 'error');
      }
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
      try {
        await startDriving(linear, angular, event.pointerId);
      } catch (error) {
        setActionFeedback(`移动失败：${formatError(error)}`, 'error');
      }
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

  try {
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
  } catch (error) {
  }
});
