package com.jlboat.phone.controller;
 class JlNaviManager$41 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$41(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int16) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int16 p5)
    {
        short v0 = p5.getData();
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic \u5e95\u76d8\u4e0a\u62a5\u7535\u91cf: getBattry: currentBattery = ").append(com.jlboat.phone.controller.JlNaviManager.access$800(this.this$0)).append(", newBattery = ").append(v0).toString());
        if (com.jlboat.phone.controller.JlNaviManager.access$800(this.this$0) != v0) {
            com.jlboat.phone.controller.JlNaviManager.access$802(this.this$0, v0);
            com.jlboat.phone.controller.JlNaviManager.access$2700(this.this$0);
            com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessage(7);
            com.jlboat.phone.application.BoatSlamApplication.power = p5.getData();
            android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("onNewMessage \u7535\u91cf: ").append(com.jlboat.phone.application.BoatSlamApplication.power).toString());
            android.content.Intent v1_12 = new android.content.Intent();
            v1_12.setAction("power");
            v1_12.putExtra("value", com.jlboat.phone.application.BoatSlamApplication.power);
            com.jlboat.phone.application.BoatSlamApplication.mApplication.sendBroadcast(v1_12);
            return;
        } else {
            return;
        }
    }
}
