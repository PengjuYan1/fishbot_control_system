package com.jlboat.phone.service;
 class ErrorMsgService$3$1 implements com.boat.jrosbridge.ROSClient$ConnectionStatusListener {
    final synthetic com.jlboat.phone.service.ErrorMsgService$3 this$1;

    ErrorMsgService$3$1(com.jlboat.phone.service.ErrorMsgService$3 p1)
    {
        this.this$1 = p1;
        return;
    }

    public void onConnect()
    {
        android.util.Log.d("ErrorMsgService", "ROSBridgeClient onConnect: ws \u6210\u529f");
        android.content.Intent v0_2 = new android.content.Intent();
        v0_2.setAction("login_succ");
        this.this$1.this$0.sendBroadcast(v0_2);
        this.this$1.this$0.initTopic();
        this.this$1.this$0.initService();
        return;
    }

    public void onDisconnect(boolean p3, String p4, int p5)
    {
        android.util.Log.d("ErrorMsgService", new StringBuilder().append("ROSBridgeClient onDisconnect: code ").append(p5).toString());
        if (p5 >= 0) {
            if ((p5 != 1000) && (p5 > 1000)) {
                com.jlboat.phone.service.ErrorMsgService.access$000(this.this$1.this$0).sendEmptyMessage(103);
            }
        } else {
            com.jlboat.phone.service.ErrorMsgService.access$000(this.this$1.this$0).sendEmptyMessage(104);
        }
        this.this$1.val$end[0] = 0;
        return;
    }

    public void onError(Exception p3)
    {
        android.util.Log.d("ErrorMsgService", "ROSBridgeClient onError: ");
        p3.printStackTrace();
        this.this$1.val$end[0] = 0;
        return;
    }
}
