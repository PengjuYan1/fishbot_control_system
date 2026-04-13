window.fishbotStore = (() => {
  const state = {
    system: {
      battery: 0,
      charging: false,
      connected: false,
      localized: false,
      task: { status: 'idle', current_target: '' },
      connection: { healthy: false, last_error: '', reconnect_attempts: 0, adapter_mode: '' },
      control: {
        emergency_stopped: false,
        emergency_status_code: 0,
        motor_locked: false,
        motor_status_code: 0,
        charge_status_code: 0,
        motion_mode_code: 0,
        out_of_charge_status_code: 0,
        out_machine_signal: false,
        out_of_charge_result_code: 0,
      },
    },
    robot: { pose: { x: 0, y: 0, theta: 0 } },
    map: { width: 0, height: 0, resolution: 0, origin_x: 0, origin_y: 0, occupancy_data: [] },
    points: [],
  };
  const listeners = new Set();

  function emit() {
    listeners.forEach((listener) => listener(state));
  }

  return {
    getState() {
      return state;
    },
    subscribe(listener) {
      listeners.add(listener);
      return () => listeners.delete(listener);
    },
    setSystemSnapshot(snapshot) {
      state.system = {
        battery: Number(snapshot.battery || 0),
        charging: Boolean(snapshot.charging),
        connected: Boolean(snapshot.connected),
        localized: Boolean(snapshot.localized),
        task: snapshot.task || { status: 'idle', current_target: '' },
        connection: snapshot.connection || { healthy: false, last_error: '', reconnect_attempts: 0, adapter_mode: '' },
        control: snapshot.control || {
          emergency_stopped: false,
          emergency_status_code: 0,
          motor_locked: false,
          motor_status_code: 0,
          charge_status_code: 0,
          motion_mode_code: 0,
          out_of_charge_status_code: 0,
          out_machine_signal: false,
          out_of_charge_result_code: 0,
        },
      };
      if (snapshot.pose) {
        state.robot.pose = snapshot.pose;
      }
      emit();
    },
    setRobotPose(pose) {
      state.robot.pose = pose;
      emit();
    },
    setMapSnapshot(map) {
      state.map = {
        width: Number(map.width || 0),
        height: Number(map.height || 0),
        resolution: Number(map.resolution || 0),
        origin_x: Number(map.origin_x || 0),
        origin_y: Number(map.origin_y || 0),
        occupancy_data: Array.isArray(map.occupancy_data) ? map.occupancy_data.slice() : [],
      };
      emit();
    },
    setPoints(points) {
      state.points = points;
      emit();
    },
  };
})();
