package com.jlboat.phone.activity;
public class MapActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener, android.view.View$OnLongClickListener {
    private static final String TAG = "MapActivity";
    private android.widget.Button add_virtual_wall_position_button;
    private android.widget.Button addactionposi_button;
    private android.widget.Button addchong_button;
    private android.widget.Button addposin_button;
    private java.util.List buildMapLocalAllPoint;
    private java.util.List buildMapLocalNaviPoints;
    private java.util.List buildMapLocalSystemPoint;
    private java.util.List chargingPrioritys;
    private android.widget.Button clean_manager_button;
    private com.boat.support.slam.entity.floors.Floors currentFloor;
    private long currentFloorId;
    private java.util.List currentFloors;
    private long currentMapId;
    private java.util.List currentMapList;
    private java.util.List currentMapPosintList;
    private java.util.List currentMapSystmePosintList;
    private long currentTimeMillis;
    private com.boat.jrosbridge.Topic currentposeLocationmiss;
    private android.widget.Button deleteAllMap;
    private android.app.AlertDialog$Builder dialogBuildLocation;
    private android.app.AlertDialog dialogLocation;
    private long firstTime;
    private com.boat.jrosbridge.Topic goChargePublish;
    private android.os.Handler handler;
    private final int handlerDismissWaitingDialog;
    private final int handlerDismissWaitingDialogTimeOut;
    private final int handlerGetMapImg;
    private final int handlerGetScanImg;
    private final int handlerOneSecondTimer;
    private final int handlerShowMapListDialog;
    private final int handlerShowPosintListDialog;
    private final int handlerShowWaitingDialog;
    private android.widget.TextView hardcodedValue;
    private android.widget.TextView hardcodedValue2;
    private boolean isClearMap;
    private boolean isDialoging;
    int isFinish;
    private boolean isMSg2;
    private boolean isMsg8;
    boolean iscreate;
    private com.boat.support.slam.entity.floors.MapList localMapList;
    private com.boat.jrosbridge.Topic locationStatus;
    private java.util.List mGlobalPlans;
    private com.jlboat.phone.adapter.RvFloorMapListAdapter mapListAdapter;
    private int mapStatus;
    private com.jlboat.phone.view.MapView mapView;
    private android.support.v7.widget.RecyclerView map_list_ry;
    private com.jlboat.phone.adapter.RvFloorPointListAdapter naviListAdapter;
    private com.boat.jrosbridge.Topic naviTargetGoalPublish;
    private android.support.v7.widget.RecyclerView navi_list_ry;
    private android.widget.Button rebootRobot;
    private android.widget.RelativeLayout rl;
    private android.widget.LinearLayout rlTipsLocation;
    private android.widget.LinearLayout rlTipsNavigation;
    private android.widget.Button set_move_mode_change;
    private android.widget.Button set_navi_cmd_stop;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.SpiritTopicListener spiritTopicListener;
    private android.widget.Button status_bt;
    private com.boat.jrosbridge.Topic stopNaviPublish;
    private com.boat.jrosbridge.Topic targetGoalEntryLists;
    private com.boat.jrosbridge.Topic targetGoalEntryLists2;
    private android.widget.TextView tvInitStatus;
    private android.widget.TextView tvLocationAutoLocation;
    private android.widget.TextView tvLocationQr;
    private android.widget.TextView tvLocationReLocation;
    private android.widget.TextView tvNavigationLength;
    private android.widget.TextView tvNavigationName;
    private android.widget.TextView tvNavigationStatus;
    private com.jlboat.phone.view.JoystickView virtualJoystickView;
    private android.app.ProgressDialog waitingDialog;

    public MapActivity()
    {
        this.mapStatus = -1;
        this.chargingPrioritys = new java.util.LinkedList();
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
        this.handlerOneSecondTimer = 5;
        this.handlerGetMapImg = 11;
        this.handlerGetScanImg = 12;
        this.isMsg8 = 0;
        this.isMSg2 = 0;
        this.isClearMap = 0;
        this.handler = new com.jlboat.phone.activity.MapActivity$10(this);
        this.firstTime = 0;
        return;
    }

    private void SaveMap(int p10, long p11, String p13, String p14)
    {
        this.safeShowWaitingDialog(this.getResString(2131493126), this.getResString(2131493125));
        this.spiritServiceClient.saveMapService(p10, p11, p13, p14, new com.jlboat.phone.activity.MapActivity$39(this));
        return;
    }

    static synthetic long access$000(com.jlboat.phone.activity.MapActivity p2)
    {
        return p2.currentFloorId;
    }

    static synthetic long access$002(com.jlboat.phone.activity.MapActivity p0, long p1)
    {
        p0.currentFloorId = p1;
        return p1;
    }

    static synthetic long access$100(com.jlboat.phone.activity.MapActivity p2)
    {
        return p2.currentMapId;
    }

    static synthetic void access$1000(com.jlboat.phone.activity.MapActivity p0)
    {
        p0.checkClearSaveStatusButtonVisable();
        return;
    }

    static synthetic long access$102(com.jlboat.phone.activity.MapActivity p0, long p1)
    {
        p0.currentMapId = p1;
        return p1;
    }

    static synthetic void access$1100(com.jlboat.phone.activity.MapActivity p0)
    {
        p0.clearMap();
        return;
    }

    static synthetic com.boat.support.slam.entity.floors.MapList access$1200(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.localMapList;
    }

    static synthetic com.boat.support.slam.entity.floors.MapList access$1202(com.jlboat.phone.activity.MapActivity p0, com.boat.support.slam.entity.floors.MapList p1)
    {
        p0.localMapList = p1;
        return p1;
    }

    static synthetic java.util.List access$1302(com.jlboat.phone.activity.MapActivity p0, java.util.List p1)
    {
        p0.chargingPrioritys = p1;
        return p1;
    }

    static synthetic java.util.List access$1400(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.currentFloors;
    }

    static synthetic java.util.List access$1402(com.jlboat.phone.activity.MapActivity p0, java.util.List p1)
    {
        p0.currentFloors = p1;
        return p1;
    }

    static synthetic com.boat.support.slam.entity.floors.Floors access$1500(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.currentFloor;
    }

    static synthetic com.boat.support.slam.entity.floors.Floors access$1502(com.jlboat.phone.activity.MapActivity p0, com.boat.support.slam.entity.floors.Floors p1)
    {
        p0.currentFloor = p1;
        return p1;
    }

