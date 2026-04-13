package com.jlboat.phone.activity;
public class DiyPointPathActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private static final String TAG = "DiyPointPathActivity";
    private android.widget.Button btAddPoint;
    private android.widget.Button btCancel;
    private android.widget.Button btLineDefConfig;
    private android.widget.Button bt_add_start_p;
    private android.widget.Button bt_navi_dpp_stop;
    private int defDirection;
    private float defSpeed;
    private int defType;
    private float defWeight;
    private long firstTimeAddNgline;
    private long firstTimeaddPoint;
    private com.boat.support.slam.entity.floors.Floors floor;
    private android.os.Handler handler;
    private final int handlerDismissWaitingDialog;
    private final int handlerShowMapListDialog;
    private final int handlerShowPosintListDialog;
    private final int handlerShowWaitingDialog;
    private boolean hasDefConfig;
    private boolean isAutoPoint;
    private boolean isSreenModel;
    private android.widget.ImageView iv_mark_diy;
    private android.widget.RadioGroup linePointModeRadioGroup_pp;
    private java.util.List linesList;
    private java.util.LinkedList linkedListId;
    private android.widget.LinearLayout ll_bt_cs_p;
    private com.boat.support.slam.entity.floors.Maps map;
    private com.jlboat.phone.view.MapView mapView;
    private com.boat.jrosbridge.Topic nGlobalPlanTopicTalk;
    private com.jlboat.phone.adapter.NaviListAdapter naviListAdapter;
    private com.boat.jrosbridge.Topic naviTargetGoalPublish;
    private android.support.v7.widget.RecyclerView navi_list_ry;
    private com.jlboat.phone.adapter.NgLineListAdapter ngLineListAdapter;
    private java.util.List ngNlines;
    private android.support.v7.widget.RecyclerView ng_list_ry;
    private com.boat.support.slam.entity.floors.Lines pathPoint;
    private long pathPointId;
    private java.util.List pointList;
    private java.util.List points;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.SpiritTopicListener spiritTopicListener;
    private com.jlboat.phone.communication.StatusServiceClient statusServiceClient;
    private com.boat.jrosbridge.Topic stopNaviPublish;
    private android.widget.Switch sw_divp_isauto_point;
    private android.widget.Switch sw_divp_isshow_pointid;
    private int timeout;
    private com.jlboat.phone.view.JoystickView virtualJoystickView;

    public DiyPointPathActivity()
    {
        this.statusServiceClient = new com.jlboat.phone.communication.StatusServiceClient();
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        this.spiritTopicListener = new com.jlboat.phone.communication.SpiritTopicListener();
        this.isSreenModel = 1;
        this.handlerShowMapListDialog = 1;
        this.handlerShowWaitingDialog = 2;
        this.handlerDismissWaitingDialog = 3;
        this.handlerShowPosintListDialog = 4;
        this.points = new java.util.LinkedList();
        this.pointList = new java.util.LinkedList();
        this.ngNlines = new java.util.LinkedList();
        this.linesList = new java.util.LinkedList();
        this.linkedListId = new java.util.LinkedList();
        this.hasDefConfig = 0;
        this.defType = -1;
        this.defDirection = -1;
        this.defSpeed = -1082130432;
        this.defWeight = -1082130432;
        this.pathPointId = -1;
        this.firstTimeAddNgline = 0;
        this.timeout = 1200;
        this.handler = new com.jlboat.phone.activity.DiyPointPathActivity$1(this);
        return;
    }

    static synthetic android.widget.Switch access$000(com.jlboat.phone.activity.DiyPointPathActivity p1)
    {
        return p1.sw_divp_isshow_pointid;
    }

    static synthetic java.util.List access$100(com.jlboat.phone.activity.DiyPointPathActivity p1)
    {
        return p1.pointList;
    }

    static synthetic void access$1000(com.jlboat.phone.activity.DiyPointPathActivity p0, com.boat.support.slam.entity.floors.Floors p1, com.boat.support.slam.entity.floors.Maps p2, com.boat.support.slam.entity.floors.Points p3)
    {
        p0.goNavito(p1, p2, p3);
        return;
    }

    static synthetic java.util.List access$102(com.jlboat.phone.activity.DiyPointPathActivity p0, java.util.List p1)
    {
        p0.pointList = p1;
        return p1;
    }

    static synthetic void access$1100(com.jlboat.phone.activity.DiyPointPathActivity p0, double p1, String p3, double p4, double p6, double p8)
    {
        p0.updatePoint(p1, p3, p4, p6, p8);
        return;
    }

    static synthetic android.widget.ImageView access$1200(com.jlboat.phone.activity.DiyPointPathActivity p1)
    {
        return p1.iv_mark_diy;
    }

    static synthetic boolean access$1300(com.jlboat.phone.activity.DiyPointPathActivity p1)
    {
        return p1.isSreenModel;
    }

    static synthetic boolean access$1302(com.jlboat.phone.activity.DiyPointPathActivity p0, boolean p1)
    {
        p0.isSreenModel = p1;
        return p1;
    }

    static synthetic com.jlboat.phone.adapter.NgLineListAdapter access$1400(com.jlboat.phone.activity.DiyPointPathActivity p1)
    {
        return p1.ngLineListAdapter;
    }

    static synthetic android.os.Handler access$1500(com.jlboat.phone.activity.DiyPointPathActivity p1)
    {
        return p1.handler;
    }

    static synthetic com.jlboat.phone.communication.SpiritServiceClient access$1600(com.jlboat.phone.activity.DiyPointPathActivity p1)
    {
        return p1.spiritServiceClient;
    }

    static synthetic int access$1702(com.jlboat.phone.activity.DiyPointPathActivity p0, int p1)
    {
        p0.defType = p1;
        return p1;
    }

    static synthetic boolean access$1802(com.jlboat.phone.activity.DiyPointPathActivity p0, boolean p1)
    {
        p0.hasDefConfig = p1;
        return p1;
    }

    static synthetic int access$1902(com.jlboat.phone.activity.DiyPointPathActivity p0, int p1)
    {
        p0.defDirection = p1;
        return p1;
    }

    static synthetic java.util.List access$200(com.jlboat.phone.activity.DiyPointPathActivity p1)
    {
        return p1.points;
    }

    static synthetic float access$2002(com.jlboat.phone.activity.DiyPointPathActivity p0, float p1)
    {
        p0.defSpeed = p1;
        return p1;
    }

    static synthetic float access$2102(com.jlboat.phone.activity.DiyPointPathActivity p0, float p1)
    {
        p0.defWeight = p1;
        return p1;
    }

    static synthetic void access$2200(com.jlboat.phone.activity.DiyPointPathActivity p0)
    {
        p0.getDefConfig();
        return;
    }

    static synthetic void access$2300(com.jlboat.phone.activity.DiyPointPathActivity p0, long p1)
    {
        p0.list2(p1);
        return;
    }

    static synthetic void access$2600(com.jlboat.phone.activity.DiyPointPathActivity p0, java.util.List p1)
    {
        p0.uodateDefConfig(p1);
        return;
    }

    static synthetic com.jlboat.phone.adapter.NaviListAdapter access$300(com.jlboat.phone.activity.DiyPointPathActivity p1)
    {
        return p1.naviListAdapter;
    }

    static synthetic com.jlboat.phone.view.MapView access$400(com.jlboat.phone.activity.DiyPointPathActivity p1)
    {
        return p1.mapView;
    }

    static synthetic java.util.List access$500(com.jlboat.phone.activity.DiyPointPathActivity p1)
    {
        return p1.ngNlines;
    }

    static synthetic java.util.List access$502(com.jlboat.phone.activity.DiyPointPathActivity p0, java.util.List p1)
    {
        p0.ngNlines = p1;
        return p1;
    }

    static synthetic void access$600(com.jlboat.phone.activity.DiyPointPathActivity p0, long p1)
    {
        p0.dellNGPointLine(p1);
        return;
    }

    static synthetic void access$700(com.jlboat.phone.activity.DiyPointPathActivity p0, long p1, int p3, int p4, float p5, float p6)
    {
        p0.dellNGPointLine(p1, p3, p4, p5, p6);
        return;
    }

    static synthetic com.boat.support.slam.entity.floors.Floors access$800(com.jlboat.phone.activity.DiyPointPathActivity p1)
    {
        return p1.floor;
    }

    static synthetic com.boat.support.slam.entity.floors.Floors access$802(com.jlboat.phone.activity.DiyPointPathActivity p0, com.boat.support.slam.entity.floors.Floors p1)
    {
        p0.floor = p1;
        return p1;
    }

    static synthetic com.boat.support.slam.entity.floors.Maps access$900(com.jlboat.phone.activity.DiyPointPathActivity p1)
    {
        return p1.map;
    }

    static synthetic com.boat.support.slam.entity.floors.Maps access$902(com.jlboat.phone.activity.DiyPointPathActivity p0, com.boat.support.slam.entity.floors.Maps p1)
    {
        p0.map = p1;
        return p1;
    }

    private void addNGPointLine(long p4, long p6)
    {
        com.jlboat.phone.message.map_msgs.NGlobalPlan v0_1 = new com.jlboat.phone.message.map_msgs.NGlobalPlan();
        v0_1.setStartNid(p4);
        v0_1.setEndNid(p6);
        if (!this.hasDefConfig) {
            v0_1.setType(0);
            v0_1.setDirection(1);
            v0_1.setSpeed(1053609165);
            v0_1.setWeight(1065353216);
        } else {
            v0_1.setType(this.defType);
            v0_1.setDirection(this.defDirection);
            v0_1.setSpeed(this.defSpeed);
            v0_1.setWeight(this.defWeight);
        }
        this.nGlobalPlanTopicTalk.publish(v0_1);
        this.linesList.add(this.pathPoint);
        this.mapView.setLinesStyle(this.linesList);
        return;
    }

    private void addPoint(double p18, double p20)
    {
        long v1 = System.currentTimeMillis();
        if ((v1 - this.firstTimeaddPoint) <= ((long) this.timeout)) {
            this.toast(2131493271);
            return;
        } else {
            this.firstTimeaddPoint = v1;
            int v3_0 = new com.jlboat.phone.util.EulerAngles;
            v3_0(0, 0, 0);
            int v3_1 = v3_0.ToQuaternion();
            this.spiritServiceClient.addManuPosintServices(0, com.jlboat.phone.application.BoatSlamApplication.CANCLEPOINTNAME, p18, p20, v3_1.z, v3_1.w, new com.jlboat.phone.activity.DiyPointPathActivity$11(this));
            return;
        }
    }

    private void dellNGPointLine(long p3)
    {
        com.jlboat.phone.message.map_msgs.NGlobalPlan v0_1 = new com.jlboat.phone.message.map_msgs.NGlobalPlan();
        v0_1.setId(p3);
        v0_1.setType(-1);
        this.nGlobalPlanTopicTalk.publish(v0_1);
        return;
    }

    private void dellNGPointLine(long p3, int p5, int p6, float p7, float p8)
    {
        com.jlboat.phone.message.map_msgs.NGlobalPlan v0_1 = new com.jlboat.phone.message.map_msgs.NGlobalPlan();
        v0_1.setId(p3);
        v0_1.setType(p5);
        v0_1.setDirection(p6);
        v0_1.setSpeed(p7);
        v0_1.setWeight(p8);
        this.nGlobalPlanTopicTalk.publish(v0_1);
        return;
    }

    private void getDefConfig()
    {
        this.statusServiceClient.getConfigsService(1, new com.jlboat.phone.activity.DiyPointPathActivity$9(this));
        return;
    }

    private void goNavito(int p1)
    {
        return;
    }

    private void goNavito(com.boat.support.slam.entity.floors.Floors p4, com.boat.support.slam.entity.floors.Maps p5, com.boat.support.slam.entity.floors.Points p6)
    {
        com.jlboat.phone.message.map_msgs.TargetGoal v0_1 = new com.jlboat.phone.message.map_msgs.TargetGoal();
        v0_1.setFloorId(p4.getFloorId());
        v0_1.setMapId(p5.getMapId());
        v0_1.setPointId(p6.getPointId());
        android.util.Log.d("DiyPointPathActivity", new StringBuilder().append("goNavito: aaa f: ").append(p4.getFloorName()).append(", m: ").append(p5.getMapName()).append(", p: ").append(p6.getPointName()).toString());
        this.naviTargetGoalPublish.publish(v0_1);
        return;
    }

    private void initTopic()
    {
        this.naviTargetGoalPublish = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.naviTargetgoal, com.jlboat.phone.message.map_msgs.TargetGoal, com.jlboat.phone.application.BoatSlamApplication.client);
        this.nGlobalPlanTopicTalk = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.NpathAddorDel, com.jlboat.phone.message.map_msgs.NGlobalPlan, com.jlboat.phone.application.BoatSlamApplication.client);
        this.stopNaviPublish = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.NaviStop, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client);
        this.naviTargetGoalPublish.advertise();
        this.nGlobalPlanTopicTalk.advertise();
        this.spiritTopicListener.getWallUpdateMsg(new com.jlboat.phone.activity.DiyPointPathActivity$8(this));
        return;
    }

    private java.util.List linP(java.util.List p17)
    {
        java.util.LinkedList v1_1 = new java.util.LinkedList();
        java.util.Iterator v2_1 = this.pointList.iterator();
        while (v2_1.hasNext()) {
            com.boat.support.slam.entity.floors.Points v3_1 = ((com.boat.support.slam.entity.floors.Points) v2_1.next());
            com.jlboat.phone.activity.DiyPointPathActivity$PointA v4_1 = new com.jlboat.phone.activity.DiyPointPathActivity$PointA(this, 0);
            v4_1.setPointId(v3_1.getPointId());
            java.util.LinkedList v6_2 = new java.util.LinkedList();
            java.util.Iterator v7 = p17.iterator();
            while (v7.hasNext()) {
                com.boat.support.slam.entity.floors.NLine v8_2 = ((com.boat.support.slam.entity.floors.NLine) v7.next());
                com.jlboat.phone.activity.DiyPointPathActivity$Point v9_1 = new com.jlboat.phone.activity.DiyPointPathActivity$Point(this, 0);
                int v10 = 0;
                if (v3_1.getPointId() == v8_2.getStartNid()) {
                    v9_1.setPointId(v8_2.getEndNid());
                    v10 = 1;
                }
                if (v3_1.getPointId() == v8_2.getStartNid()) {
                    v9_1.setPointId(v8_2.getStartNid());
                    v10 = 1;
                }
                if (v10 != 0) {
                    v9_1.setLineId(v8_2.getId());
                }
                if (v10 != 0) {
                    v6_2.add(v9_1);
                }
            }
            if (v6_2.size() > 0) {
                v4_1.setPoints(v6_2);
            }
        }
        return v1_1;
    }

    private void list2(long p8)
    {
        long v0 = System.currentTimeMillis();
        if ((v0 - this.firstTimeAddNgline) <= ((long) this.timeout)) {
            this.toast(2131493271);
            return;
        } else {
            this.firstTimeAddNgline = v0;
            if (this.linkedListId.size() == 2) {
                this.linkedListId.removeFirst();
            }
            this.linkedListId.add(Long.valueOf(p8));
            if (this.linkedListId.size() != 2) {
                this.linesList.add(this.pathPoint);
                this.mapView.setLinesStyle(this.linesList);
            } else {
                this.addNGPointLine(((Long) this.linkedListId.get(0)).longValue(), ((Long) this.linkedListId.get(1)).longValue());
            }
            return;
        }
    }

    private void stopTopic()
    {
        this.naviTargetGoalPublish.unadvertise();
        this.nGlobalPlanTopicTalk.unadvertise();
        this.stopNaviPublish.unadvertise();
        return;
    }

    private void uodateDefConfig(java.util.List p4)
    {
        this.statusServiceClient.setOrDelConfigsService(p4, 1, new com.jlboat.phone.activity.DiyPointPathActivity$10(this));
        return;
    }

    private void updatePoint(double p18, String p20, double p21, double p23, double p25)
    {
        double v8_0 = new com.jlboat.phone.util.EulerAngles;
        v8_0(0, p25, 0);
        com.jlboat.phone.util.Quaternion v1_1 = v8_0.ToQuaternion();
        this.spiritServiceClient.addManuPosintServices(0, p20, p21, p23, v1_1.z, v1_1.w, p18, new com.jlboat.phone.activity.DiyPointPathActivity$12(this));
        return;
    }

    public double degreeToRadian(double p5)
    {
        return ((4614256656552045848 * p5) / 4640537203540230144);
    }

    public void onClick(android.view.View p21)
    {
        switch (p21.getId()) {
            case 2131230790:
                this.pathPointId = -1;
                this.pathPointId = this.mapView.getEnablePoint();
                if (this.pathPointId == -1) {
                    if (!this.isSreenModel) {
                        this.pathPoint = this.mapView.getRosRobotPoint();
                    } else {
                        this.pathPoint = this.mapView.getRosMapPoint();
                    }
                } else {
                    this.pathPoint = this.mapView.getEnablePointLine();
                }
                if (this.pathPoint != null) {
                    long v0_45 = this.linesList.iterator();
                    while (v0_45.hasNext()) {
                        com.boat.support.slam.entity.floors.Lines v1_5 = ((com.boat.support.slam.entity.floors.Lines) v0_45.next());
                        if ((v1_5.getX() == this.pathPoint.getX()) && (v1_5.getY() == this.pathPoint.getY())) {
                            break;
                        }
                    }
                    if (this.pathPointId != -1) {
                        this.list2(this.pathPointId);
                    } else {
                        this.addPoint(this.pathPoint.getX(), this.pathPoint.getY());
                    }
                } else {
                }
                break;
            case 2131230792:
                this.bt_add_start_p.setVisibility(8);
                this.ll_bt_cs_p.setVisibility(0);
                this.linesList.clear();
                this.linkedListId.clear();
                this.pathPointId = -1;
                this.pathPointId = this.mapView.getEnablePoint();
                if (this.pathPointId == -1) {
                    if (!this.isSreenModel) {
                        this.pathPoint = this.mapView.getRosRobotPoint();
                    } else {
                        this.pathPoint = this.mapView.getRosMapPoint();
                    }
                } else {
                    this.pathPoint = this.mapView.getEnablePointLine();
                }
                if (this.pathPoint != null) {
                    if (this.pathPointId != -1) {
                        this.list2(this.pathPointId);
                    } else {
                        this.addPoint(this.pathPoint.getX(), this.pathPoint.getY());
                    }
                } else {
                }
                break;
            case 2131230797:
                this.ll_bt_cs_p.setVisibility(8);
                this.bt_add_start_p.setVisibility(0);
                this.linesList.clear();
                this.linkedListId.clear();
                break;
            case 2131230807:
                if (this.hasDefConfig) {
                    double v8_1 = this.getLayoutInflater().inflate(2131361850, 0);
                    android.widget.Button v9_1 = new android.app.AlertDialog$Builder(this);
                    v9_1.setView(v8_1);
                    android.app.AlertDialog v10 = v9_1.create();
                    android.widget.TextView v11_1 = ((android.widget.TextView) v8_1.findViewById(2131231342));
                    android.widget.Spinner v12_1 = ((android.widget.Spinner) v8_1.findViewById(2131231260));
                    android.widget.RadioGroup v13_1 = ((android.widget.RadioGroup) v8_1.findViewById(2131231169));
                    android.widget.EditText v14_1 = ((android.widget.EditText) v8_1.findViewById(2131230910));
                    android.widget.EditText v15_1 = ((android.widget.EditText) v8_1.findViewById(2131230911));
                    double v5_4 = ((android.widget.Button) v8_1.findViewById(2131230796));
                    android.widget.EditText v4_2 = ((android.widget.Button) v8_1.findViewById(2131230827));
                    ((android.widget.Button) v8_1.findViewById(2131230798)).setVisibility(8);
                    v11_1.setText("\u9ed8\u8ba4\u914d\u7f6e");
                    v12_1.setSelection(this.defType);
                    if (this.defDirection == 0) {
                        v13_1.check(2131231124);
                    }
                    if (this.defDirection == 1) {
                        v13_1.check(2131231125);
                    }
                    if (this.defDirection == 2) {
                        v13_1.check(2131231126);
                    }
                    v14_1.setText(new StringBuilder().append(this.defSpeed).append("").toString());
                    v15_1.setText(new StringBuilder().append(this.defWeight).append("").toString());
                    v5_4.setOnClickListener(new com.jlboat.phone.activity.DiyPointPathActivity$13(this, v10));
                    android.widget.EditText v3_0 = new com.jlboat.phone.activity.DiyPointPathActivity$14;
                    double v8_0 = v3_0;
                    android.widget.Button v9_0 = v4_2;
                    v3_0(this, v13_1, v14_1, v15_1, v12_1, v10);
                    v9_0.setOnClickListener(v8_0);
                    v10.show();
                } else {
                    this.toast(2131493266);
                }
                break;
            case 2131230820:
                long v0_75 = new com.boat.jrosbridge.message.std_msgs.Int16();
                v0_75.setData(5);
                this.stopNaviPublish.publish(v0_75);
                break;
            default:
        }
        return;
    }

    protected void onCreate(android.os.Bundle p3)
    {
        this.initTitleBar(2131361893, 2131493099);
        super.onCreate(p3);
        this.mapView = ((com.jlboat.phone.view.MapView) this.findViewById(2131230986));
        this.virtualJoystickView = ((com.jlboat.phone.view.JoystickView) this.findViewById(2131231359));
        this.iv_mark_diy = ((android.widget.ImageView) this.findViewById(2131230945));
        this.sw_divp_isauto_point = ((android.widget.Switch) this.findViewById(2131231280));
        this.sw_divp_isshow_pointid = ((android.widget.Switch) this.findViewById(2131231281));
        this.linePointModeRadioGroup_pp = ((android.widget.RadioGroup) this.findViewById(2131230749));
        this.bt_add_start_p = ((android.widget.Button) this.findViewById(2131230792));
        this.bt_navi_dpp_stop = ((android.widget.Button) this.findViewById(2131230820));
        this.ll_bt_cs_p = ((android.widget.LinearLayout) this.findViewById(2131230967));
        this.btCancel = ((android.widget.Button) this.findViewById(2131230797));
        this.btAddPoint = ((android.widget.Button) this.findViewById(2131230790));
        this.btLineDefConfig = ((android.widget.Button) this.findViewById(2131230807));
        this.ng_list_ry = ((android.support.v7.widget.RecyclerView) this.findViewById(2131231043));
        this.navi_list_ry = ((android.support.v7.widget.RecyclerView) this.findViewById(2131231039));
        this.ng_list_ry.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));
        this.navi_list_ry.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));
        this.ngLineListAdapter = new com.jlboat.phone.adapter.NgLineListAdapter(this);
        this.ng_list_ry.setAdapter(this.ngLineListAdapter);
        this.ngLineListAdapter.setOnclickItem(new com.jlboat.phone.activity.DiyPointPathActivity$2(this));
        this.ngLineListAdapter.setOnLingclickItem(new com.jlboat.phone.activity.DiyPointPathActivity$3(this));
        this.naviListAdapter = new com.jlboat.phone.adapter.NaviListAdapter(this);
        this.navi_list_ry.setAdapter(this.naviListAdapter);
        this.naviListAdapter.setOnLingclickItem(new com.jlboat.phone.activity.DiyPointPathActivity$4(this));
        this.linePointModeRadioGroup_pp.setOnCheckedChangeListener(new com.jlboat.phone.activity.DiyPointPathActivity$5(this));
        this.sw_divp_isauto_point.setOnCheckedChangeListener(new com.jlboat.phone.activity.DiyPointPathActivity$6(this));
        this.sw_divp_isauto_point.setChecked(1);
        this.sw_divp_isshow_pointid.setOnCheckedChangeListener(new com.jlboat.phone.activity.DiyPointPathActivity$7(this));
        this.bt_add_start_p.setOnClickListener(this);
        this.bt_navi_dpp_stop.setOnClickListener(this);
        this.btCancel.setOnClickListener(this);
        this.btAddPoint.setOnClickListener(this);
        this.btLineDefConfig.setOnClickListener(this);
        return;
    }

    protected void onPause()
    {
        super.onPause();
        this.stopTopic();
        this.mapView.onStop();
        this.virtualJoystickView.onStop();
        return;
    }

    protected void onResume()
    {
        super.onResume();
        this.initTopic();
        this.mapView.onStart(this.getMyApplication());
        this.virtualJoystickView.onStart();
        this.getDefConfig();
        return;
    }

    public double radianToDegree(double p5)
    {
        return ((4640537203540230144 * p5) / 4614256656552045848);
    }
}
