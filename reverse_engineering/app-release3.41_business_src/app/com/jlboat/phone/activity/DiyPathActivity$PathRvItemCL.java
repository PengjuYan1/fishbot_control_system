package com.jlboat.phone.activity;
 class DiyPathActivity$PathRvItemCL implements com.jlboat.phone.adapter.DiyPathListAdapter$OnItemClickListener {
    final synthetic com.jlboat.phone.activity.DiyPathActivity this$0;

    private DiyPathActivity$PathRvItemCL(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    synthetic DiyPathActivity$PathRvItemCL(com.jlboat.phone.activity.DiyPathActivity p1, com.jlboat.phone.activity.DiyPathActivity$1 p2)
    {
        this(p1);
        return;
    }

    public void onClick(int p5, android.view.View p6)
    {
        com.jlboat.phone.activity.DiyPathActivity.access$602(this.this$0, p5);
        com.jlboat.phone.activity.DiyPathActivity.access$700(this.this$0).setData(com.jlboat.phone.activity.DiyPathActivity.access$400(this.this$0), p5);
        java.util.List v0_4 = ((com.boat.support.slam.entity.floors.GlobalPlans) com.jlboat.phone.activity.DiyPathActivity.access$400(this.this$0).get(p5)).getAddPoints();
        if ((v0_4 == null) || (v0_4.size() <= 0)) {
            com.jlboat.phone.activity.DiyPathActivity.access$900(this.this$0).setVisibility(0);
            com.jlboat.phone.activity.DiyPathActivity.access$1000(this.this$0).setVisibility(8);
        } else {
            com.jlboat.phone.activity.DiyPathActivity.access$900(this.this$0).setVisibility(8);
            com.jlboat.phone.activity.DiyPathActivity.access$1000(this.this$0).setVisibility(0);
            com.jlboat.phone.activity.DiyPathActivity.access$1200(this.this$0).setData(v0_4, com.jlboat.phone.activity.DiyPathActivity.access$1100(this.this$0));
        }
        if (com.jlboat.phone.activity.DiyPathActivity.access$1800(this.this$0) != null) {
            com.jlboat.phone.activity.DiyPathActivity.access$1800(this.this$0).setSelectedGlobalPlans(((com.boat.support.slam.entity.floors.GlobalPlans) com.jlboat.phone.activity.DiyPathActivity.access$400(this.this$0).get(p5)).getGlobalplanId());
        }
        return;
    }
}
