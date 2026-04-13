package com.jlboat.phone.activity;
 class DiyPathActivity$3$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.DiyPathActivity$3 this$1;

    DiyPathActivity$3$1(com.jlboat.phone.activity.DiyPathActivity$3 p1)
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
                    com.boat.support.slam.entity.floors.MapList v0_1 = ((com.boat.support.slam.entity.floors.MapList) new com.google.gson.Gson().fromJson(new org.json.JSONObject(p10.getMessage()).toString(), new com.jlboat.phone.activity.DiyPathActivity$3$1$1(this).getType()));
                } catch (com.jlboat.phone.view.MapView v1_23) {
                    v1_23.printStackTrace();
                }
                com.jlboat.phone.view.MapView v1_25 = v0_1.getFloors().iterator();
                while (v1_25.hasNext()) {
                    com.boat.support.slam.entity.floors.Floors v2_7 = ((com.boat.support.slam.entity.floors.Floors) v1_25.next());
                    if (v2_7.getFloorId() == v0_1.getDefaultFloor()) {
                        com.jlboat.phone.view.MapView v1_27 = v2_7.getMaps().iterator();
                        while (v1_27.hasNext()) {
                            com.boat.support.slam.entity.floors.Maps v3_4 = ((com.boat.support.slam.entity.floors.Maps) v1_27.next());
                            if (v2_7.getDefaultmap() == v3_4.getMapId()) {
                                if ((v3_4.getShapeAreas() != null) && ((!v3_4.getShapeAreas().isEmpty()) && (com.jlboat.phone.activity.DiyPathActivity.access$1800(this.this$1.this$0) != null))) {
                                    com.jlboat.phone.activity.DiyPathActivity.access$1800(this.this$1.this$0).setProhibition(v3_4.getShapeAreas());
                                }
                                if ((v3_4.getPoints() != null) && (!v3_4.getPoints().isEmpty())) {
                                    com.jlboat.phone.activity.DiyPathActivity.access$1100(this.this$1.this$0).clear();
                                    com.jlboat.phone.view.MapView v1_44 = v3_4.getPoints().iterator();
                                    while (v1_44.hasNext()) {
                                        java.util.List v4_15 = ((com.boat.support.slam.entity.floors.Points) v1_44.next());
                                        if (!v4_15.getPointName().equals(com.jlboat.phone.application.BoatSlamApplication.CANCLEPOINTNAME)) {
                                            com.jlboat.phone.activity.DiyPathActivity.access$1100(this.this$1.this$0).add(v4_15);
                                        }
                                    }
                                    com.jlboat.phone.activity.DiyPathActivity.access$1800(this.this$1.this$0).setPoints(com.jlboat.phone.activity.DiyPathActivity.access$1100(this.this$1.this$0));
                                }
                                com.jlboat.phone.activity.DiyPathActivity.access$402(this.this$1.this$0, v3_4.getGlobalPlans());
                                if ((com.jlboat.phone.activity.DiyPathActivity.access$400(this.this$1.this$0) != null) && (!com.jlboat.phone.activity.DiyPathActivity.access$400(this.this$1.this$0).isEmpty())) {
                                    com.jlboat.phone.activity.DiyPathActivity.access$1800(this.this$1.this$0).setGlobalPlans(com.jlboat.phone.activity.DiyPathActivity.access$400(this.this$1.this$0));
                                    com.jlboat.phone.activity.DiyPathActivity.access$1800(this.this$1.this$0).setSelectedGlobalPlans(((com.boat.support.slam.entity.floors.GlobalPlans) com.jlboat.phone.activity.DiyPathActivity.access$400(this.this$1.this$0).get(com.jlboat.phone.activity.DiyPathActivity.access$600(this.this$1.this$0))).getGlobalplanId());
                                }
                                com.jlboat.phone.activity.DiyPathActivity.access$2000(this.this$1.this$0).sendEmptyMessage(1004);
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
