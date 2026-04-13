package com.boat.jrosbridge.message;
public class Duration extends com.boat.jrosbridge.message.Message {
    public int nsecs;
    public int secs;

    public Duration()
    {
        return;
    }

    public Duration(double p5)
    {
        this.secs = ((int) p5);
        this.nsecs = ((int) ((p5 - ((double) this.secs)) * 4741671816366391296));
        this.normalize();
        return;
    }

    public Duration(int p1, int p2)
    {
        this.secs = p1;
        this.nsecs = p2;
        this.normalize();
        return;
    }

    public Duration(com.boat.jrosbridge.message.Duration p2)
    {
        this.secs = p2.secs;
        this.nsecs = p2.nsecs;
        return;
    }

    public static com.boat.jrosbridge.message.Duration fromMillis(long p4)
    {
        return new com.boat.jrosbridge.message.Duration(((int) (p4 / 1000)), (((int) (p4 % 1000)) * 1000000));
    }

    public static com.boat.jrosbridge.message.Duration fromNano(long p4)
    {
        return new com.boat.jrosbridge.message.Duration(((int) (p4 / 1000000000)), ((int) (p4 % 1000000000)));
    }

    public com.boat.jrosbridge.message.Duration add(com.boat.jrosbridge.message.Duration p5)
    {
        return new com.boat.jrosbridge.message.Duration((this.secs + p5.secs), (this.nsecs + p5.nsecs));
    }

    public int getNsecs()
    {
        return this.nsecs;
    }

    public int getSecs()
    {
        return this.secs;
    }

    public void normalize()
    {
        while (this.nsecs < 0) {
            this.nsecs = (this.nsecs + 1000000000);
            this.secs = (this.secs - 1);
        }
        while (this.nsecs >= 1000000000) {
            this.nsecs = (this.nsecs - 1000000000);
            this.secs = (this.secs + 1);
        }
        return;
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

    public com.boat.jrosbridge.message.Duration subtract(com.boat.jrosbridge.message.Duration p5)
    {
        return new com.boat.jrosbridge.message.Duration((this.secs - p5.secs), (this.nsecs - p5.nsecs));
    }

    public long totalNsecs()
    {
        return ((((long) this.secs) * 1000000000) + ((long) this.nsecs));
    }
}
