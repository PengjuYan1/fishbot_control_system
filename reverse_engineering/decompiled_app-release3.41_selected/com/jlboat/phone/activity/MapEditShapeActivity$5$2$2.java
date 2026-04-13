package com.jlboat.phone.activity;
 class MapEditShapeActivity$5$2$2 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.MapEditShapeActivity$5$2 this$2;
    final synthetic com.boat.support.slam.entity.floors.Maps val$maps;

    MapEditShapeActivity$5$2$2(com.jlboat.phone.activity.MapEditShapeActivity$5$2 p1, com.boat.support.slam.entity.floors.Maps p2)
    {
        this.this$2 = p1;
        this.val$maps = p2;
        return;
    }

    public void run()
    {
        this.this$2.this$1.this$0.shapeListAdapter.setListData(this.val$maps.getShapeAreas());
        return;
    }
}
