package com.jlboat.phone.adapter;
 class CleanAreaRvAdapter$1 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.adapter.CleanAreaRvAdapter this$0;
    final synthetic long val$id;
    final synthetic String val$name;

    CleanAreaRvAdapter$1(com.jlboat.phone.adapter.CleanAreaRvAdapter p1, long p2, String p4)
    {
        this.this$0 = p1;
        this.val$id = p2;
        this.val$name = p4;
        return;
    }

    public void onClick(android.view.View p5)
    {
        if (com.jlboat.phone.adapter.CleanAreaRvAdapter.access$100(this.this$0) != null) {
            com.jlboat.phone.adapter.CleanAreaRvAdapter.access$100(this.this$0).click(this.val$id, this.val$name);
        }
        return;
    }
}
