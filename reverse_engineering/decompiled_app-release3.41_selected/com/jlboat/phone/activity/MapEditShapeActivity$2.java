package com.jlboat.phone.activity;
 class MapEditShapeActivity$2 implements com.jlboat.phone.adapter.ShapeListAdapter$OnLongClick {
    final synthetic com.jlboat.phone.activity.MapEditShapeActivity this$0;

    MapEditShapeActivity$2(com.jlboat.phone.activity.MapEditShapeActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void longclick(long p5, int p7)
    {
        android.app.AlertDialog$Builder v0_1 = new android.app.AlertDialog$Builder(this.this$0);
        v0_1.setTitle(new StringBuilder().append(this.this$0.getResString(2131493030)).append(" ").append(p7).append("?").toString());
        v0_1.setPositiveButton(2131493023, new com.jlboat.phone.activity.MapEditShapeActivity$2$1(this, p5));
        v0_1.setNegativeButton(2131493007, new com.jlboat.phone.activity.MapEditShapeActivity$2$2(this));
        v0_1.show();
        return;
    }
}
