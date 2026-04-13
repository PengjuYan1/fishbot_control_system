package com.jlboat.phone.activity;
 class MapEditChargeActivity$1 implements com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter$OnItemClickListener {
    final synthetic com.jlboat.phone.activity.MapEditChargeActivity this$0;

    MapEditChargeActivity$1(com.jlboat.phone.activity.MapEditChargeActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onClick(int p2)
    {
        this.this$0.selectedPointList.remove(p2);
        com.jlboat.phone.activity.MapEditChargeActivity.access$000(this.this$0);
        return;
    }
}
