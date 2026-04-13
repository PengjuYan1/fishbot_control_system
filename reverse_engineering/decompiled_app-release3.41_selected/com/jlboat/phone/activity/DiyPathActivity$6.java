package com.jlboat.phone.activity;
 class DiyPathActivity$6 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.DiyPathActivity this$0;
    final synthetic int val$useType;

    DiyPathActivity$6(com.jlboat.phone.activity.DiyPathActivity p1, int p2)
    {
        this.this$0 = p1;
        this.val$useType = p2;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SetGlobalPlanResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SetGlobalPlanResponse p6)
    {
        com.jlboat.phone.activity.DiyPathActivity.access$2402(this.this$0, p6.isResult());
        if (!p6.isResult()) {
            if (this.val$useType != 1) {
                if (this.val$useType != 2) {
                    com.jlboat.phone.activity.DiyPathActivity.access$2000(this.this$0).sendEmptyMessage(1003);
                } else {
                    com.jlboat.phone.activity.DiyPathActivity.access$2000(this.this$0).sendEmptyMessage(1002);
                }
            } else {
                com.jlboat.phone.activity.DiyPathActivity.access$2000(this.this$0).sendEmptyMessage(1003);
                this.this$0.linesList.remove((this.this$0.linesList.size() - 1));
                this.this$0.toast(2131493263);
            }
        } else {
            if (this.val$useType != 1) {
                if (this.val$useType != 2) {
                    com.jlboat.phone.activity.DiyPathActivity.access$602(this.this$0, 0);
                    com.jlboat.phone.activity.DiyPathActivity.access$2000(this.this$0).sendEmptyMessage(1003);
                    com.jlboat.phone.activity.DiyPathActivity.access$2000(this.this$0).sendEmptyMessage(1004);
                } else {
                    com.jlboat.phone.activity.DiyPathActivity.access$2000(this.this$0).sendEmptyMessage(1002);
                }
            } else {
                com.jlboat.phone.activity.DiyPathActivity.access$2000(this.this$0).sendEmptyMessage(1003);
            }
        }
        com.jlboat.phone.activity.DiyPathActivity.access$2202(this.this$0, 1);
        return;
    }
}
