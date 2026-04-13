package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment2025$4 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 this$0;

    NavigationTestFragment2025$4(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        this.this$0 = p1;
        return;
    }

    synthetic void lambda$onNewMessage$0$com-jlboat-phone-fragment-settingfragment-NavigationTestFragment2025$4()
    {
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$1100(this.this$0);
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
                    com.boat.support.slam.entity.floors.MapList v0_1 = ((com.boat.support.slam.entity.floors.MapList) new com.google.gson.Gson().fromJson(new org.json.JSONObject(p6.getMessage()).toString(), new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025$4$1(this).getType()));
                } catch (android.support.v4.app.FragmentActivity v1_2) {
                    v1_2.printStackTrace();
                }
                com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.access$1000(this.this$0, v0_1);
                this.this$0.requireActivity().runOnUiThread(new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025$4$$ExternalSyntheticLambda0(this));
            } else {
                return;
            }
        }
        return;
    }
}
