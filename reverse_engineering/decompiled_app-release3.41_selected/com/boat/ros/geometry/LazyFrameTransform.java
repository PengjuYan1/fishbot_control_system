package com.boat.ros.geometry;
public class LazyFrameTransform {
    private com.boat.ros.geometry.FrameTransform frameTransform;
    private final com.boat.jrosbridge.message.geometry_msgs.TransformStamped message;
    private final Object mutex;

    public LazyFrameTransform(com.boat.jrosbridge.message.geometry_msgs.TransformStamped p2)
    {
        this.mutex = new Object();
        this.message = p2;
        return;
    }

    LazyFrameTransform(com.boat.ros.geometry.FrameTransform p2)
    {
        this.mutex = new Object();
        this.message = 0;
        this.frameTransform = p2;
        return;
    }

    public com.boat.ros.geometry.FrameTransform get()
    {
        if (this.frameTransform == null) {
            this.frameTransform = com.boat.ros.geometry.FrameTransform.fromTransformStampedMessage(this.message);
            return this.frameTransform;
        } else {
            return this.frameTransform;
        }
    }
}
