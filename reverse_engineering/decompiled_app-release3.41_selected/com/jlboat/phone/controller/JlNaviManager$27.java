package com.jlboat.phone.controller;
 class JlNaviManager$27 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;
    final synthetic com.boat.support.slam.IResponseListener val$responseListener;

    JlNaviManager$27(com.jlboat.phone.controller.JlNaviManager p1, com.boat.support.slam.IResponseListener p2)
    {
        this.this$0 = p1;
        this.val$responseListener = p2;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.PointSetResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.PointSetResponse p3)
    {
        this.this$0.toast("\u6dfb\u52a0\u5bfc\u822a\u70b9\u6210\u529f");
        if (this.val$responseListener != null) {
            try {
                this.val$responseListener.onSuccess(p3.toString());
            } catch (android.os.RemoteException v0_3) {
                v0_3.printStackTrace();
            }
        }
        return;
    }
}
