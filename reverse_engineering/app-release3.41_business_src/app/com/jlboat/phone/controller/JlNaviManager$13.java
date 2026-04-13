package com.jlboat.phone.controller;
 class JlNaviManager$13 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$13(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.ListNaviPointsResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.ListNaviPointsResponse p8)
    {
        com.jlboat.phone.controller.JlNaviManager.access$3200(this.this$0).clear();
        com.jlboat.phone.controller.JlNaviManager.access$3300(this.this$0).clear();
        java.util.List v0_4 = p8.getListNaviPoints();
        java.util.List v1 = p8.getListSystemPoints();
        if (v0_4 != null) {
            com.jlboat.phone.controller.JlNaviManager v2_0 = v0_4.iterator();
            while (v2_0.hasNext()) {
                com.jlboat.phone.message.map_msgs.PointListEntry v3_5 = ((com.jlboat.phone.message.map_msgs.PointListEntry) v2_0.next());
                com.boat.support.slam.entity.floors.Points v4_3 = new com.boat.support.slam.entity.floors.Points();
                v4_3.setPointId(Long.parseLong(v3_5.getPointId()));
                v4_3.setPointName(v3_5.getPointName());
                v4_3.setPositionX(((double) v3_5.getX()));
                v4_3.setPositionY(((double) v3_5.getY()));
                v4_3.setPositionYaw(((double) v3_5.getZ()));
                com.jlboat.phone.controller.JlNaviManager.access$3200(this.this$0).add(v4_3);
            }
        }
        if (v1 != null) {
            com.jlboat.phone.controller.JlNaviManager v2_1 = v1.iterator();
            while (v2_1.hasNext()) {
                com.jlboat.phone.message.map_msgs.PointListEntry v3_3 = ((com.jlboat.phone.message.map_msgs.PointListEntry) v2_1.next());
                com.boat.support.slam.entity.floors.Points v4_1 = new com.boat.support.slam.entity.floors.Points();
                v4_1.setPointId(Long.parseLong(v3_3.getPointId()));
                v4_1.setPointName(v3_3.getPointName());
                v4_1.setPositionX(((double) v3_3.getX()));
                v4_1.setPositionY(((double) v3_3.getY()));
                v4_1.setPositionYaw(((double) v3_3.getZ()));
                com.jlboat.phone.controller.JlNaviManager.access$3300(this.this$0).add(v4_1);
            }
        }
        if (!this.this$0.islocalPointUpdateEnd) {
            com.jlboat.phone.controller.JlNaviManager.access$2600(this.this$0);
        }
        return;
    }
}
