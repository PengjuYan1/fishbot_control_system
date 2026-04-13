package com.jlboat.phone.activity;
public class MapCleanAreaActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private static final String TAG = "MapCleanAreaActivity";
    android.widget.Button add;
    android.widget.Button bt_start_clean_area;
    android.widget.Button cancel;
    com.jlboat.phone.adapter.CleanAreaRvAdapter cleanAreaRvAdapter;
    private java.util.List cleanAreas;
    private int itemType;
    android.widget.ImageView ivCleanRectangle;
    java.util.List linesList;
    android.widget.LinearLayout llOk;
    private java.util.List longs;
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
    android.support.v7.widget.RecyclerView recyclerView;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.SpiritTopicListener spiritTopicListener;
    private com.boat.jrosbridge.Topic startCleanAreaPublish;
    private float viewHeight;
    private float viewWidth;

    public MapCleanAreaActivity()
    {
        this.longs = new java.util.LinkedList();
        this.mPrimaryLastX = -1082130432;
        this.mPrimaryLastY = -1082130432;
        this.mSecondaryLastX = -1082130432;
        this.mSecondaryLastY = -1082130432;
        this.movingx = -1082130432;
        this.movingy = -1082130432;
        return;
    }

    static synthetic java.util.List access$000(com.jlboat.phone.activity.MapCleanAreaActivity p1)
    {
        return p1.cleanAreas;
    }

    static synthetic java.util.List access$002(com.jlboat.phone.activity.MapCleanAreaActivity p0, java.util.List p1)
    {
        p0.cleanAreas = p1;
        return p1;
    }

    static synthetic java.util.List access$100(com.jlboat.phone.activity.MapCleanAreaActivity p1)
    {
        return p1.longs;
    }

    static synthetic float access$1002(com.jlboat.phone.activity.MapCleanAreaActivity p0, float p1)
    {
        p0.mSecondaryLastY = p1;
        return p1;
    }

    static synthetic float access$1100(com.jlboat.phone.activity.MapCleanAreaActivity p1)
    {
        return p1.movingx;
    }

    static synthetic float access$1102(com.jlboat.phone.activity.MapCleanAreaActivity p0, float p1)
    {
        p0.movingx = p1;
        return p1;
    }

    static synthetic float access$1200(com.jlboat.phone.activity.MapCleanAreaActivity p1)
    {
        return p1.movingy;
    }

    static synthetic float access$1202(com.jlboat.phone.activity.MapCleanAreaActivity p0, float p1)
    {
        p0.movingy = p1;
        return p1;
    }

    static synthetic void access$1300(com.jlboat.phone.activity.MapCleanAreaActivity p0, String p1)
    {
        p0.checkClenaArea(p1);
        return;
    }

    static synthetic com.jlboat.phone.communication.SpiritServiceClient access$1400(com.jlboat.phone.activity.MapCleanAreaActivity p1)
    {
        return p1.spiritServiceClient;
    }

    static synthetic void access$200(com.jlboat.phone.activity.MapCleanAreaActivity p0, boolean p1, world_canvas_msgs18.SetCleanAreaEnty p2)
    {
        p0.addOrDelCleanArea(p1, p2);
        return;
    }

    static synthetic int access$302(com.jlboat.phone.activity.MapCleanAreaActivity p0, int p1)
    {
        p0.itemType = p1;
        return p1;
    }

    static synthetic float access$400(com.jlboat.phone.activity.MapCleanAreaActivity p1)
    {
        return p1.mPrimaryLastX;
    }

    static synthetic float access$402(com.jlboat.phone.activity.MapCleanAreaActivity p0, float p1)
    {
        p0.mPrimaryLastX = p1;
        return p1;
    }

    static synthetic float access$500(com.jlboat.phone.activity.MapCleanAreaActivity p1)
    {
        return p1.mPrimaryLastY;
    }

    static synthetic float access$502(com.jlboat.phone.activity.MapCleanAreaActivity p0, float p1)
    {
        p0.mPrimaryLastY = p1;
        return p1;
    }

    static synthetic android.widget.RelativeLayout$LayoutParams access$600(com.jlboat.phone.activity.MapCleanAreaActivity p1)
    {
        return p1.params;
    }

    static synthetic android.widget.RelativeLayout$LayoutParams access$602(com.jlboat.phone.activity.MapCleanAreaActivity p0, android.widget.RelativeLayout$LayoutParams p1)
    {
        p0.params = p1;
        return p1;
    }

    static synthetic float access$700(com.jlboat.phone.activity.MapCleanAreaActivity p1)
    {
        return p1.viewWidth;
    }

    static synthetic float access$702(com.jlboat.phone.activity.MapCleanAreaActivity p0, float p1)
    {
        p0.viewWidth = p1;
        return p1;
    }

    static synthetic float access$800(com.jlboat.phone.activity.MapCleanAreaActivity p1)
    {
        return p1.viewHeight;
    }

    static synthetic float access$802(com.jlboat.phone.activity.MapCleanAreaActivity p0, float p1)
    {
        p0.viewHeight = p1;
        return p1;
    }

    static synthetic float access$902(com.jlboat.phone.activity.MapCleanAreaActivity p0, float p1)
    {
        p0.mSecondaryLastX = p1;
        return p1;
    }

    private void addOrDelCleanArea(boolean p4, world_canvas_msgs18.SetCleanAreaEnty p5)
    {
        android.util.Log.d("MapCleanAreaActivity", new StringBuilder().append("addOrDelCleanArea: ").append(p5.getCleanAreaId()).toString());
        if (this.spiritServiceClient != null) {
            this.spiritServiceClient.addOrDelCleanAreaServer(p5, new com.jlboat.phone.activity.MapCleanAreaActivity$9(this, p4));
        }
        return;
    }

    private void checkClenaArea(String p11)
    {
        world_canvas_msgs18.SetCleanAreaEnty v0_1 = new world_canvas_msgs18.SetCleanAreaEnty();
        v0_1.setName(p11);
        v0_1.setClosed(0);
        v0_1.setType("lines");
        java.util.LinkedList v1_3 = new java.util.LinkedList();
        if (this.itemType == 1) {
            v0_1.setClosed(1);
            com.boat.support.slam.entity.floors.Lines v2_1 = this.mapView.getRosMapPoint(this.ivCleanRectangle.getLeft(), (this.ivCleanRectangle.getTop() + this.ivCleanRectangle.getHeight()));
            if (v2_1 != null) {
                com.boat.support.slam.entity.floors.Lines v4_3 = this.mapView.getRosMapPoint(this.ivCleanRectangle.getLeft(), this.ivCleanRectangle.getTop());
                if (v4_3 != null) {
                    com.boat.support.slam.entity.floors.Lines v5_6 = this.mapView.getRosMapPoint((this.ivCleanRectangle.getLeft() + this.ivCleanRectangle.getWidth()), this.ivCleanRectangle.getTop());
                    if (v5_6 != null) {
                        com.boat.support.slam.entity.floors.Lines v6_8 = this.mapView.getRosMapPoint((this.ivCleanRectangle.getLeft() + this.ivCleanRectangle.getWidth()), (this.ivCleanRectangle.getTop() + this.ivCleanRectangle.getHeight()));
                        if (v6_8 != null) {
                            v1_3.add(v2_1);
                            v1_3.add(v4_3);
                            v1_3.add(v5_6);
                            v1_3.add(v6_8);
                            v0_1.setPoints(v1_3);
                            this.addOrDelCleanArea(1, v0_1);
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        return;
    }

    private void init()
    {
        this.spiritTopicListener = new com.jlboat.phone.communication.SpiritTopicListener();
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        this.linesList = new java.util.LinkedList();
        return;
    }

    public void initTopic()
    {
        this.startCleanAreaPublish = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.CleanArea, com.boat.jrosbridge.message.std_msgs.Int64MultiArray, com.jlboat.phone.application.BoatSlamApplication.client);
        this.spiritTopicListener.getWallUpdateMsg(new com.jlboat.phone.activity.MapCleanAreaActivity$8(this));
        return;
    }

    public void onClick(android.view.View p9)
    {
        switch (p9.getId()) {
            case 2131230826:
                android.app.AlertDialog$Builder v0_4 = new long[this.longs.size()];
                com.boat.jrosbridge.message.std_msgs.Int64MultiArray v1_0 = 0;
                while (v1_0 < this.longs.size()) {
                    v0_4[v1_0] = ((Long) this.longs.get(v1_0)).longValue();
                    v1_0++;
                }
                android.util.Log.d("MapCleanAreaActivity", new StringBuilder().append("onClick: longs1 ").append(java.util.Arrays.toString(v0_4)).toString());
                com.boat.jrosbridge.message.std_msgs.Int64MultiArray v1_7 = new com.boat.jrosbridge.message.std_msgs.Int64MultiArray();
                v1_7.setData(v0_4);
                this.startCleanAreaPublish.publish(v1_7);
                break;
            case 2131231054:
                if (this.mapView != null) {
                    com.boat.jrosbridge.message.std_msgs.Int64MultiArray v1_8 = new android.app.AlertDialog$Builder(this).create();
                    com.boat.jrosbridge.Topic v2_1 = this.getLayoutInflater().inflate(2131361846, 0);
                    android.widget.TextView v3_3 = ((android.widget.TextView) v2_1.findViewById(2131231328));
                    android.widget.Button v6_2 = ((android.widget.Button) v2_1.findViewById(2131230799));
                    ((android.widget.Button) v2_1.findViewById(2131230802)).setOnClickListener(new com.jlboat.phone.activity.MapCleanAreaActivity$6(this, ((android.widget.EditText) v2_1.findViewById(2131230901)), v1_8));
                    v6_2.setOnClickListener(new com.jlboat.phone.activity.MapCleanAreaActivity$7(this, v1_8));
                    v3_3.setText(this.getResString(2131492981));
                    v1_8.setView(v2_1);
                    v1_8.show();
                } else {
                }
                break;
            default:
        }
        return;
    }

    protected void onCreate(android.os.Bundle p3)
    {
        this.initTitleBar(2131361890, 2131492945);
        super.onCreate(p3);
        this.mapView = ((com.jlboat.phone.view.MapView) this.findViewById(2131230986));
        this.ivCleanRectangle = ((android.widget.ImageView) this.findViewById(2131230942));
        this.radioGroup = ((android.widget.RadioGroup) this.findViewById(2131231166));
        this.llOk = ((android.widget.LinearLayout) this.findViewById(2131230971));
        this.add = ((android.widget.Button) this.findViewById(2131230747));
        this.cancel = ((android.widget.Button) this.findViewById(2131230839));
        this.ok = ((android.widget.Button) this.findViewById(2131231054));
        this.bt_start_clean_area = ((android.widget.Button) this.findViewById(2131230826));
        this.recyclerView = ((android.support.v7.widget.RecyclerView) this.findViewById(2131230852));
        this.recyclerView.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));
        this.cleanAreaRvAdapter = new com.jlboat.phone.adapter.CleanAreaRvAdapter(this);
        this.cleanAreaRvAdapter.setOnclickItem(new com.jlboat.phone.activity.MapCleanAreaActivity$1(this));
        this.cleanAreaRvAdapter.setOnCheckedChangeListener(new com.jlboat.phone.activity.MapCleanAreaActivity$2(this));
        this.cleanAreaRvAdapter.setOnLingclickItem(new com.jlboat.phone.activity.MapCleanAreaActivity$3(this));
        this.recyclerView.setAdapter(this.cleanAreaRvAdapter);
        this.radioGroup.setOnCheckedChangeListener(new com.jlboat.phone.activity.MapCleanAreaActivity$4(this));
        this.add.setOnClickListener(this);
        this.cancel.setOnClickListener(this);
        this.ok.setOnClickListener(this);
        this.bt_start_clean_area.setOnClickListener(this);
        this.ivCleanRectangle.setOnTouchListener(new com.jlboat.phone.activity.MapCleanAreaActivity$5(this));
        this.mapView.setUseCleanPath(1);
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
