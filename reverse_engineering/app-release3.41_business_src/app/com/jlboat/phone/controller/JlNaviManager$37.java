package com.jlboat.phone.controller;
 class JlNaviManager$37 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$37(com.jlboat.phone.controller.JlNaviManager p1)
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
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic getInitMsg: data ").append(v0).toString());
        if (v0 == 12) {
            com.jlboat.phone.controller.JlNaviManager.access$902(this.this$0, 1);
            com.jlboat.phone.controller.JlNaviManager.access$3802(this.this$0, "\u673a\u5668\u4eba\u521d\u59cb\u5316\u6210\u529f\uff0c\u5bfc\u822a\u5df2\u5c31\u7eea");
            com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$3800(this.this$0));
            com.jlboat.phone.controller.JlNaviManager.access$3900(this.this$0);
            com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessage(9);
        }
        if (v0 == 11) {
            com.jlboat.phone.controller.JlNaviManager.access$3802(this.this$0, "\u673a\u5668\u4eba\u5bfc\u822a\u521d\u59cb\u5316\u5931\u8d25\uff0c\u5bfc\u822a\u6a21\u5757\u4e0d\u5de5\u4f5c!");
            com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$3800(this.this$0));
        }
        com.jlboat.phone.controller.JlNaviManager.access$4002(this.this$0, v0);
        if (!com.jlboat.phone.controller.JlNaviManager.access$400(this.this$0)) {
            com.jlboat.phone.controller.JlNaviManager.access$4102(this.this$0, 1);
        }
        if (!this.this$0.isInitEnd) {
            com.jlboat.phone.controller.JlNaviManager.access$2300(this.this$0);
        }
        return;
    }
}
