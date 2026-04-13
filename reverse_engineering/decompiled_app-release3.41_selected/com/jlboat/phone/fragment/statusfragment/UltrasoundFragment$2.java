package com.jlboat.phone.fragment.statusfragment;
 class UltrasoundFragment$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.statusfragment.UltrasoundFragment this$0;

    UltrasoundFragment$2(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.RobotSonarListResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.RobotSonarListResponse p4)
    {
        com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$902(this.this$0, p4.getSonars());
        com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$1002(this.this$0, p4.isUserSonar());
        android.util.Log.d(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$1100(this.this$0), new StringBuilder().append("onSuccess: getSonar: ").append(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$900(this.this$0).size()).toString());
        com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$1200(this.this$0).sendEmptyMessage(3);
        return;
    }
}
