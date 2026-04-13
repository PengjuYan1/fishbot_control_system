package com.boat.jrosbridge.message;
public class Time extends com.boat.jrosbridge.message.Message {
    public int nsecs;
    public int secs;

    public Time()
    {
        return;
    }

    public int getNsecs()
    {
        return this.nsecs;
    }

    public int getSecs()
    {
        return this.secs;
    }

    public void setNsecs(int p1)
    {
        this.nsecs = p1;
        return;
    }

    public void setSecs(int p1)
    {
        this.secs = p1;
        return;
    }

    public com.boat.jrosbridge.message.Duration subtract(com.boat.jrosbridge.message.Time p5)
    {
        return new com.boat.jrosbridge.message.Duration((this.secs - p5.secs), (this.nsecs - p5.nsecs));
    }
}
