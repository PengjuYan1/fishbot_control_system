package com.jlboat.phone.controller;
 class JlNaviManager$20 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$20(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_srvs.Empty) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_srvs.Empty p3)
    {
        this.this$0.toast("\u5220\u9664\u5730\u56fe\u6210\u529f");
        return;
    }
}
