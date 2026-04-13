package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment$5 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment this$0;

    NavigationTestFragment$5(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.NaviTestResultEntrys) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.NaviTestResultEntrys p4)
    {
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$1200(this.this$0).unsubscribe();
        if ((p4.getTestresults() != null) && (p4.getTestresults().size() >= 1)) {
            this.this$0.startActivity(new android.content.Intent(this.this$0.getActivity(), com.jlboat.phone.activity.TestResultActivity));
            return;
        } else {
            return;
        }
    }
}
