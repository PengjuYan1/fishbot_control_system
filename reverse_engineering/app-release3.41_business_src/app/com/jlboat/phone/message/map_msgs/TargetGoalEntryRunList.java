package com.jlboat.phone.message.map_msgs;
public class TargetGoalEntryRunList extends com.boat.jrosbridge.message.Message {
    public int circle_times;
    public com.jlboat.phone.message.map_msgs.TargetGoalEntry[] high_goal_list;
    public com.jlboat.phone.message.map_msgs.TargetGoalEntry[] low_goal_list;
    public com.jlboat.phone.message.map_msgs.TargetGoalEntry[] operated_goal_list;
    public boolean task_circle;

    public TargetGoalEntryRunList()
    {
        return;
    }

    public int getCircle_times()
    {
        return this.circle_times;
    }

    public com.jlboat.phone.message.map_msgs.TargetGoalEntry[] getHigh_goal_list()
    {
        return this.high_goal_list;
    }

    public com.jlboat.phone.message.map_msgs.TargetGoalEntry[] getLow_goal_list()
    {
        return this.low_goal_list;
    }

    public com.jlboat.phone.message.map_msgs.TargetGoalEntry[] getOperated_goal_list()
    {
        return this.operated_goal_list;
    }

    public boolean getTask_circle()
    {
        return this.task_circle;
    }

    public void setCircle_times(int p1)
    {
        this.circle_times = p1;
        return;
    }

    public void setHigh_goal_list(com.jlboat.phone.message.map_msgs.TargetGoalEntry[] p1)
    {
        this.high_goal_list = p1;
        return;
    }

    public void setLow_goal_list(com.jlboat.phone.message.map_msgs.TargetGoalEntry[] p1)
    {
        this.low_goal_list = p1;
        return;
    }

    public void setOperated_goal_list(com.jlboat.phone.message.map_msgs.TargetGoalEntry[] p1)
    {
        this.operated_goal_list = p1;
        return;
    }

    public void setTask_circle(boolean p1)
    {
        this.task_circle = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("TargetGoalEntryRunList{operated_goal_list=").append(java.util.Arrays.toString(this.operated_goal_list)).append(", high_goal_list=").append(java.util.Arrays.toString(this.high_goal_list)).append(", low_goal_list=").append(java.util.Arrays.toString(this.low_goal_list)).append(", task_circle=").append(this.task_circle).append(", circle_times=").append(this.circle_times).append(125).toString();
    }
}
