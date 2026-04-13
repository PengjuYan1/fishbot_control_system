package com.jlboat.phone.controller;
 class JlNaviManager$1$2 implements com.boat.jrosbridge.ROSClient$ConnectionStatusListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager$1 this$1;

    JlNaviManager$1$2(com.jlboat.phone.controller.JlNaviManager$1 p1)
    {
        this.this$1 = p1;
        return;
    }

    public void onConnect()
    {
        com.jlboat.phone.controller.JlNaviManager.access$702(this.this$1.this$0, 1);
        com.jlboat.phone.controller.JlNaviManager.access$202(this.this$1.this$0, 1002);
        com.jlboat.phone.controller.JlNaviManager.access$302(this.this$1.this$0, "\u673a\u5668\u4eba\u8fde\u63a5\u5bfc\u822a\u901a\u8baf\u6210\u529f");
        this.this$1.this$0.toast(new StringBuilder().append(com.jlboat.phone.controller.JlNaviManager.access$300(this.this$1.this$0)).append(com.jlboat.phone.controller.JlNaviManager.access$400(this.this$1.this$0)).append(com.jlboat.phone.controller.JlNaviManager.access$500(this.this$1.this$0)).toString());
        if (!com.jlboat.phone.controller.JlNaviManager.access$400(this.this$1.this$0)) {
            com.jlboat.phone.controller.JlNaviManager.access$602(this.this$1.this$0, 1);
        }
        com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$1.this$0.getApp(), com.jlboat.phone.controller.JlNaviManager.access$200(this.this$1.this$0), com.jlboat.phone.controller.JlNaviManager.access$300(this.this$1.this$0));
        this.this$1.this$0.pubCmdListener = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.CMD_VEL, com.boat.jrosbridge.message.geometry_msgs.Twist, com.jlboat.phone.application.BoatSlamApplication.client);
        this.this$1.this$0.pubCmdListener.advertise();
        this.this$1.this$0.pubRecordBagListener = new com.jlboat.phone.communication.PubRecordBag();
        this.this$1.this$0.setTargetGoalPublish = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.NaviToPointName, com.jlboat.phone.message.map_msgs.SetTargetGoal, com.jlboat.phone.application.BoatSlamApplication.client);
        this.this$1.this$0.setTargetGoalPublish.advertise();
        this.this$1.this$0.nGlobalPlanTopicPublish = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.NpathAddorDel, com.jlboat.phone.message.map_msgs.NGlobalPlan, com.jlboat.phone.application.BoatSlamApplication.client);
        this.this$1.this$0.nGlobalPlanTopicPublish.advertise();
        this.this$1.this$0.erasePoseTopic = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.ErasePose, com.jlboat.phone.message.map_msgs.ErasePose, com.jlboat.phone.application.BoatSlamApplication.client);
        this.this$1.this$0.erasePoseTopic.advertise();
        this.this$1.this$0.outofChange = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.OUTOFCHARGE, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client);
        this.this$1.this$0.outofChange.advertise();
        this.this$1.this$0.warnLedStatus = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.WARNLEDSTATUS, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client);
        this.this$1.this$0.warnLedStatus.advertise();
        this.this$1.this$0.reachPointStatus = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.REACHPOINT_STATUS, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client);
        this.this$1.this$0.reachPointStatus.advertise();
        this.this$1.this$0.mapLisener = new com.jlboat.phone.communication.MapListener();
        this.this$1.this$0.mapLisener.setOnCallBack(this.this$1.this$0);
        this.this$1.this$0.tfPoseListener = new com.jlboat.phone.communication.TFPoseListener();
        this.this$1.this$0.tfPoseListener.setListener(this.this$1.this$0);
        this.this$1.this$0.pathLayerLisener = new com.jlboat.phone.communication.PathLayerLisener();
        this.this$1.this$0.pathLayerLisener.setListener(this.this$1.this$0);
        this.this$1.this$0.statusServiceClient = new com.jlboat.phone.communication.StatusServiceClient();
        this.this$1.this$0.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        this.this$1.this$0.spiritTopicListener = new com.jlboat.phone.communication.SpiritTopicListener();
        this.this$1.this$0.initService();
        return;
    }

    public void onDisconnect(boolean p6, String p7, int p8)
    {
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$1.this$0), new StringBuilder().append("ROSBridgeClient onDisconnect: code ").append(p8).toString());
        if (p8 >= 0) {
            if (p8 != 1000) {
                if (p8 > 1000) {
                    if (this.this$1.this$0.mapLisener != null) {
                        this.this$1.this$0.mapLisener.recycle();
                    }
                    com.jlboat.phone.controller.JlNaviManager.access$202(this.this$1.this$0, 1001);
                    com.jlboat.phone.controller.JlNaviManager.access$302(this.this$1.this$0, "\u5e95\u76d8\u610f\u5916\u65ad\u5f00,\u5c1d\u8bd5\u91cd\u8fde");
                    this.this$1.this$0.toast(new StringBuilder().append(com.jlboat.phone.controller.JlNaviManager.access$300(this.this$1.this$0)).append(com.jlboat.phone.controller.JlNaviManager.access$400(this.this$1.this$0)).append(com.jlboat.phone.controller.JlNaviManager.access$500(this.this$1.this$0)).toString());
                    if (!com.jlboat.phone.controller.JlNaviManager.access$400(this.this$1.this$0)) {
                        com.jlboat.phone.controller.JlNaviManager.access$602(this.this$1.this$0, 1);
                    }
                    com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$1.this$0.getApp(), com.jlboat.phone.controller.JlNaviManager.access$200(this.this$1.this$0), com.jlboat.phone.controller.JlNaviManager.access$300(this.this$1.this$0));
                    com.jlboat.phone.controller.JlNaviManager.access$802(this.this$1.this$0, -1);
                    com.jlboat.phone.controller.JlNaviManager.access$100(this.this$1.this$0).sendEmptyMessage(1);
                    com.jlboat.phone.controller.JlNaviManager.access$702(this.this$1.this$0, 0);
                    com.jlboat.phone.controller.JlNaviManager.access$902(this.this$1.this$0, 0);
                }
            } else {
                this.this$1.this$0.toast("\u81ea\u52a8\u91cd\u542f");
            }
        } else {
            com.jlboat.phone.controller.JlNaviManager.access$202(this.this$1.this$0, 1001);
            com.jlboat.phone.controller.JlNaviManager.access$302(this.this$1.this$0, "\u8fde\u63a5\u5931\u8d25,\u5bfc\u822a\u8f6f\u4ef6\u5f02\u5e38,\u53ef\u80fd\u5e95\u76d8\u7a0b\u5e8f\u6ca1\u8d77\u6765");
            this.this$1.this$0.toast(new StringBuilder().append(com.jlboat.phone.controller.JlNaviManager.access$300(this.this$1.this$0)).append(com.jlboat.phone.controller.JlNaviManager.access$400(this.this$1.this$0)).append(com.jlboat.phone.controller.JlNaviManager.access$500(this.this$1.this$0)).toString());
            if (!com.jlboat.phone.controller.JlNaviManager.access$400(this.this$1.this$0)) {
                com.jlboat.phone.controller.JlNaviManager.access$602(this.this$1.this$0, 1);
            }
            if ((com.jlboat.phone.controller.JlNaviManager.access$400(this.this$1.this$0)) && (com.jlboat.phone.controller.JlNaviManager.access$500(this.this$1.this$0))) {
                com.boat.utils.ReportExceptionInformationUtils.uploadWarn(this.this$1.this$0.getApp(), com.jlboat.phone.controller.JlNaviManager.access$200(this.this$1.this$0), com.jlboat.phone.controller.JlNaviManager.access$300(this.this$1.this$0));
                com.jlboat.phone.controller.JlNaviManager.access$502(this.this$1.this$0, 0);
            }
            com.jlboat.phone.controller.JlNaviManager.access$100(this.this$1.this$0).sendEmptyMessageDelayed(2, 10000);
            this.this$1.this$0.Navigational_state(4);
        }
        return;
    }

    public void onError(Exception p3)
    {
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$1.this$0), "ROSBridgeClient onError: ");
        p3.printStackTrace();
        return;
    }
}
