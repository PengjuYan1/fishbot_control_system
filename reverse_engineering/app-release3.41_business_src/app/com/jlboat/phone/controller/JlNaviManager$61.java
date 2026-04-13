package com.jlboat.phone.controller;
 class JlNaviManager$61 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$61(com.jlboat.phone.controller.JlNaviManager p1)
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
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic getImuMsg: ").append(v0).toString());
        if (v0 != 0) {
            if (v0 == 16) {
                com.jlboat.phone.controller.JlNaviManager.access$7402(this.this$0, "\u673a\u5668\u4ebaIMU\u6a21\u5757\u6b63\u5e38\u53d1\u9001\u6570\u636e\uff0cIMU\u6a21\u5757\u5de5\u4f5c\u6b63\u5e38\u3002");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$7400(this.this$0));
            }
            if (v0 == 15) {
                com.jlboat.phone.controller.JlNaviManager.access$7402(this.this$0, "\u673a\u5668\u4ebaIMU\u6a21\u5757\u53d1\u9001\u6570\u636e\u5f02\u5e38\uff0c\u5bfc\u822a\u6a21\u5757\u4e0d\u5de5\u4f5c\uff01");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$7400(this.this$0));
            }
            com.jlboat.phone.controller.JlNaviManager.access$7502(this.this$0, v0);
            if (!com.jlboat.phone.controller.JlNaviManager.access$400(this.this$0)) {
                com.jlboat.phone.controller.JlNaviManager.access$7602(this.this$0, 1);
            }
            return;
        } else {
            return;
        }
    }
}
