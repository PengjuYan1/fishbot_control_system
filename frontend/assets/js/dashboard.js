function formatEmergencyStatus(control) {
  const code = Number(control.emergency_status_code || 0);
  if (code === 31) {
    return '急停触发 / 安全回路未复位 (31)';
  }
  if (code === 32) {
    return '急停已解除 (32)';
  }
  return control.emergency_stopped ? `急停中 (${code})` : `已解除 (${code})`;
}

function formatMotorStatus(control) {
  const code = Number(control.motor_status_code || 0);
  if (code === 33) {
    return '电机未使能 / 可手推不可驱动 (33)';
  }
  if (code === 34) {
    return '电机已使能 / 可受控驱动 (34)';
  }
  return control.motor_locked ? `未使能 (${code})` : `已使能 (${code})`;
}

function formatStm32Status(control) {
  const code = Number(control.stm32_status_code || 0);
  if (code === 17) {
    return 'STM32 通讯异常 (17)';
  }
  if (code === 18) {
    return 'STM32 通讯正常 (18)';
  }
  return String(code);
}

function formatOdomStatus(control) {
  const code = Number(control.odom_status_code || 0);
  if (code === 19) {
    return '里程计 / 驱动反馈异常 (19)';
  }
  if (code === 20) {
    return '里程计 / 驱动反馈正常 (20)';
  }
  return String(code);
}

