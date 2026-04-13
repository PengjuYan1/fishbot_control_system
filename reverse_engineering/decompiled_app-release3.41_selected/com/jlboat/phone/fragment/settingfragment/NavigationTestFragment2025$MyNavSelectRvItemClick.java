package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment2025$MyNavSelectRvItemClick implements com.jlboat.phone.adapter.TestPointSelectedListAdapter$OnItemClickListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 this$0;

    NavigationTestFragment2025$MyNavSelectRvItemClick(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onClick(int p3)
    {
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$600(this.this$0).remove(p3);
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$1800(this.this$0).sendEmptyMessage(101);
        return;
    }
}
