package com.jlboat.phone.activity;
 class MapActivity$6$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapActivity$6 this$1;

    MapActivity$6$2(com.jlboat.phone.activity.MapActivity$6 p1)
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
        com.jlboat.phone.activity.MapActivity.access$2200(this.this$1.this$0).clear();
        com.jlboat.phone.activity.MapActivity.access$2300(this.this$1.this$0).clear();
        com.jlboat.phone.activity.MapActivity.access$2400(this.this$1.this$0).clear();
        java.util.List v0_5 = p8.getListNaviPoints();
        java.util.List v1 = p8.getListSystemPoints();
        if (v0_5 != null) {
            com.jlboat.phone.view.MapView v2_0 = v0_5.iterator();
            while (v2_0.hasNext()) {
                java.util.List v3_8 = ((com.jlboat.phone.message.map_msgs.PointListEntry) v2_0.next());
                if (!v3_8.getPointName().equals(com.jlboat.phone.application.BoatSlamApplication.CANCLEPOINTNAME)) {
                    com.boat.support.slam.entity.floors.Points v4_2 = new com.boat.support.slam.entity.floors.Points();
                    v4_2.setPointId(Long.parseLong(v3_8.getPointId()));
                    v4_2.setPointName(v3_8.getPointName());
                    v4_2.setPositionX(((double) v3_8.getX()));
                    v4_2.setPositionY(((double) v3_8.getY()));
                    v4_2.setPositionYaw(((double) v3_8.getZ()));
                    com.jlboat.phone.activity.MapActivity.access$2200(this.this$1.this$0).add(v4_2);
                    com.jlboat.phone.activity.MapActivity.access$2300(this.this$1.this$0).add(v4_2);
                }
            }
        }
        if (v1 != null) {
            com.jlboat.phone.view.MapView v2_1 = v1.iterator();
            while (v2_1.hasNext()) {
                java.util.List v3_6 = ((com.jlboat.phone.message.map_msgs.PointListEntry) v2_1.next());
                if (!v3_6.getPointName().equals(com.jlboat.phone.application.BoatSlamApplication.CANCLEPOINTNAME)) {
                    com.boat.support.slam.entity.floors.Points v4_6 = new com.boat.support.slam.entity.floors.Points();
                    v4_6.setPointId(Long.parseLong(v3_6.getPointId()));
                    v4_6.setPointName(v3_6.getPointName());
                    v4_6.setPositionX(((double) v3_6.getX()));
                    v4_6.setPositionY(((double) v3_6.getY()));
                    v4_6.setPositionYaw(((double) v3_6.getZ()));
                    com.jlboat.phone.activity.MapActivity.access$2200(this.this$1.this$0).add(v4_6);
                    com.jlboat.phone.activity.MapActivity.access$2400(this.this$1.this$0).add(v4_6);
                }
            }
        }
        if (com.jlboat.phone.activity.MapActivity.access$900(this.this$1.this$0) != null) {
            if (com.jlboat.phone.activity.MapActivity.access$800(this.this$1.this$0) != 0) {
                com.jlboat.phone.activity.MapActivity.access$900(this.this$1.this$0).setPoints(com.jlboat.phone.activity.MapActivity.access$2200(this.this$1.this$0));
            } else {
                return;
            }
        }
        return;
    }
}
