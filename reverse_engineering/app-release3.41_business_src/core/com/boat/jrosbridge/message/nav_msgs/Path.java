package com.boat.jrosbridge.message.nav_msgs;
public class Path extends com.boat.jrosbridge.message.Message {
    public com.boat.jrosbridge.message.std_msgs.Header header;
    public com.boat.jrosbridge.message.geometry_msgs.PoseStamped[] poses;

    public Path()
    {
        return;
    }

    public com.boat.jrosbridge.message.std_msgs.Header getHeader()
    {
        return this.header;
    }

    public com.boat.jrosbridge.message.geometry_msgs.PoseStamped[] getPoses()
    {
        return this.poses;
    }

    public void setHeader(com.boat.jrosbridge.message.std_msgs.Header p1)
    {
        this.header = p1;
        return;
    }

    public void setPoses(com.boat.jrosbridge.message.geometry_msgs.PoseStamped[] p1)
    {
        this.poses = p1;
        return;
    }
}
