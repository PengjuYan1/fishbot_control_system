package com.boat.jrosbridge.message.geometry_msgs;
public class Point32 extends com.boat.jrosbridge.message.Message {
    public float x;
    public float y;
    public float z;

    public Point32()
    {
        return;
    }

    public float getX()
    {
        return this.x;
    }

    public float getY()
    {
        return this.y;
    }

    public float getZ()
    {
        return this.z;
    }

    public void setX(float p1)
    {
        this.x = p1;
        return;
    }

    public void setY(float p1)
    {
        this.y = p1;
        return;
    }

    public void setZ(float p1)
    {
        this.z = p1;
        return;
    }
}
