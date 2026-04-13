package com.boat.jrosbridge.message.geometry_msgs;
public class Twist extends com.boat.jrosbridge.message.Message {
    public com.boat.jrosbridge.message.geometry_msgs.Vector3 angular;
    public com.boat.jrosbridge.message.geometry_msgs.Vector3 linear;

    public Twist()
    {
        return;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Vector3 getAngular()
    {
        return this.angular;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Vector3 getLinear()
    {
        return this.linear;
    }

    public void setAngular(com.boat.jrosbridge.message.geometry_msgs.Vector3 p1)
    {
        this.angular = p1;
        return;
    }

    public void setLinear(com.boat.jrosbridge.message.geometry_msgs.Vector3 p1)
    {
        this.linear = p1;
        return;
    }
}
