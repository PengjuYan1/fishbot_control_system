package com.jlboat.phone.activity;
 class MapActivity$8$1 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.MapActivity$8 this$1;
    final synthetic com.boat.support.slam.entity.floors.Floors val$floors;

    MapActivity$8$1(com.jlboat.phone.activity.MapActivity$8 p1, com.boat.support.slam.entity.floors.Floors p2)
    {
        this.this$1 = p1;
        this.val$floors = p2;
        return;
    }

    public void run()
    {
        if (8 == com.jlboat.phone.activity.MapActivity.access$2900(this.this$1.this$0).getVisibility()) {
            com.jlboat.phone.activity.MapActivity.access$3000(this.this$1.this$0).setVisibility(0);
        }
        com.jlboat.phone.activity.MapActivity.access$3300(this.this$1.this$0).setVisibility(0);
        com.jlboat.phone.activity.MapActivity.access$3300(this.this$1.this$0).setText(new StringBuilder().append(this.this$1.this$0.getString(2131493096)).append(" ").append(this.val$floors.getFloorName()).append(" ").append(this.this$1.this$0.getResources().getString(2131493070)).append(", ").toString());
        return;
    }
}
