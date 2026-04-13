package com.jlboat.phone.activity;
 class MapActivity$9 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;

    MapActivity$9(com.jlboat.phone.activity.MapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.TargetGoalEntryRunList) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.TargetGoalEntryRunList p5)
    {
        java.util.LinkedList v0_1 = new java.util.LinkedList();
        v0_1.addAll(java.util.Arrays.asList(p5.getHigh_goal_list()));
        v0_1.addAll(java.util.Arrays.asList(p5.getLow_goal_list()));
        if (!v0_1.isEmpty()) {
            com.jlboat.phone.message.map_msgs.TargetGoalEntry v1_2 = v0_1.iterator();
            if (v1_2.hasNext()) {
                com.jlboat.phone.message.map_msgs.TargetGoalEntry v1_4 = ((com.jlboat.phone.message.map_msgs.TargetGoalEntry) v1_2.next());
                if (v1_4.getStatus() == 1) {
                    this.this$0.runOnUiThread(new com.jlboat.phone.activity.MapActivity$9$1(this, v1_4));
                }
            }
        }
        return;
    }
}
