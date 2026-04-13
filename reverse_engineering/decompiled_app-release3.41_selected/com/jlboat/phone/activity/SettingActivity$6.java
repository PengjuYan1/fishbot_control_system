package com.jlboat.phone.activity;
 class SettingActivity$6 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.SettingActivity this$0;

    SettingActivity$6(com.jlboat.phone.activity.SettingActivity p1)
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
        com.jlboat.phone.activity.SettingActivity.access$100(this.this$0).clear();
        java.util.Iterator v0_3 = p6.getConfigs().iterator();
        while (v0_3.hasNext()) {
            com.jlboat.phone.message.map_msgs.Config v1_1 = ((com.jlboat.phone.message.map_msgs.Config) v0_3.next());
            if (!v1_1.getConfigName().equals("startAutoupgrade")) {
                if (!v1_1.getConfigName().equals("powerThreashold")) {
                    if (v1_1.getConfigName().equals("powerThreasholdMax")) {
                        android.util.Log.d(com.jlboat.phone.activity.SettingActivity.access$000(this.this$0), new StringBuilder().append("powerThreasholdMax: aaa ").append(v1_1.getConfigName()).toString());
                        com.jlboat.phone.activity.SettingActivity.access$100(this.this$0).add(v1_1);
                        com.jlboat.phone.activity.SettingActivity.access$400(this.this$0).post(new com.jlboat.phone.activity.SettingActivity$6$3(this, v1_1));
                    }
                } else {
                    com.jlboat.phone.activity.SettingActivity.access$100(this.this$0).add(v1_1);
                    com.jlboat.phone.activity.SettingActivity.access$400(this.this$0).post(new com.jlboat.phone.activity.SettingActivity$6$2(this, v1_1));
                }
            } else {
                com.jlboat.phone.activity.SettingActivity.access$100(this.this$0).add(v1_1);
                com.jlboat.phone.activity.SettingActivity.access$400(this.this$0).post(new com.jlboat.phone.activity.SettingActivity$6$1(this, v1_1));
            }
        }
        return;
    }
}
