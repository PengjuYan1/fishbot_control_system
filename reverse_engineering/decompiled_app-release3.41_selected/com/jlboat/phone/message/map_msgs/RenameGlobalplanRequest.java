package com.jlboat.phone.message.map_msgs;
public class RenameGlobalplanRequest extends com.boat.jrosbridge.message.Message {
    public long dir;
    public long globalplanId;
    public String globalplanName;

    public RenameGlobalplanRequest()
    {
        return;
    }

    public long getDir()
    {
        return this.dir;
    }

    public long getGlobalplanId()
    {
        return this.globalplanId;
    }

    public String getGlobalplanName()
    {
        return this.globalplanName;
    }

    public void setDir(long p1)
    {
        this.dir = p1;
        return;
    }

    public void setGlobalplanId(long p1)
    {
        this.globalplanId = p1;
        return;
    }

    public void setGlobalplanName(String p1)
    {
        this.globalplanName = p1;
        return;
    }
}
