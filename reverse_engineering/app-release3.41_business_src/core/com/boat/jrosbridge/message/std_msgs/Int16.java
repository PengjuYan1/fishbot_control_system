package com.boat.jrosbridge.message.std_msgs;
public class Int16 extends com.boat.jrosbridge.message.Message {
    public short data;

    public Int16()
    {
        return;
    }

    public short getData()
    {
        return this.data;
    }

    public void setData(short p1)
    {
        this.data = p1;
        return;
    }
}
