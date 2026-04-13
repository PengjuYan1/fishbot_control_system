package com.jlboat.phone.adapter;
 class DiyPathListAdapter$1 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.adapter.DiyPathListAdapter this$0;
    final synthetic int val$postion;

    DiyPathListAdapter$1(com.jlboat.phone.adapter.DiyPathListAdapter p1, int p2)
    {
        this.this$0 = p1;
        this.val$postion = p2;
        return;
    }

    public void onClick(android.view.View p3)
    {
        if ((com.jlboat.phone.adapter.DiyPathListAdapter.access$000(this.this$0) != null) && (com.jlboat.phone.adapter.DiyPathListAdapter.access$100(this.this$0) != this.val$postion)) {
            com.jlboat.phone.adapter.DiyPathListAdapter.access$000(this.this$0).onClick(this.val$postion, p3);
        }
        return;
    }
}
