package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment202508$6 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508 this$0;

    NavigationTestFragment202508$6(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508 p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.GetConfigsResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.GetConfigsResponse p6)
    {
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$1000(this.this$0).clear();
        android.util.Log.e(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$2100(this.this$0), new StringBuilder().append("getconfig:").append(p6.getConfigs().toString()).toString());
        java.util.Iterator v0_3 = p6.getConfigs().iterator();
        while (v0_3.hasNext()) {
            com.jlboat.phone.message.map_msgs.Config v1_5 = ((com.jlboat.phone.message.map_msgs.Config) v0_3.next());
            if (v1_5.getConfigName().equals("task_executing_wait_time")) {
                android.util.Log.e(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$2100(this.this$0), new StringBuilder().append("config:").append(v1_5.toString()).toString());
                com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$1000(this.this$0).add(v1_5);
                com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$2300(this.this$0).post(new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508$6$1(this, v1_5));
            }
        }
        return;
    }
}
