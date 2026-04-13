package com.jlboat.phone.activity;
public class MapExpansionActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private static final String TAG = "MapExpansionActivity";
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
    private android.os.Handler handler;
    private final int handlerDismissWaitingDialog;
    private final int handlerDismissWaitingDialogTimeOut;
    private final int handlerShowMapListDialog;
    private final int handlerShowPosintListDialog;
    private final int handlerShowWaitingDialog;
    private boolean isDialoging;
    private boolean isPause;
    private boolean isfast;
    private com.boat.support.slam.entity.floors.MapList localMapList;
    private java.util.List mGlobalPlans;
    private com.jlboat.phone.adapter.RvFloorMapListAdapter mapListAdapter;
    private int mapStatus;
    private com.jlboat.phone.view.MapView mapView;
    private android.support.v7.widget.RecyclerView map_list_ry;
    private com.jlboat.phone.adapter.RvFloorPointListAdapter naviListAdapter;
    private com.boat.jrosbridge.Topic naviTargetGoalPublish;
    private android.support.v7.widget.RecyclerView navi_list_ry;
    private android.widget.Button rebootRobot;
    private com.boat.jrosbridge.Topic setTargetGoalPublish;
    private android.widget.Button set_navi_cmd_stop;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.SpiritTopicListener spiritTopicListener;
    private android.widget.Button status_bt;
    private com.boat.jrosbridge.Topic stopNaviPublish;
    private com.jlboat.phone.view.JoystickView virtualJoystickView;
    private android.app.ProgressDialog waitingDialog;

    public MapExpansionActivity()
    {
        this.isfast = 1;
        this.isPause = 0;
        this.currentFloors = new java.util.ArrayList();
        this.currentFloorId = 0;
        this.currentMapList = new java.util.ArrayList();
        this.currentMapId = 0;
        this.currentMapPosintList = new java.util.ArrayList();
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
        this.handler = new com.jlboat.phone.activity.MapExpansionActivity$6(this);
        return;
    }

    private void SaveMap(int p10, long p11, String p13, String p14)
    {
        this.safeShowWaitingDialog(this.getResString(2131493126), this.getResString(2131493125));
        this.spiritServiceClient.saveMapService(p10, p11, p13, p14, new com.jlboat.phone.activity.MapExpansionActivity$23(this));
        return;
    }

    private void SaveMap(String p1)
    {
        return;
    }

    static synthetic long access$000(com.jlboat.phone.activity.MapExpansionActivity p2)
    {
        return p2.currentFloorId;
    }

    static synthetic long access$002(com.jlboat.phone.activity.MapExpansionActivity p0, long p1)
    {
        p0.currentFloorId = p1;
        return p1;
    }

    static synthetic long access$100(com.jlboat.phone.activity.MapExpansionActivity p2)
    {
        return p2.currentMapId;
    }

    static synthetic java.util.List access$1000(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        return p1.mGlobalPlans;
    }

    static synthetic java.util.List access$1002(com.jlboat.phone.activity.MapExpansionActivity p0, java.util.List p1)
    {
        p0.mGlobalPlans = p1;
        return p1;
    }

    static synthetic long access$102(com.jlboat.phone.activity.MapExpansionActivity p0, long p1)
    {
        p0.currentMapId = p1;
        return p1;
    }

    static synthetic java.util.List access$1100(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        return p1.currentMapList;
    }

    static synthetic java.util.List access$1102(com.jlboat.phone.activity.MapExpansionActivity p0, java.util.List p1)
    {
        p0.currentMapList = p1;
        return p1;
    }

    static synthetic java.util.List access$1200(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        return p1.currentMapPosintList;
    }

    static synthetic android.os.Handler access$1300(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        return p1.handler;
    }

    static synthetic com.jlboat.phone.communication.SpiritServiceClient access$1400(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        return p1.spiritServiceClient;
    }

    static synthetic java.util.List access$1500(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        return p1.buildMapLocalAllPoint;
    }

    static synthetic java.util.List access$1600(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        return p1.buildMapLocalNaviPoints;
    }

    static synthetic java.util.List access$1700(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        return p1.buildMapLocalSystemPoint;
    }

    static synthetic void access$1800(com.jlboat.phone.activity.MapExpansionActivity p0)
    {
        p0.safeDismissWaitingDialog();
        return;
    }

    static synthetic boolean access$1900(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        return p1.isfast;
    }

    static synthetic boolean access$1902(com.jlboat.phone.activity.MapExpansionActivity p0, boolean p1)
    {
        p0.isfast = p1;
        return p1;
    }

    static synthetic void access$200(com.jlboat.phone.activity.MapExpansionActivity p0, int p1, long p2, long p4)
    {
        p0.loadMap(p1, p2, p4);
        return;
    }

    static synthetic void access$2000(com.jlboat.phone.activity.MapExpansionActivity p0)
    {
        p0.rebuildMap();
        return;
    }

    static synthetic void access$2100(com.jlboat.phone.activity.MapExpansionActivity p0)
    {
        p0.checkClearSaveStatusButtonVisable();
        return;
    }

    static synthetic com.jlboat.phone.adapter.RvFloorMapListAdapter access$2200(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        return p1.mapListAdapter;
    }

    static synthetic com.jlboat.phone.adapter.RvFloorPointListAdapter access$2300(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        return p1.naviListAdapter;
    }

    static synthetic void access$2400(com.jlboat.phone.activity.MapExpansionActivity p0, CharSequence p1, CharSequence p2)
    {
        p0.showWaitingDialog(p1, p2);
        return;
    }

    static synthetic void access$2500(com.jlboat.phone.activity.MapExpansionActivity p0, long p1, long p3, long p5)
    {
        p0.deleteNavi(p1, p3, p5);
        return;
    }

    static synthetic void access$2600(com.jlboat.phone.activity.MapExpansionActivity p0, int p1, long p2, long p4, long p6, String p8)
    {
        p0.renamePointName(p1, p2, p4, p6, p8);
        return;
    }

    static synthetic void access$2700(com.jlboat.phone.activity.MapExpansionActivity p0, int p1, long p2, String p4, String p5)
    {
        p0.SaveMap(p1, p2, p4, p5);
        return;
    }

    static synthetic void access$2800(com.jlboat.phone.activity.MapExpansionActivity p0, long p1, String p3)
    {
        p0.addPoint(p1, p3);
        return;
    }

    static synthetic android.widget.Button access$2900(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        return p1.status_bt;
    }

    static synthetic boolean access$300(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        return p1.isDialoging;
    }

    static synthetic void access$3000(com.jlboat.phone.activity.MapExpansionActivity p0, String p1)
    {
        p0.robotSsh(p1);
        return;
    }

    static synthetic boolean access$302(com.jlboat.phone.activity.MapExpansionActivity p0, boolean p1)
    {
        p0.isDialoging = p1;
        return p1;
    }

    static synthetic void access$400(com.jlboat.phone.activity.MapExpansionActivity p0)
    {
        p0.dismissWaitingDialog();
        return;
    }

    static synthetic com.jlboat.phone.view.MapView access$500(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        return p1.mapView;
    }

    static synthetic com.boat.support.slam.entity.floors.MapList access$600(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        return p1.localMapList;
    }

    static synthetic com.boat.support.slam.entity.floors.MapList access$602(com.jlboat.phone.activity.MapExpansionActivity p0, com.boat.support.slam.entity.floors.MapList p1)
    {
        p0.localMapList = p1;
        return p1;
    }

    static synthetic java.util.List access$700(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        return p1.currentFloors;
    }

    static synthetic java.util.List access$702(com.jlboat.phone.activity.MapExpansionActivity p0, java.util.List p1)
    {
        p0.currentFloors = p1;
        return p1;
    }

    static synthetic com.boat.support.slam.entity.floors.Floors access$800(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        return p1.currentFloor;
    }

    static synthetic com.boat.support.slam.entity.floors.Floors access$802(com.jlboat.phone.activity.MapExpansionActivity p0, com.boat.support.slam.entity.floors.Floors p1)
    {
        p0.currentFloor = p1;
        return p1;
    }

    static synthetic int access$900(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        return p1.mapStatus;
    }

    static synthetic int access$902(com.jlboat.phone.activity.MapExpansionActivity p0, int p1)
    {
        p0.mapStatus = p1;
        return p1;
    }

    private void addPoint(long p3, String p5)
    {
        this.safeShowWaitingDialog(this.getResString(2131493113), this.getResString(2131493112));
        this.spiritServiceClient.addPosintServices(p3, p5, new com.jlboat.phone.activity.MapExpansionActivity$28(this));
        return;
    }

    private void checkClearSaveStatusButtonVisable()
    {
        this.runOnUiThread(new com.jlboat.phone.activity.MapExpansionActivity$30(this));
        return;
    }

    private void clearMap()
    {
        this.safeShowWaitingDialog(this.getResString(2131493116), this.getResString(2131493117));
        this.spiritServiceClient.clearMapService(new com.jlboat.phone.activity.MapExpansionActivity$21(this));
        return;
    }

    private void deleteNavi(long p12, long p14, long p16)
    {
        this.safeShowWaitingDialog(this.getResString(2131493121), this.getResString(2131493120));
        this.spiritServiceClient.deletePonsintService(p12, p14, p16, new com.jlboat.phone.activity.MapExpansionActivity$27(this));
        return;
    }

    private void dismissWaitingDialog()
    {
        if ((this.waitingDialog != null) && (this.waitingDialog.isShowing())) {
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
        this.spiritServiceClient.getCurrentPositionListener(new com.jlboat.phone.activity.MapExpansionActivity$26(this));
        return;
    }

    private void goNavito(int p5)
    {
        String v0_3 = ((com.boat.support.slam.entity.floors.Points) this.buildMapLocalNaviPoints.get(p5)).getPointName();
        this.toast(new StringBuilder().append(this.getResString(2131493246)).append(v0_3).toString());
        com.jlboat.phone.message.map_msgs.SetTargetGoal v1_4 = new com.jlboat.phone.message.map_msgs.SetTargetGoal();
        v1_4.setGoalName(v0_3);
        android.util.Log.d("MapExpansionActivity", new StringBuilder().append("goNavito: aaa ").append(v1_4.getGoalName()).toString());
        this.setTargetGoalPublish.publish(v1_4);
        return;
    }

    private void goNavito(com.boat.support.slam.entity.floors.Floors p4, com.boat.support.slam.entity.floors.Maps p5, com.boat.support.slam.entity.floors.Points p6)
    {
        this.toast(new StringBuilder().append(this.getResString(2131493246)).append("\n ").append(this.getResString(2131492995)).append(p4.getFloorName()).append("\n").append(this.getResString(2131493002)).append(p5.getMapName()).append("\n").append(this.getResString(2131493008)).append(p6.getPointName()).toString());
        com.jlboat.phone.message.map_msgs.TargetGoal v0_12 = new com.jlboat.phone.message.map_msgs.TargetGoal();
        v0_12.setFloorId(p4.getFloorId());
        v0_12.setMapId(p5.getMapId());
        v0_12.setPointId(p6.getPointId());
        android.util.Log.d("MapExpansionActivity", new StringBuilder().append("goNavito: aaa f: ").append(p4.getFloorName()).append(", m: ").append(p5.getMapName()).append(", p: ").append(p6.getPointName()).toString());
        this.naviTargetGoalPublish.publish(v0_12);
        return;
    }

    private void loadMap(int p10, long p11, long p13)
    {
        if (p10 == 0) {
            this.safeShowWaitingDialog(this.getResString(2131493115), this.getResString(2131493114));
        }
        this.spiritServiceClient.setPublishService(p10, p11, p13, new com.jlboat.phone.activity.MapExpansionActivity$8(this, p10));
        return;
    }

    private void mapAdd()
    {
        com.jlboat.phone.activity.MapExpansionActivity$17 v8_0 = new android.app.AlertDialog$Builder(this);
        android.widget.Button v9_1 = this.getLayoutInflater().inflate(2131361846, 0);
        android.widget.Button v10_0 = new int[] {0});
        android.widget.RadioGroup v12_1 = ((android.widget.RadioGroup) v9_1.findViewById(2131231168));
        android.widget.Spinner v13_1 = ((android.widget.Spinner) v9_1.findViewById(2131231258));
        android.widget.EditText v14_1 = ((android.widget.EditText) v9_1.findViewById(2131230899));
        android.widget.EditText v15_1 = ((android.widget.EditText) v9_1.findViewById(2131230900));
        android.app.AlertDialog v6_1 = ((android.widget.Button) v9_1.findViewById(2131230802));
        int[] v5_1 = ((android.widget.Button) v9_1.findViewById(2131230799));
        ((android.widget.TextView) v9_1.findViewById(2131231336)).setText(this.getResString(2131493002));
        android.widget.EditText v4_0 = new android.widget.ArrayAdapter(this, 17367048);
        com.jlboat.phone.activity.MapExpansionActivity$18 v0_24 = this.currentFloors.iterator();
        while (v0_24.hasNext()) {
            v4_0.add(((com.boat.support.slam.entity.floors.Floors) v0_24.next()).getFloorName());
        }
        v13_1.setAdapter(v4_0);
        v8_0.setView(v9_1);
        android.widget.RadioGroup v3_0 = v8_0.create();
        v12_1.setOnCheckedChangeListener(new com.jlboat.phone.activity.MapExpansionActivity$15(this, v13_1, v14_1));
        v12_1.check(2131231121);
        v13_1.setOnItemSelectedListener(new com.jlboat.phone.activity.MapExpansionActivity$16(this, v10_0));
        android.widget.EditText v2_2 = new com.jlboat.phone.activity.MapExpansionActivity$17;
        com.jlboat.phone.activity.MapExpansionActivity$17 v8_1 = v2_2;
        android.app.AlertDialog v17 = v3_0;
        android.widget.Button v9_0 = v5_1;
        android.widget.Button v10_1 = v6_1;
        v2_2(this, v14_1, v12_1, v15_1, v10_0, v17);
        v10_1.setOnClickListener(v8_1);
        android.app.AlertDialog v1_6 = v17;
        v9_0.setOnClickListener(new com.jlboat.phone.activity.MapExpansionActivity$18(this, v1_6));
        v1_6.show();
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
        v4_2.setOnClickListener(new com.jlboat.phone.activity.MapExpansionActivity$19(this, v3_2, v6_2));
        v5_2.setOnClickListener(new com.jlboat.phone.activity.MapExpansionActivity$20(this, v6_2));
        v6_2.show();
        return;
    }

    private void rebuildMap()
    {
        this.safeShowWaitingDialog(this.getResString(2131492932), "loading");
        this.spiritServiceClient.rebuildMapService(new com.jlboat.phone.activity.MapExpansionActivity$22(this));
        return;
    }

    private void renamePointName(int p14, long p15, long p17, long p19, String p21)
    {
        this.safeShowWaitingDialog(this.getResString(2131493124), p21);
        this.spiritServiceClient.renamePosintService(p14, p15, p17, p19, p21, new com.jlboat.phone.activity.MapExpansionActivity$29(this));
        return;
    }

    private void robotSsh(String p3)
    {
        android.util.Log.d("MapExpansionActivity", "onSuccess:reboot ");
        this.spiritServiceClient.robotSshService(p3, new com.jlboat.phone.activity.MapExpansionActivity$7(this));
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
        this.setTargetGoalPublish.unadvertise();
        this.naviTargetGoalPublish.unadvertise();
        this.stopNaviPublish.unadvertise();
        return;
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
            v12_1.setOnClickListener(new com.jlboat.phone.activity.MapExpansionActivity$9(this, p18, p19, v5));
            com.boat.support.slam.entity.floors.Maps v4_0 = new com.jlboat.phone.activity.MapExpansionActivity$10;
            com.jlboat.phone.activity.MapExpansionActivity$10 v7_1 = v4_0;
            android.app.AlertDialog v16 = v5;
            v4_0(this, v11_1, p18, p19, v5);
            v13_1.setOnClickListener(v7_1);
            android.app.AlertDialog v1_5 = v16;
            v14_1.setOnClickListener(new com.jlboat.phone.activity.MapExpansionActivity$11(this, v1_5));
            v1_5.show();
            return;
        } else {
            return;
        }
    }

    public void PointAndDeleteorRename(com.boat.support.slam.entity.floors.Floors p20, com.boat.support.slam.entity.floors.Maps p21, com.boat.support.slam.entity.floors.Points p22)
    {
        com.jlboat.phone.activity.MapExpansionActivity$13 v8_1 = this.getLayoutInflater().inflate(2131361852, 0);
        android.widget.TextView v9_1 = ((android.widget.TextView) v8_1.findViewById(2131231328));
        android.widget.EditText v10_1 = ((android.widget.EditText) v8_1.findViewById(2131230901));
        android.widget.Button v11_1 = ((android.widget.Button) v8_1.findViewById(2131230801));
        android.widget.Button v12_1 = ((android.widget.Button) v8_1.findViewById(2131230803));
        android.widget.Button v13_1 = ((android.widget.Button) v8_1.findViewById(2131230799));
        v8_1.findViewById(2131230805);
        v8_1.findViewById(2131230806);
        v11_1.setText(this.getResString(2131492991));
        v9_1.setText(new StringBuilder().append(this.getResString(2131492995)).append(p20.getFloorName()).append("\n").append(this.getResString(2131493002)).append(p21.getMapName()).append("\n").append(this.getResString(2131493008)).append(p22.getPointName()).append("\n").append(this.getResString(2131492993)).append("\uff1a").append(p22.getDeviceID()).append("\n").append(this.getResString(2131493020)).append("\uff1a").append(p22.getWaitPoints().toString()).toString());
        v10_1.setHint(this.getResString(2131493039));
        android.app.AlertDialog v6_0 = new android.app.AlertDialog$Builder(this);
        v6_0.setView(v8_1);
        com.boat.support.slam.entity.floors.Points v5_0 = v6_0.create();
        com.boat.support.slam.entity.floors.Floors v4_0 = new com.jlboat.phone.activity.MapExpansionActivity$12;
        android.app.AlertDialog v6_1 = v4_0;
        android.app.AlertDialog v17 = v5_0;
        v4_0(this, p20, p21, p22, v5_0);
        v11_1.setOnClickListener(v6_1);
        android.app.AlertDialog v6_2 = new com.jlboat.phone.activity.MapExpansionActivity$13;
        com.jlboat.phone.activity.MapExpansionActivity$13 v8_0 = v6_2;
        v6_2(this, v10_1, p21, p20, p22, v17);
        v12_1.setOnClickListener(v8_0);
        android.app.AlertDialog v1_3 = v17;
        v13_1.setOnClickListener(new com.jlboat.phone.activity.MapExpansionActivity$14(this, v1_3));
        v1_3.show();
        return;
    }

    public void deleteMap(long p9, long p11)
    {
        this.safeShowWaitingDialog(this.getResString(2131493121), this.getResString(2131493119));
        this.spiritServiceClient.deleteMapService(p9, p11, new com.jlboat.phone.activity.MapExpansionActivity$24(this));
        return;
    }

    public void initTopic()
    {
        this.setTargetGoalPublish = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.NaviToPointName, com.jlboat.phone.message.map_msgs.SetTargetGoal, com.jlboat.phone.application.BoatSlamApplication.client);
        this.naviTargetGoalPublish = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.naviTargetgoal, com.jlboat.phone.message.map_msgs.TargetGoal, com.jlboat.phone.application.BoatSlamApplication.client);
        this.stopNaviPublish = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.NaviStop, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client);
        this.setTargetGoalPublish.advertise();
        this.naviTargetGoalPublish.advertise();
        this.stopNaviPublish.advertise();
        this.spiritTopicListener.getInitMsg(new com.jlboat.phone.activity.MapExpansionActivity$3(this));
        this.spiritTopicListener.getWallUpdateMsg(new com.jlboat.phone.activity.MapExpansionActivity$4(this));
        this.spiritTopicListener.getMapStatus(new com.jlboat.phone.activity.MapExpansionActivity$5(this));
        return;
    }

    public void onClick(android.view.View p7)
    {
        switch (p7.getId()) {
            case 2131230753:
                this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.MapEditActivity));
                break;
            case 2131230754:
                this.addPoint(2, "\u521d\u59cb\u70b9");
                break;
            case 2131230755:
                this.addPoint(1, "\u5145\u7535\u6869");
                break;
            case 2131230757:
                this.pointAdd();
                break;
            case 2131230853:
                this.startActivity(new android.content.Intent(this, com.jlboat.phone.activity.MapCleanAreaActivity));
                break;
            case 2131231144:
                int v0_12 = new android.app.AlertDialog$Builder(this);
                v0_12.setTitle(2131493015);
                v0_12.setPositiveButton(2131493023, new com.jlboat.phone.activity.MapExpansionActivity$31(this));
                v0_12.setNegativeButton(2131493007, new com.jlboat.phone.activity.MapExpansionActivity$32(this));
                v0_12.show();
                break;
            case 2131231248:
                int v0_9 = new com.boat.jrosbridge.message.std_msgs.Int16();
                v0_9.setData(5);
                this.stopNaviPublish.publish(v0_9);
                break;
            case 2131231274:
                android.util.Log.d("MapExpansionActivity", new StringBuilder().append("onClick: \u5f53\u524d\u5730\u56fe\u72b6\u6001 ").append(this.mapStatus).toString());
                if (this.mapStatus != 0) {
                    if (this.mapStatus != 2) {
                    } else {
                        int v0_5 = 0;
                        int v1_2 = 0;
                        if ((this.buildMapLocalSystemPoint != null) && (this.buildMapLocalSystemPoint.size() > 0)) {
                            int v2_4 = this.buildMapLocalSystemPoint.iterator();
                            while (v2_4.hasNext()) {
                                com.boat.support.slam.entity.floors.Points v3_2 = ((com.boat.support.slam.entity.floors.Points) v2_4.next());
                                if (this.getResString(2131493071).equals(v3_2.getPointName())) {
                                    v0_5 = 1;
                                }
                                if (this.getResString(2131493070).equals(v3_2.getPointName())) {
                                    v1_2 = 1;
                                }
                            }
                        }
                        if (v0_5 != 0) {
                            if (v1_2 != 0) {
                                this.mapAdd();
                            } else {
                                this.toast(2131493280);
                            }
                        } else {
                            this.toast(2131493281);
                        }
                    }
                } else {
                    this.rebuildMap();
                }
                break;
            default:
        }
        return;
    }

    protected void onCreate(android.os.Bundle p3)
    {
        this.initTitleBar(2131361899, 2131492932);
        super.onCreate(p3);
        this.rebootRobot = ((android.widget.Button) this.findViewById(2131231144));
        this.rebootRobot.setOnClickListener(this);
        this.virtualJoystickView = ((com.jlboat.phone.view.JoystickView) this.findViewById(2131231359));
        this.status_bt = ((android.widget.Button) this.findViewById(2131231274));
        this.status_bt.setVisibility(8);
        this.addactionposi_button = ((android.widget.Button) this.findViewById(2131230754));
        this.set_navi_cmd_stop = ((android.widget.Button) this.findViewById(2131231248));
        this.addchong_button = ((android.widget.Button) this.findViewById(2131230755));
        this.addposin_button = ((android.widget.Button) this.findViewById(2131230757));
        this.mapView = ((com.jlboat.phone.view.MapView) this.findViewById(2131230986));
        this.map_list_ry = ((android.support.v7.widget.RecyclerView) this.findViewById(2131230985));
        this.navi_list_ry = ((android.support.v7.widget.RecyclerView) this.findViewById(2131231039));
        this.map_list_ry.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));
        this.navi_list_ry.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));
        this.mapListAdapter = new com.jlboat.phone.adapter.RvFloorMapListAdapter(this);
        this.map_list_ry.setAdapter(this.mapListAdapter);
        this.mapListAdapter.setOnclickItem(new com.jlboat.phone.activity.MapExpansionActivity$1(this));
        this.naviListAdapter = new com.jlboat.phone.adapter.RvFloorPointListAdapter(this);
        this.navi_list_ry.setAdapter(this.naviListAdapter);
        this.naviListAdapter.setOnclickItem(new com.jlboat.phone.activity.MapExpansionActivity$2(this));
        this.set_navi_cmd_stop.setOnClickListener(this);
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
        this.safeDismissWaitingDialog();
        this.isPause = 1;
        this.mapView.onStop();
        this.virtualJoystickView.onStop();
        this.stopTopic();
        return;
    }

    protected void onResume()
    {
        super.onResume();
        this.isPause = 0;
        this.mapView.onStart(this.getMyApplication());
        this.virtualJoystickView.onStart();
        this.initTopic();
        return;
    }

    public void renameMapName(long p9, long p11, String p13)
    {
        this.safeShowWaitingDialog(this.getResString(2131493123), p13);
        this.spiritServiceClient.renameMapService(p9, p11, p13, new com.jlboat.phone.activity.MapExpansionActivity$25(this));
        return;
    }
}
