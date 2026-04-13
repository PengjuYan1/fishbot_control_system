package com.jlboat.phone.controller;
 class JlNaviManager$68 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$68(com.jlboat.phone.controller.JlNaviManager p1)
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
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic getBatteryMsg: ").append(v0).toString());
        if (v0 != 0) {
            if (v0 != 124) {
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, "\u673a\u5668\u4eba\u7535\u6c60\u6e29\u5ea6\u8fc7\u9ad8\uff0c\u5371\u9669\uff01\u8bf7\u65ad\u7535!!!");
            } else {
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, "\u673a\u5668\u4eba\u7535\u6c60\u6e29\u5ea6\u6b63\u5e38\u3002!");
            }
            return;
        } else {
            return;
        }
    }
}
