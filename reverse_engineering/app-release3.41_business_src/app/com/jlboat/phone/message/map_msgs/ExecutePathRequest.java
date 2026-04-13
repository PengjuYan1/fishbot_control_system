package com.jlboat.phone.message.map_msgs;
public class ExecutePathRequest extends com.boat.jrosbridge.message.Message {
    public long op;

    public ExecutePathRequest()
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
