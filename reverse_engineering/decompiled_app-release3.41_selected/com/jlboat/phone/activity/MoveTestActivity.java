package com.jlboat.phone.activity;
public class MoveTestActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private static final int MOVE_TEST_CANCLE = 103;
    private static final int MOVE_TEST_END = 102;
    private static final int START_MOVE_SUCC = 100;
    private static final String TAG = "MoveTestActivity";
    private static final int UPDATE_RES_LIST = 101;
    private com.jlboat.phone.adapter.MoveResultAdapter adapter;
    private int bottonType;
    private float data;
    private java.util.List dataList;
    private int intentType;
    private boolean isMoveRun;
    private android.widget.Button leftTurn360Btn;
    private android.os.Handler mHandler;
    private int moveType;
    private int moveValue;
    private android.widget.Button oneMeterBackBtn;
    private android.widget.Button oneMeterBtn;
    private com.jlboat.phone.bean.MoveRes res;
    private android.widget.Button rightTurn360Btn;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.SpiritTopicListener spiritTopicListener;
    private android.widget.TextView testCategoryTv;
    private android.support.v7.widget.RecyclerView testResRv;

    public MoveTestActivity()
    {
        this.moveValue = -1;
        this.moveType = -1;
        this.dataList = new java.util.ArrayList();
        this.mHandler = new com.jlboat.phone.activity.MoveTestActivity$1(this);
        return;
    }

    static synthetic boolean access$002(com.jlboat.phone.activity.MoveTestActivity p0, boolean p1)
    {
        p0.isMoveRun = p1;
        return p1;
    }

    static synthetic java.util.List access$100(com.jlboat.phone.activity.MoveTestActivity p1)
    {
        return p1.dataList;
    }

    static synthetic void access$1000(com.jlboat.phone.activity.MoveTestActivity p0)
    {
        p0.setBtnState();
        return;
    }

    static synthetic float access$1100(com.jlboat.phone.activity.MoveTestActivity p1)
    {
        return p1.data;
    }

    static synthetic float access$1102(com.jlboat.phone.activity.MoveTestActivity p0, float p1)
    {
        p0.data = p1;
        return p1;
    }

    static synthetic com.jlboat.phone.bean.MoveRes access$1200(com.jlboat.phone.activity.MoveTestActivity p1)
    {
        return p1.res;
    }

    static synthetic com.jlboat.phone.bean.MoveRes access$1202(com.jlboat.phone.activity.MoveTestActivity p0, com.jlboat.phone.bean.MoveRes p1)
    {
        p0.res = p1;
        return p1;
    }

    static synthetic android.os.Handler access$1300(com.jlboat.phone.activity.MoveTestActivity p1)
    {
        return p1.mHandler;
    }

    static synthetic int access$200(com.jlboat.phone.activity.MoveTestActivity p1)
    {
        return p1.bottonType;
    }

    static synthetic android.widget.Button access$300(com.jlboat.phone.activity.MoveTestActivity p1)
    {
        return p1.oneMeterBtn;
    }

    static synthetic android.widget.Button access$400(com.jlboat.phone.activity.MoveTestActivity p1)
    {
        return p1.oneMeterBackBtn;
    }

    static synthetic android.widget.Button access$500(com.jlboat.phone.activity.MoveTestActivity p1)
    {
        return p1.leftTurn360Btn;
    }

    static synthetic android.widget.Button access$600(com.jlboat.phone.activity.MoveTestActivity p1)
    {
        return p1.rightTurn360Btn;
    }

    static synthetic int access$700(com.jlboat.phone.activity.MoveTestActivity p1)
    {
        return p1.moveType;
    }

    static synthetic com.jlboat.phone.adapter.MoveResultAdapter access$800(com.jlboat.phone.activity.MoveTestActivity p1)
    {
        return p1.adapter;
    }

    static synthetic android.support.v7.widget.RecyclerView access$900(com.jlboat.phone.activity.MoveTestActivity p1)
    {
        return p1.testResRv;
    }

    private void initRos()
    {
        this.initRosData();
        return;
    }

    private void initView()
    {
        this.intentType = this.getIntent().getIntExtra("type", -1);
        if (this.intentType == -1) {
            com.jlboat.phone.util.Utils.toast("\u6570\u636e\u83b7\u53d6\u5931\u8d25");
            this.finish();
        }
        int v2_3;
        this.oneMeterBtn = ((android.widget.Button) this.findViewById(2131231018));
        this.oneMeterBackBtn = ((android.widget.Button) this.findViewById(2131231017));
        this.leftTurn360Btn = ((android.widget.Button) this.findViewById(2131231016));
        this.rightTurn360Btn = ((android.widget.Button) this.findViewById(2131231024));
        this.oneMeterBtn.setOnClickListener(this);
        this.oneMeterBackBtn.setOnClickListener(this);
        this.leftTurn360Btn.setOnClickListener(this);
        this.rightTurn360Btn.setOnClickListener(this);
        this.testCategoryTv = ((android.widget.TextView) this.findViewById(2131231026));
        this.testResRv = ((android.support.v7.widget.RecyclerView) this.findViewById(2131231027));
        android.support.v7.widget.RecyclerView v0_24 = this.testCategoryTv;
        com.jlboat.phone.adapter.MoveResultAdapter v1_3 = new StringBuilder().append("type\uff1a");
        if (this.intentType != 0) {
            v2_3 = 2131493032;
        } else {
            v2_3 = 2131493091;
        }
        v0_24.setText(v1_3.append(this.getResString(v2_3)).toString());
        this.adapter = new com.jlboat.phone.adapter.MoveResultAdapter();
        this.testResRv.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));
        this.testResRv.addItemDecoration(new android.support.v7.widget.DividerItemDecoration(this, 1));
        this.testResRv.setAdapter(this.adapter);
        return;
    }

    private void setBtnState()
    {
        this.isMoveRun = 0;
        this.oneMeterBtn.setEnabled(1);
        this.oneMeterBackBtn.setEnabled(1);
        this.leftTurn360Btn.setEnabled(1);
        this.rightTurn360Btn.setEnabled(1);
        this.oneMeterBtn.setBackgroundResource(2131165271);
        this.oneMeterBackBtn.setBackgroundResource(2131165271);
        this.leftTurn360Btn.setBackgroundResource(2131165271);
        this.rightTurn360Btn.setBackgroundResource(2131165271);
        return;
    }

    private void setData(int p5)
    {
        switch (p5) {
            case 1:
                if (this.intentType != 0) {
                    this.moveValue = 0;
                    this.moveType = 4;
                } else {
                    this.moveValue = 1;
                    this.moveType = 2;
                }
                break;
            case 2:
                if (this.intentType != 0) {
                    this.moveValue = 0;
                    this.moveType = 5;
                } else {
                    this.moveValue = -1;
                    this.moveType = 2;
                }
                break;
            case 3:
                if (this.intentType != 0) {
                    this.moveValue = 0;
                    this.moveType = 6;
                } else {
                    this.moveValue = 360;
                    this.moveType = 1;
                }
                break;
            case 4:
                if (this.intentType != 0) {
                    this.moveValue = 0;
                    this.moveType = 7;
                } else {
                    this.moveValue = -360;
                    this.moveType = 1;
                }
                break;
            default:
        }
        this.startMove(this.moveValue, this.moveType);
        return;
    }

    private void startMove(int p3, int p4)
    {
        this.spiritServiceClient.setScaleTestService(p3, p4, new com.jlboat.phone.activity.MoveTestActivity$3(this));
        return;
    }

    protected void initRosData()
    {
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        this.spiritTopicListener = new com.jlboat.phone.communication.SpiritTopicListener();
        return;
    }

    public void initService()
    {
        this.initTopic();
        return;
    }

    public void initTopic()
    {
        this.spiritTopicListener.getMoveTestMsg(new com.jlboat.phone.activity.MoveTestActivity$2(this));
        return;
    }

    public void onBackPressed()
    {
        if (!this.isMoveRun) {
            this.finish();
            return;
        } else {
            com.jlboat.phone.util.Utils.toast("\u6d4b\u8bd5\u8fd0\u884c\u4e2d\uff0c\u8bf7\u53d6\u6d88\u6d4b\u8bd5");
            return;
        }
    }

    public void onClick(android.view.View p4)
    {
        switch (p4.getId()) {
            case 2131231016:
                this.bottonType = 3;
                this.setData(3);
                break;
            case 2131231017:
                this.bottonType = 2;
                this.setData(2);
                break;
            case 2131231018:
                this.bottonType = 1;
                this.setData(1);
                break;
            case 2131231024:
                this.bottonType = 4;
                this.setData(4);
                break;
            default:
                throw new IllegalStateException(new StringBuilder().append("Unexpected value: ").append(p4.getId()).toString());
        }
        return;
    }

    protected void onCreate(android.os.Bundle p3)
    {
        super.onCreate(p3);
        this.initTitleBar(2131361826, 2131493345);
        this.initRos();
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
        this.initService();
        return;
    }
}
