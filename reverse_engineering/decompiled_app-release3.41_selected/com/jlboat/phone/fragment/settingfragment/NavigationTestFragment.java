package com.jlboat.phone.fragment.settingfragment;
public class NavigationTestFragment extends com.jlboat.phone.base.BaseFragment implements android.view.View$OnClickListener, android.widget.CompoundButton$OnCheckedChangeListener {
    private static final int CHARGE_TEST_ALL = 5;
    private static final int CHARGE_TEST_RANDOM = 4;
    private static final int NAVI_TEST_ALL = 2;
    private static final int NAVI_TEST_ONEC = 1;
    private static final int UPDATE_FRAGMENT_UI = 101;
    private static int mType;
    private String TAG;
    private android.widget.Button chargeTestBtn;
    private java.util.List configList;
    private android.widget.TextView cuFloors;
    private String currentMapName;
    private android.widget.Spinner floorSpinner;
    private com.boat.jrosbridge.Topic getTestMsg;
    private android.os.Handler mHandler;
    private long mapId;
    private java.util.List mapList;
    private java.util.List mapPointList;
    private android.support.v7.widget.RecyclerView navAllPointRv;
    private android.widget.TextView navCurrentmapNameTv;
    private android.widget.LinearLayout navNopointTipLl;
    private android.widget.LinearLayout navSelectMapNameLl;
    private android.support.v7.widget.RecyclerView navSelectedPointRv;
    private android.widget.Button navTestBtn;
    private java.util.List selectedPointList;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.SpiritTopicListener spiritTopicListener;
    com.jlboat.phone.communication.StatusServiceClient statusServiceClient;
    private android.widget.EditText testNaviWaitTimeBt;
    private com.jlboat.phone.adapter.TestPointListAdapter testPointListAdapter;
    private com.jlboat.phone.adapter.TestPointSelectedListAdapter testPointSelectedListAdapter;
    private int testType;
    private android.widget.CheckBox testTypeLooperCb;

    public NavigationTestFragment()
    {
        this.TAG = "NavigationTestFragment";
        this.mapList = new java.util.ArrayList();
        this.mapId = -1;
        this.mapPointList = new java.util.ArrayList();
        this.selectedPointList = new java.util.ArrayList();
        this.configList = new java.util.LinkedList();
        this.mHandler = new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment$1(this);
        this.testType = 0;
        return;
    }

    static synthetic String access$000(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p1)
    {
        return p1.currentMapName;
    }

    static synthetic String access$002(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p0, String p1)
    {
        p0.currentMapName = p1;
        return p1;
    }

    static synthetic android.widget.TextView access$100(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p1)
    {
        return p1.navCurrentmapNameTv;
    }

    static synthetic long access$1002(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p0, long p1)
    {
        p0.mapId = p1;
        return p1;
    }

    static synthetic android.os.Handler access$1100(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p1)
    {
        return p1.mHandler;
    }

    static synthetic com.boat.jrosbridge.Topic access$1200(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p1)
    {
        return p1.getTestMsg;
    }

    static synthetic android.widget.EditText access$1300(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p1)
    {
        return p1.testNaviWaitTimeBt;
    }

    static synthetic android.os.Handler access$1400(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p1)
    {
        return p1.handler;
    }

    static synthetic java.util.List access$200(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p1)
    {
        return p1.mapPointList;
    }

    static synthetic java.util.List access$202(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p0, java.util.List p1)
    {
        p0.mapPointList = p1;
        return p1;
    }

    static synthetic java.util.List access$300(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p1)
    {
        return p1.selectedPointList;
    }

    static synthetic com.jlboat.phone.adapter.TestPointListAdapter access$400(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p1)
    {
        return p1.testPointListAdapter;
    }

    static synthetic com.jlboat.phone.adapter.TestPointSelectedListAdapter access$500(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p1)
    {
        return p1.testPointSelectedListAdapter;
    }

    static synthetic android.support.v7.widget.RecyclerView access$600(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p1)
    {
        return p1.navSelectedPointRv;
    }

    static synthetic android.widget.LinearLayout access$700(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p1)
    {
        return p1.navNopointTipLl;
    }

    static synthetic java.util.List access$800(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p1)
    {
        return p1.configList;
    }

    static synthetic java.util.List access$902(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment p0, java.util.List p1)
    {
        p0.mapList = p1;
        return p1;
    }

    public static com.jlboat.phone.fragment.settingfragment.NavigationTestFragment newInstance(int p1)
    {
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.mType = p1;
        return new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment();
    }

    private void startNav()
    {
        if (!this.selectedPointList.isEmpty()) {
            if (((this.testType != 1) && (this.testType != 5)) || (this.selectedPointList.size() != 1)) {
                String v0_4 = new java.util.ArrayList();
                java.util.List v1_1 = this.selectedPointList.iterator();
                while (v1_1.hasNext()) {
                    v0_4.add(((com.boat.support.slam.entity.floors.Points) v1_1.next()).getPointName());
                }
                long v2_3;
                if (com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.mType != 0) {
                    if (this.testType != 0) {
                        v2_3 = 5;
                    } else {
                        v2_3 = 4;
                    }
                } else {
                    if (this.testType != 0) {
                        v2_3 = 2;
                    } else {
                        v2_3 = 1;
                    }
                }
                this.spiritServiceClient.setNaviTestService(v0_4, v2_3, new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment$3(this));
                this.initTopic();
                this.selectedPointList.clear();
                return;
            } else {
                com.jlboat.phone.util.Utils.toast("\u4e00\u4e2a\u70b9\u4e0d\u80fd\u5f00\u542f\u5faa\u73af");
                return;
            }
        } else {
            com.jlboat.phone.util.Utils.toast("\u8bf7\u9009\u62e9\u5bfc\u822a\u70b9");
            return;
        }
    }

