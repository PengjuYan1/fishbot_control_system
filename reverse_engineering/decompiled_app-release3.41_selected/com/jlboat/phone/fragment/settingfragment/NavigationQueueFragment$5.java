package com.jlboat.phone.fragment.settingfragment;
 class NavigationQueueFragment$5 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment this$0;

    NavigationQueueFragment$5(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    synthetic void lambda$onNewMessage$0$com-jlboat-phone-fragment-settingfragment-NavigationQueueFragment$5()
    {
        com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$1100(this.this$0);
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
                    com.boat.support.slam.entity.floors.MapList v0_1 = ((com.boat.support.slam.entity.floors.MapList) new com.google.gson.Gson().fromJson(new org.json.JSONObject(p6.getMessage()).toString(), new com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment$5$1(this).getType()));
                } catch (com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment v1_2) {
                    v1_2.printStackTrace();
                }
                com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment.access$1000(this.this$0, v0_1);
                this.this$0.runOnUiThread(new com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment$5$$ExternalSyntheticLambda0(this));
            } else {
                return;
            }
        }
        return;
    }
}
