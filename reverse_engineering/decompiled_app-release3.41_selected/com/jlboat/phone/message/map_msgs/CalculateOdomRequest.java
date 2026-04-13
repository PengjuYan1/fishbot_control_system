package com.jlboat.phone.message.map_msgs;
public class CalculateOdomRequest extends com.boat.jrosbridge.message.Message {
    public long cmd;

    public CalculateOdomRequest()
    {
        return;
    }

    public long getCmd()
    {
        return this.cmd;
    }

    public void setCmd(long p1)
    {
        this.cmd = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("CalculateOdomRequest{cmd=").append(this.cmd).append(125).toString();
    }
}
