package com.jlboat.phone.service;
 class SpiritTopicListenerUtils$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.service.SpiritTopicListenerUtils this$0;

    SpiritTopicListenerUtils$2(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
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
        android.util.Log.d("SpiritTopicListenerUtils", new StringBuilder().append("onNewMessage: change ").append(v0).toString());
        if ((v0 != 45) && ((v0 != 46) && ((v0 != 47) && (v0 != 48)))) {
            com.jlboat.phone.application.BoatSlamApplication.change = 0;
        } else {
            com.jlboat.phone.application.BoatSlamApplication.change = 1;
            com.boat.utils.ReportExceptionInformationUtils.deleteWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, com.jlboat.phone.service.SpiritTopicListenerUtils.LOW_BATTERY_SHUTDOWN_FLAG);
        }
        int v1_10 = new android.content.Intent();
        v1_10.setAction("change");
        v1_10.putExtra("value", com.jlboat.phone.application.BoatSlamApplication.change);
        com.jlboat.phone.application.BoatSlamApplication.mApplication.sendBroadcast(v1_10);
        return;
    }
}
