package com.jlboat.phone.communication;
public class PathLayerLisener {
    String TAG;
    com.jlboat.phone.communication.PathLayerLisener$OnDataCallBack onDataCallBack;
    com.boat.jrosbridge.Topic pathlayer;

    public PathLayerLisener()
    {
        this.TAG = "PathLayerLisener";
        return;
    }

    public void onStart()
    {
        this.pathlayer = new com.boat.jrosbridge.Topic("visualization_marker", com.boat.jrosbridge.message.visualization_msgs.Marker, com.jlboat.phone.application.BoatSlamApplication.client);
        this.pathlayer.subscribe(new com.jlboat.phone.communication.PathLayerLisener$1(this));
        return;
    }

    public void onStop()
    {
        if (this.pathlayer != null) {
            this.pathlayer.unsubscribe();
        }
        return;
    }

    public void setListener(com.jlboat.phone.communication.PathLayerLisener$OnDataCallBack p1)
    {
        this.onDataCallBack = p1;
        return;
    }
}
