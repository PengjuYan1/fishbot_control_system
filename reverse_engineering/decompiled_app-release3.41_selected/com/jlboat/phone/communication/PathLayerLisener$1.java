package com.jlboat.phone.communication;
 class PathLayerLisener$1 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.communication.PathLayerLisener this$0;

    PathLayerLisener$1(com.jlboat.phone.communication.PathLayerLisener p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.visualization_msgs.Marker) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.visualization_msgs.Marker p8)
    {
        if ((p8 != null) && (p8.getPoints().length >= 1)) {
            java.util.LinkedList v0_3 = new java.util.LinkedList();
            org.json.JSONArray v1_3 = p8.getPoints();
            com.jlboat.phone.communication.PathLayerLisener$OnDataCallBack v2_0 = v1_3.length;
            String v3_0 = 0;
            while (v3_0 < v2_0) {
                com.boat.jrosbridge.message.geometry_msgs.Point v4 = v1_3[v3_0];
                v0_3.add(Double.valueOf(v4.getX()));
                v0_3.add(Double.valueOf(v4.getY()));
                v3_0++;
            }
            org.json.JSONArray v1_1 = new org.json.JSONArray(v0_3);
            if (this.this$0.onDataCallBack != null) {
                this.this$0.onDataCallBack.onPathLayerListener(v1_1.toString());
            }
            return;
        } else {
            return;
        }
    }
}
