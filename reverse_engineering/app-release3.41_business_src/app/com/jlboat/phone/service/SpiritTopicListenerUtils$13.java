package com.jlboat.phone.service;
 class SpiritTopicListenerUtils$13 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.service.SpiritTopicListenerUtils this$0;

    SpiritTopicListenerUtils$13(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
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
            if (v0 != 108) {
                if ((v0 == 107) && (com.jlboat.phone.service.SpiritTopicListenerUtils.access$1000(this.this$0))) {
                    com.jlboat.phone.service.SpiritTopicListenerUtils.access$1002(this.this$0, 0);
                    com.boat.utils.ReportExceptionInformationUtils.showWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, v0, 11, "\u673a\u5668\u4eba\u5de6\u7535\u673a\u51fa\u73b0\u6545\u969c\uff0c\u8bf7\u68c0\u67e5\u5de6\u7535\u673a");
                }
                return;
            } else {
                com.boat.utils.ReportExceptionInformationUtils.deleteWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, 11);
                com.jlboat.phone.service.SpiritTopicListenerUtils.access$1002(this.this$0, 1);
                return;
            }
        } else {
            return;
        }
    }
}
