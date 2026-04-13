package com.jlboat.phone.adapter;
 class DiyPathListAdapter$2 implements android.view.View$OnLongClickListener {
    final synthetic com.jlboat.phone.adapter.DiyPathListAdapter this$0;
    final synthetic int val$postion;

    DiyPathListAdapter$2(com.jlboat.phone.adapter.DiyPathListAdapter p1, int p2)
    {
        this.this$0 = p1;
        this.val$postion = p2;
        return;
    }

    public boolean onLongClick(android.view.View p3)
    {
        if (com.jlboat.phone.adapter.DiyPathListAdapter.access$200(this.this$0) != null) {
            com.jlboat.phone.adapter.DiyPathListAdapter.access$200(this.this$0).onLongClick(this.val$postion, p3);
        }
        return 1;
    }
}
