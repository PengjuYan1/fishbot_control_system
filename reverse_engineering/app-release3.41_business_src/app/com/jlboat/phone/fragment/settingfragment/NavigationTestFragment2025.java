package com.jlboat.phone.fragment.settingfragment;
public class NavigationTestFragment2025 extends com.jlboat.phone.base.BaseFragment implements android.view.View$OnClickListener, android.widget.CompoundButton$OnCheckedChangeListener {
    private static final int CHARGE_TEST_ALL = 5;
    private static final int CHARGE_TEST_RANDOM = 4;
    private static final int LIFT_TEST_ALL = 9;
    private static final int LIFT_TEST_RANDOM = 8;
    private static final int NAVI_TEST_ALL = 2;
    private static final int NAVI_TEST_ONEC = 1;
    private static final int UPDATE_FRAGMENT_UI = 101;
    private static int mType;
    private String TAG;
    private android.widget.Button chargeTestBtn;
    private java.util.List configList;
    private String currentMapName;
    private java.util.Map floorDefaultMaps;
    private long floorId;
    private java.util.Map floorIdMap;
    private java.util.List floorNameList;
    private android.widget.Spinner floorSpinner;
    private ref.WeakReference fragmentRef;
    private com.boat.jrosbridge.Topic getTestMsg;
    private android.widget.Button liftTestBtn;
    private com.boat.support.slam.entity.floors.MapList localMapList;
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
    private java.util.List selectedTestPoint;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.SpiritTopicListener spiritTopicListener;
    com.jlboat.phone.communication.StatusServiceClient statusServiceClient;
    private android.widget.EditText testNaviWaitTimeBt;
    private com.jlboat.phone.adapter.TestPointListAdapter testPointListAdapter;
    private com.jlboat.phone.adapter.TestPointSelectedListAdapter testPointSelectedListAdapter;
    private int testType;
    private android.widget.CheckBox testTypeLooperCb;

    public NavigationTestFragment2025()
    {
        this.TAG = "NavigationTestFragment2025";
        this.mapList = new java.util.ArrayList();
        this.mapId = -1;
        this.mapPointList = new java.util.ArrayList();
        this.selectedPointList = new java.util.ArrayList();
        this.selectedTestPoint = new java.util.ArrayList();
        this.configList = new java.util.LinkedList();
        this.floorDefaultMaps = new java.util.HashMap();
        this.floorNameList = new java.util.ArrayList();
        this.floorIdMap = new java.util.HashMap();
        this.mHandler = new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025$1(this);
        this.testType = 0;
        return;
    }

    static synthetic String access$000(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        return p1.currentMapName;
    }

    static synthetic String access$002(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p0, String p1)
    {
        p0.currentMapName = p1;
        return p1;
    }

    static synthetic android.widget.TextView access$100(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        return p1.navCurrentmapNameTv;
    }

    static synthetic void access$1000(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p0, com.boat.support.slam.entity.floors.MapList p1)
    {
        p0.setupFloorMapData(p1);
        return;
    }

    static synthetic void access$1100(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p0)
    {
        p0.initSpinner();
        return;
    }

    static synthetic java.util.List access$1200(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        return p1.floorNameList;
    }

    static synthetic java.util.Map access$1300(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        return p1.floorDefaultMaps;
    }

    static synthetic long access$1400(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p2)
    {
        return p2.mapId;
    }

    static synthetic long access$1402(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p0, long p1)
    {
        p0.mapId = p1;
        return p1;
    }

    static synthetic long access$1500(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p2)
    {
        return p2.floorId;
    }

    static synthetic long access$1502(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p0, long p1)
    {
        p0.floorId = p1;
        return p1;
    }

    static synthetic java.util.List access$1602(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p0, java.util.List p1)
    {
        p0.mapList = p1;
        return p1;
    }

    static synthetic java.util.Map access$1700(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        return p1.floorIdMap;
    }

    static synthetic android.os.Handler access$1800(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        return p1.mHandler;
    }

    static synthetic com.boat.jrosbridge.Topic access$1900(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        return p1.getTestMsg;
    }

    static synthetic java.util.List access$200(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        return p1.mapPointList;
    }

    static synthetic ref.WeakReference access$2000(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        return p1.fragmentRef;
    }

    static synthetic java.util.List access$202(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p0, java.util.List p1)
    {
        p0.mapPointList = p1;
        return p1;
    }

    static synthetic String access$2100(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        return p1.TAG;
    }

