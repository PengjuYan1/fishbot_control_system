const fs = require('fs');

function assert(condition, message) {
  if (!condition) {
    throw new Error(message);
  }
}

const dashboardJs = fs.readFileSync('/home/ypj/fishbot_control_system/frontend/assets/js/dashboard.js', 'utf8');

assert(
  dashboardJs.includes('history 50') || dashboardJs.includes('历史结果 50') || dashboardJs.includes('仍在充电态'),
  'expected dashboard to distinguish historical out-of-charge success from current charging state'
);
assert(
  dashboardJs.includes('charge_status_code') && dashboardJs.includes('out_of_charge_result_code'),
  'expected dashboard out-of-charge display to consider both charge status and result code'
);
assert(
  dashboardJs.includes('requestUndockAssist'),
  'expected dashboard to keep retrying out-of-charge while waiting for undock'
);
