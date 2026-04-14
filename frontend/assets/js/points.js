document.addEventListener('DOMContentLoaded', async () => {
  const pointList = document.getElementById('point-list');
  const pointCanvas = document.getElementById('point-canvas');
  const selectionStatus = document.getElementById('selection-status');
  const nameInput = document.getElementById('point-name');
  const xInput = document.getElementById('point-x');
  const yInput = document.getElementById('point-y');
  const thetaInput = document.getElementById('point-theta');
  const floorIdInput = document.getElementById('point-floor-id');
  const mapIdInput = document.getElementById('point-map-id');
  const pointIdInput = document.getElementById('point-point-id');
  const saveFeedButton = document.getElementById('save-feed-point');
  const saveChargeButton = document.getElementById('save-charge-point');

  if (!pointList || !window.fishbotApi) {
    return;
  }

  const renderPoints = async () => {
    const points = await (window.fishbotApi.getPoints ? window.fishbotApi.getPoints() : []);
    pointList.innerHTML = points.map((point) => (
      `<div class="metric-card">
        <span>${point.type}</span>
        <strong>${point.name}</strong>
        <small>x=${Number(point.x || 0).toFixed(2)} y=${Number(point.y || 0).toFixed(2)} theta=${Number(point.theta || 0).toFixed(2)}</small>
        <small>floor_id=${point.floor_id || 0} map_id=${point.map_id || 0} point_id=${point.point_id || 0}</small>
      </div>`
    )).join('');
  };

  const collectPayload = () => ({
    name: nameInput.value.trim(),
    x: xInput.value || '0',
    y: yInput.value || '0',
    theta: thetaInput.value || '0',
    floor_id: floorIdInput.value || '0',
    map_id: mapIdInput.value || '0',
    point_id: pointIdInput.value || '0',
  });

  const savePoint = async (type) => {
    const payload = collectPayload();
    if (!payload.name) {
      selectionStatus.textContent = '请先填写点位名称';
      return;
    }

    if (window.fishbotApi.createPoint) {
      await window.fishbotApi.createPoint(type, payload);
    }
    selectionStatus.textContent = `已保存${type === 'feed' ? '投喂' : '充电'}点：${payload.name}`;
    await renderPoints();
  };

  if (pointCanvas) {
    pointCanvas.addEventListener('click', (event) => {
      const rect = pointCanvas.getBoundingClientRect();
      const relativeX = (event.clientX - rect.left) / rect.width;
      const relativeY = (event.clientY - rect.top) / rect.height;
      const x = (relativeX * 20).toFixed(2);
      const y = ((1 - relativeY) * 20).toFixed(2);
      xInput.value = x;
      yInput.value = y;
      selectionStatus.textContent = `已拾取坐标 x=${x} y=${y}，请继续填写 theta / floor_id / map_id / point_id`;
    });
  }

  if (saveFeedButton) {
    saveFeedButton.addEventListener('click', async () => savePoint('feed'));
  }

  if (saveChargeButton) {
    saveChargeButton.addEventListener('click', async () => savePoint('charge'));
  }

  await renderPoints();
});
