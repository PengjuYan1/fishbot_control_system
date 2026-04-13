package com.jlboat.phone.activity;
public class DiyPathActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private static final String TAG = "DiyPathActivity";
    private final int POINT_VERIFY;
    private final int REQ_END;
    private final int START_REQ;
    private final int STOP_PATH_TEST;
    private final int UPDATE_ALLLIST;
    private java.util.List bindPointList;
    private com.jlboat.phone.adapter.BindPointListAdapter bindPointListAdapter;
    private android.support.v7.widget.RecyclerView bindPointRv;
    private android.widget.LinearLayout bind_point_ll;
    android.widget.Button btAddPoint;
    android.widget.Button btCancel;
    android.widget.Button btSave;
    android.widget.Button bt_add_start;
    private com.jlboat.phone.view.MyPopupWindow delPopu;
    private int dir;
    private com.jlboat.phone.adapter.DiyPathListAdapter diyPathListAdapter;
    private com.boat.jrosbridge.Topic globalPlansTestTopic;
    private android.os.Handler handler;
    private android.view.View inflate;
    private boolean isAdd;
    private boolean isNext;
    private boolean isSreenModel;
    private boolean isUsePoint;
    private android.widget.ImageView iv_mark_diy;
    private android.widget.RadioGroup linePointModeRadioGroup;
    java.util.List linesList;
    android.widget.LinearLayout ll_bt_cs;
    private com.jlboat.phone.view.loading.MyLoading loading;
    private int longClickPos;
    private java.util.List mGlobalPlans;
    private com.jlboat.phone.view.MapView mapView;
    private com.jlboat.phone.view.MyPopupWindow myPopupWindow;
    private com.jlboat.phone.view.PathItemSettingPopup pathItemSettingPopup;
    private android.widget.TextView pathNoDataTv;
    private com.boat.support.slam.entity.floors.Lines pathPoint;
    private com.jlboat.phone.view.SavaPathPopup pathPopup;
    private android.support.v7.widget.RecyclerView pathRv;
    private android.widget.TextView pointNoDataTv;
    private java.util.List points;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.SpiritTopicListener spiritTopicListener;
    private android.widget.Button stopPathTestBtn;

    public DiyPathActivity()
    {
        this.START_REQ = 1001;
        this.REQ_END = 1002;
        this.POINT_VERIFY = 1003;
        this.UPDATE_ALLLIST = 1004;
        this.STOP_PATH_TEST = 1005;
        this.handler = new com.jlboat.phone.activity.DiyPathActivity$1(this);
        this.isSreenModel = 1;
        this.points = new java.util.LinkedList();
        this.longClickPos = 0;
        this.isAdd = 1;
        this.isNext = 1;
        return;
    }

    static synthetic com.jlboat.phone.view.SavaPathPopup access$000(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.pathPopup;
    }

    static synthetic com.jlboat.phone.view.loading.MyLoading access$100(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.loading;
    }

    static synthetic android.support.v7.widget.RecyclerView access$1000(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.bindPointRv;
    }

    static synthetic java.util.List access$1100(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.points;
    }

    static synthetic com.jlboat.phone.adapter.BindPointListAdapter access$1200(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.bindPointListAdapter;
    }

    static synthetic android.widget.Button access$1300(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.stopPathTestBtn;
    }

    static synthetic android.widget.ImageView access$1600(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.iv_mark_diy;
    }

    static synthetic boolean access$1700(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.isSreenModel;
    }

    static synthetic boolean access$1702(com.jlboat.phone.activity.DiyPathActivity p0, boolean p1)
    {
        p0.isSreenModel = p1;
        return p1;
    }

    static synthetic com.jlboat.phone.view.MapView access$1800(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.mapView;
    }

    static synthetic android.support.v7.widget.RecyclerView access$200(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.pathRv;
    }

    static synthetic android.os.Handler access$2000(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.handler;
    }

    static synthetic com.jlboat.phone.communication.SpiritServiceClient access$2100(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.spiritServiceClient;
    }

    static synthetic boolean access$2200(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.isNext;
    }

    static synthetic boolean access$2202(com.jlboat.phone.activity.DiyPathActivity p0, boolean p1)
    {
        p0.isNext = p1;
        return p1;
    }

    static synthetic void access$2300(com.jlboat.phone.activity.DiyPathActivity p0, long p1, String p3, int p4, int p5, int p6, String p7)
    {
        p0.subOrVerData(p1, p3, p4, p5, p6, p7);
        return;
    }

    static synthetic boolean access$2402(com.jlboat.phone.activity.DiyPathActivity p0, boolean p1)
    {
        p0.isUsePoint = p1;
        return p1;
    }

    static synthetic void access$2500(com.jlboat.phone.activity.DiyPathActivity p0, int p1, android.view.View p2)
    {
        p0.settingShow(p1, p2);
        return;
    }

    static synthetic com.jlboat.phone.view.PathItemSettingPopup access$2600(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.pathItemSettingPopup;
    }

    static synthetic com.boat.jrosbridge.Topic access$2700(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.globalPlansTestTopic;
    }

    static synthetic void access$2800(com.jlboat.phone.activity.DiyPathActivity p0, com.boat.support.slam.entity.floors.GlobalPlans p1)
    {
        p0.showReNameDiaLog(p1);
        return;
    }

    static synthetic com.jlboat.phone.view.MyPopupWindow access$2900(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.myPopupWindow;
    }

    static synthetic com.jlboat.phone.view.MyPopupWindow access$2902(com.jlboat.phone.activity.DiyPathActivity p0, com.jlboat.phone.view.MyPopupWindow p1)
    {
        p0.myPopupWindow = p1;
        return p1;
    }

    static synthetic android.widget.LinearLayout access$300(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.bind_point_ll;
    }

    static synthetic android.view.View access$3000(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.inflate;
    }

    static synthetic int access$3100(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.dir;
    }

    static synthetic int access$3102(com.jlboat.phone.activity.DiyPathActivity p0, int p1)
    {
        p0.dir = p1;
        return p1;
    }

    static synthetic void access$3200(com.jlboat.phone.activity.DiyPathActivity p0, com.boat.support.slam.entity.floors.GlobalPlans p1, String p2, int p3)
    {
        p0.renamePath(p1, p2, p3);
        return;
    }

    static synthetic com.jlboat.phone.view.MyPopupWindow access$3300(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.delPopu;
    }

    static synthetic com.jlboat.phone.view.MyPopupWindow access$3302(com.jlboat.phone.activity.DiyPathActivity p0, com.jlboat.phone.view.MyPopupWindow p1)
    {
        p0.delPopu = p1;
        return p1;
    }

    static synthetic void access$3400(com.jlboat.phone.activity.DiyPathActivity p0, int p1)
    {
        p0.deleteBindedPoint(p1);
        return;
    }

    static synthetic java.util.List access$400(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.mGlobalPlans;
    }

    static synthetic java.util.List access$402(com.jlboat.phone.activity.DiyPathActivity p0, java.util.List p1)
    {
        p0.mGlobalPlans = p1;
        return p1;
    }

    static synthetic android.widget.TextView access$500(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.pathNoDataTv;
    }

    static synthetic int access$600(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.longClickPos;
    }

    static synthetic int access$602(com.jlboat.phone.activity.DiyPathActivity p0, int p1)
    {
        p0.longClickPos = p1;
        return p1;
    }

    static synthetic com.jlboat.phone.adapter.DiyPathListAdapter access$700(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.diyPathListAdapter;
    }

    static synthetic java.util.List access$800(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.bindPointList;
    }

    static synthetic java.util.List access$802(com.jlboat.phone.activity.DiyPathActivity p0, java.util.List p1)
    {
        p0.bindPointList = p1;
        return p1;
    }

    static synthetic android.widget.TextView access$900(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        return p1.pointNoDataTv;
    }

    private int[] calculatePopWindowPos(android.view.View p19, android.view.View p20)
    {
        int v11_3;
        int[] v1 = new int[2];
        int[] v0_1 = new int[2];
        p19.getLocationOnScreen(v0_1);
        int v3 = p19.getHeight();
        int v4_0 = com.jlboat.phone.util.Utils.getScreenHeight(p19.getContext());
        int v5_1 = com.jlboat.phone.util.Utils.getScreenWidth(p19.getContext());
        p20.measure(0, 0);
        int v8 = p20.getMeasuredHeight();
        int v9 = p20.getMeasuredWidth();
        if (((v4_0 - v0_1[1]) - v3) >= v8) {
            v11_3 = 0;
        } else {
            v11_3 = 1;
        }
        int v6_3 = ((int) (((double) v5_1) - (((double) p19.getWidth()) + (((double) p19.getWidth()) * 4609434218613702656))));
        if (v11_3 == 0) {
            v1[0] = ((v5_1 - v9) - v6_3);
            v1[1] = ((v0_1[1] + v3) - (v3 / 2));
        } else {
            v1[0] = ((v5_1 - v9) - v6_3);
            v1[1] = ((v0_1[1] - v8) + (v3 / 2));
        }
        return v1;
    }

    private void deleteBindedPoint(int p8)
    {
        if (this.loading == null) {
            this.loading = com.jlboat.phone.util.Utils.showLoading(this, 2131361892, "\u5220\u9664\u4e2d...");
        }
        com.boat.support.slam.entity.floors.GlobalPlans v0_2 = ((com.boat.support.slam.entity.floors.GlobalPlans) this.mGlobalPlans.get(this.longClickPos));
        com.boat.support.slam.entity.floors.AddPoints v1_2 = ((com.boat.support.slam.entity.floors.AddPoints) v0_2.getAddPoints().get(p8));
        com.jlboat.phone.message.map_msgs.GlobalPlanPoints v2_1 = new com.jlboat.phone.message.map_msgs.GlobalPlanPoints();
        v2_1.setPointIdA(v1_2.getX());
        v2_1.setPointIdB(v1_2.getY());
        world_canvas_msgs18.DiyPathEnty v3_3 = new world_canvas_msgs18.DiyPathEnty();
        v3_3.setGlobalplanId(v0_2.getGlobalplanId());
        v3_3.setAddPoint(v2_1);
        this.spiritServiceClient.addPointsGlobalplan(v3_3, 1, new com.jlboat.phone.activity.DiyPathActivity$15(this));
        return;
    }

    public static void i(String p2, String p3)
    {
        int v0_1 = (2001 - p2.length());
        while (p3.length() > v0_1) {
            android.util.Log.i(p2, p3.substring(0, v0_1));
            p3 = p3.substring(v0_1);
        }
        android.util.Log.i(p2, p3);
        return;
    }

    private void initTopic()
    {
        this.globalPlansTestTopic = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.GlobalPlansTest, com.boat.jrosbridge.message.std_msgs.Int64, com.jlboat.phone.application.BoatSlamApplication.client);
        this.globalPlansTestTopic.advertise();
        this.spiritTopicListener.getWallUpdateMsg(new com.jlboat.phone.activity.DiyPathActivity$3(this));
        return;
    }

    private void renamePath(com.boat.support.slam.entity.floors.GlobalPlans p4, String p5, int p6)
    {
        if (this.loading == null) {
            this.loading = com.jlboat.phone.util.Utils.showLoading(this, 2131361892, "\u4fee\u6539\u4e2d...");
        }
        world_canvas_msgs18.DiyPathEnty v0_4 = new world_canvas_msgs18.DiyPathEnty();
        v0_4.setGlobalplanName(p5);
        v0_4.setDir(((long) p6));
        v0_4.setGlobalplanId(p4.getGlobalplanId());
        this.spiritServiceClient.renameDiyPath(v0_4, new com.jlboat.phone.activity.DiyPathActivity$14(this));
        return;
    }

    private void settingShow(int p9, android.view.View p10)
    {
        com.boat.support.slam.entity.floors.GlobalPlans v0_2 = ((com.boat.support.slam.entity.floors.GlobalPlans) this.mGlobalPlans.get(p9));
        com.jlboat.phone.view.PathItemSettingPopup v7 = new com.jlboat.phone.view.PathItemSettingPopup;
        v7(this, new com.jlboat.phone.activity.DiyPathActivity$7(this, v0_2), new com.jlboat.phone.activity.DiyPathActivity$8(this, v0_2), new com.jlboat.phone.activity.DiyPathActivity$9(this, p9), new com.jlboat.phone.activity.DiyPathActivity$10(this, p9, v0_2));
        this.pathItemSettingPopup = v7;
        int[] v2_2 = this.calculatePopWindowPos(p10, android.view.LayoutInflater.from(this).inflate(2131361927, 0));
        this.pathItemSettingPopup.showAtLocation(p10, 0, v2_2[0], v2_2[1]);
        return;
    }

    private void showReNameDiaLog(com.boat.support.slam.entity.floors.GlobalPlans p11)
    {
        this.dir = p11.getDir();
        android.view.View v0_2 = android.view.LayoutInflater.from(this).inflate(2131361926, 0);
        android.widget.EditText v1_1 = ((android.widget.EditText) v0_2.findViewById(2131231082));
        android.widget.RadioGroup v2_2 = ((android.widget.RadioGroup) v0_2.findViewById(2131231083));
        android.widget.RadioButton v3_2 = ((android.widget.RadioButton) v0_2.findViewById(2131231091));
        android.view.View vtmp7 = v0_2.findViewById(2131231077);
        if (this.dir != 0) {
            v3_2.setChecked(1);
        } else {
            ((android.widget.RadioButton) vtmp7).setChecked(1);
        }
        android.widget.Button v5_3 = ((android.widget.Button) v0_2.findViewById(2131231081));
        android.widget.Button v6_3 = ((android.widget.Button) v0_2.findViewById(2131231080));
        v1_1.setText(p11.getGlobalplanName());
        android.app.AlertDialog$Builder v7_2 = new android.app.AlertDialog$Builder(this);
        v7_2.setView(v0_2);
        android.app.AlertDialog v8 = v7_2.create();
        v2_2.setOnCheckedChangeListener(new com.jlboat.phone.activity.DiyPathActivity$11(this));
        v5_3.setOnClickListener(new com.jlboat.phone.activity.DiyPathActivity$12(this, v1_1, p11, v8));
        v6_3.setOnClickListener(new com.jlboat.phone.activity.DiyPathActivity$13(this, v8));
        v8.show();
        return;
    }

    private void stopTopic()
    {
        this.globalPlansTestTopic.unadvertise();
        return;
    }

    private void subOrVerData(long p4, String p6, int p7, int p8, int p9, String p10)
    {
        if (this.loading == null) {
            this.loading = com.jlboat.phone.util.Utils.showLoading(this, 2131361892, p10);
        }
        world_canvas_msgs18.DiyPathEnty v0_4 = new world_canvas_msgs18.DiyPathEnty();
        v0_4.setDir(((long) p8));
        v0_4.setGlobalplanId(p4);
        v0_4.setGlobalplanName(p6);
        v0_4.setLinesList(this.linesList);
        v0_4.setOp(((long) p7));
        this.spiritServiceClient.addOrDelDiyPath(v0_4, new com.jlboat.phone.activity.DiyPathActivity$6(this, p9));
        return;
    }

    public void onClick(android.view.View p12)
    {
        switch (p12.getId()) {
            case 2131230789:
                if (!this.isNext) {
                } else {
                    this.isNext = 0;
                    if (!this.isSreenModel) {
                        this.pathPoint = this.mapView.getRosRobotPoint();
                    } else {
                        this.pathPoint = this.mapView.getRosMapPoint();
                    }
                    if (this.pathPoint != null) {
                        this.isAdd = 1;
                        com.jlboat.phone.view.MapView v0_2 = this.linesList.iterator();
                        while (v0_2.hasNext()) {
                            java.util.List v2_2 = ((com.boat.support.slam.entity.floors.Lines) v0_2.next());
                            if ((v2_2.getX() == this.pathPoint.getX()) && (v2_2.getY() == this.pathPoint.getY())) {
                                this.isAdd = 0;
                                break;
                            }
                        }
                        if (!this.isAdd) {
                        } else {
                            this.linesList.add(this.pathPoint);
                            this.mapView.setLinesStyle(this.linesList);
                            this.subOrVerData(-1, "", 2, -1, 1, this.getResString(2131493229));
                        }
                    } else {
                    }
                }
                break;
            case 2131230791:
                if (!this.isNext) {
                } else {
                    this.isNext = 0;
                    this.bt_add_start.setVisibility(8);
                    this.pathRv.setVisibility(8);
                    this.bind_point_ll.setVisibility(8);
                    this.ll_bt_cs.setVisibility(0);
                    this.linesList = new java.util.LinkedList();
                    if (!this.isSreenModel) {
                        this.pathPoint = this.mapView.getRosRobotPoint();
                    } else {
                        this.pathPoint = this.mapView.getRosMapPoint();
                    }
                    if (this.pathPoint != null) {
                        this.linesList.add(this.pathPoint);
                        this.mapView.setLinesStyle(this.linesList);
                        this.subOrVerData(-1, "", 2, -1, 1, this.getResString(2131493229));
                    } else {
                    }
                }
                break;
            case 2131230795:
                this.ll_bt_cs.setVisibility(8);
                this.bt_add_start.setVisibility(0);
                this.pathRv.setVisibility(0);
                this.bind_point_ll.setVisibility(0);
                this.linesList.clear();
                break;
            case 2131230822:
                if (this.linesList.size() >= 2) {
                    this.pathPopup = new com.jlboat.phone.view.SavaPathPopup(this, new com.jlboat.phone.activity.DiyPathActivity$4(this));
                    this.pathPopup.showAtLocation(android.view.LayoutInflater.from(this).inflate(2131361892, 0), 17, 0, 0);
                } else {
                    this.toast(2131493273);
                }
                break;
            case 2131231277:
                this.spiritServiceClient.executePath(4, new com.jlboat.phone.activity.DiyPathActivity$5(this));
                break;
            default:
        }
        return;
    }

    protected void onCreate(android.os.Bundle p5)
    {
        this.initTitleBar(2131361892, 2131492930);
        super.onCreate(p5);
        this.ll_bt_cs = ((android.widget.LinearLayout) this.findViewById(2131230966));
        this.mapView = ((com.jlboat.phone.view.MapView) this.findViewById(2131230986));
        this.bt_add_start = ((android.widget.Button) this.findViewById(2131230791));
        this.btCancel = ((android.widget.Button) this.findViewById(2131230795));
        this.btSave = ((android.widget.Button) this.findViewById(2131230822));
        this.btAddPoint = ((android.widget.Button) this.findViewById(2131230789));
        this.pathNoDataTv = ((android.widget.TextView) this.findViewById(2131231087));
        this.pathRv = ((android.support.v7.widget.RecyclerView) this.findViewById(2131231088));
        this.pathRv.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));
        this.diyPathListAdapter = new com.jlboat.phone.adapter.DiyPathListAdapter();
        this.pathRv.setAdapter(this.diyPathListAdapter);
        this.diyPathListAdapter.setOnItemClickListener(new com.jlboat.phone.activity.DiyPathActivity$PathRvItemCL(this, 0));
        this.diyPathListAdapter.setOnLongItemClickListener(new com.jlboat.phone.activity.DiyPathActivity$PathRvItemLongCL(this, 0));
        this.iv_mark_diy = ((android.widget.ImageView) this.findViewById(2131230945));
        this.linePointModeRadioGroup = ((android.widget.RadioGroup) this.findViewById(2131230748));
        this.linePointModeRadioGroup.setOnCheckedChangeListener(new com.jlboat.phone.activity.DiyPathActivity$2(this));
        this.bind_point_ll = ((android.widget.LinearLayout) this.findViewById(2131230777));
        this.pointNoDataTv = ((android.widget.TextView) this.findViewById(2131231100));
        this.bindPointRv = ((android.support.v7.widget.RecyclerView) this.findViewById(2131230778));
        this.bindPointRv.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));
        this.bindPointListAdapter = new com.jlboat.phone.adapter.BindPointListAdapter();
        this.bindPointRv.setAdapter(this.bindPointListAdapter);
        this.bindPointListAdapter.setOnItemClickListener(new com.jlboat.phone.activity.DiyPathActivity$BindPointItemCL(this, 0));
        this.stopPathTestBtn = ((android.widget.Button) this.findViewById(2131231277));
        this.bt_add_start.setOnClickListener(this);
        this.btCancel.setOnClickListener(this);
        this.btSave.setOnClickListener(this);
        this.btAddPoint.setOnClickListener(this);
        this.stopPathTestBtn.setOnClickListener(this);
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        this.spiritTopicListener = new com.jlboat.phone.communication.SpiritTopicListener();
        this.inflate = android.view.LayoutInflater.from(this).inflate(2131361892, 0);
        return;
    }

    protected void onPause()
    {
        super.onPause();
        this.mapView.onStop();
        this.stopTopic();
        return;
    }

    protected void onResume()
    {
        super.onResume();
        this.initTopic();
        this.mapView.onStart(this.getMyApplication());
        return;
    }
}
