package com.jlboat.phone.activity;
 class MapExpansionActivity$12 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.MapExpansionActivity this$0;
    final synthetic android.app.AlertDialog val$alertDialog;
    final synthetic com.boat.support.slam.entity.floors.Points val$frd;
    final synthetic com.boat.support.slam.entity.floors.Floors val$localDataFloor;
    final synthetic com.boat.support.slam.entity.floors.Maps val$localMap;

    MapExpansionActivity$12(com.jlboat.phone.activity.MapExpansionActivity p1, com.boat.support.slam.entity.floors.Floors p2, com.boat.support.slam.entity.floors.Maps p3, com.boat.support.slam.entity.floors.Points p4, android.app.AlertDialog p5)
    {
        this.this$0 = p1;
        this.val$localDataFloor = p2;
        this.val$localMap = p3;
        this.val$frd = p4;
        this.val$alertDialog = p5;
        return;
    }

    public void onClick(android.view.View p8)
    {
        com.jlboat.phone.activity.MapExpansionActivity.access$2500(this.this$0, this.val$localDataFloor.getFloorId(), this.val$localMap.getMapId(), this.val$frd.getPointId());
        this.val$alertDialog.cancel();
        return;
    }
}
