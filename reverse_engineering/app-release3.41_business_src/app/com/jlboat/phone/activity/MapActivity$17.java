package com.jlboat.phone.activity;
 class MapActivity$17 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;
    final synthetic android.app.AlertDialog val$alertDialog;
    final synthetic android.widget.EditText val$editTextcler;
    final synthetic com.boat.support.slam.entity.floors.Floors val$floors;
    final synthetic com.boat.support.slam.entity.floors.Maps val$maps;

    MapActivity$17(com.jlboat.phone.activity.MapActivity p1, android.widget.EditText p2, com.boat.support.slam.entity.floors.Floors p3, com.boat.support.slam.entity.floors.Maps p4, android.app.AlertDialog p5)
    {
        this.this$0 = p1;
        this.val$editTextcler = p2;
        this.val$floors = p3;
        this.val$maps = p4;
        this.val$alertDialog = p5;
        return;
    }

    public void onClick(android.view.View p8)
    {
        String v0_2 = this.val$editTextcler.getText().toString();
        android.util.Log.d("MapActivity", new StringBuilder().append("onClick: \u8f93\u5165\u7684\u540d\u5b57 ").append(v0_2).toString());
        if (!v0_2.replace(" ", "").equals("")) {
            com.jlboat.phone.activity.MapActivity v1_7 = this.val$floors.getMaps().iterator();
            while (v1_7.hasNext()) {
                if (v0_2.equals(((com.boat.support.slam.entity.floors.Maps) v1_7.next()).getMapName())) {
                    this.this$0.toast(2131493284);
                    return;
                }
            }
            this.this$0.renameMapName(this.val$floors.getFloorId(), this.val$maps.getMapId(), v0_2);
            this.val$alertDialog.cancel();
            return;
        } else {
            this.this$0.toast(this.this$0.getResString(2131493283));
            return;
        }
    }
}
