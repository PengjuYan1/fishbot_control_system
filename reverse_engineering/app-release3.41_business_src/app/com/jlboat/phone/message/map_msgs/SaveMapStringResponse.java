package com.jlboat.phone.message.map_msgs;
public class SaveMapStringResponse extends com.boat.jrosbridge.message.Message {
    public String message;
    public int status;

    public SaveMapStringResponse()
    {
        return;
    }

    public String getMessage()
    {
        return this.message;
    }

    public int getStatus()
    {
        return this.status;
    }

    public void setMessage(String p1)
    {
        this.message = p1;
        return;
    }

    public void setStatus(int p1)
    {
        this.status = p1;
        return;
    }
}
