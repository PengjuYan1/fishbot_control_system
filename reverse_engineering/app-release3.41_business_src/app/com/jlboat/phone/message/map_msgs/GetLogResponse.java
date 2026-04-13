package com.jlboat.phone.message.map_msgs;
public class GetLogResponse extends com.boat.jrosbridge.message.Message {
    public String log_name;
    public int status;

    public GetLogResponse()
    {
        return;
    }

    public String getLogName()
    {
        return this.log_name;
    }

    public int getStatus()
    {
        return this.status;
    }

    public void setLogName(String p1)
    {
        this.log_name = p1;
        return;
    }

    public void setStatus(int p1)
    {
        this.status = p1;
        return;
    }
}
