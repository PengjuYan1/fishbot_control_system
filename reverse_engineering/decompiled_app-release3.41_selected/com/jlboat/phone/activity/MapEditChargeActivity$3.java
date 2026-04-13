package com.jlboat.phone.activity;
 class MapEditChargeActivity$3 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapEditChargeActivity this$0;

    MapEditChargeActivity$3(com.jlboat.phone.activity.MapEditChargeActivity p1)
    {
        this.this$0 = p1;
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
                new com.boat.support.slam.entity.floors.MapList();
                try {
                    com.boat.support.slam.entity.floors.MapList v0_1 = ((com.boat.support.slam.entity.floors.MapList) new com.google.gson.Gson().fromJson(new org.json.JSONObject(p6.getMessage()).toString(), new com.jlboat.phone.activity.MapEditChargeActivity$3$1(this).getType()));
                } catch (com.jlboat.phone.activity.MapEditChargeActivity v1_2) {
                    v1_2.printStackTrace();
                }
                com.jlboat.phone.activity.MapEditChargeActivity.access$102(this.this$0, v0_1.getChargingPrioritys());
                com.jlboat.phone.activity.MapEditChargeActivity.access$202(this.this$0, v0_1.getFloors());
                android.util.Log.d("MapEditChargeActivity", new StringBuilder().append("chargingPrioritys:").append(com.jlboat.phone.activity.MapEditChargeActivity.access$100(this.this$0)).toString());
                this.this$0.runOnUiThread(new com.jlboat.phone.activity.MapEditChargeActivity$3$2(this));
            } else {
                return;
            }
        }
        return;
    }
}
