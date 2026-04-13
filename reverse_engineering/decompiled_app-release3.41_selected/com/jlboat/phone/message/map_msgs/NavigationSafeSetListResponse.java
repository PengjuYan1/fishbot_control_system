package com.jlboat.phone.message.map_msgs;
public class NavigationSafeSetListResponse extends com.boat.jrosbridge.message.Message {
    public long op;

    public NavigationSafeSetListResponse()
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
