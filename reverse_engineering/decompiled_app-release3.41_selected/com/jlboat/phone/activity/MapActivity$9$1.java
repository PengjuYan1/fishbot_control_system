package com.jlboat.phone.activity;
 class MapActivity$9$1 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.MapActivity$9 this$1;
    final synthetic com.jlboat.phone.message.map_msgs.TargetGoalEntry val$resultEntry;

    MapActivity$9$1(com.jlboat.phone.activity.MapActivity$9 p1, com.jlboat.phone.message.map_msgs.TargetGoalEntry p2)
    {
        this.this$1 = p1;
        this.val$resultEntry = p2;
        return;
    }

    public void run()
    {
        if (8 == com.jlboat.phone.activity.MapActivity.access$2900(this.this$1.this$0).getVisibility()) {
            com.jlboat.phone.activity.MapActivity.access$3000(this.this$1.this$0).setVisibility(0);
        }
        com.jlboat.phone.activity.MapActivity.access$3300(this.this$1.this$0).setVisibility(0);
        com.jlboat.phone.activity.MapActivity.access$3400(this.this$1.this$0).setVisibility(0);
        com.jlboat.phone.activity.MapActivity.access$3300(this.this$1.this$0).setText(new StringBuilder().append(this.this$1.this$0.getString(2131493096)).append(" ").append(this.val$resultEntry.getFloorName()).append(" ").append(this.val$resultEntry.getPointName()).append(", ").toString());
        return;
    }
}
