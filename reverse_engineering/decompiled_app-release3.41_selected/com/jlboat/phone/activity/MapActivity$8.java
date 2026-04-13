package com.jlboat.phone.activity;
 class MapActivity$8 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;

    MapActivity$8(com.jlboat.phone.activity.MapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int16) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int16 p9)
    {
        if (com.jlboat.phone.activity.MapActivity.access$1200(this.this$0) != null) {
            java.util.Iterator v0_1 = com.jlboat.phone.activity.MapActivity.access$1200(this.this$0).getFloors().iterator();
            while (v0_1.hasNext()) {
                com.boat.support.slam.entity.floors.Floors v1_2 = ((com.boat.support.slam.entity.floors.Floors) v0_1.next());
                if (v1_2.getFloorId() == com.jlboat.phone.activity.MapActivity.access$000(this.this$0)) {
                    java.util.Iterator v0_4 = v1_2.getMaps().iterator();
                    while (v0_4.hasNext()) {
                        if (((com.boat.support.slam.entity.floors.Maps) v0_4.next()).getMapId() == com.jlboat.phone.activity.MapActivity.access$100(this.this$0)) {
                            this.this$0.runOnUiThread(new com.jlboat.phone.activity.MapActivity$8$1(this, v1_2));
                        }
                    }
                }
            }
        }
        return;
    }
}
