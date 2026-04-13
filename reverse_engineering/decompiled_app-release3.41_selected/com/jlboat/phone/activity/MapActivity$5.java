package com.jlboat.phone.activity;
 class MapActivity$5 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;

    MapActivity$5(com.jlboat.phone.activity.MapActivity p1)
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
        android.util.Log.d("MapActivity", new StringBuilder().append("topic getMapBuildStatusMsg: ").append(v0).toString());
        android.util.Log.d("MapActivity", new StringBuilder().append("topic mapStatus: ").append(com.jlboat.phone.activity.MapActivity.access$800(this.this$0)).toString());
        com.jlboat.phone.activity.MapActivity.access$802(this.this$0, v0);
        if (com.jlboat.phone.activity.MapActivity.access$900(this.this$0) != null) {
            int v4;
            com.jlboat.phone.view.MapView vtmp13 = com.jlboat.phone.activity.MapActivity.access$900(this.this$0);
            if (v0 == 0) {
                v4 = 0;
            } else {
                v4 = 1;
            }
            vtmp13.setBuildType(v4);
        }
        com.jlboat.phone.activity.MapActivity.access$1000(this.this$0);
        if ((com.jlboat.phone.activity.MapActivity.access$800(this.this$0) == 0) && (this.this$0.iscreate)) {
            this.this$0.iscreate = 0;
            this.this$0.isFinish = 1;
            com.jlboat.phone.activity.MapActivity.access$1100(this.this$0);
        }
        return;
    }
}
