package com.jlboat.phone.controller;
 class JlNaviManager$55 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$55(com.jlboat.phone.controller.JlNaviManager p1)
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
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic getMapBuildStatusMsg: ").append(v0).toString());
        if (v0 != 0) {
            if (v0 == 68) {
                com.jlboat.phone.controller.JlNaviManager.access$6202(this.this$0, 1);
                com.boat.utils.ReportExceptionInformationUtils.upload(this.this$0.getApp(), v0, "\u673a\u5668\u4eba\u5904\u4e8e\u65b0\u5efa\u5730\u56fe\u6a21\u5f0f\uff0c\u8bf7\u626b\u63cf\u65b0\u5efa\u5730\u56fe!");
            }
            if (v0 == 70) {
                com.jlboat.phone.controller.JlNaviManager.access$6202(this.this$0, 0);
                com.boat.utils.ReportExceptionInformationUtils.upload(this.this$0.getApp(), v0, "\u673a\u5668\u4eba\u5904\u4e8e\u52a0\u8f7d\u5730\u56fe\u6a21\u5f0f\uff0c\u53ef\u4ee5\u6b63\u5e38\u5bfc\u822a!");
            }
            return;
        } else {
            return;
        }
    }
}
