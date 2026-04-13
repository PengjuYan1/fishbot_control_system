package com.jlboat.phone.controller;
 class JlNaviManager$7 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$7(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.GetLogResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.GetLogResponse p6)
    {
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("onSuccess: getAndUploadLog").append(p6.getStatus()).toString());
        String v1_0 = p6.getLogName();
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("onSuccess: getAndUploadLog ").append(v1_0).toString());
        if ((v1_0 != null) && (!v1_0.isEmpty())) {
            android.content.Intent v2_6 = new android.content.Intent();
            v2_6.setClassName("com.jlboat.phone", "com.jlboat.phone.service.DownloadFileService");
            v2_6.setAction("download_log");
            v2_6.putExtra("logName", v1_0);
            this.this$0.getApp().startService(v2_6);
            return;
        } else {
            return;
        }
    }
}
