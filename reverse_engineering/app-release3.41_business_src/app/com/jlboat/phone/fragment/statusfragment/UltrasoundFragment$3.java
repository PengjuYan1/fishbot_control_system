package com.jlboat.phone.fragment.statusfragment;
 class UltrasoundFragment$3 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.statusfragment.UltrasoundFragment this$0;

    UltrasoundFragment$3(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.RobotSonarSetResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.RobotSonarSetResponse p6)
    {
        long v0 = p6.getResult();
        android.util.Log.d(com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$1100(this.this$0), new StringBuilder().append("onSuccess: saveSonar: ").append(v0).toString());
        if (v0 != 0) {
            com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$1400(this.this$0, this.this$0.getResources().getString(2131493247));
        } else {
            com.jlboat.phone.fragment.statusfragment.UltrasoundFragment.access$1300(this.this$0, this.this$0.getResources().getString(2131493249));
        }
        return;
    }
}
