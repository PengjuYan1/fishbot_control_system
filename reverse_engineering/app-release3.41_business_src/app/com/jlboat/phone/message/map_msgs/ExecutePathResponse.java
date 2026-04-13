package com.jlboat.phone.message.map_msgs;
public class ExecutePathResponse extends com.boat.jrosbridge.message.Message {
    public long result;

    public ExecutePathResponse()
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
