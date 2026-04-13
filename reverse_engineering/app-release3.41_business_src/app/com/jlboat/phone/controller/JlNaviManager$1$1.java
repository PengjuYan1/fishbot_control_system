package com.jlboat.phone.controller;
 class JlNaviManager$1$1 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.controller.JlNaviManager$1 this$1;

    JlNaviManager$1$1(com.jlboat.phone.controller.JlNaviManager$1 p1)
    {
        this.this$1 = p1;
        return;
    }

    public void run()
    {
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$1.this$0), "handleMessage: ping \u7f51\u5173\u5f00\u59cb");
        if (!this.this$1.this$0.Ping(com.jlboat.phone.application.BoatSlamApplication.gateway_ip)) {
            com.jlboat.phone.controller.JlNaviManager.access$202(this.this$1.this$0, 1001);
            com.jlboat.phone.controller.JlNaviManager.access$302(this.this$1.this$0, "\u8fde\u63a5\u4e0d\u5230\u5bfc\u822a\u8def\u7531\u5668");
            this.this$1.this$0.toast(new StringBuilder().append(com.jlboat.phone.controller.JlNaviManager.access$300(this.this$1.this$0)).append(com.jlboat.phone.controller.JlNaviManager.access$400(this.this$1.this$0)).append(", ispush  = ").append(com.jlboat.phone.controller.JlNaviManager.access$500(this.this$1.this$0)).toString());
            if (!com.jlboat.phone.controller.JlNaviManager.access$400(this.this$1.this$0)) {
                com.jlboat.phone.controller.JlNaviManager.access$602(this.this$1.this$0, 1);
            }
            if ((com.jlboat.phone.controller.JlNaviManager.access$400(this.this$1.this$0)) && (com.jlboat.phone.controller.JlNaviManager.access$500(this.this$1.this$0))) {
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$1.this$0.getApp(), com.jlboat.phone.controller.JlNaviManager.access$200(this.this$1.this$0), com.jlboat.phone.controller.JlNaviManager.access$300(this.this$1.this$0));
            }
            com.jlboat.phone.controller.JlNaviManager.access$100(this.this$1.this$0).sendEmptyMessageDelayed(0, 3000);
        } else {
            android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$1.this$0), "handleMessage: ping \u7f51\u5173\u901a\u8fc7 ");
            com.jlboat.phone.controller.JlNaviManager.access$100(this.this$1.this$0).sendEmptyMessage(2);
        }
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$1.this$0), "handleMessage: ping \u7f51\u5173\u7ed3\u675f");
        return;
    }
}
