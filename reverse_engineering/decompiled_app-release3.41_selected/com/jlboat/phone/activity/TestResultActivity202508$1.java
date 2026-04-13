package com.jlboat.phone.activity;
 class TestResultActivity202508$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.TestResultActivity202508 this$0;

    TestResultActivity202508$1(com.jlboat.phone.activity.TestResultActivity202508 p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.TargetGoalEntryRunList) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.TargetGoalEntryRunList p4)
    {
        java.util.LinkedList v0_1 = new java.util.LinkedList();
        v0_1.addAll(java.util.Arrays.asList(p4.getOperated_goal_list()));
        v0_1.addAll(java.util.Arrays.asList(p4.getHigh_goal_list()));
        v0_1.addAll(java.util.Arrays.asList(p4.getLow_goal_list()));
        com.jlboat.phone.activity.TestResultActivity202508.access$002(this.this$0, p4.getTask_circle());
        com.jlboat.phone.activity.TestResultActivity202508.access$102(this.this$0, p4.getCircle_times());
        com.jlboat.phone.activity.TestResultActivity202508.access$400(this.this$0).getMapsService(new com.jlboat.phone.activity.TestResultActivity202508$1$1(this, v0_1));
        android.util.Log.d("TestResultActivity", new StringBuilder().append("tttt: ").append(v0_1).toString());
        return;
    }
}
