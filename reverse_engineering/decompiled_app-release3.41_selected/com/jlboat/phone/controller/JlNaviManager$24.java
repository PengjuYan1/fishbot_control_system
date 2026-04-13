package com.jlboat.phone.controller;
 class JlNaviManager$24 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;
    final synthetic int val$cmd;
    final synthetic int val$finalDistance;

    JlNaviManager$24(com.jlboat.phone.controller.JlNaviManager p1, int p2, int p3)
    {
        this.this$0 = p1;
        this.val$cmd = p2;
        this.val$finalDistance = p3;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_srvs.Empty) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_srvs.Empty p4)
    {
        this.this$0.toast(new StringBuilder().append("setNavicmd onSuccess:cmd: ").append(this.val$cmd).append(" distance: ").append(this.val$finalDistance).toString());
        return;
    }
}
