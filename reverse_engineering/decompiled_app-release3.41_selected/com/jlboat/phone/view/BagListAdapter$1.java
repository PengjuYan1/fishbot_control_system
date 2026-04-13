package com.jlboat.phone.view;
 class BagListAdapter$1 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.view.BagListAdapter this$0;
    final synthetic String val$s;

    BagListAdapter$1(com.jlboat.phone.view.BagListAdapter p1, String p2)
    {
        this.this$0 = p1;
        this.val$s = p2;
        return;
    }

    public void onClick(android.view.View p3)
    {
        android.util.Log.d("TAG", new StringBuilder().append("onBindViewHolder: ").append(this.val$s).toString());
        return;
    }
}
