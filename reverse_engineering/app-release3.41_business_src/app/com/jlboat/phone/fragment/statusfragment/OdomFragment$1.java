package com.jlboat.phone.fragment.statusfragment;
 class OdomFragment$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.statusfragment.OdomFragment this$0;

    OdomFragment$1(com.jlboat.phone.fragment.statusfragment.OdomFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.nav_msgs.Odometry) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.nav_msgs.Odometry p17)
    {
        int v1 = 0;
        android.support.v7.widget.RecyclerView v4_7 = new Object[1];
        v4_7[0] = Double.valueOf(p17.getPose().getPose().getPosition().getX());
        if (!String.format("%.2f", v4_7).equals(this.this$0.x)) {
            v1 = 1;
            android.support.v7.widget.RecyclerView v4_19 = this.this$0;
            String v7_6 = new Object[1];
            v7_6[0] = Double.valueOf(p17.getPose().getPose().getPosition().getX());
            v4_19.x = String.format("%.2f", v7_6);
        }
        String v6_54 = new Object[1];
        v6_54[0] = Double.valueOf(p17.getPose().getPose().getPosition().getY());
        if (!String.format("%.2f", v6_54).equals(this.this$0.y)) {
            v1 = 1;
            android.support.v7.widget.RecyclerView v4_28 = this.this$0;
            String v7_7 = new Object[1];
            v7_7[0] = Double.valueOf(p17.getPose().getPose().getPosition().getY());
            v4_28.y = String.format("%.2f", v7_7);
        }
        java.text.DateFormat v2_11 = new com.jlboat.phone.util.EulerAngles;
        v2_11(p17.getPose().getPose().getOrientation().getW(), p17.getPose().getPose().getOrientation().getX(), p17.getPose().getPose().getOrientation().getY(), p17.getPose().getPose().getOrientation().getZ());
        android.support.v7.widget.RecyclerView v4_3 = new Object[1];
        v4_3[0] = Double.valueOf(Math.toDegrees(v2_11.yaw));
        if (!String.format("%.0f\u00b0", v4_3).equals(this.this$0.yaw)) {
            v1 = 1;
            android.support.v7.widget.RecyclerView v4_6 = this.this$0;
            com.jlboat.phone.util.EulerAngles v15 = new com.jlboat.phone.util.EulerAngles;
            v15(p17.getPose().getPose().getOrientation().getW(), p17.getPose().getPose().getOrientation().getX(), p17.getPose().getPose().getOrientation().getY(), p17.getPose().getPose().getOrientation().getZ());
            String v3_1 = new Object[1];
            v3_1[0] = Double.valueOf(Math.toDegrees(v15.yaw));
            v4_6.yaw = String.format("%.0f\u00b0", v3_1);
        }
        String v3_4 = java.text.DateFormat.getTimeInstance(2).format(Long.valueOf(System.currentTimeMillis()));
        if (v1 != 0) {
            if (this.this$0.addViewed.size() >= 300) {
                this.this$0.addViewed.remove(299);
                this.this$0.addViewed.add(0, new StringBuilder().append("     time: ").append(v3_4).append("     x: ").append(this.this$0.x).append("  y: ").append(this.this$0.y).append("  yaw: ").append(this.this$0.yaw).toString());
            } else {
                this.this$0.addViewed.add(0, new StringBuilder().append("     time: ").append(v3_4).append("     x: ").append(this.this$0.x).append("  y: ").append(this.this$0.y).append("  yaw: ").append(this.this$0.yaw).toString());
            }
            this.this$0.rvAddNewView.post(new com.jlboat.phone.fragment.statusfragment.OdomFragment$1$1(this));
        }
        return;
    }
}
