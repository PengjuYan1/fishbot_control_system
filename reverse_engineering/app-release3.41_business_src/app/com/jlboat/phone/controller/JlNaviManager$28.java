package com.jlboat.phone.controller;
 class JlNaviManager$28 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$28(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.PointMaunSetResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.PointMaunSetResponse p6)
    {
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), "onNewMessage: addMenuPoint \u6307\u4ee4\u53d1\u9001\u6210\u529f");
        if (p6.getResult() >= 100) {
            com.jlboat.phone.controller.JlNaviManager.access$3600(this.this$0, "RobotAddPoint", new StringBuilder().append("{\"pointId\":").append(p6.getResult()).append(",\"status\":true}").toString());
            return;
        } else {
            return;
        }
    }
}
