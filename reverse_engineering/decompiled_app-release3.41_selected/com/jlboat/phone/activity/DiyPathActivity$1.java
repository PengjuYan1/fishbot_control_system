package com.jlboat.phone.activity;
 class DiyPathActivity$1 extends android.os.Handler {
    final synthetic com.jlboat.phone.activity.DiyPathActivity this$0;

    DiyPathActivity$1(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p6)
    {
        super.handleMessage(p6);
        switch (p6.what) {
            case 1001:
                break;
            case 1002:
                if (com.jlboat.phone.activity.DiyPathActivity.access$000(this.this$0) != null) {
                    com.jlboat.phone.activity.DiyPathActivity.access$000(this.this$0).dismiss();
                }
                if (com.jlboat.phone.activity.DiyPathActivity.access$100(this.this$0) != null) {
                    com.jlboat.phone.activity.DiyPathActivity.access$100(this.this$0).dismiss();
                }
                this.this$0.ll_bt_cs.setVisibility(8);
                this.this$0.bt_add_start.setVisibility(0);
                this.this$0.linesList.clear();
                com.jlboat.phone.activity.DiyPathActivity.access$200(this.this$0).setVisibility(0);
                com.jlboat.phone.activity.DiyPathActivity.access$300(this.this$0).setVisibility(0);
                break;
            case 1003:
                if (com.jlboat.phone.activity.DiyPathActivity.access$100(this.this$0) == null) {
                } else {
                    com.jlboat.phone.activity.DiyPathActivity.access$100(this.this$0).dismiss();
                }
                break;
            case 1004:
                if (com.jlboat.phone.activity.DiyPathActivity.access$400(this.this$0).size() <= 0) {
                    com.jlboat.phone.activity.DiyPathActivity.access$200(this.this$0).setVisibility(8);
                    com.jlboat.phone.activity.DiyPathActivity.access$500(this.this$0).setVisibility(0);
                    com.jlboat.phone.activity.DiyPathActivity.access$900(this.this$0).setVisibility(0);
                    com.jlboat.phone.activity.DiyPathActivity.access$1000(this.this$0).setVisibility(8);
                } else {
                    com.jlboat.phone.activity.DiyPathActivity.access$200(this.this$0).setVisibility(0);
                    com.jlboat.phone.activity.DiyPathActivity.access$500(this.this$0).setVisibility(8);
                    com.jlboat.phone.activity.DiyPathActivity.access$700(this.this$0).setData(com.jlboat.phone.activity.DiyPathActivity.access$400(this.this$0), com.jlboat.phone.activity.DiyPathActivity.access$600(this.this$0));
                    com.jlboat.phone.activity.DiyPathActivity.access$802(this.this$0, ((com.boat.support.slam.entity.floors.GlobalPlans) com.jlboat.phone.activity.DiyPathActivity.access$400(this.this$0).get(com.jlboat.phone.activity.DiyPathActivity.access$600(this.this$0))).getAddPoints());
                    if ((com.jlboat.phone.activity.DiyPathActivity.access$800(this.this$0) == null) || (com.jlboat.phone.activity.DiyPathActivity.access$800(this.this$0).size() <= 0)) {
                        com.jlboat.phone.activity.DiyPathActivity.access$900(this.this$0).setVisibility(0);
                        com.jlboat.phone.activity.DiyPathActivity.access$1000(this.this$0).setVisibility(8);
                    } else {
                        com.jlboat.phone.activity.DiyPathActivity.access$900(this.this$0).setVisibility(8);
                        com.jlboat.phone.activity.DiyPathActivity.access$1000(this.this$0).setVisibility(0);
                        com.jlboat.phone.activity.DiyPathActivity.access$1200(this.this$0).setData(com.jlboat.phone.activity.DiyPathActivity.access$800(this.this$0), com.jlboat.phone.activity.DiyPathActivity.access$1100(this.this$0));
                    }
                }
                break;
            case 1005:
                this.this$0.bt_add_start.setVisibility(0);
                com.jlboat.phone.activity.DiyPathActivity.access$1300(this.this$0).setVisibility(8);
                break;
            default:
        }
        return;
    }
}
