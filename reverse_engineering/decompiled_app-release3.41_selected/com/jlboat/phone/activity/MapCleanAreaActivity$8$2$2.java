package com.jlboat.phone.activity;
 class MapCleanAreaActivity$8$2$2 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.MapCleanAreaActivity$8$2 this$2;
    final synthetic com.boat.support.slam.entity.floors.Maps val$maps;

    MapCleanAreaActivity$8$2$2(com.jlboat.phone.activity.MapCleanAreaActivity$8$2 p1, com.boat.support.slam.entity.floors.Maps p2)
    {
        this.this$2 = p1;
        this.val$maps = p2;
        return;
    }

    public void run()
    {
        this.this$2.this$1.this$0.cleanAreaRvAdapter.setListData(this.val$maps.getCleanAreas());
        return;
    }
}
