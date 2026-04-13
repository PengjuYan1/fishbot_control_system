package com.jlboat.phone.adapter;
 class NgLineListAdapter$1 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.adapter.NgLineListAdapter this$0;
    final synthetic int val$oederNum;
    final synthetic long val$shapeid;

    NgLineListAdapter$1(com.jlboat.phone.adapter.NgLineListAdapter p1, long p2, int p4)
    {
        this.this$0 = p1;
        this.val$shapeid = p2;
        this.val$oederNum = p4;
        return;
    }

    public void onClick(android.view.View p5)
    {
        if (com.jlboat.phone.adapter.NgLineListAdapter.access$100(this.this$0) != null) {
            com.jlboat.phone.adapter.NgLineListAdapter.access$100(this.this$0).click(this.val$shapeid, this.val$oederNum);
        }
        return;
    }
}
