package com.jlboat.phone.message.map_msgs;
public class SetEraserModeResponse extends com.boat.jrosbridge.message.Message {
    public int status;

    public SetEraserModeResponse()
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
