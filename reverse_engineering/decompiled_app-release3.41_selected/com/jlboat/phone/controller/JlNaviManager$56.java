package com.jlboat.phone.controller;
 class JlNaviManager$56 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$56(com.jlboat.phone.controller.JlNaviManager p1)
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
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic getOutChargeMsg: ").append(v0).toString());
        if (v0 != 0) {
            if (v0 == 50) {
                com.boat.utils.ReportExceptionInformationUtils.upload(this.this$0.getApp(), v0, "\u673a\u5668\u4eba\u51fa\u6869\u6210\u529f!");
            }
            if (v0 == 49) {
                com.boat.utils.ReportExceptionInformationUtils.upload(this.this$0.getApp(), v0, "\u673a\u5668\u4eba\u51fa\u6869\u5931\u8d25!\u8bf7\u4fee\u590d\uff01");
            }
            return;
        } else {
            return;
        }
    }
}
