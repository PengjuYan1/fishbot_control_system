package com.jlboat.phone.activity;
 class MapExpansionActivity$4$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapExpansionActivity$4 this$1;

    MapExpansionActivity$4$1(com.jlboat.phone.activity.MapExpansionActivity$4 p1)
    {
        this.this$1 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_srvs.TriggerResponse) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_srvs.TriggerResponse p9)
    {
        if (p9.getSuccess()) {
            if (!p9.getMessage().isEmpty()) {
                com.jlboat.phone.activity.MapExpansionActivity.access$602(this.this$1.this$0, new com.boat.support.slam.entity.floors.MapList());
                try {
                    com.jlboat.phone.activity.MapExpansionActivity.access$602(this.this$1.this$0, ((com.boat.support.slam.entity.floors.MapList) new com.google.gson.Gson().fromJson(new org.json.JSONObject(p9.getMessage()).toString(), new com.jlboat.phone.activity.MapExpansionActivity$4$1$1(this).getType())));
                } catch (com.jlboat.phone.view.MapView v0_39) {
                    v0_39.printStackTrace();
                }
                com.jlboat.phone.activity.MapExpansionActivity.access$702(this.this$1.this$0, com.jlboat.phone.activity.MapExpansionActivity.access$600(this.this$1.this$0).getFloors());
                com.jlboat.phone.activity.MapExpansionActivity.access$002(this.this$1.this$0, com.jlboat.phone.activity.MapExpansionActivity.access$600(this.this$1.this$0).getDefaultFloor());
                com.jlboat.phone.view.MapView v0_49 = com.jlboat.phone.activity.MapExpansionActivity.access$600(this.this$1.this$0).getFloors().iterator();
                while (v0_49.hasNext()) {
                    int v1_16 = ((com.boat.support.slam.entity.floors.Floors) v0_49.next());
                    if (v1_16.getFloorId() == com.jlboat.phone.activity.MapExpansionActivity.access$600(this.this$1.this$0).getDefaultFloor()) {
                        com.jlboat.phone.activity.MapExpansionActivity.access$802(this.this$1.this$0, v1_16);
                        com.jlboat.phone.view.MapView v0_55 = v1_16.getMaps().iterator();
                        while (v0_55.hasNext()) {
                            com.boat.support.slam.entity.floors.Maps v2_7 = ((com.boat.support.slam.entity.floors.Maps) v0_55.next());
                            if (v1_16.getDefaultmap() == v2_7.getMapId()) {
                                if (com.jlboat.phone.activity.MapExpansionActivity.access$900(this.this$1.this$0) == 0) {
                                    if ((v2_7.getShapeAreas() != null) && ((!v2_7.getShapeAreas().isEmpty()) && (com.jlboat.phone.activity.MapExpansionActivity.access$500(this.this$1.this$0) != null))) {
                                        com.jlboat.phone.activity.MapExpansionActivity.access$500(this.this$1.this$0).setProhibition(v2_7.getShapeAreas());
                                    }
                                    com.jlboat.phone.activity.MapExpansionActivity.access$1002(this.this$1.this$0, v2_7.getGlobalPlans());
                                    if ((com.jlboat.phone.activity.MapExpansionActivity.access$500(this.this$1.this$0) != null) && ((com.jlboat.phone.activity.MapExpansionActivity.access$1000(this.this$1.this$0) != null) && (!com.jlboat.phone.activity.MapExpansionActivity.access$1000(this.this$1.this$0).isEmpty()))) {
                                        com.jlboat.phone.activity.MapExpansionActivity.access$500(this.this$1.this$0).setGlobalPlans(com.jlboat.phone.activity.MapExpansionActivity.access$1000(this.this$1.this$0));
                                    }
                                }
                                com.jlboat.phone.activity.MapExpansionActivity.access$1102(this.this$1.this$0, v1_16.getMaps());
                                com.jlboat.phone.activity.MapExpansionActivity.access$102(this.this$1.this$0, v1_16.getDefaultmap());
                                com.jlboat.phone.activity.MapExpansionActivity.access$1200(this.this$1.this$0).clear();
                                com.jlboat.phone.view.MapView v0_35 = v2_7.getPoints().iterator();
                                while (v0_35.hasNext()) {
                                    java.util.List v3_9 = ((com.boat.support.slam.entity.floors.Points) v0_35.next());
                                    if (!v3_9.getPointName().equals(com.jlboat.phone.application.BoatSlamApplication.CANCLEPOINTNAME)) {
                                        com.jlboat.phone.activity.MapExpansionActivity.access$1200(this.this$1.this$0).add(v3_9);
                                    }
                                }
                            }
                        }
                    }
                }
                com.jlboat.phone.activity.MapExpansionActivity.access$1300(this.this$1.this$0).sendEmptyMessage(1);
            } else {
                return;
            }
        }
        return;
    }
}
