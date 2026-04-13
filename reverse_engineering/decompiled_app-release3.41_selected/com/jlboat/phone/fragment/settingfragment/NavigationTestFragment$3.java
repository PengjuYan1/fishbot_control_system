package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment$3 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment this$0;

    NavigationTestFragment$3(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SetNaviTestResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SetNaviTestResponse p1)
    {
        return;
    }
}
