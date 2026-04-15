const fs = require('fs');
const vm = require('vm');

function assert(condition, message) {
  if (!condition) {
    throw new Error(message);
  }
}

const source = fs.readFileSync('/home/ypj/fishbot_control_system/frontend/assets/js/store.js', 'utf8');
const context = {
  window: {},
  console,
};
context.global = context;
vm.createContext(context);
vm.runInContext(source, context, { filename: 'store.js' });

const store = context.window.fishbotStore;
assert(store, 'expected fishbotStore to be defined');

let emitCount = 0;
store.subscribe(() => {
  emitCount += 1;
});

const basePoint = {
  id: 7,
  name: 'N1',
  type: 'nav',
  x: 1.2,
  y: -0.4,
  theta: 0.25,
  floor_id: 1,
  map_id: 2,
  point_id: 3,
};

store.setPoints([basePoint]);
assert(emitCount === 1, `expected first point write to emit once, got ${emitCount}`);
store.setPoints([{ ...basePoint }]);
assert(emitCount === 1, 'expected identical point payload to avoid redundant emit');
store.setPoints([{ ...basePoint, name: 'N2' }]);
assert(emitCount === 2, 'expected changed point payload to emit');

const baseMap = {
  floor_id: 1,
  map_id: 2,
  map_name: 'pond-a',
  charge_id: 11,
  initial_id: 12,
  is_default_floor: true,
  is_default_map: true,
};

store.setMaps([baseMap]);
assert(emitCount === 3, 'expected first map write to emit');
store.setMaps([{ ...baseMap }]);
assert(emitCount === 3, 'expected identical map payload to avoid redundant emit');
store.setMaps([{ ...baseMap, map_name: 'pond-b' }]);
assert(emitCount === 4, 'expected changed map payload to emit');

store.setRobotPose({ x: 1, y: 2, theta: 3 });
assert(emitCount === 5, 'expected first pose write to emit');
store.setRobotPose({ x: 1, y: 2, theta: 3 });
assert(emitCount === 5, 'expected identical pose to avoid redundant emit');
store.setRobotPose({ x: 1, y: 2, theta: 3.1 });
assert(emitCount === 6, 'expected changed pose to emit');
