package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment202508$MyNavRvItemClick implements com.jlboat.phone.adapter.TestPointListAdapter$OnItemClickListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508 this$0;

    NavigationTestFragment202508$MyNavRvItemClick(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508 p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onClick(int p6)
    {
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$300(this.this$0).clear();
        com.boat.support.slam.entity.floors.SelectedTestPoint v1_1 = new com.boat.support.slam.entity.floors.SelectedTestPoint(((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$200(this.this$0).get(p6)), Long.valueOf(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$1600(this.this$0)), Long.valueOf(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$1500(this.this$0)));
        if (!com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$600(this.this$0).contains(v1_1)) {
            com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$600(this.this$0).add(v1_1);
        } else {
            com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$600(this.this$0).remove(v1_1);
        }
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$302(this.this$0, ((java.util.List) com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$600(this.this$0).stream().map(new com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment$MyNavRvItemClick$$ExternalSyntheticLambda0()).collect(java.util.stream.Collectors.toList())));
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$1900(this.this$0).sendEmptyMessage(101);
        return;
    }
}
