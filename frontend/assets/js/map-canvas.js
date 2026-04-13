function positionStyle(x, y) {
  return `left:${x}%;top:${y}%;`;
}

function renderRobot(container, pose) {
  const robot = document.createElement('div');
  robot.className = 'robot-marker';
  robot.style.cssText = positionStyle(18 + pose.x * 8, 24 + pose.y * 6);
  container.appendChild(robot);
  return robot;
}

function renderHeading(container, pose) {
  const heading = document.createElement('div');
  heading.className = 'robot-heading';
  heading.style.cssText = `${positionStyle(22 + pose.x * 8, 28 + pose.y * 6)}transform: rotate(${pose.theta}rad);`;
  container.appendChild(heading);
  return heading;
}

function renderPoints(container, points) {
  return points.map((point) => {
    const node = document.createElement('div');
    node.className = point.type === 'charge' ? 'map-point charge-point' : 'map-point feed-point';
    node.textContent = point.name;
    node.style.cssText = positionStyle(point.x, point.y);
    container.appendChild(node);
    return node;
  });
}

window.renderMapOverlay = function renderMapOverlay() {
  const stage = document.getElementById('map-layer');
  if (!stage || !window.fishbotStore) {
    return;
  }

  const state = window.fishbotStore.getState();
  stage.innerHTML = '';
  renderRobot(stage, state.robot.pose);
  renderHeading(stage, state.robot.pose);
  renderPoints(stage, state.points);
};
