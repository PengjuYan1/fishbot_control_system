package com.jlboat.phone.controller;
 class JlNaviManager$62 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$62(com.jlboat.phone.controller.JlNaviManager p1)
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
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic getSonarMsg: ").append(v0).toString());
        if (v0 != 0) {
            if (v0 == 106) {
                com.jlboat.phone.controller.JlNaviManager.access$7702(this.this$0, "\u673a\u5668\u4eba\u8d85\u58f0\u6ce2\u677f\u6b63\u5e38\u3002");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$7700(this.this$0));
            }
            if (v0 == 105) {
                com.jlboat.phone.controller.JlNaviManager.access$7702(this.this$0, "\u673a\u5668\u4eba\u8d85\u58f0\u6ce2\u677f\u51fa\u73b0\u6545\u969c,\u6709\u53ef\u80fd\u662f\u8fde\u7ebf\u51fa\u73b0\u95ee\u9898!");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$7700(this.this$0));
            }
            com.jlboat.phone.controller.JlNaviManager.access$7802(this.this$0, v0);
            if (!com.jlboat.phone.controller.JlNaviManager.access$400(this.this$0)) {
                com.jlboat.phone.controller.JlNaviManager.access$7902(this.this$0, 1);
            }
            return;
        } else {
            return;
        }
    }
}
