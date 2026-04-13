package com.jlboat.phone.fragment.statusfragment;
 class Camera03Fragment$3 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.statusfragment.Camera03Fragment this$0;

    Camera03Fragment$3(com.jlboat.phone.fragment.statusfragment.Camera03Fragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.RobotSshResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.RobotSshResponse p4)
    {
        android.util.Log.d("CameraFragment", new StringBuilder().append("onSuccess:reboot").append(p4.getStatus()).toString());
        return;
    }
}
