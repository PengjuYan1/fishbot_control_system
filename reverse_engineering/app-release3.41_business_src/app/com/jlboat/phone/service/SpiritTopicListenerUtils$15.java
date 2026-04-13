package com.jlboat.phone.service;
 class SpiritTopicListenerUtils$15 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.service.SpiritTopicListenerUtils this$0;

    SpiritTopicListenerUtils$15(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
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
            if (v0 != 118) {
                if ((v0 == 117) && (com.jlboat.phone.service.SpiritTopicListenerUtils.access$1200(this.this$0))) {
                    com.jlboat.phone.service.SpiritTopicListenerUtils.access$1202(this.this$0, 0);
                    com.boat.utils.ReportExceptionInformationUtils.showWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, v0, 13, "\u673a\u5668\u4eba\u907f\u969c\u6444\u50cf\u5934\u51fa\u73b0\u6545\u969c,\u6709\u53ef\u80fd\u8fde\u7ebf\u51fa\u73b0\u95ee\u9898!");
                }
                return;
            } else {
                com.boat.utils.ReportExceptionInformationUtils.deleteWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, 13);
                com.jlboat.phone.service.SpiritTopicListenerUtils.access$1202(this.this$0, 1);
                return;
            }
        } else {
            return;
        }
    }
}
