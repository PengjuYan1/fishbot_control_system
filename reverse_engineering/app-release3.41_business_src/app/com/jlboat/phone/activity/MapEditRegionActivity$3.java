package com.jlboat.phone.activity;
 class MapEditRegionActivity$3 implements com.jlboat.phone.adapter.RegionListAdapter$OnClick {
    final synthetic com.jlboat.phone.activity.MapEditRegionActivity this$0;

    MapEditRegionActivity$3(com.jlboat.phone.activity.MapEditRegionActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void click(com.boat.support.slam.entity.floors.Region p5, int p6)
    {
        android.util.Log.e("MapEditShapeActivity", new StringBuilder().append("isOK0:").append(com.jlboat.phone.activity.MapEditRegionActivity.access$300(this.this$0)).toString());
        if (this.this$0.mapView != null) {
            this.this$0.mapView.setTagRegionId(p5.getRegionId());
            com.jlboat.phone.activity.MapEditRegionActivity.access$100(this.this$0);
            com.jlboat.phone.activity.MapEditRegionActivity.access$400(this.this$0, p5);
        }
        this.this$0.toast(new StringBuilder().append(this.this$0.getResString(2131493140)).append(p6).toString());
        return;
    }
}
