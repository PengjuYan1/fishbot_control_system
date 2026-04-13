package com.boat.jrosbridge.message.std_msgs;
public class Int64 extends com.boat.jrosbridge.message.Message {
    public long data;

    public Int64()
    {
        return;
    }

    public long getData()
    {
        return this.data;
    }

    public void setData(long p1)
    {
        this.data = p1;
        return;
    }
}
