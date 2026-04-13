package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment$MyNavRvItemClick implements com.jlboat.phone.adapter.TestPointListAdapter$OnItemClickListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment this$0;

    NavigationTestFragment$MyNavRvItemClick(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onClick(int p4)
    {
        com.boat.support.slam.entity.floors.Points v0_3 = ((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$200(this.this$0).get(p4));
        if (!com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$300(this.this$0).contains(v0_3)) {
            com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$300(this.this$0).add(v0_3);
        } else {
            com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$300(this.this$0).remove(v0_3);
        }
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$1100(this.this$0).sendEmptyMessage(101);
        return;
    }
}
