window.fishbotStore = (() => {
  function normalizePose(pose) {
    return {
      x: Number((pose && pose.x) || 0),
      y: Number((pose && pose.y) || 0),
      theta: Number((pose && pose.theta) || 0),
    };
  }

  function poseSignature(pose) {
    return [pose.x, pose.y, pose.theta].join('|');
  }

  function normalizeControl(control) {
    return {
      emergency_stopped: Boolean(control && control.emergency_stopped),
      emergency_status_code: Number((control && control.emergency_status_code) || 0),
      motor_locked: Boolean(control && control.motor_locked),
      motor_status_code: Number((control && control.motor_status_code) || 0),
      charge_status_code: Number((control && control.charge_status_code) || 0),
      stm32_status_code: Number((control && control.stm32_status_code) || 0),
      odom_status_code: Number((control && control.odom_status_code) || 0),
      motion_mode_code: Number((control && control.motion_mode_code) || 0),
      location_status_code: Number((control && control.location_status_code) || 0),
      navigation_status_code: Number((control && control.navigation_status_code) || 0),
      out_of_charge_status_code: Number((control && control.out_of_charge_status_code) || 0),
      out_machine_signal: Boolean(control && control.out_machine_signal),
      out_of_charge_result_code: Number((control && control.out_of_charge_result_code) || 0),
    };
  }

  function controlSignature(control) {
    return [
      control.emergency_stopped ? 1 : 0,
      control.emergency_status_code,
      control.motor_locked ? 1 : 0,
      control.motor_status_code,
      control.charge_status_code,
      control.stm32_status_code,
      control.odom_status_code,
      control.motion_mode_code,
      control.location_status_code,
      control.navigation_status_code,
      control.out_of_charge_status_code,
      control.out_machine_signal ? 1 : 0,
      control.out_of_charge_result_code,
    ].join('|');
  }

  function normalizeSystem(snapshot) {
    return {
      battery: Number((snapshot && snapshot.battery) || 0),
      charging: Boolean(snapshot && snapshot.charging),
      connected: Boolean(snapshot && snapshot.connected),
      localized: Boolean(snapshot && snapshot.localized),
      task: {
        status: String(((snapshot && snapshot.task) && snapshot.task.status) || 'idle'),
        current_target: String(((snapshot && snapshot.task) && snapshot.task.current_target) || ''),
      },
      connection: {
        healthy: Boolean((snapshot && snapshot.connection) && snapshot.connection.healthy),
        last_error: String(((snapshot && snapshot.connection) && snapshot.connection.last_error) || ''),
        reconnect_attempts: Number(((snapshot && snapshot.connection) && snapshot.connection.reconnect_attempts) || 0),
        adapter_mode: String(((snapshot && snapshot.connection) && snapshot.connection.adapter_mode) || ''),
      },
      control: normalizeControl((snapshot && snapshot.control) || {}),
      manual_control: {
        phase: String(((snapshot && snapshot.manual_control) && snapshot.manual_control.phase) || 'idle'),
        desired_linear: Number(((snapshot && snapshot.manual_control) && snapshot.manual_control.desired_linear) || 0),
        desired_angular: Number(((snapshot && snapshot.manual_control) && snapshot.manual_control.desired_angular) || 0),
        session_active: Boolean((snapshot && snapshot.manual_control) && snapshot.manual_control.session_active),
        pending_motion: Boolean((snapshot && snapshot.manual_control) && snapshot.manual_control.pending_motion),
      },
    };
  }

  function systemSignature(system) {
    return [
      system.battery,
      system.charging ? 1 : 0,
      system.connected ? 1 : 0,
      system.localized ? 1 : 0,
      system.task.status,
      system.task.current_target,
      system.connection.healthy ? 1 : 0,
      system.connection.last_error,
      system.connection.reconnect_attempts,
      system.connection.adapter_mode,
      controlSignature(system.control),
      system.manual_control.phase,
      system.manual_control.desired_linear,
      system.manual_control.desired_angular,
      system.manual_control.session_active ? 1 : 0,
      system.manual_control.pending_motion ? 1 : 0,
    ].join('|');
  }

  function normalizeMap(map) {
    return {
      width: Number((map && map.width) || 0),
      height: Number((map && map.height) || 0),
      resolution: Number((map && map.resolution) || 0),
      origin_x: Number((map && map.origin_x) || 0),
      origin_y: Number((map && map.origin_y) || 0),
      occupancy_data: Array.isArray(map && map.occupancy_data) ? map.occupancy_data.slice() : [],
    };
  }

  function hashArray(values) {
    let hash = 2166136261;
    for (let index = 0; index < values.length; index += 1) {
      hash ^= (Number(values[index]) || 0) + 128;
      hash = Math.imul(hash, 16777619);
    }
    return hash >>> 0;
  }

  function mapSignature(map) {
    return [
      map.width,
      map.height,
      map.resolution,
      map.origin_x,
      map.origin_y,
      map.occupancy_data.length,
      hashArray(map.occupancy_data),
    ].join('|');
  }

  function normalizeMapItem(map) {
    return {
      floor_id: Number((map && map.floor_id) || 0),
      map_id: Number((map && map.map_id) || 0),
      map_name: String((map && map.map_name) || ''),
      charge_id: Number((map && map.charge_id) || 0),
      initial_id: Number((map && map.initial_id) || 0),
      is_default_floor: Boolean(map && map.is_default_floor),
      is_default_map: Boolean(map && map.is_default_map),
    };
  }

  function mapsSignature(maps) {
    return maps.map((map) => [
      map.floor_id,
      map.map_id,
      map.map_name,
      map.charge_id,
      map.initial_id,
      map.is_default_floor ? 1 : 0,
      map.is_default_map ? 1 : 0,
    ].join(':')).join('|');
  }

  function normalizePoint(point) {
    return {
      id: Number((point && point.id) || 0),
      name: String((point && point.name) || ''),
      type: String((point && point.type) || ''),
      x: Number((point && point.x) || 0),
      y: Number((point && point.y) || 0),
      theta: Number((point && point.theta) || 0),
      floor_id: Number((point && point.floor_id) || 0),
      map_id: Number((point && point.map_id) || 0),
      point_id: Number((point && point.point_id) || 0),
    };
  }

  function pointsSignature(points) {
    return points.map((point) => [
      point.id,
      point.name,
      point.type,
      point.x,
      point.y,
      point.theta,
      point.floor_id,
      point.map_id,
      point.point_id,
    ].join(':')).join('|');
  }

  const state = {
    system: normalizeSystem({
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
        stm32_status_code: 0,
        odom_status_code: 0,
        motion_mode_code: 0,
        location_status_code: 0,
        navigation_status_code: 0,
        out_of_charge_status_code: 0,
        out_machine_signal: false,
        out_of_charge_result_code: 0,
      },
      manual_control: {
        phase: 'idle',
        desired_linear: 0,
        desired_angular: 0,
        session_active: false,
        pending_motion: false,
      },
    }),
    robot: { pose: normalizePose({ x: 0, y: 0, theta: 0 }) },
    map: normalizeMap({ width: 0, height: 0, resolution: 0, origin_x: 0, origin_y: 0, occupancy_data: [] }),
    maps: [],
    points: [],
  };
  const listeners = new Set();
  const signatures = {
    system: systemSignature(state.system),
    pose: poseSignature(state.robot.pose),
    map: mapSignature(state.map),
    maps: mapsSignature(state.maps),
    points: pointsSignature(state.points),
  };

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
      const nextSystem = normalizeSystem(snapshot || {});
      const nextSystemSignature = systemSignature(nextSystem);
      const nextPose = normalizePose((snapshot && snapshot.pose) || state.robot.pose);
      const nextPoseSignature = poseSignature(nextPose);
      let changed = false;

      if (nextSystemSignature !== signatures.system) {
        state.system = nextSystem;
        signatures.system = nextSystemSignature;
        changed = true;
      }

      if (nextPoseSignature !== signatures.pose) {
        state.robot.pose = nextPose;
        signatures.pose = nextPoseSignature;
        changed = true;
      }

      if (changed) {
        emit();
      }
    },
    setRobotPose(pose) {
      const nextPose = normalizePose(pose || {});
      const nextPoseSignature = poseSignature(nextPose);
      if (nextPoseSignature === signatures.pose) {
        return;
      }
      state.robot.pose = nextPose;
      signatures.pose = nextPoseSignature;
      emit();
    },
    setMapSnapshot(map) {
      const nextMap = normalizeMap(map || {});
      const nextMapSignature = mapSignature(nextMap);
      if (nextMapSignature === signatures.map) {
        return;
      }
      state.map = nextMap;
      signatures.map = nextMapSignature;
      emit();
    },
    setMaps(maps) {
      const nextMaps = Array.isArray(maps) ? maps.map(normalizeMapItem) : [];
      const nextMapsSignature = mapsSignature(nextMaps);
      if (nextMapsSignature === signatures.maps) {
        return;
      }
      state.maps = nextMaps;
      signatures.maps = nextMapsSignature;
      emit();
    },
    setPoints(points) {
      const nextPoints = Array.isArray(points) ? points.map(normalizePoint) : [];
      const nextPointsSignature = pointsSignature(nextPoints);
      if (nextPointsSignature === signatures.points) {
        return;
      }
      state.points = nextPoints;
      signatures.points = nextPointsSignature;
      emit();
    },
  };
})();