    static synthetic java.util.List access$1600(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.mGlobalPlans;
    }

    static synthetic java.util.List access$1602(com.jlboat.phone.activity.MapActivity p0, java.util.List p1)
    {
        p0.mGlobalPlans = p1;
        return p1;
    }

    static synthetic java.util.List access$1700(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.currentMapList;
    }

    static synthetic java.util.List access$1702(com.jlboat.phone.activity.MapActivity p0, java.util.List p1)
    {
        p0.currentMapList = p1;
        return p1;
    }

    static synthetic java.util.List access$1800(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.currentMapPosintList;
    }

    static synthetic java.util.List access$1900(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.currentMapSystmePosintList;
    }

    static synthetic java.util.List access$1902(com.jlboat.phone.activity.MapActivity p0, java.util.List p1)
    {
        p0.currentMapSystmePosintList = p1;
        return p1;
    }

    static synthetic void access$200(com.jlboat.phone.activity.MapActivity p0, int p1, long p2, long p4)
    {
        p0.loadMap(p1, p2, p4);
        return;
    }

    static synthetic android.os.Handler access$2000(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.handler;
    }

    static synthetic com.jlboat.phone.communication.SpiritServiceClient access$2100(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.spiritServiceClient;
    }

    static synthetic java.util.List access$2200(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.buildMapLocalAllPoint;
    }

    static synthetic java.util.List access$2300(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.buildMapLocalNaviPoints;
    }

    static synthetic java.util.List access$2400(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.buildMapLocalSystemPoint;
    }

    static synthetic boolean access$2500(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.isMSg2;
    }

    static synthetic boolean access$2502(com.jlboat.phone.activity.MapActivity p0, boolean p1)
    {
        p0.isMSg2 = p1;
        return p1;
    }

    static synthetic long access$2600(com.jlboat.phone.activity.MapActivity p2)
    {
        return p2.currentTimeMillis;
    }

    static synthetic long access$2602(com.jlboat.phone.activity.MapActivity p0, long p1)
    {
        p0.currentTimeMillis = p1;
        return p1;
    }

    static synthetic boolean access$2700(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.isMsg8;
    }

    static synthetic boolean access$2702(com.jlboat.phone.activity.MapActivity p0, boolean p1)
    {
        p0.isMsg8 = p1;
        return p1;
    }

    static synthetic void access$2800(com.jlboat.phone.activity.MapActivity p0)
    {
        p0.safeSecond();
        return;
    }

    static synthetic android.widget.LinearLayout access$2900(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.rlTipsLocation;
    }

    static synthetic void access$300(com.jlboat.phone.activity.MapActivity p0, com.boat.support.slam.entity.floors.Floors p1, com.boat.support.slam.entity.floors.Maps p2, com.boat.support.slam.entity.floors.Points p3)
    {
        p0.goNavito(p1, p2, p3);
        return;
    }

    static synthetic android.widget.LinearLayout access$3000(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.rlTipsNavigation;
    }

    static synthetic android.widget.TextView access$3100(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.hardcodedValue;
    }

    static synthetic android.widget.TextView access$3200(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.hardcodedValue2;
    }

    static synthetic android.widget.TextView access$3300(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.tvNavigationName;
    }

    static synthetic android.widget.TextView access$3400(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.tvNavigationStatus;
    }

    static synthetic com.jlboat.phone.adapter.RvFloorMapListAdapter access$3500(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.mapListAdapter;
    }

    static synthetic com.jlboat.phone.adapter.RvFloorPointListAdapter access$3600(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.naviListAdapter;
    }

    static synthetic void access$3700(com.jlboat.phone.activity.MapActivity p0, CharSequence p1, CharSequence p2)
    {
        p0.showWaitingDialog(p1, p2);
        return;
    }

    static synthetic void access$3800(com.jlboat.phone.activity.MapActivity p0, long p1)
    {
        p0.deleteFloorWithMaps(p1);
        return;
    }

    static synthetic void access$3900(com.jlboat.phone.activity.MapActivity p0, long p1, long p3, long p5)
    {
        p0.deleteNavi(p1, p3, p5);
        return;
    }

    static synthetic android.widget.TextView access$400(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.tvNavigationLength;
    }

    static synthetic void access$4000(com.jlboat.phone.activity.MapActivity p0, int p1, long p2, long p4, long p6, com.boat.support.slam.entity.floors.Points p8)
    {
        p0.pointUpdate(p1, p2, p4, p6, p8);
        return;
    }

    static synthetic String access$4100(com.jlboat.phone.activity.MapActivity p1, com.boat.support.slam.entity.floors.Points p2)
    {
        return p1.getstring(p2);
    }

    static synthetic void access$4200(com.jlboat.phone.activity.MapActivity p0, int p1, long p2, String p4, String p5)
    {
        p0.SaveMap(p1, p2, p4, p5);
        return;
    }

    static synthetic void access$4300(com.jlboat.phone.activity.MapActivity p0, long p1, String p3)
    {
        p0.addPoint(p1, p3);
        return;
    }

    static synthetic void access$4400(com.jlboat.phone.activity.MapActivity p0)
    {
        p0.safeDismissWaitingDialog();
        return;
    }

    static synthetic android.widget.Button access$4500(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.status_bt;
    }

    static synthetic android.widget.Button access$4600(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.add_virtual_wall_position_button;
    }

    static synthetic com.boat.jrosbridge.Topic access$4700(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.locationStatus;
    }

    static synthetic com.boat.jrosbridge.Topic access$4702(com.jlboat.phone.activity.MapActivity p0, com.boat.jrosbridge.Topic p1)
    {
        p0.locationStatus = p1;
        return p1;
    }

    static synthetic void access$4800(com.jlboat.phone.activity.MapActivity p0)
    {
        p0.showLocationDialog();
        return;
    }

    static synthetic android.widget.Button access$4900(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.clean_manager_button;
    }

    static synthetic boolean access$500(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.isDialoging;
    }

    static synthetic void access$5000(com.jlboat.phone.activity.MapActivity p0, String p1)
    {
        p0.robotSsh(p1);
        return;
    }

    static synthetic boolean access$502(com.jlboat.phone.activity.MapActivity p0, boolean p1)
    {
        p0.isDialoging = p1;
        return p1;
    }

