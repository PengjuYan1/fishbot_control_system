package com.boat.jrosbridge.message.geometry_msgs;
public class TransformStamped extends com.boat.jrosbridge.message.Message {
    public String child_frame_id;
    public com.boat.jrosbridge.message.std_msgs.Header header;
    public com.boat.jrosbridge.message.geometry_msgs.Transform transform;

    public TransformStamped()
    {
        return;
    }

    public String getChildFrameId()
    {
        return this.child_frame_id;
    }

    public com.boat.jrosbridge.message.std_msgs.Header getHeader()
    {
        return this.header;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Transform getTransform()
    {
        return this.transform;
    }

    public void setChildFrameId(String p1)
    {
        this.child_frame_id = p1;
        return;
    }

    public void setHeader(com.boat.jrosbridge.message.std_msgs.Header p1)
    {
        this.header = p1;
        return;
    }

    public void setTransform(com.boat.jrosbridge.message.geometry_msgs.Transform p1)
    {
        this.transform = p1;
        return;
    }
}
