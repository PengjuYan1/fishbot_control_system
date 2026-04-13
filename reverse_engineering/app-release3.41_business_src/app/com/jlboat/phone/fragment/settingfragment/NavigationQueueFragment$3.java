package com.jlboat.phone.fragment.settingfragment;
 class NavigationQueueFragment$3 implements com.jlboat.phone.adapter.LiftQueueAdapter$OnItemDeleteListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment this$0;

    NavigationQueueFragment$3(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onItemDelete(int p6)
    {
        if ((com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$700(this.this$0) != null) && (com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$700(this.this$0).getNaviQueueListEntrys() != null)) {
            java.util.ArrayList v1_1 = new java.util.ArrayList(java.util.Arrays.asList(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$700(this.this$0).getNaviQueueListEntrys()));
            if (p6 < v1_1.size()) {
                v1_1.remove(p6);
                String v3_1 = new com.jlboat.phone.message.map_msgs.NaviQueueListEntry[0];
                com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$700(this.this$0).setNaviQueueListEntrys(((com.jlboat.phone.message.map_msgs.NaviQueueListEntry[]) v1_1.toArray(v3_1)));
                this.this$0.int32.setData(p6);
                com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$800(this.this$0).publish(this.this$0.int32);
                android.util.Log.e(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$500(this.this$0), new StringBuilder().append("int32:").append(this.this$0.int32.getData()).toString());
                android.util.Log.e(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$500(this.this$0), "\u5220\u9664\u6210\u529f");
                com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$900(this.this$0);
            }
        }
        return;
    }
}
