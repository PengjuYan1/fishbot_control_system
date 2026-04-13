package com.jlboat.phone.message.map_msgs;
public class TargetGoalEntryList extends com.boat.jrosbridge.message.Message {
    public com.jlboat.phone.message.map_msgs.TargetGoalEntry[] goal_point_list;

    public TargetGoalEntryList()
    {
        return;
    }

    public java.util.List getGoal_point_list()
    {
        return java.util.Arrays.asList(this.goal_point_list);
    }

    public void setGoal_point_list(java.util.List p2)
    {
        com.jlboat.phone.message.map_msgs.TargetGoalEntry[] v0_1 = new com.jlboat.phone.message.map_msgs.TargetGoalEntry[0];
        this.goal_point_list = ((com.jlboat.phone.message.map_msgs.TargetGoalEntry[]) p2.toArray(v0_1));
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("TargetGoalEntryList{goal_point_list=").append(java.util.Arrays.toString(this.goal_point_list)).append(125).toString();
    }
}
