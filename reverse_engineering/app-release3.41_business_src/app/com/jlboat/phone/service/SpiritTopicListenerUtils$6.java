package com.jlboat.phone.service;
 class SpiritTopicListenerUtils$6 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.service.SpiritTopicListenerUtils this$0;

    SpiritTopicListenerUtils$6(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
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
        if (v0 != 62) {
            if ((v0 == 63) && (com.jlboat.phone.service.SpiritTopicListenerUtils.access$300(this.this$0))) {
                com.jlboat.phone.service.SpiritTopicListenerUtils.access$302(this.this$0, 0);
                com.boat.utils.ReportExceptionInformationUtils.showWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, v0, 3, "\u673a\u5668\u4eba\u865a\u62df\u5899\u52a0\u8f7d\u5931\u8d25");
            }
            return;
        } else {
            com.boat.utils.ReportExceptionInformationUtils.deleteWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, 3);
            com.jlboat.phone.service.SpiritTopicListenerUtils.access$302(this.this$0, 1);
            return;
        }
    }
}
