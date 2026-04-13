package com.jlboat.phone.activity;
 class DiyPointPathActivity$9 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.DiyPointPathActivity this$0;

    DiyPointPathActivity$9(com.jlboat.phone.activity.DiyPointPathActivity p1)
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
        android.util.Log.d("DiyPointPathActivity", "getDefConfig onNewMessage: ");
        java.util.Iterator v0_2 = p5.getConfigs().iterator();
        while (v0_2.hasNext()) {
            com.jlboat.phone.message.map_msgs.Config v1_2 = ((com.jlboat.phone.message.map_msgs.Config) v0_2.next());
            if (v1_2.getConfigName().equals("ng_path_df_type")) {
                com.jlboat.phone.activity.DiyPointPathActivity.access$1702(this.this$0, Integer.parseInt(v1_2.getConfigValue()));
                com.jlboat.phone.activity.DiyPointPathActivity.access$1802(this.this$0, 1);
            }
            if (v1_2.getConfigName().equals("ng_path_df_direction")) {
                com.jlboat.phone.activity.DiyPointPathActivity.access$1902(this.this$0, Integer.parseInt(v1_2.getConfigValue()));
            }
            if (v1_2.getConfigName().equals("ng_path_df_speed")) {
                com.jlboat.phone.activity.DiyPointPathActivity.access$2002(this.this$0, Float.parseFloat(v1_2.getConfigValue()));
            }
            if (v1_2.getConfigName().equals("ng_path_df_weight")) {
                com.jlboat.phone.activity.DiyPointPathActivity.access$2102(this.this$0, Float.parseFloat(v1_2.getConfigValue()));
            }
        }
        return;
    }
}
