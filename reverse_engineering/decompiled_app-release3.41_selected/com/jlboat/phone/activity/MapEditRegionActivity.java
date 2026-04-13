package com.jlboat.phone.activity;
public class MapEditRegionActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private static final String TAG = "MapEditShapeActivity";
    com.jlboat.phone.adapter.RegionListAdapter RegionListAdapter;
    android.widget.Button add;
    android.widget.Button addpoint;
    android.widget.Button cancel;
    private long endRid;
    android.widget.LinearLayout end_rid_ll;
    android.widget.TextView end_rid_tv;
    private java.util.List floorList;
    private boolean isOk;
    private int itemType;
    android.widget.ImageView ivRectangle;
    java.util.List linesList;
    android.widget.LinearLayout llOk;
    private float mPrimaryLastX;
    private float mPrimaryLastY;
    private float mSecondaryLastX;
    private float mSecondaryLastY;
    com.jlboat.phone.view.MapView mapView;
    android.widget.LinearLayout mark_one_ll;
    android.widget.EditText mark_one_tv;
    android.widget.LinearLayout mark_two_ll;
    android.widget.EditText mark_two_tv;
    private float movingx;
    private float movingy;
    android.widget.Button ok;
    private android.widget.RelativeLayout$LayoutParams params;
    private java.util.List pointsList;
    android.widget.RadioGroup radioGroup;
    private int regionProperty1;
    private int regionProperty2;
    private java.util.List selectfloorList;
    android.widget.LinearLayout setid_ll;
    android.support.v7.widget.RecyclerView shapeRy;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.SpiritTopicListener spiritTopicListener;
    private long startRId;
    android.widget.LinearLayout start_rid_ll;
    android.widget.TextView start_rid_tv;
    private float viewHeight;
    private float viewWidth;
    private long waitRid;
    android.widget.LinearLayout wait_rid_ll;
    android.widget.TextView wait_rid_tv;

    public MapEditRegionActivity()
    {
        this.mPrimaryLastX = -1082130432;
        this.mPrimaryLastY = -1082130432;
        this.mSecondaryLastX = -1082130432;
        this.mSecondaryLastY = -1082130432;
        this.movingx = -1082130432;
        this.movingy = -1082130432;
        Integer v1 = Integer.valueOf(1);
        Integer v3 = Integer.valueOf(2);
        Integer v5 = Integer.valueOf(3);
        Integer v7 = Integer.valueOf(4);
        Integer v9 = Integer.valueOf(5);
        Integer[] v8_1 = new Integer[5];
        v8_1[0] = v1;
        v8_1[1] = v3;
        v8_1[2] = v5;
        v8_1[3] = v7;
        v8_1[4] = v9;
        this.floorList = java.util.Arrays.asList(v8_1);
        this.selectfloorList = 0;
        this.isOk = 0;
        return;
    }

    static synthetic int access$002(com.jlboat.phone.activity.MapEditRegionActivity p0, int p1)
    {
        p0.regionProperty1 = p1;
        return p1;
    }

    static synthetic void access$100(com.jlboat.phone.activity.MapEditRegionActivity p0)
    {
        p0.checkOkVis();
        return;
    }

    static synthetic long access$1002(com.jlboat.phone.activity.MapEditRegionActivity p0, long p1)
    {
        p0.waitRid = p1;
        return p1;
    }

    static synthetic void access$1100(com.jlboat.phone.activity.MapEditRegionActivity p0)
    {
        p0.reset();
        return;
    }

    static synthetic float access$1200(com.jlboat.phone.activity.MapEditRegionActivity p1)
    {
        return p1.mPrimaryLastX;
    }

    static synthetic float access$1202(com.jlboat.phone.activity.MapEditRegionActivity p0, float p1)
    {
        p0.mPrimaryLastX = p1;
        return p1;
    }

    static synthetic float access$1300(com.jlboat.phone.activity.MapEditRegionActivity p1)
    {
        return p1.mPrimaryLastY;
    }

    static synthetic float access$1302(com.jlboat.phone.activity.MapEditRegionActivity p0, float p1)
    {
        p0.mPrimaryLastY = p1;
        return p1;
    }

    static synthetic android.widget.RelativeLayout$LayoutParams access$1400(com.jlboat.phone.activity.MapEditRegionActivity p1)
    {
        return p1.params;
    }

    static synthetic android.widget.RelativeLayout$LayoutParams access$1402(com.jlboat.phone.activity.MapEditRegionActivity p0, android.widget.RelativeLayout$LayoutParams p1)
    {
        p0.params = p1;
        return p1;
    }

    static synthetic float access$1500(com.jlboat.phone.activity.MapEditRegionActivity p1)
    {
        return p1.viewWidth;
    }

    static synthetic float access$1502(com.jlboat.phone.activity.MapEditRegionActivity p0, float p1)
    {
        p0.viewWidth = p1;
        return p1;
    }

    static synthetic float access$1600(com.jlboat.phone.activity.MapEditRegionActivity p1)
    {
        return p1.viewHeight;
    }

    static synthetic float access$1602(com.jlboat.phone.activity.MapEditRegionActivity p0, float p1)
    {
        p0.viewHeight = p1;
        return p1;
    }

    static synthetic float access$1702(com.jlboat.phone.activity.MapEditRegionActivity p0, float p1)
    {
        p0.mSecondaryLastX = p1;
        return p1;
    }

    static synthetic float access$1802(com.jlboat.phone.activity.MapEditRegionActivity p0, float p1)
    {
        p0.mSecondaryLastY = p1;
        return p1;
    }

    static synthetic float access$1900(com.jlboat.phone.activity.MapEditRegionActivity p1)
    {
        return p1.movingx;
    }

    static synthetic float access$1902(com.jlboat.phone.activity.MapEditRegionActivity p0, float p1)
    {
        p0.movingx = p1;
        return p1;
    }

    static synthetic float access$2000(com.jlboat.phone.activity.MapEditRegionActivity p1)
    {
        return p1.movingy;
    }

    static synthetic float access$2002(com.jlboat.phone.activity.MapEditRegionActivity p0, float p1)
    {
        p0.movingy = p1;
        return p1;
    }

    static synthetic int access$202(com.jlboat.phone.activity.MapEditRegionActivity p0, int p1)
    {
        p0.regionProperty2 = p1;
        return p1;
    }

    static synthetic com.jlboat.phone.communication.SpiritServiceClient access$2100(com.jlboat.phone.activity.MapEditRegionActivity p1)
    {
        return p1.spiritServiceClient;
    }

    static synthetic boolean access$300(com.jlboat.phone.activity.MapEditRegionActivity p1)
    {
        return p1.isOk;
    }

    static synthetic void access$400(com.jlboat.phone.activity.MapEditRegionActivity p0, com.boat.support.slam.entity.floors.Region p1)
    {
        p0.showRegion(p1);
        return;
    }

    static synthetic java.util.List access$500(com.jlboat.phone.activity.MapEditRegionActivity p1)
    {
        return p1.pointsList;
    }

    static synthetic java.util.List access$502(com.jlboat.phone.activity.MapEditRegionActivity p0, java.util.List p1)
    {
        p0.pointsList = p1;
        return p1;
    }

    static synthetic void access$600(com.jlboat.phone.activity.MapEditRegionActivity p0, world_canvas_msgs18.SetRegionRequestEnty p1)
    {
        p0.delRegion(p1);
        return;
    }

    static synthetic int access$702(com.jlboat.phone.activity.MapEditRegionActivity p0, int p1)
    {
        p0.itemType = p1;
        return p1;
    }

    static synthetic long access$802(com.jlboat.phone.activity.MapEditRegionActivity p0, long p1)
    {
        p0.startRId = p1;
        return p1;
    }

    static synthetic long access$902(com.jlboat.phone.activity.MapEditRegionActivity p0, long p1)
    {
        p0.endRid = p1;
        return p1;
    }

    private void checkOkVis()
    {
        if ((this.itemType != 2) && ((this.itemType != 3) && ((this.itemType != 5) && (this.itemType != 6)))) {
            int v13 = 1;
            int v14 = 0;
        } else {
            v13 = 0;
            v14 = 8;
        }
        int v19;
        int v15;
        int v17;
        int v20;
        int v16;
        int v18;
        if (this.itemType != 1) {
            v15 = 1;
            v16 = 0;
            v17 = 0;
            v18 = 0;
            v19 = 8;
            v20 = 8;
        } else {
            v15 = 0;
            v16 = 1;
            v17 = 1;
            v18 = 8;
            v19 = 0;
            v20 = 0;
        }
        int v9_0 = new com.jlboat.phone.activity.MapEditRegionActivity$$ExternalSyntheticLambda0;
        com.jlboat.phone.activity.MapEditRegionActivity$$ExternalSyntheticLambda0 v11_1 = v9_0;
        v9_0(this, v19, v20, 0, v18, v14, v15, v13, v16, v17);
        new android.os.Handler(android.os.Looper.getMainLooper()).post(v11_1);
        return;
    }

    private void delRegion(world_canvas_msgs18.SetRegionRequestEnty p4)
    {
        android.util.Log.d("MapEditShapeActivity", new StringBuilder().append("delRegion: ").append(p4.getRegionId()).toString());
        if (this.spiritServiceClient != null) {
            this.spiritServiceClient.addOrDelRegionServer(p4, new com.jlboat.phone.activity.MapEditRegionActivity$10(this));
        }
        return;
    }

    private void digloagRid(int p8)
    {
        android.app.AlertDialog$Builder v0_1 = new android.app.AlertDialog$Builder(this);
        android.view.View v1_1 = this.getLayoutInflater().inflate(2131361854, 0);
        v0_1.setView(v1_1);
        android.app.AlertDialog v2_0 = v0_1.create();
        android.widget.TextView v3_2 = ((android.widget.TextView) v1_1.findViewById(2131231328));
        android.support.v7.widget.RecyclerView v4_2 = ((android.support.v7.widget.RecyclerView) v1_1.findViewById(2131231224));
        v4_2.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));
        com.jlboat.phone.adapter.NaviListAdapter v5_3 = new com.jlboat.phone.adapter.NaviListAdapter(this);
        v4_2.setAdapter(v5_3);
        v5_3.setOnLingclickItem(new com.jlboat.phone.activity.MapEditRegionActivity$9(this, p8, v2_0));
        v5_3.setListData(this.pointsList);
        if (p8 != 0) {
            if (p8 != 1) {
                if (p8 == 2) {
                    v3_2.setText(this.getResString(2131493397));
                }
            } else {
                v3_2.setText(this.getResString(2131493036));
            }
        } else {
            v3_2.setText(this.getResString(2131493197));
        }
        v2_0.show();
        return;
    }

    private void init()
    {
        this.spiritTopicListener = new com.jlboat.phone.communication.SpiritTopicListener();
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        this.linesList = new java.util.LinkedList();
        this.radioGroup.check(2131231127);
        this.ok.setVisibility(8);
        this.ivRectangle.setVisibility(8);
        return;
    }

    private void reset()
    {
        this.start_rid_tv.setText(this.getResString(2131492974));
        this.end_rid_tv.setText(this.getResString(2131492974));
        this.wait_rid_tv.setText(this.getResString(2131492974));
        this.mark_one_tv.setText(2131493338);
        this.mark_two_tv.setText(2131493338);
        return;
    }

    private void showRegion(com.boat.support.slam.entity.floors.Region p8)
    {
        if (p8.getRegionProperty1() != 0) {
            this.mark_one_tv.setText(new StringBuilder().append(p8.getRegionProperty1()).append("").toString());
        }
        if (p8.getRegionProperty2() != 0) {
            this.mark_two_tv.setText(new StringBuilder().append(p8.getRegionProperty2()).append("").toString());
        }
        android.widget.ImageView v0_4 = this.pointsList.iterator();
        while (v0_4.hasNext()) {
            int v1_6 = ((com.boat.support.slam.entity.floors.Points) v0_4.next());
            if (p8.getStartPointId() == v1_6.getPointId()) {
                this.start_rid_tv.setText(v1_6.getPointName());
            }
            if (p8.getEndPointId() == v1_6.getPointId()) {
                this.end_rid_tv.setText(v1_6.getPointName());
            }
            if (p8.getWaitPointId() == v1_6.getPointId()) {
                this.wait_rid_tv.setText(v1_6.getPointName());
            }
        }
        this.ok.setVisibility(8);
        this.add.setVisibility(0);
        this.ivRectangle.setVisibility(8);
        return;
    }

    public void initTopic()
    {
        this.spiritTopicListener.getWallUpdateMsg(new com.jlboat.phone.activity.MapEditRegionActivity$7(this));
        return;
    }

    synthetic void lambda$checkOkVis$0$com-jlboat-phone-activity-MapEditRegionActivity(int p6, int p7, int p8, int p9, int p10, boolean p11, boolean p12, boolean p13, boolean p14)
    {
        if (this.mark_two_ll.getVisibility() != p6) {
            this.mark_two_ll.setVisibility(p6);
        }
        if (this.mark_one_ll.getVisibility() != p7) {
            this.mark_one_ll.setVisibility(p7);
        }
        if (this.start_rid_ll.getVisibility() != p8) {
            this.start_rid_ll.setVisibility(p8);
        }
        if (this.end_rid_ll.getVisibility() != p9) {
            this.end_rid_ll.setVisibility(p9);
        }
        if (this.wait_rid_ll.getVisibility() != p10) {
            this.wait_rid_ll.setVisibility(p10);
        }
        if (((this.startRId == 0) || ((this.endRid == 0) && (p11))) || (((this.waitRid == 0) && (p12)) || (((this.regionProperty1 == 0) && (p13)) || ((this.regionProperty2 == 0) && (p14))))) {
            int v0_18 = 0;
        } else {
            v0_18 = 1;
        }
        this.isOk = v0_18;
        return;
    }

    public void onClick(android.view.View p17)
    {
        switch (p17.getId()) {
            case 2131230747:
                android.util.Log.d("MapEditShapeActivity", "onClick:digfloorRid ");
                this.ok.setVisibility(0);
                this.add.setVisibility(8);
                this.ivRectangle.setVisibility(0);
                this.mapView.setTagRegionId(0);
                this.reset();
                break;
            case 2131230756:
                if (this.mapView != null) {
                    android.widget.ImageView v1_21 = this.mapView.getRosMapPoint();
                    if (v1_21 != null) {
                        this.linesList.add(v1_21);
                        if (!this.linesList.isEmpty()) {
                            this.cancel.setVisibility(0);
                            if (this.linesList.size() >= 3) {
                                this.setid_ll.setVisibility(0);
                            }
                        }
                        this.mapView.setLinesStyle(this.linesList, 1);
                    } else {
                    }
                } else {
                }
                break;
            case 2131230839:
                this.linesList.clear();
                this.selectfloorList.clear();
                this.cancel.setVisibility(8);
                this.setid_ll.setVisibility(8);
                this.ok.setVisibility(8);
                break;
            case 2131230888:
                this.digloagRid(1);
                break;
            case 2131231054:
                android.util.Log.d("MapEditShapeActivity", "onClick: setRegionRequestEnty1: ");
                if (this.isOk) {
                    android.util.Log.d("MapEditShapeActivity", "onClick: setRegionRequestEnty3: ");
                    if (this.mapView != null) {
                        android.util.Log.d("MapEditShapeActivity", "onClick: setRegionRequestEnty4: ");
                        world_canvas_msgs18.SetRegionRequestEnty v2_3 = new world_canvas_msgs18.SetRegionRequestEnty();
                        v2_3.setType(this.itemType);
                        v2_3.setStartPointId(this.startRId);
                        v2_3.setEndPointId(this.endRid);
                        v2_3.setWaitPointId(this.waitRid);
                        v2_3.setRegionProperty2(this.regionProperty2);
                        v2_3.setRegionProperty1(this.regionProperty1);
                        java.util.LinkedList v8_7 = new java.util.LinkedList();
                        com.boat.support.slam.entity.floors.Lines v9_1 = this.mapView.getRosMapPoint(this.ivRectangle.getLeft(), (this.ivRectangle.getTop() + this.ivRectangle.getHeight()));
                        if (v9_1 != null) {
                            com.boat.support.slam.entity.floors.Lines v10_3 = this.mapView.getRosMapPoint(this.ivRectangle.getLeft(), this.ivRectangle.getTop());
                            if (v10_3 != null) {
                                com.boat.support.slam.entity.floors.Lines v11_6 = this.mapView.getRosMapPoint((this.ivRectangle.getLeft() + this.ivRectangle.getWidth()), this.ivRectangle.getTop());
                                if (v11_6 != null) {
                                    com.boat.support.slam.entity.floors.Lines v12_8 = this.mapView.getRosMapPoint((this.ivRectangle.getLeft() + this.ivRectangle.getWidth()), (this.ivRectangle.getTop() + this.ivRectangle.getHeight()));
                                    if (v12_8 != null) {
                                        android.util.Log.d("MapEditShapeActivity", "onClick: setRegionRequestEnty3: ");
                                        v8_7.add(v9_1);
                                        v8_7.add(v10_3);
                                        v8_7.add(v11_6);
                                        v8_7.add(v12_8);
                                        v2_3.setPoints(v8_7);
                                        android.util.Log.d("MapEditShapeActivity", new StringBuilder().append("onClick: setRegionRequestEnty: ").append(v2_3.toString()).toString());
                                        this.spiritServiceClient.addOrDelRegionServer(v2_3, new com.jlboat.phone.activity.MapEditRegionActivity$8(this));
                                        this.startRId = 0;
                                        this.endRid = 0;
                                        this.waitRid = 0;
                                        this.reset().checkOkVis();
                                        this.ok.setVisibility(8);
                                        this.add.setVisibility(0);
                                        this.ivRectangle.setVisibility(8);
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                    android.util.Log.d("MapEditShapeActivity", "onClick: setRegionRequestEnty2: ");
                    this.toast(2131493248);
                    android.util.Log.d("MapEditShapeActivity", "onClick: setRegionRequestEnt5: ");
                }
                break;
            case 2131231250:
                break;
            case 2131231270:
                this.digloagRid(0);
                break;
            case 2131231361:
                this.digloagRid(2);
                break;
            default:
        }
        return;
    }

    protected void onCreate(android.os.Bundle p3)
    {
        this.initTitleBar(2131361897, 2131492936);
        super.onCreate(p3);
        this.mapView = ((com.jlboat.phone.view.MapView) this.findViewById(2131230984));
        this.radioGroup = ((android.widget.RadioGroup) this.findViewById(2131231170));
        this.shapeRy = ((android.support.v7.widget.RecyclerView) this.findViewById(2131231251));
        this.setid_ll = ((android.widget.LinearLayout) this.findViewById(2131231250));
        this.start_rid_ll = ((android.widget.LinearLayout) this.findViewById(2131231270));
        this.end_rid_ll = ((android.widget.LinearLayout) this.findViewById(2131230888));
        this.wait_rid_ll = ((android.widget.LinearLayout) this.findViewById(2131231361));
        this.mark_one_ll = ((android.widget.LinearLayout) this.findViewById(2131230987));
        this.mark_two_ll = ((android.widget.LinearLayout) this.findViewById(2131230989));
        this.mark_two_tv = ((android.widget.EditText) this.findViewById(2131230990));
        this.mark_two_tv.setImeOptions(6);
        this.mark_two_tv.setOnClickListener(this);
        this.mark_one_tv = ((android.widget.EditText) this.findViewById(2131230988));
        this.mark_one_tv.setImeOptions(6);
        this.mark_one_tv.setOnClickListener(this);
        this.mark_one_tv.addTextChangedListener(new com.jlboat.phone.activity.MapEditRegionActivity$1(this));
        this.mark_two_tv.addTextChangedListener(new com.jlboat.phone.activity.MapEditRegionActivity$2(this));
        this.start_rid_tv = ((android.widget.TextView) this.findViewById(2131231271));
        this.end_rid_tv = ((android.widget.TextView) this.findViewById(2131230889));
        this.wait_rid_tv = ((android.widget.TextView) this.findViewById(2131231362));
        this.ivRectangle = ((android.widget.ImageView) this.findViewById(2131230947));
        this.addpoint = ((android.widget.Button) this.findViewById(2131230756));
        this.cancel = ((android.widget.Button) this.findViewById(2131230839));
        this.ok = ((android.widget.Button) this.findViewById(2131231054));
        this.add = ((android.widget.Button) this.findViewById(2131230747));
        this.shapeRy.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));
        this.RegionListAdapter = new com.jlboat.phone.adapter.RegionListAdapter(this);
        this.RegionListAdapter.setOnclickItem(new com.jlboat.phone.activity.MapEditRegionActivity$3(this));
        this.RegionListAdapter.setOnLingclickItem(new com.jlboat.phone.activity.MapEditRegionActivity$4(this));
        this.shapeRy.setAdapter(this.RegionListAdapter);
        this.radioGroup.setOnCheckedChangeListener(new com.jlboat.phone.activity.MapEditRegionActivity$5(this));
        this.ivRectangle.setOnTouchListener(new com.jlboat.phone.activity.MapEditRegionActivity$6(this));
        this.addpoint.setOnClickListener(this);
        this.cancel.setOnClickListener(this);
        this.ok.setOnClickListener(this);
        this.add.setOnClickListener(this);
        this.start_rid_ll.setOnClickListener(this);
        this.end_rid_ll.setOnClickListener(this);
        this.wait_rid_ll.setOnClickListener(this);
        this.mark_two_ll.setOnClickListener(this);
        this.mapView.setEdit(1);
        this.init();
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
