package com.jlboat.phone.activity;
 class MapEditMapActivity$3 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapEditMapActivity this$0;
    final synthetic int val$mode;

    MapEditMapActivity$3(com.jlboat.phone.activity.MapEditMapActivity p1, int p2)
    {
        this.this$0 = p1;
        this.val$mode = p2;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SetEraserModeResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SetEraserModeResponse p5)
    {
        int v3_1;
        String v2_5;
        com.jlboat.phone.activity.MapEditMapActivity v0_0 = this.this$0;
        com.jlboat.phone.activity.MapEditMapActivity$3$1 v1_5 = new StringBuilder().append(this.this$0.getResString(2131493301)).append(this.val$mode).append(", ").append(this.this$0.getResString(2131493300)).append(" ");
        if (p5.getStatus() != 0) {
            v2_5 = this.this$0;
            v3_1 = 2131493241;
        } else {
            v2_5 = this.this$0;
            v3_1 = 2131493252;
        }
        v0_0.toast(v1_5.append(v2_5.getResString(v3_1)).toString());
        this.this$0.runOnUiThread(new com.jlboat.phone.activity.MapEditMapActivity$3$1(this));
        return;
    }
}
