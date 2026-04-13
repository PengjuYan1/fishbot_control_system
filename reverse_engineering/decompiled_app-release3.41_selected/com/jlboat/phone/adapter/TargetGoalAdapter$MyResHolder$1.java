package com.jlboat.phone.adapter;
 class TargetGoalAdapter$MyResHolder$1 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.adapter.TargetGoalAdapter$MyResHolder this$1;
    final synthetic com.jlboat.phone.adapter.TargetGoalAdapter val$this$0;

    TargetGoalAdapter$MyResHolder$1(com.jlboat.phone.adapter.TargetGoalAdapter$MyResHolder p1, com.jlboat.phone.adapter.TargetGoalAdapter p2)
    {
        this.this$1 = p1;
        this.val$this$0 = p2;
        return;
    }

    public void onClick(android.view.View p3)
    {
        if (com.jlboat.phone.adapter.TargetGoalAdapter.access$000(this.this$1.this$0) != null) {
            int v0_4 = this.this$1.getAdapterPosition();
            if (v0_4 != -1) {
                com.jlboat.phone.adapter.TargetGoalAdapter.access$000(this.this$1.this$0).onItemDelete(v0_4);
            }
        }
        return;
    }
}
