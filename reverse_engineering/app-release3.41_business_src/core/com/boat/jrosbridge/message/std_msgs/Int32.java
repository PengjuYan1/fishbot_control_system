package com.boat.jrosbridge.message.std_msgs;
public class Int32 extends com.boat.jrosbridge.message.Message {
    public int data;

    public Int32()
    {
        return;
    }

    public int getData()
    {
        return this.data;
    }

    public void setData(int p1)
    {
        this.data = p1;
        return;
    }
}
