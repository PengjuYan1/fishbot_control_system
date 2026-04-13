package com.jlboat.phone.message.map_msgs;
public class NavigationCreamSetListResponse extends com.boat.jrosbridge.message.Message {
    public long op;

    public NavigationCreamSetListResponse()
    {
        return;
    }

    public long getOp()
    {
        return this.op;
    }

    public void setOp(long p1)
    {
        this.op = p1;
        return;
    }
}
