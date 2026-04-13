package com.jlboat.phone.controller;
 class JlNaviManager$60 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$60(com.jlboat.phone.controller.JlNaviManager p1)
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
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic getNaviNetworkMsg: ").append(v0).toString());
        if (v0 != 0) {
            if (v0 == 21) {
                com.jlboat.phone.controller.JlNaviManager.access$7202(this.this$0, "\u673a\u5668\u4eba\u5bfc\u822a\u6a21\u5757\u8054\u7f51\u5931\u8d25\uff01");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$7200(this.this$0));
            }
            if (v0 == 22) {
                com.jlboat.phone.controller.JlNaviManager.access$7202(this.this$0, "\u673a\u5668\u4eba\u5bfc\u822a\u6a21\u5757\u8054\u7f51\u6210\u529f\uff01");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$7200(this.this$0));
            }
            com.jlboat.phone.controller.JlNaviManager.access$1702(this.this$0, v0);
            if (!com.jlboat.phone.controller.JlNaviManager.access$400(this.this$0)) {
                com.jlboat.phone.controller.JlNaviManager.access$7302(this.this$0, 1);
            }
            com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessage(22);
            return;
        } else {
            return;
        }
    }
}
