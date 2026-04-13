package com.jlboat.phone.fragment.statusfragment;
 class AvoidFillFragment$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.statusfragment.AvoidFillFragment this$0;

    AvoidFillFragment$1(com.jlboat.phone.fragment.statusfragment.AvoidFillFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int16MultiArray) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int16MultiArray p12)
    {
        com.jlboat.phone.fragment.statusfragment.AvoidFillFragment.access$002(this.this$0, 0);
        long[] v0_1 = p12.getData();
        if (v0_1.length == 2) {
            com.boat.jrosbridge.message.Log.d("AvoidFillFragment", new StringBuilder().append("InfraredRangeSensor_Distance: ").append(v0_1).toString());
            if (((v0_1[0] < 150) && (v0_1[0] > 30)) || ((v0_1[1] < 150) && (v0_1[1] > 30))) {
                com.jlboat.phone.fragment.statusfragment.AvoidFillFragment.access$002(this.this$0, 1);
            }
            String v4_9 = java.text.DateFormat.getTimeInstance(2).format(Long.valueOf(System.currentTimeMillis()));
            if (this.this$0.addViewed.size() >= 100) {
                this.this$0.addViewed.remove(99);
                this.this$0.addViewed.add(0, new StringBuilder().append("     time: ").append(v4_9).append("  :[ ").append(String.valueOf(v0_1[0])).append(",").append(String.valueOf(v0_1[1])).append(" ]").toString());
            } else {
                this.this$0.addViewed.add(0, new StringBuilder().append("     time: ").append(v4_9).append("  :[ ").append(String.valueOf(v0_1[0])).append(",").append(String.valueOf(v0_1[1])).append(" ]").toString());
            }
            this.this$0.rvAddNewView.post(new com.jlboat.phone.fragment.statusfragment.AvoidFillFragment$1$1(this, com.jlboat.phone.fragment.statusfragment.AvoidFillFragment.access$000(this.this$0)));
        }
        return;
    }
}
