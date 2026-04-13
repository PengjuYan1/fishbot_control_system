package com.jlboat.phone.activity;
public class TestResultActivity202508 extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private static final String TAG = "TestResultActivity";
    private static final int TEST_CANCLE = 7;
    private com.jlboat.phone.adapter.TestResultAdapter250816 adapter;
    private int cycleCount;
    private com.boat.jrosbridge.Topic delTargetGoal;
    private long firstTime;
    private boolean isCycle;
    private boolean isEnd;
    private com.boat.support.slam.entity.floors.MapList localMapList;
    private java.util.ArrayList nameList;
    private android.widget.Button resCancleBtn;
    private com.boat.jrosbridge.Topic settargetGoalType;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.SpiritTopicListener spiritTopicListener;
    private com.boat.jrosbridge.Topic stopNaviPublish;
    private com.jlboat.phone.message.map_msgs.TargetGoalEntryDel targetGoalEntryDel;
    private android.support.v7.widget.RecyclerView testResRv;
    private String time_title;
    private android.widget.RelativeLayout titleLabelRv;
    private android.widget.TextView title_cycle;
    private android.widget.TextView title_time;
    private android.widget.TextView title_times;
    private android.widget.TextView title_wait;
    private int type;

    public TestResultActivity202508()
    {
        this.nameList = new java.util.ArrayList();
        this.firstTime = 0;
        this.time_title = "";
        return;
    }

    static synthetic boolean access$002(com.jlboat.phone.activity.TestResultActivity202508 p0, boolean p1)
    {
        p0.isCycle = p1;
        return p1;
    }

    static synthetic int access$102(com.jlboat.phone.activity.TestResultActivity202508 p0, int p1)
    {
        p0.cycleCount = p1;
        return p1;
    }

    static synthetic com.boat.support.slam.entity.floors.MapList access$200(com.jlboat.phone.activity.TestResultActivity202508 p1)
    {
        return p1.localMapList;
    }

    static synthetic com.boat.support.slam.entity.floors.MapList access$202(com.jlboat.phone.activity.TestResultActivity202508 p0, com.boat.support.slam.entity.floors.MapList p1)
    {
        p0.localMapList = p1;
        return p1;
    }

    static synthetic void access$300(com.jlboat.phone.activity.TestResultActivity202508 p0, java.util.List p1, com.boat.support.slam.entity.floors.MapList p2)
    {
        p0.processDataAndUpdateUI(p1, p2);
        return;
    }

    static synthetic com.jlboat.phone.communication.SpiritServiceClient access$400(com.jlboat.phone.activity.TestResultActivity202508 p1)
    {
        return p1.spiritServiceClient;
    }

    static synthetic android.widget.TextView access$500(com.jlboat.phone.activity.TestResultActivity202508 p1)
    {
        return p1.title_time;
    }

    private void cancleTest()
    {
        com.boat.jrosbridge.message.std_msgs.Int16 v0_1 = new com.boat.jrosbridge.message.std_msgs.Int16();
        v0_1.setData(5);
        this.stopNaviPublish.publish(v0_1);
        return;
    }

    private void initView()
    {
        this.testResRv = ((android.support.v7.widget.RecyclerView) this.findViewById(2131231288));
        this.titleLabelRv = ((android.widget.RelativeLayout) this.findViewById(2131231316));
        this.title_time = ((android.widget.TextView) this.findViewById(2131231319));
        this.title_times = ((android.widget.TextView) this.findViewById(2131231319));
        this.title_wait = ((android.widget.TextView) this.findViewById(2131231321));
        this.title_cycle = ((android.widget.TextView) this.findViewById(2131231315));
        this.resCancleBtn = ((android.widget.Button) this.findViewById(2131231149));
        this.resCancleBtn.setOnClickListener(this);
        this.adapter = new com.jlboat.phone.adapter.TestResultAdapter250816(this);
        this.testResRv.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));
        this.testResRv.setAdapter(this.adapter);
        return;
    }

    private void processDataAndUpdateUI(java.util.List p6, com.boat.support.slam.entity.floors.MapList p7)
    {
        int v0 = 1;
        int v1_1 = p6.iterator();
        while (v1_1.hasNext()) {
            if (((com.jlboat.phone.message.map_msgs.TargetGoalEntry) v1_1.next()).getStatus() != 2) {
                v0 = 0;
                break;
            }
        }
        this.testResRv.post(new com.jlboat.phone.activity.TestResultActivity202508$$ExternalSyntheticLambda0(this, p7, p6, v0));
        return;
    }

    private void stopTopic()
    {
        this.stopNaviPublish.unadvertise();
        return;
    }

    public void initTopic()
    {
        this.stopNaviPublish = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.NaviStop, com.boat.jrosbridge.message.std_msgs.Int16, com.jlboat.phone.application.BoatSlamApplication.client);
        this.stopNaviPublish.advertise();
        this.spiritTopicListener.getNaviTargetgoalList(new com.jlboat.phone.activity.TestResultActivity202508$1(this));
        this.spiritTopicListener.getNaviWait(new com.jlboat.phone.activity.TestResultActivity202508$2(this));
        return;
    }

    synthetic void lambda$processDataAndUpdateUI$0$com-jlboat-phone-activity-TestResultActivity202508(com.boat.support.slam.entity.floors.MapList p4, java.util.List p5, boolean p6)
    {
        this.adapter.setData2(p4);
        this.adapter.setData3(this.isCycle, this.cycleCount);
        this.adapter.setData(p5);
        android.util.Log.d("TestResultActivity", new StringBuilder().append("resultEntries:").append(p5).toString());
        android.util.Log.d("TestResultActivity", new StringBuilder().append("isCycle:").append(this.isCycle).toString());
        android.util.Log.d("TestResultActivity", new StringBuilder().append("cycleCount:").append(this.cycleCount).toString());
        if (!p6) {
            this.resCancleBtn.setVisibility(0);
        } else {
            this.resCancleBtn.setVisibility(8);
        }
        if (!this.isCycle) {
            this.title_cycle.setText(this.getResString(2131493230));
        } else {
            this.title_cycle.setText(this.getResString(this.cycleCount));
        }
        this.title_time.setText(this.time_title);
        return;
    }

    public void onBackPressed()
    {
        long v0 = System.currentTimeMillis();
        if (!this.isEnd) {
            if ((v0 - this.firstTime) <= 2000) {
                this.finish();
            } else {
                com.jlboat.phone.util.Utils.toast("\u518d\u70b9\u4e00\u6b21\u8fd4\u56de,\u6d4b\u8bd5\u7a0b\u5e8f\u4e0d\u4f1a\u505c\u6b62");
                this.firstTime = v0;
            }
        } else {
            this.finish();
        }
        return;
    }

    public void onClick(android.view.View p2)
    {
        switch (p2.getId()) {
            case 2131231149:
                this.cancleTest();
                break;
            default:
        }
        return;
    }

    protected void onCreate(android.os.Bundle p4)
    {
        super.onCreate(p4);
        this.type = this.getIntent().getIntExtra("type", -1);
        this.initTitleBar(2131361833, 2131493220);
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        this.spiritTopicListener = new com.jlboat.phone.communication.SpiritTopicListener();
        this.initView();
        return;
    }

    protected void onPause()
    {
        super.onPause();
        this.stopTopic();
        return;
    }

    protected void onResume()
    {
        super.onResume();
        this.initTopic();
        return;
    }
}
