package com.boat.jrosbridge.message.std_msgs;
public class Header extends com.boat.jrosbridge.message.Message {
    public String frame_id;
    public long seq;
    public com.boat.jrosbridge.message.Time stamp;

    public Header()
    {
        return;
    }

    public String getFrameId()
    {
        return this.frame_id;
    }

    public long getSeq()
    {
        return this.seq;
    }

    public com.boat.jrosbridge.message.Time getStamp()
    {
        return this.stamp;
    }

    public void setFrameId(String p1)
    {
        this.frame_id = p1;
        return;
    }

    public void setSeq(long p1)
    {
        this.seq = p1;
        return;
    }

    public void setStamp(com.boat.jrosbridge.message.Time p1)
    {
        this.stamp = p1;
        return;
    }
}
