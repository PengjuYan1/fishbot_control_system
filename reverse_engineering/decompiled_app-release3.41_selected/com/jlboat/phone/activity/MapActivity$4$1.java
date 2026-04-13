package com.jlboat.phone.activity;
 class MapActivity$4$1 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.MapActivity$4 this$1;
    final synthetic com.boat.jrosbridge.message.std_msgs.Int16 val$int16;

    MapActivity$4$1(com.jlboat.phone.activity.MapActivity$4 p1, com.boat.jrosbridge.message.std_msgs.Int16 p2)
    {
        this.this$1 = p1;
        this.val$int16 = p2;
        return;
    }

    public void run()
    {
        com.jlboat.phone.activity.MapActivity.access$700(this.this$1.this$0).setVisibility(8);
        if (this.val$int16.getData() == 11) {
            com.jlboat.phone.activity.MapActivity.access$700(this.this$1.this$0).setVisibility(0);
        }
        return;
    }
}
