package com.jlboat.phone.adapter;
 class ShapeListAdapter$1 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.adapter.ShapeListAdapter this$0;
    final synthetic int val$oederNum;
    final synthetic long val$shapeid;

    ShapeListAdapter$1(com.jlboat.phone.adapter.ShapeListAdapter p1, long p2, int p4)
    {
        this.this$0 = p1;
        this.val$shapeid = p2;
        this.val$oederNum = p4;
        return;
    }

    public void onClick(android.view.View p5)
    {
        if (com.jlboat.phone.adapter.ShapeListAdapter.access$100(this.this$0) != null) {
            com.jlboat.phone.adapter.ShapeListAdapter.access$100(this.this$0).click(this.val$shapeid, this.val$oederNum);
        }
        return;
    }
}
