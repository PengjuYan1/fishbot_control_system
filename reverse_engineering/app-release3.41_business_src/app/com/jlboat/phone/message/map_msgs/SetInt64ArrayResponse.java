package com.jlboat.phone.message.map_msgs;
public class SetInt64ArrayResponse extends com.boat.jrosbridge.message.Message {
    public String message;
    public boolean success;

    public SetInt64ArrayResponse()
    {
        return;
    }

    public String getMessage()
    {
        return this.message;
    }

    public boolean isSuccess()
    {
        return this.success;
    }

    public void setMessage(String p1)
    {
        this.message = p1;
        return;
    }

    public void setSuccess(boolean p1)
    {
        this.success = p1;
        return;
    }
}
