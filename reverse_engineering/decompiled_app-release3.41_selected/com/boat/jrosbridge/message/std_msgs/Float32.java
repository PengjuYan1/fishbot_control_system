package com.boat.jrosbridge.message.std_msgs;
public class Float32 extends com.boat.jrosbridge.message.Message {
    public float data;

    public Float32()
    {
        return;
    }

    public float getData()
    {
        return this.data;
    }

    public void setData(float p1)
    {
        this.data = p1;
        return;
    }
}
