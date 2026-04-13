package com.jlboat.phone.controller;
 class JlNaviManager$14 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$14(com.jlboat.phone.controller.JlNaviManager p1)
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
        this.this$0.toast("onSuccess: SetGoalResponse");
        if (com.jlboat.phone.controller.JlNaviManager.access$3400(this.this$0) != null) {
            try {
                com.jlboat.phone.controller.JlNaviManager.access$3400(this.this$0).onSuccess("succ");
            } catch (android.os.RemoteException v0_1) {
                v0_1.printStackTrace();
            }
        }
        return;
    }
}
