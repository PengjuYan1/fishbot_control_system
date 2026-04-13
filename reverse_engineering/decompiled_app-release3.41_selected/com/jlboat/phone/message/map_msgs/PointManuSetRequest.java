package com.jlboat.phone.message.map_msgs;
public class PointManuSetRequest extends com.boat.jrosbridge.message.Message {
    public com.boat.jrosbridge.message.geometry_msgs.PoseWithCovarianceStamped point;
    public long point_mode;
    public String point_name;

    public PointManuSetRequest()
    {
        return;
    }

    public com.boat.jrosbridge.message.geometry_msgs.PoseWithCovarianceStamped getPoint()
    {
        return this.point;
    }

    public long getPointMode()
    {
        return this.point_mode;
    }

    public String getPointName()
    {
        return this.point_name;
    }

    public void setPoint(com.boat.jrosbridge.message.geometry_msgs.PoseWithCovarianceStamped p1)
    {
        this.point = p1;
        return;
    }

    public void setPointMode(long p1)
    {
        this.point_mode = p1;
        return;
    }

    public void setPointName(String p1)
    {
        this.point_name = p1;
        return;
    }
}
