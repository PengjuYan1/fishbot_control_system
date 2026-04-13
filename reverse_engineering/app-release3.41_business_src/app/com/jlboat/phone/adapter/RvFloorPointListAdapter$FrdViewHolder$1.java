package com.jlboat.phone.adapter;
 class RvFloorPointListAdapter$FrdViewHolder$1 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.adapter.RvFloorPointListAdapter$FrdViewHolder this$1;
    final synthetic com.boat.support.slam.entity.floors.Points val$frd;
    final synthetic com.boat.support.slam.entity.floors.Floors val$localDataFloor;

    RvFloorPointListAdapter$FrdViewHolder$1(com.jlboat.phone.adapter.RvFloorPointListAdapter$FrdViewHolder p1, com.boat.support.slam.entity.floors.Floors p2, com.boat.support.slam.entity.floors.Points p3)
    {
        this.this$1 = p1;
        this.val$localDataFloor = p2;
        this.val$frd = p3;
        return;
    }

    public void onClick(android.view.View p8)
    {
        android.util.Log.d("catalpa ", new StringBuilder().append("RvFloorPointListAdapter onClick: floorname ").append(this.val$localDataFloor.getFloorName()).append(" , dfmapid: ").append(this.val$localDataFloor.getDefaultmap()).append(" , point_name: ").append(this.val$frd.getPointName()).toString());
        if (com.jlboat.phone.adapter.RvFloorPointListAdapter.access$700(this.this$1.this$0) != null) {
            com.jlboat.phone.adapter.RvFloorPointListAdapter$OnClick v0_12 = this.val$localDataFloor.getMaps().iterator();
            while (v0_12.hasNext()) {
                com.boat.support.slam.entity.floors.Maps v1_10 = ((com.boat.support.slam.entity.floors.Maps) v0_12.next());
                if (this.val$localDataFloor.getDefaultmap() == v1_10.getMapId()) {
                    com.jlboat.phone.adapter.RvFloorPointListAdapter.access$700(this.this$1.this$0).click(p8, this.val$localDataFloor, v1_10, this.val$frd);
                    break;
                }
            }
        }
        return;
    }
}
