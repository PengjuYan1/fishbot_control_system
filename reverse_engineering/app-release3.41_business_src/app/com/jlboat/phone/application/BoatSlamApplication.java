package com.jlboat.phone.application;
public class BoatSlamApplication extends com.boat.base.BaseApplication {
    public static String CANCLEPOINTNAME = "";
    public static final String TAG = "BoatSlamApplication";
    public static java.util.List activities;
    public static final String[] bugTopic;
    public static int change;
    public static String classis_carto_version_name;
    public static String classis_channel;
    public static String classis_driver_version_name;
    public static int classis_numero;
    public static int classis_version_code;
    public static String classis_version_name;
    public static com.boat.jrosbridge.rosbridge.ROSBridgeClient client;
    public static int coco_num;
    public static int coco_num_pc;
    public static String displayName;
    public static String download_uri;
    public static String end_ip;
    public static java.util.List errList;
    public static String gateway_ip;
    public static boolean hasHeart;
    public static boolean has_nav_info;
    public static String hostAddress;
    public static boolean isShutDown;
    public static com.jlboat.phone.application.BoatSlamApplication mApplication;
    public static String mapApiGetMap;
    public static String mapApiGetScan;
    public static int power;
    public static String ros2_ip;
    public static String ros_ip;
    public static String ros_uri;
    public static String ros_url;
    public static String route_ip;
    public static String ssid;
    public static String wsros_uri;

