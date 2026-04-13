package com.jlboat.phone.activity;
 class MapActivity$13 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;
    final synthetic android.app.AlertDialog val$alertDialog;
    final synthetic com.boat.support.slam.entity.floors.Floors val$floors;

    MapActivity$13(com.jlboat.phone.activity.MapActivity p1, com.boat.support.slam.entity.floors.Floors p2, android.app.AlertDialog p3)
    {
        this.this$0 = p1;
        this.val$floors = p2;
        this.val$alertDialog = p3;
        return;
    }

    public void onClick(android.view.View p6)
    {
        if (this.val$floors.getFloorId() != com.jlboat.phone.activity.MapActivity.access$000(this.this$0)) {
            android.util.Log.d("MapActivity", new StringBuilder().append("onClick: floor: ").append(this.val$floors.getFloorName()).toString());
            com.jlboat.phone.activity.MapActivity.access$3800(this.this$0, this.val$floors.getFloorId());
            this.val$alertDialog.cancel();
            return;
        } else {
            this.this$0.toast(2131493278);
            return;
        }
    }
}
