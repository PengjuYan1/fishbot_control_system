package com.jlboat.phone.activity;
 class MapActivity$2 implements com.jlboat.phone.adapter.RvFloorPointListAdapter$OnClick {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;

    MapActivity$2(com.jlboat.phone.activity.MapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void click(android.view.View p2, com.boat.support.slam.entity.floors.Floors p3, com.boat.support.slam.entity.floors.Maps p4, com.boat.support.slam.entity.floors.Points p5)
    {
        com.jlboat.phone.activity.MapActivity.access$300(this.this$0, p3, p4, p5);
        return;
    }

    public void longlick(android.view.View p2, com.boat.support.slam.entity.floors.Floors p3, com.boat.support.slam.entity.floors.Maps p4, com.boat.support.slam.entity.floors.Points p5)
    {
        this.this$0.PointAndDeleteorRename(p3, p4, p5);
        return;
    }
}
