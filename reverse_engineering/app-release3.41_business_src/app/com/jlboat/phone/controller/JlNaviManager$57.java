package com.jlboat.phone.controller;
 class JlNaviManager$57 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$57(com.jlboat.phone.controller.JlNaviManager p1)
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
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic getLidarMsg: ").append(v0).toString());
        if (v0 != 0) {
            if (v0 == 14) {
                com.jlboat.phone.controller.JlNaviManager.access$6302(this.this$0, "\u673a\u5668\u4eba\u6fc0\u5149\u6a21\u5757\u6b63\u5e38\u53d1\u9001\u6570\u636e\uff0c\u6fc0\u5149\u6a21\u5757\u5de5\u4f5c\u6b63\u5e38");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$6300(this.this$0));
            }
            if (v0 == 13) {
                com.jlboat.phone.controller.JlNaviManager.access$6302(this.this$0, "\u673a\u5668\u4eba\u6fc0\u5149\u6a21\u5757\u53d1\u9001\u6570\u636e\u5f02\u5e38\uff0c\u5bfc\u822a\u6a21\u5757\u4e0d\u5de5\u4f5c");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$6300(this.this$0));
            }
            com.jlboat.phone.controller.JlNaviManager.access$6402(this.this$0, v0);
            if (!com.jlboat.phone.controller.JlNaviManager.access$400(this.this$0)) {
                com.jlboat.phone.controller.JlNaviManager.access$6502(this.this$0, 1);
            }
            return;
        } else {
            return;
        }
    }
}
