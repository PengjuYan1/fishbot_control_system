package com.jlboat.phone.message.map_msgs;
public class SetShapeResponse extends com.boat.jrosbridge.message.Message {
    public boolean success;

    public SetShapeResponse()
    {
        return;
    }

    public boolean isSuccess()
    {
        return this.success;
    }

    public void setSuccess(boolean p1)
    {
        this.success = p1;
        return;
    }
}
