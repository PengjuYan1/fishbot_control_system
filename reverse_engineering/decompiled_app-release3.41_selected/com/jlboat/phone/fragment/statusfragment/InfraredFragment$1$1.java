package com.jlboat.phone.fragment.statusfragment;
 class InfraredFragment$1$1 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.fragment.statusfragment.InfraredFragment$1 this$1;
    final synthetic com.jlboat.phone.message.map_msgs.RobotIrCode val$robotIrCode;

    InfraredFragment$1$1(com.jlboat.phone.fragment.statusfragment.InfraredFragment$1 p1, com.jlboat.phone.message.map_msgs.RobotIrCode p2)
    {
        this.this$1 = p1;
        this.val$robotIrCode = p2;
        return;
    }

    public void run()
    {
        int v0_2;
        com.jlboat.phone.view.CustomProgress v1 = com.jlboat.phone.fragment.statusfragment.InfraredFragment.access$000(this.this$1.this$0);
        if (this.val$robotIrCode.getLeftcode1() != 1) {
            v0_2 = 0;
        } else {
            v0_2 = 1;
        }
        int v4_2;
        if (this.val$robotIrCode.getLeftcode2() != 1) {
            v4_2 = 0;
        } else {
            v4_2 = 1;
        }
        int v5_2;
        if (this.val$robotIrCode.getLeftcode3() != 1) {
            v5_2 = 0;
        } else {
            v5_2 = 1;
        }
        int v6_2;
        if (this.val$robotIrCode.getFrontcode1() != 1) {
            v6_2 = 0;
        } else {
            v6_2 = 1;
        }
        int v7_2;
        if (this.val$robotIrCode.getFrontcode2() != 1) {
            v7_2 = 0;
        } else {
            v7_2 = 1;
        }
        int v8_2;
        if (this.val$robotIrCode.getFrontcode3() != 1) {
            v8_2 = 0;
        } else {
            v8_2 = 1;
        }
        int v9_2;
        if (this.val$robotIrCode.getRightcode1() != 1) {
            v9_2 = 0;
        } else {
            v9_2 = 1;
        }
        int v10_2;
        if (this.val$robotIrCode.getRightcode2() != 1) {
            v10_2 = 0;
        } else {
            v10_2 = 1;
        }
        int v11_2;
        if (this.val$robotIrCode.getRightcode3() != 1) {
            v11_2 = 0;
        } else {
            v11_2 = 1;
        }
        v1.setColors(v0_2, v4_2, v5_2, v6_2, v7_2, v8_2, v9_2, v10_2, v11_2);
        return;
    }
}
