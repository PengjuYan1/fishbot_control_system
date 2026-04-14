const fs = require('fs');

function assert(condition, message) {
  if (!condition) {
    throw new Error(message);
  }
}

const indexHtml = fs.readFileSync('/home/ypj/fishbot_control_system/frontend/index.html', 'utf8');
const apiJs = fs.readFileSync('/home/ypj/fishbot_control_system/frontend/assets/js/api.js', 'utf8');
const dashboardJs = fs.readFileSync('/home/ypj/fishbot_control_system/frontend/assets/js/dashboard.js', 'utf8');

assert(
  apiJs.includes("'/api/points/delete'"),
  'expected frontend api to expose point delete endpoint'
);
assert(
  apiJs.includes('deletePoint('),
  'expected frontend api to expose deletePoint method'
);
assert(
  indexHtml.includes('id="point-list-panel"'),
  'expected dashboard to define a point list management panel'
);
assert(
  dashboardJs.includes('deletePoint('),
  'expected dashboard to trigger point deletion'
);
assert(
  dashboardJs.includes('point-list-panel'),
  'expected dashboard to bind point list panel events'
);
