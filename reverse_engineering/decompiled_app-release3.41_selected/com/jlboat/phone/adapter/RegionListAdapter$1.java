package com.jlboat.phone.adapter;
 class RegionListAdapter$1 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.adapter.RegionListAdapter this$0;
    final synthetic int val$oederNum;
    final synthetic int val$position;

    RegionListAdapter$1(com.jlboat.phone.adapter.RegionListAdapter p1, int p2, int p3)
    {
        this.this$0 = p1;
        this.val$position = p2;
        this.val$oederNum = p3;
        return;
    }

    public void onClick(android.view.View p4)
    {
        if (com.jlboat.phone.adapter.RegionListAdapter.access$100(this.this$0) != null) {
            com.jlboat.phone.adapter.RegionListAdapter.access$100(this.this$0).click(((com.boat.support.slam.entity.floors.Region) com.jlboat.phone.adapter.RegionListAdapter.access$200(this.this$0).get(this.val$position)), this.val$oederNum);
        }
        return;
    }
}
