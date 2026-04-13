package com.jlboat.phone.service;
 class SpiritTopicListenerUtils$12 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.service.SpiritTopicListenerUtils this$0;

    SpiritTopicListenerUtils$12(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
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
        if (v0 != 0) {
            if (v0 != 106) {
                if ((v0 == 105) && (com.jlboat.phone.service.SpiritTopicListenerUtils.access$900(this.this$0))) {
                    com.jlboat.phone.service.SpiritTopicListenerUtils.access$902(this.this$0, 0);
                    com.boat.utils.ReportExceptionInformationUtils.showWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, v0, 10, "\u673a\u5668\u4eba\u8d85\u58f0\u6ce2\u677f\u51fa\u73b0\u6545\u969c,\u6709\u53ef\u80fd\u662f\u8fde\u7ebf\u51fa\u73b0\u95ee\u9898!");
                }
                return;
            } else {
                com.boat.utils.ReportExceptionInformationUtils.deleteWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, 10);
                com.jlboat.phone.service.SpiritTopicListenerUtils.access$902(this.this$0, 1);
                return;
            }
        } else {
            return;
        }
    }
}
