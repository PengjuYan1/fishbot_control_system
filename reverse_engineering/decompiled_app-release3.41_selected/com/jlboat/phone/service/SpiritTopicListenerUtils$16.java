package com.jlboat.phone.service;
 class SpiritTopicListenerUtils$16 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.service.SpiritTopicListenerUtils this$0;

    SpiritTopicListenerUtils$16(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
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
            if (v0 != 124) {
                if ((v0 == 123) && (com.jlboat.phone.service.SpiritTopicListenerUtils.access$1300(this.this$0))) {
                    com.jlboat.phone.service.SpiritTopicListenerUtils.access$1302(this.this$0, 0);
                    com.boat.utils.ReportExceptionInformationUtils.showWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, v0, 14, "\u673a\u5668\u4eba\u7535\u6c60\u6e29\u5ea6\u8fc7\u9ad8\uff0c\u5371\u9669\uff01\u8bf7\u65ad\u7535!!!");
                }
                return;
            } else {
                com.boat.utils.ReportExceptionInformationUtils.deleteWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, 14);
                com.jlboat.phone.service.SpiritTopicListenerUtils.access$1302(this.this$0, 1);
                return;
            }
        } else {
            return;
        }
    }
}
