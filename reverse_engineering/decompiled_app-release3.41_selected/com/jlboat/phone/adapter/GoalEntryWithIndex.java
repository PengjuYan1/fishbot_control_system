package com.jlboat.phone.adapter;
 class GoalEntryWithIndex {
    int completedIndex;
    com.jlboat.phone.message.map_msgs.TargetGoalEntry entry;

    public GoalEntryWithIndex(com.jlboat.phone.message.map_msgs.TargetGoalEntry p1, int p2)
    {
        this.entry = p1;
        this.completedIndex = p2;
        return;
    }
}
