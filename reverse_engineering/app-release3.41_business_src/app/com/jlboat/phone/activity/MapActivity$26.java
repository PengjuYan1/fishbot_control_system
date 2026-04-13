package com.jlboat.phone.activity;
 class MapActivity$26 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;
    final synthetic com.boat.support.slam.entity.floors.Points val$frd;
    final synthetic android.widget.TextView val$point_wait_et;

    MapActivity$26(com.jlboat.phone.activity.MapActivity p1, com.boat.support.slam.entity.floors.Points p2, android.widget.TextView p3)
    {
        this.this$0 = p1;
        this.val$frd = p2;
        this.val$point_wait_et = p3;
        return;
    }

    public void onClick(android.view.View p4)
    {
        if ((this.val$frd.getWaitPoints() != null) && (this.val$frd.getWaitPoints().size() >= 1)) {
            this.val$frd.getWaitPoints().remove((this.val$frd.getWaitPoints().size() - 1));
            this.val$point_wait_et.setText(com.jlboat.phone.activity.MapActivity.access$4100(this.this$0, this.val$frd));
        }
        return;
    }
}
