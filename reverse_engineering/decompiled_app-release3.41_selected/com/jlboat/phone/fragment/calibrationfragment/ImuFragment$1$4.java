package com.jlboat.phone.fragment.calibrationfragment;
 class ImuFragment$1$4 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.fragment.calibrationfragment.ImuFragment$1 this$1;
    final synthetic com.jlboat.phone.message.map_msgs.CalculateOdomResponse val$c;

    ImuFragment$1$4(com.jlboat.phone.fragment.calibrationfragment.ImuFragment$1 p1, com.jlboat.phone.message.map_msgs.CalculateOdomResponse p2)
    {
        this.this$1 = p1;
        this.val$c = p2;
        return;
    }

    public void run()
    {
        com.jlboat.phone.util.Utils.toast(com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$000(this.this$1.this$0).getString(2131493303));
        com.jlboat.phone.fragment.calibrationfragment.ImuFragment v0_2 = com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$300(this.this$1.this$0);
        String v1_2 = new StringBuilder().append(": ");
        String v5_0 = new Object[1];
        v5_0[0] = Float.valueOf(this.val$c.getRightmotor_ratio());
        v0_2.setText(v1_2.append(String.format("%.2f", v5_0)).toString());
        com.jlboat.phone.fragment.calibrationfragment.ImuFragment v0_6 = com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$400(this.this$1.this$0);
        String v1_8 = new StringBuilder().append(": ");
        Object[] v4_1 = new Object[1];
        v4_1[0] = Float.valueOf(this.val$c.getLeftmotor_ratio());
        v0_6.setText(v1_8.append(String.format("%.2f", v4_1)).toString());
        com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$500(this.this$1.this$0).setVisibility(0);
        com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$100(this.this$1.this$0).clear();
        com.jlboat.phone.fragment.calibrationfragment.ImuFragment.access$202(this.this$1.this$0, 0);
        return;
    }
}