    public void getConfigs(int p3)
    {
        this.statusServiceClient.getConfigsService(p3, new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment$6(this));
        return;
    }

    public void getMaps()
    {
        this.spiritServiceClient.getMapsService(new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment$4(this));
        return;
    }

    protected void initData()
    {
        this.initTopic();
        this.statusServiceClient = new com.jlboat.phone.communication.StatusServiceClient();
        return;
    }

    protected void initListener()
    {
        return;
    }

    public void initTopic()
    {
        this.getTestMsg = new com.boat.jrosbridge.Topic(com.jlboat.phone.util.TopicNames.TestMsg, com.jlboat.phone.message.map_msgs.NaviTestResultEntrys, com.jlboat.phone.application.BoatSlamApplication.client);
        this.getTestMsg.subscribe(new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment$5(this));
        return;
    }

    protected android.view.View initView(android.view.LayoutInflater p8, android.view.ViewGroup p9)
    {
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        this.spiritTopicListener = new com.jlboat.phone.communication.SpiritTopicListener();
        android.view.View v0_5 = p8.inflate(2131361865, p9, 0);
        this.testNaviWaitTimeBt = ((android.widget.EditText) v0_5.findViewById(2131231287));
        this.floorSpinner = ((android.widget.Spinner) v0_5.findViewById(2131231259));
        this.floorSpinner.setVisibility(8);
        this.testNaviWaitTimeBt.setImeOptions(6);
        this.testNaviWaitTimeBt.addTextChangedListener(new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment$2(this));
        this.testTypeLooperCb = ((android.widget.CheckBox) v0_5.findViewById(2131231289));
        this.testTypeLooperCb.setOnCheckedChangeListener(this);
        this.navTestBtn = ((android.widget.Button) v0_5.findViewById(2131231038));
        this.chargeTestBtn = ((android.widget.Button) v0_5.findViewById(2131230849));
        if (com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.mType != 1) {
            this.testTypeLooperCb.setText(2131493223);
            this.navTestBtn.setVisibility(0);
            this.chargeTestBtn.setVisibility(8);
        } else {
            this.testTypeLooperCb.setText(2131493223);
            this.chargeTestBtn.setVisibility(0);
            this.navTestBtn.setVisibility(8);
        }
        this.navSelectMapNameLl = ((android.widget.LinearLayout) v0_5.findViewById(2131231037));
        this.navCurrentmapNameTv = ((android.widget.TextView) v0_5.findViewById(2131231032));
        this.navAllPointRv = ((android.support.v7.widget.RecyclerView) v0_5.findViewById(2131231031));
        this.navSelectedPointRv = ((android.support.v7.widget.RecyclerView) v0_5.findViewById(2131231036));
        this.cuFloors = ((android.widget.TextView) v0_5.findViewById(2131230862));
        this.cuFloors.setVisibility(8);
        this.navNopointTipLl = ((android.widget.LinearLayout) v0_5.findViewById(2131231034));
        this.navTestBtn.setOnClickListener(this);
        this.chargeTestBtn.setOnClickListener(this);
        this.navAllPointRv.setLayoutManager(new android.support.v7.widget.GridLayoutManager(this.getActivity(), 6));
        this.navSelectedPointRv.setLayoutManager(new android.support.v7.widget.GridLayoutManager(this.getActivity(), 6));
        this.testPointListAdapter = new com.jlboat.phone.adapter.TestPointListAdapter();
        this.testPointSelectedListAdapter = new com.jlboat.phone.adapter.TestPointSelectedListAdapter();
        this.navSelectedPointRv.setAdapter(this.testPointSelectedListAdapter);
        this.testPointSelectedListAdapter.setOnItemClickListener(new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment$MyNavSelectRvItemClick(this));
        this.testPointListAdapter.setOnItemClickListener(new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment$MyNavRvItemClick(this));
        this.navAllPointRv.setAdapter(this.testPointListAdapter);
        return v0_5;
    }

    public void onActivityCreated(android.os.Bundle p1)
    {
        super.onActivityCreated(p1);
        return;
    }

    public void onCheckedChanged(android.widget.CompoundButton p4, boolean p5)
    {
        switch (p4.getId()) {
            case 2131231289:
                if (!p5) {
                    this.testTypeLooperCb.setChecked(p5);
                    this.testType = 0;
                    if (com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.mType != 1) {
                    } else {
                        this.mHandler.sendEmptyMessage(101);
                    }
                } else {
                    this.testTypeLooperCb.setChecked(p5);
                    this.testType = 1;
                    if (com.jlboat.phone.fragment.settingfragment.NavigationTestFragment.mType != 1) {
                    } else {
                        this.mHandler.sendEmptyMessage(101);
                    }
                }
                break;
            default:
        }
        return;
    }

    public void onClick(android.view.View p2)
    {
        switch (p2.getId()) {
            case 2131230849:
            case 2131231038:
                this.startNav();
                break;
            case 2131231037:
                break;
            default:
        }
        return;
    }

    public void onResume()
    {
        super.onResume();
        this.getMaps();
        this.testTypeLooperCb.setChecked(0);
        this.getConfigs(9);
        return;
    }
}
