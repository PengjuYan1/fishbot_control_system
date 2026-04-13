package com.jlboat.phone.communication;
public class TFPoseListener {
    String TAG;
    private org.ros.namespace.GraphName base_footprint_frame;
    private org.json.JSONArray data;
    private java.util.List doubleList;
    private com.boat.ros.geometry.FrameTransformTree frameTransformTree;
    private com.boat.ros.geometry.FrameTransform frameTransform_footprint_to_map;
    private boolean isStart;
    private org.ros.namespace.GraphName map_frame;
    private Object mutex;
    com.jlboat.phone.communication.TFPoseListener$OnCallBack onCallBack;
    com.boat.jrosbridge.Topic tfSubscriber;
    private com.boat.ros.geometry.Transform transform_footprint_to_mapTransform;
    private com.boat.ros.geometry.Vector3 vector;
    private com.boat.ros.geometry.Vector3 vectorleft;
    private com.boat.ros.geometry.Vector3 vectorright;
    private com.boat.ros.geometry.Vector3 vectortop;

    public TFPoseListener()
    {
        this.TAG = "TFPoseListener";
        this.map_frame = org.ros.namespace.GraphName.of("map");
        this.base_footprint_frame = org.ros.namespace.GraphName.of("base_footprint");
        this.frameTransformTree = new com.boat.ros.geometry.FrameTransformTree();
        this.isStart = 0;
        return;
    }

    static synthetic com.boat.ros.geometry.FrameTransformTree access$000(com.jlboat.phone.communication.TFPoseListener p1)
    {
        return p1.frameTransformTree;
    }

    static synthetic boolean access$100(com.jlboat.phone.communication.TFPoseListener p1)
    {
        return p1.isStart;
    }

    static synthetic void access$200(com.jlboat.phone.communication.TFPoseListener p0)
    {
        p0.updataPose();
        return;
    }

    private void updataPose()
    {
        try {
            this.frameTransform_footprint_to_map = this.frameTransformTree.transform(this.base_footprint_frame, this.map_frame);
        } catch (com.jlboat.phone.communication.TFPoseListener$OnCallBack v0) {
            android.util.Log.d(this.TAG, "updataPose: robot canthas tf");
        }
        if (this.frameTransform_footprint_to_map != null) {
            this.transform_footprint_to_mapTransform = this.frameTransform_footprint_to_map.getTransform();
            if (this.transform_footprint_to_mapTransform != null) {
                com.jlboat.phone.communication.TFPoseListener$OnCallBack v0_11 = new com.boat.ros.geometry.Vector3;
                v0_11(0, 0, 0);
                this.vector = v0_11;
                com.jlboat.phone.communication.TFPoseListener$OnCallBack v0_12 = new com.boat.ros.geometry.Vector3;
                v0_12(-4626637969190257951, 4596734067664517857, 0);
                this.vectorleft = v0_12;
                com.jlboat.phone.communication.TFPoseListener$OnCallBack v0_13 = new com.boat.ros.geometry.Vector3;
                v0_13(4599075939470750515, 0, 0);
                this.vectortop = v0_13;
                com.jlboat.phone.communication.TFPoseListener$OnCallBack v0_14 = new com.boat.ros.geometry.Vector3;
                v0_14(-4626998257160447590, -4626998257160447590, 0);
                this.vectorright = v0_14;
                this.doubleList = new java.util.LinkedList();
                this.doubleList.add(Double.valueOf(this.transform_footprint_to_mapTransform.apply(this.vector).getX()));
                this.doubleList.add(Double.valueOf(this.transform_footprint_to_mapTransform.apply(this.vector).getY()));
                this.doubleList.add(Double.valueOf(this.transform_footprint_to_mapTransform.apply(this.vectorleft).getX()));
                this.doubleList.add(Double.valueOf(this.transform_footprint_to_mapTransform.apply(this.vectorleft).getY()));
                this.doubleList.add(Double.valueOf(this.transform_footprint_to_mapTransform.apply(this.vectortop).getX()));
                this.doubleList.add(Double.valueOf(this.transform_footprint_to_mapTransform.apply(this.vectortop).getY()));
                this.doubleList.add(Double.valueOf(this.transform_footprint_to_mapTransform.apply(this.vectorright).getX()));
                this.doubleList.add(Double.valueOf(this.transform_footprint_to_mapTransform.apply(this.vectorright).getY()));
                this.data = new org.json.JSONArray(this.doubleList);
                if (this.onCallBack != null) {
                    this.onCallBack.onTFDataListener(this.data.toString());
                }
            }
        }
        return;
    }

    public void onStart()
    {
        this.mutex = new Object();
        this.tfSubscriber = new com.boat.jrosbridge.Topic("tf", com.boat.jrosbridge.message.tf2_msgs.TFMessage, com.jlboat.phone.application.BoatSlamApplication.client);
        this.tfSubscriber.subscribe(new com.jlboat.phone.communication.TFPoseListener$1(this));
        this.isStart = 1;
        new Thread(new com.jlboat.phone.communication.TFPoseListener$2(this)).start();
        return;
    }

    public void onStop()
    {
        this.isStart = 0;
        if (this.tfSubscriber != null) {
            this.tfSubscriber.unsubscribe();
        }
        return;
    }

    public void setListener(com.jlboat.phone.communication.TFPoseListener$OnCallBack p1)
    {
        this.onCallBack = p1;
        return;
    }
}
