package com.jlboat.phone.fragment.statusfragment;
 class AvoidFillFragment$1$1 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.fragment.statusfragment.AvoidFillFragment$1 this$1;
    final synthetic boolean val$finalflag;

    AvoidFillFragment$1$1(com.jlboat.phone.fragment.statusfragment.AvoidFillFragment$1 p1, boolean p2)
    {
        this.this$1 = p1;
        this.val$finalflag = p2;
        return;
    }

    public void run()
    {
        if (this.val$finalflag) {
            this.this$1.this$0.fill_no_tv.setText(this.this$1.this$0.getString(2131493349));
            com.jlboat.phone.fragment.statusfragment.AvoidFillFragment.access$100(this.this$1.this$0);
        } else {
            this.this$1.this$0.fill_no_tv.setTextColor(this.this$1.this$0.getResources().getColor(2131034237));
            this.this$1.this$0.fill_no_tv.setText(this.this$1.this$0.getString(2131493358));
            com.jlboat.phone.fragment.statusfragment.AvoidFillFragment.access$100(this.this$1.this$0);
        }
        return;
    }
}
