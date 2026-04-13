package com.jlboat.phone.controller;
 class JlNaviManager$29 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$29(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.GetConfigsResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.GetConfigsResponse p9)
    {
        int v0 = -1;
        int v1 = -1;
        float v2 = -1082130432;
        float v3 = -1082130432;
        com.boat.support.slam.entity.floors.NLine v4_3 = p9.getConfigs().iterator();
        while (v4_3.hasNext()) {
            com.jlboat.phone.controller.JlNaviManager v5_4 = ((com.jlboat.phone.message.map_msgs.Config) v4_3.next());
            if (v5_4.getConfigName().equals("ng_path_df_type")) {
                v0 = Integer.parseInt(v5_4.getConfigValue());
            }
            if (v5_4.getConfigName().equals("ng_path_df_direction")) {
                v1 = Integer.parseInt(v5_4.getConfigValue());
            }
            if (v5_4.getConfigName().equals("ng_path_df_speed")) {
                v2 = Float.parseFloat(v5_4.getConfigValue());
            }
            if (v5_4.getConfigName().equals("ng_path_df_weight")) {
                v3 = Float.parseFloat(v5_4.getConfigValue());
            }
        }
        com.boat.support.slam.entity.floors.NLine v4_1 = new com.boat.support.slam.entity.floors.NLine();
        v4_1.setType(v0);
        v4_1.setDirection(v1);
        v4_1.setSpeed(v2);
        v4_1.setWeight(v3);
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), "getDefDiyLineConfig: RobotNGlobalplansConfig ");
        com.jlboat.phone.controller.JlNaviManager.access$3600(this.this$0, "RobotNGlobalplansConfig", new com.google.gson.Gson().toJson(v4_1));
        return;
    }
}
