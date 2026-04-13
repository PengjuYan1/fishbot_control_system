package com.jlboat.phone.activity;
 class MapEditRegionActivity$4$1 implements android.content.DialogInterface$OnClickListener {
    final synthetic com.jlboat.phone.activity.MapEditRegionActivity$4 this$1;
    final synthetic com.boat.support.slam.entity.floors.Region val$region;

    MapEditRegionActivity$4$1(com.jlboat.phone.activity.MapEditRegionActivity$4 p1, com.boat.support.slam.entity.floors.Region p2)
    {
        this.this$1 = p1;
        this.val$region = p2;
        return;
    }

    public void onClick(android.content.DialogInterface p4, int p5)
    {
        p4.dismiss();
        world_canvas_msgs18.SetRegionRequestEnty v0_1 = new world_canvas_msgs18.SetRegionRequestEnty();
        v0_1.setRegionId(this.val$region.getRegionId());
        com.jlboat.phone.activity.MapEditRegionActivity.access$600(this.this$1.this$0, v0_1);
        return;
    }
}
