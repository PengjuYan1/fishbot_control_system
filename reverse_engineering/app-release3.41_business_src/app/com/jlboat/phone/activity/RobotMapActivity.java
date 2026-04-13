package com.jlboat.phone.activity;
public class RobotMapActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private static final String TAG = "RobotMapActivity";
    private static int mapStatus;
    private android.widget.Button addactionposi_button;
    private android.widget.Button addchong_button;
    private android.widget.Button addposin_button;
    private java.util.List buildMapLocalAllPoint;
    private java.util.List buildMapLocalNaviPoints;
    private java.util.List buildMapLocalSystemPoint;
    private boolean cdw;
    private com.boat.support.slam.entity.floors.Floors currentFloor;
    private long currentFloorId;
    private java.util.List currentFloors;
    private long currentMapId;
    private java.util.List currentMapList;
    private java.util.List currentMapPosintList;
    private java.util.List currentMapSystmePosintList;
    private long firstTime;
    private android.os.Handler handler;
    private final int handlerDismissWaitingDialog;
    private final int handlerDismissWaitingDialogTimeOut;
    private final int handlerShowMapListDialog;
    private final int handlerShowPosintListDialog;
    private final int handlerShowWaitingDialog;
    private boolean isDialoging;
    private com.boat.support.slam.entity.floors.MapList localMapList;
    private com.jlboat.phone.adapter.RvFloorMapListAdapter mapListAdapter;
    private com.jlboat.phone.view.MapView mapView;
    private android.support.v7.widget.RecyclerView map_list_ry;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.SpiritTopicListener spiritTopicListener;
    private android.widget.Button status_bt;
    private com.jlboat.phone.view.JoystickView virtualJoystickView;
    private android.app.ProgressDialog waitingDialog;

    public RobotMapActivity()
    {
        this.currentFloors = new java.util.ArrayList();
        this.currentFloorId = 0;
        this.currentMapList = new java.util.ArrayList();
        this.currentMapId = 0;
        this.currentMapPosintList = new java.util.ArrayList();
        this.currentMapSystmePosintList = new java.util.ArrayList();
        this.buildMapLocalAllPoint = new java.util.LinkedList();
        this.buildMapLocalNaviPoints = new java.util.LinkedList();
        this.buildMapLocalSystemPoint = new java.util.LinkedList();
        this.isDialoging = 0;
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        this.spiritTopicListener = new com.jlboat.phone.communication.SpiritTopicListener();
        this.handlerShowMapListDialog = 1;
        this.handlerShowWaitingDialog = 2;
        this.handlerDismissWaitingDialog = 3;
        this.handlerDismissWaitingDialogTimeOut = 31;
        this.handlerShowPosintListDialog = 4;
        this.cdw = 0;
        this.handler = new com.jlboat.phone.activity.RobotMapActivity$5(this);
        this.firstTime = 0;
        return;
    }

    private void SaveMap(int p10, long p11, String p13, String p14)
    {
        this.safeShowWaitingDialog(this.getResString(2131493126), this.getResString(2131493125));
        this.spiritServiceClient.saveMapService(p10, p11, p13, p14, new com.jlboat.phone.activity.RobotMapActivity$15(this));
        return;
    }

    static synthetic long access$000(com.jlboat.phone.activity.RobotMapActivity p2)
    {
        return p2.currentFloorId;
    }

    static synthetic long access$002(com.jlboat.phone.activity.RobotMapActivity p0, long p1)
    {
        p0.currentFloorId = p1;
        return p1;
    }

    static synthetic long access$100(com.jlboat.phone.activity.RobotMapActivity p2)
    {
        return p2.currentMapId;
    }

    static synthetic java.util.List access$1000(com.jlboat.phone.activity.RobotMapActivity p1)
    {
        return p1.currentMapList;
    }

    static synthetic java.util.List access$1002(com.jlboat.phone.activity.RobotMapActivity p0, java.util.List p1)
    {
        p0.currentMapList = p1;
        return p1;
    }

    static synthetic long access$102(com.jlboat.phone.activity.RobotMapActivity p0, long p1)
    {
        p0.currentMapId = p1;
        return p1;
    }

    static synthetic java.util.List access$1100(com.jlboat.phone.activity.RobotMapActivity p1)
    {
        return p1.currentMapPosintList;
    }

    static synthetic java.util.List access$1200(com.jlboat.phone.activity.RobotMapActivity p1)
    {
        return p1.currentMapSystmePosintList;
    }

    static synthetic java.util.List access$1202(com.jlboat.phone.activity.RobotMapActivity p0, java.util.List p1)
    {
        p0.currentMapSystmePosintList = p1;
        return p1;
    }

    static synthetic android.os.Handler access$1300(com.jlboat.phone.activity.RobotMapActivity p1)
    {
        return p1.handler;
    }

    static synthetic com.jlboat.phone.communication.SpiritServiceClient access$1400(com.jlboat.phone.activity.RobotMapActivity p1)
    {
        return p1.spiritServiceClient;
    }

    static synthetic java.util.List access$1500(com.jlboat.phone.activity.RobotMapActivity p1)
    {
        return p1.buildMapLocalAllPoint;
    }

    static synthetic java.util.List access$1600(com.jlboat.phone.activity.RobotMapActivity p1)
    {
        return p1.buildMapLocalNaviPoints;
    }

    static synthetic java.util.List access$1700(com.jlboat.phone.activity.RobotMapActivity p1)
    {
        return p1.buildMapLocalSystemPoint;
    }

    static synthetic void access$1800(com.jlboat.phone.activity.RobotMapActivity p0)
    {
        p0.checkClearSaveStatusButtonVisable();
        return;
    }

    static synthetic com.jlboat.phone.adapter.RvFloorMapListAdapter access$1900(com.jlboat.phone.activity.RobotMapActivity p1)
    {
        return p1.mapListAdapter;
    }

    static synthetic void access$200(com.jlboat.phone.activity.RobotMapActivity p0, int p1, long p2, long p4)
    {
        p0.loadMap(p1, p2, p4);
        return;
    }

    static synthetic void access$2000(com.jlboat.phone.activity.RobotMapActivity p0, CharSequence p1, CharSequence p2)
    {
        p0.showWaitingDialog(p1, p2);
        return;
    }

    static synthetic void access$2100(com.jlboat.phone.activity.RobotMapActivity p0, int p1, long p2, String p4, String p5)
    {
        p0.SaveMap(p1, p2, p4, p5);
        return;
    }

    static synthetic void access$2200(com.jlboat.phone.activity.RobotMapActivity p0, long p1, String p3)
    {
        p0.addPoint(p1, p3);
        return;
    }

    static synthetic void access$2300(com.jlboat.phone.activity.RobotMapActivity p0)
    {
        p0.safeDismissWaitingDialog();
        return;
    }

    static synthetic void access$2400(com.jlboat.phone.activity.RobotMapActivity p0)
    {
        p0.clearMap();
        return;
    }

    static synthetic android.widget.Button access$2500(com.jlboat.phone.activity.RobotMapActivity p1)
    {
        return p1.status_bt;
    }

    static synthetic boolean access$300(com.jlboat.phone.activity.RobotMapActivity p1)
    {
        return p1.isDialoging;
    }

    static synthetic boolean access$302(com.jlboat.phone.activity.RobotMapActivity p0, boolean p1)
    {
        p0.isDialoging = p1;
        return p1;
    }

    static synthetic void access$400(com.jlboat.phone.activity.RobotMapActivity p0)
    {
        p0.dismissWaitingDialog();
        return;
    }

    static synthetic com.jlboat.phone.view.MapView access$500(com.jlboat.phone.activity.RobotMapActivity p1)
    {
        return p1.mapView;
    }

    static synthetic com.boat.support.slam.entity.floors.MapList access$600(com.jlboat.phone.activity.RobotMapActivity p1)
    {
        return p1.localMapList;
    }

    static synthetic com.boat.support.slam.entity.floors.MapList access$602(com.jlboat.phone.activity.RobotMapActivity p0, com.boat.support.slam.entity.floors.MapList p1)
    {
        p0.localMapList = p1;
        return p1;
    }

    static synthetic java.util.List access$700(com.jlboat.phone.activity.RobotMapActivity p1)
    {
        return p1.currentFloors;
    }

    static synthetic java.util.List access$702(com.jlboat.phone.activity.RobotMapActivity p0, java.util.List p1)
    {
        p0.currentFloors = p1;
        return p1;
    }

    static synthetic com.boat.support.slam.entity.floors.Floors access$800(com.jlboat.phone.activity.RobotMapActivity p1)
    {
        return p1.currentFloor;
    }

    static synthetic com.boat.support.slam.entity.floors.Floors access$802(com.jlboat.phone.activity.RobotMapActivity p0, com.boat.support.slam.entity.floors.Floors p1)
    {
        p0.currentFloor = p1;
        return p1;
    }

    static synthetic int access$900()
    {
        return com.jlboat.phone.activity.RobotMapActivity.mapStatus;
    }

    static synthetic int access$902(int p0)
    {
        com.jlboat.phone.activity.RobotMapActivity.mapStatus = p0;
        return p0;
    }

    private void addPoint(long p3, String p5)
    {
        this.safeShowWaitingDialog(this.getResString(2131493113), this.getResString(2131493112));
        this.spiritServiceClient.addPosintServices(p3, p5, new com.jlboat.phone.activity.RobotMapActivity$20(this));
        return;
    }

    private void checkClearSaveStatusButtonVisable()
    {
        this.runOnUiThread(new com.jlboat.phone.activity.RobotMapActivity$22(this));
        return;
    }

    private void clearMap()
    {
        this.safeShowWaitingDialog(this.getResString(2131493116), this.getResString(2131493117));
        this.spiritServiceClient.clearMapService(new com.jlboat.phone.activity.RobotMapActivity$14(this));
        return;
    }

    private void deleteNavi(String p11)
    {
        this.safeShowWaitingDialog(this.getResString(2131493121), this.getResString(2131493120));
        this.spiritServiceClient.deletePonsintService(this.localMapList.getDefaultFloor(), this.currentMapId, Long.parseLong(p11), new com.jlboat.phone.activity.RobotMapActivity$19(this));
        return;
    }

    private void dismissWaitingDialog()
    {
        if (this.waitingDialog != null) {
            this.waitingDialog.dismiss();
            this.waitingDialog = 0;
        }
        if (this.handler.hasMessages(31)) {
            this.handler.removeMessages(31);
        }
        return;
    }

    private void getLocation()
    {
        this.spiritServiceClient.getCurrentPositionListener(new com.jlboat.phone.activity.RobotMapActivity$18(this));
        return;
    }

    private void loadMap(int p10, long p11, long p13)
    {
        if (p10 == 0) {
            this.safeShowWaitingDialog(this.getResString(2131493115), this.getResString(2131493114));
        }
        this.spiritServiceClient.setPublishService(p10, p11, p13, new com.jlboat.phone.activity.RobotMapActivity$7(this, p10));
        return;
    }

    private void mapAdd()
    {
        com.jlboat.phone.activity.RobotMapActivity$10 v8_0 = new android.app.AlertDialog$Builder(this);
        android.widget.Button v9_0 = this.getLayoutInflater().inflate(2131361846, 0);
        android.widget.Button v10_1 = new int[] {0});
        android.widget.RadioGroup v12_1 = ((android.widget.RadioGroup) v9_0.findViewById(2131231168));
        android.widget.Spinner v13_1 = ((android.widget.Spinner) v9_0.findViewById(2131231258));
        android.widget.EditText v14_1 = ((android.widget.EditText) v9_0.findViewById(2131230899));
        android.widget.EditText v15_1 = ((android.widget.EditText) v9_0.findViewById(2131230900));
        android.app.AlertDialog v6_2 = ((android.widget.Button) v9_0.findViewById(2131230802));
        int[] v5_1 = ((android.widget.Button) v9_0.findViewById(2131230799));
        ((android.widget.TextView) v9_0.findViewById(2131231336)).setText(this.getResString(2131493002));
        android.widget.EditText v4_0 = new android.widget.ArrayAdapter(this, 17367048);
        android.app.AlertDialog v1_21 = this.currentFloors.iterator();
        while (v1_21.hasNext()) {
            v4_0.add(((com.boat.support.slam.entity.floors.Floors) v1_21.next()).getFloorName());
        }
        v13_1.setAdapter(v4_0);
        v8_0.setView(v9_0);
        android.widget.RadioGroup v3_1 = v8_0.create();
        v12_1.setOnCheckedChangeListener(new com.jlboat.phone.activity.RobotMapActivity$8(this, v13_1, v14_1));
        if (this.localMapList != null) {
            v12_1.check(2131231121);
        } else {
            v12_1.check(2131231123);
            v12_1.getChildAt(0).setEnabled(0);
            v12_1.getChildAt(1).setEnabled(0);
        }
        v13_1.setOnItemSelectedListener(new com.jlboat.phone.activity.RobotMapActivity$9(this, v10_1));
        android.widget.EditText v2_5 = new com.jlboat.phone.activity.RobotMapActivity$10;
        com.jlboat.phone.activity.RobotMapActivity$10 v8_1 = v2_5;
        android.app.AlertDialog v17 = v3_1;
        android.widget.Button v9_1 = v5_1;
        android.widget.Button v10_0 = v6_2;
        v2_5(this, v14_1, v12_1, v15_1, v10_1, v17);
        v10_0.setOnClickListener(v8_1);
        android.app.AlertDialog v1_0 = v17;
        v9_1.setOnClickListener(new com.jlboat.phone.activity.RobotMapActivity$11(this, v1_0));
        v1_0.show();
        return;
    }

    private void pointAdd()
    {
        android.app.AlertDialog$Builder v0_1 = new android.app.AlertDialog$Builder(this);
        android.view.View v1_1 = this.getLayoutInflater().inflate(2131361851, 0);
        android.widget.EditText v3_2 = ((android.widget.EditText) v1_1.findViewById(2131230901));
        android.widget.Button v4_2 = ((android.widget.Button) v1_1.findViewById(2131230802));
        android.widget.Button v5_2 = ((android.widget.Button) v1_1.findViewById(2131230799));
        ((android.widget.TextView) v1_1.findViewById(2131231328)).setText(this.getResString(2131493008));
        v0_1.setView(v1_1);
        android.app.AlertDialog v6_2 = v0_1.create();
        v4_2.setOnClickListener(new com.jlboat.phone.activity.RobotMapActivity$12(this, v3_2, v6_2));
        v5_2.setOnClickListener(new com.jlboat.phone.activity.RobotMapActivity$13(this, v6_2));
        v6_2.show();
        return;
    }

    private void renamePointName(int p14, long p15, long p17, long p19, String p21)
    {
        this.safeShowWaitingDialog(this.getResString(2131493124), p21);
        this.spiritServiceClient.renamePosintService(p14, p15, p17, p19, p21, new com.jlboat.phone.activity.RobotMapActivity$21(this));
        return;
    }

    private void robotSsh(String p3)
    {
        android.util.Log.d("RobotMapActivity", "onSuccess:reboot ");
        this.spiritServiceClient.robotSshService(p3, new com.jlboat.phone.activity.RobotMapActivity$6(this));
        return;
    }

    private void safeDismissWaitingDialog()
    {
        this.handler.sendEmptyMessage(3);
        return;
    }

    private void safeShowWaitingDialog(CharSequence p4, CharSequence p5)
    {
        android.os.Message v0_1 = new android.os.Message();
        v0_1.what = 2;
        android.os.Handler v1_2 = new Object[2];
        v1_2[0] = p4;
        v1_2[1] = p5;
        v0_1.obj = v1_2;
        this.handler.sendMessage(v0_1);
        return;
    }

    private void showWaitingDialog(CharSequence p3, CharSequence p4)
    {
        this.waitingDialog = android.app.ProgressDialog.show(this, p3, p4, 1);
        this.waitingDialog.setProgressStyle(0);
        return;
    }

    private void stopTopic()
    {
        return;
    }

    public void deleteAllMap()
    {
        this.safeShowWaitingDialog(this.getResString(2131492992), this.getResString(2131492987));
        this.spiritServiceClient.deleteAllMapService(new com.jlboat.phone.activity.RobotMapActivity$17(this));
        return;
    }

    public void deleteMap(String p9)
    {
        this.safeShowWaitingDialog(this.getResString(2131493121), this.getResString(2131493119));
        this.spiritServiceClient.deleteMapService(this.localMapList.getDefaultFloor(), Long.parseLong(p9), new com.jlboat.phone.activity.RobotMapActivity$16(this));
        return;
    }

    public void initTopic()
    {
        this.spiritTopicListener.getInitMsg(new com.jlboat.phone.activity.RobotMapActivity$2(this));
        this.spiritTopicListener.getWallUpdateMsg(new com.jlboat.phone.activity.RobotMapActivity$3(this));
        this.spiritTopicListener.getMapStatus(new com.jlboat.phone.activity.RobotMapActivity$4(this));
        return;
    }

    public void onBackPressed()
    {
        long v0 = System.currentTimeMillis();
        if (com.jlboat.phone.activity.RobotMapActivity.mapStatus == 0) {
            super.onBackPressed();
        } else {
            if ((v0 - this.firstTime) <= 2000) {
                super.onBackPressed();
            } else {
                this.toast(2131493279);
                this.firstTime = v0;
            }
        }
        return;
    }

    public void onClick(android.view.View p7)
    {
        switch (p7.getId()) {
            case 2131230754:
                this.addPoint(2, "\u521d\u59cb\u70b9");
                break;
            case 2131230755:
                this.addPoint(1, "\u5145\u7535\u6869");
                break;
            case 2131230757:
                this.pointAdd();
                break;
            case 2131231274:
                if (com.jlboat.phone.activity.RobotMapActivity.mapStatus != 1) {
                    this.clearMap();
                } else {
                    int v0_2 = 0;
                    int v1_1 = 0;
                    if ((this.buildMapLocalSystemPoint != null) && (this.buildMapLocalSystemPoint.size() > 0)) {
                        int v2_3 = this.buildMapLocalSystemPoint.iterator();
                        while (v2_3.hasNext()) {
                            com.boat.support.slam.entity.floors.Points v3_2 = ((com.boat.support.slam.entity.floors.Points) v2_3.next());
                            if (this.getResString(2131493071).equals(v3_2.getPointName())) {
                                v0_2 = 1;
                            }
                            if (this.getResString(2131493070).equals(v3_2.getPointName())) {
                                v1_1 = 1;
                            }
                        }
                    }
                    if (v0_2 != 0) {
                        if (v1_1 != 0) {
                            this.mapAdd();
                        } else {
                            this.toast(2131493280);
                        }
                    } else {
                        this.toast(2131493281);
                    }
                }
                break;
            default:
        }
        return;
    }

    public void onCreate(android.os.Bundle p3)
    {
        super.onCreate(p3);
        this.initTitleBar(2131361931, 2131493093);
        this.virtualJoystickView = ((com.jlboat.phone.view.JoystickView) this.findViewById(2131231359));
        this.status_bt = ((android.widget.Button) this.findViewById(2131231274));
        this.status_bt.setVisibility(8);
        this.addactionposi_button = ((android.widget.Button) this.findViewById(2131230754));
        this.addchong_button = ((android.widget.Button) this.findViewById(2131230755));
        this.addposin_button = ((android.widget.Button) this.findViewById(2131230757));
        this.mapView = ((com.jlboat.phone.view.MapView) this.findViewById(2131230986));
        this.map_list_ry = ((android.support.v7.widget.RecyclerView) this.findViewById(2131230985));
        this.map_list_ry.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));
        this.mapListAdapter = new com.jlboat.phone.adapter.RvFloorMapListAdapter(this);
        this.map_list_ry.setAdapter(this.mapListAdapter);
        this.mapListAdapter.setOnclickItem(new com.jlboat.phone.activity.RobotMapActivity$1(this));
        this.addactionposi_button.setOnClickListener(this);
        this.addchong_button.setOnClickListener(this);
        this.status_bt.setOnClickListener(this);
        this.addposin_button.setOnClickListener(this);
        return;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        return;
    }

    protected void onPause()
    {
        super.onPause();
        this.mapView.onStop();
        this.virtualJoystickView.onStop();
        this.stopTopic();
        return;
    }

    protected void onResume()
    {
        super.onResume();
        this.mapView.setRobot(1);
        this.mapView.onStart(this.getMyApplication());
        this.virtualJoystickView.onStart();
        this.initTopic();
        return;
    }

    public void renameMapName(String p2, String p3)
    {
        this.safeShowWaitingDialog(this.getResString(2131493123), p3);
        return;
    }
}
