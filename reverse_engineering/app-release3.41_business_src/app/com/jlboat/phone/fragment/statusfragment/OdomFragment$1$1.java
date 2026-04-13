package com.jlboat.phone.fragment.statusfragment;
 class OdomFragment$1$1 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.fragment.statusfragment.OdomFragment$1 this$1;

    OdomFragment$1$1(com.jlboat.phone.fragment.statusfragment.OdomFragment$1 p1)
    {
        this.this$1 = p1;
        return;
    }

    public void run()
    {
        this.this$1.this$0.odom_no_tv.setTextColor(this.this$1.this$0.getResources().getColor(2131034237));
        this.this$1.this$0.odom_no_tv.setText(this.this$1.this$0.getString(2131493358));
        this.this$1.this$0.addDataAdapter.notifyDataSetChanged();
        return;
    }
}
