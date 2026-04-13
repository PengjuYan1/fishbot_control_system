package com.jlboat.phone.activity;
 class MapExpansionActivity$5 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapExpansionActivity this$0;

    MapExpansionActivity$5(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int16) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int16 p6)
    {
        short v0 = p6.getData();
        android.util.Log.d("MapExpansionActivity", new StringBuilder().append("topic getMapBuildStatusMsg: ").append(v0).toString());
        if ((com.jlboat.phone.activity.MapExpansionActivity.access$900(this.this$0) != 2) || (v0 != 0)) {
            com.jlboat.phone.activity.MapExpansionActivity.access$902(this.this$0, v0);
            if (com.jlboat.phone.activity.MapExpansionActivity.access$500(this.this$0) != null) {
                int v4;
                com.jlboat.phone.view.MapView vtmp10 = com.jlboat.phone.activity.MapExpansionActivity.access$500(this.this$0);
                if (v0 == 0) {
                    v4 = 0;
                } else {
                    v4 = 1;
                }
                vtmp10.setBuildType(v4);
            }
            if (com.jlboat.phone.activity.MapExpansionActivity.access$1900(this.this$0)) {
                if (com.jlboat.phone.activity.MapExpansionActivity.access$900(this.this$0) == 2) {
                    com.jlboat.phone.activity.MapExpansionActivity.access$1902(this.this$0, 0);
                } else {
                    com.jlboat.phone.activity.MapExpansionActivity.access$2000(this.this$0);
                    return;
                }
            }
            com.jlboat.phone.activity.MapExpansionActivity.access$2100(this.this$0);
            return;
        } else {
            com.jlboat.phone.activity.MapExpansionActivity.access$1800(this.this$0);
            com.jlboat.phone.activity.MapExpansionActivity.access$902(this.this$0, v0);
            this.this$0.finish();
            return;
        }
    }
}
