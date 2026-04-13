package com.jlboat.phone.controller;
 class JlNaviManager$25 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$25(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.DeleteTestPointResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.DeleteTestPointResponse p5)
    {
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("onSuccess: getResult()").append(p5.getResult()).toString());
        this.this$0.toast(new StringBuilder().append("\u5220\u9664\u5730\u70b9\u6210\u529f").append(p5.getResult()).toString());
        return;
    }
}
