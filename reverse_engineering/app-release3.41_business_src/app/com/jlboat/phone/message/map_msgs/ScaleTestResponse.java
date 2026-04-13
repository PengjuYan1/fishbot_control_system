package com.jlboat.phone.message.map_msgs;
public class ScaleTestResponse extends com.boat.jrosbridge.message.Message {
    public int status;

    public ScaleTestResponse()
    {
        return;
    }

    public int getStatus()
    {
        return this.status;
    }

    public void setStatus(int p1)
    {
        this.status = p1;
        return;
    }
}
