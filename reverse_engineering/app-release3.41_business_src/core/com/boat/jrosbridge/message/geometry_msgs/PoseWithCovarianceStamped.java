package com.boat.jrosbridge.message.geometry_msgs;
public class PoseWithCovarianceStamped extends com.boat.jrosbridge.message.Message {
    public com.boat.jrosbridge.message.std_msgs.Header header;
    public com.boat.jrosbridge.message.geometry_msgs.PoseWithCovariance pose;

    public PoseWithCovarianceStamped()
    {
        return;
    }

    public com.boat.jrosbridge.message.std_msgs.Header getHeader()
    {
        return this.header;
    }

    public com.boat.jrosbridge.message.geometry_msgs.PoseWithCovariance getPose()
    {
        return this.pose;
    }

    public void setHeader(com.boat.jrosbridge.message.std_msgs.Header p1)
    {
        this.header = p1;
        return;
    }

    public void setPose(com.boat.jrosbridge.message.geometry_msgs.PoseWithCovariance p1)
    {
        this.pose = p1;
        return;
    }
}
