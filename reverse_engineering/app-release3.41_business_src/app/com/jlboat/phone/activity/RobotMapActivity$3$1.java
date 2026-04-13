package com.jlboat.phone.activity;
 class RobotMapActivity$3$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.RobotMapActivity$3 this$1;

    RobotMapActivity$3$1(com.jlboat.phone.activity.RobotMapActivity$3 p1)
    {
        this.this$1 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_srvs.TriggerResponse) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_srvs.TriggerResponse p17)
    {
        if (p17.getSuccess()) {
            if (!p17.getMessage().isEmpty()) {
                com.jlboat.phone.activity.RobotMapActivity.access$602(this.this$1.this$0, new com.boat.support.slam.entity.floors.MapList());
                try {
                    com.jlboat.phone.activity.RobotMapActivity.access$602(this.this$1.this$0, ((com.boat.support.slam.entity.floors.MapList) new com.google.gson.Gson().fromJson(new org.json.JSONObject(p17.getMessage()).toString(), new com.jlboat.phone.activity.RobotMapActivity$3$1$1(this).getType())));
                } catch (java.util.LinkedList v0_50) {
                    v0_50.printStackTrace();
                }
                com.jlboat.phone.activity.RobotMapActivity.access$702(this.this$1.this$0, com.jlboat.phone.activity.RobotMapActivity.access$600(this.this$1.this$0).getFloors());
                com.jlboat.phone.activity.RobotMapActivity.access$002(this.this$1.this$0, com.jlboat.phone.activity.RobotMapActivity.access$600(this.this$1.this$0).getDefaultFloor());
                java.util.LinkedList v0_60 = com.jlboat.phone.activity.RobotMapActivity.access$600(this.this$1.this$0).getFloors().iterator();
                while (v0_60.hasNext()) {
                    int v2_16 = ((com.boat.support.slam.entity.floors.Floors) v0_60.next());
                    if (v2_16.getFloorId() == com.jlboat.phone.activity.RobotMapActivity.access$600(this.this$1.this$0).getDefaultFloor()) {
                        com.jlboat.phone.activity.RobotMapActivity.access$802(this.this$1.this$0, v2_16);
                        java.util.LinkedList v0_65 = v2_16.getMaps().iterator();
                        while (v0_65.hasNext()) {
                            com.boat.support.slam.entity.floors.Maps v3_7 = ((com.boat.support.slam.entity.floors.Maps) v0_65.next());
                            if (v2_16.getDefaultmap() == v3_7.getMapId()) {
                                if (com.jlboat.phone.activity.RobotMapActivity.access$900() == 0) {
                                    if ((v3_7.getShapeAreas() != null) && ((!v3_7.getShapeAreas().isEmpty()) && (com.jlboat.phone.activity.RobotMapActivity.access$500(this.this$1.this$0) != null))) {
                                        com.jlboat.phone.activity.RobotMapActivity.access$500(this.this$1.this$0).setProhibition(v3_7.getShapeAreas());
                                    }
                                    if ((v3_7.getRegionList() != null) && ((!v3_7.getRegionList().isEmpty()) && (com.jlboat.phone.activity.RobotMapActivity.access$500(this.this$1.this$0) != null))) {
                                        com.jlboat.phone.activity.RobotMapActivity.access$500(this.this$1.this$0).setRegion(v3_7.getRegionList());
                                    }
                                    if ((v3_7.getNglobalPlans() != null) && ((v3_7.getNglobalPlans().getnLines() != null) && (v3_7.getNglobalPlans().getnLines().size() > 0))) {
                                        java.util.LinkedList v0_27 = new java.util.LinkedList();
                                        com.jlboat.phone.view.MapView v4_4 = v3_7.getNglobalPlans().getnLines().iterator();
                                        while (v4_4.hasNext()) {
                                            com.boat.support.slam.entity.floors.NLine v5_7 = ((com.boat.support.slam.entity.floors.NLine) v4_4.next());
                                            com.jlboat.phone.bean.NgNline v6_2 = new com.jlboat.phone.bean.NgNline();
                                            v6_2.setnLine(v5_7);
                                            int v7_0 = 0;
                                            int v8_0 = 0;
                                            java.util.Iterator v9_1 = v3_7.getPoints().iterator();
                                            while (v9_1.hasNext()) {
                                                com.boat.support.slam.entity.floors.Points v10_2 = ((com.boat.support.slam.entity.floors.Points) v9_1.next());
                                                if (v10_2.getPointId() == v5_7.getStartNid()) {
                                                    v6_2.setStartX(v10_2.getPositionX());
                                                    v6_2.setStartY(v10_2.getPositionY());
                                                    v7_0 = 1;
                                                }
                                                if (v10_2.getPointId() == v5_7.getEndNid()) {
                                                    v6_2.setEndX(v10_2.getPositionX());
                                                    v6_2.setEndY(v10_2.getPositionY());
                                                    v8_0 = 1;
                                                }
                                                if ((v7_0 != 0) && (v8_0 != 0)) {
                                                    break;
                                                }
                                            }
                                            v0_27.add(v6_2);
                                        }
                                        com.jlboat.phone.activity.RobotMapActivity.access$500(this.this$1.this$0).setNgLines(v0_27);
                                    }
                                }
                                com.jlboat.phone.activity.RobotMapActivity.access$1002(this.this$1.this$0, v2_16.getMaps());
                                com.jlboat.phone.activity.RobotMapActivity.access$102(this.this$1.this$0, v2_16.getDefaultmap());
                                com.jlboat.phone.activity.RobotMapActivity.access$1100(this.this$1.this$0).clear();
                                com.jlboat.phone.activity.RobotMapActivity.access$1200(this.this$1.this$0).clear();
                                java.util.LinkedList v0_40 = v3_7.getPoints().iterator();
                                while (v0_40.hasNext()) {
                                    com.jlboat.phone.view.MapView v4_16 = ((com.boat.support.slam.entity.floors.Points) v0_40.next());
                                    if (!v4_16.getPointName().equals(com.jlboat.phone.application.BoatSlamApplication.CANCLEPOINTNAME)) {
                                        com.jlboat.phone.activity.RobotMapActivity.access$1100(this.this$1.this$0).add(v4_16);
                                    }
                                }
                                com.jlboat.phone.activity.RobotMapActivity.access$1202(this.this$1.this$0, v3_7.getSystemPoints());
                                com.jlboat.phone.activity.RobotMapActivity.access$1100(this.this$1.this$0).addAll(com.jlboat.phone.activity.RobotMapActivity.access$1200(this.this$1.this$0));
                                break;
                            }
                        }
                    }
                }
                com.jlboat.phone.activity.RobotMapActivity.access$1300(this.this$1.this$0).sendEmptyMessage(1);
            } else {
                return;
            }
        }
        return;
    }
}
