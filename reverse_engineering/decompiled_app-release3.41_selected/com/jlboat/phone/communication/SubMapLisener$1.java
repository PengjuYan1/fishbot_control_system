package com.jlboat.phone.communication;
 class SubMapLisener$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.communication.SubMapLisener this$0;
    final synthetic com.boat.jrosbridge.Topic val$submapListSubscriber;
    final synthetic com.boat.jrosbridge.Service val$submapQueryServiceClient;

    SubMapLisener$1(com.jlboat.phone.communication.SubMapLisener p1, com.boat.jrosbridge.Topic p2, com.boat.jrosbridge.Service p3)
    {
        this.this$0 = p1;
        this.val$submapListSubscriber = p2;
        this.val$submapQueryServiceClient = p3;
        return;
    }

    public void onNewMessage(cartographer_ros_msgs.SubmapList p8)
    {
        if (p8.getSubmap().size() > 0) {
            if ((this.this$0.第一次进来) || (((cartographer_ros_msgs.SubmapEntry) p8.getSubmap().get((p8.getSubmap().size() - 1))).getTrajectoryId() == 0)) {
                com.jlboat.phone.communication.SubMapLisener.access$000(this.this$0, p8);
            }
            if (this.this$0.第一次进来) {
                int v3_15;
                if (((cartographer_ros_msgs.SubmapEntry) p8.getSubmap().get((p8.getSubmap().size() - 1))).getTrajectoryId() != 0) {
                    v3_15 = 0;
                } else {
                    v3_15 = 1;
                }
                this.this$0.status = v3_15;
            }
            int v3_20;
            if (((cartographer_ros_msgs.SubmapEntry) p8.getSubmap().get((p8.getSubmap().size() - 1))).getTrajectoryId() != 0) {
                v3_20 = 0;
            } else {
                v3_20 = 1;
            }
            if (this.this$0.status != v3_20) {
                int v3_25;
                if (((cartographer_ros_msgs.SubmapEntry) p8.getSubmap().get((p8.getSubmap().size() - 1))).getTrajectoryId() != 0) {
                    v3_25 = 0;
                } else {
                    v3_25 = 1;
                }
                this.this$0.status = v3_25;
                if (this.this$0.onDataCallBack != null) {
                    this.val$submapListSubscriber.unsubscribe();
                    this.this$0.onDataCallBack.onRestart();
                }
            }
            if (!this.this$0.第一次进来) {
                java.util.Iterator v0_37 = (p8.getSubmap().size() - 1);
                if ((((cartographer_ros_msgs.SubmapEntry) p8.getSubmap().get(v0_37)).getTrajectoryId() == 0) && (this.val$submapQueryServiceClient != null)) {
                    cartographer_ros_msgs.SubmapEntry v1_4 = new cartographer_ros_msgs.SubmapQueryRequest();
                    cartographer_ros_msgs.SubmapQueryRequest v2_3 = ((cartographer_ros_msgs.SubmapEntry) p8.getSubmap().get(v0_37)).getSubmapIndex();
                    v1_4.setTrajectoryId(((cartographer_ros_msgs.SubmapEntry) p8.getSubmap().get(v0_37)).getTrajectoryId());
                    v1_4.setSubmapIndex(v2_3);
                    this.val$submapQueryServiceClient.callWithHandler(v1_4, new com.jlboat.phone.communication.SubMapLisener$1$2(this, v2_3));
                }
            } else {
                this.this$0.第一次进来 = 0;
                java.util.Iterator v0_4 = this.this$0.a;
                int v3_6 = this.this$0.a;
                com.boat.jrosbridge.Service v4_3 = this.this$0.a;
                this.this$0.a[3] = 0;
                v4_3[2] = 0;
                v3_6[1] = 0;
                v0_4[0] = 0;
                java.util.Iterator v0_6 = p8.getSubmap().iterator();
                while (v0_6.hasNext()) {
                    if (((cartographer_ros_msgs.SubmapEntry) v0_6.next()).getTrajectoryId() == 0) {
                        this.this$0.a[0] = (this.this$0.a[0] + 1);
                    }
                }
                java.util.Iterator v0_8 = p8.getSubmap().iterator();
                while (v0_8.hasNext()) {
                    cartographer_ros_msgs.SubmapEntry v1_7 = ((cartographer_ros_msgs.SubmapEntry) v0_8.next());
                    if ((v1_7.getTrajectoryId() == 0) && (this.val$submapQueryServiceClient != null)) {
                        cartographer_ros_msgs.SubmapQueryRequest v2_10 = new cartographer_ros_msgs.SubmapQueryRequest();
                        int v3_8 = v1_7.getSubmapIndex();
                        v2_10.setTrajectoryId(v1_7.getTrajectoryId());
                        v2_10.setSubmapIndex(v3_8);
                        this.val$submapQueryServiceClient.callWithHandler(v2_10, new com.jlboat.phone.communication.SubMapLisener$1$1(this, v3_8));
                    }
                }
            }
            return;
        } else {
            com.jlboat.phone.communication.SubMapLisener.access$000(this.this$0, p8);
            if (this.this$0.onDataCallBack != null) {
                this.val$submapListSubscriber.unsubscribe();
                this.this$0.onDataCallBack.onRestart();
            }
            return;
        }
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((cartographer_ros_msgs.SubmapList) p1));
        return;
    }
}
