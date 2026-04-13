package com.jlboat.phone.adapter;
 class CleanAreaRvAdapter$2 implements android.widget.CompoundButton$OnCheckedChangeListener {
    final synthetic com.jlboat.phone.adapter.CleanAreaRvAdapter this$0;
    final synthetic long val$id;

    CleanAreaRvAdapter$2(com.jlboat.phone.adapter.CleanAreaRvAdapter p1, long p2)
    {
        this.this$0 = p1;
        this.val$id = p2;
        return;
    }

    public void onCheckedChanged(android.widget.CompoundButton p4, boolean p5)
    {
        if (com.jlboat.phone.adapter.CleanAreaRvAdapter.access$300(this.this$0) != null) {
            com.jlboat.phone.adapter.CleanAreaRvAdapter.access$300(this.this$0).onCheckedChanged(this.val$id, p5);
        }
        return;
    }
}
