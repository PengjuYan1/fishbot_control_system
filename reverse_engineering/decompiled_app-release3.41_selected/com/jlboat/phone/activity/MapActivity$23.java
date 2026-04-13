package com.jlboat.phone.activity;
 class MapActivity$23 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;
    final synthetic android.app.AlertDialog val$alertDialog;
    final synthetic String[] val$bind_point;
    final synthetic com.boat.support.slam.entity.floors.Points val$frd;
    final synthetic com.boat.support.slam.entity.floors.Floors val$localDataFloor;
    final synthetic com.boat.support.slam.entity.floors.Maps val$localMap;
    final synthetic android.widget.EditText val$point_device_et;
    final synthetic android.widget.EditText val$point_ledWarn_et;
    final synthetic android.widget.EditText val$point_name_et;
    final synthetic android.widget.EditText val$region_type;
    final synthetic int[] val$selectIndex;

    MapActivity$23(com.jlboat.phone.activity.MapActivity p1, android.widget.EditText p2, android.widget.EditText p3, com.boat.support.slam.entity.floors.Maps p4, com.boat.support.slam.entity.floors.Points p5, int[] p6, String[] p7, android.widget.EditText p8, com.boat.support.slam.entity.floors.Floors p9, android.widget.EditText p10, android.app.AlertDialog p11)
    {
        this.this$0 = p1;
        this.val$point_name_et = p2;
        this.val$region_type = p3;
        this.val$localMap = p4;
        this.val$frd = p5;
        this.val$selectIndex = p6;
        this.val$bind_point = p7;
        this.val$point_ledWarn_et = p8;
        this.val$localDataFloor = p9;
        this.val$point_device_et = p10;
        this.val$alertDialog = p11;
        return;
    }

    public void onClick(android.view.View p32)
    {
        String v1_2 = this.val$point_name_et.getText().toString();
        String v2_0 = this.val$region_type.getText().toString();
        android.util.Log.d("MapActivity", new StringBuilder().append("onClick: \u8f93\u5165\u7684\u540d\u5b57 ").append(v1_2).toString());
        if (!v1_2.replace(" ", "").equals("")) {
            boolean v6_21 = this.val$localMap.getPoints().iterator();
            while (v6_21.hasNext()) {
                String v7_9 = ((com.boat.support.slam.entity.floors.Points) v6_21.next());
                if ((v1_2.equals(v7_9.getPointName())) && (this.val$frd.getPointId() != v7_9.getPointId())) {
                    this.this$0.toast(2131493287);
                    return;
                }
            }
            boolean v6_16 = 0;
            String v7_1 = 0;
            int v8_1 = 0;
            if (this.val$selectIndex[0] > 0) {
                android.widget.Toast v9_26 = this.val$selectIndex;
                String v11_3 = (v9_26[0] - 1);
                v9_26[0] = v11_3;
                android.widget.Toast v9_27 = v11_3;
                android.util.Log.d("MapActivity", new StringBuilder().append("selectedFloorIndex: ").append(v9_27).toString());
                if ((v9_27 >= null) && (v9_27 < com.jlboat.phone.activity.MapActivity.access$1400(this.this$0).size())) {
                    String v11_15 = ((com.boat.support.slam.entity.floors.Floors) com.jlboat.phone.activity.MapActivity.access$1400(this.this$0).get(v9_27));
                    android.util.Log.d("MapActivity", new StringBuilder().append("selectedFloor: ").append(v11_15).toString());
                    v6_16 = 1;
                    android.util.Log.d("MapActivity", new StringBuilder().append("isValidSelection: ").append(1).toString());
                    String v12_15 = com.jlboat.phone.activity.MapActivity.access$1400(this.this$0).iterator();
                    while (v12_15.hasNext()) {
                        java.util.Iterator v17_0;
                        String v13_1 = ((com.boat.support.slam.entity.floors.Floors) v12_15.next());
                        if (v13_1.getFloorId() != v11_15.getFloorId()) {
                            v17_0 = v6_16;
                        } else {
                            int v8_0 = 1;
                            android.util.Log.d("MapActivity", new StringBuilder().append("floorsexist: ").append(1).toString());
                            int v14_7 = v13_1.getMaps().iterator();
                            while (v14_7.hasNext()) {
                                com.boat.support.slam.entity.floors.Points v20_0;
                                com.boat.support.slam.entity.floors.Maps v15_3 = ((com.boat.support.slam.entity.floors.Maps) v14_7.next());
                                if (v13_1.getDefaultmap() != v15_3.getMapId()) {
                                    v17_0 = v6_16;
                                    v20_0 = v8_0;
                                } else {
                                    v17_0 = v6_16;
                                    android.util.Log.d("MapActivity", new StringBuilder().append("\u627e\u5230\u9ed8\u8ba4\u5730\u56fe: ").append(v15_3.getMapName()).toString());
                                    boolean v6_5 = v15_3.getPoints().iterator();
                                    while (v6_5.hasNext()) {
                                        int v10_5 = ((com.boat.support.slam.entity.floors.Points) v6_5.next());
                                        if (this.val$bind_point[0] != v10_5.getPointName()) {
                                        } else {
                                            android.util.Log.d("MapActivity", new StringBuilder().append("\u627e\u5230\u5339\u914d\u70b9\u4f4d: ").append(v10_5.getPointName()).toString());
                                            v20_0 = v8_0;
                                            this.val$frd.setBindPointId(v10_5.getPointId());
                                            this.val$frd.setBindMapId(v15_3.getMapId());
                                            this.val$frd.setBindFloorId(v13_1.getFloorId());
                                            v7_1 = 1;
                                        }
                                        if (v7_1 != null) {
                                            if (v7_1 == null) {
                                                v8_1 = v20_0;
                                            } else {
                                                v6_16 = v17_0;
                                                v8_1 = v20_0;
                                                if ((!v6_16) || (v7_1 == null)) {
                                                    android.util.Log.d("MapActivity", new StringBuilder().append("frd.getBindPointId(): ").append(this.val$frd.getBindPointId()).toString());
                                                    android.util.Log.d("MapActivity", new StringBuilder().append("frd.getBindMapId(): ").append(this.val$frd.getBindMapId()).toString());
                                                    android.util.Log.d("MapActivity", new StringBuilder().append("frd.getBindFloorId(): ").append(this.val$frd.getBindFloorId()).toString());
                                                    if ((v8_1 != 0) && (v7_1 == null)) {
                                                        android.util.Log.d("MapActivity", "\u7ed1\u5b9a\u4fe1\u606f\u7f3a\u5931");
                                                        android.widget.Toast.makeText(this.this$0, "\u7ed1\u5b9a\u5bfc\u822a\u70b9\u4fe1\u606f\u7f3a\u5931", 0).show();
                                                    }
                                                    this.val$frd.setBindPointId(0);
                                                    this.val$frd.setBindMapId(0);
                                                    this.val$frd.setBindFloorId(0);
                                                }
                                                android.widget.Toast v9_23 = this.val$point_ledWarn_et.getText().toString();
                                                int v10_17 = 0;
                                                String v11_1 = "";
                                                String v12_0 = "";
                                                String v13_2 = "";
                                                if ((v9_23 != null) && (!v9_23.isEmpty())) {
                                                    int v14_12 = com.jlboat.phone.activity.MapActivity.access$1200(this.this$0).getFloors().iterator();
                                                    while (v14_12.hasNext()) {
                                                        com.boat.support.slam.entity.floors.Maps v15_6 = ((com.boat.support.slam.entity.floors.Floors) v14_12.next());
                                                        java.util.Iterator v17_2 = v15_6.getMaps().iterator();
                                                        while (v17_2.hasNext()) {
                                                            boolean v21_1;
                                                            com.boat.support.slam.entity.floors.Points v18_5 = ((com.boat.support.slam.entity.floors.Maps) v17_2.next());
                                                            if (v15_6.getDefaultmap() != v18_5.getMapId()) {
                                                                v21_1 = v6_16;
                                                            } else {
                                                                String v19_3 = v18_5.getPoints().iterator();
                                                                while (v19_3.hasNext()) {
                                                                    com.boat.support.slam.entity.floors.Points v20_4 = ((com.boat.support.slam.entity.floors.Points) v19_3.next());
                                                                    boolean v21_2 = v6_16;
                                                                    if (!v9_23.equals(v20_4.getLedWarnID())) {
                                                                        v6_16 = v21_2;
                                                                    } else {
                                                                        if ((v15_6.getFloorId() != this.val$localDataFloor.getFloorId()) || ((v18_5.getMapId() != this.val$localMap.getMapId()) || (v20_4.getPointId() != this.val$frd.getPointId()))) {
                                                                            v10_17 = 1;
                                                                            v11_1 = v15_6.getFloorName();
                                                                            v12_0 = v18_5.getMapName();
                                                                            v13_2 = v20_4.getPointName();
                                                                            if (v10_17 == 0) {
                                                                                String v3_8 = this.val$point_device_et.getText().toString();
                                                                                if (("".equals(v3_8)) || (v3_8 == null)) {
                                                                                    this.val$frd.setDeviceType(0);
                                                                                }
                                                                                if (this.val$frd.getDeviceType() != 0) {
                                                                                    this.val$frd.setDeviceID(v3_8);
                                                                                } else {
                                                                                    this.val$frd.setDeviceID("");
                                                                                }
                                                                                this.val$frd.setLedWarnID(v9_23);
                                                                                android.util.Log.d("MapActivity", new StringBuilder().append("ledWarnName:").append(v9_23).toString());
                                                                                this.val$frd.setPointName(v1_2);
                                                                                this.val$frd.setCargoRegionType(v2_0);
                                                                                android.util.Log.d("MapActivity", new StringBuilder().append("frg:").append(this.val$frd).toString());
                                                                                com.jlboat.phone.activity.MapActivity.access$4000(this.this$0, 0, this.val$localDataFloor.getFloorId(), this.val$localMap.getMapId(), this.val$frd.getPointId(), this.val$frd);
                                                                                this.val$alertDialog.cancel();
                                                                                return;
                                                                            } else {
                                                                                this.this$0.toast(new StringBuilder().append(this.this$0.getResString(2131493285)).append("\n").append(v11_1).append(" ").append(v12_0).append(" ").append(v13_2).toString());
                                                                                return;
                                                                            }
                                                                        } else {
                                                                            v6_16 = v21_2;
                                                                        }
                                                                    }
                                                                }
                                                                v21_1 = v6_16;
                                                            }
                                                            v6_16 = v21_1;
                                                        }
                                                    }
                                                }
                                            }
                                            v6_16 = v17_0;
                                        }
                                    }
                                    v20_0 = v8_0;
                                }
                                v6_16 = v17_0;
                                v8_0 = v20_0;
                            }
                            v17_0 = v6_16;
                            v20_0 = v8_0;
                        }
                    }
                }
            }
        } else {
            this.this$0.toast(this.this$0.getResString(2131493286));
            return;
        }
    }
}
