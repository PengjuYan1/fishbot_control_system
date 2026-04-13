package com.jlboat.phone.service;
 class SpiritTopicListenerUtils$7 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.service.SpiritTopicListenerUtils this$0;

    SpiritTopicListenerUtils$7(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
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
        android.util.Log.d("SpiritTopicListenerUtils", new StringBuilder().append("topic getMapStatusMsg: ").append(v0).toString());
        if (v0 != 0) {
            if (v0 != 60) {
                if ((v0 == 61) && (com.jlboat.phone.service.SpiritTopicListenerUtils.access$400(this.this$0))) {
                    com.jlboat.phone.service.SpiritTopicListenerUtils.access$402(this.this$0, 0);
                    com.boat.utils.ReportExceptionInformationUtils.showWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, v0, 4, "\u673a\u5668\u4eba\u5730\u56fe\u52a0\u8f7d\u5931\u8d25\u5bfc\u81f4\u5730\u56fe\u6ca1\u6709\u8d77\u6765\uff0c\u5bfc\u822a\u6a21\u5757\u4e0d\u5de5\u4f5c!");
                }
                return;
            } else {
                com.boat.utils.ReportExceptionInformationUtils.deleteWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, 4);
                com.jlboat.phone.service.SpiritTopicListenerUtils.access$402(this.this$0, 1);
                return;
            }
        } else {
            return;
        }
    }
}
