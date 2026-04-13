package com.jlboat.phone.controller;
 class JlNaviManager$48 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$48(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SetTargetGoal) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SetTargetGoal p5)
    {
        String v0 = p5.getGoalName();
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic: getNaviToPointName ").append(v0).toString());
        com.jlboat.phone.controller.JlNaviManager.access$1502(this.this$0, v0);
        com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessage(11);
        return;
    }
}
