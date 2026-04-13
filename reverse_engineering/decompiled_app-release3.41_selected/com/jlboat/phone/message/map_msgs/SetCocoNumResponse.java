package com.jlboat.phone.message.map_msgs;
public class SetCocoNumResponse extends com.boat.jrosbridge.message.Message {
    public int result;

    public SetCocoNumResponse()
    {
        return;
    }

    public int getResult()
    {
        return this.result;
    }

    public void setResult(int p1)
    {
        this.result = p1;
        return;
    }
}
