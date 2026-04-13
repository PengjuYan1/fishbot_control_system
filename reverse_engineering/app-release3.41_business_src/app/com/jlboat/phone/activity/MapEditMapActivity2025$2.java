package com.jlboat.phone.activity;
 class MapEditMapActivity2025$2 implements android.widget.CompoundButton$OnCheckedChangeListener {
    final synthetic com.jlboat.phone.activity.MapEditMapActivity2025 this$0;

    MapEditMapActivity2025$2(com.jlboat.phone.activity.MapEditMapActivity2025 p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onCheckedChanged(android.widget.CompoundButton p2, boolean p3)
    {
        this.this$0.mapView.isClear(p3);
        return;
    }
}