    static synthetic void access$600(com.jlboat.phone.activity.MapActivity p0)
    {
        p0.dismissWaitingDialog();
        return;
    }

    static synthetic android.widget.TextView access$700(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.tvInitStatus;
    }

    static synthetic int access$800(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.mapStatus;
    }

    static synthetic int access$802(com.jlboat.phone.activity.MapActivity p0, int p1)
    {
        p0.mapStatus = p1;
        return p1;
    }

    static synthetic com.jlboat.phone.view.MapView access$900(com.jlboat.phone.activity.MapActivity p1)
    {
        return p1.mapView;
    }

    private void addPoint(long p3, String p5)
    {
        this.safeShowWaitingDialog(this.getResString(2131493113), this.getResString(2131493112));
        this.spiritServiceClient.addPosintServices(p3, p5, new com.jlboat.phone.activity.MapActivity$48(this));
        return;
    }

    private void checkClearSaveStatusButtonVisable()
    {
        this.runOnUiThread(new com.jlboat.phone.activity.MapActivity$51(this));
        return;
    }

    private void clearMap()
    {
        this.mapView.clearPoints();
        this.isClearMap = 1;
        this.safeShowWaitingDialog(this.getResString(2131493116), this.getResString(2131493117));
        this.spiritServiceClient.clearMapService(new com.jlboat.phone.activity.MapActivity$38(this));
        return;
    }

    private void deleteFloorWithMaps(long p10)
    {
        java.util.ArrayList v0_1 = new java.util.ArrayList();
        java.util.Iterator v1_4 = this.currentFloors.iterator();
        while (v1_4.hasNext()) {
            com.boat.support.slam.entity.floors.Maps v2_0 = ((com.boat.support.slam.entity.floors.Floors) v1_4.next());
            if (v2_0.getFloorId() == p10) {
                v0_1.addAll(v2_0.getMaps());
                break;
            }
        }
        if (!v0_1.isEmpty()) {
            java.util.Iterator v1_3 = v0_1.iterator();
            while (v1_3.hasNext()) {
                com.boat.support.slam.entity.floors.Maps v2_3 = ((com.boat.support.slam.entity.floors.Maps) v1_3.next());
                this.spiritServiceClient.deleteMapService(p10, v2_3.getMapId(), new com.jlboat.phone.activity.MapActivity$40(this, v2_3));
            }
        }
        this.deleteFloor(p10);
        return;
    }

    private void deleteNavi(long p12, long p14, long p16)
    {
        this.safeShowWaitingDialog(this.getResString(2131493121), this.getResString(2131493120));
        this.spiritServiceClient.deletePonsintService(p12, p14, p16, new com.jlboat.phone.activity.MapActivity$47(this));
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
        this.spiritServiceClient.getCurrentPositionListener(new com.jlboat.phone.activity.MapActivity$46(this));
        return;
    }

    private String getstring(com.boat.support.slam.entity.floors.Points p5)
    {
        java.util.LinkedList v0_1 = new java.util.LinkedList();
        if (p5.getWaitPoints() != null) {
            int v1_1 = 1;
            while (v1_1 <= p5.getWaitPoints().size()) {
                v0_1.add(new StringBuilder().append(v1_1).append("").toString());
                v1_1++;
            }
        }
        return v0_1.toString();
    }

    private void goNavito(int p1)
    {
        return;
    }

    private void goNavito(com.boat.support.slam.entity.floors.Floors p9, com.boat.support.slam.entity.floors.Maps p10, com.boat.support.slam.entity.floors.Points p11)
    {
        com.jlboat.phone.message.map_msgs.TargetGoal v0_1 = new com.jlboat.phone.message.map_msgs.TargetGoal();
        v0_1.setFloorId(p9.getFloorId());
        v0_1.setMapId(p10.getMapId());
        v0_1.setPointId(p11.getPointId());
        android.util.Log.d("MapActivity", new StringBuilder().append("goNavito: aaa f: ").append(p9.getFloorName()).append(", m: ").append(p10.getMapName()).append(", p: ").append(p11.getPointName()).toString());
        android.util.Log.d("MapActivity", new StringBuilder().append("goNavito: aaa f: ").append(p9.getFloorId()).append(", m: ").append(p10.getMapId()).append(", p: ").append(p11.getPointId()).toString());
        this.naviTargetGoalPublish.publish(v0_1);
        return;
    }

    private void goNavitoQueue(com.boat.support.slam.entity.floors.Floors p1, com.boat.support.slam.entity.floors.Maps p2, com.boat.support.slam.entity.floors.Points p3)
    {
        return;
    }

    private void loadMap(int p10, long p11, long p13)
    {
        if (p10 == 0) {
            this.safeShowWaitingDialog(this.getResString(2131493115), this.getResString(2131493114));
        }
        this.spiritServiceClient.setPublishService(p10, p11, p13, new com.jlboat.phone.activity.MapActivity$12(this, p10));
        return;
    }

    private void mapAdd()
    {
        com.jlboat.phone.activity.MapActivity$30 v8_0 = new android.app.AlertDialog$Builder(this);
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
        v12_1.setOnCheckedChangeListener(new com.jlboat.phone.activity.MapActivity$28(this, v13_1, v14_1));
        if (this.localMapList != null) {
            v12_1.check(2131231121);
        } else {
            v12_1.check(2131231123);
            v12_1.getChildAt(0).setEnabled(0);
            v12_1.getChildAt(1).setEnabled(0);
        }
        v13_1.setOnItemSelectedListener(new com.jlboat.phone.activity.MapActivity$29(this, v10_1));
        android.widget.EditText v2_5 = new com.jlboat.phone.activity.MapActivity$30;
        com.jlboat.phone.activity.MapActivity$30 v8_1 = v2_5;
        android.app.AlertDialog v17 = v3_1;
        android.widget.Button v9_1 = v5_1;
        android.widget.Button v10_0 = v6_2;
        v2_5(this, v14_1, v12_1, v15_1, v10_1, v17);
        v10_0.setOnClickListener(v8_1);
        android.app.AlertDialog v1_0 = v17;
        v9_1.setOnClickListener(new com.jlboat.phone.activity.MapActivity$31(this, v1_0));
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
        v4_2.setOnClickListener(new com.jlboat.phone.activity.MapActivity$32(this, v3_2, v6_2));
        v5_2.setOnClickListener(new com.jlboat.phone.activity.MapActivity$33(this, v6_2));
        v6_2.show();
        return;
    }

