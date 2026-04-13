package com.jlboat.phone.adapter;
 class LiftQueueAdapter$MyResHolder$1 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.adapter.LiftQueueAdapter$MyResHolder this$1;
    final synthetic com.jlboat.phone.adapter.LiftQueueAdapter val$this$0;

    LiftQueueAdapter$MyResHolder$1(com.jlboat.phone.adapter.LiftQueueAdapter$MyResHolder p1, com.jlboat.phone.adapter.LiftQueueAdapter p2)
    {
        this.this$1 = p1;
        this.val$this$0 = p2;
        return;
    }

    public void onClick(android.view.View p3)
    {
        if (com.jlboat.phone.adapter.LiftQueueAdapter.access$000(this.this$1.this$0) != null) {
            int v0_4 = this.this$1.getAdapterPosition();
            if (v0_4 != -1) {
                com.jlboat.phone.adapter.LiftQueueAdapter.access$000(this.this$1.this$0).onItemDelete(v0_4);
            }
        }
        return;
    }
}
