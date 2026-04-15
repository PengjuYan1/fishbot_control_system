document.addEventListener('DOMContentLoaded', () => {
  if (!window.fishbotApi) {
    return;
  }

  const undockButton = document.getElementById('undock-button');
  const exitNavigationModeButton = document.getElementById('exit-navigation-mode-button');
  const stopButton = document.getElementById('drive-stop-center');
  const linearSpeedInput = document.getElementById('manual-linear-speed');
  const angularSpeedInput = document.getElementById('manual-angular-speed');
  const linearSpeedValue = document.getElementById('manual-linear-speed-value');
  const angularSpeedValue = document.getElementById('manual-angular-speed-value');
  const actionFeedbackNode = document.getElementById('action-feedback');
  const directionButtons = Array.from(document.querySelectorAll('[data-drive-direction]'));

  const driveKeys = { f: 0, b: 0, l: 0, r: 0 };
  const keyboardDirectionMap = {
    ArrowUp: 'f',
    ArrowDown: 'b',
    ArrowLeft: 'l',
    ArrowRight: 'r',
  };

  let linearSpeed = Number(linearSpeedInput ? linearSpeedInput.value : 0.30);
  let angularSpeed = Number(angularSpeedInput ? angularSpeedInput.value : 0.60);
  let commandLoopTimer = null;
  let stopBurstTimer = null;
  let moveRequestInFlight = false;
  let stopRequestInFlight = false;
  let moveRequestQueued = false;
  let stopBurstRemaining = 0;
  let undockRequestInFlight = false;
  let exitNavigationRequestInFlight = false;
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

  const getManualControlPhase = (result) => (result && (result.phase || result.status)) || 'idle';

  const describeManualControlPhase = (phase, source) => {
    if (phase === 'undocking_requested') {
      return source === 'drive'
        ? '底盘仍在充电/脱桩流程中，请先点“脱离充电桩”。'
        : '已发送脱离充电请求，解除后可直接控制。';
    }
    if (phase === 'ready_for_drive') {
      return source === 'navigation'
        ? '已发送退出导航模式指令，请等待底盘释放导航占用。'
        : '底盘已准备好，可继续按住方向控制。';
    }
    if (phase === 'driving') {
      return `控制中：线速度 ${currentLinearSpeed.toFixed(2)}，角速度 ${currentAngularSpeed.toFixed(2)}。`;
    }
    return '控制会话空闲。';
  };

  const updateSpeedLabels = () => {
    if (linearSpeedValue) {
      linearSpeedValue.textContent = `${linearSpeed.toFixed(2)} m/s`;
    }
    if (angularSpeedValue) {
      angularSpeedValue.textContent = `${angularSpeed.toFixed(2)} rad/s`;
    }
  };

  const resetDriveKeys = () => {
    driveKeys.f = 0;
    driveKeys.b = 0;
    driveKeys.l = 0;
    driveKeys.r = 0;
  };

  const updateDirectionButtonStates = () => {
    directionButtons.forEach((button) => {
      const direction = button.getAttribute('data-drive-direction');
      if (!direction || direction === 's') {
        return;
      }
      button.classList.toggle('active', Boolean(driveKeys[direction]));
    });
  };

  const stopDriveLoop = () => {
    if (commandLoopTimer) {
      window.clearInterval(commandLoopTimer);
      commandLoopTimer = null;
    }
  };

  const clearStopBurst = () => {
    if (stopBurstTimer) {
      window.clearTimeout(stopBurstTimer);
      stopBurstTimer = null;
    }
    stopBurstRemaining = 0;
  };

  const wantsMotion = () => currentLinearSpeed !== 0 || currentAngularSpeed !== 0;

  const recalculateDriveIntent = () => {
    let nextLinear = 0;
    let nextAngular = 0;

    if (driveKeys.f) {
      nextLinear += linearSpeed;
    }
    if (driveKeys.b) {
      nextLinear -= linearSpeed;
    }
    if (driveKeys.l) {
      nextAngular += angularSpeed;
    }
    if (driveKeys.r) {
      nextAngular -= angularSpeed;
    }

    currentLinearSpeed = Number(nextLinear.toFixed(3));
    currentAngularSpeed = Number(nextAngular.toFixed(3));
    updateDirectionButtonStates();
  };

  const sendStopBurst = async () => {
    if (stopRequestInFlight || stopBurstRemaining <= 0) {
      return;
    }

    stopRequestInFlight = true;
    try {
      stopBurstRemaining -= 1;
      await window.fishbotApi.stopManualMove();
      setActionFeedback('已发送停止指令。', 'success');
    } catch (error) {
      setActionFeedback(`停止失败：${formatError(error)}`, 'error');
    } finally {
      stopRequestInFlight = false;
      if (stopBurstRemaining > 0) {
        stopBurstTimer = window.setTimeout(() => {
          void sendStopBurst();
        }, 80);
      } else {
        stopBurstTimer = null;
      }
    }
  };

  const scheduleStopBurst = () => {
    clearStopBurst();
    moveRequestQueued = false;
    stopBurstRemaining = 3;
    void sendStopBurst();
  };

  const stopDriving = () => {
    stopDriveLoop();
    resetDriveKeys();
    recalculateDriveIntent();
    scheduleStopBurst();
  };

  const flushLatestDriveIntent = async () => {
    if (!wantsMotion()) {
      moveRequestQueued = false;
      return;
    }

    if (moveRequestInFlight) {
      moveRequestQueued = true;
      return;
    }

    moveRequestInFlight = true;
    moveRequestQueued = false;
    try {
      const result = await window.fishbotApi.manualMove(currentLinearSpeed, currentAngularSpeed);
      const phase = getManualControlPhase(result);
      setActionFeedback(describeManualControlPhase(phase, 'drive'), 'success');
    } catch (error) {
      stopDriveLoop();
      resetDriveKeys();
      recalculateDriveIntent();
      setActionFeedback(`移动失败：${formatError(error)}`, 'error');
      scheduleStopBurst();
    } finally {
      moveRequestInFlight = false;
      if (wantsMotion() && moveRequestQueued) {
        void flushLatestDriveIntent();
      }
    }
  };

  const ensureDriveLoop = () => {
    if (!wantsMotion()) {
      stopDriveLoop();
      scheduleStopBurst();
      return;
    }

    clearStopBurst();
    if (commandLoopTimer) {
      moveRequestQueued = true;
      return;
    }

    void flushLatestDriveIntent();
    commandLoopTimer = window.setInterval(() => {
      void flushLatestDriveIntent();
    }, 100);
  };

  const setDirectionActive = (direction, active) => {
    if (!Object.prototype.hasOwnProperty.call(driveKeys, direction)) {
      return;
    }
    driveKeys[direction] = active ? 1 : 0;
    recalculateDriveIntent();
    ensureDriveLoop();
  };

  directionButtons.forEach((button) => {
    const direction = button.getAttribute('data-drive-direction');
    if (!direction) {
      return;
    }

    if (direction === 's') {
      button.addEventListener('click', (event) => {
        event.preventDefault();
        button.classList.add('active');
        window.setTimeout(() => button.classList.remove('active'), 120);
        stopDriving();
      });
      return;
    }

    const press = (event) => {
      event.preventDefault();
      button.classList.add('active');
      setDirectionActive(direction, true);
    };

    const release = (event) => {
      event.preventDefault();
      button.classList.remove('active');
      setDirectionActive(direction, false);
    };

    button.addEventListener('mousedown', press);
    button.addEventListener('mouseup', release);
    button.addEventListener('mouseleave', release);
    button.addEventListener('touchstart', press, { passive: false });
    button.addEventListener('touchend', release, { passive: false });
    button.addEventListener('touchcancel', release, { passive: false });
  });

  document.addEventListener('keydown', (event) => {
    if (event.repeat) {
      return;
    }

    if (event.key === ' ') {
      event.preventDefault();
      if (stopButton) {
        stopButton.classList.add('active');
        window.setTimeout(() => stopButton.classList.remove('active'), 120);
      }
      stopDriving();
      return;
    }

    const direction = keyboardDirectionMap[event.key];
    if (!direction) {
      return;
    }

    event.preventDefault();
    setDirectionActive(direction, true);
  });

  document.addEventListener('keyup', (event) => {
    const direction = keyboardDirectionMap[event.key];
    if (!direction) {
      return;
    }

    event.preventDefault();
    setDirectionActive(direction, false);
  });

  if (linearSpeedInput) {
    linearSpeedInput.addEventListener('input', (event) => {
      linearSpeed = Number(event.target.value || 0.30);
      updateSpeedLabels();
      recalculateDriveIntent();
    });
  }

  if (angularSpeedInput) {
    angularSpeedInput.addEventListener('input', (event) => {
      angularSpeed = Number(event.target.value || 0.60);
      updateSpeedLabels();
      recalculateDriveIntent();
    });
  }

  if (undockButton) {
    undockButton.addEventListener('click', async () => {
      if (undockRequestInFlight) {
        return;
      }
      undockRequestInFlight = true;
      stopDriving();
      clearStopBurst();
      try {
        const result = await window.fishbotApi.undockFromChargePile();
        const phase = getManualControlPhase(result);
        setActionFeedback(
          phase === 'ready_for_drive'
            ? '脱桩完成，现可直接按方向控制。'
            : describeManualControlPhase(phase, 'navigation'),
          'success'
        );
      } catch (error) {
        setActionFeedback(`脱离充电桩失败：${formatError(error)}`, 'error');
      } finally {
        undockRequestInFlight = false;
      }
    });
  }

  if (exitNavigationModeButton) {
    exitNavigationModeButton.addEventListener('click', async () => {
      if (exitNavigationRequestInFlight) {
        return;
      }
      exitNavigationRequestInFlight = true;
      try {
        const result = await window.fishbotApi.exitNavigationMode();
        const phase = getManualControlPhase(result);
        setActionFeedback(describeManualControlPhase(phase, 'navigation'), 'success');
      } catch (error) {
        setActionFeedback(`退出导航模式失败：${formatError(error)}`, 'error');
      } finally {
        exitNavigationRequestInFlight = false;
      }
    });
  }

  window.addEventListener('blur', () => {
    if (wantsMotion() || commandLoopTimer) {
      stopDriving();
    }
  });

  document.addEventListener('visibilitychange', () => {
    if (document.hidden && (wantsMotion() || commandLoopTimer)) {
      stopDriving();
    }
  });

  updateSpeedLabels();
  recalculateDriveIntent();
});
