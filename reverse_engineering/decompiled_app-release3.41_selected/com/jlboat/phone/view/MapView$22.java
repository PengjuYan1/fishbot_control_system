package com.jlboat.phone.view;
 class MapView$22 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.view.MapView this$0;

    MapView$22(com.jlboat.phone.view.MapView p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.geometry_msgs.PoseStamped) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.geometry_msgs.PoseStamped p13)
    {
        com.jlboat.phone.view.MapView.access$800(this.this$0);
        Throwable v1_4 = this.this$0;
        double v9_1 = new com.boat.ros.geometry.Vector3;
        v9_1(p13.pose.position.x, p13.pose.position.y, p13.pose.position.z);
        com.jlboat.phone.view.MapView.access$902(v1_4, v9_1);
        Throwable v1_3 = this.this$0;
        com.boat.ros.geometry.Quaternion v11 = new com.boat.ros.geometry.Quaternion;
        v11(p13.pose.orientation.x, p13.pose.orientation.y, p13.pose.orientation.z, p13.pose.orientation.w);
        com.jlboat.phone.view.MapView.access$1002(v1_3, v11);
        Throwable v1_7 = this.this$0.vector.subtract(this.this$0.vector);
        com.boat.ros.geometry.Vector3 v2_16 = this.this$0.vectorleft.subtract(this.this$0.vector);
        com.boat.ros.geometry.Vector3 v3_5 = this.this$0.vectortop.subtract(this.this$0.vector);
        com.boat.ros.geometry.Vector3 v4_4 = this.this$0.vectorright.subtract(this.this$0.vector);
        com.jlboat.phone.view.MapView.access$1102(this.this$0, com.jlboat.phone.view.MapView.access$1000(this.this$0).rotateAndScaleVector(v1_7).add(com.jlboat.phone.view.MapView.access$900(this.this$0)));
        com.jlboat.phone.view.MapView.access$1202(this.this$0, com.jlboat.phone.view.MapView.access$1000(this.this$0).rotateAndScaleVector(v2_16).add(com.jlboat.phone.view.MapView.access$900(this.this$0)));
        com.jlboat.phone.view.MapView.access$1302(this.this$0, com.jlboat.phone.view.MapView.access$1000(this.this$0).rotateAndScaleVector(v3_5).add(com.jlboat.phone.view.MapView.access$900(this.this$0)));
        com.jlboat.phone.view.MapView.access$1402(this.this$0, com.jlboat.phone.view.MapView.access$1000(this.this$0).rotateAndScaleVector(v4_4).add(com.jlboat.phone.view.MapView.access$900(this.this$0)));
        com.jlboat.phone.view.MapView.access$1502(this.this$0, 1);
        this.this$0.post(new com.jlboat.phone.view.MapView$22$1(this));
        return;
    }
}
