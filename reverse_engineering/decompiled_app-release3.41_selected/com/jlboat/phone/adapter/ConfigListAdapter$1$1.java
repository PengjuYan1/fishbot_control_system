package com.jlboat.phone.adapter;
 class ConfigListAdapter$1$1 implements android.content.DialogInterface$OnClickListener {
    final synthetic com.jlboat.phone.adapter.ConfigListAdapter$1 this$1;
    final synthetic android.widget.EditText val$editText1;

    ConfigListAdapter$1$1(com.jlboat.phone.adapter.ConfigListAdapter$1 p1, android.widget.EditText p2)
    {
        this.this$1 = p1;
        this.val$editText1 = p2;
        return;
    }

    public void onClick(android.content.DialogInterface p5, int p6)
    {
        p5.dismiss();
        String v0_2 = this.val$editText1.getText().toString();
        ((com.jlboat.phone.message.map_msgs.Config) com.jlboat.phone.adapter.ConfigListAdapter.access$400(this.this$1.this$0).get(this.this$1.val$position)).setConfigName(com.jlboat.phone.adapter.ConfigListAdapter.access$100(this.this$1.this$0));
        ((com.jlboat.phone.message.map_msgs.Config) com.jlboat.phone.adapter.ConfigListAdapter.access$400(this.this$1.this$0).get(this.this$1.val$position)).setConfigValue(v0_2);
        java.util.LinkedList v1_8 = new java.util.LinkedList();
        v1_8.add(((com.jlboat.phone.message.map_msgs.Config) com.jlboat.phone.adapter.ConfigListAdapter.access$400(this.this$1.this$0).get(this.this$1.val$position)));
        com.jlboat.phone.adapter.ConfigListAdapter.access$500(this.this$1.this$0, v1_8);
        return;
    }
}
