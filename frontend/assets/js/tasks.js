document.addEventListener('DOMContentLoaded', async () => {
  const scheduleList = document.getElementById('schedule-list');
  const scheduleForm = document.getElementById('schedule-form');

  if (!scheduleList || !window.fishbotApi) {
    return;
  }

  const renderSchedules = async () => {
    const schedules = await (window.fishbotApi.getSchedules ? window.fishbotApi.getSchedules() : []);
    scheduleList.innerHTML = schedules.map((schedule) => (
      `<div class="metric-card"><span>${schedule.cron}</span><strong>${schedule.name}</strong></div>`
    )).join('');
  };

  if (scheduleForm && window.fishbotApi.createSchedule) {
    scheduleForm.addEventListener('submit', async (event) => {
      event.preventDefault();
      const formData = new FormData(scheduleForm);
      const body = new URLSearchParams({
        name: formData.get('name'),
        cron: formData.get('cron'),
        enabled: formData.get('enabled') ? '1' : '0',
      });
      await window.fishbotApi.createSchedule(body.toString());
      await renderSchedules();
    });
  }

  await renderSchedules();
});
