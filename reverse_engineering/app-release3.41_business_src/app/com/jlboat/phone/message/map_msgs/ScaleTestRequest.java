package com.jlboat.phone.message.map_msgs;
public class ScaleTestRequest extends com.boat.jrosbridge.message.Message {
    public int type;
    public int value;

    public ScaleTestRequest()
    {
        return;
    }

    public int getType()
    {
        return this.type;
    }

    public int getValue()
    {
        return this.value;
    }

    public void setType(int p1)
    {
        this.type = p1;
        return;
    }

    public void setValue(int p1)
    {
        this.value = p1;
        return;
    }
}
