package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment$6 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment this$0;

    NavigationTestFragment$6(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.GetConfigsResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.GetConfigsResponse p5)
    {
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$800(this.this$0).clear();
        java.util.Iterator v0_3 = p5.getConfigs().iterator();
        while (v0_3.hasNext()) {
            com.jlboat.phone.message.map_msgs.Config v1_1 = ((com.jlboat.phone.message.map_msgs.Config) v0_3.next());
            if (v1_1.getConfigName().equals("naviTestSleep")) {
                com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$800(this.this$0).add(v1_1);
                com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$1400(this.this$0).post(new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment$6$1(this, v1_1));
            }
        }
        return;
    }
}
