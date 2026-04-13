package com.jlboat.phone.adapter;
 class CleanAreaRvAdapter$3 implements android.view.View$OnLongClickListener {
    final synthetic com.jlboat.phone.adapter.CleanAreaRvAdapter this$0;
    final synthetic long val$id;
    final synthetic String val$name;

    CleanAreaRvAdapter$3(com.jlboat.phone.adapter.CleanAreaRvAdapter p1, long p2, String p4)
    {
        this.this$0 = p1;
        this.val$id = p2;
        this.val$name = p4;
        return;
    }

    public boolean onLongClick(android.view.View p5)
    {
        com.jlboat.phone.adapter.CleanAreaRvAdapter.access$500(this.this$0).longclick(this.val$id, this.val$name);
        return 0;
    }
}
