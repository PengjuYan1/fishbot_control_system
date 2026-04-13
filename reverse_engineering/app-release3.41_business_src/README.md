# app-release3.41 business source snapshot

This folder is a curated subset of the decompiled APK focused on business logic and ROS communication.

Included:
- `app/com/jlboat/phone`: main app code
- `core/com/boat/*`: support framework, ROS bridge, SLAM interfaces
- `ros_msgs/*`: app-specific ROS message wrappers
- `ros_deps/org/ros`: ROS Java dependencies referenced by the app
- `manifest/AndroidManifest.decoded.xml`: decoded manifest

Excluded on purpose:
- `androidx/`, `android/support/`, `com/google/` and other standard third-party/runtime packages
- non-Java bytecode dumps like `*.ag`
- raw resources except the decoded manifest
