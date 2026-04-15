function clampPercent(value) {
  return Math.max(0, Math.min(100, value));
}

const mapViewportState = {
  scale: 1,
  minScale: 0.5,
  maxScale: 4,
  initialized: false,
};

const mapRenderState = {
  stageReady: false,
  rasterSignature: '',
  pointsSignature: '',
  stage: null,
  canvas: null,
  pointsLayer: null,
  robotMarker: null,
  robotHeading: null,
};

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

function clampScale(nextScale) {
  return Math.max(mapViewportState.minScale, Math.min(mapViewportState.maxScale, nextScale));
}

function applyMapScale() {
  const stage = document.getElementById('map-layer');
  if (!stage) {
    return;
  }
  stage.style.transform = `scale(${mapViewportState.scale})`;

  const label = document.getElementById('map-zoom-label');
  if (label) {
    label.textContent = `${Math.round(mapViewportState.scale * 100)}%`;
  }
}

function setMapScale(nextScale) {
  mapViewportState.scale = clampScale(nextScale);
  applyMapScale();
}

function bindMapZoomControls() {
  if (mapViewportState.initialized) {
    return;
  }
  mapViewportState.initialized = true;

  const zoomIn = document.getElementById('map-zoom-in');
  const zoomOut = document.getElementById('map-zoom-out');
  const zoomReset = document.getElementById('map-zoom-reset');
  const canvasHost = document.getElementById('map-canvas');

  if (zoomIn) {
    zoomIn.addEventListener('click', () => {
      setMapScale(mapViewportState.scale * 1.2);
    });
  }

  if (zoomOut) {
    zoomOut.addEventListener('click', () => {
      setMapScale(mapViewportState.scale / 1.2);
    });
  }

  if (zoomReset) {
    zoomReset.addEventListener('click', () => {
      setMapScale(1);
    });
  }

  if (canvasHost) {
    canvasHost.addEventListener('wheel', (event) => {
      event.preventDefault();
      const nextScale = event.deltaY < 0 ? mapViewportState.scale * 1.08 : mapViewportState.scale / 1.08;
      setMapScale(nextScale);
    }, { passive: false });
  }

  applyMapScale();
}

function ensureStageStructure(stage) {
  if (mapRenderState.stageReady && mapRenderState.stage === stage) {
    return;
  }

  stage.innerHTML = '';

  const canvas = document.createElement('canvas');
  canvas.id = 'map-grid-canvas';
  canvas.className = 'map-grid-canvas';
  canvas.width = 800;
  canvas.height = 800;
  stage.appendChild(canvas);

  const pointsLayer = document.createElement('div');
  pointsLayer.className = 'map-points-layer';
  stage.appendChild(pointsLayer);

  const robotMarker = document.createElement('div');
  robotMarker.className = 'robot-marker';
  stage.appendChild(robotMarker);

  const robotHeading = document.createElement('div');
  robotHeading.className = 'robot-heading';
  stage.appendChild(robotHeading);

  mapRenderState.stageReady = true;
  mapRenderState.rasterSignature = '';
  mapRenderState.pointsSignature = '';
  mapRenderState.stage = stage;
  mapRenderState.canvas = canvas;
  mapRenderState.pointsLayer = pointsLayer;
  mapRenderState.robotMarker = robotMarker;
  mapRenderState.robotHeading = robotHeading;
}

function drawMapRaster(map) {
  const canvas = mapRenderState.canvas;
  if (!canvas) {
    return;
  }

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

function mapSignature(map) {
  return [
    Number(map.width || 0),
    Number(map.height || 0),
    Number(map.resolution || 0),
    Number(map.origin_x || 0),
    Number(map.origin_y || 0),
    Array.isArray(map.occupancy_data) ? map.occupancy_data.length : 0,
  ].join('|');
}

function pointsSignature(points) {
  return (Array.isArray(points) ? points : []).map((point) => [
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

function renderPoints(map, points) {
  if (!mapRenderState.pointsLayer) {
    return;
  }

  mapRenderState.pointsLayer.innerHTML = '';
  (points || []).forEach((point) => {
    const position = worldToPercent(map, Number(point.x || 0), Number(point.y || 0));
    const node = document.createElement('div');
    node.className = point.type === 'charge'
      ? 'map-point charge-point'
      : point.type === 'initial'
        ? 'map-point initial-point'
        : point.type === 'nav'
          ? 'map-point nav-point'
          : 'map-point feed-point';
    node.textContent = point.name;
    node.style.cssText = positionStyle(position);
    mapRenderState.pointsLayer.appendChild(node);
  });
}

function updateRobotPose(map, pose) {
  if (!mapRenderState.robotMarker || !mapRenderState.robotHeading) {
    return;
  }

  const position = worldToPercent(map, Number(pose.x || 0), Number(pose.y || 0));
  mapRenderState.robotMarker.style.cssText = positionStyle(position);
  mapRenderState.robotHeading.style.cssText = `${positionStyle(position)}transform: rotate(${Number(pose.theta || 0)}rad);`;
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

  bindMapZoomControls();
  ensureStageStructure(stage);

  const state = window.fishbotStore.getState();
  const map = state.map || {};
  const points = state.points || [];
  const pose = (state.robot && state.robot.pose) || {};

  const nextMapSignature = mapSignature(map);
  if (nextMapSignature !== mapRenderState.rasterSignature) {
    drawMapRaster(map);
    mapRenderState.rasterSignature = nextMapSignature;
  }

  const nextPointsSignature = pointsSignature(points);
  if (nextPointsSignature !== mapRenderState.pointsSignature) {
    renderPoints(map, points);
    mapRenderState.pointsSignature = nextPointsSignature;
  }

  updateRobotPose(map, pose);
  updateMapNote(map);
  applyMapScale();
};
