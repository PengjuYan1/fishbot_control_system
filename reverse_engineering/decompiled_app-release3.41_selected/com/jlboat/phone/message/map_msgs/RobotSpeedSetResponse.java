package com.jlboat.phone.message.map_msgs;
public class RobotSpeedSetResponse extends com.boat.jrosbridge.message.Message {
    public long result;

    public RobotSpeedSetResponse()
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
