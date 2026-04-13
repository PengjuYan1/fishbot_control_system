package com.jlboat.phone.service;
 class ErrorMsgService$3 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.service.ErrorMsgService this$0;
    final synthetic boolean[] val$end;

    ErrorMsgService$3(com.jlboat.phone.service.ErrorMsgService p1, boolean[] p2)
    {
        this.this$0 = p1;
        this.val$end = p2;
        return;
    }

    public void run()
    {
        this.val$end[0] = 1;
        com.jlboat.phone.application.BoatSlamApplication.client.connect(new com.jlboat.phone.service.ErrorMsgService$3$1(this));
        while (this.val$end[0]) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }
}
