const fs = require('fs');

function assert(condition, message) {
  if (!condition) {
    throw new Error(message);
  }
}

const indexHtml = fs.readFileSync('/home/ypj/fishbot_control_system/frontend/index.html', 'utf8');
const dashboardJs = fs.readFileSync('/home/ypj/fishbot_control_system/frontend/assets/js/dashboard.js', 'utf8');
const manualControlJs = fs.readFileSync('/home/ypj/fishbot_control_system/frontend/assets/js/manual-control.js', 'utf8');

assert(
  indexHtml.includes('id="undock-button"'),
  'expected dashboard to define an explicit undock button'
);
assert(
  indexHtml.includes('class="dpad-button" data-drive-direction="f"'),
  'expected dashboard to expose a forward dpad control'
);
assert(
  indexHtml.includes('data-drive-direction="s"') &&
    indexHtml.includes('id="drive-stop-center"'),
  'expected dashboard to expose a stop dpad control'
);
assert(
  indexHtml.includes('id="manual-linear-speed"'),
  'expected dashboard to expose a linear speed slider'
);
assert(
  indexHtml.includes('id="manual-angular-speed"'),
  'expected dashboard to expose an angular speed slider'
);
assert(
  indexHtml.includes('assets/js/manual-control.js'),
  'expected dashboard page to load the dedicated manual control frontend module'
);
assert(
  !indexHtml.includes('manual-joystick-base'),
  'expected dashboard to remove the old joystick container'
);
assert(
  manualControlJs.includes("data-drive-direction"),
  'expected manual control frontend to bind dpad events'
);
assert(
  manualControlJs.includes('manual-linear-speed') &&
    manualControlJs.includes('manual-angular-speed'),
  'expected manual control frontend to bind speed sliders'
);
assert(
  manualControlJs.includes('ready_for_drive') &&
    manualControlJs.includes('driving'),
  'expected manual control flow to react to backend control phases'
);
assert(
  manualControlJs.includes('keydown') &&
    manualControlJs.includes('keyup'),
  'expected manual control frontend to support keyboard drive shortcuts'
);
assert(
  manualControlJs.includes('undock-button') &&
    manualControlJs.includes('undockFromChargePile'),
  'expected dashboard to call the explicit undock control path'
);
assert(
  dashboardJs.includes('startMapping') &&
    !dashboardJs.includes('undockFromChargePile'),
  'expected dashboard script to keep map/task logic and leave manual control to the dedicated frontend module'
);
