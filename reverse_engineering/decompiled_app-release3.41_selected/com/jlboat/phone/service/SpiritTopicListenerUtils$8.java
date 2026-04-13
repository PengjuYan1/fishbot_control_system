package com.jlboat.phone.service;
 class SpiritTopicListenerUtils$8 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.service.SpiritTopicListenerUtils this$0;

    SpiritTopicListenerUtils$8(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
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
        android.util.Log.d("SpiritTopicListenerUtils", new StringBuilder().append("topic getOutChargeMsg: ").append(v0).toString());
        if (v0 != 0) {
            if (v0 != 50) {
                if ((v0 == 49) && (com.jlboat.phone.service.SpiritTopicListenerUtils.access$500(this.this$0))) {
                    com.jlboat.phone.service.SpiritTopicListenerUtils.access$502(this.this$0, 0);
                    com.boat.utils.ReportExceptionInformationUtils.showWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, v0, 5, "\u673a\u5668\u4eba\u51fa\u6869\u5931\u8d25!\u8bf7\u4fee\u590d\uff01");
                }
                return;
            } else {
                com.boat.utils.ReportExceptionInformationUtils.deleteWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, 5);
                com.jlboat.phone.service.SpiritTopicListenerUtils.access$502(this.this$0, 1);
                return;
            }
        } else {
            return;
        }
    }
}
