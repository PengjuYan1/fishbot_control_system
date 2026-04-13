package com.jlboat.phone.controller;
 class JlNaviManager$67 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$67(com.jlboat.phone.controller.JlNaviManager p1)
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
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic getCameraMsg: ").append(v0).toString());
        if (v0 != 0) {
            if (v0 != 118) {
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, "\u673a\u5668\u4eba\u907f\u969c\u6444\u50cf\u5934\u51fa\u73b0\u6545\u969c,\u6709\u53ef\u80fd\u8fde\u7ebf\u51fa\u73b0\u95ee\u9898!");
            } else {
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, "\u673a\u5668\u4eba\u907f\u969c\u6444\u50cf\u5934\u6b63\u5e38");
            }
            return;
        } else {
            return;
        }
    }
}
