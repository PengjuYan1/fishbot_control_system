package com.jlboat.phone.message.map_msgs;
public class SetModeRequest extends com.boat.jrosbridge.message.Message {
    public long mode;

    public SetModeRequest()
    {
        return;
    }

    public long getMode()
    {
        return this.mode;
    }

    public void setMode(long p1)
    {
        this.mode = p1;
        return;
    }
}
