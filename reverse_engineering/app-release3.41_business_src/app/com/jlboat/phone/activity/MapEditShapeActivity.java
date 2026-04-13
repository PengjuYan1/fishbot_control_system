package com.jlboat.phone.activity;
public class MapEditShapeActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private static final String TAG = "MapEditShapeActivity";
    android.widget.Button addpoint;
    android.widget.Button cancel;
    private int itemType;
    android.widget.ImageView ivMark;
    android.widget.ImageView ivRectangle;
    android.widget.ImageView ivRound;
    java.util.List linesList;
    android.widget.LinearLayout llOk;
    private float mPrimaryLastX;
    private float mPrimaryLastY;
    private float mSecondaryLastX;
    private float mSecondaryLastY;
    com.jlboat.phone.view.MapView mapView;
    private float movingx;
    private float movingy;
    android.widget.Button ok;
    private android.widget.RelativeLayout$LayoutParams params;
    android.widget.RadioGroup radioGroup;
    com.jlboat.phone.adapter.ShapeListAdapter shapeListAdapter;
    android.support.v7.widget.RecyclerView shapeRy;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.SpiritTopicListener spiritTopicListener;
    private float viewHeight;
    private float viewWidth;

    public MapEditShapeActivity()
    {
        this.mPrimaryLastX = -1082130432;
        this.mPrimaryLastY = -1082130432;
        this.mSecondaryLastX = -1082130432;
        this.mSecondaryLastY = -1082130432;
        this.movingx = -1082130432;
        this.movingy = -1082130432;
        return;
    }

    static synthetic void access$000(com.jlboat.phone.activity.MapEditShapeActivity p0, world_canvas_msgs18.SetShapeRequestEnty p1)
    {
        p0.delShape(p1);
        return;
    }

    static synthetic float access$1000(com.jlboat.phone.activity.MapEditShapeActivity p1)
    {
        return p1.movingy;
    }

    static synthetic float access$1002(com.jlboat.phone.activity.MapEditShapeActivity p0, float p1)
    {
        p0.movingy = p1;
        return p1;
    }

    static synthetic int access$102(com.jlboat.phone.activity.MapEditShapeActivity p0, int p1)
    {
        p0.itemType = p1;
        return p1;
    }

    static synthetic com.jlboat.phone.communication.SpiritServiceClient access$1100(com.jlboat.phone.activity.MapEditShapeActivity p1)
    {
        return p1.spiritServiceClient;
    }

    static synthetic float access$200(com.jlboat.phone.activity.MapEditShapeActivity p1)
    {
        return p1.mPrimaryLastX;
    }

    static synthetic float access$202(com.jlboat.phone.activity.MapEditShapeActivity p0, float p1)
    {
        p0.mPrimaryLastX = p1;
        return p1;
    }

    static synthetic float access$300(com.jlboat.phone.activity.MapEditShapeActivity p1)
    {
        return p1.mPrimaryLastY;
    }

    static synthetic float access$302(com.jlboat.phone.activity.MapEditShapeActivity p0, float p1)
    {
        p0.mPrimaryLastY = p1;
        return p1;
    }

    static synthetic android.widget.RelativeLayout$LayoutParams access$400(com.jlboat.phone.activity.MapEditShapeActivity p1)
    {
        return p1.params;
    }

    static synthetic android.widget.RelativeLayout$LayoutParams access$402(com.jlboat.phone.activity.MapEditShapeActivity p0, android.widget.RelativeLayout$LayoutParams p1)
    {
        p0.params = p1;
        return p1;
    }

    static synthetic float access$500(com.jlboat.phone.activity.MapEditShapeActivity p1)
    {
        return p1.viewWidth;
    }

    static synthetic float access$502(com.jlboat.phone.activity.MapEditShapeActivity p0, float p1)
    {
        p0.viewWidth = p1;
        return p1;
    }

    static synthetic float access$600(com.jlboat.phone.activity.MapEditShapeActivity p1)
    {
        return p1.viewHeight;
    }

    static synthetic float access$602(com.jlboat.phone.activity.MapEditShapeActivity p0, float p1)
    {
        p0.viewHeight = p1;
        return p1;
    }

    static synthetic float access$702(com.jlboat.phone.activity.MapEditShapeActivity p0, float p1)
    {
        p0.mSecondaryLastX = p1;
        return p1;
    }

    static synthetic float access$802(com.jlboat.phone.activity.MapEditShapeActivity p0, float p1)
    {
        p0.mSecondaryLastY = p1;
        return p1;
    }

    static synthetic float access$900(com.jlboat.phone.activity.MapEditShapeActivity p1)
    {
        return p1.movingx;
    }

    static synthetic float access$902(com.jlboat.phone.activity.MapEditShapeActivity p0, float p1)
    {
        p0.movingx = p1;
        return p1;
    }

    private void delShape(world_canvas_msgs18.SetShapeRequestEnty p4)
    {
        android.util.Log.d("MapEditShapeActivity", new StringBuilder().append("delShape: ").append(p4.getShapeId()).toString());
        if (this.spiritServiceClient != null) {
            this.spiritServiceClient.addOrDelShapeServer(p4, new com.jlboat.phone.activity.MapEditShapeActivity$7(this));
        }
        return;
    }

    private void init()
    {
        this.spiritTopicListener = new com.jlboat.phone.communication.SpiritTopicListener();
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        this.linesList = new java.util.LinkedList();
        this.radioGroup.check(2131231130);
        return;
    }

    public void initTopic()
    {
        this.spiritTopicListener.getWallUpdateMsg(new com.jlboat.phone.activity.MapEditShapeActivity$5(this));
        return;
    }

    public void onClick(android.view.View p15)
    {
        switch (p15.getId()) {
            case 2131230756:
                if ((this.mapView == null) || (this.itemType != 0)) {
                } else {
                    com.boat.support.slam.entity.floors.Lines v0_7 = this.mapView.getRosMapPoint();
                    if (v0_7 != null) {
                        this.linesList.add(v0_7);
                        if (!this.linesList.isEmpty()) {
                            this.ok.setVisibility(0);
                            this.cancel.setVisibility(0);
                        }
                        this.mapView.setLinesStyle(this.linesList);
                    } else {
                    }
                }
                break;
            case 2131230839:
                this.linesList.clear();
                this.cancel.setVisibility(8);
                this.ok.setVisibility(8);
                break;
            case 2131231054:
                if (this.mapView != null) {
                    com.boat.support.slam.entity.floors.Lines v0_10 = new world_canvas_msgs18.SetShapeRequestEnty();
                    v0_10.setClosed(0);
                    v0_10.setType("lines");
                    com.jlboat.phone.view.MapView v1_2 = new java.util.LinkedList();
                    if (this.itemType == 0) {
                        this.cancel.setVisibility(8);
                        this.ok.setVisibility(8);
                        if (!this.linesList.isEmpty()) {
                            v0_10.setPoints(this.linesList);
                        }
                    }
                    if (this.itemType == 1) {
                        v0_10.setClosed(1);
                        com.jlboat.phone.communication.SpiritServiceClient v2_13 = this.mapView.getRosMapPoint(this.ivRectangle.getLeft(), (this.ivRectangle.getTop() + this.ivRectangle.getHeight()));
                        if (v2_13 != null) {
                            com.boat.support.slam.entity.floors.Lines v3_12 = this.mapView.getRosMapPoint(this.ivRectangle.getLeft(), this.ivRectangle.getTop());
                            if (v3_12 != null) {
                                float v4_17 = this.mapView.getRosMapPoint((this.ivRectangle.getLeft() + this.ivRectangle.getWidth()), this.ivRectangle.getTop());
                                if (v4_17 != 0) {
                                    com.boat.support.slam.entity.floors.Lines v5_10 = this.mapView.getRosMapPoint((this.ivRectangle.getLeft() + this.ivRectangle.getWidth()), (this.ivRectangle.getTop() + this.ivRectangle.getHeight()));
                                    if (v5_10 != null) {
                                        v1_2.add(v2_13);
                                        v1_2.add(v3_12);
                                        v1_2.add(v4_17);
                                        v1_2.add(v5_10);
                                        v0_10.setPoints(v1_2);
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    }
                    if (this.itemType == 2) {
                        v0_10.setType("circle");
                        com.jlboat.phone.communication.SpiritServiceClient v2_17 = this.mapView.getRosMapPoint();
                        android.util.Log.d("MapEditShapeActivity", new StringBuilder().append("onClick: ").append(v2_17).toString());
                        if (v2_17 != null) {
                            com.boat.support.slam.entity.floors.Lines v3_2 = this.mapView.getRosMapPoint((this.ivRound.getLeft() + (this.ivRound.getWidth() / 2)), this.ivRound.getTop());
                            if (v3_2 != null) {
                                double v6_8 = Math.sqrt(Math.abs((((v2_17.getX() - v3_2.getX()) * (v2_17.getX() - v3_2.getX())) + ((v2_17.getY() - v3_2.getY()) * (v2_17.getY() - v3_2.getY())))));
                                android.util.Log.d("MapEditShapeActivity", new StringBuilder().append("onClick: \u4e24\u70b9\u95f4\u7684\u8ddd\u79bb\u662f:").append(v6_8).toString());
                                v1_2.add(v2_17);
                                v0_10.setPoints(v1_2);
                                v0_10.setRadius(((float) v6_8));
                            } else {
                            }
                        } else {
                        }
                    }
                    this.spiritServiceClient.addOrDelShapeServer(v0_10, new com.jlboat.phone.activity.MapEditShapeActivity$6(this));
                } else {
                }
                break;
            default:
        }
        return;
    }

    protected void onCreate(android.os.Bundle p3)
    {
        this.initTitleBar(2131361898, 2131492935);
        super.onCreate(p3);
        this.mapView = ((com.jlboat.phone.view.MapView) this.findViewById(2131230984));
        this.radioGroup = ((android.widget.RadioGroup) this.findViewById(2131231170));
        this.shapeRy = ((android.support.v7.widget.RecyclerView) this.findViewById(2131231251));
        this.ivMark = ((android.widget.ImageView) this.findViewById(2131230944));
        this.ivRectangle = ((android.widget.ImageView) this.findViewById(2131230946));
        this.ivRound = ((android.widget.ImageView) this.findViewById(2131230948));
        this.llOk = ((android.widget.LinearLayout) this.findViewById(2131230971));
        this.addpoint = ((android.widget.Button) this.findViewById(2131230756));
        this.cancel = ((android.widget.Button) this.findViewById(2131230839));
        this.ok = ((android.widget.Button) this.findViewById(2131231054));
        this.shapeRy.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));
        this.shapeListAdapter = new com.jlboat.phone.adapter.ShapeListAdapter(this);
        this.shapeListAdapter.setOnclickItem(new com.jlboat.phone.activity.MapEditShapeActivity$1(this));
        this.shapeListAdapter.setOnLingclickItem(new com.jlboat.phone.activity.MapEditShapeActivity$2(this));
        this.shapeRy.setAdapter(this.shapeListAdapter);
        this.radioGroup.setOnCheckedChangeListener(new com.jlboat.phone.activity.MapEditShapeActivity$3(this));
        this.addpoint.setOnClickListener(this);
        this.cancel.setOnClickListener(this);
        this.ok.setOnClickListener(this);
        this.ivRectangle.setOnTouchListener(new com.jlboat.phone.activity.MapEditShapeActivity$4(this));
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
