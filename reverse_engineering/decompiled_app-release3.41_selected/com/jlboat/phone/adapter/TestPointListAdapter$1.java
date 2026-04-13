package com.jlboat.phone.adapter;
 class TestPointListAdapter$1 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.adapter.TestPointListAdapter this$0;
    final synthetic int val$postion;

    TestPointListAdapter$1(com.jlboat.phone.adapter.TestPointListAdapter p1, int p2)
    {
        this.this$0 = p1;
        this.val$postion = p2;
        return;
    }

    public void onClick(android.view.View p3)
    {
        if (com.jlboat.phone.adapter.TestPointListAdapter.access$000(this.this$0) != null) {
            com.jlboat.phone.adapter.TestPointListAdapter.access$000(this.this$0).onClick(this.val$postion);
        }
        return;
    }
}
