package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment2025$6 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 this$0;

    NavigationTestFragment2025$6(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.NaviTestResultEntrys) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.NaviTestResultEntrys p5)
    {
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$1900(this.this$0).unsubscribe();
        if ((p5.getTestresults() != null) && (p5.getTestresults().size() >= 1)) {
            com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 v0_5 = ((com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025) com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$2000(this.this$0).get());
            if ((v0_5 != null) && (v0_5.getActivity() != null)) {
                android.support.v4.app.FragmentActivity v1_2 = v0_5.getActivity();
                v1_2.startActivity(new android.content.Intent(v1_2, com.jlboat.phone.activity.TestResultActivity));
                return;
            } else {
                android.util.Log.w(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$2100(this.this$0), "Fragment or Activity is null, cannot start Activity");
                return;
            }
        } else {
            return;
        }
    }
}
