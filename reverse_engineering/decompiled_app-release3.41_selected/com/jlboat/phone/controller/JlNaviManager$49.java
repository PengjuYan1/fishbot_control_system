package com.jlboat.phone.controller;
 class JlNaviManager$49 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$49(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.TargetGoal) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.TargetGoal p5)
    {
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic: getNaviTargetGoal: floor: ").append(p5.getFloorId()).append(", map: ").append(p5.getMapId()).append(", point: ").append(p5.getPointId()).toString());
        com.jlboat.phone.controller.JlNaviManager.access$1602(this.this$0, p5);
        com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessage(19);
        return;
    }
}
