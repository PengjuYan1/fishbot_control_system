package com.jlboat.phone.activity;
 class MapActivity$25 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;
    final synthetic com.boat.support.slam.entity.floors.Points val$frd;
    final synthetic android.widget.TextView val$point_wait_et;

    MapActivity$25(com.jlboat.phone.activity.MapActivity p1, com.boat.support.slam.entity.floors.Points p2, android.widget.TextView p3)
    {
        this.this$0 = p1;
        this.val$frd = p2;
        this.val$point_wait_et = p3;
        return;
    }

    public void onClick(android.view.View p6)
    {
        com.boat.support.slam.entity.floors.Position v0_1 = new com.boat.support.slam.entity.floors.Position();
        com.boat.support.slam.entity.floors.Lines v1_2 = com.jlboat.phone.activity.MapActivity.access$900(this.this$0).getRosRobotPoint();
        v0_1.setX(v1_2.getX());
        v0_1.setY(Double.valueOf(v1_2.getY()));
        if (this.val$frd.getWaitPoints() == null) {
            this.val$frd.setWaitPoints(new java.util.LinkedList());
            this.val$frd.getWaitPoints().add(v0_1);
        } else {
            this.val$frd.getWaitPoints().add(v0_1);
        }
        this.val$point_wait_et.setText(com.jlboat.phone.activity.MapActivity.access$4100(this.this$0, this.val$frd));
        return;
    }
}
