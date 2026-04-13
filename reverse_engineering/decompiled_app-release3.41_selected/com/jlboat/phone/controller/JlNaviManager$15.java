package com.jlboat.phone.controller;
 class JlNaviManager$15 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$15(com.jlboat.phone.controller.JlNaviManager p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.jlboat.phone.message.map_msgs.TargetGoalPlanResponse) p1));
        return;
    }

    public void onNewMessage(com.jlboat.phone.message.map_msgs.TargetGoalPlanResponse p4)
    {
        this.this$0.toast(new StringBuilder().append("onSuccess: naviTargetGoalPlan ").append(p4.getStatus()).toString());
        if (com.jlboat.phone.controller.JlNaviManager.access$3400(this.this$0) != null) {
            try {
                com.jlboat.phone.controller.JlNaviManager.access$3400(this.this$0).onSuccess("succ");
            } catch (android.os.RemoteException v0_5) {
                v0_5.printStackTrace();
            }
        }
        return;
    }
}
