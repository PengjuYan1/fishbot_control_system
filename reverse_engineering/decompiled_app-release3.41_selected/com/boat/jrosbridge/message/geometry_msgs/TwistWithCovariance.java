package com.boat.jrosbridge.message.geometry_msgs;
public class TwistWithCovariance extends com.boat.jrosbridge.message.Message {
    public double[] covariance;
    public com.boat.jrosbridge.message.geometry_msgs.Twist twist;

    public TwistWithCovariance()
    {
        return;
    }

    public double[] getCovariance()
    {
        return this.covariance;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Twist getTwist()
    {
        return this.twist;
    }

    public void setCovariance(double[] p1)
    {
        this.covariance = p1;
        return;
    }

    public void setTwist(com.boat.jrosbridge.message.geometry_msgs.Twist p1)
    {
        this.twist = p1;
        return;
    }
}
