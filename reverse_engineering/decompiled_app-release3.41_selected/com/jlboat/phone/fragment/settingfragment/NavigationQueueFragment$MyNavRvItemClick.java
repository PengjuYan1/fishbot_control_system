package com.jlboat.phone.fragment.settingfragment;
 class NavigationQueueFragment$MyNavRvItemClick implements com.jlboat.phone.adapter.TestPointListAdapter$OnItemClickListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment this$0;

    NavigationQueueFragment$MyNavRvItemClick(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onClick(int p6)
    {
        com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$2002(this.this$0, 0);
        com.boat.support.slam.entity.floors.SelectedTestPoint v1_1 = new com.boat.support.slam.entity.floors.SelectedTestPoint(((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$200(this.this$0).get(p6)), Long.valueOf(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$1600(this.this$0)), Long.valueOf(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$1500(this.this$0)));
        if (!com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$2100(this.this$0).contains(v1_1)) {
            if (com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$2100(this.this$0).size() < 2) {
                com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$2100(this.this$0).add(v1_1);
            } else {
                com.jlboat.phone.util.Utils.toast("\u6700\u591a\u9009\u62e92\u4e2a\u70b9\u4f4d");
                return;
            }
        } else {
            com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$2100(this.this$0).remove(v1_1);
            android.util.Log.d(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$500(this.this$0), new StringBuilder().append("\u53d6\u6d88\u9009\u4e2d\u70b9\u4f4d:").append(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$300(this.this$0)).toString());
        }
        com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$302(this.this$0, ((java.util.List) com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$2100(this.this$0).stream().map(new com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment$MyNavRvItemClick$$ExternalSyntheticLambda0()).collect(java.util.stream.Collectors.toList())));
        com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$1900(this.this$0).sendEmptyMessage(101);
        android.util.Log.d(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$500(this.this$0), new StringBuilder().append("selectedPointList:").append(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$300(this.this$0)).toString());
        return;
    }
}
