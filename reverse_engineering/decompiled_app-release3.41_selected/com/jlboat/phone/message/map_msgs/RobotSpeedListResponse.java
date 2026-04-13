package com.jlboat.phone.message.map_msgs;
public class RobotSpeedListResponse extends com.boat.jrosbridge.message.Message {
    public long speed;

    public RobotSpeedListResponse()
    {
        return;
    }

    public long getSpeed()
    {
        return this.speed;
    }

    public void setSpeed(long p1)
    {
        this.speed = p1;
        return;
    }
}
