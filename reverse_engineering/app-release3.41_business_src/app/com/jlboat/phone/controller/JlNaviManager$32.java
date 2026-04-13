package com.jlboat.phone.controller;
 class JlNaviManager$32 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;
    final synthetic com.boat.support.slam.IPositionResult val$result;

    JlNaviManager$32(com.jlboat.phone.controller.JlNaviManager p1, com.boat.support.slam.IPositionResult p2)
    {
        this.this$0 = p1;
        this.val$result = p2;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.GetPositionResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.GetPositionResponse p4)
    {
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("onSuccess: GetPositionResponse() Success \nx: ").append(p4.getPose().getX()).append("\ny: ").append(p4.getPose().getY()).append("\nz: ").append(p4.getPose().getZ()).toString());
        com.boat.support.slam.entity.floors.Points v0_3 = new com.boat.support.slam.entity.floors.Points();
        v0_3.setPositionX(((double) p4.getPose().getX()));
        v0_3.setPositionY(((double) p4.getPose().getY()));
        v0_3.setPositionYaw(((double) p4.getPose().getZ()));
        if (this.val$result != null) {
            try {
                this.val$result.onPosition(v0_3);
            } catch (android.os.RemoteException v1_19) {
                v1_19.printStackTrace();
            }
        }
        return;
    }
}
