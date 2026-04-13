package com.jlboat.phone.activity;
 class MapEditRegionActivity$4 implements com.jlboat.phone.adapter.RegionListAdapter$OnLongClick {
    final synthetic com.jlboat.phone.activity.MapEditRegionActivity this$0;

    MapEditRegionActivity$4(com.jlboat.phone.activity.MapEditRegionActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void longclick(com.boat.support.slam.entity.floors.Region p16, int p17)
    {
        android.app.AlertDialog$Builder v1_1 = new android.app.AlertDialog$Builder(this.this$0);
        String v2_0 = this.this$0.getResources().getString(2131493139);
        if (p16.getType() == 1) {
            v2_0 = this.this$0.getResources().getString(2131493034);
        }
        if (p16.getType() == 2) {
            v2_0 = this.this$0.getResources().getString(2131493086);
        }
        if (p16.getType() == 3) {
            v2_0 = this.this$0.getResources().getString(2131493184);
        }
        if (p16.getType() == 4) {
            v2_0 = this.this$0.getResources().getString(2131492907);
        }
        if (p16.getType() == 5) {
            v2_0 = this.this$0.getResources().getString(2131493041);
        }
        if (p16.getType() == 6) {
            v2_0 = this.this$0.getResources().getString(2131492909);
        }
        String v4_5 = this.this$0.getResources().getString(2131493139);
        String v5_3 = this.this$0.getResources().getString(2131493139);
        String v6_0 = this.this$0.getResources().getString(2131493139);
        String v7_0 = this.this$0.getResources().getString(2131493139);
        String v3_0 = this.this$0.getResources().getString(2131493139);
        if (p16.getRegionProperty1() != 0) {
            v7_0 = new StringBuilder().append(p16.getRegionProperty1()).append("").toString();
        }
        if (p16.getRegionProperty2() != 0) {
            v3_0 = new StringBuilder().append(p16.getRegionProperty2()).append("").toString();
        }
        com.jlboat.phone.activity.MapEditRegionActivity$4$2 v8_10 = com.jlboat.phone.activity.MapEditRegionActivity.access$500(this.this$0).iterator();
        while (v8_10.hasNext()) {
            com.boat.support.slam.entity.floors.Region v9_6 = ((com.boat.support.slam.entity.floors.Points) v8_10.next());
            if (p16.getStartPointId() == v9_6.getPointId()) {
                v4_5 = v9_6.getPointName();
            }
            if (p16.getEndPointId() == v9_6.getPointId()) {
                v5_3 = v9_6.getPointName();
            }
            if (p16.getWaitPointId() == v9_6.getPointId()) {
                v6_0 = v9_6.getPointName();
            }
        }
        v1_1.setTitle(new StringBuilder().append(this.this$0.getResString(2131493029)).append(" ").append(p17).append(" ").append(v2_0).append(" ?\n").toString());
        v1_1.setMessage(new StringBuilder().append(this.this$0.getResString(2131493197)).append(" ").append(v4_5).append("   ").append(this.this$0.getResString(2131493036)).append(" ").append(v5_3).append("   ").append(this.this$0.getResString(2131493397)).append(" ").append(v6_0).append(" \n").append(this.this$0.getResString(2131493073)).append(" ").append(v7_0).append("   ").append(this.this$0.getResString(2131493074)).append(" ").append(v3_0).append("   ").toString());
        v1_1.setPositiveButton(2131493023, new com.jlboat.phone.activity.MapEditRegionActivity$4$1(this, p16));
        v1_1.setNegativeButton(2131493007, new com.jlboat.phone.activity.MapEditRegionActivity$4$2(this));
        v1_1.show();
        return;
    }
}
