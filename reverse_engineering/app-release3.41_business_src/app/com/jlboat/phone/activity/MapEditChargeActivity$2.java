package com.jlboat.phone.activity;
 class MapEditChargeActivity$2 implements com.jlboat.phone.adapter.MapActDlFloorListAdapter$OnItemClickListener {
    final synthetic com.jlboat.phone.activity.MapEditChargeActivity this$0;

    MapEditChargeActivity$2(com.jlboat.phone.activity.MapEditChargeActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onClick(int p3)
    {
        com.boat.support.slam.entity.floors.Floors v0_3 = ((com.boat.support.slam.entity.floors.Floors) this.this$0.mapPointList.get(p3));
        if (!this.this$0.selectedPointList.contains(v0_3)) {
            this.this$0.selectedPointList.add(v0_3);
        } else {
            this.this$0.selectedPointList.remove(v0_3);
        }
        com.jlboat.phone.activity.MapEditChargeActivity.access$000(this.this$0);
        return;
    }
}
