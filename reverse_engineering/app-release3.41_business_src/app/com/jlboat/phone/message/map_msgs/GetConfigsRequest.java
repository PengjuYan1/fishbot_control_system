package com.jlboat.phone.message.map_msgs;
public class GetConfigsRequest extends com.boat.jrosbridge.message.Message {
    public int type;

    public GetConfigsRequest()
    {
        return;
    }

    public int getType()
    {
        return this.type;
    }

    public void setType(int p1)
    {
        this.type = p1;
        return;
    }
}
