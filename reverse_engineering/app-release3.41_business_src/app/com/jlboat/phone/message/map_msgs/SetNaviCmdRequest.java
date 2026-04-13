package com.jlboat.phone.message.map_msgs;
public class SetNaviCmdRequest extends com.boat.jrosbridge.message.Message {
    public String cmd;
    public long distance;

    public SetNaviCmdRequest()
    {
        return;
    }

    public String getCmd()
    {
        return this.cmd;
    }

    public long getDistance()
    {
        return this.distance;
    }

    public void setCmd(String p1)
    {
        this.cmd = p1;
        return;
    }

    public void setDistance(long p1)
    {
        this.distance = p1;
        return;
    }
}
