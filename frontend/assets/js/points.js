document.addEventListener('DOMContentLoaded', async () => {
  const pointList = document.getElementById('point-list');
  if (!pointList || !window.fishbotApi) {
    return;
  }

  const points = await (window.fishbotApi.getPoints ? window.fishbotApi.getPoints() : []);
  pointList.innerHTML = points.map((point) => (
    `<div class="metric-card"><span>${point.type}</span><strong>${point.name}</strong></div>`
  )).join('');
});
