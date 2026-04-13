package com.jlboat.phone.activity;
 class PointBindPathActivity$3 extends java.lang.Thread {
    final synthetic com.jlboat.phone.activity.PointBindPathActivity this$0;

    PointBindPathActivity$3(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void run()
    {
        super.run();
        int v0_0 = 0;
        while (v0_0 < this.this$0.newAddPos.size()) {
            int v1_4 = new world_canvas_msgs18.DiyPathEnty();
            com.jlboat.phone.message.map_msgs.GlobalPlanPoints v3_1 = new com.jlboat.phone.message.map_msgs.GlobalPlanPoints();
            com.boat.support.slam.entity.floors.Points v5_6 = ((com.boat.support.slam.entity.floors.Points) ((java.util.Map) this.this$0.newAddPos.get(v0_0)).get("end"));
            v3_1.setPointIdA(((com.boat.support.slam.entity.floors.Points) ((java.util.Map) this.this$0.newAddPos.get(v0_0)).get("start")).getPointId());
            v3_1.setPointIdB(v5_6.getPointId());
            v1_4.setAddPoint(v3_1);
            v1_4.setGlobalplanId(com.jlboat.phone.activity.PointBindPathActivity.access$200(this.this$0).getGlobalplanId());
            com.jlboat.phone.activity.PointBindPathActivity.access$1600(this.this$0, v1_4, 0);
            try {
                com.jlboat.phone.activity.PointBindPathActivity$3.sleep(500);
            } catch (InterruptedException v2_1) {
                v2_1.printStackTrace();
            }
            v0_0++;
        }
        this.this$0.newAddPos.clear();
        com.jlboat.phone.activity.PointBindPathActivity.access$1702(this.this$0, 0);
        com.jlboat.phone.activity.PointBindPathActivity.access$1400(this.this$0).sendEmptyMessage(1003);
        com.jlboat.phone.activity.PointBindPathActivity.access$1400(this.this$0).sendEmptyMessage(1002);
        return;
    }
}
