package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment2025$5 implements android.widget.AdapterView$OnItemSelectedListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 this$0;

    NavigationTestFragment2025$5(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onItemSelected(android.widget.AdapterView p7, android.view.View p8, int p9, long p10)
    {
        com.boat.support.slam.entity.floors.MapInfo v1_1 = ((com.boat.support.slam.entity.floors.MapInfo) com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$1300(this.this$0).get(((String) com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$1200(this.this$0).get(p9))));
        if (v1_1 != null) {
            com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$002(this.this$0, v1_1.getMapName());
            com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$1402(this.this$0, v1_1.getMapId());
            com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$1502(this.this$0, v1_1.getFloorId());
            com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$202(this.this$0, v1_1.getPoints());
            com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$1602(this.this$0, ((com.boat.support.slam.entity.floors.Floors) com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$1700(this.this$0).get(Long.valueOf(v1_1.getFloorId()))).getMaps());
            com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$1800(this.this$0).sendEmptyMessage(101);
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