    static synthetic android.widget.EditText access$2200(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        return p1.testNaviWaitTimeBt;
    }

    static synthetic android.os.Handler access$2300(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        return p1.handler;
    }

    static synthetic java.util.List access$300(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        return p1.selectedPointList;
    }

    static synthetic java.util.List access$302(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p0, java.util.List p1)
    {
        p0.selectedPointList = p1;
        return p1;
    }

    static synthetic com.jlboat.phone.adapter.TestPointListAdapter access$400(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        return p1.testPointListAdapter;
    }

    static synthetic com.jlboat.phone.adapter.TestPointSelectedListAdapter access$500(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        return p1.testPointSelectedListAdapter;
    }

    static synthetic java.util.List access$600(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        return p1.selectedTestPoint;
    }

    static synthetic android.support.v7.widget.RecyclerView access$700(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        return p1.navSelectedPointRv;
    }

    static synthetic android.widget.LinearLayout access$800(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        return p1.navNopointTipLl;
    }

    static synthetic java.util.List access$900(com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 p1)
    {
        return p1.configList;
    }

    private void initSpinner()
    {
        android.widget.ArrayAdapter v0_1 = new android.widget.ArrayAdapter(this.requireContext(), 17367048, this.floorNameList);
        v0_1.setDropDownViewResource(17367049);
        this.floorSpinner.setAdapter(v0_1);
        if (this.localMapList != null) {
            com.boat.support.slam.entity.floors.Floors v3_2 = ((com.boat.support.slam.entity.floors.Floors) this.floorIdMap.get(Long.valueOf(this.localMapList.getDefaultFloor())));
            if (v3_2 != null) {
                int v4_2 = this.floorNameList.indexOf(v3_2.getFloorName());
                if (v4_2 != -1) {
                    this.floorSpinner.setSelection(v4_2);
                }
            }
        }
        this.floorSpinner.setOnItemSelectedListener(new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025$5(this));
        return;
    }

    public static com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025 newInstance(int p1)
    {
        com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.mType = p1;
        return new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025();
    }

    private void setupFloorMapData(com.boat.support.slam.entity.floors.MapList p10)
    {
        this.floorDefaultMaps.clear();
        this.floorNameList.clear();
        this.floorIdMap.clear();
        android.util.Log.d(this.TAG, new StringBuilder().append("MapList:").append(p10).toString());
        this.localMapList = p10;
        if (p10.getFloors() != null) {
            java.util.Iterator v0_4 = p10.getFloors().iterator();
            while (v0_4.hasNext()) {
                com.boat.support.slam.entity.floors.Floors v1_5 = ((com.boat.support.slam.entity.floors.Floors) v0_4.next());
                this.floorIdMap.put(Long.valueOf(v1_5.getFloorId()), v1_5);
                long v2_1 = v1_5.getDefaultmap();
                com.boat.support.slam.entity.floors.MapInfo v4_1 = v1_5.getMaps().iterator();
                while (v4_1.hasNext()) {
                    String v5_2 = ((com.boat.support.slam.entity.floors.Maps) v4_1.next());
                    if (v5_2.getMapId() == v2_1) {
                        com.boat.support.slam.entity.floors.MapInfo v4_3 = new com.boat.support.slam.entity.floors.MapInfo();
                        v4_3.setFloorId(v1_5.getFloorId());
                        v4_3.setFloorName(v1_5.getFloorName());
                        v4_3.setMapId(v5_2.getMapId());
                        v4_3.setMapName(v5_2.getMapName());
                        v4_3.setPoints(v5_2.getPoints());
                        this.floorDefaultMaps.put(v1_5.getFloorName(), v4_3);
                        break;
                    }
                }
                this.floorNameList.add(v1_5.getFloorName());
            }
            return;
        } else {
            return;
        }
    }

