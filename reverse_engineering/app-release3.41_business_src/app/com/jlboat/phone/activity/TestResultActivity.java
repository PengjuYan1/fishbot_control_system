package com.jlboat.phone.activity;
public class TestResultActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private static final String TAG = "TestResultActivity";
    private static final int TEST_CANCLE = 7;
    private com.jlboat.phone.adapter.TestResultAdapter adapter;
    private long firstTime;
    private boolean isEnd;
    private com.boat.support.slam.entity.floors.MapList localMapList;
    private java.util.ArrayList nameList;
    private android.widget.Button resCancleBtn;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.SpiritTopicListener spiritTopicListener;
    private android.support.v7.widget.RecyclerView testResRv;
    private String time_title;
    private android.widget.TextView title_time;
    private int type;

    public TestResultActivity()
    {
        this.nameList = new java.util.ArrayList();
        this.firstTime = 0;
        this.time_title = "";
        return;
    }

    static synthetic String access$000(com.jlboat.phone.activity.TestResultActivity p1)
    {
        return p1.time_title;
    }

    static synthetic String access$002(com.jlboat.phone.activity.TestResultActivity p0, String p1)
    {
        p0.time_title = p1;
        return p1;
    }

    static synthetic com.boat.support.slam.entity.floors.MapList access$100(com.jlboat.phone.activity.TestResultActivity p1)
    {
        return p1.localMapList;
    }

    static synthetic com.boat.support.slam.entity.floors.MapList access$102(com.jlboat.phone.activity.TestResultActivity p0, com.boat.support.slam.entity.floors.MapList p1)
    {
        p0.localMapList = p1;
        return p1;
    }

    static synthetic void access$200(com.jlboat.phone.activity.TestResultActivity p0, java.util.List p1, com.boat.support.slam.entity.floors.MapList p2)
    {
        p0.processDataAndUpdateUI(p1, p2);
        return;
    }

    static synthetic com.jlboat.phone.communication.SpiritServiceClient access$300(com.jlboat.phone.activity.TestResultActivity p1)
    {
        return p1.spiritServiceClient;
    }

    static synthetic boolean access$400(com.jlboat.phone.activity.TestResultActivity p1)
    {
        return p1.isEnd;
    }

    static synthetic boolean access$402(com.jlboat.phone.activity.TestResultActivity p0, boolean p1)
    {
        p0.isEnd = p1;
        return p1;
    }

    static synthetic com.jlboat.phone.adapter.TestResultAdapter access$500(com.jlboat.phone.activity.TestResultActivity p1)
    {
        return p1.adapter;
    }

    static synthetic android.widget.Button access$600(com.jlboat.phone.activity.TestResultActivity p1)
    {
        return p1.resCancleBtn;
    }

    static synthetic android.widget.TextView access$700(com.jlboat.phone.activity.TestResultActivity p1)
    {
        return p1.title_time;
    }

    static synthetic android.support.v7.widget.RecyclerView access$800(com.jlboat.phone.activity.TestResultActivity p1)
    {
        return p1.testResRv;
    }

    private void cancleTest()
    {
        this.spiritServiceClient.setNaviTestService(this.nameList, 7, new com.jlboat.phone.activity.TestResultActivity$2(this));
        return;
    }

    private void initView()
    {
        this.testResRv = ((android.support.v7.widget.RecyclerView) this.findViewById(2131231288));
        this.title_time = ((android.widget.TextView) this.findViewById(2131231319));
        this.resCancleBtn = ((android.widget.Button) this.findViewById(2131231149));
        this.resCancleBtn.setOnClickListener(this);
        this.adapter = new com.jlboat.phone.adapter.TestResultAdapter(this);
        this.testResRv.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));
        this.testResRv.setAdapter(this.adapter);
        return;
    }

    private void processDataAndUpdateUI(java.util.List p9, com.boat.support.slam.entity.floors.MapList p10)
    {
        int v0 = 1;
        int v1_0 = p9.iterator();
        while (v1_0.hasNext()) {
            android.support.v7.widget.RecyclerView v2_3 = ((com.jlboat.phone.message.map_msgs.NaviTestResultEntry) v1_0.next());
            if (((int) v2_3.getTestType()) != 2) {
                if ((((int) v2_3.getGoalResult()) != 2) && (((int) v2_3.getChargeResult()) != 2)) {
                    if ((((int) v2_3.getGoalResult()) == 3) || (((int) v2_3.getChargeResult()) == 3)) {
                        v0 = 0;
                        break;
                    }
                } else {
                    v0 = 1;
                    break;
                }
            } else {
                if (v2_3.getGoalResult() != 2) {
                    v0 = 0;
                } else {
                    v0 = 1;
                    break;
                }
            }
        }
        this.testResRv.post(new com.jlboat.phone.activity.TestResultActivity$$ExternalSyntheticLambda0(this, p10, p9, v0));
        return;
    }

    public void initTopic()
    {
        this.spiritTopicListener.getTestMsg(new com.jlboat.phone.activity.TestResultActivity$1(this));
        return;
    }

    synthetic void lambda$processDataAndUpdateUI$0$com-jlboat-phone-activity-TestResultActivity(com.boat.support.slam.entity.floors.MapList p3, java.util.List p4, boolean p5)
    {
        this.adapter.setData2(p3);
        this.adapter.setData(p4);
        android.util.Log.d("TestResultActivity", new StringBuilder().append("localMapList2:").append(p3).toString());
        if (!p5) {
            this.resCancleBtn.setVisibility(0);
        } else {
            this.resCancleBtn.setVisibility(8);
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
        this.initTitleBar(2131361832, 2131493220);
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        this.spiritTopicListener = new com.jlboat.phone.communication.SpiritTopicListener();
        this.initView();
        return;
    }

    protected void onPause()
    {
        super.onPause();
        return;
    }

    protected void onResume()
    {
        super.onResume();
        this.initTopic();
        return;
    }
}
