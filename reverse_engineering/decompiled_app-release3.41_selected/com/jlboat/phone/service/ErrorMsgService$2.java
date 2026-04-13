package com.jlboat.phone.service;
 class ErrorMsgService$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.service.ErrorMsgService this$0;

    ErrorMsgService$2(com.jlboat.phone.service.ErrorMsgService p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.AboutRobotResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.AboutRobotResponse p14)
    {
        android.util.Log.d("ErrorMsgService", new StringBuilder().append("onSuccess: aboutRobot").append(p14.getNavInfo()).toString());
        String v0_3 = p14.getNavInfo();
        new com.jlboat.phone.bean.NavInfo();
        try {
            com.jlboat.phone.bean.NavInfo v2_1 = ((com.jlboat.phone.bean.NavInfo) new com.google.gson.Gson().fromJson(new org.json.JSONObject(v0_3).toString(), new com.jlboat.phone.service.ErrorMsgService$2$1(this).getType()));
        } catch (String v3_2) {
            v3_2.printStackTrace();
        }
        String v4_5;
        String v3_3 = v2_1.getCoco_num();
        if (v2_1.getCoco_num_pc() != null) {
            v4_5 = v2_1.getCoco_num_pc();
        } else {
            v4_5 = v2_1.getCoco_num();
        }
        String v5_1 = v2_1.getNavi_channel();
        String v6_3 = v2_1.getVersion_code();
        String v7 = v2_1.getVersion_name();
        String v8 = v2_1.getStm32_version_name();
        String v9 = v2_1.getCarto_version_name();
        String v10 = v2_1.getNumero();
        android.util.Log.d("ErrorMsgService", new StringBuilder().append("setText: ").append(v7).toString());
        android.util.Log.d("ErrorMsgService", new StringBuilder().append("setText: ").append(v3_3).append(" ").append(v4_5).append(" ").append(v5_1).append(" ").append(v6_3).append(" ").append(v7).append(" ").append(v10).toString());
        try {
            com.jlboat.phone.application.BoatSlamApplication.coco_num = Integer.parseInt(v3_3);
            com.jlboat.phone.application.BoatSlamApplication.coco_num_pc = Integer.parseInt(v4_5);
            com.jlboat.phone.application.BoatSlamApplication.classis_channel = v5_1;
            com.jlboat.phone.application.BoatSlamApplication.classis_version_code = Integer.parseInt(v6_3);
            com.jlboat.phone.application.BoatSlamApplication.classis_version_name = v7;
            com.jlboat.phone.application.BoatSlamApplication.classis_driver_version_name = v8;
            com.jlboat.phone.application.BoatSlamApplication.classis_carto_version_name = v9;
            com.jlboat.phone.application.BoatSlamApplication.classis_numero = Integer.parseInt(v10);
            com.jlboat.phone.application.BoatSlamApplication.has_nav_info = 1;
        } catch (Exception v1_4) {
            v1_4.printStackTrace();
        }
        return;
    }
}
