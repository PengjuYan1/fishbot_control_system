package com.jlboat.phone.fragment.statusfragment;
 class InfraredFragment$2$1 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.fragment.statusfragment.InfraredFragment$2 this$1;

    InfraredFragment$2$1(com.jlboat.phone.fragment.statusfragment.InfraredFragment$2 p1)
    {
        this.this$1 = p1;
        return;
    }

    public void run()
    {
        if (!com.jlboat.phone.fragment.statusfragment.InfraredFragment.access$100(this.this$1.this$0)) {
            com.jlboat.phone.fragment.statusfragment.InfraredFragment.access$200(this.this$1.this$0).setChecked(1);
            com.jlboat.phone.fragment.statusfragment.InfraredFragment.access$102(this.this$1.this$0, 1);
        } else {
            com.jlboat.phone.fragment.statusfragment.InfraredFragment.access$200(this.this$1.this$0).setChecked(0);
            com.jlboat.phone.fragment.statusfragment.InfraredFragment.access$102(this.this$1.this$0, 0);
            com.jlboat.phone.fragment.statusfragment.InfraredFragment.access$000(this.this$1.this$0).setColors(0, 0, 0, 0, 0, 0, 0, 0, 0);
        }
        return;
    }
}
