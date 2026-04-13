package com.jlboat.phone.message.map_msgs;
public class SetGlobalPlanResponse extends com.boat.jrosbridge.message.Message {
    public boolean result;

    public SetGlobalPlanResponse()
    {
        return;
    }

    public boolean isResult()
    {
        return this.result;
    }

    public void setResult(boolean p1)
    {
        this.result = p1;
        return;
    }
}
