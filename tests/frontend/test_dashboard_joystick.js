const fs = require('fs');

function assert(condition, message) {
  if (!condition) {
    throw new Error(message);
  }
}

const indexHtml = fs.readFileSync('/home/ypj/fishbot_control_system/frontend/index.html', 'utf8');
const dashboardJs = fs.readFileSync('/home/ypj/fishbot_control_system/frontend/assets/js/dashboard.js', 'utf8');

assert(
  indexHtml.includes('id="manual-joystick-base"'),
  'expected dashboard to define a joystick base container'
);
assert(
  indexHtml.includes('id="manual-joystick-knob"'),
  'expected dashboard to define a joystick knob element'
);
assert(
  !indexHtml.includes('class="drive-button" data-linear='),
  'expected dashboard to remove the old directional drive buttons'
);
assert(
  dashboardJs.includes('manual-joystick-base'),
  'expected dashboard controller to bind joystick base events'
);
assert(
  dashboardJs.includes('manual-joystick-knob'),
  'expected dashboard controller to bind joystick knob events'
);

