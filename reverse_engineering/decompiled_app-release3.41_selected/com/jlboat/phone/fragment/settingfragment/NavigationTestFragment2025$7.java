package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment2025$7 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 this$0;

    NavigationTestFragment2025$7(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
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
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$900(this.this$0).clear();
        java.util.Iterator v0_3 = p5.getConfigs().iterator();
        while (v0_3.hasNext()) {
            com.jlboat.phone.message.map_msgs.Config v1_1 = ((com.jlboat.phone.message.map_msgs.Config) v0_3.next());
            if (v1_1.getConfigName().equals("naviTestSleep")) {
                com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$900(this.this$0).add(v1_1);
                com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$2300(this.this$0).post(new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025$7$1(this, v1_1));
            }
        }
        return;
    }
}
