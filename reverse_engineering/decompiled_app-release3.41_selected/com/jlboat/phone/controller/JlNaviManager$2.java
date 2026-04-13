package com.jlboat.phone.controller;
 class JlNaviManager$2 extends android.content.BroadcastReceiver {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$2(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onReceive(android.content.Context p10, android.content.Intent p11)
    {
        if ((p11 != null) && (p11.getAction() != null)) {
            String v0_5;
            String v0_15 = p11.getAction();
            switch (v0_15.hashCode()) {
                case -1172645946:
                    if (!v0_15.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                        v0_5 = -1;
                    } else {
                        v0_5 = 0;
                    }
                    break;
                case -715721437:
                    if (!v0_15.equals("com.boat.launcher.action.network")) {
                    } else {
                        v0_5 = 1;
                    }
                    break;
                case -100506299:
                    if (!v0_15.equals("com.boat.action.WiFICONFIG_ROS")) {
                    } else {
                        v0_5 = 2;
                    }
                    break;
                case 472913819:
                    if (!v0_15.equals("com.jboat.action.allmap_and_res")) {
                    } else {
                        v0_5 = 4;
                    }
                    break;
                case 717592887:
                    if (!v0_15.equals("com.boat.action.CocoNum")) {
                    } else {
                        v0_5 = 3;
                    }
                    break;
                default:
            }
            switch (v0_5) {
                case 0:
                    com.jlboat.phone.application.BoatSlamApplication.clearDefaultNetwork();
                    com.jlboat.phone.application.BoatSlamApplication.setDefaultNetwork();
                    break;
                case 1:
                    String v0_8 = p11.getBooleanExtra("isConnect", 0);
                    if (v0_8 != null) {
                        com.jlboat.phone.controller.JlNaviManager.access$2800(this.this$0);
                    }
                    com.jlboat.phone.controller.JlNaviManager.access$402(this.this$0, v0_8);
                    break;
                case 2:
                    String v0_3 = p11.getStringExtra("ssid");
                    if (v0_3 != null) {
                        String v0_4 = v0_3.substring(1, (v0_3.length() - com.jlboat.phone.controller.JlNaviManager v2_27));
                        String v1_4 = p11.getStringExtra("passwd");
                        if (v1_4 != null) {
                            android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("onReceive: \u53d1\u9001\u6d88\u606f\u7ed9\u5e95\u76d8").append(v0_4).append("====").append(v1_4).toString());
                            this.this$0.toast(new StringBuilder().append("onReceive: com.boat.action.WiFICONFIG_ROS ssid = ").append(v0_4).append(" passwd: ").append(v1_4).toString());
                            if ((!com.jlboat.phone.controller.JlNaviManager.access$700(this.this$0)) || (!com.jlboat.phone.controller.JlNaviManager.access$900(this.this$0))) {
                            } else {
                                this.this$0.setWifiConfig(v0_4, v1_4);
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                case 3:
                    com.jlboat.phone.controller.JlNaviManager.access$2900(this.this$0);
                    break;
                case 4:
                    String v0_14 = p11.getStringExtra("allmaps");
                    String v1_12 = p11.getBooleanExtra("isUploadMapFile", 0);
                    if (v0_14 != null) {
                        try {
                            com.jlboat.phone.controller.JlNaviManager.access$3002(this.this$0, ((com.boat.support.slam.entity.floors.MapList) new com.google.gson.Gson().fromJson(v0_14, new com.jlboat.phone.controller.JlNaviManager$2$1(this).getType())));
                        } catch (com.jlboat.phone.controller.JlNaviManager v2_15) {
                            v2_15.printStackTrace();
                        }
                        if ((com.jlboat.phone.controller.JlNaviManager.access$3000(this.this$0) != null) && ((com.jlboat.phone.controller.JlNaviManager.access$3000(this.this$0).getFloors() != null) && (!com.jlboat.phone.controller.JlNaviManager.access$3000(this.this$0).getFloors().isEmpty()))) {
                            if (v1_12 != null) {
                                com.jlboat.phone.controller.JlNaviManager v2_26 = new android.content.Intent();
                                v2_26.setClassName("com.jlboat.phone", "com.jlboat.phone.service.DownloadFileService");
                                v2_26.setAction("download_floor_maps");
                                v2_26.putExtra("floors", com.jlboat.phone.controller.JlNaviManager.access$3000(this.this$0));
                                this.this$0.getApp().startService(v2_26);
                            }
                            com.jlboat.phone.controller.JlNaviManager v2_31 = com.jlboat.phone.controller.JlNaviManager.access$3000(this.this$0).getFloors().iterator();
                            while (v2_31.hasNext()) {
                                com.boat.support.slam.entity.floors.Floors v3_2 = ((com.boat.support.slam.entity.floors.Floors) v2_31.next());
                                if (com.jlboat.phone.controller.JlNaviManager.access$3000(this.this$0).getDefaultFloor() == v3_2.getFloorId()) {
                                    android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("onReceive: \u540e\u53f0\u5904\u7406\u540e\u7684map isUploadMapFile: ").append(v1_12).toString());
                                    com.jlboat.phone.controller.JlNaviManager.access$3102(this.this$0, v3_2);
                                    break;
                                }
                            }
                        }
                    }
                    if (this.this$0.isMapUpdateEnd) {
                    } else {
                        com.jlboat.phone.controller.JlNaviManager.access$2500(this.this$0);
                    }
                    break;
                default:
            }
            return;
        } else {
            return;
        }
    }
}
