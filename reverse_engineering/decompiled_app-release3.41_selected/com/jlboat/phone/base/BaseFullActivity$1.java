package com.jlboat.phone.base;
 class BaseFullActivity$1 extends android.os.Handler {
    final synthetic com.jlboat.phone.base.BaseFullActivity this$0;

    BaseFullActivity$1(com.jlboat.phone.base.BaseFullActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p3)
    {
        super.handleMessage(p3);
        switch (p3.what) {
            case 100:
                if (!com.jlboat.phone.base.BaseFullActivity.access$000(this.this$0)) {
                    com.jlboat.phone.base.BaseFullActivity.access$002(this.this$0, 1);
                    com.jlboat.phone.base.BaseFullActivity.access$100(this.this$0).setVisibility(8);
                } else {
                    com.jlboat.phone.base.BaseFullActivity.access$002(this.this$0, 0);
                    com.jlboat.phone.base.BaseFullActivity.access$100(this.this$0).setVisibility(0);
                }
                android.content.Intent v0_7 = new android.content.Intent();
                v0_7.setAction("ERRMSG_UPDATE");
                this.this$0.sendBroadcast(v0_7);
                break;
            default:
        }
        return;
    }
}
