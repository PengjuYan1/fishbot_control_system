package com.jlboat.phone.controller;
 class JlNaviManager$1 extends android.os.Handler {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$1(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p12)
    {
        super.handleMessage(p12);
        switch (p12.what) {
            case 0:
                android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), "handleMessage: ping \u7f51\u5173\u5f00\u59cb ");
                new Thread(new com.jlboat.phone.controller.JlNaviManager$1$1(this)).start();
                break;
            case 1:
                this.this$0.getRosHostname();
                break;
            case 2:
                android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), "handleMessage: \u5f00\u59cb\u767b\u5f55\u8fde\u63a5");
                com.jlboat.phone.application.BoatSlamApplication.client.connect(new com.jlboat.phone.controller.JlNaviManager$1$2(this));
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                com.jlboat.phone.controller.JlNaviManager.access$1000();
                try {
                    Throwable v1_29 = com.jlboat.phone.controller.JlNaviManager.access$1000().beginBroadcast();
                    int v2_17 = 0;
                } catch (Throwable v1_31) {
                    throw v1_31;
                }
                while (v2_17 < v1_29) {
                    try {
                        ((com.boat.support.slam.ISlamCallBack) com.jlboat.phone.controller.JlNaviManager.access$1000().getBroadcastItem(v2_17)).onChargeChanged(com.jlboat.phone.controller.JlNaviManager.access$1100(this.this$0));
                    } catch (RuntimeException v4_16) {
                        android.util.Log.i(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("remoteE = ").append(v4_16.toString()).toString());
                    }
                    v2_17++;
                }
                com.jlboat.phone.controller.JlNaviManager.access$1000().finishBroadcast();
                break;
            case 6:
                android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), "handleMessage: els");
                com.jlboat.phone.controller.JlNaviManager.access$1000();
                try {
                    Throwable v1_24 = com.jlboat.phone.controller.JlNaviManager.access$1000().beginBroadcast();
                    int v2_14 = 0;
                } catch (Throwable v1_27) {
                    throw v1_27;
                }
                while (v2_14 < v1_24) {
                    try {
                        ((com.boat.support.slam.ISlamCallBack) com.jlboat.phone.controller.JlNaviManager.access$1000().getBroadcastItem(v2_14)).onEmergencyStop(com.jlboat.phone.controller.JlNaviManager.access$1200(this.this$0));
                    } catch (RuntimeException v4_13) {
                        android.util.Log.i(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("remoteE = ").append(v4_13.toString()).toString());
                    }
                    v2_14++;
                }
                com.jlboat.phone.controller.JlNaviManager.access$1000().finishBroadcast();
                break;
            case 7:
                com.jlboat.phone.controller.JlNaviManager.access$1000();
                try {
                    Throwable v1_20 = com.jlboat.phone.controller.JlNaviManager.access$1000().beginBroadcast();
                    int v2_11 = 0;
                } catch (Throwable v1_21) {
                    throw v1_21;
                }
                while (v2_11 < v1_20) {
                    try {
                        ((com.boat.support.slam.ISlamCallBack) com.jlboat.phone.controller.JlNaviManager.access$1000().getBroadcastItem(v2_11)).onBatteryChange(com.jlboat.phone.controller.JlNaviManager.access$800(this.this$0));
                    } catch (RuntimeException v4_10) {
                        android.util.Log.i(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("remoteE = ").append(v4_10.toString()).toString());
                    }
                    v2_11++;
                }
                com.jlboat.phone.controller.JlNaviManager.access$1000().finishBroadcast();
                break;
            case 8:
                com.jlboat.phone.controller.JlNaviManager.access$1300(this.this$0);
                com.jlboat.phone.controller.JlNaviManager.access$1000();
                try {
                    Throwable v1_16 = com.jlboat.phone.controller.JlNaviManager.access$1000().beginBroadcast();
                    int v2_9 = 0;
                } catch (Throwable v1_18) {
                    throw v1_18;
                }
                while (v2_9 < v1_16) {
                    try {
                        ((com.boat.support.slam.ISlamCallBack) com.jlboat.phone.controller.JlNaviManager.access$1000().getBroadcastItem(v2_9)).onMoveStatusChange(com.jlboat.phone.controller.JlNaviManager.access$1400(this.this$0));
                    } catch (RuntimeException v4_7) {
                        android.util.Log.i(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("remoteE = ").append(v4_7.toString()).toString());
                    } catch (RuntimeException v4_7) {
                    }
                    v2_9++;
                }
                com.jlboat.phone.controller.JlNaviManager.access$1000().finishBroadcast();
                break;
            case 9:
                com.jlboat.phone.controller.JlNaviManager.access$1000();
                try {
                    Throwable v1_10 = com.jlboat.phone.controller.JlNaviManager.access$1000().beginBroadcast();
                    int v2_6 = 0;
                } catch (Throwable v1_13) {
                    throw v1_13;
                }
                while (v2_6 < v1_10) {
                    try {
                        ((com.boat.support.slam.ISlamCallBack) com.jlboat.phone.controller.JlNaviManager.access$1000().getBroadcastItem(v2_6)).onSlamInit();
                    } catch (RuntimeException v4_4) {
                        android.util.Log.i(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("remoteE = ").append(v4_4.toString()).toString());
                    } catch (RuntimeException v4_4) {
                    }
                    v2_6++;
                }
                com.jlboat.phone.controller.JlNaviManager.access$1000().finishBroadcast();
                break;
            case 10:
                com.jlboat.phone.controller.JlNaviManager.access$1000();
                try {
                    Throwable v1_5 = com.jlboat.phone.controller.JlNaviManager.access$1000().beginBroadcast();
                    int v2_3 = 0;
                } catch (Throwable v1_8) {
                    throw v1_8;
                }
                while (v2_3 < v1_5) {
                    try {
                        ((com.boat.support.slam.ISlamCallBack) com.jlboat.phone.controller.JlNaviManager.access$1000().getBroadcastItem(v2_3)).onLocalizationLost();
                    } catch (RuntimeException v4_3) {
                        android.util.Log.i(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("remoteE = ").append(v4_3.toString()).toString());
                    } catch (RuntimeException v4_3) {
                    }
                    v2_3++;
                }
                com.jlboat.phone.controller.JlNaviManager.access$1000().finishBroadcast();
                break;
            case 11:
                com.jlboat.phone.controller.JlNaviManager.access$1000();
                try {
                    Throwable v1_2 = com.jlboat.phone.controller.JlNaviManager.access$1000().beginBroadcast();
                    int v2_1 = 0;
                } catch (Throwable v1_3) {
                    throw v1_3;
                }
                while (v2_1 < v1_2) {
                    try {
                        ((com.boat.support.slam.ISlamCallBack) com.jlboat.phone.controller.JlNaviManager.access$1000().getBroadcastItem(v2_1)).onNaviToNameCallback(com.jlboat.phone.controller.JlNaviManager.access$1500(this.this$0));
                    } catch (RuntimeException v4_2) {
                        android.util.Log.i(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("remoteE = ").append(v4_2.toString()).toString());
                    } catch (RuntimeException v4_2) {
                    }
                    v2_1++;
                }
                com.jlboat.phone.controller.JlNaviManager.access$1000().finishBroadcast();
                break;
            case 12:
                com.jlboat.phone.controller.JlNaviManager.access$1000();
                try {
                    Throwable v1_171 = com.jlboat.phone.controller.JlNaviManager.access$1000().beginBroadcast();
                    int v2_0 = 0;
                } catch (Throwable v1_0) {
                    throw v1_0;
                }
                while (v2_0 < v1_171) {
                    try {
                        ((com.boat.support.slam.ISlamCallBack) com.jlboat.phone.controller.JlNaviManager.access$1000().getBroadcastItem(v2_0)).onMapUpdate();
                    } catch (RuntimeException v4_52) {
                        android.util.Log.i(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("remoteE = ").append(v4_52.toString()).toString());
                    } catch (RuntimeException v4_52) {
                    }
                    v2_0++;
                }
                com.jlboat.phone.controller.JlNaviManager.access$1000().finishBroadcast();
                break;
            case 13:
                com.jlboat.phone.controller.JlNaviManager.access$1000();
                try {
                    Throwable v1_168 = com.jlboat.phone.controller.JlNaviManager.access$1000().beginBroadcast();
                    int v2_77 = 0;
                } catch (Throwable v1_169) {
                    throw v1_169;
                }
                while (v2_77 < v1_168) {
                    try {
                        ((com.boat.support.slam.ISlamCallBack) com.jlboat.phone.controller.JlNaviManager.access$1000().getBroadcastItem(v2_77)).onLocalizationStatus(com.jlboat.phone.controller.JlNaviManager.access$1800(this.this$0));
                    } catch (RuntimeException v4_50) {
                        android.util.Log.i(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("remoteE = ").append(v4_50.toString()).toString());
                    } catch (RuntimeException v4_50) {
                    }
                    v2_77++;
                }
                com.jlboat.phone.controller.JlNaviManager.access$1000().finishBroadcast();
                break;
            case 14:
                com.jlboat.phone.controller.JlNaviManager.access$1000();
                try {
                    Throwable v1_165 = com.jlboat.phone.controller.JlNaviManager.access$1000().beginBroadcast();
                    int v2_75 = 0;
                } catch (Throwable v1_166) {
                    throw v1_166;
                }
                while (v2_75 < v1_165) {
                    try {
                        ((com.boat.support.slam.ISlamCallBack) com.jlboat.phone.controller.JlNaviManager.access$1000().getBroadcastItem(v2_75)).onMotorLock(com.jlboat.phone.controller.JlNaviManager.access$1900(this.this$0));
                    } catch (RuntimeException v4_47) {
                        android.util.Log.i(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("remoteE = ").append(v4_47.toString()).toString());
                    } catch (RuntimeException v4_47) {
                    }
                    v2_75++;
                }
                com.jlboat.phone.controller.JlNaviManager.access$1000().finishBroadcast();
                break;
            case 15:
                com.jlboat.phone.controller.JlNaviManager.access$1000();
                try {
                    Throwable v1_161 = com.jlboat.phone.controller.JlNaviManager.access$1000().beginBroadcast();
                    int v2_73 = 0;
                } catch (Throwable v1_162) {
                    throw v1_162;
                }
                while (v2_73 < v1_161) {
                    try {
                        ((com.boat.support.slam.ISlamCallBack) com.jlboat.phone.controller.JlNaviManager.access$1000().getBroadcastItem(v2_73)).onChangeMotionMode(com.jlboat.phone.controller.JlNaviManager.access$2000(this.this$0));
                    } catch (RuntimeException v4_44) {
                        android.util.Log.i(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("remoteE = ").append(v4_44.toString()).toString());
                    } catch (RuntimeException v4_44) {
                    }
                    v2_73++;
                }
                com.jlboat.phone.controller.JlNaviManager.access$1000().finishBroadcast();
                break;
            case 16:
                com.jlboat.phone.controller.JlNaviManager.access$1000();
                try {
                    Throwable v1_156 = com.jlboat.phone.controller.JlNaviManager.access$1000().beginBroadcast();
                    int v2_71 = 0;
                } catch (Throwable v1_158) {
                    throw v1_158;
                }
                while (v2_71 < v1_156) {
                    try {
                        ((com.boat.support.slam.ISlamCallBack) com.jlboat.phone.controller.JlNaviManager.access$1000().getBroadcastItem(v2_71)).onOutChangeStatus(com.jlboat.phone.controller.JlNaviManager.access$2100(this.this$0));
                    } catch (RuntimeException v4_41) {
                        android.util.Log.i(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("remoteE = ").append(v4_41.toString()).toString());
                    } catch (RuntimeException v4_41) {
                    }
                    v2_71++;
                }
                com.jlboat.phone.controller.JlNaviManager.access$1000().finishBroadcast();
                break;
            case 17:
                com.jlboat.phone.controller.JlNaviManager.access$1000();
                try {
                    Throwable v1_152 = com.jlboat.phone.controller.JlNaviManager.access$1000().beginBroadcast();
                    int v2_67 = 0;
                } catch (Throwable v1_154) {
                    throw v1_154;
                }
                while (v2_67 < v1_152) {
                    try {
                        ((com.boat.support.slam.ISlamCallBack) com.jlboat.phone.controller.JlNaviManager.access$1000().getBroadcastItem(v2_67)).onMachineSignal(com.jlboat.phone.controller.JlNaviManager.access$2200(this.this$0));
                    } catch (RuntimeException v4_38) {
                        android.util.Log.i(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("remoteE = ").append(v4_38.toString()).toString());
                    } catch (RuntimeException v4_38) {
                    }
                    v2_67++;
                }
                com.jlboat.phone.controller.JlNaviManager.access$1000().finishBroadcast();
                break;
            case 19:
                com.jlboat.phone.controller.JlNaviManager.access$1000();
                try {
                    Throwable v1_147 = com.jlboat.phone.controller.JlNaviManager.access$1000().beginBroadcast();
                    int v2_65 = 0;
                } catch (Throwable v1_149) {
                    throw v1_149;
                }
                while (v2_65 < v1_147) {
                    try {
                        ((com.boat.support.slam.ISlamCallBack) com.jlboat.phone.controller.JlNaviManager.access$1000().getBroadcastItem(v2_65)).onNaviGoalCallback(com.jlboat.phone.controller.JlNaviManager.access$1600(this.this$0).getFloorId(), com.jlboat.phone.controller.JlNaviManager.access$1600(this.this$0).getMapId(), com.jlboat.phone.controller.JlNaviManager.access$1600(this.this$0).getPointId());
                    } catch (RuntimeException v3_36) {
                        android.util.Log.i(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("remoteE = ").append(v3_36.toString()).toString());
                    } catch (RuntimeException v3_36) {
                    }
                    v2_65++;
                }
                com.jlboat.phone.controller.JlNaviManager.access$1000().finishBroadcast();
                break;
            case 22:
                android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), "handleMessage: NAVI_NETWORK ");
                com.jlboat.phone.controller.JlNaviManager.access$1000();
                try {
                    Throwable v1_144 = com.jlboat.phone.controller.JlNaviManager.access$1000().beginBroadcast();
                    int v2_63 = 0;
                } catch (Throwable v1_145) {
                    throw v1_145;
                }
                while (v2_63 < v1_144) {
                    String v5_21 = com.jlboat.phone.controller.JlNaviManager.access$1000().getBroadcastItem(v2_63);
                    try {
                        String v6_51;
                        if (com.jlboat.phone.controller.JlNaviManager.access$1700(this.this$0) != 22) {
                            v6_51 = 0;
                            ((com.boat.support.slam.ISlamCallBack) v5_21).onNaviNetWorkStatus(v6_51);
                        } else {
                            v6_51 = 1;
                        }
                        v2_63++;
                    } catch (String v6_52) {
                        android.util.Log.i(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("remoteE = ").append(v6_52.toString()).toString());
                    } catch (String v6_52) {
                    }
                }
                com.jlboat.phone.controller.JlNaviManager.access$1000().finishBroadcast();
                break;
            case 50:
                com.jlboat.phone.controller.JlNaviManager.access$1000();
                try {
                    Throwable v1_138 = com.jlboat.phone.controller.JlNaviManager.access$1000().beginBroadcast();
                    int v2_60 = 0;
                } catch (Throwable v1_140) {
                    throw v1_140;
                }
                while (v2_60 < v1_138) {
                    RuntimeException v4_33 = ((com.jlboat.phone.bean.ResponseString) p12.obj);
                    try {
                        ((com.boat.support.slam.ISlamCallBack) com.jlboat.phone.controller.JlNaviManager.access$1000().getBroadcastItem(v2_60)).onResponseString(v4_33.getType(), v4_33.getValue());
                    } catch (String v5_19) {
                        android.util.Log.i(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("remoteE = ").append(v5_19.toString()).toString());
                    } catch (String v5_19) {
                    }
                    v2_60++;
                }
                com.jlboat.phone.controller.JlNaviManager.access$1000().finishBroadcast();
                break;
            case 100:
                com.jlboat.phone.controller.JlNaviManager v0_174 = p12.getData();
                Throwable v1_133 = v0_174.getInt("code", 0);
                if (v1_133 != null) {
                    int v2_58 = v0_174.getString("data");
                    com.jlboat.phone.controller.JlNaviManager.access$1000();
                    try {
                        RuntimeException v4_30 = com.jlboat.phone.controller.JlNaviManager.access$1000().beginBroadcast();
                        String v5_16 = 0;
                    } catch (RuntimeException v4_31) {
                        throw v4_31;
                    }
                    while (v5_16 < v4_30) {
                        try {
                            ((com.boat.support.slam.ISlamCallBack) com.jlboat.phone.controller.JlNaviManager.access$1000().getBroadcastItem(v5_16)).onResponseDatas(v1_133, v2_58);
                        } catch (String v7_17) {
                            android.util.Log.i(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("remoteE = ").append(v7_17.toString()).toString());
                        } catch (String v7_17) {
                        }
                        v5_16++;
                    }
                    com.jlboat.phone.controller.JlNaviManager.access$1000().finishBroadcast();
                } else {
                }
                break;
            case 1000:
                if (this.this$0.isAllMapData) {
                    this.this$0.isAllMapData = 0;
                    com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessageDelayed(p12.what, 10000);
                    if (!this.this$0.isAllMapDataEnd) {
                    } else {
                        this.this$0.isAllMapDataEnd = 0;
                        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: all \u5f00\u59cb\u8bf7\u6c42\u5e95\u76d8\u6570\u636e ").append(p12.what).toString());
                        this.this$0.mapLisener.onStart();
                        this.this$0.tfPoseListener.onStart();
                        this.this$0.pathLayerLisener.onStart();
                    }
                } else {
                    android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: all \u5fc3\u8df3\u505c\u6b62\u5f3a\u5236\u65ad\u5f00\uff1a").append(p12.what).toString());
                    this.this$0.mapLisener.onStop();
                    this.this$0.tfPoseListener.onStop();
                    this.this$0.pathLayerLisener.onStop();
                    this.this$0.isAllMapDataEnd = 1;
                }
                break;
            case 1001:
                if (this.this$0.isMapData) {
                    this.this$0.isMapData = 0;
                    com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessageDelayed(p12.what, 10000);
                    if (!this.this$0.isMapDataEnd) {
                    } else {
                        this.this$0.isMapDataEnd = 0;
                        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: map \u5f00\u59cb\u8bf7\u6c42\u5e95\u76d8\u6570\u636e ").append(p12.what).toString());
                        this.this$0.mapLisener.onStart();
                    }
                } else {
                    android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: map \u5fc3\u8df3\u505c\u6b62\u5f3a\u5236\u65ad\u5f00\uff1a").append(p12.what).toString());
                    this.this$0.mapLisener.onStop();
                    this.this$0.isMapDataEnd = 1;
                }
                break;
            case 1002:
                if (this.this$0.isPose) {
                    this.this$0.isPose = 0;
                    com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessageDelayed(p12.what, 10000);
                    if (!this.this$0.isPoseEnd) {
                    } else {
                        this.this$0.isPoseEnd = 0;
                        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: tf \u5f00\u59cb\u8bf7\u6c42\u5e95\u76d8\u6570\u636e ").append(p12.what).toString());
                        this.this$0.tfPoseListener.onStart();
                    }
                } else {
                    android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: tf \u5fc3\u8df3\u505c\u6b62\u5f3a\u5236\u65ad\u5f00\uff1a").append(p12.what).toString());
                    this.this$0.tfPoseListener.onStop();
                    this.this$0.isPoseEnd = 1;
                }
                break;
            case 1003:
                break;
            case 1004:
                if (this.this$0.isGPlan) {
                    this.this$0.isGPlan = 0;
                    com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessageDelayed(p12.what, 10000);
                    if (!this.this$0.isGPlanEnd) {
                    } else {
                        this.this$0.isGPlanEnd = 0;
                        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: Gpath \u5f00\u59cb\u8bf7\u6c42\u5e95\u76d8\u6570\u636e ").append(p12.what).toString());
                        this.this$0.pathLayerLisener.onStart();
                    }
                } else {
                    android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: Gplan \u5fc3\u8df3\u505c\u6b62\u5f3a\u5236\u65ad\u5f00\uff1a").append(p12.what).toString());
                    this.this$0.pathLayerLisener.onStop();
                    this.this$0.isGPlanEnd = 1;
                }
                break;
            case 1011:
                if (this.this$0.isInit) {
                    this.this$0.isInit = 0;
                    com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessageDelayed(p12.what, 10000);
                    if (!this.this$0.isInitEnd) {
                    } else {
                        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: InitStatus \u5f00\u59cb\u8bf7\u6c42\u5e95\u76d8\u6570\u636e ").append(p12.what).toString());
                        this.this$0.isInitEnd = 0;
                        com.jlboat.phone.controller.JlNaviManager.access$2300(this.this$0);
                    }
                } else {
                    android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: InitStatus \u5fc3\u8df3\u505c\u6b62\u5f3a\u5236\u65ad\u5f00\uff1a").append(p12.what).toString());
                    this.this$0.isInitEnd = 1;
                }
                break;
            case 1012:
                if (this.this$0.isMapStatus) {
                    this.this$0.isMapStatus = 0;
                    com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessageDelayed(p12.what, 10000);
                    if (!this.this$0.isMapStatusEnd) {
                    } else {
                        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: MapStatus \u5f00\u59cb\u8bf7\u6c42\u5e95\u76d8\u6570\u636e ").append(p12.what).toString());
                        this.this$0.isMapStatusEnd = 0;
                        com.jlboat.phone.controller.JlNaviManager.access$2400(this.this$0);
                    }
                } else {
                    android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: MapStatus \u5fc3\u8df3\u505c\u6b62\u5f3a\u5236\u65ad\u5f00\uff1a").append(p12.what).toString());
                    this.this$0.isMapStatusEnd = 1;
                }
                break;
            case 1013:
                if (this.this$0.isMapUpdate) {
                    this.this$0.isMapUpdate = 0;
                    com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessageDelayed(p12.what, 10000);
                    if (!this.this$0.isMapUpdateEnd) {
                    } else {
                        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: mapUpdate \u5f00\u59cb\u8bf7\u6c42\u5e95\u76d8\u6570\u636e ").append(p12.what).toString());
                        this.this$0.isMapUpdateEnd = 0;
                        com.jlboat.phone.controller.JlNaviManager.access$2500(this.this$0);
                    }
                } else {
                    android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: mapUpdate \u5fc3\u8df3\u505c\u6b62\u5f3a\u5236\u65ad\u5f00\uff1a").append(p12.what).toString());
                    this.this$0.isMapUpdateEnd = 1;
                }
                break;
            case 1015:
                if (this.this$0.islocalPointUpdate) {
                    this.this$0.islocalPointUpdate = 0;
                    com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessageDelayed(p12.what, 10000);
                    if (!this.this$0.islocalPointUpdateEnd) {
                    } else {
                        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: localPoint \u5f00\u59cb\u8bf7\u6c42\u5e95\u76d8\u6570\u636e ").append(p12.what).toString());
                        this.this$0.islocalPointUpdateEnd = 0;
                        com.jlboat.phone.controller.JlNaviManager.access$2600(this.this$0);
                    }
                } else {
                    android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: localPoint \u5fc3\u8df3\u505c\u6b62\u5f3a\u5236\u65ad\u5f00\uff1a").append(p12.what).toString());
                    this.this$0.islocalPointUpdateEnd = 1;
                }
                break;
            case 1021:
                if (this.this$0.isNaviStatus) {
                    this.this$0.isNaviStatus = 0;
                    com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessageDelayed(p12.what, 10000);
                    if (!this.this$0.isNaviStatusUpdateEnd) {
                    } else {
                        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: NaviStatus \u5f00\u59cb\u8bf7\u6c42\u5e95\u76d8\u6570\u636e ").append(p12.what).toString());
                        this.this$0.isNaviStatusUpdateEnd = 0;
                    }
                } else {
                    android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: NaviStatus \u5fc3\u8df3\u505c\u6b62\u5f3a\u5236\u65ad\u5f00\uff1a").append(p12.what).toString());
                    this.this$0.isNaviStatusUpdateEnd = 1;
                }
                break;
            case 1022:
                if (this.this$0.isNaviToPoint) {
                    this.this$0.isNaviToPoint = 0;
                    com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessageDelayed(p12.what, 10000);
                    if (!this.this$0.isNaviToPointUpdateEnd) {
                    } else {
                        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: NaviToPoint \u5f00\u59cb\u8bf7\u6c42\u5e95\u76d8\u6570\u636e ").append(p12.what).toString());
                        this.this$0.isNaviToPointUpdateEnd = 0;
                    }
                } else {
                    android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: NaviToPoint \u5fc3\u8df3\u505c\u6b62\u5f3a\u5236\u65ad\u5f00\uff1a").append(p12.what).toString());
                    this.this$0.isNaviToPointUpdateEnd = 1;
                }
                break;
            case 1031:
                if (this.this$0.isPower) {
                    this.this$0.isPower = 0;
                    com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessageDelayed(p12.what, 10000);
                    if (!this.this$0.isPowerUpdateEnd) {
                    } else {
                        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: isPower \u5f00\u59cb\u8bf7\u6c42\u5e95\u76d8\u6570\u636e ").append(p12.what).toString());
                        this.this$0.isPowerUpdateEnd = 0;
                        com.jlboat.phone.controller.JlNaviManager.access$2700(this.this$0);
                    }
                } else {
                    android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("handleMessage: isPower \u5fc3\u8df3\u505c\u6b62\u5f3a\u5236\u65ad\u5f00\uff1a").append(p12.what).toString());
                    this.this$0.isPowerUpdateEnd = 1;
                }
                break;
            case 1032:
                com.jlboat.phone.controller.JlNaviManager.access$1000();
                try {
                    Throwable v1_11 = com.jlboat.phone.controller.JlNaviManager.access$1000().beginBroadcast();
                    int v2_13 = 0;
                } catch (Throwable v1_99) {
                    throw v1_99;
                }
                while (v2_13 < v1_11) {
                    try {
                        ((com.boat.support.slam.ISlamCallBack) com.jlboat.phone.controller.JlNaviManager.access$1000().getBroadcastItem(v2_13)).onSlamDownMapSucc();
                    } catch (RuntimeException v4_19) {
                        android.util.Log.i(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("onSlamDownMapSucc = ").append(v4_19.toString()).toString());
                    } catch (RuntimeException v4_19) {
                    }
                    v2_13++;
                }
                com.jlboat.phone.controller.JlNaviManager.access$1000().finishBroadcast();
                break;
            default:
        }
        return;
    }
}
