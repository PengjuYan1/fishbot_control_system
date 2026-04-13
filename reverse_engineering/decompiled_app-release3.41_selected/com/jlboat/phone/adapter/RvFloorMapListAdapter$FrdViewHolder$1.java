package com.jlboat.phone.adapter;
 class RvFloorMapListAdapter$FrdViewHolder$1 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.adapter.RvFloorMapListAdapter$FrdViewHolder this$1;
    final synthetic com.boat.support.slam.entity.floors.Maps val$currentMap;
    final synthetic com.boat.support.slam.entity.floors.Floors val$mapBelongFloor;

    RvFloorMapListAdapter$FrdViewHolder$1(com.jlboat.phone.adapter.RvFloorMapListAdapter$FrdViewHolder p1, com.boat.support.slam.entity.floors.Floors p2, com.boat.support.slam.entity.floors.Maps p3)
    {
        this.this$1 = p1;
        this.val$mapBelongFloor = p2;
        this.val$currentMap = p3;
        return;
    }

    public void onClick(android.view.View p4)
    {
        android.util.Log.d("catalpa ", new StringBuilder().append("onClick: ").append(this.val$mapBelongFloor.getFloorName()).append("  ").append(this.val$currentMap.getMapName()).toString());
        if (com.jlboat.phone.adapter.RvFloorMapListAdapter.access$300(this.this$1.this$0) != null) {
            com.jlboat.phone.adapter.RvFloorMapListAdapter.access$300(this.this$1.this$0).click(p4, this.val$mapBelongFloor, this.val$currentMap);
        }
        return;
    }
}
