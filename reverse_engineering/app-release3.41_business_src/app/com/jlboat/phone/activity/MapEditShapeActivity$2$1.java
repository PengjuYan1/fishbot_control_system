package com.jlboat.phone.activity;
 class MapEditShapeActivity$2$1 implements android.content.DialogInterface$OnClickListener {
    final synthetic com.jlboat.phone.activity.MapEditShapeActivity$2 this$1;
    final synthetic long val$shapeId;

    MapEditShapeActivity$2$1(com.jlboat.phone.activity.MapEditShapeActivity$2 p1, long p2)
    {
        this.this$1 = p1;
        this.val$shapeId = p2;
        return;
    }

    public void onClick(android.content.DialogInterface p4, int p5)
    {
        p4.dismiss();
        world_canvas_msgs18.SetShapeRequestEnty v0_1 = new world_canvas_msgs18.SetShapeRequestEnty();
        v0_1.setShapeId(this.val$shapeId);
        com.jlboat.phone.activity.MapEditShapeActivity.access$000(this.this$1.this$0, v0_1);
        return;
    }
}
