package com.jlboat.phone.fragment.calibrationfragment;
 class ImuFragment$1$2 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.fragment.calibrationfragment.ImuFragment$1 this$1;
    final synthetic com.jlboat.phone.message.map_msgs.CalculateOdomResponse val$c;

    ImuFragment$1$2(com.jlboat.phone.fragment.calibrationfragment.ImuFragment$1 p1, com.jlboat.phone.message.map_msgs.CalculateOdomResponse p2)
    {
        this.this$1 = p1;
        this.val$c = p2;
        return;
    }

    public void run()
    {
        android.util.Log.d("ImuFragment", new StringBuilder().append("onNewMessage: \u6536\u5230\u8fd4\u56de\u6d88\u606f=").append(this.val$c.toString()).toString());
        com.jlboat.phone.util.Utils.toast(com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$000(this.this$1.this$0).getString(2131493289));
        com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$100(this.this$1.this$0).remove((com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$100(this.this$1.this$0).size() - 1));
        com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$210(this.this$1.this$0);
        return;
    }
}
