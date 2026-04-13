package com.jlboat.phone.controller;
 class JlNaviManager$50 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$50(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int16) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int16 p3)
    {
        if (p3.getData() == 5) {
            com.jlboat.phone.controller.JlNaviManager.access$1402(this.this$0, "NAVISTOP");
            com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessage(8);
            if (com.jlboat.phone.controller.JlNaviManager.access$3500(this.this$0) != null) {
                try {
                    com.jlboat.phone.controller.JlNaviManager.access$3500(this.this$0).onSuccess("stop");
                    com.jlboat.phone.controller.JlNaviManager.access$3502(this.this$0, 0);
                } catch (android.os.RemoteException v0_6) {
                    v0_6.printStackTrace();
                }
            }
        }
        return;
    }
}
