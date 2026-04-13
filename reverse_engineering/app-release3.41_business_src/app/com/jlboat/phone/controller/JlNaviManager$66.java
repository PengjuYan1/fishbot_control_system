package com.jlboat.phone.controller;
 class JlNaviManager$66 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$66(com.jlboat.phone.controller.JlNaviManager p1)
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
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic getRightMotorMsg: ").append(v0).toString());
        if (v0 != 0) {
            if (v0 == 110) {
                com.jlboat.phone.controller.JlNaviManager.access$8402(this.this$0, "\u673a\u5668\u4eba\u53f3\u7535\u673a\u6b63\u5e38");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$8400(this.this$0));
            }
            if (v0 == 109) {
                com.jlboat.phone.controller.JlNaviManager.access$8402(this.this$0, "\u673a\u5668\u4eba\u53f3\u7535\u673a\u51fa\u73b0\u6545\u969c\uff0c\u8bf7\u68c0\u67e5\u53f3\u7535\u673a!");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$8400(this.this$0));
            }
            com.jlboat.phone.controller.JlNaviManager.access$8502(this.this$0, v0);
            if (!com.jlboat.phone.controller.JlNaviManager.access$400(this.this$0)) {
                com.jlboat.phone.controller.JlNaviManager.access$8602(this.this$0, 1);
            }
            return;
        } else {
            return;
        }
    }
}
