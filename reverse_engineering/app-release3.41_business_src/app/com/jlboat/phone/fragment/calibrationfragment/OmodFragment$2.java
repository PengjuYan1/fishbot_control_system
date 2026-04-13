package com.jlboat.phone.fragment.calibrationfragment;
 class OmodFragment$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.calibrationfragment.OmodFragment this$0;

    OmodFragment$2(com.jlboat.phone.fragment.calibrationfragment.OmodFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.GetConfigsResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.GetConfigsResponse p6)
    {
        com.jlboat.phone.fragment.calibrationfragment.OmodFragment.access$000(this.this$0).clear();
        android.os.Handler v0_5 = p6.getConfigs().iterator();
        while (v0_5.hasNext()) {
            int v1_2 = ((com.jlboat.phone.message.map_msgs.Config) v0_5.next());
            if ((v1_2.getConfigName().equals("line_scale")) || ((v1_2.getConfigName().equals("rotate_scale")) || ((v1_2.getConfigName().equals("right_pwm_scale")) || ((v1_2.getConfigName().equals("rotate_scale")) || ((v1_2.getConfigName().equals("rotate_scale")) || (v1_2.getConfigName().equals("rotate_scale"))))))) {
                com.jlboat.phone.fragment.calibrationfragment.OmodFragment.access$000(this.this$0).add(v1_2);
            }
        }
        com.jlboat.phone.fragment.calibrationfragment.OmodFragment.access$100(this.this$0).sendEmptyMessage(1);
        return;
    }
}
