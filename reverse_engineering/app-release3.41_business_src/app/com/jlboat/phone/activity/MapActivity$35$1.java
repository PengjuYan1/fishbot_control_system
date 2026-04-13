package com.jlboat.phone.activity;
 class MapActivity$35$1 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.MapActivity$35 this$1;

    MapActivity$35$1(com.jlboat.phone.activity.MapActivity$35 p1)
    {
        this.this$1 = p1;
        return;
    }

    public void run()
    {
        this.this$1.val$testPointListAdapter.setData(this.this$1.val$mapPointList, this.this$1.val$selectedPointList);
        this.this$1.val$testPointSelectedListAdapter.setData(this.this$1.val$selectedPointList);
        if (this.this$1.val$selectedPointList.size() <= 0) {
            this.this$1.val$navNopointTipLl.setVisibility(0);
            this.this$1.val$navSelectedPointRv.setVisibility(8);
        } else {
            this.this$1.val$navSelectedPointRv.setVisibility(0);
            this.this$1.val$navNopointTipLl.setVisibility(8);
        }
        return;
    }
}
