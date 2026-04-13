window.fishbotStore = (() => {
  const state = {
    robot: { pose: { x: 0, y: 0, theta: 0 } },
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
    setRobotPose(pose) {
      state.robot.pose = pose;
      emit();
    },
    setPoints(points) {
      state.points = points;
      emit();
    },
  };
})();
