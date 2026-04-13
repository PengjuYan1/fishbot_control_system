package com.jlboat.phone.activity;
 class RobotMapActivity$1$1 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.RobotMapActivity$1 this$1;
    final synthetic android.app.AlertDialog val$alertDialog;
    final synthetic com.boat.support.slam.entity.floors.Maps val$frd;
    final synthetic com.boat.support.slam.entity.floors.Floors val$localDataFloor;
    final synthetic android.widget.RadioGroup val$radioGroup;

    RobotMapActivity$1$1(com.jlboat.phone.activity.RobotMapActivity$1 p1, android.widget.RadioGroup p2, com.boat.support.slam.entity.floors.Floors p3, com.boat.support.slam.entity.floors.Maps p4, android.app.AlertDialog p5)
    {
        this.this$1 = p1;
        this.val$radioGroup = p2;
        this.val$localDataFloor = p3;
        this.val$frd = p4;
        this.val$alertDialog = p5;
        return;
    }

    public void onClick(android.view.View p8)
    {
        int v0 = 0;
        if (this.val$radioGroup.getCheckedRadioButtonId() == 2131231120) {
            v0 = 1;
        }
        com.jlboat.phone.activity.RobotMapActivity.access$200(this.this$1.this$0, v0, this.val$localDataFloor.getFloorId(), this.val$frd.getMapId());
        this.val$alertDialog.dismiss();
        return;
    }
}
