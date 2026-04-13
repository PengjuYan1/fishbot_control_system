package com.jlboat.phone.controller;
 class JlNaviManager$59 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$59(com.jlboat.phone.controller.JlNaviManager p1)
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
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic getOdomMsg: ").append(v0).toString());
        if (v0 != 0) {
            if (v0 == 20) {
                com.jlboat.phone.controller.JlNaviManager.access$6902(this.this$0, "\u673a\u5668\u4eba\u91cc\u7a0b\u8ba1\u6a21\u5757\u6b63\u5e38\u53d1\u9001\u6570\u636e\uff0c\u9a71\u52a8\u7535\u673a\u5de5\u4f5c\u6b63\u5e38");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$6900(this.this$0));
            }
            if (v0 == 19) {
                com.jlboat.phone.controller.JlNaviManager.access$6902(this.this$0, "\u673a\u5668\u4eba\u91cc\u7a0b\u8ba1\u53d1\u9001\u6570\u636e\u5931\u8d25,\u53ef\u80fd\u662f\u901a\u8baf\u51fa\u73b0\u4e86\u95ee\u9898");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$6900(this.this$0));
            }
            com.jlboat.phone.controller.JlNaviManager.access$7002(this.this$0, v0);
            if (!com.jlboat.phone.controller.JlNaviManager.access$400(this.this$0)) {
                com.jlboat.phone.controller.JlNaviManager.access$7102(this.this$0, 1);
            }
            return;
        } else {
            return;
        }
    }
}
