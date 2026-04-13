package com.jlboat.phone.message.map_msgs;
public class ErasePose extends com.boat.jrosbridge.message.Message {
    public double x;
    public double y;

    public ErasePose()
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
}
