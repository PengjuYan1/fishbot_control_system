package com.jlboat.phone.activity;
public class PointBindPathActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private static final String TAG = "PointBindPathActivity";
    private final int REQ_END;
    private final int START_REQ;
    private final int UPDATE_UI;
    private com.jlboat.phone.adapter.BindPointListAdapter bindPointListAdapter;
    private android.support.v7.widget.RecyclerView bpBindRv;
    private android.widget.Button bpCancelBt;
    private android.support.v7.widget.RecyclerView bpNavPointRv;
    private android.widget.TextView bpPathNameTv;
    private android.widget.Button bpSaveBt;
    private com.jlboat.phone.view.MyPopupWindow delPopu;
    private int flag;
    private long globalplanId;
    private android.os.Handler handler;
    private int isShowToast;
    java.util.List linesList;
    private com.jlboat.phone.view.loading.MyLoading loading;
    private com.boat.support.slam.entity.floors.GlobalPlans mGlobalPlans;
    com.jlboat.phone.view.MapView mapView;
    private com.jlboat.phone.adapter.NavPointListAdapter navPointListAdapter;
    java.util.List newAddPos;
    private com.jlboat.phone.adapter.NewBindPointListAdapter newBindPointListAdapter;
    private android.support.v7.widget.RecyclerView newBindPointRv;
    private java.util.List oldAddPoints;
    private java.util.List points;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.SpiritTopicListener spiritTopicListener;
    java.util.Map stringPointsMap;

    public PointBindPathActivity()
    {
        this.newAddPos = new java.util.ArrayList();
        this.flag = 0;
        this.START_REQ = 1001;
        this.REQ_END = 1002;
        this.UPDATE_UI = 1003;
        this.handler = new com.jlboat.phone.activity.PointBindPathActivity$1(this);
        this.points = new java.util.LinkedList();
        return;
    }

    static synthetic com.jlboat.phone.view.loading.MyLoading access$000(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        return p1.loading;
    }

    static synthetic com.jlboat.phone.view.loading.MyLoading access$002(com.jlboat.phone.activity.PointBindPathActivity p0, com.jlboat.phone.view.loading.MyLoading p1)
    {
        p0.loading = p1;
        return p1;
    }

    static synthetic com.jlboat.phone.adapter.NewBindPointListAdapter access$100(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        return p1.newBindPointListAdapter;
    }

    static synthetic long access$1300(com.jlboat.phone.activity.PointBindPathActivity p2)
    {
        return p2.globalplanId;
    }

    static synthetic android.os.Handler access$1400(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        return p1.handler;
    }

    static synthetic com.jlboat.phone.communication.SpiritServiceClient access$1500(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        return p1.spiritServiceClient;
    }

    static synthetic void access$1600(com.jlboat.phone.activity.PointBindPathActivity p0, world_canvas_msgs18.DiyPathEnty p1, int p2)
    {
        p0.addBindNavPoint(p1, p2);
        return;
    }

    static synthetic int access$1700(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        return p1.flag;
    }

    static synthetic int access$1702(com.jlboat.phone.activity.PointBindPathActivity p0, int p1)
    {
        p0.flag = p1;
        return p1;
    }

    static synthetic int access$1708(com.jlboat.phone.activity.PointBindPathActivity p2)
    {
        int v0 = p2.flag;
        p2.flag = (v0 + 1);
        return v0;
    }

    static synthetic int access$1800(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        return p1.isShowToast;
    }

    static synthetic int access$1810(com.jlboat.phone.activity.PointBindPathActivity p2)
    {
        int v0 = p2.isShowToast;
        p2.isShowToast = (v0 - 1);
        return v0;
    }

    static synthetic android.support.v7.widget.RecyclerView access$1900(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        return p1.newBindPointRv;
    }

    static synthetic com.boat.support.slam.entity.floors.GlobalPlans access$200(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        return p1.mGlobalPlans;
    }

    static synthetic com.jlboat.phone.view.MyPopupWindow access$2000(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        return p1.delPopu;
    }

    static synthetic com.jlboat.phone.view.MyPopupWindow access$2002(com.jlboat.phone.activity.PointBindPathActivity p0, com.jlboat.phone.view.MyPopupWindow p1)
    {
        p0.delPopu = p1;
        return p1;
    }

    static synthetic com.boat.support.slam.entity.floors.GlobalPlans access$202(com.jlboat.phone.activity.PointBindPathActivity p0, com.boat.support.slam.entity.floors.GlobalPlans p1)
    {
        p0.mGlobalPlans = p1;
        return p1;
    }

    static synthetic void access$2100(com.jlboat.phone.activity.PointBindPathActivity p0, int p1)
    {
        p0.deleteBindedPoint(p1);
        return;
    }

    static synthetic android.support.v7.widget.RecyclerView access$300(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        return p1.bpNavPointRv;
    }

    static synthetic java.util.List access$400(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        return p1.points;
    }

    static synthetic com.jlboat.phone.adapter.NavPointListAdapter access$500(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        return p1.navPointListAdapter;
    }

    static synthetic java.util.List access$600(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        return p1.oldAddPoints;
    }

    static synthetic java.util.List access$602(com.jlboat.phone.activity.PointBindPathActivity p0, java.util.List p1)
    {
        p0.oldAddPoints = p1;
        return p1;
    }

    static synthetic android.widget.TextView access$700(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        return p1.bpPathNameTv;
    }

    static synthetic android.support.v7.widget.RecyclerView access$800(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        return p1.bpBindRv;
    }

    static synthetic com.jlboat.phone.adapter.BindPointListAdapter access$900(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        return p1.bindPointListAdapter;
    }

    private void addBindNavPoint(world_canvas_msgs18.DiyPathEnty p3, int p4)
    {
        this.spiritServiceClient.addPointsGlobalplan(p3, p4, new com.jlboat.phone.activity.PointBindPathActivity$4(this));
        return;
    }

    private void deleteBindedPoint(int p7)
    {
        if (this.loading == null) {
            this.loading = com.jlboat.phone.util.Utils.showLoading(this, 2131361892, "\u5220\u9664\u4e2d...");
        }
        com.boat.support.slam.entity.floors.AddPoints v0_1 = ((com.boat.support.slam.entity.floors.AddPoints) this.oldAddPoints.get(p7));
        com.jlboat.phone.message.map_msgs.GlobalPlanPoints v1_1 = new com.jlboat.phone.message.map_msgs.GlobalPlanPoints();
        v1_1.setPointIdA(v0_1.getX());
        v1_1.setPointIdB(v0_1.getY());
        world_canvas_msgs18.DiyPathEnty v2_3 = new world_canvas_msgs18.DiyPathEnty();
        v2_3.setGlobalplanId(this.mGlobalPlans.getGlobalplanId());
        v2_3.setAddPoint(v1_1);
        this.spiritServiceClient.addPointsGlobalplan(v2_3, 1, new com.jlboat.phone.activity.PointBindPathActivity$5(this));
        return;
    }

    private void initTopic()
    {
        this.spiritTopicListener.getWallUpdateMsg(new com.jlboat.phone.activity.PointBindPathActivity$2(this));
        return;
    }

    public void onClick(android.view.View p3)
    {
        switch (p3.getId()) {
            case 2131230784:
                this.newAddPos.clear();
                this.flag = 0;
                this.newBindPointListAdapter.setData(this.newAddPos);
                break;
            case 2131230785:
            case 2131230786:
            default:
                break;
            case 2131230787:
                break;
            case 2131230788:
                if (this.newAddPos.size() <= 0) {
                    this.toast(2131493294);
                } else {
                    if (this.flag != 0) {
                        this.toast(2131493295);
                    } else {
                        this.isShowToast = this.newAddPos.size();
                        this.handler.sendEmptyMessage(1001);
                        new com.jlboat.phone.activity.PointBindPathActivity$3(this).start();
                    }
                }
                break;
        }
        return;
    }

    protected void onCreate(android.os.Bundle p6)
    {
        this.initTitleBar(2131361929, 2131493031);
        super.onCreate(p6);
        this.globalplanId = this.getIntent().getLongExtra("data", -1);
        if (-1 == this.globalplanId) {
            this.toast(2131493296);
            this.finish();
        }
        this.mapView = ((com.jlboat.phone.view.MapView) this.findViewById(2131230785));
        this.bpPathNameTv = ((android.widget.TextView) this.findViewById(2131230787));
        this.bpPathNameTv.setOnClickListener(this);
        this.bpBindRv = ((android.support.v7.widget.RecyclerView) this.findViewById(2131230782));
        this.bpBindRv.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));
        this.bindPointListAdapter = new com.jlboat.phone.adapter.BindPointListAdapter();
        this.bpBindRv.setAdapter(this.bindPointListAdapter);
        this.bpNavPointRv = ((android.support.v7.widget.RecyclerView) this.findViewById(2131230786));
        android.support.v7.widget.LinearLayoutManager v0_22 = new android.support.v7.widget.LinearLayoutManager(this);
        v0_22.setOrientation(0);
        this.bpNavPointRv.setLayoutManager(v0_22);
        this.navPointListAdapter = new com.jlboat.phone.adapter.NavPointListAdapter();
        this.bpNavPointRv.setAdapter(this.navPointListAdapter);
        this.navPointListAdapter.setOnItemClickListener(new com.jlboat.phone.activity.PointBindPathActivity$NavPointItemCL(this, 0));
        this.newBindPointRv = ((android.support.v7.widget.RecyclerView) this.findViewById(2131230781));
        this.newBindPointRv.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));
        this.newBindPointListAdapter = new com.jlboat.phone.adapter.NewBindPointListAdapter();
        this.newBindPointRv.setAdapter(this.newBindPointListAdapter);
        this.newBindPointListAdapter.setOnItemClickListener(new com.jlboat.phone.activity.PointBindPathActivity$NewBindPointItemCL(this, 0));
        this.bpSaveBt = ((android.widget.Button) this.findViewById(2131230788));
        this.bpCancelBt = ((android.widget.Button) this.findViewById(2131230784));
        this.bpSaveBt.setOnClickListener(this);
        this.bpCancelBt.setOnClickListener(this);
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        this.spiritTopicListener = new com.jlboat.phone.communication.SpiritTopicListener();
        this.linesList = new java.util.LinkedList();
        return;
    }

    protected void onPause()
    {
        super.onPause();
        this.mapView.onStop();
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
