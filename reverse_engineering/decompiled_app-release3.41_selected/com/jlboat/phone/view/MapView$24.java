package com.jlboat.phone.view;
 class MapView$24 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.view.MapView this$0;

    MapView$24(com.jlboat.phone.view.MapView p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.nav_msgs.Path) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.nav_msgs.Path p8)
    {
        com.jlboat.phone.view.MapView.access$1902(this.this$0, new java.util.LinkedList());
        new com.boat.jrosbridge.message.geometry_msgs.Point();
        com.jlboat.phone.view.MapView v1_9 = p8.getPoses();
        com.jlboat.phone.view.MapView$24$1 v2_3 = v1_9.length;
        int v3 = 0;
        while (v3 < v2_3) {
            com.jlboat.phone.view.MapView.access$1900(this.this$0).add(v1_9[v3].getPose().getPosition());
            v3++;
        }
        if ((com.jlboat.phone.view.MapView.access$1900(this.this$0) != null) && (com.jlboat.phone.view.MapView.access$1900(this.this$0).size() > 0)) {
            com.jlboat.phone.view.MapView.access$2002(this.this$0, 1);
            this.this$0.post(new com.jlboat.phone.view.MapView$24$1(this));
        }
        return;
    }
}
