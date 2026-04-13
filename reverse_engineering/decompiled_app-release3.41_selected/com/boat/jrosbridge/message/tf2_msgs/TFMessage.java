package com.boat.jrosbridge.message.tf2_msgs;
public class TFMessage extends com.boat.jrosbridge.message.Message {
    public com.boat.jrosbridge.message.geometry_msgs.TransformStamped[] transforms;

    public TFMessage()
    {
        return;
    }

    public com.boat.jrosbridge.message.geometry_msgs.TransformStamped[] getTransforms()
    {
        return this.transforms;
    }

    public void setTransforms(com.boat.jrosbridge.message.geometry_msgs.TransformStamped[] p1)
    {
        this.transforms = p1;
        return;
    }
}
