package com.jlboat.phone.service;
 class SpiritTopicListenerUtils$11 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.service.SpiritTopicListenerUtils this$0;

    SpiritTopicListenerUtils$11(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
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
        android.util.Log.d("SpiritTopicListenerUtils", new StringBuilder().append("topic getImuMsg: ").append(v0).toString());
        if (v0 != 0) {
            if (v0 != 16) {
                if ((v0 != 15) || (!com.jlboat.phone.service.SpiritTopicListenerUtils.access$800(this.this$0))) {
                    com.jlboat.phone.service.SpiritTopicListenerUtils.access$802(this.this$0, 1);
                } else {
                    com.jlboat.phone.service.SpiritTopicListenerUtils.access$802(this.this$0, 0);
                    com.boat.utils.ReportExceptionInformationUtils.showWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, v0, 9, "\u673a\u5668\u4ebaIMU\u6a21\u5757\u53d1\u9001\u6570\u636e\u5f02\u5e38\uff0c\u5bfc\u822a\u6a21\u5757\u4e0d\u5de5\u4f5c\uff01");
                }
                return;
            } else {
                com.boat.utils.ReportExceptionInformationUtils.deleteWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, 9);
                com.jlboat.phone.service.SpiritTopicListenerUtils.access$802(this.this$0, 1);
                return;
            }
        } else {
            return;
        }
    }
}
