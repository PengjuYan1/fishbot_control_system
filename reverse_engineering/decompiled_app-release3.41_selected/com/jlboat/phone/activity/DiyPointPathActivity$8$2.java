package com.jlboat.phone.activity;
 class DiyPointPathActivity$8$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.DiyPointPathActivity$8 this$1;

    DiyPointPathActivity$8$2(com.jlboat.phone.activity.DiyPointPathActivity$8 p1)
    {
        this.this$1 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_srvs.TriggerResponse) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_srvs.TriggerResponse p19)
    {
        if (p19.getSuccess()) {
            if (!p19.getMessage().isEmpty()) {
                new com.boat.support.slam.entity.floors.MapList();
                try {
                    com.boat.support.slam.entity.floors.MapList v2 = ((com.boat.support.slam.entity.floors.MapList) new com.google.gson.Gson().fromJson(new org.json.JSONObject(p19.getMessage()).toString(), new com.jlboat.phone.activity.DiyPointPathActivity$8$2$1(this).getType()));
                } catch (java.util.LinkedList v0_27) {
                    v0_27.printStackTrace();
                }
                java.util.LinkedList v0_29 = v2.getFloors().iterator();
                while (v0_29.hasNext()) {
                    com.boat.support.slam.entity.floors.Floors v3_7 = ((com.boat.support.slam.entity.floors.Floors) v0_29.next());
                    if (v3_7.getFloorId() == v2.getDefaultFloor()) {
                        com.jlboat.phone.activity.DiyPointPathActivity.access$802(this.this$1.this$0, v3_7);
                        java.util.LinkedList v0_34 = v3_7.getMaps().iterator();
                        while (v0_34.hasNext()) {
                            com.boat.support.slam.entity.floors.Maps v4_4 = ((com.boat.support.slam.entity.floors.Maps) v0_34.next());
                            if (v3_7.getDefaultmap() == v4_4.getMapId()) {
                                com.jlboat.phone.activity.DiyPointPathActivity.access$902(this.this$1.this$0, v4_4);
                                if ((v4_4.getShapeAreas() != null) && ((!v4_4.getShapeAreas().isEmpty()) && (com.jlboat.phone.activity.DiyPointPathActivity.access$400(this.this$1.this$0) != null))) {
                                    com.jlboat.phone.activity.DiyPointPathActivity.access$400(this.this$1.this$0).setProhibition(v4_4.getShapeAreas());
                                }
                                if ((v4_4.getPoints() != null) && (!v4_4.getPoints().isEmpty())) {
                                    com.jlboat.phone.activity.DiyPointPathActivity.access$200(this.this$1.this$0).clear();
                                    com.jlboat.phone.activity.DiyPointPathActivity.access$102(this.this$1.this$0, v4_4.getPoints());
                                    com.jlboat.phone.activity.DiyPointPathActivity.access$100(this.this$1.this$0).addAll(v4_4.getSystemPoints());
                                    java.util.LinkedList v0_7 = v4_4.getPoints().iterator();
                                    while (v0_7.hasNext()) {
                                        com.jlboat.phone.activity.DiyPointPathActivity v5_24 = ((com.boat.support.slam.entity.floors.Points) v0_7.next());
                                        if (!v5_24.getPointName().equals(com.jlboat.phone.application.BoatSlamApplication.CANCLEPOINTNAME)) {
                                            com.jlboat.phone.activity.DiyPointPathActivity.access$200(this.this$1.this$0).add(v5_24);
                                        }
                                    }
                                    java.util.LinkedList v0_10 = v4_4.getSystemPoints().iterator();
                                    while (v0_10.hasNext()) {
                                        com.jlboat.phone.activity.DiyPointPathActivity v5_22 = ((com.boat.support.slam.entity.floors.Points) v0_10.next());
                                        if (!v5_22.getPointName().equals(com.jlboat.phone.application.BoatSlamApplication.CANCLEPOINTNAME)) {
                                            com.jlboat.phone.activity.DiyPointPathActivity.access$200(this.this$1.this$0).add(v5_22);
                                        }
                                    }
                                    com.jlboat.phone.activity.DiyPointPathActivity.access$400(this.this$1.this$0).setPoints(com.jlboat.phone.activity.DiyPointPathActivity.access$100(this.this$1.this$0));
                                    if ((v4_4.getNglobalPlans() != null) && ((v4_4.getNglobalPlans().getnLines() != null) && (v4_4.getNglobalPlans().getnLines().size() > 0))) {
                                        java.util.LinkedList v0_22 = new java.util.LinkedList();
                                        com.jlboat.phone.activity.DiyPointPathActivity v5_9 = v4_4.getNglobalPlans().getnLines().iterator();
                                        while (v5_9.hasNext()) {
                                            com.jlboat.phone.activity.DiyPointPathActivity$8$2$2 v6_4 = ((com.boat.support.slam.entity.floors.NLine) v5_9.next());
                                            com.jlboat.phone.bean.NgNline v7_1 = new com.jlboat.phone.bean.NgNline();
                                            v7_1.setnLine(v6_4);
                                            int v8_0 = 0;
                                            int v9_0 = 0;
                                            java.util.LinkedList v10_1 = new java.util.LinkedList();
                                            v10_1.addAll(v4_4.getPoints());
                                            v10_1.addAll(v4_4.getSystemPoints());
                                            java.util.Iterator v11_2 = v10_1.iterator();
                                            while (v11_2.hasNext()) {
                                                com.boat.support.slam.entity.floors.Points v12_2 = ((com.boat.support.slam.entity.floors.Points) v11_2.next());
                                                if (v12_2.getPointId() == v6_4.getStartNid()) {
                                                    v7_1.setStartX(v12_2.getPositionX());
                                                    v7_1.setStartY(v12_2.getPositionY());
                                                    v8_0 = 1;
                                                }
                                                if (v12_2.getPointId() == v6_4.getEndNid()) {
                                                    v7_1.setEndX(v12_2.getPositionX());
                                                    v7_1.setEndY(v12_2.getPositionY());
                                                    v9_0 = 1;
                                                }
                                                if ((v8_0 != 0) && (v9_0 != 0)) {
                                                    break;
                                                }
                                            }
                                            v0_22.add(v7_1);
                                        }
                                        com.jlboat.phone.activity.DiyPointPathActivity.access$502(this.this$1.this$0, v0_22);
                                        com.jlboat.phone.activity.DiyPointPathActivity.access$400(this.this$1.this$0).setNgLines(v0_22);
                                        this.this$1.this$0.runOnUiThread(new com.jlboat.phone.activity.DiyPointPathActivity$8$2$2(this, v0_22));
                                    }
                                }
                                com.jlboat.phone.activity.DiyPointPathActivity.access$1500(this.this$1.this$0).sendEmptyMessage(4);
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
