package com.jlboat.phone.activity;
 class MapActivity$35 implements com.jlboat.phone.adapter.MapActDlFloorListAdapter$OnItemClickListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;
    final synthetic java.util.List val$mapPointList;
    final synthetic android.widget.LinearLayout val$navNopointTipLl;
    final synthetic android.support.v7.widget.RecyclerView val$navSelectedPointRv;
    final synthetic java.util.List val$selectedPointList;
    final synthetic com.jlboat.phone.adapter.MapActDlFloorListAdapter val$testPointListAdapter;
    final synthetic com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter val$testPointSelectedListAdapter;

    MapActivity$35(com.jlboat.phone.activity.MapActivity p1, java.util.List p2, java.util.List p3, com.jlboat.phone.adapter.MapActDlFloorListAdapter p4, com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter p5, android.support.v7.widget.RecyclerView p6, android.widget.LinearLayout p7)
    {
        this.this$0 = p1;
        this.val$mapPointList = p2;
        this.val$selectedPointList = p3;
        this.val$testPointListAdapter = p4;
        this.val$testPointSelectedListAdapter = p5;
        this.val$navSelectedPointRv = p6;
        this.val$navNopointTipLl = p7;
        return;
    }

    public void onClick(int p4)
    {
        com.boat.support.slam.entity.floors.Floors v0_2 = ((com.boat.support.slam.entity.floors.Floors) this.val$mapPointList.get(p4));
        if (!this.val$selectedPointList.contains(v0_2)) {
            this.val$selectedPointList.add(v0_2);
        } else {
            this.val$selectedPointList.remove(v0_2);
        }
        this.this$0.runOnUiThread(new com.jlboat.phone.activity.MapActivity$35$1(this));
        return;
    }
}
