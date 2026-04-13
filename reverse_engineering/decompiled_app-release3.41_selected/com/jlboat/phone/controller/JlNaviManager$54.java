package com.jlboat.phone.controller;
 class JlNaviManager$54 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$54(com.jlboat.phone.controller.JlNaviManager p1)
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
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic getMapStatusMsg: ").append(v0).toString());
        if (v0 != 0) {
            if (v0 == 60) {
                com.jlboat.phone.controller.JlNaviManager.access$5902(this.this$0, "\u673a\u5668\u4eba\u5730\u56fe\u548c\u5bfc\u822a\u70b9\u52a0\u8f7d\u6210\u529f");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$5900(this.this$0));
            }
            if (v0 == 61) {
                com.jlboat.phone.controller.JlNaviManager.access$5902(this.this$0, "\u673a\u5668\u4eba\u5730\u56fe\u52a0\u8f7d\u5931\u8d25\u5bfc\u81f4\u5730\u56fe\u6ca1\u6709\u8d77\u6765\uff0c\u5bfc\u822a\u6a21\u5757\u4e0d\u5de5\u4f5c!");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$5900(this.this$0));
            }
            com.jlboat.phone.controller.JlNaviManager.access$6002(this.this$0, v0);
            if (!com.jlboat.phone.controller.JlNaviManager.access$400(this.this$0)) {
                com.jlboat.phone.controller.JlNaviManager.access$6102(this.this$0, 1);
            }
            return;
        } else {
            return;
        }
    }
}
