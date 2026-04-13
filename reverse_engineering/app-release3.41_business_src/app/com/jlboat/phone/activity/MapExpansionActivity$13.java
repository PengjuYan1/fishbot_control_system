package com.jlboat.phone.activity;
 class MapExpansionActivity$13 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.MapExpansionActivity this$0;
    final synthetic android.app.AlertDialog val$alertDialog;
    final synthetic android.widget.EditText val$editTextcler;
    final synthetic com.boat.support.slam.entity.floors.Points val$frd;
    final synthetic com.boat.support.slam.entity.floors.Floors val$localDataFloor;
    final synthetic com.boat.support.slam.entity.floors.Maps val$localMap;

    MapExpansionActivity$13(com.jlboat.phone.activity.MapExpansionActivity p1, android.widget.EditText p2, com.boat.support.slam.entity.floors.Maps p3, com.boat.support.slam.entity.floors.Floors p4, com.boat.support.slam.entity.floors.Points p5, android.app.AlertDialog p6)
    {
        this.this$0 = p1;
        this.val$editTextcler = p2;
        this.val$localMap = p3;
        this.val$localDataFloor = p4;
        this.val$frd = p5;
        this.val$alertDialog = p6;
        return;
    }

    public void onClick(android.view.View p11)
    {
        String v0_2 = this.val$editTextcler.getText().toString();
        android.util.Log.d("MapExpansionActivity", new StringBuilder().append("onClick: \u8f93\u5165\u7684\u540d\u5b57 ").append(v0_2).toString());
        if (!v0_2.replace(" ", "").equals("")) {
            com.jlboat.phone.activity.MapExpansionActivity v1_7 = this.val$localMap.getPoints().iterator();
            while (v1_7.hasNext()) {
                if (v0_2.equals(((com.boat.support.slam.entity.floors.Points) v1_7.next()).getPointName())) {
                    this.this$0.toast(2131493287);
                    return;
                }
            }
            com.jlboat.phone.activity.MapExpansionActivity.access$2600(this.this$0, 0, this.val$localDataFloor.getFloorId(), this.val$localMap.getMapId(), this.val$frd.getPointId(), v0_2);
            this.val$alertDialog.cancel();
            return;
        } else {
            this.this$0.toast(this.this$0.getResString(2131493286));
            return;
        }
    }
}
