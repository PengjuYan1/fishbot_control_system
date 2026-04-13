package com.jlboat.phone.activity;
 class DiyPointPathActivity$1 extends android.os.Handler {
    final synthetic com.jlboat.phone.activity.DiyPointPathActivity this$0;

    DiyPointPathActivity$1(com.jlboat.phone.activity.DiyPointPathActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p4)
    {
        super.handleMessage(p4);
        switch (p4.what) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                java.util.List v1_2;
                com.jlboat.phone.adapter.NaviListAdapter v0_4 = com.jlboat.phone.activity.DiyPointPathActivity.access$300(this.this$0);
                if (!com.jlboat.phone.activity.DiyPointPathActivity.access$000(this.this$0).isChecked()) {
                    v1_2 = com.jlboat.phone.activity.DiyPointPathActivity.access$200(this.this$0);
                } else {
                    v1_2 = com.jlboat.phone.activity.DiyPointPathActivity.access$100(this.this$0);
                }
                v0_4.setListData(v1_2);
                break;
            default:
                throw new IllegalStateException(new StringBuilder().append("Unexpected value: ").append(p4.what).toString());
        }
        return;
    }
}
