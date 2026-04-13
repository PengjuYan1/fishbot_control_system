package com.boat.jrosbridge.message.std_msgs;
public class MultiArrayDimension extends com.boat.jrosbridge.message.Message {
    public String label;
    public int size;
    public int stride;

    public MultiArrayDimension()
    {
        return;
    }

    public String getLabel()
    {
        return this.label;
    }

    public int getSize()
    {
        return this.size;
    }

    public int getStride()
    {
        return this.stride;
    }

    public void setLabel(String p1)
    {
        this.label = p1;
        return;
    }

    public void setSize(int p1)
    {
        this.size = p1;
        return;
    }

    public void setStride(int p1)
    {
        this.stride = p1;
        return;
    }
}
