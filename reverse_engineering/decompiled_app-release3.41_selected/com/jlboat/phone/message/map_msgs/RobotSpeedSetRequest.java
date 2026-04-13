package com.jlboat.phone.message.map_msgs;
public class RobotSpeedSetRequest extends com.boat.jrosbridge.message.Message {
    public long speed;

    public RobotSpeedSetRequest()
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
