package com.jlboat.phone.controller;
 class JlNaviManager$21 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;
    final synthetic com.boat.support.slam.IResponseListener val$responseListener;
    final synthetic com.boat.support.slam.entity.floors.ShapeAreas val$shapArea;

    JlNaviManager$21(com.jlboat.phone.controller.JlNaviManager p1, com.boat.support.slam.entity.floors.ShapeAreas p2, com.boat.support.slam.IResponseListener p3)
    {
        this.this$0 = p1;
        this.val$shapArea = p2;
        this.val$responseListener = p3;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.SetShapeResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.SetShapeResponse p6)
    {
        if (this.val$shapArea.getShapeId() == 0) {
            this.this$0.toast(this.this$0.getApp().getResources().getString(2131493249));
        } else {
            android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), "onNewMessage: \u5220\u9664\u6210\u529f");
        }
        if (this.val$responseListener != null) {
            try {
                this.val$responseListener.onSuccess("succ");
            } catch (android.os.RemoteException v0_6) {
                v0_6.printStackTrace();
            }
        }
        return;
    }
}
