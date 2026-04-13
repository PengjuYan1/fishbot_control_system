package com.jlboat.phone.view;
 class SavaPathPopup$3 implements android.view.View$OnTouchListener {
    final synthetic com.jlboat.phone.view.SavaPathPopup this$0;

    SavaPathPopup$3(com.jlboat.phone.view.SavaPathPopup p1)
    {
        this.this$0 = p1;
        return;
    }

    public boolean onTouch(android.view.View p5, android.view.MotionEvent p6)
    {
        if (com.jlboat.phone.view.SavaPathPopup.access$000(this.this$0)) {
            int v0_2 = com.jlboat.phone.view.SavaPathPopup.access$100(this.this$0).findViewById(2131230972).getTop();
            if ((p6.getAction() == 1) && (((int) p6.getY()) < v0_2)) {
                this.this$0.dismiss();
            }
        }
        return 1;
    }
}
