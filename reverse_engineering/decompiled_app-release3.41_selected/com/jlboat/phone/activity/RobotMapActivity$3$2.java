package com.jlboat.phone.activity;
 class RobotMapActivity$3$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.RobotMapActivity$3 this$1;

    RobotMapActivity$3$2(com.jlboat.phone.activity.RobotMapActivity$3 p1)
    {
        this.this$1 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.ListNaviPointsResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.ListNaviPointsResponse p8)
    {
        com.jlboat.phone.activity.RobotMapActivity.access$1500(this.this$1.this$0).clear();
        com.jlboat.phone.activity.RobotMapActivity.access$1600(this.this$1.this$0).clear();
        com.jlboat.phone.activity.RobotMapActivity.access$1700(this.this$1.this$0).clear();
        java.util.List v0_5 = p8.getListNaviPoints();
        java.util.List v1 = p8.getListSystemPoints();
        if (v0_5 != null) {
            com.jlboat.phone.view.MapView v2_0 = v0_5.iterator();
            while (v2_0.hasNext()) {
                com.jlboat.phone.message.map_msgs.PointListEntry v3_8 = ((com.jlboat.phone.message.map_msgs.PointListEntry) v2_0.next());
                if (!v3_8.getPointName().equals(com.jlboat.phone.application.BoatSlamApplication.CANCLEPOINTNAME)) {
                    com.boat.support.slam.entity.floors.Points v4_7 = new com.boat.support.slam.entity.floors.Points();
                    v4_7.setPointId(Long.parseLong(v3_8.getPointId()));
                    v4_7.setPointName(v3_8.getPointName());
                    v4_7.setPositionX(((double) v3_8.getX()));
                    v4_7.setPositionY(((double) v3_8.getY()));
                    v4_7.setPositionYaw(((double) v3_8.getZ()));
                    com.jlboat.phone.activity.RobotMapActivity.access$1500(this.this$1.this$0).add(v4_7);
                    com.jlboat.phone.activity.RobotMapActivity.access$1600(this.this$1.this$0).add(v4_7);
                }
            }
        }
        if (v1 != null) {
            com.jlboat.phone.view.MapView v2_1 = v1.iterator();
            while (v2_1.hasNext()) {
                com.jlboat.phone.message.map_msgs.PointListEntry v3_6 = ((com.jlboat.phone.message.map_msgs.PointListEntry) v2_1.next());
                if (!v3_6.getPointName().equals(com.jlboat.phone.application.BoatSlamApplication.CANCLEPOINTNAME)) {
                    com.boat.support.slam.entity.floors.Points v4_3 = new com.boat.support.slam.entity.floors.Points();
                    v4_3.setPointId(Long.parseLong(v3_6.getPointId()));
                    v4_3.setPointName(v3_6.getPointName());
                    v4_3.setPositionX(((double) v3_6.getX()));
                    v4_3.setPositionY(((double) v3_6.getY()));
                    v4_3.setPositionYaw(((double) v3_6.getZ()));
                    com.jlboat.phone.activity.RobotMapActivity.access$1500(this.this$1.this$0).add(v4_3);
                    com.jlboat.phone.activity.RobotMapActivity.access$1700(this.this$1.this$0).add(v4_3);
                }
            }
        }
        if (com.jlboat.phone.activity.RobotMapActivity.access$500(this.this$1.this$0) != null) {
            com.jlboat.phone.activity.RobotMapActivity.access$500(this.this$1.this$0).setPoints(com.jlboat.phone.activity.RobotMapActivity.access$1500(this.this$1.this$0));
        }
        return;
    }
}
