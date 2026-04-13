package com.jlboat.phone.controller;
 class JlNaviManager$26 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;
    final synthetic String val$newname;
    final synthetic com.boat.support.slam.IResponseListener val$responseListener;

    JlNaviManager$26(com.jlboat.phone.controller.JlNaviManager p1, com.boat.support.slam.IResponseListener p2, String p3)
    {
        this.this$0 = p1;
        this.val$responseListener = p2;
        this.val$newname = p3;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.PointRenameResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.PointRenameResponse p3)
    {
        if (this.val$responseListener != null) {
            try {
                this.val$responseListener.onSuccess(this.val$newname);
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }
}
