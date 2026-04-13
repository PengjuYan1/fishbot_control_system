package com.boat.jrosbridge.message.std_msgs;
public class ColorRGBA extends com.boat.jrosbridge.message.Message {
    public float a;
    public float b;
    public float g;
    public float r;

    public ColorRGBA()
    {
        return;
    }

    public float getA()
    {
        return this.a;
    }

    public float getB()
    {
        return this.b;
    }

    public float getG()
    {
        return this.g;
    }

    public float getR()
    {
        return this.r;
    }

    public void setA(float p1)
    {
        this.a = p1;
        return;
    }

    public void setB(float p1)
    {
        this.b = p1;
        return;
    }

    public void setG(float p1)
    {
        this.g = p1;
        return;
    }

    public void setR(float p1)
    {
        this.r = p1;
        return;
    }
}
