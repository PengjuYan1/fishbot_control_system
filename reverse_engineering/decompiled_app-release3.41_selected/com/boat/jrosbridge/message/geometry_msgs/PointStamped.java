package com.boat.jrosbridge.message.geometry_msgs;
public class PointStamped extends com.boat.jrosbridge.message.Message {
    public com.boat.jrosbridge.message.std_msgs.Header header;
    public com.boat.jrosbridge.message.geometry_msgs.Point point;

    public PointStamped()
    {
        return;
    }

    public com.boat.jrosbridge.message.std_msgs.Header getHeader()
    {
        return this.header;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Point getPoint()
    {
        return this.point;
    }

    public void setHeader(com.boat.jrosbridge.message.std_msgs.Header p1)
    {
        this.header = p1;
        return;
    }

    public void setPoint(com.boat.jrosbridge.message.geometry_msgs.Point p1)
    {
        this.point = p1;
        return;
    }
}
