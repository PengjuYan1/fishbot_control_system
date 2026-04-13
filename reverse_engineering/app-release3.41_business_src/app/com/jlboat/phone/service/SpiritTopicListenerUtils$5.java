package com.jlboat.phone.service;
 class SpiritTopicListenerUtils$5 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.service.SpiritTopicListenerUtils this$0;

    SpiritTopicListenerUtils$5(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
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
        if (v0 == 32) {
            com.boat.utils.ReportExceptionInformationUtils.deleteWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, 2);
            com.jlboat.phone.service.SpiritTopicListenerUtils.access$202(this.this$0, 1);
        }
        if ((v0 == 31) && (com.jlboat.phone.service.SpiritTopicListenerUtils.access$200(this.this$0))) {
            com.jlboat.phone.service.SpiritTopicListenerUtils.access$202(this.this$0, 0);
            com.boat.utils.ReportExceptionInformationUtils.showWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, v0, 2, "\u673a\u5668\u4eba\u5904\u4e8e\u6025\u505c\u72b6\u6001\uff01\u673a\u5668\u4eba\u7535\u673a\u9501\u4f4f\u4e0d\u52a8");
        }
        return;
    }
}
