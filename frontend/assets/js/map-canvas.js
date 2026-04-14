function clampPercent(value) {
  return Math.max(0, Math.min(100, value));
}

function fallbackPosition(x, y) {
  return {
    left: clampPercent(18 + x * 8),
    top: clampPercent(24 + y * 6),
  };
}

function worldToPercent(map, x, y) {
  if (!map || !map.width || !map.height || !map.resolution) {
    return fallbackPosition(x, y);
  }

  const mapWidth = map.width * map.resolution;
  const mapHeight = map.height * map.resolution;
  if (mapWidth <= 0 || mapHeight <= 0) {
    return fallbackPosition(x, y);
  }

  const relativeX = (x - map.origin_x) / mapWidth;
  const relativeY = (y - map.origin_y) / mapHeight;
  return {
    left: clampPercent(relativeX * 100),
    top: clampPercent((1 - relativeY) * 100),
  };
}

function positionStyle(position) {
  return `left:${position.left}%;top:${position.top}%;`;
}

function ensureCanvas(stage) {
  let canvas = document.getElementById('map-grid-canvas');
  if (!canvas) {
    canvas = document.createElement('canvas');
    canvas.id = 'map-grid-canvas';
    canvas.className = 'map-grid-canvas';
    canvas.width = 800;
    canvas.height = 800;
    stage.appendChild(canvas);
  }
  return canvas;
}

function drawMapRaster(stage, map) {
  const canvas = ensureCanvas(stage);
  const context = canvas.getContext('2d');
  context.clearRect(0, 0, canvas.width, canvas.height);

  if (!map || !map.width || !map.height || !Array.isArray(map.occupancy_data) || map.occupancy_data.length === 0) {
    return;
  }

  const offscreen = document.createElement('canvas');
  offscreen.width = map.width;
  offscreen.height = map.height;
  const offscreenContext = offscreen.getContext('2d');
  const image = offscreenContext.createImageData(map.width, map.height);

  for (let row = 0; row < map.height; row += 1) {
    for (let col = 0; col < map.width; col += 1) {
      const sourceIndex = row * map.width + col;
      const targetRow = map.height - row - 1;
      const pixelIndex = (targetRow * map.width + col) * 4;
      const value = Number(map.occupancy_data[sourceIndex] || 0);

      let red = 240;
      let green = 244;
      let blue = 247;
      let alpha = 255;

      if (value < 0) {
        red = 194;
        green = 204;
        blue = 214;
        alpha = 160;
      } else if (value > 65) {
        red = 35;
        green = 51;
        blue = 74;
      } else if (value > 0) {
        red = 110;
        green = 138;
        blue = 163;
      }

      image.data[pixelIndex] = red;
      image.data[pixelIndex + 1] = green;
      image.data[pixelIndex + 2] = blue;
      image.data[pixelIndex + 3] = alpha;
    }
  }

  offscreenContext.putImageData(image, 0, 0);
  context.imageSmoothingEnabled = false;
  context.drawImage(offscreen, 0, 0, canvas.width, canvas.height);
}

function renderRobot(stage, map, pose) {
  const position = worldToPercent(map, Number(pose.x || 0), Number(pose.y || 0));

  const robot = document.createElement('div');
  robot.className = 'robot-marker';
  robot.style.cssText = positionStyle(position);
  stage.appendChild(robot);

  const heading = document.createElement('div');
  heading.className = 'robot-heading';
  heading.style.cssText = `${positionStyle(position)}transform: rotate(${Number(pose.theta || 0)}rad);`;
  stage.appendChild(heading);
}

function renderPoints(stage, map, points) {
  points.forEach((point) => {
    const position = worldToPercent(map, Number(point.x || 0), Number(point.y || 0));
    const node = document.createElement('div');
    node.className = point.type === 'charge'
      ? 'map-point charge-point'
      : point.type === 'initial'
        ? 'map-point initial-point'
        : 'map-point feed-point';
    node.textContent = point.name;
    node.style.cssText = positionStyle(position);
    stage.appendChild(node);
  });
}

function updateMapNote(map) {
  const note = document.getElementById('map-note');
  if (!note) {
    return;
  }

  if (map && map.width && map.height && map.resolution) {
    note.textContent = `地图 ${map.width}x${map.height} @ ${map.resolution}m/格，原点 (${map.origin_x.toFixed(2)}, ${map.origin_y.toFixed(2)})`;
    return;
  }

  note.textContent = '等待地图快照 / 机器人位置 / 点位覆盖层';
}

window.renderMapOverlay = function renderMapOverlay() {
  const stage = document.getElementById('map-layer');
  if (!stage || !window.fishbotStore) {
    return;
  }

  const state = window.fishbotStore.getState();
  const map = state.map || {};
  stage.innerHTML = '';
  drawMapRaster(stage, map);
  renderRobot(stage, map, state.robot.pose);
  renderPoints(stage, map, state.points);
  updateMapNote(map);
};
