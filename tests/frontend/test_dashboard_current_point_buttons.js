const fs = require('fs');

function assert(condition, message) {
  if (!condition) {
    throw new Error(message);
  }
}

const dashboardJs = fs.readFileSync('/home/ypj/fishbot_control_system/frontend/assets/js/dashboard.js', 'utf8');
const apiJs = fs.readFileSync('/home/ypj/fishbot_control_system/frontend/assets/js/api.js', 'utf8');

assert(
  apiJs.includes("'/api/points/charge/current'"),
  'expected frontend api to expose current charge point creation endpoint'
);
assert(
  apiJs.includes("'/api/points/feed/current'"),
  'expected frontend api to expose current feed point creation endpoint'
);
assert(
  dashboardJs.includes('createCurrentChargePoint'),
  'expected dashboard to call current charge point creation'
);
assert(
  dashboardJs.includes('createCurrentFeedPoint'),
  'expected dashboard to call current feed point creation'
);
assert(
  !dashboardJs.includes("window.location.href = 'map.html'"),
  'expected dashboard buttons to stop redirecting to map editor'
);

