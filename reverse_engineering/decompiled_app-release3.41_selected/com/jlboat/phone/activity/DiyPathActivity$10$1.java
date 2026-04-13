package com.jlboat.phone.activity;
 class DiyPathActivity$10$1 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.DiyPathActivity$10 this$1;

    DiyPathActivity$10$1(com.jlboat.phone.activity.DiyPathActivity$10 p1)
    {
        this.this$1 = p1;
        return;
    }

    public void onClick(android.view.View p10)
    {
        if (!com.jlboat.phone.activity.DiyPathActivity.access$2200(this.this$1.this$0)) {
            return;
        } else {
            com.jlboat.phone.activity.DiyPathActivity.access$2202(this.this$1.this$0, 0);
            com.jlboat.phone.activity.DiyPathActivity.access$2300(this.this$1.this$0, this.this$1.val$globalPlans.getGlobalplanId(), this.this$1.val$globalPlans.getGlobalplanName(), 0, this.this$1.val$globalPlans.getDir(), 3, "\u5220\u9664\u4e2d...");
            com.jlboat.phone.activity.DiyPathActivity.access$2900(this.this$1.this$0).dismiss();
            return;
        }
    }
}
