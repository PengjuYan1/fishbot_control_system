# Reverse Engineering Notes

This directory stores the APK reverse-engineering material used to verify the real robot ROS interfaces.

## Included Content

- `app-release3.41_business_src/`
  - cleaned business-oriented decompiled source
  - this is the main reference used during interface matching and behavior verification
- `decompiled_app-release3.41_selected/`
  - selected packages extracted from the larger raw decompile tree
  - includes the most relevant control and ROS bridge code:
    - `com/jlboat/`
    - `com/boat/`
    - `cartographer_ros_msgs/`

## Why The Full Raw Tree Is Not Stored Here

The original raw decompile output under `/home/ypj/decompiled_app-release3.41` is much larger and contains a large amount of Android framework, Kotlin runtime, and third-party library code. That material adds a lot of repository weight but does not materially help with robot interface verification, so this repository keeps the useful subset instead.

## Main Files Used For Current Interface Validation

- `app-release3.41_business_src/app/com/jlboat/phone/activity/MapActivity.java`
- `app-release3.41_business_src/app/com/jlboat/phone/controller/JlNaviManager.java`
- `app-release3.41_business_src/app/com/jlboat/phone/view/JoystickView.java`
- `app-release3.41_business_src/app/com/jlboat/phone/util/TopicNames.java`
- `app-release3.41_business_src/app/com/jlboat/phone/util/ServiceNames.java`

## Current Practical Conclusion

The APK confirms that manual remote driving is based on continuous `cmd_vel` publishing, while navigation stop and mode switching are handled separately. That conclusion is the basis for the current C++ web control implementation and later live debugging work.
