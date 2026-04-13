package com.jlboat.phone.service;
 class ErrorMsgService$1 extends android.os.Handler {
    final synthetic com.jlboat.phone.service.ErrorMsgService this$0;

    ErrorMsgService$1(com.jlboat.phone.service.ErrorMsgService p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p6)
    {
        super.handleMessage(p6);
        switch (p6.what) {
            case 1:
                android.widget.Toast.makeText(this.this$0.getApplicationContext(), "\u83b7\u53d6\u673a\u5668\u4fe1\u606f\u6210\u529f", 0).show();
                break;
            case 2:
                android.widget.Toast.makeText(this.this$0.getApplicationContext(), "\u83b7\u53d6\u673a\u5668\u4fe1\u606f\u5931\u8d25", 0).show();
                break;
            case 3:
                android.util.Log.e("ErrorMsgService", "handleMessage: wifi\u53d8\u5316 \u91cd\u65b0\u767b\u5f55");
                com.jlboat.phone.application.BoatSlamApplication.isShutDown = 0;
                this.this$0.isrestar = 1;
                android.content.Intent v0_33 = new android.content.Intent();
                v0_33.setAction("Finish");
                this.this$0.sendBroadcast(v0_33);
                this.this$0.stopForeground(1);
                this.this$0.stopSelf();
                break;
            case 101:
                android.content.Intent v0_28 = new android.content.Intent();
                v0_28.setAction("WIFICONNECTED_STATE");
                v0_28.putExtra("state", com.jlboat.phone.service.ErrorMsgService.access$100(this.this$0));
                v0_28.putExtra("count", com.jlboat.phone.service.ErrorMsgService.access$200(this.this$0));
                this.this$0.sendBroadcast(v0_28);
                break;
            case 102:
                if (!com.jlboat.phone.application.BoatSlamApplication.hasHeart) {
                    android.util.Log.e("ErrorMsgService", "handleMessage: \u5fc3\u8df3\u6d88\u5931 \u8df3\u8f6c\u767b\u5f55");
                    android.widget.Toast.makeText(this.this$0.mContext.getApplicationContext(), "\u6570\u636e\u5f02\u5e38\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55", 0).show();
                    com.jlboat.phone.application.BoatSlamApplication.isShutDown = 0;
                    this.this$0.isrestar = 1;
                    android.content.Intent v0_23 = new android.content.Intent();
                    v0_23.setClass(this.this$0.mContext, com.jlboat.phone.LoginActivity);
                    v0_23.addFlags(268435456);
                    this.this$0.startActivity(v0_23);
                    this.this$0.stopForeground(1);
                    this.this$0.stopSelf();
                } else {
                    com.jlboat.phone.application.BoatSlamApplication.hasHeart = 0;
                    com.jlboat.phone.service.ErrorMsgService.access$000(this.this$0).sendEmptyMessageDelayed(102, 10000);
                }
                break;
            case 103:
                android.widget.Toast.makeText(this.this$0.mContext.getApplicationContext(), "\u8fde\u63a5\u65ad\u5f00\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55", 0).show();
                this.this$0.stopForeground(1);
                this.this$0.stopSelf();
                android.content.Intent v0_14 = new android.content.Intent();
                v0_14.setAction("Finish");
                this.this$0.sendBroadcast(v0_14);
                break;
            case 104:
                android.content.Intent v0_29 = new android.content.Intent();
                v0_29.setAction("login_re");
                this.this$0.sendBroadcast(v0_29);
                this.this$0.stopForeground(1);
                this.this$0.stopSelf();
                break;
            default:
        }
        return;
    }
}