    static BoatSlamApplication()
    {
        com.jlboat.phone.application.BoatSlamApplication.route_ip = "10.7.5";
        com.jlboat.phone.application.BoatSlamApplication.gateway_ip = new StringBuilder().append(com.jlboat.phone.application.BoatSlamApplication.route_ip).append(".1").toString();
        com.jlboat.phone.application.BoatSlamApplication.end_ip = ".88";
        com.jlboat.phone.application.BoatSlamApplication.ros_ip = new StringBuilder().append(com.jlboat.phone.application.BoatSlamApplication.route_ip).append(com.jlboat.phone.application.BoatSlamApplication.end_ip).toString();
        com.jlboat.phone.application.BoatSlamApplication.ros2_ip = new StringBuilder().append(com.jlboat.phone.application.BoatSlamApplication.route_ip).append(".80").toString();
        com.jlboat.phone.application.BoatSlamApplication.wsros_uri = new StringBuilder().append("ws://").append(com.jlboat.phone.application.BoatSlamApplication.ros_ip).append(":9090/").toString();
        com.jlboat.phone.application.BoatSlamApplication.ros_url = new StringBuilder().append("http://").append(com.jlboat.phone.application.BoatSlamApplication.ros_ip).append(":5000/").toString();
        com.jlboat.phone.application.BoatSlamApplication.ros_uri = new StringBuilder().append("http://").append(com.jlboat.phone.application.BoatSlamApplication.ros_ip).append(":11311/").toString();
        com.jlboat.phone.application.BoatSlamApplication.download_uri = new StringBuilder().append("http://").append(com.jlboat.phone.application.BoatSlamApplication.ros_ip).append(":9999/").toString();
        com.jlboat.phone.application.BoatSlamApplication.mapApiGetMap = new StringBuilder().append(com.jlboat.phone.application.BoatSlamApplication.ros_url).append("spirit/api/get_map_img").toString();
        com.jlboat.phone.application.BoatSlamApplication.mapApiGetScan = new StringBuilder().append(com.jlboat.phone.application.BoatSlamApplication.ros_url).append("spirit/api/get_scan_img").toString();
        com.jlboat.phone.application.BoatSlamApplication.displayName = "";
        com.jlboat.phone.application.BoatSlamApplication.hostAddress = "";
        com.jlboat.phone.application.BoatSlamApplication.classis_version_code = 0;
        com.jlboat.phone.application.BoatSlamApplication.classis_version_name = "";
        com.jlboat.phone.application.BoatSlamApplication.classis_numero = 0;
        com.jlboat.phone.application.BoatSlamApplication.classis_channel = "";
        com.jlboat.phone.application.BoatSlamApplication.classis_driver_version_name = "";
        com.jlboat.phone.application.BoatSlamApplication.classis_carto_version_name = "";
        com.jlboat.phone.application.BoatSlamApplication.coco_num = 0;
        com.jlboat.phone.application.BoatSlamApplication.coco_num_pc = 0;
        com.jlboat.phone.application.BoatSlamApplication.power = 0;
        com.jlboat.phone.application.BoatSlamApplication.change = -1;
        com.jlboat.phone.application.BoatSlamApplication.hasHeart = 1;
        com.jlboat.phone.application.BoatSlamApplication.isShutDown = 0;
        com.jlboat.phone.application.BoatSlamApplication.ssid = "";
        com.jlboat.phone.application.BoatSlamApplication.errList = new java.util.ArrayList();
        com.jlboat.phone.application.BoatSlamApplication.activities = new java.util.ArrayList();
        com.jlboat.phone.application.BoatSlamApplication.bugTopic = new String[] {"/imu/data", "/scan", "/raw_odom", "/tf", "/tf_static"});
        com.jlboat.phone.application.BoatSlamApplication.client = new com.boat.jrosbridge.rosbridge.ROSBridgeClient(com.jlboat.phone.application.BoatSlamApplication.wsros_uri);
        com.jlboat.phone.application.BoatSlamApplication.CANCLEPOINTNAME = "c_j_x_line_point";
        return;
    }

    public BoatSlamApplication()
    {
        return;
    }

    public static void cancelNetWorkManager()
    {
        android.net.ConnectivityManager.setProcessDefaultNetwork(0);
        return;
    }

    public static void clearDefaultNetwork()
    {
        if (android.os.Build$VERSION.SDK_INT >= 23) {
            ((android.net.ConnectivityManager) com.jlboat.phone.application.BoatSlamApplication.mApplication.getSystemService("connectivity")).bindProcessToNetwork(0);
        }
        return;
    }

    public static boolean is18()
    {
        if ((!com.jlboat.phone.application.BoatSlamApplication.classis_channel.equals("086000000302")) && ((!com.jlboat.phone.application.BoatSlamApplication.classis_channel.equals("086000000204")) && (!com.jlboat.phone.application.BoatSlamApplication.classis_channel.equals("086000000702")))) {
            int v0_3 = 0;
        } else {
            v0_3 = 1;
        }
        return v0_3;
    }

    public static void setDefaultNetwork()
    {
        android.net.ConnectivityManager v0_2 = ((android.net.ConnectivityManager) com.jlboat.phone.application.BoatSlamApplication.mApplication.getSystemService("connectivity"));
        if (android.os.Build$VERSION.SDK_INT < 23) {
            android.util.Log.d("BoatSlamApplication", "Android version below Marshmallow.");
        } else {
            String v1_1 = v0_2.getAllNetworks();
            String v2_0 = v1_1.length;
            String v4_0 = 0;
            while (v4_0 < v2_0) {
                String v5 = v1_1[v4_0];
                android.net.NetworkCapabilities v6 = v0_2.getNetworkCapabilities(v5);
                if (v6 != null) {
                    android.util.Log.d("BoatSlamApplication", new StringBuilder().append("Network: ").append(v5.toString()).toString());
                    if (v6.hasTransport(3)) {
                        v0_2.bindProcessToNetwork(v5);
                        android.util.Log.d("BoatSlamApplication", new StringBuilder().append("Default network set to ETHER: ").append(v5.toString()).toString());
                        return;
                    }
                }
                v4_0++;
            }
            android.util.Log.d("BoatSlamApplication", "No suitable network found for binding.");
        }
        return;
    }

    public static void setNetWorkManager()
    {
        android.net.ConnectivityManager v0_2 = ((android.net.ConnectivityManager) com.jlboat.phone.application.BoatSlamApplication.mApplication.getSystemService("connectivity"));
        android.net.NetworkRequest$Builder v1_2 = new android.net.NetworkRequest$Builder();
        android.util.Log.i("test", "\u8bbe\u7f6e\u8ddf\u5e95\u76d8\u901a\u8baf\u4e3a\u6709\u7ebf\u7f51\u7edc\u63a5\u53e3\uff01");
        v1_2.addTransportType(3);
        v0_2.requestNetwork(v1_2.build(), new com.jlboat.phone.application.BoatSlamApplication$1(v0_2));
        return;
    }

    protected void attachBaseContext(android.content.Context p1)
    {
        super.attachBaseContext(p1);
        return;
    }

    public bridge synthetic com.boat.controller.AppController initController()
    {
        return this.initController();
    }

    public com.jlboat.phone.controller.SlamAppController initController()
    {
        com.jlboat.phone.application.BoatSlamApplication.mApplication = this;
        return new com.jlboat.phone.controller.SlamAppController(this);
    }
}
