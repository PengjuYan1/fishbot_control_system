package com.jlboat.phone.base;
 class BaseFragment$1 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.base.BaseFragment this$0;
    final synthetic CharSequence val$str;

    BaseFragment$1(com.jlboat.phone.base.BaseFragment p1, CharSequence p2)
    {
        this.this$0 = p1;
        this.val$str = p2;
        return;
    }

    public void run()
    {
        android.widget.Toast.makeText(this.this$0.act, this.val$str, 0).show();
        return;
    }
}
