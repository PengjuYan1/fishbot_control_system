package com.boat.jrosbridge.message.geometry_msgs;
public class Pose extends com.boat.jrosbridge.message.Message {
    public com.boat.jrosbridge.message.geometry_msgs.Quaternion orientation;
    public com.boat.jrosbridge.message.geometry_msgs.Point position;

    public Pose()
    {
        return;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Quaternion getOrientation()
    {
        return this.orientation;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Point getPosition()
    {
        return this.position;
    }

    public void setOrientation(com.boat.jrosbridge.message.geometry_msgs.Quaternion p1)
    {
        this.orientation = p1;
        return;
    }

    public void setPosition(com.boat.jrosbridge.message.geometry_msgs.Point p1)
    {
        this.position = p1;
        return;
    }
}
