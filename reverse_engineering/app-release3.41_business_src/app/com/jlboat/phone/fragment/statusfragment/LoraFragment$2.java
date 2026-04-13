package com.jlboat.phone.fragment.statusfragment;
 class LoraFragment$2 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.fragment.statusfragment.LoraFragment this$0;

    LoraFragment$2(com.jlboat.phone.fragment.statusfragment.LoraFragment p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_srvs.TriggerResponse) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_srvs.TriggerResponse p13)
    {
        if (p13.getSuccess()) {
            if (!p13.getMessage().isEmpty()) {
                new com.boat.support.slam.entity.floors.MapList();
                try {
                    com.boat.support.slam.entity.floors.MapList v0_1 = ((com.boat.support.slam.entity.floors.MapList) new com.google.gson.Gson().fromJson(new org.json.JSONObject(p13.getMessage()).toString(), new com.jlboat.phone.fragment.statusfragment.LoraFragment$2$1(this).getType()));
                } catch (android.support.v4.app.FragmentActivity v1_2) {
                    v1_2.printStackTrace();
                }
                if ((v0_1 != null) && (v0_1.getFloors() != null)) {
                    com.jlboat.phone.fragment.statusfragment.LoraFragment$2$2 v2_8 = v0_1.getFloors().iterator();
                    while (v2_8.hasNext()) {
                        String v3_7 = ((com.boat.support.slam.entity.floors.Floors) v2_8.next());
                        if ((v3_7 != null) && ((v3_7.getMaps() != null) && (v3_7.getDefaultmap() != -1))) {
                            long v4_6 = v3_7.getDefaultmap();
                            String v6_1 = 0;
                            java.util.Iterator v7_8 = v3_7.getMaps().iterator();
                            while (v7_8.hasNext()) {
                                com.boat.support.slam.entity.floors.Points v8_9 = ((com.boat.support.slam.entity.floors.Maps) v7_8.next());
                                if ((v8_9 != null) && (v8_9.getMapId() == v4_6)) {
                                    v6_1 = v8_9;
                                    break;
                                }
                            }
                            if ((v6_1 != null) && (v6_1.getPoints() != null)) {
                                java.util.Iterator v7_0 = v6_1.getPoints().iterator();
                                while (v7_0.hasNext()) {
                                    com.boat.support.slam.entity.floors.Points v8_2 = ((com.boat.support.slam.entity.floors.Points) v7_0.next());
                                    if ((v8_2 != null) && (v8_2.getDeviceType() != 0)) {
                                        com.boat.support.slam.entity.floors.LoraInfo v9_2 = new com.boat.support.slam.entity.floors.LoraInfo();
                                        v9_2.setFloorName(v3_7.getFloorName());
                                        v9_2.setPointName(v8_2.getPointName());
                                        v9_2.setDeviceID(v8_2.getDeviceID());
                                        v9_2.setDeviceType(v8_2.getDeviceType());
                                        com.jlboat.phone.fragment.statusfragment.LoraFragment.access$100(this.this$0).add(v9_2);
                                    }
                                }
                            } else {
                                android.util.Log.d("LoraFragment", new StringBuilder().append("\u697c\u5c42").append(v3_7.getFloorName()).append("\u672a\u627e\u5230\u9ed8\u8ba4\u5730\u56fe\u6216\u65e0\u70b9\u4f4d").toString());
                            }
                        } else {
                            android.util.Log.d("LoraFragment", "\u65e0\u6548\u697c\u5c42\u6216\u65e0\u9ed8\u8ba4\u5730\u56fe\uff0c\u8df3\u8fc7");
                        }
                    }
                    android.util.Log.d("LoraFragment", new StringBuilder().append("loraInfo\uff1a").append(com.jlboat.phone.fragment.statusfragment.LoraFragment.access$100(this.this$0).toString()).toString());
                    this.this$0.getActivity().runOnUiThread(new com.jlboat.phone.fragment.statusfragment.LoraFragment$2$2(this));
                } else {
                    android.util.Log.d("LoraFragment", "localMapList\u6216floors\u4e3a\u7a7a\uff0c\u8df3\u8fc7\u7b5b\u9009");
                    return;
                }
            } else {
                return;
            }
        }
        return;
    }
}
