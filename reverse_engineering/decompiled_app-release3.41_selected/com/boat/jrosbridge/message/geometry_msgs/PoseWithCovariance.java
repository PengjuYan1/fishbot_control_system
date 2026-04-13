package com.boat.jrosbridge.message.geometry_msgs;
public class PoseWithCovariance extends com.boat.jrosbridge.message.Message {
    public double[] covariance;
    public com.boat.jrosbridge.message.geometry_msgs.Pose pose;

    public PoseWithCovariance()
    {
        this.pose = new com.boat.jrosbridge.message.geometry_msgs.Pose();
        return;
    }

    public double[] getCovariance()
    {
        return this.covariance;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Pose getPose()
    {
        return this.pose;
    }

    public void setCovariance(double[] p1)
    {
        this.covariance = p1;
        return;
    }

    public void setPose(com.boat.jrosbridge.message.geometry_msgs.Pose p1)
    {
        this.pose = p1;
        return;
    }
}
