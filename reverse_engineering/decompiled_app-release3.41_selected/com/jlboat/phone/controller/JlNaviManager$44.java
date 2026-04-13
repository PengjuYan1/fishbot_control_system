package com.jlboat.phone.controller;
 class JlNaviManager$44 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$44(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int16) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int16 p4)
    {
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), "outMachineSignal");
        int v2 = 1;
        if (p4.getData() != 1) {
            v2 = 0;
        }
        com.jlboat.phone.controller.JlNaviManager.access$2202(this.this$0, v2);
        com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessage(17);
        return;
    }
}
