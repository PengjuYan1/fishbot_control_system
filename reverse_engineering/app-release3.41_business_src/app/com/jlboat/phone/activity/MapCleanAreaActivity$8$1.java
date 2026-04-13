package com.jlboat.phone.activity;
 class MapCleanAreaActivity$8$1 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.MapCleanAreaActivity$8 this$1;

    MapCleanAreaActivity$8$1(com.jlboat.phone.activity.MapCleanAreaActivity$8 p1)
    {
        this.this$1 = p1;
        return;
    }

    public void run()
    {
        this.this$1.this$0.bt_start_clean_area.setVisibility(8);
        this.this$1.this$0.cleanAreaRvAdapter.setListData(new java.util.LinkedList());
        return;
    }
}
