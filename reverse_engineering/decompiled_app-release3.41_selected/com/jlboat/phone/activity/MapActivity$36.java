package com.jlboat.phone.activity;
 class MapActivity$36 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;
    final synthetic android.app.AlertDialog val$alertDialog;
    final synthetic java.util.List val$selectedPointList;

    MapActivity$36(com.jlboat.phone.activity.MapActivity p1, java.util.List p2, android.app.AlertDialog p3)
    {
        this.this$0 = p1;
        this.val$selectedPointList = p2;
        this.val$alertDialog = p3;
        return;
    }

    public void onClick(android.view.View p6)
    {
        java.util.LinkedList v0_1 = new java.util.LinkedList();
        android.app.AlertDialog v1_3 = this.val$selectedPointList.iterator();
        while (v1_3.hasNext()) {
            v0_1.add(Long.valueOf(((com.boat.support.slam.entity.floors.Floors) v1_3.next()).getFloorId()));
        }
        com.jlboat.phone.activity.MapActivity.access$2100(this.this$0).setChargingPriority(v0_1, new com.jlboat.phone.activity.MapActivity$36$1(this));
        this.val$alertDialog.dismiss();
        return;
    }
}
