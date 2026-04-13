package com.jlboat.phone.message.map_msgs;
public class GetPositionResponse extends com.boat.jrosbridge.message.Message {
    public com.boat.jrosbridge.message.geometry_msgs.Point32 pose;

    public GetPositionResponse()
    {
        return;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Point32 getPose()
    {
        return this.pose;
    }

    public void setPose(com.boat.jrosbridge.message.geometry_msgs.Point32 p1)
    {
        this.pose = p1;
        return;
    }
}
