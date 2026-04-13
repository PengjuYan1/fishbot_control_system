package com.jlboat.phone.activity;
 class MapCleanAreaActivity$8$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapCleanAreaActivity$8 this$1;

    MapCleanAreaActivity$8$2(com.jlboat.phone.activity.MapCleanAreaActivity$8 p1)
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
                    com.boat.support.slam.entity.floors.MapList v0_1 = ((com.boat.support.slam.entity.floors.MapList) new com.google.gson.Gson().fromJson(new org.json.JSONObject(p10.getMessage()).toString(), new com.jlboat.phone.activity.MapCleanAreaActivity$8$2$1(this).getType()));
                } catch (com.jlboat.phone.activity.MapCleanAreaActivity v1_12) {
                    v1_12.printStackTrace();
                }
                com.jlboat.phone.activity.MapCleanAreaActivity v1_14 = v0_1.getFloors().iterator();
                while (v1_14.hasNext()) {
                    com.boat.support.slam.entity.floors.Floors v2_7 = ((com.boat.support.slam.entity.floors.Floors) v1_14.next());
                    if (v2_7.getFloorId() == v0_1.getDefaultFloor()) {
                        com.jlboat.phone.activity.MapCleanAreaActivity v1_16 = v2_7.getMaps().iterator();
                        while (v1_16.hasNext()) {
                            com.boat.support.slam.entity.floors.Maps v3_4 = ((com.boat.support.slam.entity.floors.Maps) v1_16.next());
                            if (v2_7.getDefaultmap() == v3_4.getMapId()) {
                                if ((v3_4.getShapeAreas() != null) && ((!v3_4.getShapeAreas().isEmpty()) && (this.this$1.this$0.mapView != null))) {
                                    this.this$1.this$0.mapView.setProhibition(v3_4.getShapeAreas());
                                }
                                if ((v3_4.getPoints() != null) && (!v3_4.getPoints().isEmpty())) {
                                    this.this$1.this$0.mapView.setPoints(v3_4.getPoints());
                                }
                                if ((v3_4.getCleanAreas() == null) || (v3_4.getCleanAreas().isEmpty())) {
                                    break;
                                }
                                com.jlboat.phone.activity.MapCleanAreaActivity.access$002(this.this$1.this$0, v3_4.getCleanAreas());
                                if (this.this$1.this$0.mapView != null) {
                                    this.this$1.this$0.mapView.setCleanAreas(v3_4.getCleanAreas());
                                }
                                this.this$1.this$0.runOnUiThread(new com.jlboat.phone.activity.MapCleanAreaActivity$8$2$2(this, v3_4));
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
