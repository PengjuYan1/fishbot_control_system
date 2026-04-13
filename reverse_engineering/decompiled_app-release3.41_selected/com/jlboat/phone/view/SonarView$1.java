package com.jlboat.phone.view;
 class SonarView$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.view.SonarView this$0;

    SonarView$1(com.jlboat.phone.view.SonarView p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Float32MultiArray) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Float32MultiArray p8)
    {
        java.util.ArrayList v0_1 = new java.util.ArrayList();
        com.jlboat.phone.view.SonarView v1_0 = p8.getData();
        com.jlboat.phone.view.SonarView$1$1 v2_0 = v1_0.length;
        int v3 = 0;
        while (v3 < v2_0) {
            float v4 = v1_0[v3];
            if (v4 <= 1128792064) {
                v0_1.add(Float.valueOf(v4));
            } else {
                v0_1.add(Float.valueOf(1128792064));
            }
            v3++;
        }
        this.this$0.post(new com.jlboat.phone.view.SonarView$1$1(this, v0_1));
        return;
    }
}
