package com.jlboat.phone.service;
 class SpiritTopicListenerUtils$4 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.service.SpiritTopicListenerUtils this$0;

    SpiritTopicListenerUtils$4(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
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
        if (v0 != 12) {
            if ((v0 == 11) && (com.jlboat.phone.service.SpiritTopicListenerUtils.access$100(this.this$0))) {
                com.jlboat.phone.service.SpiritTopicListenerUtils.access$102(this.this$0, 0);
                com.boat.utils.ReportExceptionInformationUtils.showWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, v0, 1, "\u673a\u5668\u4eba\u5bfc\u822a\u521d\u59cb\u5316\u5931\u8d25\uff0c\u5bfc\u822a\u6a21\u5757\u4e0d\u5de5\u4f5c!");
            }
            return;
        } else {
            com.boat.utils.ReportExceptionInformationUtils.deleteWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, 1);
            com.jlboat.phone.service.SpiritTopicListenerUtils.access$102(this.this$0, 1);
            return;
        }
    }
}
