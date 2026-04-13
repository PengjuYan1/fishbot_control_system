package com.jlboat.phone.activity;
 class MapEditRegionActivity$9 implements com.jlboat.phone.adapter.NaviListAdapter$OnClick {
    final synthetic com.jlboat.phone.activity.MapEditRegionActivity this$0;
    final synthetic android.app.AlertDialog val$alertDialog;
    final synthetic int val$type;

    MapEditRegionActivity$9(com.jlboat.phone.activity.MapEditRegionActivity p1, int p2, android.app.AlertDialog p3)
    {
        this.this$0 = p1;
        this.val$type = p2;
        this.val$alertDialog = p3;
        return;
    }

    public void longclick(android.view.View p1)
    {
        return;
    }

    public void onClick(android.view.View p5)
    {
        int v0_2 = ((Integer) p5.getTag()).intValue();
        if (this.val$type != 0) {
            if (this.val$type != 1) {
                if (this.val$type == 2) {
                    com.jlboat.phone.activity.MapEditRegionActivity.access$1002(this.this$0, ((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.activity.MapEditRegionActivity.access$500(this.this$0).get(v0_2)).getPointId());
                    this.this$0.wait_rid_tv.setText(((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.activity.MapEditRegionActivity.access$500(this.this$0).get(v0_2)).getPointName());
                }
            } else {
                com.jlboat.phone.activity.MapEditRegionActivity.access$902(this.this$0, ((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.activity.MapEditRegionActivity.access$500(this.this$0).get(v0_2)).getPointId());
                this.this$0.end_rid_tv.setText(((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.activity.MapEditRegionActivity.access$500(this.this$0).get(v0_2)).getPointName());
            }
        } else {
            com.jlboat.phone.activity.MapEditRegionActivity.access$802(this.this$0, ((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.activity.MapEditRegionActivity.access$500(this.this$0).get(v0_2)).getPointId());
            this.this$0.start_rid_tv.setText(((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.activity.MapEditRegionActivity.access$500(this.this$0).get(v0_2)).getPointName());
        }
        com.jlboat.phone.activity.MapEditRegionActivity.access$100(this.this$0);
        this.val$alertDialog.dismiss();
        return;
    }
}
