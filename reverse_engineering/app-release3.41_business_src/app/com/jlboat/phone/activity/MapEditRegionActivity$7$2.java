package com.jlboat.phone.activity;
 class MapEditRegionActivity$7$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapEditRegionActivity$7 this$1;

    MapEditRegionActivity$7$2(com.jlboat.phone.activity.MapEditRegionActivity$7 p1)
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
                    com.boat.support.slam.entity.floors.MapList v0_1 = ((com.boat.support.slam.entity.floors.MapList) new com.google.gson.Gson().fromJson(new org.json.JSONObject(p10.getMessage()).toString(), new com.jlboat.phone.activity.MapEditRegionActivity$7$2$1(this).getType()));
                } catch (com.jlboat.phone.view.MapView v1_7) {
                    v1_7.printStackTrace();
                }
                com.jlboat.phone.view.MapView v1_9 = v0_1.getFloors().iterator();
                while (v1_9.hasNext()) {
                    com.boat.support.slam.entity.floors.Floors v2_7 = ((com.boat.support.slam.entity.floors.Floors) v1_9.next());
                    if (v2_7.getFloorId() == v0_1.getDefaultFloor()) {
                        com.jlboat.phone.view.MapView v1_11 = v2_7.getMaps().iterator();
                        while (v1_11.hasNext()) {
                            com.boat.support.slam.entity.floors.Maps v3_4 = ((com.boat.support.slam.entity.floors.Maps) v1_11.next());
                            if (v2_7.getDefaultmap() == v3_4.getMapId()) {
                                if ((v3_4.getRegionList() != null) && (!v3_4.getRegionList().isEmpty())) {
                                    if (this.this$1.this$0.mapView != null) {
                                        this.this$1.this$0.mapView.setRegion(v3_4.getRegionList());
                                    }
                                    if (this.this$1.this$0.RegionListAdapter != null) {
                                        this.this$1.this$0.runOnUiThread(new com.jlboat.phone.activity.MapEditRegionActivity$7$2$2(this, v3_4));
                                    }
                                }
                                if ((v3_4.getPoints() == null) || (v3_4.getPoints().isEmpty())) {
                                    break;
                                }
                                com.jlboat.phone.activity.MapEditRegionActivity.access$502(this.this$1.this$0, new java.util.LinkedList());
                                com.jlboat.phone.view.MapView v1_2 = v3_4.getPoints().iterator();
                                while (v1_2.hasNext()) {
                                    java.util.List v4_5 = ((com.boat.support.slam.entity.floors.Points) v1_2.next());
                                    if (!v4_5.getPointName().equals(com.jlboat.phone.application.BoatSlamApplication.CANCLEPOINTNAME)) {
                                        com.jlboat.phone.activity.MapEditRegionActivity.access$500(this.this$1.this$0).add(v4_5);
                                    }
                                }
                                this.this$1.this$0.mapView.setPoints(com.jlboat.phone.activity.MapEditRegionActivity.access$500(this.this$1.this$0));
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
