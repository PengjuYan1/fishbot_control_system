package com.boat.jrosbridge.message.nav_msgs;
public class Odometry extends com.boat.jrosbridge.message.Message {
    public String child_frame_id;
    public com.boat.jrosbridge.message.std_msgs.Header header;
    public com.boat.jrosbridge.message.geometry_msgs.PoseWithCovariance pose;
    public com.boat.jrosbridge.message.geometry_msgs.TwistWithCovariance twist;

    public Odometry()
    {
        return;
    }

    public String getChildFrameId()
    {
        return this.child_frame_id;
    }

    public com.boat.jrosbridge.message.std_msgs.Header getHeader()
    {
        return this.header;
    }

    public com.boat.jrosbridge.message.geometry_msgs.PoseWithCovariance getPose()
    {
        return this.pose;
    }

    public com.boat.jrosbridge.message.geometry_msgs.TwistWithCovariance getTwist()
    {
        return this.twist;
    }

    public void setChildFrameId(String p1)
    {
        this.child_frame_id = p1;
        return;
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

    public void setTwist(com.boat.jrosbridge.message.geometry_msgs.TwistWithCovariance p1)
    {
        this.twist = p1;
        return;
    }
}
