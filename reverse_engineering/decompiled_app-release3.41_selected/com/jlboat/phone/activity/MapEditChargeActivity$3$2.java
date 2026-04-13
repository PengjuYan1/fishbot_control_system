package com.jlboat.phone.activity;
 class MapEditChargeActivity$3$2 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.MapEditChargeActivity$3 this$1;

    MapEditChargeActivity$3$2(com.jlboat.phone.activity.MapEditChargeActivity$3 p1)
    {
        this.this$1 = p1;
        return;
    }

    public void run()
    {
        this.this$1.this$0.mapPointList.clear();
        if (com.jlboat.phone.activity.MapEditChargeActivity.access$200(this.this$1.this$0) != null) {
            this.this$1.this$0.mapPointList.addAll(com.jlboat.phone.activity.MapEditChargeActivity.access$200(this.this$1.this$0));
        }
        this.this$1.this$0.selectedPointList.clear();
        if ((com.jlboat.phone.activity.MapEditChargeActivity.access$100(this.this$1.this$0) != null) && (com.jlboat.phone.activity.MapEditChargeActivity.access$200(this.this$1.this$0) != null)) {
            java.util.Iterator v0_17 = com.jlboat.phone.activity.MapEditChargeActivity.access$100(this.this$1.this$0).iterator();
            while (v0_17.hasNext()) {
                long v1_6 = ((Long) v0_17.next()).longValue();
                java.util.List v3_3 = com.jlboat.phone.activity.MapEditChargeActivity.access$200(this.this$1.this$0).iterator();
                while (v3_3.hasNext()) {
                    com.boat.support.slam.entity.floors.Floors v4_2 = ((com.boat.support.slam.entity.floors.Floors) v3_3.next());
                    if (v4_2.getFloorId() == v1_6) {
                        this.this$1.this$0.selectedPointList.add(v4_2);
                        break;
                    }
                }
            }
        }
        com.jlboat.phone.activity.MapEditChargeActivity.access$000(this.this$1.this$0);
        return;
    }
}
