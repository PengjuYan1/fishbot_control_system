package com.jlboat.phone.activity;
 class MapCleanAreaActivity$3$1 implements android.content.DialogInterface$OnClickListener {
    final synthetic com.jlboat.phone.activity.MapCleanAreaActivity$3 this$1;
    final synthetic long val$id;

    MapCleanAreaActivity$3$1(com.jlboat.phone.activity.MapCleanAreaActivity$3 p1, long p2)
    {
        this.this$1 = p1;
        this.val$id = p2;
        return;
    }

    public void onClick(android.content.DialogInterface p4, int p5)
    {
        p4.dismiss();
        world_canvas_msgs18.SetCleanAreaEnty v0_1 = new world_canvas_msgs18.SetCleanAreaEnty();
        v0_1.setCleanAreaId(this.val$id);
        com.jlboat.phone.activity.MapCleanAreaActivity.access$200(this.this$1.this$0, 0, v0_1);
        return;
    }
}
