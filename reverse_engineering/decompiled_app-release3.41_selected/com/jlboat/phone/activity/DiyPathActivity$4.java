package com.jlboat.phone.activity;
 class DiyPathActivity$4 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.DiyPathActivity this$0;

    DiyPathActivity$4(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onClick(android.view.View p11)
    {
        if (com.jlboat.phone.activity.DiyPathActivity.access$000(this.this$0).pathName.isEmpty()) {
            this.this$0.toast(2131493108);
        } else {
            if ((com.jlboat.phone.activity.DiyPathActivity.access$400(this.this$0) != null) && (com.jlboat.phone.activity.DiyPathActivity.access$400(this.this$0).size() > 0)) {
                com.jlboat.phone.activity.DiyPathActivity v0_9 = com.jlboat.phone.activity.DiyPathActivity.access$400(this.this$0).iterator();
                while (v0_9.hasNext()) {
                    if (com.jlboat.phone.activity.DiyPathActivity.access$000(this.this$0).pathName.equals(((com.boat.support.slam.entity.floors.GlobalPlans) v0_9.next()).getGlobalplanName())) {
                        this.this$0.toast(2131493260);
                        return;
                    }
                }
            }
            if (com.jlboat.phone.activity.DiyPathActivity.access$000(this.this$0).directional == -1) {
                this.this$0.toast(2131493262);
            } else {
                if (!com.jlboat.phone.activity.DiyPathActivity.access$2200(this.this$0)) {
                    return;
                } else {
                    com.jlboat.phone.activity.DiyPathActivity.access$2202(this.this$0, 0);
                    com.jlboat.phone.activity.DiyPathActivity.access$2300(this.this$0, 0, com.jlboat.phone.activity.DiyPathActivity.access$000(this.this$0).pathName, 0, com.jlboat.phone.activity.DiyPathActivity.access$000(this.this$0).directional, 2, this.this$0.getResString(2131493126));
                }
            }
        }
        return;
    }
}
