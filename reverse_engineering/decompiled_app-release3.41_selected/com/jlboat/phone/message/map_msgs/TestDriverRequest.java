package com.jlboat.phone.message.map_msgs;
public class TestDriverRequest extends com.boat.jrosbridge.message.Message {
    public long cmd;

    public TestDriverRequest()
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
}
