package com.jlboat.phone.fragment.statusfragment;
 class ImuFragment$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.statusfragment.ImuFragment this$0;

    ImuFragment$1(com.jlboat.phone.fragment.statusfragment.ImuFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.sensor_msgs.Imu) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.sensor_msgs.Imu p17)
    {
        int v1 = 0;
        double v11_0 = new com.jlboat.phone.util.EulerAngles;
        v11_0(p17.getOrientation().getW(), p17.getOrientation().getX(), p17.getOrientation().getY(), p17.getOrientation().getZ());
        android.support.v7.widget.RecyclerView v4_4 = new Object[1];
        v4_4[0] = Double.valueOf(Math.toDegrees(v11_0.yaw));
        if (!String.format("%.0f\u00b0", v4_4).equals(this.this$0.yaw)) {
            v1 = 1;
            android.support.v7.widget.RecyclerView v4_7 = this.this$0;
            com.jlboat.phone.util.EulerAngles v15 = new com.jlboat.phone.util.EulerAngles;
            v15(p17.getOrientation().getW(), p17.getOrientation().getX(), p17.getOrientation().getY(), p17.getOrientation().getZ());
            String v3_2 = new Object[1];
            v3_2[0] = Double.valueOf(Math.toDegrees(v15.yaw));
            v4_7.yaw = String.format("%.0f\u00b0", v3_2);
        }
        String v3_5 = java.text.DateFormat.getTimeInstance(2).format(Long.valueOf(System.currentTimeMillis()));
        if (v1 != 0) {
            if (this.this$0.addViewed.size() >= 300) {
                this.this$0.addViewed.remove(299);
                this.this$0.addViewed.add(0, new StringBuilder().append("     time: ").append(v3_5).append("     yaw: ").append(this.this$0.yaw).toString());
            } else {
                this.this$0.addViewed.add(0, new StringBuilder().append("     time: ").append(v3_5).append("     yaw: ").append(this.this$0.yaw).toString());
            }
            this.this$0.rvAddNewView.post(new com.jlboat.phone.fragment.statusfragment.ImuFragment$1$1(this));
        }
        return;
    }
}
