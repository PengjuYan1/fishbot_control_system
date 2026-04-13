package com.jlboat.phone.adapter;
 class ConfigListAdapter$1 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.adapter.ConfigListAdapter this$0;
    final synthetic android.support.v7.widget.RecyclerView$ViewHolder val$holder;
    final synthetic int val$position;

    ConfigListAdapter$1(com.jlboat.phone.adapter.ConfigListAdapter p1, android.support.v7.widget.RecyclerView$ViewHolder p2, int p3)
    {
        this.this$0 = p1;
        this.val$holder = p2;
        this.val$position = p3;
        return;
    }

    public void onClick(android.view.View p6)
    {
        String v0_4 = com.jlboat.phone.adapter.ConfigListAdapter$MsgViewHolder.access$000(((com.jlboat.phone.adapter.ConfigListAdapter$MsgViewHolder) this.val$holder)).getText().toString();
        com.jlboat.phone.adapter.ConfigListAdapter.access$102(this.this$0, com.jlboat.phone.adapter.ConfigListAdapter$MsgViewHolder.access$200(((com.jlboat.phone.adapter.ConfigListAdapter$MsgViewHolder) this.val$holder)).getText().toString());
        android.widget.EditText v1_1 = new android.widget.EditText(com.jlboat.phone.adapter.ConfigListAdapter.access$300(this.this$0));
        v1_1.setText(v0_4);
        android.app.AlertDialog$Builder v2_7 = new android.app.AlertDialog$Builder(com.jlboat.phone.adapter.ConfigListAdapter.access$300(this.this$0));
        v2_7.setTitle("\u8bf7\u8f93\u5165\u4fee\u6539\u7684\u53c2\u6570\u3002");
        v2_7.setView(v1_1);
        v2_7.setPositiveButton("\u786e\u5b9a", new com.jlboat.phone.adapter.ConfigListAdapter$1$1(this, v1_1));
        v2_7.setNegativeButton("\u53d6\u6d88", new com.jlboat.phone.adapter.ConfigListAdapter$1$2(this));
        v2_7.show();
        return;
    }
}
