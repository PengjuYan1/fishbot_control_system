package com.jlboat.phone.activity;
 class MapActivity$6$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapActivity$6 this$1;

    MapActivity$6$1(com.jlboat.phone.activity.MapActivity$6 p1)
    {
        this.this$1 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_srvs.TriggerResponse) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_srvs.TriggerResponse p18)
    {
        if (p18.getSuccess()) {
            if (!p18.getMessage().isEmpty()) {
                com.jlboat.phone.activity.MapActivity.access$1202(this.this$1.this$0, new com.boat.support.slam.entity.floors.MapList());
                try {
                    com.jlboat.phone.activity.MapActivity.access$1202(this.this$1.this$0, ((com.boat.support.slam.entity.floors.MapList) new com.google.gson.Gson().fromJson(new org.json.JSONObject(p18.getMessage()).toString(), new com.jlboat.phone.activity.MapActivity$6$1$1(this).getType())));
                } catch (java.util.LinkedList v0_68) {
                    v0_68.printStackTrace();
                }
                com.jlboat.phone.activity.MapActivity.access$1302(this.this$1.this$0, com.jlboat.phone.activity.MapActivity.access$1200(this.this$1.this$0).getChargingPrioritys());
                com.jlboat.phone.activity.MapActivity.access$1402(this.this$1.this$0, com.jlboat.phone.activity.MapActivity.access$1200(this.this$1.this$0).getFloors());
                com.jlboat.phone.activity.MapActivity.access$002(this.this$1.this$0, com.jlboat.phone.activity.MapActivity.access$1200(this.this$1.this$0).getDefaultFloor());
                java.util.LinkedList v0_80 = com.jlboat.phone.activity.MapActivity.access$1200(this.this$1.this$0).getFloors().iterator();
                while (v0_80.hasNext()) {
                    int v2_20 = ((com.boat.support.slam.entity.floors.Floors) v0_80.next());
                    if (v2_20.getFloorId() == com.jlboat.phone.activity.MapActivity.access$1200(this.this$1.this$0).getDefaultFloor()) {
                        com.jlboat.phone.activity.MapActivity.access$1502(this.this$1.this$0, v2_20);
                        java.util.LinkedList v0_86 = v2_20.getMaps().iterator();
                        while (v0_86.hasNext()) {
                            com.boat.support.slam.entity.floors.Maps v3_7 = ((com.boat.support.slam.entity.floors.Maps) v0_86.next());
                            if (v2_20.getDefaultmap() == v3_7.getMapId()) {
                                if (com.jlboat.phone.activity.MapActivity.access$800(this.this$1.this$0) == 0) {
                                    if ((v3_7.getShapeAreas() != null) && ((!v3_7.getShapeAreas().isEmpty()) && (com.jlboat.phone.activity.MapActivity.access$900(this.this$1.this$0) != null))) {
                                        com.jlboat.phone.activity.MapActivity.access$900(this.this$1.this$0).setProhibition(v3_7.getShapeAreas());
                                    }
                                    if ((v3_7.getRegionList() != null) && ((!v3_7.getRegionList().isEmpty()) && (com.jlboat.phone.activity.MapActivity.access$900(this.this$1.this$0) != null))) {
                                        com.jlboat.phone.activity.MapActivity.access$900(this.this$1.this$0).setRegion(v3_7.getRegionList());
                                    }
                                    com.jlboat.phone.activity.MapActivity.access$1602(this.this$1.this$0, v3_7.getGlobalPlans());
                                    if ((com.jlboat.phone.activity.MapActivity.access$900(this.this$1.this$0) != null) && ((com.jlboat.phone.activity.MapActivity.access$1600(this.this$1.this$0) != null) && (!com.jlboat.phone.activity.MapActivity.access$1600(this.this$1.this$0).isEmpty()))) {
                                        com.jlboat.phone.activity.MapActivity.access$900(this.this$1.this$0).setGlobalPlans(com.jlboat.phone.activity.MapActivity.access$1600(this.this$1.this$0));
                                    }
                                    if ((v3_7.getNglobalPlans() != null) && ((v3_7.getNglobalPlans().getnLines() != null) && (v3_7.getNglobalPlans().getnLines().size() > 0))) {
                                        java.util.LinkedList v0_46 = new java.util.LinkedList();
                                        com.jlboat.phone.view.MapView v4_9 = v3_7.getNglobalPlans().getnLines().iterator();
                                        while (v4_9.hasNext()) {
                                            com.boat.support.slam.entity.floors.NLine v5_10 = ((com.boat.support.slam.entity.floors.NLine) v4_9.next());
                                            com.jlboat.phone.bean.NgNline v6_3 = new com.jlboat.phone.bean.NgNline();
                                            v6_3.setnLine(v5_10);
                                            int v7_0 = 0;
                                            int v8_1 = 0;
                                            java.util.LinkedList v9_1 = new java.util.LinkedList();
                                            v9_1.addAll(v3_7.getPoints());
                                            v9_1.addAll(v3_7.getSystemPoints());
                                            java.util.Iterator v10_2 = v9_1.iterator();
                                            while (v10_2.hasNext()) {
                                                com.boat.support.slam.entity.floors.Points v11_2 = ((com.boat.support.slam.entity.floors.Points) v10_2.next());
                                                if (v11_2.getPointId() == v5_10.getStartNid()) {
                                                    v6_3.setStartX(v11_2.getPositionX());
                                                    v6_3.setStartY(v11_2.getPositionY());
                                                    v7_0 = 1;
                                                }
                                                if (v11_2.getPointId() == v5_10.getEndNid()) {
                                                    v6_3.setEndX(v11_2.getPositionX());
                                                    v6_3.setEndY(v11_2.getPositionY());
                                                    v8_1 = 1;
                                                }
                                                if ((v7_0 != 0) && (v8_1 != 0)) {
                                                    break;
                                                }
                                            }
                                            v0_46.add(v6_3);
                                        }
                                        com.jlboat.phone.activity.MapActivity.access$900(this.this$1.this$0).setNgLines(v0_46);
                                    }
                                }
                                com.jlboat.phone.activity.MapActivity.access$1702(this.this$1.this$0, v2_20.getMaps());
                                com.jlboat.phone.activity.MapActivity.access$102(this.this$1.this$0, v2_20.getDefaultmap());
                                com.jlboat.phone.activity.MapActivity.access$1800(this.this$1.this$0).clear();
                                com.jlboat.phone.activity.MapActivity.access$1900(this.this$1.this$0).clear();
                                java.util.LinkedList v0_59 = v3_7.getPoints().iterator();
                                while (v0_59.hasNext()) {
                                    com.jlboat.phone.view.MapView v4_22 = ((com.boat.support.slam.entity.floors.Points) v0_59.next());
                                    if (!v4_22.getPointName().equals(com.jlboat.phone.application.BoatSlamApplication.CANCLEPOINTNAME)) {
                                        com.jlboat.phone.activity.MapActivity.access$1800(this.this$1.this$0).add(v4_22);
                                    }
                                }
                                com.jlboat.phone.activity.MapActivity.access$1902(this.this$1.this$0, v3_7.getSystemPoints());
                                com.jlboat.phone.activity.MapActivity.access$1800(this.this$1.this$0).addAll(com.jlboat.phone.activity.MapActivity.access$1900(this.this$1.this$0));
                                break;
                            }
                        }
                    }
                }
                com.jlboat.phone.activity.MapActivity.access$2000(this.this$1.this$0).sendEmptyMessage(1);
            } else {
                return;
            }
        }
        return;
    }
}
