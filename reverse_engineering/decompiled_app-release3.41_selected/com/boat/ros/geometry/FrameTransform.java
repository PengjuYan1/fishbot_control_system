package com.boat.ros.geometry;
public class FrameTransform {
    private final org.ros.namespace.GraphName source;
    private final org.ros.namespace.GraphName target;
    private final com.boat.jrosbridge.message.Time time;
    private final com.boat.ros.geometry.Transform transform;

    public FrameTransform(com.boat.ros.geometry.Transform p2, org.ros.namespace.GraphName p3, org.ros.namespace.GraphName p4, com.boat.jrosbridge.message.Time p5)
    {
        this.transform = p2;
        this.source = p3.toRelative();
        this.target = p4.toRelative();
        this.time = p5;
        return;
    }

    public static com.boat.ros.geometry.FrameTransform fromTransformStampedMessage(com.boat.jrosbridge.message.geometry_msgs.TransformStamped p7)
    {
        return new com.boat.ros.geometry.FrameTransform(com.boat.ros.geometry.Transform.fromTransformMessage(p7.getTransform()), org.ros.namespace.GraphName.of(p7.getChildFrameId()), org.ros.namespace.GraphName.of(p7.getHeader().getFrameId()), p7.getHeader().getStamp());
    }

    public boolean equals(Object p6)
    {
        if (this != p6) {
            if (p6 != null) {
                if (this.getClass() == p6.getClass()) {
                    if (this.source != null) {
                        if (!this.source.equals(((com.boat.ros.geometry.FrameTransform) p6).source)) {
                            return 0;
                        }
                    } else {
                        if (((com.boat.ros.geometry.FrameTransform) p6).source != null) {
                            return 0;
                        }
                    }
                    if (this.target != null) {
                        if (!this.target.equals(((com.boat.ros.geometry.FrameTransform) p6).target)) {
                            return 0;
                        }
                    } else {
                        if (((com.boat.ros.geometry.FrameTransform) p6).target != null) {
                            return 0;
                        }
                    }
                    if (this.time != null) {
                        if (!this.time.equals(((com.boat.ros.geometry.FrameTransform) p6).time)) {
                            return 0;
                        }
                    } else {
                        if (((com.boat.ros.geometry.FrameTransform) p6).time != null) {
                            return 0;
                        }
                    }
                    if (this.transform != null) {
                        if (!this.transform.equals(((com.boat.ros.geometry.FrameTransform) p6).transform)) {
                            return 0;
                        }
                    } else {
                        if (((com.boat.ros.geometry.FrameTransform) p6).transform != null) {
                            return 0;
                        }
                    }
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }

    public org.ros.namespace.GraphName getSourceFrame()
    {
        return this.source;
    }

    public org.ros.namespace.GraphName getTargetFrame()
    {
        return this.target;
    }

    public com.boat.jrosbridge.message.Time getTime()
    {
        return this.time;
    }

    public com.boat.ros.geometry.Transform getTransform()
    {
        return this.transform;
    }

    public com.boat.ros.geometry.FrameTransform invert()
    {
        return new com.boat.ros.geometry.FrameTransform(this.transform.invert(), this.target, this.source, this.time);
    }

    public String toString()
    {
        org.ros.namespace.GraphName v1 = this.target;
        com.boat.ros.geometry.Transform v2 = this.transform;
        com.boat.jrosbridge.message.Time v3 = this.time;
        Object[] v4_1 = new Object[4];
        v4_1[0] = this.source;
        v4_1[1] = v1;
        v4_1[2] = v2;
        v4_1[3] = v3;
        return String.format("FrameTransform<Source: %s, Target: %s, %s, Time: %s>", v4_1);
    }

    public com.boat.jrosbridge.message.geometry_msgs.TransformStamped toTransformStampedMessage(com.boat.jrosbridge.message.geometry_msgs.TransformStamped p3)
    {
        p3.getHeader().setFrameId(this.target.toString());
        p3.getHeader().setStamp(this.time);
        p3.setChildFrameId(this.source.toString());
        this.transform.toTransformMessage(p3.getTransform());
        return p3;
    }
}
