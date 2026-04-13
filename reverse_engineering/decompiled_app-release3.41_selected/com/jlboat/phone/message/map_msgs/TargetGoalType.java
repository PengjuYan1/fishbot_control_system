package com.jlboat.phone.message.map_msgs;
public class TargetGoalType extends com.boat.jrosbridge.message.Message {
    public boolean circle;
    public int wait_time;

    public TargetGoalType()
    {
        return;
    }

    public boolean getCircle()
    {
        return this.circle;
    }

    public int getWaitTime()
    {
        return this.wait_time;
    }

    public void setCircle(boolean p1)
    {
        this.circle = p1;
        return;
    }

    public void setWaitTime(int p1)
    {
        this.wait_time = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("TargetGoalType{circle=").append(this.circle).append(", waitTime=").append(this.wait_time).append(125).toString();
    }
}
