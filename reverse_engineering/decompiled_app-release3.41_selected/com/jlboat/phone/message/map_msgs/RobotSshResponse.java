package com.jlboat.phone.message.map_msgs;
public class RobotSshResponse extends com.boat.jrosbridge.message.Message {
    public String data;
    public int status;

    public RobotSshResponse()
    {
        return;
    }

    public String getData()
    {
        return this.data;
    }

    public int getStatus()
    {
        return this.status;
    }

    public void setData(String p1)
    {
        this.data = p1;
        return;
    }

    public void setStatus(int p1)
    {
        this.status = p1;
        return;
    }
}
