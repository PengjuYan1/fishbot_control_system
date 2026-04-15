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

function formatNavigationStatusCode(control) {
  const code = Number(control.navigation_status_code || 0);
  switch (code) {
    case 1:
      return '1 (导航开始)';
    case 2:
      return '2 (到达目标)';
    case 3:
      return '3 (导航失败)';
    case 5:
      return '5 (导航停止中)';
    case 8:
      return '8 (全局路径规划超时/陷入困境)';
    case 52:
      return '52 (未设置充电点)';
    case 83:
      return '83 (导航已取消)';
    default:
      return String(code);
  }
}

function formatManualControlPhase(manualControl) {
  const phase = (manualControl && manualControl.phase) || 'idle';
  switch (phase) {
    case 'undocking_requested':
      return '脱桩中';
    case 'ready_for_drive':
      return '待接管';
    case 'driving':
      return '驱动中';
    case 'idle':
    default:
      return '空闲';
  }
}

function chargingBlocksManualControl(system) {
  const control = system.control || {};
  if (system.charging) {
    return true;
  }

  switch (Number(control.charge_status_code || 0)) {
    case 45:
    case 46:
    case 47:
    case 48:
      return true;
    default:
      return false;
  }
}

function formatControlBlockers(system) {
  const blockers = [];
  const control = system.control || {};

  if (Number(control.emergency_status_code || 0) === 31) {
    blockers.push('急停未复位');
  }
  if (chargingBlocksManualControl(system)) {
    blockers.push(`仍在充电态 (${Number(control.charge_status_code || 0)})`);
  }
  if (Number(control.motor_status_code || 0) === 33) {
    blockers.push('电机未使能');
  }
  if (Number(control.location_status_code || 0) === 9) {
    blockers.push('定位丢失 (9)');
  }
  const navigationCode = Number(control.navigation_status_code || 0);
  if (navigationCode === 1 || navigationCode === 5) {
    blockers.push(`导航控制仍占用中 (${navigationCode})`);
  } else if (navigationCode === 8) {
    blockers.push('导航规划失败/超时 (8)');
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
  const manualControlPhaseNode = document.getElementById('manual-control-phase-value');
  const outchargeResultNode = document.getElementById('outcharge-result-value');
  const controlBlockerNode = document.getElementById('control-blocker-value');

  if (batteryNode) {
    batteryNode.textContent = `${state.system.battery}%`;
  }

  if (localizationNode) {
    const locationCode = Number((state.system.control || {}).location_status_code || 0);
    localizationNode.textContent = state.system.localized
      ? `正常 (${locationCode})`
      : `未定位 (${locationCode})`;
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
    navigationCodeNode.textContent = formatNavigationStatusCode(state.system.control || {});
  }

  if (manualControlPhaseNode) {
    manualControlPhaseNode.textContent = formatManualControlPhase(state.system.manual_control);
  }

  if (outchargeResultNode) {
    const resultCode = Number(state.system.control.out_of_charge_result_code || 0);
    if (chargingBlocksManualControl(state.system)) {
      if (resultCode > 0) {
        outchargeResultNode.textContent = `仍在充电态，历史结果 ${resultCode}`;
      } else {
        outchargeResultNode.textContent = '仍在充电态';
      }
    } else if (resultCode === 50) {
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

function renderPointListPanel() {
  const panel = document.getElementById('point-list-panel');
  if (!panel || !window.fishbotStore) {
    return;
  }

  const points = window.fishbotStore.getState().points || [];
  if (points.length === 0) {
    panel.innerHTML = '<p class="point-list-empty">暂无已保存点位。</p>';
    return;
  }

  const pointTypeLabel = (point) => {
    if (point.type === 'charge') {
      return '充电点';
    }
    if (point.type === 'initial') {
      return '初始点';
    }
    if (point.type === 'nav') {
      return '导航点';
    }
    return '投喂点';
  };

  panel.innerHTML = points.map((point) => `
    <div class="point-list-item">
      <div class="point-list-copy">
        <strong>${point.name}</strong>
        <span>${pointTypeLabel(point)} · floor ${point.floor_id || 0} · map ${point.map_id || 0} · point ${point.point_id || 0}</span>
      </div>
      <div class="map-item-actions">
        ${point.type === 'initial' ? '' : `<button type="button" class="map-enter-button" data-point-navigate-id="${point.id}" data-point-name="${point.name}">导航到此点</button>`}
        <button type="button" class="point-delete-button" data-point-delete-id="${point.id}">删除</button>
      </div>
    </div>
  `).join('');
}

function renderMapListPanel() {
  const panel = document.getElementById('map-list-panel');
  if (!panel || !window.fishbotStore) {
    return;
  }

  const maps = window.fishbotStore.getState().maps || [];
  if (maps.length === 0) {
    panel.innerHTML = '<p class="point-list-empty">暂无已保存地图。</p>';
    return;
  }

  panel.innerHTML = maps.map((map) => `
    <div class="point-list-item">
      <div class="point-list-copy">
        <strong>${map.map_name || `Map-${map.map_id}`}${map.is_default_floor && map.is_default_map ? '（默认）' : ''}</strong>
        <span>floor ${map.floor_id || 0} · map ${map.map_id || 0} · charge ${map.charge_id || 0} · initial ${map.initial_id || 0}</span>
      </div>
      <div class="map-item-actions">
        <button type="button" class="map-enter-button" data-map-enter-floor-id="${map.floor_id}" data-map-enter-map-id="${map.map_id}">进入</button>
        <button type="button" class="point-delete-button" data-map-delete-floor-id="${map.floor_id}" data-map-delete-map-id="${map.map_id}">删除</button>
      </div>
    </div>
  `).join('');
}

function bindControlButtons() {
  const startMappingButton = document.getElementById('start-mapping-button');
  const saveMapButton = document.getElementById('save-map-button');
  const startTaskButton = document.getElementById('start-task-button');
  const goChargeButton = document.getElementById('go-charge-button');
  const undockButton = document.getElementById('undock-button');
  const exitNavigationModeButton = document.getElementById('exit-navigation-mode-button');
  const joystickBase = document.getElementById('manual-joystick-base');
  const joystickKnob = document.getElementById('manual-joystick-knob');
  const driveStopCenterButton = document.getElementById('drive-stop-center');
  const mapEditorButton = document.getElementById('goto-map-editor-button');
  const navEditorButton = document.getElementById('goto-map-editor-nav-button');
  const feedEditorButton = document.getElementById('goto-map-editor-feed-button');
  const pointListPanel = document.getElementById('point-list-panel');
  const mapListPanel = document.getElementById('map-list-panel');
  const actionFeedbackNode = document.getElementById('action-feedback');
  const maxLinearSpeed = 0.40;
  const maxAngularSpeed = 0.60;
  const joystickHeartbeatMs = 40;
  let commandLoopTimer = null;
  let activePointerId = null;
  let joystickDragging = false;
  let moveRequestInFlight = false;
  let stopRequestInFlight = false;
  let controlRequestGeneration = 0;
  let currentLinearSpeed = 0;
  let currentAngularSpeed = 0;
  let lastActionFeedback = '';

  const setActionFeedback = (message, level) => {
    if (!actionFeedbackNode) {
      return;
    }
    if (lastActionFeedback === `${level || ''}:${message}`) {
      return;
    }
    lastActionFeedback = `${level || ''}:${message}`;
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

  const refreshMaps = async () => {
    const maps = await window.fishbotApi.getMaps();
    window.fishbotStore.setMaps(maps || []);
  };

  const refreshMapAndPoints = async () => {
    const [maps, points] = await Promise.all([
      window.fishbotApi.getMaps(),
      window.fishbotApi.getPoints(),
    ]);
    window.fishbotStore.setMaps(maps || []);
    window.fishbotStore.setPoints(points || []);
  };

  const setManualControlState = (result) => {
    if (!window.fishbotStore || !result) {
      return (result && (result.phase || result.status)) || 'idle';
    }

    const currentSystem = window.fishbotStore.getState().system || {};
    const nextPhase = result.phase || result.status || 'idle';
    window.fishbotStore.setSystemSnapshot({
      ...currentSystem,
      manual_control: {
        ...(currentSystem.manual_control || {}),
        phase: nextPhase,
        desired_linear: Number(result.desired_linear || 0),
        desired_angular: Number(result.desired_angular || 0),
        session_active: Boolean(result.session_active),
        pending_motion: Boolean(result.pending_motion),
      },
    });
    return nextPhase;
  };

  const describeManualControlPhase = (phase, source) => {
    if (phase === 'undocking_requested') {
      return source === 'joystick'
        ? '正在自动出桩并接管底盘，请保持摇杆。'
        : '已发送脱离充电请求，解除后可直接遥控。';
    }
    if (phase === 'ready_for_drive') {
      return source === 'navigation'
        ? '已发送退出导航模式指令，请观察导航状态码是否退出占用态。'
        : '底盘正在释放导航占用并准备驱动，保持摇杆即可开始移动。';
    }
    if (phase === 'driving') {
      return `摇杆控制：线速度 ${currentLinearSpeed.toFixed(2)}，角速度 ${currentAngularSpeed.toFixed(2)}。`;
    }
    return '控制会话空闲。';
  };

  const resetJoystickVisuals = () => {
    activePointerId = null;
    joystickDragging = false;
    currentLinearSpeed = 0;
    currentAngularSpeed = 0;
    if (joystickBase) {
      joystickBase.classList.remove('is-active');
    }
    if (joystickKnob) {
      joystickKnob.style.transform = 'translate3d(0px, 0px, 0)';
    }
  };

  const stopDriveLoop = () => {
    if (commandLoopTimer) {
      window.clearInterval(commandLoopTimer);
      commandLoopTimer = null;
    }
  };

  const stopDriving = async () => {
    stopDriveLoop();
    resetJoystickVisuals();
    if (stopRequestInFlight) {
      return;
    }
    stopRequestInFlight = true;
    controlRequestGeneration += 1;
    try {
      const result = await window.fishbotApi.stopManualMove();
      setManualControlState(result);
      setActionFeedback('已发送停止指令，摇杆会话已复位。', 'success');
    } catch (error) {
      setActionFeedback(`停止失败：${formatError(error)}`, 'error');
      throw error;
    } finally {
      stopRequestInFlight = false;
    }
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

  const sendCurrentDriveIntent = async () => {
    if (!joystickDragging || moveRequestInFlight) {
      return;
    }

    const requestGeneration = controlRequestGeneration;
    moveRequestInFlight = true;
    try {
      const result = await window.fishbotApi.manualMove(currentLinearSpeed, currentAngularSpeed);
      if (requestGeneration !== controlRequestGeneration) {
        return;
      }
      const phase = setManualControlState(result);
      setActionFeedback(describeManualControlPhase(phase, 'joystick'), 'success');
    } catch (error) {
      if (requestGeneration !== controlRequestGeneration) {
        return;
      }
      stopDriveLoop();
      resetJoystickVisuals();
      setActionFeedback(`移动失败：${formatError(error)}`, 'error');
      try {
        const result = await window.fishbotApi.stopManualMove();
        setManualControlState(result);
      } catch (stopError) {
      }
    } finally {
      moveRequestInFlight = false;
    }
  };

  const ensureDriveLoop = () => {
    if (commandLoopTimer) {
      return;
    }
    void sendCurrentDriveIntent();
    commandLoopTimer = window.setInterval(() => {
      void sendCurrentDriveIntent();
    }, joystickHeartbeatMs);
  };

  const handleJoystickMove = (clientX, clientY, pointerId) => {
    if (!joystickBase) {
      return;
    }

    const { linear, angular } = updateJoystickPosition(clientX, clientY);
    joystickBase.classList.add('is-active');
    if (!joystickDragging) {
      controlRequestGeneration += 1;
    }
    activePointerId = pointerId;
    joystickDragging = true;
    currentLinearSpeed = linear;
    currentAngularSpeed = angular;
    ensureDriveLoop();
  };

  if (startMappingButton) {
    startMappingButton.addEventListener('click', async () => {
      try {
        await window.fishbotApi.startMapping();
        await refreshMaps();
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
        await refreshMaps();
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
        const result = await window.fishbotApi.startSelfCharge();
        const nextSnapshot = { ...window.fishbotStore.getState().system, task: {
          status: result.status || 'self_charging_nav',
          current_target: result.current_target_name || '',
        } };
        window.fishbotStore.setSystemSnapshot(nextSnapshot);
        setActionFeedback('已启动自研回充：先导航到充电点，再低速靠桩。', 'success');
      } catch (error) {
        setActionFeedback(`回充失败：${formatError(error)}`, 'error');
      }
    });
  }

  if (undockButton) {
    undockButton.addEventListener('click', async () => {
      try {
        const result = await window.fishbotApi.undockFromChargePile();
        const phase = setManualControlState(result);
        setActionFeedback(
          phase === 'ready_for_drive'
            ? '脱桩完成，现可直接拖动摇杆控制。'
            : describeManualControlPhase(phase, 'navigation'),
          'success'
        );
      } catch (error) {
        setActionFeedback(`脱离充电桩失败：${formatError(error)}`, 'error');
      }
    });
  }

  if (exitNavigationModeButton) {
    exitNavigationModeButton.addEventListener('click', async () => {
      try {
        const result = await window.fishbotApi.exitNavigationMode();
        const phase = setManualControlState(result);
        setActionFeedback(describeManualControlPhase(phase, 'navigation'), 'success');
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

    target.addEventListener('pointerdown', (event) => {
      event.preventDefault();
      if (joystickBase && joystickBase.setPointerCapture && event.pointerId !== undefined) {
        joystickBase.setPointerCapture(event.pointerId);
      }
      try {
        handleJoystickMove(event.clientX, event.clientY, event.pointerId);
      } catch (error) {
        setActionFeedback(`移动失败：${formatError(error)}`, 'error');
      }
    });
  };

  bindJoystickStart(joystickBase);
  bindJoystickStart(joystickKnob);

  window.addEventListener('pointermove', (event) => {
    if (joystickDragging &&
        activePointerId !== null &&
        activePointerId === event.pointerId) {
      try {
        handleJoystickMove(event.clientX, event.clientY, event.pointerId);
      } catch (error) {
        setActionFeedback(`移动失败：${formatError(error)}`, 'error');
      }
    }
  });

  window.addEventListener('pointerup', async (event) => {
    if (joystickDragging &&
        activePointerId !== null &&
        activePointerId === event.pointerId) {
      await stopDriving();
    }
  });

  window.addEventListener('pointercancel', async (event) => {
    if (joystickDragging &&
        activePointerId !== null &&
        activePointerId === event.pointerId) {
      await stopDriving();
    }
  });

  window.addEventListener('blur', () => {
    if (joystickDragging || commandLoopTimer) {
      void stopDriving();
    }
  });

  document.addEventListener('visibilitychange', () => {
    if (document.hidden && (joystickDragging || commandLoopTimer)) {
      void stopDriving();
    }
  });

  if (mapEditorButton) {
    mapEditorButton.addEventListener('click', async () => {
      try {
        const point = await window.fishbotApi.createCurrentChargePoint();
        await refreshMapAndPoints();
        setActionFeedback(`已按当前位置创建充电点 ${point.name || 'C?'}。`, 'success');
      } catch (error) {
        setActionFeedback(`创建充电点失败：${formatError(error)}`, 'error');
      }
    });
  }

  if (feedEditorButton) {
    feedEditorButton.addEventListener('click', async () => {
      try {
        const point = await window.fishbotApi.createCurrentFeedPoint();
        await refreshMapAndPoints();
        setActionFeedback(`已按当前位置创建投喂点 ${point.name || 'F?'}。`, 'success');
      } catch (error) {
        setActionFeedback(`创建投喂点失败：${formatError(error)}`, 'error');
      }
    });
  }

  if (navEditorButton) {
    navEditorButton.addEventListener('click', async () => {
      try {
        const point = await window.fishbotApi.createCurrentNavPoint();
        await refreshMapAndPoints();
        setActionFeedback(`已按当前位置创建导航点 ${point.name || 'N?'}。`, 'success');
      } catch (error) {
        setActionFeedback(`创建导航点失败：${formatError(error)}`, 'error');
      }
    });
  }

  if (pointListPanel) {
    pointListPanel.addEventListener('click', async (event) => {
      const navigateTarget = event.target instanceof Element ? event.target.closest('[data-point-navigate-id]') : null;
      if (navigateTarget) {
        const pointId = Number(navigateTarget.getAttribute('data-point-navigate-id') || 0);
        const pointName = navigateTarget.getAttribute('data-point-name') || '';
        if (!pointId) {
          return;
        }

        try {
          const result = await window.fishbotApi.navigateToPoint(pointId);
          const nextSnapshot = { ...window.fishbotStore.getState().system, task: {
            status: result.status || 'navigating',
            current_target: result.current_target_name || pointName,
          } };
          window.fishbotStore.setSystemSnapshot(nextSnapshot);
          setActionFeedback(`已开始导航到点位 ${result.current_target_name || pointName || pointId}。`, 'success');
        } catch (error) {
          setActionFeedback(`导航到点位失败：${formatError(error)}`, 'error');
        }
        return;
      }

      const target = event.target instanceof Element ? event.target.closest('[data-point-delete-id]') : null;
      if (!target) {
        return;
      }

      const pointId = Number(target.getAttribute('data-point-delete-id') || 0);
      if (!pointId) {
        return;
      }

      if (window.confirm && !window.confirm('确认删除该点位？会同时删除机器人原生点位。')) {
        return;
      }

      try {
        const point = await window.fishbotApi.deletePoint(pointId);
        await refreshMapAndPoints();
        setActionFeedback(`已删除点位 ${point.name || pointId}。`, 'success');
      } catch (error) {
        setActionFeedback(`删除点位失败：${formatError(error)}`, 'error');
      }
    });
  }

  if (mapListPanel) {
    mapListPanel.addEventListener('click', async (event) => {
      const enterTarget = event.target instanceof Element ? event.target.closest('[data-map-enter-floor-id][data-map-enter-map-id]') : null;
      if (enterTarget) {
        const floorId = Number(enterTarget.getAttribute('data-map-enter-floor-id') || 0);
        const mapId = Number(enterTarget.getAttribute('data-map-enter-map-id') || 0);
        if (floorId > 0 && mapId > 0) {
          try {
            await window.fishbotApi.loadMap(floorId, mapId);
            await refreshMaps();
            setActionFeedback(`已进入地图 floor ${floorId} / map ${mapId}。`, 'success');
          } catch (error) {
            setActionFeedback(`进入地图失败：${formatError(error)}`, 'error');
          }
        }
        return;
      }

      const target = event.target instanceof Element ? event.target.closest('[data-map-delete-floor-id][data-map-delete-map-id]') : null;
      if (!target) {
        return;
      }

      const floorId = Number(target.getAttribute('data-map-delete-floor-id') || 0);
      const mapId = Number(target.getAttribute('data-map-delete-map-id') || 0);
      if (!floorId || !mapId) {
        return;
      }

      if (window.confirm && !window.confirm('确认删除该地图？对应原生地图会被删除。')) {
        return;
      }

      try {
        await window.fishbotApi.deleteMap(floorId, mapId);
        await refreshMapAndPoints();
        setActionFeedback(`已删除地图 floor ${floorId} / map ${mapId}。`, 'success');
      } catch (error) {
        setActionFeedback(`删除地图失败：${formatError(error)}`, 'error');
      }
    });
  }
}

document.addEventListener('DOMContentLoaded', async () => {
  if (!window.fishbotApi || !window.fishbotStore) {
    return;
  }

  window.fishbotStore.subscribe(() => {
    updateDashboardStatus();
    renderPointListPanel();
    renderMapListPanel();
    if (typeof window.renderMapOverlay === 'function') {
      window.renderMapOverlay();
    }
  });
  updateDashboardStatus();
  renderPointListPanel();
  renderMapListPanel();
  if (typeof window.renderMapOverlay === 'function') {
    window.renderMapOverlay();
  }

  bindControlButtons();
  bindRealtimeStatusSocket();

  try {
    const [status, points, maps, map] = await Promise.all([
      window.fishbotApi.getSystemStatus(),
      window.fishbotApi.getPoints(),
      window.fishbotApi.getMaps(),
      window.fishbotApi.getMapSnapshot ? window.fishbotApi.getMapSnapshot() : Promise.resolve(null),
    ]);

    window.fishbotStore.setSystemSnapshot(status || {});
    window.fishbotStore.setPoints(points || []);
    window.fishbotStore.setMaps(maps || []);
    if (map) {
      window.fishbotStore.setMapSnapshot(map);
    }
  } catch (error) {
  }

  if (window.fishbotApi && window.fishbotStore) {
    window.setInterval(async () => {
      if (document.hidden) {
        return;
      }
      try {
        const [points, maps] = await Promise.all([
          window.fishbotApi.getPoints(),
          window.fishbotApi.getMaps(),
        ]);
        window.fishbotStore.setPoints(points || []);
        window.fishbotStore.setMaps(maps || []);
      } catch (error) {
      }
    }, 3000);
  }

});
