package com.jlboat.phone.adapter;
 class BindPointListAdapter$1 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.adapter.BindPointListAdapter this$0;
    final synthetic com.jlboat.phone.adapter.BindPointListAdapter$MyHolder val$myHolder;
    final synthetic int val$postion;

    BindPointListAdapter$1(com.jlboat.phone.adapter.BindPointListAdapter p1, int p2, com.jlboat.phone.adapter.BindPointListAdapter$MyHolder p3)
    {
        this.this$0 = p1;
        this.val$postion = p2;
        this.val$myHolder = p3;
        return;
    }

    public void onClick(android.view.View p4)
    {
        if (com.jlboat.phone.adapter.BindPointListAdapter.access$000(this.this$0) != null) {
            com.jlboat.phone.adapter.BindPointListAdapter.access$000(this.this$0).onClick(this.val$postion, this.val$myHolder.tv.getText().toString());
        }
        return;
    }
}
