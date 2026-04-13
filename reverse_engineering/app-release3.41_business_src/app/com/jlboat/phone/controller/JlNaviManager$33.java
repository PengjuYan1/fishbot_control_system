package com.jlboat.phone.controller;
 class JlNaviManager$33 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;
    final synthetic com.boat.support.slam.IResponseListener val$responseListener;

    JlNaviManager$33(com.jlboat.phone.controller.JlNaviManager p1, com.boat.support.slam.IResponseListener p2)
    {
        this.this$0 = p1;
        this.val$responseListener = p2;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.AboutRobotResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.AboutRobotResponse p3)
    {
        if (this.val$responseListener != null) {
            try {
                this.val$responseListener.onSuccess(p3.getNavInfo());
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }
}
