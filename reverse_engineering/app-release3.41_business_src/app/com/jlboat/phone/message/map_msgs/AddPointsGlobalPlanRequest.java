package com.jlboat.phone.message.map_msgs;
public class AddPointsGlobalPlanRequest extends com.boat.jrosbridge.message.Message {
    public com.jlboat.phone.message.map_msgs.GlobalPlanPoints addPoints;
    public long globalplanId;

    public AddPointsGlobalPlanRequest()
    {
        return;
    }

    public com.jlboat.phone.message.map_msgs.GlobalPlanPoints getAddPoints()
    {
        return this.addPoints;
    }

    public long getGlobalplanId()
    {
        return this.globalplanId;
    }

    public void setAddPoints(com.jlboat.phone.message.map_msgs.GlobalPlanPoints p1)
    {
        this.addPoints = p1;
        return;
    }

    public void setGlobalplanId(long p1)
    {
        this.globalplanId = p1;
        return;
    }
}
