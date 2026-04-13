package com.jlboat.phone.activity;
 class MapEditMapActivity$1 implements com.jlboat.phone.view.MapView$MoveCallBackLines {
    final synthetic com.jlboat.phone.activity.MapEditMapActivity this$0;

    MapEditMapActivity$1(com.jlboat.phone.activity.MapEditMapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onMoveChange(com.boat.support.slam.entity.floors.Lines p4)
    {
        if ((p4 != null) && (com.jlboat.phone.activity.MapEditMapActivity.access$000(this.this$0) != null)) {
            com.jlboat.phone.message.map_msgs.ErasePose v0_3 = new com.jlboat.phone.message.map_msgs.ErasePose();
            v0_3.setX(p4.getX());
            v0_3.setY(p4.getY());
            com.jlboat.phone.activity.MapEditMapActivity.access$000(this.this$0).publish(v0_3);
        }
        return;
    }
}
