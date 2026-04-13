package com.jlboat.phone;
public class LoginActivity extends android.support.v7.app.AppCompatActivity implements android.view.View$OnClickListener {
    private static final int LOCATION_PERM = 101;
    private static final String TAG = "LoginActivity";
    int actionCode;
    private android.widget.CheckBox agreement_cb;
    private android.widget.Button connectButton;
    int count;
    private boolean diyIp;
    private android.widget.EditText et_end_ip;
    private android.widget.EditText et_route;
    private long firstTime;
    boolean isConnecting;
    boolean isdestory;
    private android.widget.ImageView iv_icon;
    private android.widget.LinearLayout ll_login_ip;
    public android.content.Context mContext;
    String[] permissions;
    public android.content.BroadcastReceiver receiver;
    long time;

    public LoginActivity()
    {
        this.permissions = new String[] {"android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_FINE_LOCATION"});
        this.isdestory = 0;
        this.firstTime = 0;
        this.count = 0;
        this.time = 0;
        this.receiver = new com.jlboat.phone.LoginActivity$1(this);
        return;
    }

    static synthetic void access$000(com.jlboat.phone.LoginActivity p0)
    {
        p0.login();
        return;
    }

    private void checkLogin()
    {
        if (this.diyIp) {
            com.jlboat.phone.application.BoatSlamApplication.route_ip = this.et_route.getText().toString();
            com.jlboat.phone.application.BoatSlamApplication.end_ip = this.et_end_ip.getText().toString();
            com.jlboat.phone.application.BoatSlamApplication.ros_ip = new StringBuilder().append(com.jlboat.phone.application.BoatSlamApplication.route_ip).append(com.jlboat.phone.application.BoatSlamApplication.end_ip).toString();
            com.jlboat.phone.application.BoatSlamApplication.wsros_uri = new StringBuilder().append("ws://").append(com.jlboat.phone.application.BoatSlamApplication.ros_ip).append(":9090/").toString();
            com.jlboat.phone.application.BoatSlamApplication.ros_url = new StringBuilder().append("http://").append(com.jlboat.phone.application.BoatSlamApplication.ros_ip).append(":5000/").toString();
            com.jlboat.phone.application.BoatSlamApplication.ros_uri = new StringBuilder().append("http://").append(com.jlboat.phone.application.BoatSlamApplication.ros_ip).append(":11311/").toString();
            com.jlboat.phone.application.BoatSlamApplication.download_uri = new StringBuilder().append("http://").append(com.jlboat.phone.application.BoatSlamApplication.ros_ip).append(":9999/").toString();
            com.jlboat.phone.application.BoatSlamApplication.mapApiGetMap = new StringBuilder().append(com.jlboat.phone.application.BoatSlamApplication.ros_url).append("spirit/api/get_map_img").toString();
            com.jlboat.phone.application.BoatSlamApplication.mapApiGetScan = new StringBuilder().append(com.jlboat.phone.application.BoatSlamApplication.ros_url).append("spirit/api/get_scan_img").toString();
            com.jlboat.phone.application.BoatSlamApplication.client = new com.boat.jrosbridge.rosbridge.ROSBridgeClient(com.jlboat.phone.application.BoatSlamApplication.wsros_uri);
            android.content.Intent v1_2 = this.getSharedPreferences("user_mes", 0).edit();
            v1_2.putString("route_ip", this.et_route.getText().toString());
            v1_2.putString("end_ip", this.et_end_ip.getText().toString());
            v1_2.commit();
        }
        android.util.Log.d("LoginActivity", new StringBuilder().append("login: route_ip: ").append(com.jlboat.phone.application.BoatSlamApplication.route_ip).append(" , end_ip: ").append(com.jlboat.phone.application.BoatSlamApplication.end_ip).append(" , ros_ip: ").append(com.jlboat.phone.application.BoatSlamApplication.ros_ip).append(" , ros_url: ").append(com.jlboat.phone.application.BoatSlamApplication.ros_url).toString());
        boolean v0_20 = com.jlboat.phone.util.Utils.hasRosWifi();
        android.util.Log.d("LoginActivity", new StringBuilder().append("checkLogin: \u662f\u5426\u68c0\u67e5\u5230ros\u7f51\u7edc ").append(v0_20).toString());
        if ((!v0_20) && (!this.diyIp)) {
            this.toast(2131493308);
            this.startActivity(new android.content.Intent("android.settings.WIFI_SETTINGS"));
        } else {
            this.setNetWorkManager1(1);
        }
        return;
    }

    private void login()
    {
        android.content.Intent v0_1 = new android.content.Intent(this, com.jlboat.phone.service.ErrorMsgService);
        if (android.os.Build$VERSION.SDK_INT < 26) {
            this.startService(v0_1);
        } else {
            this.startForegroundService(v0_1);
        }
        return;
    }

    private void setW4FS()
    {
        this.getWindow().setFlags(1024, 1024);
        this.getWindow().addFlags(128);
        if (android.os.Build$VERSION.SDK_INT >= 28) {
            int v0_2 = this.getWindow().getAttributes();
            v0_2.layoutInDisplayCutoutMode = 1;
            this.getWindow().setAttributes(v0_2);
        }
        this.getWindow().getDecorView().setSystemUiVisibility((this.getWindow().getDecorView().getSystemUiVisibility() | 1028));
        return;
    }

    public boolean checkPermissionAllGranted(String[] p6)
    {
        int v2 = 0;
        while (v2 < p6.length) {
            if (android.support.v4.content.ContextCompat.checkSelfPermission(this, p6[v2]) == 0) {
                v2++;
            } else {
                return 0;
            }
        }
        return 1;
    }

    public void onClick(android.view.View p9)
    {
        if (p9.getId() == 2131230991) {
            if (this.agreement_cb.isChecked()) {
                long v0_6 = System.currentTimeMillis();
                if ((v0_6 - this.firstTime) <= 2000) {
                    this.toast(2131493271);
                    return;
                } else {
                    this.firstTime = v0_6;
                    if (!this.isConnecting) {
                        if (this.checkPermissionAllGranted(this.permissions)) {
                            this.checkLogin();
                        } else {
                            this.requestPermissions_(this.permissions);
                        }
                    } else {
                        this.toast(2131493272);
                        return;
                    }
                }
            } else {
                this.toast(2131492967);
            }
        }
        if (p9.getId() == 2131230943) {
            long v0_3 = System.currentTimeMillis();
            if ((v0_3 - this.time) >= 800) {
                this.count = 1;
            } else {
                this.count = (this.count + 1);
            }
            this.time = v0_3;
            if (this.count >= 3) {
                this.count = 0;
                this.ll_login_ip.setVisibility(0);
                this.diyIp = 1;
                android.content.SharedPreferences v2_13 = this.getSharedPreferences("user_mes", 0);
                String v3_5 = v2_13.getString("route_ip", 0);
                String v4_3 = v2_13.getString("end_ip", 0);
                if (v3_5 != null) {
                    this.et_route.setText(v3_5);
                }
                if (v4_3 != null) {
                    this.et_end_ip.setText(v4_3);
                }
            }
        }
        return;
    }

    public void onCreate(android.os.Bundle p3)
    {
        super.onCreate(p3);
        this.setContentView(2131361886);
        this.setW4FS();
        this.mContext = this;
        this.iv_icon = ((android.widget.ImageView) this.findViewById(2131230943));
        this.connectButton = ((android.widget.Button) this.findViewById(2131230991));
        this.agreement_cb = ((android.widget.CheckBox) this.findViewById(2131230759));
        this.ll_login_ip = ((android.widget.LinearLayout) this.findViewById(2131230969));
        this.et_route = ((android.widget.EditText) this.findViewById(2131230909));
        this.et_end_ip = ((android.widget.EditText) this.findViewById(2131230902));
        this.iv_icon.setOnClickListener(this);
        this.connectButton.setOnClickListener(this);
        android.content.IntentFilter v0_19 = new android.content.IntentFilter();
        v0_19.addAction("login_succ");
        v0_19.addAction("login_re");
        this.registerReceiver(this.receiver, v0_19);
        return;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        this.unregisterReceiver(this.receiver);
        return;
    }

    public void onRequestPermissionsResult(int p5, String[] p6, int[] p7)
    {
        super.onRequestPermissionsResult(p5, p6, p7);
        if (p5 == 101) {
            int v0_1 = 1;
            String v2_1 = 0;
            while (v2_1 < p7.length) {
                if (p7[v2_1] == 0) {
                    v2_1++;
                } else {
                    v0_1 = 0;
                    break;
                }
            }
            if (v0_1 != 0) {
                android.util.Log.e("LoginActivity", "onRequestPermissionsResult: \u81ea\u52a8\u767b\u5f55");
                this.checkLogin();
            } else {
                this.openAppDetails("null");
            }
        }
        return;
    }

    protected void onResume()
    {
        super.onResume();
        this.setNetWorkManager1(0);
        this.isConnecting = 0;
        if (!this.isdestory) {
            if (this.getIntent() != null) {
                boolean v1_1 = this.getIntent().getBooleanExtra("needLogin", 0);
                this.actionCode = this.getIntent().getIntExtra("loginAction", 0);
                if (v1_1) {
                    if (this.checkPermissionAllGranted(this.permissions)) {
                        this.checkLogin();
                    } else {
                        this.requestPermissions_(this.permissions);
                    }
                    this.isdestory = 1;
                }
            }
            return;
        } else {
            try {
                boolean v0_5 = new android.content.Intent(this, com.jlboat.phone.service.ErrorMsgService);
                v0_5.setAction("stop");
                this.startService(v0_5);
            } catch (boolean v0_6) {
                v0_6.printStackTrace();
            }
            this.finish();
            return;
        }
    }

    protected void onStart()
    {
        super.onStart();
        return;
    }

    public void openAppDetails(String p4)
    {
        android.app.AlertDialog$Builder v0_1 = new android.app.AlertDialog$Builder(this);
        v0_1.setMessage("\u7533\u8bf7\u5931\u8d25: \u60a8\u5df2\u62d2\u7edd\u6743\u9650, \u9700\u8981\u5b9a\u4f4d\u6743\u9650\uff0c\u8bf7\u5230 \u201c\u5e94\u7528\u4fe1\u606f -> \u6743\u9650\u201d \u4e2d\u6388\u4e88\uff01");
        v0_1.setPositiveButton("\u53bb\u624b\u52a8\u6388\u6743", new com.jlboat.phone.LoginActivity$6(this));
        v0_1.setNegativeButton("\u53d6\u6d88", 0);
        v0_1.show();
        return;
    }

    public void requestPermissions_(String[] p2)
    {
        android.support.v4.app.ActivityCompat.requestPermissions(this, p2, 101);
        return;
    }

    public void setNetWorkManager1(boolean p7)
    {
        this.isConnecting = 1;
        android.net.ConnectivityManager v0_3 = ((android.net.ConnectivityManager) com.jlboat.phone.application.BoatSlamApplication.mApplication.getSystemService("connectivity"));
        android.net.NetworkRequest$Builder v1_2 = new android.net.NetworkRequest$Builder();
        v1_2.addCapability(12);
        v1_2.addTransportType(0);
        try {
            v0_3.requestNetwork(v1_2.build(), new com.jlboat.phone.LoginActivity$2(this, v0_3));
        } catch (Thread v4_0) {
            v4_0.printStackTrace();
        }
        new Thread(new com.jlboat.phone.LoginActivity$3(this, p7)).start();
        return;
    }

    public void setNetWorkManager2(boolean p7)
    {
        android.net.ConnectivityManager v0_2 = ((android.net.ConnectivityManager) com.jlboat.phone.application.BoatSlamApplication.mApplication.getSystemService("connectivity"));
        android.net.NetworkRequest$Builder v1_2 = new android.net.NetworkRequest$Builder();
        v1_2.addTransportType(1);
        try {
            v0_2.requestNetwork(v1_2.build(), new com.jlboat.phone.LoginActivity$4(this, v0_2, p7));
        } catch (Exception v4) {
            v4.printStackTrace();
            this.isConnecting = 0;
        }
        return;
    }

    public void showagreement(android.view.View p7)
    {
        android.widget.ScrollView v0_1 = new android.widget.ScrollView(this);
        v0_1.setBackgroundColor(this.getResources().getColor(2131034166));
        android.widget.TextView v1_3 = new android.widget.TextView(this);
        v1_3.setText(android.text.Html.fromHtml(this.getResources().getString(2131493394)));
        v1_3.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        v1_3.setPadding(10, 0, 0, 0);
        v0_1.addView(v1_3);
        new android.app.AlertDialog$Builder(this, 2131558754).setTitle(this.getResources().getString(2131493393)).setView(v0_1).create().show();
        return;
    }

    public void toast(int p4)
    {
        String v0 = String.valueOf(p4);
        if (v0.length() > 5) {
            v0 = this.getResources().getString(p4);
        }
        this.toast(v0);
        return;
    }

    public void toast(String p2)
    {
        this.runOnUiThread(new com.jlboat.phone.LoginActivity$5(this, p2));
        return;
    }
}
