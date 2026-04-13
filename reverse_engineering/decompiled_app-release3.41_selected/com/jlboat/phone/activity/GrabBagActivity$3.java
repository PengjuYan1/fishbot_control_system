package com.jlboat.phone.activity;
 class GrabBagActivity$3 extends android.os.Handler {
    final synthetic com.jlboat.phone.activity.GrabBagActivity this$0;

    GrabBagActivity$3(com.jlboat.phone.activity.GrabBagActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p5)
    {
        switch (p5.what) {
            case 1:
                com.jlboat.phone.activity.GrabBagActivity.access$100(this.this$0).setType(5);
                com.jlboat.phone.activity.GrabBagActivity.access$200(this.this$0).sendEmptyMessageDelayed(1, 3000);
                break;
            case 2:
                com.jlboat.phone.activity.GrabBagActivity.access$700(this.this$0).setMdata(com.jlboat.phone.activity.GrabBagActivity.access$600(this.this$0));
                break;
            default:
        }
        return;
    }
}
