package com.jlboat.phone.message.map_msgs;
public class SetInt64Request extends com.boat.jrosbridge.message.Message {
    public long data;

    public SetInt64Request()
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
