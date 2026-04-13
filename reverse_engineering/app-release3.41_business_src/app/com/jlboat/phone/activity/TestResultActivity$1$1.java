package com.jlboat.phone.activity;
 class TestResultActivity$1$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.TestResultActivity$1 this$1;
    final synthetic java.util.List val$resultEntries;

    TestResultActivity$1$1(com.jlboat.phone.activity.TestResultActivity$1 p1, java.util.List p2)
    {
        this.this$1 = p1;
        this.val$resultEntries = p2;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_srvs.TriggerResponse) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_srvs.TriggerResponse p6)
    {
        if (p6.getSuccess()) {
            if (!p6.getMessage().isEmpty()) {
                com.jlboat.phone.activity.TestResultActivity.access$102(this.this$1.this$0, new com.boat.support.slam.entity.floors.MapList());
                try {
                    com.jlboat.phone.activity.TestResultActivity.access$102(this.this$1.this$0, ((com.boat.support.slam.entity.floors.MapList) new com.google.gson.Gson().fromJson(new org.json.JSONObject(p6.getMessage()).toString(), new com.jlboat.phone.activity.TestResultActivity$1$1$1(this).getType())));
                } catch (com.jlboat.phone.activity.TestResultActivity v0_3) {
                    v0_3.printStackTrace();
                }
                com.jlboat.phone.activity.TestResultActivity.access$200(this.this$1.this$0, this.val$resultEntries, com.jlboat.phone.activity.TestResultActivity.access$100(this.this$1.this$0));
            } else {
                return;
            }
        }
        return;
    }
}
