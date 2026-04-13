package com.jlboat.phone.service;
 class SpiritTopicListenerUtils$3 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.service.SpiritTopicListenerUtils this$0;

    SpiritTopicListenerUtils$3(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
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
        if (v0 != 10) {
            if ((v0 == 9) && (com.jlboat.phone.service.SpiritTopicListenerUtils.access$000(this.this$0))) {
                com.jlboat.phone.service.SpiritTopicListenerUtils.access$002(this.this$0, 0);
                com.boat.utils.ReportExceptionInformationUtils.showWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, v0, 0, "\u673a\u5668\u4eba\u4f4d\u7f6e\u4e22\u5931!");
            }
            return;
        } else {
            com.boat.utils.ReportExceptionInformationUtils.deleteWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, 0);
            com.jlboat.phone.service.SpiritTopicListenerUtils.access$002(this.this$0, 1);
            return;
        }
    }
}
