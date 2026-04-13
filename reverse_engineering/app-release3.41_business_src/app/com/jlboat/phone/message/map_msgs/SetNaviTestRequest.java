package com.jlboat.phone.message.map_msgs;
public class SetNaviTestRequest extends com.boat.jrosbridge.message.Message {
    public String[] goal_names;
    public com.boat.support.slam.entity.floors.NaviTest[] navis;
    public long type;

    public SetNaviTestRequest()
    {
        return;
    }

    public java.util.List getGoalNames()
    {
        return java.util.Arrays.asList(this.goal_names);
    }

    public String[] getGoal_names()
    {
        return this.goal_names;
    }

    public com.boat.support.slam.entity.floors.NaviTest[] getNaviTests()
    {
        return this.navis;
    }

    public long getType()
    {
        return this.type;
    }

    public void setGoalNames(java.util.List p2)
    {
        String[] v0_1 = new String[0];
        this.goal_names = ((String[]) p2.toArray(v0_1));
        return;
    }

    public void setGoal_names(String[] p1)
    {
        this.goal_names = p1;
        return;
    }

    public void setNaviTests(com.boat.support.slam.entity.floors.NaviTest[] p1)
    {
        this.navis = p1;
        return;
    }

    public void setType(long p1)
    {
        this.type = p1;
        return;
    }
}
