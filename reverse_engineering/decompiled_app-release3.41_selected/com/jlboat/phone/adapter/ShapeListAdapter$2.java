package com.jlboat.phone.adapter;
 class ShapeListAdapter$2 implements android.view.View$OnLongClickListener {
    final synthetic com.jlboat.phone.adapter.ShapeListAdapter this$0;
    final synthetic int val$oederNum;
    final synthetic long val$shapeid;

    ShapeListAdapter$2(com.jlboat.phone.adapter.ShapeListAdapter p1, long p2, int p4)
    {
        this.this$0 = p1;
        this.val$shapeid = p2;
        this.val$oederNum = p4;
        return;
    }

    public boolean onLongClick(android.view.View p5)
    {
        com.jlboat.phone.adapter.ShapeListAdapter.access$200(this.this$0).longclick(this.val$shapeid, this.val$oederNum);
        return 0;
    }
}
