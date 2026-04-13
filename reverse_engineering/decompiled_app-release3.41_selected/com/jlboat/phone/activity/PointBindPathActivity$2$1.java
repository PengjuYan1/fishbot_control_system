package com.jlboat.phone.activity;
 class PointBindPathActivity$2$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.PointBindPathActivity$2 this$1;

    PointBindPathActivity$2$1(com.jlboat.phone.activity.PointBindPathActivity$2 p1)
    {
        this.this$1 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_srvs.TriggerResponse) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_srvs.TriggerResponse p13)
    {
        if (p13.getSuccess()) {
            if (!p13.getMessage().isEmpty()) {
                new com.boat.support.slam.entity.floors.MapList();
                try {
                    com.boat.support.slam.entity.floors.MapList v0_1 = ((com.boat.support.slam.entity.floors.MapList) new com.google.gson.Gson().fromJson(new org.json.JSONObject(p13.getMessage()).toString(), new com.jlboat.phone.activity.PointBindPathActivity$2$1$1(this).getType()));
                } catch (com.jlboat.phone.view.MapView v1_4) {
                    v1_4.printStackTrace();
                }
                com.jlboat.phone.view.MapView v1_6 = v0_1.getFloors().iterator();
                while (v1_6.hasNext()) {
                    com.boat.support.slam.entity.floors.Floors v2_7 = ((com.boat.support.slam.entity.floors.Floors) v1_6.next());
                    if (v2_7.getFloorId() == v0_1.getDefaultFloor()) {
                        java.util.List v3_16 = v2_7.getMaps().iterator();
                        while (v3_16.hasNext()) {
                            com.boat.support.slam.entity.floors.Maps v4_5 = ((com.boat.support.slam.entity.floors.Maps) v3_16.next());
                            if (v2_7.getDefaultmap() == v4_5.getMapId()) {
                                if ((v4_5.getShapeAreas() != null) && ((!v4_5.getShapeAreas().isEmpty()) && (this.this$1.this$0.mapView != null))) {
                                    this.this$1.this$0.mapView.setProhibition(v4_5.getShapeAreas());
                                }
                                if ((v4_5.getPoints() != null) && (!v4_5.getPoints().isEmpty())) {
                                    com.jlboat.phone.activity.PointBindPathActivity.access$400(this.this$1.this$0).clear();
                                    com.jlboat.phone.view.MapView v1_23 = v4_5.getPoints().iterator();
                                    while (v1_23.hasNext()) {
                                        java.util.List v3_12 = ((com.boat.support.slam.entity.floors.Points) v1_23.next());
                                        if (!v3_12.getPointName().equals(com.jlboat.phone.application.BoatSlamApplication.CANCLEPOINTNAME)) {
                                            com.jlboat.phone.activity.PointBindPathActivity.access$400(this.this$1.this$0).add(v3_12);
                                        }
                                    }
                                    this.this$1.this$0.mapView.setPoints(com.jlboat.phone.activity.PointBindPathActivity.access$400(this.this$1.this$0));
                                }
                                com.jlboat.phone.view.MapView v1_2 = v4_5.getGlobalPlans();
                                if ((v1_2 == null) || (v1_2.size() <= 0)) {
                                    com.jlboat.phone.activity.PointBindPathActivity.access$202(this.this$1.this$0, 0);
                                } else {
                                    java.util.List v3_7 = new java.util.ArrayList();
                                    java.util.List v5_1 = v1_2.iterator();
                                    while (v5_1.hasNext()) {
                                        com.boat.support.slam.entity.floors.GlobalPlans v6_2 = ((com.boat.support.slam.entity.floors.GlobalPlans) v5_1.next());
                                        if (com.jlboat.phone.activity.PointBindPathActivity.access$1300(this.this$1.this$0) == v6_2.getGlobalplanId()) {
                                            com.jlboat.phone.activity.PointBindPathActivity.access$202(this.this$1.this$0, v6_2);
                                            v3_7.add(com.jlboat.phone.activity.PointBindPathActivity.access$200(this.this$1.this$0));
                                            this.this$1.this$0.mapView.setGlobalPlans(v3_7);
                                            this.this$1.this$0.mapView.setSelectedGlobalPlans(com.jlboat.phone.activity.PointBindPathActivity.access$200(this.this$1.this$0).getGlobalplanId());
                                        }
                                    }
                                }
                                com.jlboat.phone.activity.PointBindPathActivity.access$1400(this.this$1.this$0).sendEmptyMessage(1003);
                            }
                        }
                    }
                }
            } else {
                return;
            }
        }
        return;
    }
}
