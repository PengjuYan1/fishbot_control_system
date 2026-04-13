package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment202508$5 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508 this$0;

    NavigationTestFragment202508$5(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508 p1)
    {
        this.this$0 = p1;
        return;
    }

    synthetic void lambda$onNewMessage$0$com-jlboat-phone-fragment-settingfragment-NavigationTestFragment202508$5()
    {
        if (com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$2000(this.this$0) != null) {
            com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$2000(this.this$0).subscribe(this);
        }
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.TargetGoalEntryRunList) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.TargetGoalEntryRunList p11)
    {
        int v5_3;
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$2000(this.this$0).unsubscribe();
        com.jlboat.phone.message.map_msgs.TargetGoalEntry[] v2 = p11.getOperated_goal_list();
        com.jlboat.phone.message.map_msgs.TargetGoalEntry[] v3 = p11.getHigh_goal_list();
        com.jlboat.phone.message.map_msgs.TargetGoalEntry[] v4 = p11.getLow_goal_list();
        if (((v2 != null) && (v2.length != 0)) || (((v3 != null) && (v3.length != 0)) || ((v4 != null) && (v4.length != 0)))) {
            v5_3 = 0;
        } else {
            v5_3 = 1;
        }
        if (v5_3 == 0) {
            this.this$0.requireActivity().startActivity(new android.content.Intent(this.this$0.requireActivity(), com.jlboat.phone.activity.TestResultActivity202508));
            return;
        } else {
            android.util.Log.e(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$2100(this.this$0), "All goal lists are null or empty");
            if (0 >= 3) {
                if (com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$2000(this.this$0) != null) {
                    com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508.access$2000(this.this$0).unsubscribe();
                }
                com.jlboat.phone.util.Utils.toast("\u672a\u83b7\u53d6\u5230\u6709\u6548\u6d4b\u8bd5\u6570\u636e\uff0c\u8bf7\u91cd\u8bd5");
            } else {
                new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment202508$5$$ExternalSyntheticLambda0(this), 100);
            }
            return;
        }
    }
}
