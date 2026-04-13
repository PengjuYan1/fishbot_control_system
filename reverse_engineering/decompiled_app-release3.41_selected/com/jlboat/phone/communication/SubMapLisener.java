package com.jlboat.phone.communication;
public class SubMapLisener {
    final int[] a;
    com.jlboat.phone.communication.SubMapLisener$OnDataCallBack onDataCallBack;
    boolean status;
    boolean 第一次进来;

    public SubMapLisener()
    {
        this.a = new int[] {0, 0, 0, 0});
        this.第一次进来 = 1;
        this.status = 0;
        return;
    }

    static synthetic void access$000(com.jlboat.phone.communication.SubMapLisener p0, cartographer_ros_msgs.SubmapList p1)
    {
        p0.pubSubmapList(p1);
        return;
    }

    static synthetic void access$100(com.jlboat.phone.communication.SubMapLisener p0)
    {
        p0.checkIsGetAllMapEnd();
        return;
    }

    static synthetic void access$200(com.jlboat.phone.communication.SubMapLisener p0, int p1, int p2, java.util.List p3)
    {
        p0.pubSubmap(p1, p2, p3);
        return;
    }

    private void checkIsGetAllMapEnd()
    {
        if (this.a[0] == this.a[1]) {
            android.util.Log.d("SubMapLisener", new StringBuilder().append("checkIsGetAllMapEnd: \u8bf7\u6c42\u5931\u8d25\u5b50\u56fe\u6570\u91cf: ").append(this.a[3]).toString());
        }
        return;
    }

    public static void d(String p2, String p3)
    {
        int v0_1 = (2001 - p2.length());
        while (p3.length() > v0_1) {
            android.util.Log.d(p2, p3.substring(0, v0_1));
            p3 = p3.substring(v0_1);
        }
        android.util.Log.d(p2, p3);
        return;
    }

    private void pubSubmap(int p1, int p2, java.util.List p3)
    {
        return;
    }

    private void pubSubmapList(cartographer_ros_msgs.SubmapList p1)
    {
        return;
    }

    public void onStart()
    {
        com.boat.jrosbridge.Service v0_0 = this.a;
        com.boat.jrosbridge.Topic v1_0 = this.a;
        com.jlboat.phone.communication.SubMapLisener$1 v2_1 = this.a;
        this.a[3] = 0;
        v2_1[2] = 0;
        v1_0[1] = 0;
        v0_0[0] = 0;
        this.第一次进来 = 1;
        com.boat.jrosbridge.Service v0_2 = new com.boat.jrosbridge.Service("/submap_query", cartographer_ros_msgs.SubmapQueryRequest, cartographer_ros_msgs.SubmapQueryResponse, com.jlboat.phone.application.BoatSlamApplication.client);
        com.boat.jrosbridge.Topic v1_3 = new com.boat.jrosbridge.Topic("/submap_list", cartographer_ros_msgs.SubmapList, com.jlboat.phone.application.BoatSlamApplication.client);
        v1_3.subscribe(new com.jlboat.phone.communication.SubMapLisener$1(this, v1_3, v0_2));
        return;
    }

    public void setOnDataCallBack(com.jlboat.phone.communication.SubMapLisener$OnDataCallBack p1)
    {
        this.onDataCallBack = p1;
        return;
    }
}
