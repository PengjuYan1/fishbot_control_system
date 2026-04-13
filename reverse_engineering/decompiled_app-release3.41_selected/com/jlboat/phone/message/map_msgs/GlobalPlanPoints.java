package com.jlboat.phone.message.map_msgs;
public class GlobalPlanPoints extends com.boat.jrosbridge.message.Message {
    public long pointIdA;
    public long pointIdB;

    public GlobalPlanPoints()
    {
        return;
    }

    public long getPointIdA()
    {
        return this.pointIdA;
    }

    public long getPointIdB()
    {
        return this.pointIdB;
    }

    public void setPointIdA(long p1)
    {
        this.pointIdA = p1;
        return;
    }

    public void setPointIdB(long p1)
    {
        this.pointIdB = p1;
        return;
    }
}
