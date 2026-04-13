package com.jlboat.phone.adapter;
 class RegionListAdapter$2 implements android.view.View$OnLongClickListener {
    final synthetic com.jlboat.phone.adapter.RegionListAdapter this$0;
    final synthetic int val$oederNum;
    final synthetic int val$position;

    RegionListAdapter$2(com.jlboat.phone.adapter.RegionListAdapter p1, int p2, int p3)
    {
        this.this$0 = p1;
        this.val$position = p2;
        this.val$oederNum = p3;
        return;
    }

    public boolean onLongClick(android.view.View p4)
    {
        com.jlboat.phone.adapter.RegionListAdapter.access$300(this.this$0).longclick(((com.boat.support.slam.entity.floors.Region) com.jlboat.phone.adapter.RegionListAdapter.access$200(this.this$0).get(this.val$position)), this.val$oederNum);
        return 0;
    }
}