    private void pointUpdate(int p14, long p15, long p17, long p19, com.boat.support.slam.entity.floors.Points p21)
    {
        this.safeShowWaitingDialog(this.getResString(2131493124), p21.getPointName());
        String v1_1 = new com.google.gson.Gson().toJson(p21);
        android.util.Log.d("MapActivity", new StringBuilder().append("pointUpdate: ").append(v1_1).toString());
        this.spiritServiceClient.updatePointService(p14, p15, p17, p19, v1_1, new com.jlboat.phone.activity.MapActivity$49(this));
        return;
    }

    private void renamePointName(int p14, long p15, long p17, long p19, String p21)
    {
        this.safeShowWaitingDialog(this.getResString(2131493124), p21);
        this.spiritServiceClient.renamePosintService(p14, p15, p17, p19, p21, new com.jlboat.phone.activity.MapActivity$50(this));
        return;
    }

    private void robotSsh(String p3)
    {
        android.util.Log.d("MapActivity", "onSuccess:reboot ");
        this.spiritServiceClient.robotSshService(p3, new com.jlboat.phone.activity.MapActivity$11(this));
        return;
    }

    private void safeDismissWaitingDialog()
    {
        this.handler.sendEmptyMessage(3);
        return;
    }

    private void safeSecond()
    {
        android.os.Message v0_1 = new android.os.Message();
        v0_1.what = 5;
        this.handler.sendMessage(v0_1);
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

    private void setChargingPriority()
    {
        if (this.chargingPrioritys != null) {
            android.app.AlertDialog$Builder v9 = new android.app.AlertDialog$Builder(this);
            android.view.View v10 = this.getLayoutInflater().inflate(2131361844, 0);
            android.widget.Button v12_1 = ((android.widget.Button) v10.findViewById(2131230802));
            com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter v13_1 = ((android.widget.Button) v10.findViewById(2131230799));
            ((android.widget.TextView) v10.findViewById(2131231328)).setText(this.getResString(2131492996));
            java.util.ArrayList v14 = new java.util.ArrayList();
            java.util.ArrayList v15 = new java.util.ArrayList();
            android.widget.LinearLayout v7_1 = ((android.widget.LinearLayout) v10.findViewById(2131231034));
            long v6_2 = ((android.support.v7.widget.RecyclerView) v10.findViewById(2131231031));
            com.boat.support.slam.entity.floors.Floors v5_5 = ((android.support.v7.widget.RecyclerView) v10.findViewById(2131231036));
            java.util.Iterator v4_4 = new com.jlboat.phone.adapter.MapActDlFloorListAdapter();
            v6_2.setLayoutManager(new android.support.v7.widget.GridLayoutManager(this.getMyApplication(), 6));
            v6_2.setAdapter(v4_4);
            com.jlboat.phone.activity.MapActivity$37 v3_5 = new com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter();
            v5_5.setLayoutManager(new android.support.v7.widget.GridLayoutManager(this.getMyApplication(), 6));
            v5_5.setAdapter(v3_5);
            android.app.AlertDialog v2_7 = new com.jlboat.phone.activity.MapActivity$34;
            long v11_3 = v2_7;
            android.widget.Button v17_0 = v3_5;
            com.jlboat.phone.adapter.MapActDlFloorListAdapter v18 = v4_4;
            android.support.v7.widget.RecyclerView v19 = v5_5;
            long v6_3 = v19;
            android.widget.LinearLayout v21 = v7_1;
            v2_7(this, v15, v4_4, v14, v17_0, v6_3, v7_1);
            android.widget.LinearLayout v7_2 = v17_0;
            v7_2.setOnItemClickListener(v11_3);
            long v11_4 = new com.jlboat.phone.activity.MapActivity$35;
            android.widget.Button v17_1 = v13_1;
            com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter v13_2 = v7_2;
            v11_4(this, v14, v15, v18, v7_2, v6_3, v21);
            com.jlboat.phone.adapter.MapActDlFloorListAdapter v0_33 = v18;
            v0_33.setOnItemClickListener(v11_4);
            v14.addAll(this.currentFloors);
            if (this.chargingPrioritys != null) {
                android.support.v7.widget.RecyclerView v1_3 = this.chargingPrioritys.iterator();
                while (v1_3.hasNext()) {
                    android.app.AlertDialog v2_5 = ((Long) v1_3.next()).longValue();
                    java.util.Iterator v4_3 = this.currentFloors.iterator();
                    while (v4_3.hasNext()) {
                        com.boat.support.slam.entity.floors.Floors v5_3 = ((com.boat.support.slam.entity.floors.Floors) v4_3.next());
                        if (v5_3.getFloorId() == v2_5) {
                            v15.add(v5_3);
                            break;
                        }
                    }
                }
            }
            v0_33.setData(v14, v15);
            v13_2.setData(v15);
            if (v15.size() <= 0) {
                android.support.v7.widget.RecyclerView v1_5 = v19;
                v21.setVisibility(0);
                v1_5.setVisibility(8);
            } else {
                v19.setVisibility(0);
                v21.setVisibility(8);
            }
            v9.setView(v10);
            android.app.AlertDialog v2_2 = v9.create();
            v12_1.setOnClickListener(new com.jlboat.phone.activity.MapActivity$36(this, v15, v2_2));
            v17_1.setOnClickListener(new com.jlboat.phone.activity.MapActivity$37(this, v2_2));
            v2_2.show();
            return;
        } else {
            this.toast(2131493290);
            return;
        }
    }

    private void showLocationDialog()
    {
        this.runOnUiThread(new com.jlboat.phone.activity.MapActivity$52(this));
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
        this.naviTargetGoalPublish.unadvertise();
        this.stopNaviPublish.unadvertise();
        this.goChargePublish.unadvertise();
        this.currentposeLocationmiss.unadvertise();
        return;
    }

    public void FloorAndDeleteorRename(com.boat.support.slam.entity.floors.Floors p10)
    {
        if (p10 != null) {
            android.view.View v0_1 = this.getLayoutInflater().inflate(2131361848, 0);
            android.widget.TextView v1_0 = ((android.widget.TextView) v0_1.findViewById(2131231328));
            android.widget.EditText v2_2 = ((android.widget.EditText) v0_1.findViewById(2131230901));
            android.widget.Button v3_2 = ((android.widget.Button) v0_1.findViewById(2131230801));
            android.widget.Button v4_2 = ((android.widget.Button) v0_1.findViewById(2131230803));
            android.widget.Button v5_2 = ((android.widget.Button) v0_1.findViewById(2131230799));
            v3_2.setText(this.getResString(2131492989));
            v1_0.setText(p10.getFloorName());
            v2_2.setHint(this.getResString(2131493039));
            android.app.AlertDialog$Builder v6_6 = new android.app.AlertDialog$Builder(this);
            v6_6.setView(v0_1);
            android.app.AlertDialog v7 = v6_6.create();
            v3_2.setOnClickListener(new com.jlboat.phone.activity.MapActivity$13(this, p10, v7));
            v4_2.setOnClickListener(new com.jlboat.phone.activity.MapActivity$14(this, v2_2, p10, v7));
            v5_2.setOnClickListener(new com.jlboat.phone.activity.MapActivity$15(this, v7));
            v7.show();
            return;
        } else {
            return;
        }
    }

    public void MapAndDeleteorRename(com.boat.support.slam.entity.floors.Floors p18, com.boat.support.slam.entity.floors.Maps p19)
    {
        if ((p18 != null) && (p19 != null)) {
            android.view.View v9 = this.getLayoutInflater().inflate(2131361848, 0);
            android.widget.TextView v10_1 = ((android.widget.TextView) v9.findViewById(2131231328));
            android.widget.EditText v11_1 = ((android.widget.EditText) v9.findViewById(2131230901));
            android.widget.Button v12_1 = ((android.widget.Button) v9.findViewById(2131230801));
            android.widget.Button v13_1 = ((android.widget.Button) v9.findViewById(2131230803));
            android.widget.Button v14_1 = ((android.widget.Button) v9.findViewById(2131230799));
            v12_1.setText(this.getResString(2131492990));
            v10_1.setText(new StringBuilder().append(p18.getFloorName()).append(": ").append(p19.getMapName()).toString());
            v11_1.setHint(this.getResString(2131493039));
            android.app.AlertDialog$Builder v15 = new android.app.AlertDialog$Builder(this);
            v15.setView(v9);
            android.app.AlertDialog v5 = v15.create();
            v12_1.setOnClickListener(new com.jlboat.phone.activity.MapActivity$16(this, p18, p19, v5));
            com.boat.support.slam.entity.floors.Maps v4_0 = new com.jlboat.phone.activity.MapActivity$17;
            com.jlboat.phone.activity.MapActivity$17 v7_1 = v4_0;
            android.app.AlertDialog v16 = v5;
            v4_0(this, v11_1, p18, p19, v5);
            v13_1.setOnClickListener(v7_1);
            android.app.AlertDialog v1_5 = v16;
            v14_1.setOnClickListener(new com.jlboat.phone.activity.MapActivity$18(this, v1_5));
            v1_5.show();
            return;
        } else {
            return;
        }
    }

    public void PointAndDeleteorRename(com.boat.support.slam.entity.floors.Floors p45, com.boat.support.slam.entity.floors.Maps p46, com.boat.support.slam.entity.floors.Points p47)
    {
        com.boat.support.slam.entity.floors.Points v13_17 = this.getLayoutInflater().inflate(2131361852, 0);
        android.widget.EditText v12_1 = ((android.widget.TextView) v13_17.findViewById(2131231328));
        android.widget.TextView v11_1 = ((android.widget.EditText) v13_17.findViewById(2131230907));
        android.widget.Spinner v10_1 = ((android.widget.RadioGroup) v13_17.findViewById(2131230875));
        android.widget.TextView v9_2 = ((android.widget.EditText) v13_17.findViewById(2131230898));
        android.widget.TextView v8_5 = ((android.widget.EditText) v13_17.findViewById(2131230903));
        android.widget.TextView v7_5 = ((android.widget.TextView) v13_17.findViewById(2131231101));
        android.widget.Button v6_5 = ((android.widget.EditText) v13_17.findViewById(2131230908));
        android.app.AlertDialog v5_4 = ((android.widget.Spinner) v13_17.findViewById(2131231256));
        String v4_5 = ((android.widget.Spinner) v13_17.findViewById(2131231257));
        com.jlboat.phone.activity.MapActivity v1_5 = ((android.widget.Button) v13_17.findViewById(2131230801));
        int v3_22 = ((android.widget.Button) v13_17.findViewById(2131230799));
        int v16 = ((android.widget.Button) v13_17.findViewById(2131230803));
        android.app.AlertDialog$Builder v17_1 = ((android.widget.TextView) v13_17.findViewById(2131230806));
        int[] v18_1 = ((android.widget.TextView) v13_17.findViewById(2131230793));
        String v19_2 = ((android.widget.TextView) v13_17.findViewById(2131230805));
        String v20 = this.getResources().getString(2131493070);
        String v21 = this.getResources().getString(2131493071);
        String v22 = this.getResources().getString(2131493072);
        String v0_1 = new android.widget.ArrayAdapter(this, 17367048);
        int v23 = v3_22;
        int v3_1 = new android.widget.ArrayAdapter(this, 17367048);
        v0_1.clear();
        v3_1.clear();
        android.widget.RadioGroup v24 = v13_17;
        v0_1.add(this.getResources().getString(2131493233));
        v3_1.add(this.getResources().getString(2131493234));
        android.widget.Spinner v2_4 = 0;
        com.boat.support.slam.entity.floors.Points v13_3 = this.currentFloors.iterator();
        while (v13_3.hasNext()) {
            String v26 = v2_4;
            v0_1.add(((com.boat.support.slam.entity.floors.Floors) v13_3.next()).getFloorName());
            v2_4 = v26;
        }
        android.widget.EditText v29_1;
        android.widget.EditText v30_0;
        v5_4.setAdapter(v0_1);
        v4_5.setAdapter(v3_1);
        if ((p47.getPointId() == 0) || ((p47.getBindMapId() == 0) || (p47.getBindFloorId() == 0))) {
            v29_1 = v3_1;
            v30_0 = v4_5;
        } else {
            com.boat.support.slam.entity.floors.Points v13_8 = this.currentFloors.iterator();
            while (v13_8.hasNext()) {
                android.widget.EditText v29_4;
                String v33_0;
                android.widget.EditText v30_2;
                String v32_2;
                android.widget.Button v25_4 = ((com.boat.support.slam.entity.floors.Floors) v13_8.next());
                if (v25_4.getFloorId() != p47.getBindFloorId()) {
                    v32_2 = v0_1;
                    v29_4 = v3_1;
                    v30_2 = v4_5;
                    v33_0 = v13_8;
                } else {
                    android.widget.EditText v27_6 = v25_4.getMaps().iterator();
                    while (v27_6.hasNext()) {
                        android.widget.EditText v30_3;
                        String v32_3;
                        android.widget.EditText v29_7;
                        String v33_3;
                        com.boat.support.slam.entity.floors.Maps v28_3 = ((com.boat.support.slam.entity.floors.Maps) v27_6.next());
                        if ((p47.getBindMapId() != v28_3.getMapId()) || (v28_3.getMapId() != v25_4.getDefaultmap())) {
                            v32_3 = v0_1;
                            v29_7 = v3_1;
                            v30_3 = v4_5;
                            v33_3 = v13_8;
                        } else {
                            v29_7 = v3_1;
                            v30_3 = v4_5;
                            String v4_7 = v13_8;
                            android.util.Log.e("MapActivity", new StringBuilder().append("frd.getBindPointId():").append(p47.getBindPointId()).toString());
                            int v3_19 = v28_3.getPoints().iterator();
                            while (v3_19.hasNext()) {
                                String v32_4;
                                String v33_5;
                                int v31_4;
                                if (((com.boat.support.slam.entity.floors.Points) v3_19.next()).getPointId() != p47.getBindPointId()) {
                                    v32_4 = v0_1;
                                    v31_4 = v3_19;
                                    v33_5 = v4_7;
                                } else {
                                    String v14_5 = v25_4.getFloorName();
                                    if (v14_5 == null) {
                                        v32_4 = v0_1;
                                        v31_4 = v3_19;
                                        v33_5 = v4_7;
                                    } else {
                                        v31_4 = v3_19;
                                        int v3_20 = v0_1.getPosition(v14_5);
                                        v32_4 = v0_1;
                                        v33_5 = v4_7;
                                        android.util.Log.e("MapActivity", new StringBuilder().append("floorsPosition:").append(v3_20).toString());
                                        if (v3_20 >= 0) {
                                            v5_4.setSelection(v3_20);
                                        }
                                    }
                                }
                                v3_19 = v31_4;
                                v0_1 = v32_4;
                                v4_7 = v33_5;
                            }
                            v32_3 = v0_1;
                            v33_3 = v4_7;
                        }
                        v3_1 = v29_7;
                        v4_5 = v30_3;
                        v0_1 = v32_3;
                        v13_8 = v33_3;
                    }
                    v32_2 = v0_1;
                    v29_4 = v3_1;
                    v30_2 = v4_5;
                    v33_0 = v13_8;
                }
                v3_1 = v29_4;
                v4_5 = v30_2;
                v0_1 = v32_2;
                v13_8 = v33_0;
            }
            v29_1 = v3_1;
            v30_0 = v4_5;
        }
        v1_5.setText(this.getResString(2131492991));
        v12_1.setText(new StringBuilder().append(this.getResString(2131492995)).append(p45.getFloorName()).append(" , ").append(this.getResString(2131493002)).append(p46.getMapName()).toString());
        v11_1.setText(p47.getPointName());
        v6_5.setText(p47.getCargoRegionType());
        String v14_0 = p47.getDeviceType();
        android.util.Log.d("MapActivity", new StringBuilder().append("PointAndDeleteorRename: deviceType ").append(v14_0).toString());
        v10_1.check(2131230870);
        if (v14_0 == 11) {
            v10_1.check(2131230871);
        }
        if (v14_0 == 12) {
            v10_1.check(2131230872);
        }
        if (v14_0 == 21) {
            v10_1.check(2131230873);
        }
        if (v14_0 == 22) {
            v10_1.check(2131230874);
        }
        v9_2.setText(p47.getDeviceID());
        v8_5.setText(p47.getLedWarnID());
        v7_5.setText(this.getstring(p47));
        android.widget.Spinner v2_6 = new int[] {0});
        android.widget.Button v35 = v23;
        String v14_1 = new com.jlboat.phone.activity.MapActivity$19;
        android.widget.Button v36 = v16;
        android.widget.TextView v37 = v17_1;
        android.widget.TextView v38 = v18_1;
        String[] v39 = v1_5;
        android.widget.TextView v40 = v19_2;
        android.app.AlertDialog$Builder v17_0 = v30_0;
        com.boat.support.slam.entity.floors.Points v13_11 = v5_4;
        android.widget.EditText v27_3 = v6_5;
        android.widget.TextView v41 = v7_5;
        com.boat.support.slam.entity.floors.Maps v28_0 = v8_5;
        android.widget.EditText v29_2 = v9_2;
        String[] v42 = v10_1;
        android.widget.EditText v30_1 = v11_1;
        v14_1(this, v2_6, new String[] {""}), v5_4, v29_1, v20, v21, v22, p47, p45, p46, v17_0);
        v13_11.setOnItemSelectedListener(v14_1);
        com.jlboat.phone.activity.MapActivity v1_1 = v17_0;
        String v14_2 = new String[] {""});
        v1_1.setOnItemSelectedListener(new com.jlboat.phone.activity.MapActivity$20(this, new int[] {0}), v14_2, v1_1));
        String v0_44 = new android.app.AlertDialog$Builder(this);
        v0_44.setView(v24);
        android.widget.TextView v11_3 = v0_44.create();
        android.widget.TextView v9_3 = new com.jlboat.phone.activity.MapActivity$21;
        String v0_45 = v9_3;
        v9_3(this, p45, p46, p47, v11_3);
        v39.setOnClickListener(v0_45);
        v42.setOnCheckedChangeListener(new com.jlboat.phone.activity.MapActivity$22(this, p47));
        String v0_50 = new com.jlboat.phone.activity.MapActivity$23;
        String v32_1 = v11_3;
        android.widget.Spinner v2_7 = v13_11;
        v42 = v14_2;
        android.widget.Spinner v43 = v1_1;
        v0_50(this, v30_1, v27_3, p46, p47, v2_6, v14_2, v28_0, p45, v29_2, v32_1);
        v36.setOnClickListener(v0_50);
        android.app.AlertDialog v5_2 = v32_1;
        v35.setOnClickListener(new com.jlboat.phone.activity.MapActivity$24(this, v5_2));
        android.widget.TextView v7_3 = v41;
        v40.setOnClickListener(new com.jlboat.phone.activity.MapActivity$25(this, p47, v7_3));
        v37.setOnClickListener(new com.jlboat.phone.activity.MapActivity$26(this, p47, v7_3));
        v38.setOnClickListener(new com.jlboat.phone.activity.MapActivity$27(this, v2_7, v43));
        v5_2.show();
        return;
    }

    public double calculateTrajectoryLength(java.util.List p14)
    {
        double v0 = 0;
        if (p14.size() >= 2) {
            int v2_1 = 0;
            while (v2_1 < (p14.size() - 1)) {
                com.boat.jrosbridge.message.geometry_msgs.Point v3_1 = ((com.boat.jrosbridge.message.geometry_msgs.Point) p14.get(v2_1));
                com.boat.jrosbridge.message.geometry_msgs.Point v4_2 = ((com.boat.jrosbridge.message.geometry_msgs.Point) p14.get((v2_1 + 1)));
                v0 += Math.sqrt(((Math.pow((v4_2.x - v3_1.x), 4611686018427387904) + Math.pow((v4_2.y - v3_1.y), 4611686018427387904)) + Math.pow((v4_2.z - v3_1.z), 4611686018427387904)));
                v2_1++;
            }
            return v0;
        } else {
            return 0;
        }
    }

    public void deleteAllMap()
    {
        this.safeShowWaitingDialog(this.getResString(2131492992), this.getResString(2131492987));
        this.spiritServiceClient.deleteAllMapService(new com.jlboat.phone.activity.MapActivity$43(this));
        return;
    }

    public void deleteFloor(long p3)
    {
        this.safeShowWaitingDialog(this.getResString(2131493121), this.getResString(2131493118));
        this.spiritServiceClient.deleteFloorService(p3, new com.jlboat.phone.activity.MapActivity$41(this));
        return;
    }

    public void deleteMap(long p9, long p11)
    {
        this.safeShowWaitingDialog(this.getResString(2131493121), this.getResString(2131493119));
        this.spiritServiceClient.deleteMapService(p9, p11, new com.jlboat.phone.activity.MapActivity$42(this));
        return;
    }

    public void initTopic()
    {
        this.naviTargetGoalPublish = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.naviTargetgoal, com.jlboat.phone.message.map_msgs.TargetGoal, com.jlboat.phone.application.BoatSlamApplication.client);
        this.stopNaviPublish = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.NaviStop, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client);
        this.goChargePublish = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.GoCharge, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client);
        this.currentposeLocationmiss = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.CurrentposeLocationmiss, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client);
        this.naviTargetGoalPublish.advertise();
        this.stopNaviPublish.advertise();
        this.goChargePublish.advertise();
        this.currentposeLocationmiss.advertise();
        this.spiritTopicListener.getInitMsg(new com.jlboat.phone.activity.MapActivity$4(this));
        this.spiritTopicListener.getMapStatus(new com.jlboat.phone.activity.MapActivity$5(this));
        this.spiritTopicListener.getWallUpdateMsg(new com.jlboat.phone.activity.MapActivity$6(this));
        this.spiritTopicListener.getNavigationMsg(new com.jlboat.phone.activity.MapActivity$7(this));
        this.spiritTopicListener.getAutoChargeStatusMsg(new com.jlboat.phone.activity.MapActivity$8(this));
        this.spiritTopicListener.getNaviTargetgoalList(new com.jlboat.phone.activity.MapActivity$9(this));
        return;
    }

    public void onBackPressed()
    {
        long v0 = System.currentTimeMillis();
        if (this.mapStatus == 0) {
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

    public void onClick(android.view.View p9)
    {
        switch (p9.getId()) {
            case 2131230753:
                this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.MapEditActivity));
                break;
            case 2131230754:
                this.addPoint(2, this.getResources().getString(2131493071));
                break;
            case 2131230755:
                this.addPoint(1, this.getResources().getString(2131493070));
                break;
            case 2131230757:
                this.pointAdd();
                break;
            case 2131230853:
                this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.MapCleanAreaActivity));
                break;
            case 2131230869:
                int v0_26 = new android.app.AlertDialog$Builder(this);
                v0_26.setTitle(this.getResString(2131493003));
                v0_26.setPositiveButton(2131493023, new com.jlboat.phone.activity.MapActivity$54(this));
                v0_26.setNegativeButton(2131493007, new com.jlboat.phone.activity.MapActivity$55(this));
                v0_26.show();
                break;
            case 2131231144:
                int v0_24 = new android.app.AlertDialog$Builder(this);
                v0_24.setTitle(2131493015);
                v0_24.setPositiveButton(2131493023, new com.jlboat.phone.activity.MapActivity$56(this));
                v0_24.setNegativeButton(2131493007, new com.jlboat.phone.activity.MapActivity$57(this));
                v0_24.show();
                break;
            case 2131231247:
                int v0_22 = new com.boat.jrosbridge.message.std_msgs.Int16();
                v0_22.setData(1);
                this.goChargePublish.publish(v0_22);
                break;
            case 2131231248:
                int v0_20 = new com.boat.jrosbridge.message.std_msgs.Int16();
                v0_20.setData(5);
                this.stopNaviPublish.publish(v0_20);
                break;
            case 2131231274:
                if (this.mapStatus != 1) {
                    this.clearMap();
                } else {
                    int v0_18 = 0;
                    int v1_11 = 0;
                    if ((this.buildMapLocalSystemPoint != null) && (this.buildMapLocalSystemPoint.size() > 0)) {
                        int v2_7 = this.buildMapLocalSystemPoint.iterator();
                        while (v2_7.hasNext()) {
                            com.boat.support.slam.entity.floors.Points v3_4 = ((com.boat.support.slam.entity.floors.Points) v2_7.next());
                            if (this.getResString(2131493071).equals(v3_4.getPointName())) {
                                v0_18 = 1;
                            }
                            if (this.getResString(2131493070).equals(v3_4.getPointName())) {
                                v1_11 = 1;
                            }
                        }
                    }
                    if (v0_18 != 0) {
                        if (v1_11 != 0) {
                            this.mapAdd();
                        } else {
                            this.toast(2131493280);
                        }
                    } else {
                        this.toast(2131493281);
                    }
                }
                break;
            case 2131231332:
                this.rlTipsLocation.setVisibility(8);
                this.spiritServiceClient.setScaleTestService(0, 3, new com.jlboat.phone.activity.MapActivity$53(this));
                break;
            case 2131231333:
                this.rlTipsLocation.setVisibility(8);
                int v0_14 = new com.boat.jrosbridge.message.std_msgs.Int16();
                v0_14.setData(3);
                this.currentposeLocationmiss.publish(v0_14);
                break;
            case 2131231334:
                this.rlTipsLocation.setVisibility(8);
                this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.MapRepositionActivity));
                break;
            default:
        }
        return;
    }

    public void onCreate(android.os.Bundle p3)
    {
        super.onCreate(p3);
        this.initTitleBar(2131361889, 2131493093);
        this.rebootRobot = ((android.widget.Button) this.findViewById(2131231144));
        this.rebootRobot.setOnClickListener(this);
        this.virtualJoystickView = ((com.jlboat.phone.view.JoystickView) this.findViewById(2131231359));
        this.rlTipsNavigation = ((android.widget.LinearLayout) this.findViewById(2131231185));
        this.tvNavigationName = ((android.widget.TextView) this.findViewById(2131231340));
        this.tvNavigationStatus = ((android.widget.TextView) this.findViewById(2131231341));
        this.tvNavigationLength = ((android.widget.TextView) this.findViewById(2131231339));
        this.hardcodedValue = ((android.widget.TextView) this.findViewById(2131230926));
        this.hardcodedValue2 = ((android.widget.TextView) this.findViewById(2131230927));
        this.rlTipsLocation = ((android.widget.LinearLayout) this.findViewById(2131231184));
        this.tvLocationAutoLocation = ((android.widget.TextView) this.findViewById(2131231332));
        this.tvLocationReLocation = ((android.widget.TextView) this.findViewById(2131231334));
        this.tvLocationQr = ((android.widget.TextView) this.findViewById(2131231333));
        this.status_bt = ((android.widget.Button) this.findViewById(2131231274));
        this.status_bt.setVisibility(8);
        this.addactionposi_button = ((android.widget.Button) this.findViewById(2131230754));
        this.set_move_mode_change = ((android.widget.Button) this.findViewById(2131231247));
        this.set_navi_cmd_stop = ((android.widget.Button) this.findViewById(2131231248));
        this.addchong_button = ((android.widget.Button) this.findViewById(2131230755));
        this.addposin_button = ((android.widget.Button) this.findViewById(2131230757));
        this.add_virtual_wall_position_button = ((android.widget.Button) this.findViewById(2131230753));
        this.clean_manager_button = ((android.widget.Button) this.findViewById(2131230853));
        this.deleteAllMap = ((android.widget.Button) this.findViewById(2131230869));
        this.mapView = ((com.jlboat.phone.view.MapView) this.findViewById(2131230986));
        this.tvInitStatus = ((android.widget.TextView) this.findViewById(2131231331));
        this.map_list_ry = ((android.support.v7.widget.RecyclerView) this.findViewById(2131230985));
        this.navi_list_ry = ((android.support.v7.widget.RecyclerView) this.findViewById(2131231039));
        this.map_list_ry.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));
        this.navi_list_ry.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));
        this.mapListAdapter = new com.jlboat.phone.adapter.RvFloorMapListAdapter(this);
        this.map_list_ry.setAdapter(this.mapListAdapter);
        this.mapListAdapter.setOnclickItem(new com.jlboat.phone.activity.MapActivity$1(this));
        this.naviListAdapter = new com.jlboat.phone.adapter.RvFloorPointListAdapter(this);
        this.navi_list_ry.setAdapter(this.naviListAdapter);
        this.naviListAdapter.setOnclickItem(new com.jlboat.phone.activity.MapActivity$2(this));
        this.set_move_mode_change.setOnClickListener(this);
        this.set_navi_cmd_stop.setOnClickListener(this);
        this.addactionposi_button.setOnClickListener(this);
        this.addchong_button.setOnClickListener(this);
        this.addchong_button.setOnLongClickListener(this);
        this.deleteAllMap.setOnClickListener(this);
        this.tvLocationAutoLocation.setOnClickListener(this);
        this.tvLocationReLocation.setOnClickListener(this);
        this.tvLocationQr.setOnClickListener(this);
        this.status_bt.setOnClickListener(this);
        this.add_virtual_wall_position_button.setOnClickListener(this);
        this.clean_manager_button.setOnClickListener(this);
        this.addposin_button.setOnClickListener(this);
        return;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        return;
    }

    public boolean onLongClick(android.view.View p2)
    {
        switch (p2.getId()) {
            case 2131230755:
                return 1;
            default:
                return 0;
        }
    }

    protected void onPause()
    {
        super.onPause();
        if (this.handler.hasMessages(11)) {
            this.handler.removeMessages(11);
        }
        if (this.handler.hasMessages(12)) {
            this.handler.removeMessages(12);
        }
        this.mapView.onStop();
        this.mapView.setNavigationPathCallBack(0);
        this.virtualJoystickView.onStop();
        this.stopTopic();
        return;
    }

    protected void onResume()
    {
        super.onResume();
        this.rlTipsNavigation.setVisibility(8);
        this.mapView.onStart(this.getMyApplication());
        this.mapView.setNavigationPathCallBack(new com.jlboat.phone.activity.MapActivity$3(this));
        this.virtualJoystickView.onStart();
        this.initTopic();
        this.handler.sendEmptyMessage(11);
        this.handler.sendEmptyMessage(12);
        return;
    }

    protected void onStart()
    {
        super.onStart();
        this.iscreate = this.getIntent().getBooleanExtra("isCreate", 0);
        return;
    }

    public void renameFloorName(long p3, String p5)
    {
        this.safeShowWaitingDialog(this.getResString(2131493122), p5);
        this.spiritServiceClient.renameFloorService(p3, p5, new com.jlboat.phone.activity.MapActivity$44(this));
        return;
    }

    public void renameMapName(long p9, long p11, String p13)
    {
        this.safeShowWaitingDialog(this.getResString(2131493123), p13);
        this.spiritServiceClient.renameMapService(p9, p11, p13, new com.jlboat.phone.activity.MapActivity$45(this));
        return;
    }
}
