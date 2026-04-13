package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment202508$MyNavSelectRvItemClick implements com.jlboat.phone.adapter.TestPointSelectedListAdapter$OnItemClickListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508 this$0;

    NavigationTestFragment202508$MyNavSelectRvItemClick(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508 p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onClick(int p4)
    {
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$600(this.this$0).remove(p4);
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$302(this.this$0, ((java.util.List) com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$600(this.this$0).stream().map(new com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment$MyNavRvItemClick$$ExternalSyntheticLambda0()).collect(java.util.stream.Collectors.toList())));
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$1900(this.this$0).sendEmptyMessage(101);
        return;
    }
}
