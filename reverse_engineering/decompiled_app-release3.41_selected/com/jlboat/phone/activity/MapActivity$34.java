package com.jlboat.phone.activity;
 class MapActivity$34 implements com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter$OnItemClickListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;
    final synthetic java.util.List val$mapPointList;
    final synthetic android.widget.LinearLayout val$navNopointTipLl;
    final synthetic android.support.v7.widget.RecyclerView val$navSelectedPointRv;
    final synthetic java.util.List val$selectedPointList;
    final synthetic com.jlboat.phone.adapter.MapActDlFloorListAdapter val$testPointListAdapter;
    final synthetic com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter val$testPointSelectedListAdapter;

    MapActivity$34(com.jlboat.phone.activity.MapActivity p1, java.util.List p2, com.jlboat.phone.adapter.MapActDlFloorListAdapter p3, java.util.List p4, com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter p5, android.support.v7.widget.RecyclerView p6, android.widget.LinearLayout p7)
    {
        this.this$0 = p1;
        this.val$selectedPointList = p2;
        this.val$testPointListAdapter = p3;
        this.val$mapPointList = p4;
        this.val$testPointSelectedListAdapter = p5;
        this.val$navSelectedPointRv = p6;
        this.val$navNopointTipLl = p7;
        return;
    }

    public void onClick(int p3)
    {
        this.val$selectedPointList.remove(p3);
        this.this$0.runOnUiThread(new com.jlboat.phone.activity.MapActivity$34$1(this));
        return;
    }
}