function formatControlBlockers(system) {
  const blockers = [];
  const control = system.control || {};

  if (Number(control.emergency_status_code || 0) === 31) {
    blockers.push('急停未复位');
  }
  if (Number(control.charge_status_code || 0) === 47) {
    blockers.push('仍在充电完成态');
  }
  if (Number(control.motor_status_code || 0) === 33) {
    blockers.push('电机未使能');
  }
  const navigationCode = Number(control.navigation_status_code || 0);
  if (navigationCode === 1 || navigationCode === 5) {
    blockers.push(`导航控制仍占用中 (${navigationCode})`);
  }
  if (Number(control.stm32_status_code || 0) === 17) {
    blockers.push('STM32 通讯异常');
  }
  if (Number(control.odom_status_code || 0) === 19) {
    blockers.push('里程计反馈异常');
  }

  if (blockers.length === 0) {
    return '当前未发现明显的底盘联锁阻塞。';
  }

  return `当前不可控原因：${blockers.join(' / ')}。`;
}

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
  const emergencyNode = document.getElementById('emergency-stop-value');
  const motorLockNode = document.getElementById('motor-lock-value');
  const chargeCodeNode = document.getElementById('charge-code-value');
  const stm32Node = document.getElementById('stm32-status-value');
  const odomNode = document.getElementById('odom-status-value');
  const navigationCodeNode = document.getElementById('navigation-code-value');
  const outchargeResultNode = document.getElementById('outcharge-result-value');
  const controlBlockerNode = document.getElementById('control-blocker-value');

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

  if (emergencyNode) {
    emergencyNode.textContent = formatEmergencyStatus(state.system.control);
  }

  if (motorLockNode) {
    motorLockNode.textContent = formatMotorStatus(state.system.control);
  }

  if (chargeCodeNode) {
    chargeCodeNode.textContent = String(state.system.control.charge_status_code || 0);
  }

  if (stm32Node) {
    stm32Node.textContent = formatStm32Status(state.system.control);
  }

  if (odomNode) {
    odomNode.textContent = formatOdomStatus(state.system.control);
  }

  if (navigationCodeNode) {
    navigationCodeNode.textContent = String(state.system.control.navigation_status_code || 0);
  }

  if (outchargeResultNode) {
    const resultCode = Number(state.system.control.out_of_charge_result_code || 0);
    if (resultCode === 50) {
      outchargeResultNode.textContent = '成功 (50)';
    } else if (resultCode === 49) {
      outchargeResultNode.textContent = '失败 (49)';
    } else {
      outchargeResultNode.textContent = String(resultCode);
    }
  }

  if (controlBlockerNode) {
    controlBlockerNode.textContent = formatControlBlockers(state.system);
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
  const exitNavigationModeButton = document.getElementById('exit-navigation-mode-button');
  const joystickBase = document.getElementById('manual-joystick-base');
  const joystickKnob = document.getElementById('manual-joystick-knob');
  const driveStopCenterButton = document.getElementById('drive-stop-center');
  const mapEditorButton = document.getElementById('goto-map-editor-button');
  const feedEditorButton = document.getElementById('goto-map-editor-feed-button');
  const actionFeedbackNode = document.getElementById('action-feedback');
  const maxLinearSpeed = 0.30;
  const maxAngularSpeed = 0.45;
  let moveTimer = null;
  let activeDrivePointerId = null;
  let activeDriveRequiresStop = false;
  let currentLinearSpeed = 0;
  let currentAngularSpeed = 0;

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
    activeDriveRequiresStop = false;
    currentLinearSpeed = 0;
    currentAngularSpeed = 0;
    if (joystickBase) {
      joystickBase.classList.remove('is-active');
    }
    if (joystickKnob) {
      joystickKnob.style.transform = 'translate3d(0px, 0px, 0)';
    }
    try {
      await window.fishbotApi.stopManualMove();
      setActionFeedback('已发送停止导航并释放控制权，同时下发停止速度。', 'success');
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
    activeDriveRequiresStop = true;
    currentLinearSpeed = linear;
    currentAngularSpeed = angular;
    await window.fishbotApi.manualMove(linear, angular);
    setActionFeedback(`摇杆控制：线速度 ${linear.toFixed(2)}，角速度 ${angular.toFixed(2)}。`, 'success');
    moveTimer = window.setInterval(() => {
      window.fishbotApi.manualMove(currentLinearSpeed, currentAngularSpeed).catch(async (error) => {
        window.clearInterval(moveTimer);
        moveTimer = null;
        activeDrivePointerId = null;
        activeDriveRequiresStop = false;
        currentLinearSpeed = 0;
        currentAngularSpeed = 0;
        setActionFeedback(`移动失败：${formatError(error)}`, 'error');
        try {
          await window.fishbotApi.stopManualMove();
        } catch (stopError) {
        }
      });
    }, 100);
  };

  const updateJoystickPosition = (clientX, clientY) => {
    if (!joystickBase || !joystickKnob) {
      return { linear: 0, angular: 0 };
    }

    const rect = joystickBase.getBoundingClientRect();
    const centerX = rect.left + rect.width / 2;
    const centerY = rect.top + rect.height / 2;
    const deltaX = clientX - centerX;
    const deltaY = clientY - centerY;
    const knobRadius = joystickKnob.offsetWidth / 2 || 39;
    const movementRadius = Math.max((rect.width - knobRadius * 2) / 2, 1);
    const distance = Math.hypot(deltaX, deltaY);
    const scale = distance > movementRadius ? movementRadius / distance : 1;
    const limitedX = deltaX * scale;
    const limitedY = deltaY * scale;
    const normalizedX = limitedX / movementRadius;
    const normalizedY = limitedY / movementRadius;

    joystickKnob.style.transform = `translate3d(${limitedX}px, ${limitedY}px, 0)`;

    return {
      linear: Number((-normalizedY * maxLinearSpeed).toFixed(3)),
      angular: Number((-normalizedX * maxAngularSpeed).toFixed(3)),
    };
  };

  const handleJoystickMove = async (clientX, clientY, pointerId) => {
    if (!joystickBase) {
      return;
    }

    const { linear, angular } = updateJoystickPosition(clientX, clientY);
    joystickBase.classList.add('is-active');

    if (!activeDriveRequiresStop) {
      await startDriving(linear, angular, pointerId);
      return;
    }

    activeDrivePointerId = pointerId;
    currentLinearSpeed = linear;
    currentAngularSpeed = angular;
    setActionFeedback(`摇杆控制：线速度 ${linear.toFixed(2)}，角速度 ${angular.toFixed(2)}。`, 'success');
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
        setActionFeedback('已发送脱离充电 / 解锁指令，请观察出桩结果码是否变成 50。', 'success');
      } catch (error) {
        setActionFeedback(`脱离充电失败：${formatError(error)}`, 'error');
      }
    });
  }

  if (exitNavigationModeButton) {
    exitNavigationModeButton.addEventListener('click', async () => {
      try {
        await window.fishbotApi.exitNavigationMode();
        setActionFeedback('已发送退出导航模式指令，请观察导航状态码是否退出占用态。', 'success');
      } catch (error) {
        setActionFeedback(`退出导航模式失败：${formatError(error)}`, 'error');
      }
    });
  }

  if (driveStopCenterButton) {
    driveStopCenterButton.addEventListener('click', stopDriving);
  }

  const bindJoystickStart = (target) => {
    if (!target) {
      return;
    }

    target.addEventListener('pointerdown', async (event) => {
      event.preventDefault();
      if (joystickBase && joystickBase.setPointerCapture && event.pointerId !== undefined) {
        joystickBase.setPointerCapture(event.pointerId);
      }
      try {
        await handleJoystickMove(event.clientX, event.clientY, event.pointerId);
      } catch (error) {
        setActionFeedback(`移动失败：${formatError(error)}`, 'error');
      }
    });
  };

  bindJoystickStart(joystickBase);
  bindJoystickStart(joystickKnob);

  window.addEventListener('pointermove', async (event) => {
    if (activeDriveRequiresStop &&
        (activeDrivePointerId === null || activeDrivePointerId === event.pointerId)) {
      try {
        await handleJoystickMove(event.clientX, event.clientY, event.pointerId);
      } catch (error) {
        setActionFeedback(`移动失败：${formatError(error)}`, 'error');
      }
    }
  });

  window.addEventListener('pointerup', async (event) => {
    if (activeDriveRequiresStop &&
        (activeDrivePointerId === null || activeDrivePointerId === event.pointerId)) {
      await stopDriving();
    }
  });

  window.addEventListener('pointercancel', async (event) => {
    if (activeDriveRequiresStop &&
        (activeDrivePointerId === null || activeDrivePointerId === event.pointerId)) {
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
