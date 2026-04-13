package com.jlboat.phone.activity;
 class MapEditShapeActivity$5$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapEditShapeActivity$5 this$1;

    MapEditShapeActivity$5$2(com.jlboat.phone.activity.MapEditShapeActivity$5 p1)
    {
        this.this$1 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_srvs.TriggerResponse) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_srvs.TriggerResponse p10)
    {
        if (p10.getSuccess()) {
            if (!p10.getMessage().isEmpty()) {
                new com.boat.support.slam.entity.floors.MapList();
                try {
                    com.boat.support.slam.entity.floors.MapList v0_1 = ((com.boat.support.slam.entity.floors.MapList) new com.google.gson.Gson().fromJson(new org.json.JSONObject(p10.getMessage()).toString(), new com.jlboat.phone.activity.MapEditShapeActivity$5$2$1(this).getType()));
                } catch (com.jlboat.phone.activity.MapEditShapeActivity v1_2) {
                    v1_2.printStackTrace();
                }
                com.jlboat.phone.activity.MapEditShapeActivity v1_4 = v0_1.getFloors().iterator();
                while (v1_4.hasNext()) {
                    com.boat.support.slam.entity.floors.Floors v2_7 = ((com.boat.support.slam.entity.floors.Floors) v1_4.next());
                    if (v2_7.getFloorId() == v0_1.getDefaultFloor()) {
                        com.jlboat.phone.activity.MapEditShapeActivity v1_6 = v2_7.getMaps().iterator();
                        while (v1_6.hasNext()) {
                            com.boat.support.slam.entity.floors.Maps v3_4 = ((com.boat.support.slam.entity.floors.Maps) v1_6.next());
                            if (v2_7.getDefaultmap() == v3_4.getMapId()) {
                                if ((v3_4.getShapeAreas() != null) && (!v3_4.getShapeAreas().isEmpty())) {
                                    if (this.this$1.this$0.mapView != null) {
                                        this.this$1.this$0.mapView.setProhibition(v3_4.getShapeAreas());
                                    }
                                    if (this.this$1.this$0.shapeListAdapter != null) {
                                        this.this$1.this$0.runOnUiThread(new com.jlboat.phone.activity.MapEditShapeActivity$5$2$2(this, v3_4));
                                    }
                                }
                                if ((v3_4.getPoints() == null) || (v3_4.getPoints().isEmpty())) {
                                    break;
                                }
                                com.jlboat.phone.activity.MapEditShapeActivity v1_25 = new java.util.LinkedList();
                                com.jlboat.phone.view.MapView v4_0 = v3_4.getPoints().iterator();
                                while (v4_0.hasNext()) {
                                    com.boat.support.slam.entity.floors.Points v5_2 = ((com.boat.support.slam.entity.floors.Points) v4_0.next());
                                    if (!v5_2.getPointName().equals(com.jlboat.phone.application.BoatSlamApplication.CANCLEPOINTNAME)) {
                                        v1_25.add(v5_2);
                                    }
                                }
                                this.this$1.this$0.mapView.setPoints(v1_25);
                                break;
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
