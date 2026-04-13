package com.jlboat.phone.fragment.calibrationfragment;
public class OmodFragment extends com.jlboat.phone.base.BaseFragment implements android.view.View$OnClickListener {
    private static final String TAG = "OmodFragment";
    private com.jlboat.phone.adapter.OdomAdapter adapter;
    private java.util.List configList;
    private android.os.Handler handler;
    private android.content.Context mContext;
    private android.support.v7.widget.RecyclerView odomTable;
    private android.widget.Button robot_advance;
    private android.widget.Button robot_back;
    private android.widget.Button robot_reset;
    private android.widget.Button robot_turn_left;
    private android.widget.Button robot_turn_right;
    private com.jlboat.phone.communication.StatusServiceClient statusServiceClient;

    public OmodFragment()
    {
        this.configList = new java.util.LinkedList();
        this.handler = new com.jlboat.phone.fragment.calibrationfragment.OmodFragment$3(this);
        return;
    }

    static synthetic java.util.List access$000(com.jlboat.phone.fragment.calibrationfragment.OmodFragment p1)
    {
        return p1.configList;
    }

    static synthetic android.os.Handler access$100(com.jlboat.phone.fragment.calibrationfragment.OmodFragment p1)
    {
        return p1.handler;
    }

    static synthetic com.jlboat.phone.adapter.OdomAdapter access$200(com.jlboat.phone.fragment.calibrationfragment.OmodFragment p1)
    {
        return p1.adapter;
    }

    static synthetic void access$300(com.jlboat.phone.fragment.calibrationfragment.OmodFragment p0, CharSequence p1)
    {
        p0.showToast(p1);
        return;
    }

    static synthetic void access$400(com.jlboat.phone.fragment.calibrationfragment.OmodFragment p0, CharSequence p1)
    {
        p0.showToast(p1);
        return;
    }

    private void getCalcuOdom()
    {
        return;
    }

    private void setTest(int p3)
    {
        android.util.Log.d("OmodFragment", new StringBuilder().append("setTest: ").append(p3).toString());
        this.statusServiceClient.setTestDriverService(p3, new com.jlboat.phone.fragment.calibrationfragment.OmodFragment$4(this));
        return;
    }

    public void getConfigs(int p3)
    {
        this.statusServiceClient.getConfigsService(p3, new com.jlboat.phone.fragment.calibrationfragment.OmodFragment$2(this));
        return;
    }

    protected void initData()
    {
        return;
    }

    protected void initListener()
    {
        return;
    }

    protected android.view.View initView(android.view.LayoutInflater p5, android.view.ViewGroup p6)
    {
        android.view.View v0_1 = p5.inflate(2131361923, p6, 0);
        this.statusServiceClient = new com.jlboat.phone.communication.StatusServiceClient();
        this.odomTable = ((android.support.v7.widget.RecyclerView) v0_1.findViewById(2131231049));
        this.robot_advance = ((android.widget.Button) v0_1.findViewById(2131231191));
        this.robot_back = ((android.widget.Button) v0_1.findViewById(2131231194));
        this.robot_turn_left = ((android.widget.Button) v0_1.findViewById(2131231208));
        this.robot_turn_right = ((android.widget.Button) v0_1.findViewById(2131231209));
        this.robot_reset = ((android.widget.Button) v0_1.findViewById(2131231206));
        this.robot_advance.setOnClickListener(this);
        this.robot_back.setOnClickListener(this);
        this.robot_turn_left.setOnClickListener(this);
        this.robot_turn_right.setOnClickListener(this);
        this.robot_reset.setOnClickListener(this);
        this.adapter = new com.jlboat.phone.adapter.OdomAdapter(this.mContext, new com.jlboat.phone.fragment.calibrationfragment.OmodFragment$1(this));
        this.odomTable.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this.mContext));
        this.odomTable.setAdapter(this.adapter);
        this.getConfigs(6);
        return v0_1;
    }

    public void onClick(android.view.View p2)
    {
        switch (p2.getId()) {
            case 2131231191:
                this.setTest(101);
                break;
            case 2131231194:
                this.setTest(102);
                break;
            case 2131231206:
                this.setTest(105);
                break;
            case 2131231208:
                this.setTest(103);
                break;
            case 2131231209:
                this.setTest(104);
                break;
            default:
        }
        return;
    }

    public android.view.View onCreateView(android.view.LayoutInflater p2, android.view.ViewGroup p3, android.os.Bundle p4)
    {
        this.mContext = this.getActivity();
        return super.onCreateView(p2, p3, p4);
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        return;
    }

    public void onStart()
    {
        super.onStart();
        return;
    }
}
