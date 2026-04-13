package com.jlboat.phone.message.map_msgs;
public class SetRelocationRequest extends com.boat.jrosbridge.message.Message {
    public com.boat.jrosbridge.message.geometry_msgs.PoseWithCovarianceStamped point;

    public SetRelocationRequest()
    {
        return;
    }

    public com.boat.jrosbridge.message.geometry_msgs.PoseWithCovarianceStamped getPoint()
    {
        return this.point;
    }

    public void setPoint(com.boat.jrosbridge.message.geometry_msgs.PoseWithCovarianceStamped p1)
    {
        this.point = p1;
        return;
    }
}
