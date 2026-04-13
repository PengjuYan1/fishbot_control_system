package com.jlboat.phone.fragment.settingfragment;
 class NavigationQueueFragment$4 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment this$0;

    NavigationQueueFragment$4(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.TargetGoalEntryRunList) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.TargetGoalEntryRunList p5)
    {
        new com.jlboat.phone.message.map_msgs.TargetGoalEntryRunList();
        android.util.Log.d(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$500(this.this$0), new StringBuilder().append("TargetGoalEntryRunList:").append(p5).toString());
        android.util.Log.d(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$500(this.this$0), new StringBuilder().append("TargetGoalEntry:").append(this.this$0.targetGoalEntries).toString());
        com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$900(this.this$0);
        return;
    }
}