    private void startNav()
    {
        if (!this.selectedTestPoint.isEmpty()) {
            if (((this.testType != 1) && (this.testType != 5)) || (this.selectedTestPoint.size() != 1)) {
                String v0_4 = new java.util.ArrayList();
                android.util.Log.d(this.TAG, new StringBuilder().append("selectedTestPoint:").append(this.selectedTestPoint).toString());
                java.util.List v1_2 = this.selectedTestPoint.iterator();
                while (v1_2.hasNext()) {
                    String v2_17 = ((com.boat.support.slam.entity.floors.SelectedTestPoint) v1_2.next());
                    String v3_4 = new com.boat.support.slam.entity.floors.NaviTest();
                    v3_4.setPointId(Long.valueOf(v2_17.getPoint().getPointId()));
                    v3_4.setMapId(v2_17.getMapId());
                    v3_4.setFloorId(v2_17.getFloorId());
                    v3_4.setGoal_name(v2_17.getPoint().getPointName());
                    v0_4.add(v3_4);
                }
                String v2_13;
                android.util.Log.d(this.TAG, new StringBuilder().append("naviList:").append(v0_4).toString());
                if (com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.mType != 0) {
                    if (this.testType != 0) {
                        v2_13 = 5;
                    } else {
                        v2_13 = 4;
                    }
                } else {
                    if (this.testType != 0) {
                        v2_13 = 2;
                    } else {
                        v2_13 = 1;
                    }
                }
                this.spiritServiceClient.setNaviTestService(v0_4, v2_13, new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025$3(this));
                this.initTopic();
                android.util.Log.e(this.TAG, "Callback error2");
                this.selectedTestPoint.clear();
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
        this.statusServiceClient.getConfigsService(p3, new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025$7(this));
        return;
    }

    public void getMaps()
    {
        this.spiritServiceClient.getMapsService(new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025$4(this));
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
        this.getTestMsg.subscribe(new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025$6(this));
        return;
    }

    protected android.view.View initView(android.view.LayoutInflater p8, android.view.ViewGroup p9)
    {
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        this.spiritTopicListener = new com.jlboat.phone.communication.SpiritTopicListener();
        android.view.View v0_5 = p8.inflate(2131361865, p9, 0);
        this.floorSpinner = ((android.widget.Spinner) v0_5.findViewById(2131231259));
        this.testNaviWaitTimeBt = ((android.widget.EditText) v0_5.findViewById(2131231287));
        this.testNaviWaitTimeBt.setImeOptions(6);
        this.testNaviWaitTimeBt.addTextChangedListener(new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025$2(this));
        this.testTypeLooperCb = ((android.widget.CheckBox) v0_5.findViewById(2131231289));
        this.testTypeLooperCb.setOnCheckedChangeListener(this);
        this.navTestBtn = ((android.widget.Button) v0_5.findViewById(2131231038));
        this.chargeTestBtn = ((android.widget.Button) v0_5.findViewById(2131230849));
        if (com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.mType != 1) {
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
        this.navNopointTipLl = ((android.widget.LinearLayout) v0_5.findViewById(2131231034));
        this.navTestBtn.setOnClickListener(this);
        this.chargeTestBtn.setOnClickListener(this);
        this.navAllPointRv.setLayoutManager(new android.support.v7.widget.GridLayoutManager(this.getActivity(), 6));
        this.navSelectedPointRv.setLayoutManager(new android.support.v7.widget.GridLayoutManager(this.getActivity(), 6));
        this.testPointListAdapter = new com.jlboat.phone.adapter.TestPointListAdapter();
        this.testPointSelectedListAdapter = new com.jlboat.phone.adapter.TestPointSelectedListAdapter();
        this.navSelectedPointRv.setAdapter(this.testPointSelectedListAdapter);
        this.testPointSelectedListAdapter.setOnItemClickListener(new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025$MyNavSelectRvItemClick(this));
        this.testPointListAdapter.setOnItemClickListener(new com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025$MyNavRvItemClick(this));
        this.navAllPointRv.setAdapter(this.testPointListAdapter);
        return v0_5;
    }

    public void onActivityCreated(android.os.Bundle p2)
    {
        super.onActivityCreated(p2);
        this.fragmentRef = new ref.WeakReference(this);
        return;
    }

    public void onCheckedChanged(android.widget.CompoundButton p4, boolean p5)
    {
        switch (p4.getId()) {
            case 2131231289:
                if (!p5) {
                    this.testTypeLooperCb.setChecked(p5);
                    this.testType = 0;
                    if (com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.mType != 1) {
                    } else {
                        this.mHandler.sendEmptyMessage(101);
                    }
                } else {
                    this.testTypeLooperCb.setChecked(p5);
                    this.testType = 1;
                    if (com.jlboat.phone.fragment.settingfragment.NavigationTestFragment2025.mType != 1) {
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

    public void onDestroy()
    {
        super.onDestroy();
        if (this.getTestMsg != null) {
            this.getTestMsg.unsubscribe();
            this.getTestMsg = 0;
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
