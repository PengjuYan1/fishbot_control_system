package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment$MyNavSelectRvItemClick implements com.jlboat.phone.adapter.TestPointSelectedListAdapter$OnItemClickListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment this$0;

    NavigationTestFragment$MyNavSelectRvItemClick(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onClick(int p3)
    {
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$300(this.this$0).remove(p3);
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$1100(this.this$0).sendEmptyMessage(101);
        return;
    }
}
