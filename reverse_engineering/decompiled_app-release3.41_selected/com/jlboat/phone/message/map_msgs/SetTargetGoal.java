package com.jlboat.phone.message.map_msgs;
public class SetTargetGoal extends com.boat.jrosbridge.message.Message {
    public String goal_name;

    public SetTargetGoal()
    {
        return;
    }

    public String getGoalName()
    {
        return this.goal_name;
    }

    public void setGoalName(String p1)
    {
        this.goal_name = p1;
        return;
    }
}
