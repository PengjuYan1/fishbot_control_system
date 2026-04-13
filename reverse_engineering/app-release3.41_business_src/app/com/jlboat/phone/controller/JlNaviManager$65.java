package com.jlboat.phone.controller;
 class JlNaviManager$65 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$65(com.jlboat.phone.controller.JlNaviManager p1)
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
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic getLeftMotorMsg: ").append(v0).toString());
        if (v0 != 0) {
            if (v0 == 108) {
                com.jlboat.phone.controller.JlNaviManager.access$8102(this.this$0, "\u673a\u5668\u4eba\u5de6\u7535\u673a\u6b63\u5e38");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$8100(this.this$0));
            }
            if (v0 == 107) {
                com.jlboat.phone.controller.JlNaviManager.access$8102(this.this$0, "\u673a\u5668\u4eba\u5de6\u7535\u673a\u51fa\u73b0\u6545\u969c\uff0c\u8bf7\u68c0\u67e5\u5de6\u7535\u673a");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$8100(this.this$0));
            }
            com.jlboat.phone.controller.JlNaviManager.access$8202(this.this$0, v0);
            if (!com.jlboat.phone.controller.JlNaviManager.access$400(this.this$0)) {
                com.jlboat.phone.controller.JlNaviManager.access$8302(this.this$0, 1);
            }
            return;
        } else {
            return;
        }
    }
}
