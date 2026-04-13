package com.boat.jrosbridge.message.geometry_msgs;
public class Quaternion extends com.boat.jrosbridge.message.Message {
    public double w;
    public double x;
    public double y;
    public double z;

    public Quaternion()
    {
        return;
    }

    public double getW()
    {
        return this.w;
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

    public void setW(double p1)
    {
        this.w = p1;
        return;
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
