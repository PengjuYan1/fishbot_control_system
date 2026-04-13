package com.jlboat.phone.controller;
 class JlNaviManager$58 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$58(com.jlboat.phone.controller.JlNaviManager p1)
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
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic getStm32Msg: ").append(v0).toString());
        if (v0 != 0) {
            if (v0 == 18) {
                com.jlboat.phone.controller.JlNaviManager.access$6602(this.this$0, "\u673a\u5668\u4eba\u5bfc\u822a\u6a21\u5757\u8ddfSTM32\u5e95\u677f\u901a\u8baf\u6b63\u5e38");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$6600(this.this$0));
            }
            if (v0 == 17) {
                com.jlboat.phone.controller.JlNaviManager.access$6602(this.this$0, "\u673a\u5668\u4eba\u5bfc\u822a\u6a21\u5757\u8ddfSTM32\u5e95\u677f\u901a\u8baf\u5931\u8d25,\u53ef\u80fd\u662f\u9a71\u52a8\u7ebf\u5b58\u5728\u677e\u52a8,\u8bf7\u91cd\u542f\u673a\u5668\u5c1d\u8bd5\u6062\u590d\uff01");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$6600(this.this$0));
            }
            com.jlboat.phone.controller.JlNaviManager.access$6702(this.this$0, v0);
            if (!com.jlboat.phone.controller.JlNaviManager.access$400(this.this$0)) {
                com.jlboat.phone.controller.JlNaviManager.access$6802(this.this$0, 1);
            }
            return;
        } else {
            return;
        }
    }
}
