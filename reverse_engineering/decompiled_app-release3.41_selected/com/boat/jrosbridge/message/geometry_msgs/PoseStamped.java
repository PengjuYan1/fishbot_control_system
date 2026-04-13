package com.boat.jrosbridge.message.geometry_msgs;
public class PoseStamped extends com.boat.jrosbridge.message.Message {
    public com.boat.jrosbridge.message.std_msgs.Header header;
    public com.boat.jrosbridge.message.geometry_msgs.Pose pose;

    public PoseStamped()
    {
        return;
    }

    public com.boat.jrosbridge.message.std_msgs.Header getHeader()
    {
        return this.header;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Pose getPose()
    {
        return this.pose;
    }

    public void setHeader(com.boat.jrosbridge.message.std_msgs.Header p1)
    {
        this.header = p1;
        return;
    }

    public void setPose(com.boat.jrosbridge.message.geometry_msgs.Pose p1)
    {
        this.pose = p1;
        return;
    }
}
