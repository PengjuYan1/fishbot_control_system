package com.jlboat.phone.fragment.statusfragment;
 class LoraFragment$3$1 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.fragment.statusfragment.LoraFragment$3 this$1;
    final synthetic com.jlboat.phone.message.map_msgs.Config val$config;

    LoraFragment$3$1(com.jlboat.phone.fragment.statusfragment.LoraFragment$3 p1, com.jlboat.phone.message.map_msgs.Config p2)
    {
        this.this$1 = p1;
        this.val$config = p2;
        return;
    }

    public void run()
    {
        if (!this.val$config.getConfigValue().equals("True")) {
            com.jlboat.phone.fragment.statusfragment.LoraFragment.access$400(this.this$1.this$0).setText(this.this$1.this$0.getString(2131492939));
        } else {
            com.jlboat.phone.fragment.statusfragment.LoraFragment.access$400(this.this$1.this$0).setText(this.this$1.this$0.getString(2131492938));
            com.jlboat.phone.fragment.statusfragment.LoraFragment.access$500(this.this$1.this$0).setVisibility(0);
        }
        com.jlboat.phone.fragment.statusfragment.LoraFragment.access$400(this.this$1.this$0).setVisibility(0);
        return;
    }
}
