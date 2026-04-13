package com.jlboat.phone.message.map_msgs;
public class SetGlobalPlanRequest extends com.boat.jrosbridge.message.Message {
    public long dir;
    public com.jlboat.phone.message.map_msgs.GlobalPlanPoints[] globalPlanPoints;
    public long globalplanId;
    public String globalplanName;
    public long op;
    public com.boat.jrosbridge.message.geometry_msgs.Point[] points;

    public SetGlobalPlanRequest()
    {
        return;
    }

    public long getDir()
    {
        return this.dir;
    }

    public com.jlboat.phone.message.map_msgs.GlobalPlanPoints[] getGlobalPlanPoints()
    {
        return this.globalPlanPoints;
    }

    public long getGlobalplanId()
    {
        return this.globalplanId;
    }

    public String getGlobalplanName()
    {
        return this.globalplanName;
    }

    public long getOp()
    {
        return this.op;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Point[] getPoints()
    {
        return this.points;
    }

    public void setDir(long p1)
    {
        this.dir = p1;
        return;
    }

    public void setGlobalPlanPoints(com.jlboat.phone.message.map_msgs.GlobalPlanPoints[] p1)
    {
        this.globalPlanPoints = p1;
        return;
    }

    public void setGlobalplanId(long p1)
    {
        this.globalplanId = p1;
        return;
    }

    public void setGlobalplanName(String p1)
    {
        this.globalplanName = p1;
        return;
    }

    public void setOp(long p1)
    {
        this.op = p1;
        return;
    }

    public void setPoints(com.boat.jrosbridge.message.geometry_msgs.Point[] p1)
    {
        this.points = p1;
        return;
    }
}
