package com.jlboat.phone.controller;
 class JlNaviManager$52 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$52(com.jlboat.phone.controller.JlNaviManager p1)
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
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic getVirtualMsg: ").append(v0).toString());
        if (v0 != 0) {
            if (v0 == 62) {
                com.jlboat.phone.controller.JlNaviManager.access$5502(this.this$0, "\u673a\u5668\u4eba\u865a\u62df\u5899\u52a0\u8f7d\u6210\u529f");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$5500(this.this$0));
            }
            if (v0 == 63) {
                com.jlboat.phone.controller.JlNaviManager.access$5502(this.this$0, "\u673a\u5668\u4eba\u865a\u62df\u5899\u52a0\u8f7d\u5931\u8d25");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$5500(this.this$0));
            }
            com.jlboat.phone.controller.JlNaviManager.access$5602(this.this$0, v0);
            if (!com.jlboat.phone.controller.JlNaviManager.access$400(this.this$0)) {
                com.jlboat.phone.controller.JlNaviManager.access$5702(this.this$0, 1);
            }
            return;
        } else {
            return;
        }
    }
}
