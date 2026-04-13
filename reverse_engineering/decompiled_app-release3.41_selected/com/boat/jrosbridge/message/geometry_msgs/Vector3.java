package com.boat.jrosbridge.message.geometry_msgs;
public class Vector3 extends com.boat.jrosbridge.message.Message {
    public double x;
    public double y;
    public double z;

    public Vector3()
    {
        return;
    }

    public double getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }

    public double getZ()
    {
        return this.z;
    }

    public void setX(double p1)
    {
        this.x = p1;
        return;
    }

    public void setY(double p1)
    {
        this.y = p1;
        return;
    }

    public void setZ(double p1)
    {
        this.z = p1;
        return;
    }
}
