package com.jlboat.phone.fragment.settingfragment;
 class NavigationQueueFragment$6 implements android.widget.AdapterView$OnItemSelectedListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment this$0;

    NavigationQueueFragment$6(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onItemSelected(android.widget.AdapterView p7, android.view.View p8, int p9, long p10)
    {
        String v0_3 = ((String) com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$1200(this.this$0).get(p9));
        com.boat.support.slam.entity.floors.MapInfo v1_1 = ((com.boat.support.slam.entity.floors.MapInfo) com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$1300(this.this$0).get(v0_3));
        if (v1_1 != null) {
            com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$1402(this.this$0, v0_3);
            com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$002(this.this$0, v1_1.getMapName());
            com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$1502(this.this$0, v1_1.getMapId());
            com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$1602(this.this$0, v1_1.getFloorId());
            com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$202(this.this$0, v1_1.getPoints());
            com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$1702(this.this$0, ((com.boat.support.slam.entity.floors.Floors) com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$1800(this.this$0).get(Long.valueOf(v1_1.getFloorId()))).getMaps());
            com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$1900(this.this$0).sendEmptyMessage(101);
            return;
        } else {
            return;
        }
    }

    public void onNothingSelected(android.widget.AdapterView p1)
    {
        return;
    }
}
