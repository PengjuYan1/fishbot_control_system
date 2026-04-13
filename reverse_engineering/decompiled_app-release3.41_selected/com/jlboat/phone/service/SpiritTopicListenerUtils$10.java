package com.jlboat.phone.service;
 class SpiritTopicListenerUtils$10 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.service.SpiritTopicListenerUtils this$0;

    SpiritTopicListenerUtils$10(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
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
            if (v0 != 18) {
                if ((v0 == 17) && (com.jlboat.phone.service.SpiritTopicListenerUtils.access$700(this.this$0))) {
                    com.jlboat.phone.service.SpiritTopicListenerUtils.access$702(this.this$0, 0);
                    com.boat.utils.ReportExceptionInformationUtils.showWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, v0, 7, "\u673a\u5668\u4eba\u5bfc\u822a\u6a21\u5757\u8ddfSTM32\u5e95\u677f\u901a\u8baf\u5931\u8d25,\u53ef\u80fd\u662f\u9a71\u52a8\u7ebf\u5b58\u5728\u677e\u52a8,\u8bf7\u91cd\u542f\u673a\u5668\u5c1d\u8bd5\u6062\u590d\uff01");
                }
                return;
            } else {
                com.boat.utils.ReportExceptionInformationUtils.deleteWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, 7);
                com.jlboat.phone.service.SpiritTopicListenerUtils.access$702(this.this$0, 1);
                return;
            }
        } else {
            return;
        }
    }
}
