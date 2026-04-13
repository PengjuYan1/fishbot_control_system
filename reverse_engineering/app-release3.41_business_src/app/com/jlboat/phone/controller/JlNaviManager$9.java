package com.jlboat.phone.controller;
 class JlNaviManager$9 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;
    final synthetic com.boat.support.slam.IResponseListener val$responseListener;

    JlNaviManager$9(com.jlboat.phone.controller.JlNaviManager p1, com.boat.support.slam.IResponseListener p2)
    {
        this.this$0 = p1;
        this.val$responseListener = p2;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.BagListResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.BagListResponse p3)
    {
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), "onSuccess: getBag");
        if (p3.getStatus() != 0) {
            if (this.val$responseListener != null) {
                try {
                    this.val$responseListener.onFailed("");
                } catch (android.os.RemoteException v0_2) {
                    v0_2.printStackTrace();
                }
            }
        } else {
            if (this.val$responseListener != null) {
                try {
                    this.val$responseListener.onSuccess(p3.getBagNames().toString());
                } catch (android.os.RemoteException v0_6) {
                    v0_6.printStackTrace();
                }
            }
        }
        return;
    }
}
