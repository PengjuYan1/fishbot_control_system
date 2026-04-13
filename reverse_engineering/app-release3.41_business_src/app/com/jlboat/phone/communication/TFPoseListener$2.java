package com.jlboat.phone.communication;
 class TFPoseListener$2 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.communication.TFPoseListener this$0;

    TFPoseListener$2(com.jlboat.phone.communication.TFPoseListener p1)
    {
        this.this$0 = p1;
        return;
    }

    public void run()
    {
        while (com.jlboat.phone.communication.TFPoseListener.access$100(this.this$0)) {
            try {
                Thread.sleep(200);
                try {
                    com.jlboat.phone.communication.TFPoseListener.access$200(this.this$0);
                } catch (Exception v0_2) {
                    v0_2.printStackTrace();
                }
            } catch (Exception v0_5) {
                v0_5.printStackTrace();
            }
        }
        return;
    }
}
