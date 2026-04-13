package com.jlboat.phone.activity;
 class MapEditShapeActivity$1 implements com.jlboat.phone.adapter.ShapeListAdapter$OnClick {
    final synthetic com.jlboat.phone.activity.MapEditShapeActivity this$0;

    MapEditShapeActivity$1(com.jlboat.phone.activity.MapEditShapeActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void click(long p5, int p7)
    {
        if (this.this$0.mapView != null) {
            this.this$0.mapView.setTagShapeId(p5);
        }
        this.this$0.toast(new StringBuilder().append(this.this$0.getResString(2131493269)).append(p7).toString());
        return;
    }
}
