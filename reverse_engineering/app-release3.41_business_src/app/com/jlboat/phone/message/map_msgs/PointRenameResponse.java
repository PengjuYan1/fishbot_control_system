package com.jlboat.phone.message.map_msgs;
public class PointRenameResponse extends com.boat.jrosbridge.message.Message {
    long result;

    public PointRenameResponse()
    {
        return;
    }

    public long getResult()
    {
        return this.result;
    }

    public void setResult(long p1)
    {
        this.result = p1;
        return;
    }
}
