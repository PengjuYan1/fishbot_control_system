package com.jlboat.phone.fragment.settingfragment;
 class NavigationTestFragment$4 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.settingfragment.NavigationTestFragment this$0;

    NavigationTestFragment$4(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_srvs.TriggerResponse) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_srvs.TriggerResponse p11)
    {
        if (p11.getSuccess()) {
            if (!p11.getMessage().isEmpty()) {
                new com.boat.support.slam.entity.floors.MapList();
                try {
                    com.boat.support.slam.entity.floors.MapList v0_1 = ((com.boat.support.slam.entity.floors.MapList) new com.google.gson.Gson().fromJson(new org.json.JSONObject(p11.getMessage()).toString(), new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment$4$1(this).getType()));
                } catch (android.os.Handler v1_2) {
                    v1_2.printStackTrace();
                }
                android.os.Handler v1_4 = v0_1.getFloors().iterator();
                while (v1_4.hasNext()) {
                    com.boat.support.slam.entity.floors.Floors v2_7 = ((com.boat.support.slam.entity.floors.Floors) v1_4.next());
                    if (v2_7.getFloorId() == v0_1.getDefaultFloor()) {
                        int v3_3 = v2_7.getMaps().size();
                        int v4_3 = 0;
                        while (v4_3 < v3_3) {
                            if (v2_7.getDefaultmap() != ((com.boat.support.slam.entity.floors.Maps) v2_7.getMaps().get(v4_3)).getMapId()) {
                                v4_3++;
                            } else {
                                com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$002(this.this$0, ((com.boat.support.slam.entity.floors.Maps) v2_7.getMaps().get(v4_3)).getMapName());
                                com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$902(this.this$0, v2_7.getMaps());
                                com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$1002(this.this$0, v2_7.getDefaultmap());
                                com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$202(this.this$0, ((com.boat.support.slam.entity.floors.Maps) v2_7.getMaps().get(v4_3)).getPoints());
                                com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.access$1100(this.this$0).sendEmptyMessage(101);
                            }
                        }
                    }
                }
            } else {
                return;
            }
        }
        return;
    }
}
