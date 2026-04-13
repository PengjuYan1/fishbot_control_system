package com.jlboat.phone.controller;
 class JlNaviManager$45 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$45(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int16) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int16 p6)
    {
        short v0 = p6.getData();
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic getLocationMsg: ").append(v0).toString());
        if (v0 == 10) {
            com.jlboat.phone.controller.JlNaviManager.access$5002(this.this$0, "\u673a\u5668\u4eba\u91cd\u65b0\u5b9a\u4f4d\u6210\u529f");
            com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$5000(this.this$0));
        }
        if (v0 == 9) {
            com.jlboat.phone.controller.JlNaviManager.access$5002(this.this$0, "\u673a\u5668\u4eba\u4f4d\u7f6e\u4e22\u5931");
            com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$5000(this.this$0));
        }
        com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessage(13);
        com.jlboat.phone.controller.JlNaviManager.access$1802(this.this$0, v0);
        if (!com.jlboat.phone.controller.JlNaviManager.access$400(this.this$0)) {
            com.jlboat.phone.controller.JlNaviManager.access$5102(this.this$0, 1);
        }
        if ((v0 == 9) || (v0 == 10)) {
            android.content.Intent v1_4 = new android.content.Intent();
            v1_4.setAction("CLEAN_ROBOT_LOCALTION_STATUS");
            v1_4.putExtra("status", v0);
            this.this$0.getApp().sendBroadcast(v1_4);
        }
        return;
    }
}
