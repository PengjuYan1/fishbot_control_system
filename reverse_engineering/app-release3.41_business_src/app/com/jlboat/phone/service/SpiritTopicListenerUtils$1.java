package com.jlboat.phone.service;
 class SpiritTopicListenerUtils$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.service.SpiritTopicListenerUtils this$0;

    SpiritTopicListenerUtils$1(com.jlboat.phone.service.SpiritTopicListenerUtils p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int16) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int16 p9)
    {
        short v0 = p9.getData();
        if ((v0 > 10) || (com.jlboat.phone.service.SpiritTopicListenerUtils.LOW_BATTERY_SHUTDOWN_FLAG <= 0)) {
            if (v0 <= 10) {
            } else {
                com.boat.utils.ReportExceptionInformationUtils.deleteWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, com.jlboat.phone.service.SpiritTopicListenerUtils.LOW_BATTERY_SHUTDOWN_FLAG);
                com.jlboat.phone.service.SpiritTopicListenerUtils.LOW_BATTERY_SHUTDOWN_FLAG = 15;
            }
        } else {
            com.jlboat.phone.service.SpiritTopicListenerUtils.LOW_BATTERY_SHUTDOWN_FLAG = -1;
            com.jlboat.phone.application.BoatSlamApplication v2_8 = new android.support.v4.app.NotificationCompat$Builder(com.jlboat.phone.application.BoatSlamApplication.mApplication, "low_battery_channel").setSmallIcon(2131427384).setContentTitle(new StringBuilder().append("\u5f53\u524d\u7535\u91cf: ").append(v0).append("%").toString()).setContentText("\u7535\u91cf\u4f4e\u4e8e3%\uff0c\u673a\u5668\u5c06\u81ea\u52a8\u5173\u673a\uff0c\u8bf7\u7ed9\u673a\u5668\u5145\u7535\uff01").setPriority(1).setAutoCancel(1);
            int v3_12 = ((android.app.NotificationManager) com.jlboat.phone.application.BoatSlamApplication.mApplication.getSystemService("notification"));
            if (v3_12 == 0) {
            } else {
                if (android.os.Build$VERSION.SDK_INT >= 26) {
                    v3_12.createNotificationChannel(new android.app.NotificationChannel("low_battery_channel", "\u4f4e\u7535\u91cf\u63d0\u9192", 4));
                }
                v3_12.notify(2, v2_8.build());
                com.boat.utils.ReportExceptionInformationUtils.showWarnMsg(com.jlboat.phone.application.BoatSlamApplication.mApplication, 15, com.jlboat.phone.service.SpiritTopicListenerUtils.LOW_BATTERY_SHUTDOWN_FLAG, "\u673a\u5668\u4eba\u7535\u91cf\u4f4e\u4e8e10%!");
            }
        }
        com.jlboat.phone.application.BoatSlamApplication.power = v0;
        android.util.Log.d("SpiritTopicListenerUtils", new StringBuilder().append("onNewMessage \u7535\u91cf: ").append(com.jlboat.phone.application.BoatSlamApplication.power).toString());
        android.content.Intent v1_7 = new android.content.Intent();
        v1_7.setAction("power");
        v1_7.putExtra("value", com.jlboat.phone.application.BoatSlamApplication.power);
        com.jlboat.phone.application.BoatSlamApplication.mApplication.sendBroadcast(v1_7);
        return;
    }
}
