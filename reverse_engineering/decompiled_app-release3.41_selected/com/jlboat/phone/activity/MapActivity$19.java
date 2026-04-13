package com.jlboat.phone.activity;
 class MapActivity$19 implements android.widget.AdapterView$OnItemSelectedListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;
    final synthetic android.widget.ArrayAdapter val$adapter2;
    final synthetic String[] val$bind_floors;
    final synthetic String val$chargePoint;
    final synthetic android.widget.Spinner val$floors_bind;
    final synthetic com.boat.support.slam.entity.floors.Points val$frd;
    final synthetic com.boat.support.slam.entity.floors.Floors val$localDataFloor;
    final synthetic com.boat.support.slam.entity.floors.Maps val$localMap;
    final synthetic String val$pointLocation;
    final synthetic android.widget.Spinner val$point_bind;
    final synthetic int[] val$selectIndex;
    final synthetic String val$startPoint;

    MapActivity$19(com.jlboat.phone.activity.MapActivity p1, int[] p2, String[] p3, android.widget.Spinner p4, android.widget.ArrayAdapter p5, String p6, String p7, String p8, com.boat.support.slam.entity.floors.Points p9, com.boat.support.slam.entity.floors.Floors p10, com.boat.support.slam.entity.floors.Maps p11, android.widget.Spinner p12)
    {
        this.this$0 = p1;
        this.val$selectIndex = p2;
        this.val$bind_floors = p3;
        this.val$floors_bind = p4;
        this.val$adapter2 = p5;
        this.val$chargePoint = p6;
        this.val$startPoint = p7;
        this.val$pointLocation = p8;
        this.val$frd = p9;
        this.val$localDataFloor = p10;
        this.val$localMap = p11;
        this.val$point_bind = p12;
        return;
    }

    public void onItemSelected(android.widget.AdapterView p15, android.view.View p16, int p17, long p18)
    {
        android.util.Log.d("MapActivity", new StringBuilder().append("\u697c\u5c42\u9009\u4e2d: ").append(p17).toString());
        this.val$selectIndex[0] = p17;
        this.val$bind_floors[0] = this.val$floors_bind.getSelectedItem().toString();
        this.val$adapter2.clear();
        this.val$adapter2.add("\u5bfc\u822a\u70b9");
        com.boat.support.slam.entity.floors.Floors v2_6 = 0;
        java.util.ArrayList v4_6 = com.jlboat.phone.activity.MapActivity.access$1400(this.this$0).iterator();
        while (v4_6.hasNext()) {
            int v5_3 = ((com.boat.support.slam.entity.floors.Floors) v4_6.next());
            if (v5_3.getFloorName().equals(this.val$bind_floors[0])) {
                v2_6 = v5_3;
                break;
            }
        }
        if (v2_6 != null) {
            com.boat.support.slam.entity.floors.Maps v3_3 = 0;
            java.util.ArrayList v4_8 = v2_6.getMaps().iterator();
            while (v4_8.hasNext()) {
                int v5_6 = ((com.boat.support.slam.entity.floors.Maps) v4_8.next());
                if (v5_6.getMapId() == v2_6.getDefaultmap()) {
                    v3_3 = v5_6;
                    break;
                }
            }
            if (v3_3 != null) {
                java.util.ArrayList v4_10 = new java.util.ArrayList();
                int v5_0 = -1;
                android.widget.Spinner v6_4 = v3_3.getPoints().iterator();
                while (v6_4.hasNext()) {
                    int v7_5 = ((com.boat.support.slam.entity.floors.Points) v6_4.next());
                    String v8_1 = v7_5.getPointName();
                    if ((!this.val$chargePoint.equals(v8_1)) && ((!this.val$startPoint.equals(v8_1)) && ((!this.val$pointLocation.equals(v8_1)) && ((this.val$frd.getPointId() != v7_5.getPointId()) || ((this.val$localDataFloor.getFloorId() != v2_6.getFloorId()) || (this.val$localMap.getMapId() != v3_3.getMapId())))))) {
                        v4_10.add(v8_1);
                        if ((this.val$frd.getBindPointId() != 0) && (v7_5.getPointId() == this.val$frd.getBindPointId())) {
                            v5_0 = (v4_10.size() - 1);
                        }
                    }
                }
                this.val$adapter2.addAll(v4_10);
                if (v5_0 >= 0) {
                    this.val$point_bind.setSelection((v5_0 + 1));
                }
                return;
            } else {
                return;
            }
        } else {
            return;
        }
    }

    public void onNothingSelected(android.widget.AdapterView p3)
    {
        android.util.Log.d("MapActivity", "floors_bind onItemClick: noth");
        return;
    }
}
