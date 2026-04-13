package com.jlboat.phone.controller;
 class JlNaviManager$38 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$38(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int16) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int16 p8)
    {
        int v3;
        short v0 = p8.getData();
        if (v0 != 31) {
            v3 = 0;
        } else {
            v3 = 1;
        }
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic getEMEMsg:  isEls = ").append(v3).append(", isEmergencyStop = ").append(com.jlboat.phone.controller.JlNaviManager.access$1200(this.this$0)).toString());
        if ((v3 != com.jlboat.phone.controller.JlNaviManager.access$1200(this.this$0)) && (v0 != 0)) {
            com.jlboat.phone.controller.JlNaviManager.access$1202(this.this$0, v3);
            if (v0 == 31) {
                com.jlboat.phone.controller.JlNaviManager.access$4202(this.this$0, "\u673a\u5668\u4eba\u5904\u4e8e\u6025\u505c\u72b6\u6001\uff01\u673a\u5668\u4eba\u7535\u673a\u9501\u4f4f\u4e0d\u52a8");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$4200(this.this$0));
            }
            if (v0 == 32) {
                com.jlboat.phone.controller.JlNaviManager.access$4202(this.this$0, "\u673a\u5668\u4eba\u6025\u505c\u72b6\u6001\u53d6\u6d88");
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$0.getApp(), v0, com.jlboat.phone.controller.JlNaviManager.access$4200(this.this$0));
            }
            com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessage(6);
            com.jlboat.phone.controller.JlNaviManager.access$4302(this.this$0, v0);
            if (!com.jlboat.phone.controller.JlNaviManager.access$400(this.this$0)) {
                com.jlboat.phone.controller.JlNaviManager.access$4402(this.this$0, 1);
            }
            return;
        } else {
            return;
        }
    }
}
