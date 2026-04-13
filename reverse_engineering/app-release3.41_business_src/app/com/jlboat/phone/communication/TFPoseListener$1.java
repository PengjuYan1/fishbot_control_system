package com.jlboat.phone.communication;
 class TFPoseListener$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.communication.TFPoseListener this$0;

    TFPoseListener$1(com.jlboat.phone.communication.TFPoseListener p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.tf2_msgs.TFMessage) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.tf2_msgs.TFMessage p6)
    {
        if (p6.getTransforms() != null) {
            com.boat.jrosbridge.message.geometry_msgs.TransformStamped[] v0_1 = p6.getTransforms();
            int v1 = v0_1.length;
            int v2 = 0;
            while (v2 < v1) {
                com.jlboat.phone.communication.TFPoseListener.access$000(this.this$0).update(v0_1[v2]);
                v2++;
            }
        }
        return;
    }
}
