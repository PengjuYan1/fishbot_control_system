package com.jlboat.phone.view;
 class PathItemSettingPopup$1 implements android.view.View$OnTouchListener {
    final synthetic com.jlboat.phone.view.PathItemSettingPopup this$0;

    PathItemSettingPopup$1(com.jlboat.phone.view.PathItemSettingPopup p1)
    {
        this.this$0 = p1;
        return;
    }

    public boolean onTouch(android.view.View p8, android.view.MotionEvent p9)
    {
        if (com.jlboat.phone.view.PathItemSettingPopup.access$000(this.this$0)) {
            int v0_2 = com.jlboat.phone.view.PathItemSettingPopup.access$100(this.this$0).findViewById(2131230973).getTop();
            int v3_3 = com.jlboat.phone.view.PathItemSettingPopup.access$100(this.this$0).findViewById(2131230973).getBottom();
            int v2_1 = com.jlboat.phone.view.PathItemSettingPopup.access$100(this.this$0).findViewById(2131230973).getRight();
            int v4_3 = ((int) p9.getY());
            if ((p9.getAction() == 1) && ((v4_3 < v0_2) || ((((int) p9.getX()) > v2_1) || (v4_3 > v3_3)))) {
                this.this$0.dismiss();
            }
        }
        return 1;
    }
}
