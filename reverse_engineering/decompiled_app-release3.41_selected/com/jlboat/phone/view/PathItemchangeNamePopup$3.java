package com.jlboat.phone.view;
 class PathItemchangeNamePopup$3 implements android.view.View$OnTouchListener {
    final synthetic com.jlboat.phone.view.PathItemchangeNamePopup this$0;

    PathItemchangeNamePopup$3(com.jlboat.phone.view.PathItemchangeNamePopup p1)
    {
        this.this$0 = p1;
        return;
    }

    public boolean onTouch(android.view.View p8, android.view.MotionEvent p9)
    {
        if (com.jlboat.phone.view.PathItemchangeNamePopup.access$000(this.this$0)) {
            int v0_2 = com.jlboat.phone.view.PathItemchangeNamePopup.access$100(this.this$0).findViewById(2131230847).getTop();
            int v3_3 = com.jlboat.phone.view.PathItemchangeNamePopup.access$100(this.this$0).findViewById(2131230847).getBottom();
            int v2_1 = com.jlboat.phone.view.PathItemchangeNamePopup.access$100(this.this$0).findViewById(2131230847).getRight();
            int v4_3 = ((int) p9.getY());
            if ((p9.getAction() == 1) && ((v4_3 < v0_2) || ((((int) p9.getX()) > v2_1) || (v4_3 > v3_3)))) {
                this.this$0.dismiss();
            }
        }
        return 1;
    }
}
