package com.jlboat.phone.controller;
 class JlNaviManager$8 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$8(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.BagListResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.BagListResponse p4)
    {
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), "onSuccess: getAndUploadBag ");
        if (p4.getStatus() == 0) {
            android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("onSuccess: getAndUploadBag ").append(p4.getBagNames()).toString());
            if ((p4.getBagNames() != null) && (!p4.getBagNames().isEmpty())) {
                android.content.Intent v0_7 = new android.content.Intent();
                v0_7.setClassName("com.jlboat.phone", "com.jlboat.phone.service.DownloadFileService");
                v0_7.setAction("download_bags");
                v0_7.putStringArrayListExtra("bags", ((java.util.ArrayList) p4.getBagNames()));
                this.this$0.getApp().startService(v0_7);
            } else {
                return;
            }
        }
        return;
    }
}
