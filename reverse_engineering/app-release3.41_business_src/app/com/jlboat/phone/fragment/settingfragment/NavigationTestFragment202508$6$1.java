package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment202508$6$1 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508$6 this$1;
    final synthetic com.jlboat.phone.message.map_msgs.Config val$config;

    NavigationTestFragment202508$6$1(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508$6 p1, com.jlboat.phone.message.map_msgs.Config p2)
    {
        this.this$1 = p1;
        this.val$config = p2;
        return;
    }

    public void run()
    {
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$2200(this.this$1.this$0).setText(this.val$config.getConfigValue());
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$902(this.this$1.this$0, this.val$config.getConfigValue().replace("\'", ""));
        return;
    }
}
