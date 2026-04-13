package com.boat.jrosbridge.message.std_srvs;
public class TriggerResponse extends com.boat.jrosbridge.message.Message {
    public String message;
    public boolean success;

    public TriggerResponse()
    {
        return;
    }

    public String getMessage()
    {
        return this.message;
    }

    public boolean getSuccess()
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
