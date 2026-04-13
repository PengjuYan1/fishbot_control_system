package com.jlboat.phone.activity;
 class MapActivity$27 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;
    final synthetic android.widget.Spinner val$floors_bind;
    final synthetic android.widget.Spinner val$point_bind;

    MapActivity$27(com.jlboat.phone.activity.MapActivity p1, android.widget.Spinner p2, android.widget.Spinner p3)
    {
        this.this$0 = p1;
        this.val$floors_bind = p2;
        this.val$point_bind = p3;
        return;
    }

    public void onClick(android.view.View p3)
    {
        this.val$floors_bind.setSelection(0);
        this.val$point_bind.setSelection(0);
        return;
    }
}
