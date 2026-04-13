package com.jlboat.phone.controller;
 class JlNaviManager$22 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;
    final synthetic int val$mode;

    JlNaviManager$22(com.jlboat.phone.controller.JlNaviManager p1, int p2)
    {
        this.this$0 = p1;
        this.val$mode = p2;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_srvs.Empty) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_srvs.Empty p4)
    {
        if ((this.val$mode == 1) && (com.jlboat.phone.controller.JlNaviManager.access$3500(this.this$0) != null)) {
            try {
                com.jlboat.phone.controller.JlNaviManager.access$3500(this.this$0).onSuccess("start");
            } catch (android.os.RemoteException v0_1) {
                v0_1.printStackTrace();
            }
        }
        this.this$0.toast(new StringBuilder().append("onSuccess: setMoveMode: ").append(this.val$mode).toString());
        return;
    }
}
