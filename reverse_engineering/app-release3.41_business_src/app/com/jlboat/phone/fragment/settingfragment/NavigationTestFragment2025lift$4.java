package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment2025lift$4 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025lift this$0;

    NavigationTestFragment2025lift$4(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025lift p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.NaviQueueList) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.NaviQueueList p4)
    {
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025lift.access$702(this.this$0, p4);
        android.util.Log.d(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025lift.access$500(this.this$0), new StringBuilder().append("naviQueueListEntry:").append(p4).toString());
        android.util.Log.d(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025lift.access$500(this.this$0), new StringBuilder().append("naviQueueListEntry:").append(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025lift.access$700(this.this$0)).toString());
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025lift.access$900(this.this$0);
        return;
    }
}
