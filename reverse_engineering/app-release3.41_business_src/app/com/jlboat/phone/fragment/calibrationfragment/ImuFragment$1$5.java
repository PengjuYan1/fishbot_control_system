package com.jlboat.phone.fragment.calibrationfragment;
 class ImuFragment$1$5 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.fragment.calibrationfragment.ImuFragment$1 this$1;
    final synthetic com.jlboat.phone.message.map_msgs.CalculateOdomResponse val$message;

    ImuFragment$1$5(com.jlboat.phone.fragment.calibrationfragment.ImuFragment$1 p1, com.jlboat.phone.message.map_msgs.CalculateOdomResponse p2)
    {
        this.this$1 = p1;
        this.val$message = p2;
        return;
    }

    public void run()
    {
        android.util.Log.d("ImuFragment", new StringBuilder().append("cList: \u5927\u5c0f=").append(com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$100(this.this$1.this$0).size()).toString());
        android.util.Log.d("ImuFragment", new StringBuilder().append("onNewMessage: \u6536\u5230\u8fd4\u56de\u6d88\u606f=").append(this.val$message.toString()).toString());
        android.util.Log.d("ImuFragment", new StringBuilder().append("cList: \u6536\u5230\u8fd4\u56de\u6d88\u606f=").append(com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$100(this.this$1.this$0).toString()).toString());
        com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$600(this.this$1.this$0).setData(com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$100(this.this$1.this$0), this.this$1.val$date, com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$200(this.this$1.this$0));
        return;
    }
}
