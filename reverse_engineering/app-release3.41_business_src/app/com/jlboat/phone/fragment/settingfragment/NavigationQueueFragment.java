package com.jlboat.phone.fragment.settingfragment;
public class NavigationQueueFragment extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener, android.widget.CompoundButton$OnCheckedChangeListener {
    private static final int UPDATE_FRAGMENT_UI = 101;
    private String TAG;
    private android.widget.Button addQueueBtu;
    private com.jlboat.phone.message.map_msgs.CargoAtoBEntry cargoAtoBEntry;
    private String currentMapName;
    private int delFlag;
    private com.boat.jrosbridge.Topic delQueueEntry;
    private java.util.Map floorDefaultMaps;
    private long floorId;
    private java.util.Map floorIdMap;
    private String floorName;
    private java.util.List floorNameList;
    private android.widget.Spinner floorSpinner;
    private com.boat.jrosbridge.Topic getNaviQueueListEntries;
    private com.boat.jrosbridge.Topic getTestMsg;
    com.boat.jrosbridge.message.std_msgs.Int32 int32;
    private com.jlboat.phone.adapter.LiftQueueAdapter liftQueueAdapter;
    private com.boat.support.slam.entity.floors.MapList localMapList;
    private android.os.Handler mHandler;
    private long mapId;
    private java.util.List mapList;
    private java.util.List mapPointList;
    private android.support.v7.widget.RecyclerView navAllPointRv;
    private android.widget.TextView navCurrentmapNameTv;
    private java.util.List naviQueueListEntrieList;
    private com.boat.jrosbridge.Topic naviQueueListEntries;
    private com.jlboat.phone.message.map_msgs.NaviQueueList naviQueueListEntrys;
    private android.support.v7.widget.RecyclerView naviQueueRv;
    private java.util.List selectedPointList;
    private java.util.List selectedTestPoint;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.SpiritTopicListener spiritTopicListener;
    com.jlboat.phone.communication.StatusServiceClient statusServiceClient;
    java.util.List targetGoalEntries;
    private com.boat.jrosbridge.Topic targetGoalEntryLists;
    private com.jlboat.phone.adapter.TestPointListAdapter testPointListAdapter;

    public NavigationQueueFragment()
    {
        this.TAG = "NavigationQueueFragment";
        this.mapList = new java.util.ArrayList();
        this.mapId = -1;
        this.targetGoalEntries = new java.util.ArrayList();
        this.naviQueueListEntrys = new com.jlboat.phone.message.map_msgs.NaviQueueList();
        this.cargoAtoBEntry = new com.jlboat.phone.message.map_msgs.CargoAtoBEntry();
        this.floorId = 0;
        this.floorName = 0;
        this.selectedTestPoint = new java.util.ArrayList();
        this.mapPointList = new java.util.ArrayList();
        this.selectedPointList = new java.util.ArrayList();
        this.currentMapName = 0;
        this.floorDefaultMaps = new java.util.HashMap();
        this.floorNameList = new java.util.ArrayList();
        this.floorIdMap = new java.util.HashMap();
        this.delFlag = 0;
        this.int32 = new com.boat.jrosbridge.message.std_msgs.Int32();
        this.mHandler = new com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment$1(this);
        return;
    }

    static synthetic String access$000(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p1)
    {
        return p1.currentMapName;
    }

    static synthetic String access$002(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p0, String p1)
    {
        p0.currentMapName = p1;
        return p1;
    }

    static synthetic android.widget.TextView access$100(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p1)
    {
        return p1.navCurrentmapNameTv;
    }

    static synthetic void access$1000(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p0, com.boat.support.slam.entity.floors.MapList p1)
    {
        p0.setupFloorMapData(p1);
        return;
    }

    static synthetic void access$1100(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p0)
    {
        p0.initSpinner();
        return;
    }

    static synthetic java.util.List access$1200(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p1)
    {
        return p1.floorNameList;
    }

    static synthetic java.util.Map access$1300(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p1)
    {
        return p1.floorDefaultMaps;
    }

    static synthetic String access$1402(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p0, String p1)
    {
        p0.floorName = p1;
        return p1;
    }

    static synthetic long access$1500(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p2)
    {
        return p2.mapId;
    }

    static synthetic long access$1502(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p0, long p1)
    {
        p0.mapId = p1;
        return p1;
    }

    static synthetic long access$1600(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p2)
    {
        return p2.floorId;
    }

    static synthetic long access$1602(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p0, long p1)
    {
        p0.floorId = p1;
        return p1;
    }

    static synthetic java.util.List access$1702(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p0, java.util.List p1)
    {
        p0.mapList = p1;
        return p1;
    }

    static synthetic java.util.Map access$1800(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p1)
    {
        return p1.floorIdMap;
    }

    static synthetic android.os.Handler access$1900(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p1)
    {
        return p1.mHandler;
    }

    static synthetic java.util.List access$200(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p1)
    {
        return p1.mapPointList;
    }

    static synthetic int access$2002(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p0, int p1)
    {
        p0.delFlag = p1;
        return p1;
    }

    static synthetic java.util.List access$202(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p0, java.util.List p1)
    {
        p0.mapPointList = p1;
        return p1;
    }

    static synthetic java.util.List access$2100(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p1)
    {
        return p1.selectedTestPoint;
    }

    static synthetic java.util.List access$300(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p1)
    {
        return p1.selectedPointList;
    }

    static synthetic java.util.List access$302(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p0, java.util.List p1)
    {
        p0.selectedPointList = p1;
        return p1;
    }

    static synthetic com.jlboat.phone.adapter.TestPointListAdapter access$400(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p1)
    {
        return p1.testPointListAdapter;
    }

    static synthetic String access$500(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p1)
    {
        return p1.TAG;
    }

    static synthetic void access$600(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p0)
    {
        p0.addNaviQueueListEntries();
        return;
    }

    static synthetic com.jlboat.phone.message.map_msgs.NaviQueueList access$700(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p1)
    {
        return p1.naviQueueListEntrys;
    }

    static synthetic com.boat.jrosbridge.Topic access$800(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p1)
    {
        return p1.delQueueEntry;
    }

    static synthetic void access$900(com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment p0)
    {
        p0.updateNaviQueueRv();
        return;
    }

    private void addNaviQueueListEntries()
    {
        com.jlboat.phone.message.map_msgs.TargetGoalEntryList v0_1 = new com.jlboat.phone.message.map_msgs.TargetGoalEntryList();
        android.os.Handler v1_5 = this.selectedTestPoint.iterator();
        while (v1_5.hasNext()) {
            int v2_2 = ((com.boat.support.slam.entity.floors.SelectedTestPoint) v1_5.next());
            com.jlboat.phone.message.map_msgs.TargetGoalEntry v3_1 = new com.jlboat.phone.message.map_msgs.TargetGoalEntry();
            v3_1.setType(22);
            v3_1.setFloorId(v2_2.getFloorId().longValue());
            v3_1.setMapId(v2_2.getMapId().longValue());
            v3_1.setPointId(v2_2.getPoint().getPointId());
            v3_1.setPointName(v2_2.getPoint().getPointName());
            this.targetGoalEntries.add(v3_1);
            android.util.Log.d(this.TAG, new StringBuilder().append("targetGoalEntries(): ").append(this.targetGoalEntries).toString());
        }
        v0_1.setGoal_point_list(this.targetGoalEntries);
        this.targetGoalEntryLists.publish(v0_1);
        this.updateNaviQueueRv();
        this.selectedPointList.clear();
        this.selectedTestPoint.clear();
        this.mHandler.sendEmptyMessage(101);
        return;
    }

    private void delCargoAtoBEntry(com.boat.support.slam.entity.floors.SelectedTestPoint p6)
    {
        if ((p6 != null) && (p6.getPoint() != null)) {
            if ((p6.getPoint().getPointId() != this.cargoAtoBEntry.getPoint_id().longValue()) || ((p6.getFloorId() != this.cargoAtoBEntry.getFloor_id()) || (p6.getMapId() != this.cargoAtoBEntry.getMap_id()))) {
                this.delFlag = 2;
                android.util.Log.d(this.TAG, "\u5df2\u6e05\u9664\u7ec8\u70b9\u4fe1\u606f");
            } else {
                this.delFlag = 1;
                android.util.Log.d(this.TAG, "\u5df2\u6e05\u9664\u8d77\u70b9\u4fe1\u606f");
            }
            return;
        } else {
            return;
        }
    }

    private void getCargoAtoBEntry(com.boat.support.slam.entity.floors.SelectedTestPoint p4)
    {
        if (this.delFlag == 0) {
            this.delFlag = 0;
            this.setCargoAtoBEntry(p4, this.selectedPointList.size());
            android.util.Log.d(this.TAG, "\u589e\u52a0\u70b9\u4f4d");
            android.util.Log.d(this.TAG, new StringBuilder().append("cargoAtoBEntry2:").append(this.cargoAtoBEntry).toString());
            android.util.Log.d(this.TAG, new StringBuilder().append("selectedPointList.size():").append(this.selectedPointList.size()).toString());
            return;
        } else {
            this.setCargoAtoBEntry(p4, this.delFlag);
            android.util.Log.d(this.TAG, "\u5df2\u6e05\u9664\u70b9\u4f4d");
            android.util.Log.d(this.TAG, new StringBuilder().append("cargoAtoBEntry2:").append(this.cargoAtoBEntry).toString());
            return;
        }
    }

    private void initSpinner()
    {
        android.widget.ArrayAdapter v0_1 = new android.widget.ArrayAdapter(this, 17367048, this.floorNameList);
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
        this.floorSpinner.setOnItemSelectedListener(new com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment$6(this));
        return;
    }

    private void setCargoAtoBEntry(com.boat.support.slam.entity.floors.SelectedTestPoint p4, int p5)
    {
        switch (p5) {
            case 1:
                this.cargoAtoBEntry.setFloor_id(Long.valueOf(this.floorId));
                this.cargoAtoBEntry.setFloor_name(this.floorName);
                this.cargoAtoBEntry.setPoint_id(Long.valueOf(p4.getPoint().getPointId()));
                this.cargoAtoBEntry.setPoint_name(p4.getPoint().getPointName());
                this.cargoAtoBEntry.setMap_id(Long.valueOf(this.mapId));
                this.cargoAtoBEntry.setMap_name(this.currentMapName);
                android.util.Log.d(this.TAG, new StringBuilder().append("cargoAtoBEntry3:").append(this.cargoAtoBEntry).toString());
                break;
            case 2:
                this.cargoAtoBEntry.setBind_floor_id(Long.valueOf(this.floorId));
                this.cargoAtoBEntry.setBind_floor_name(this.floorName);
                this.cargoAtoBEntry.setBind_point_id(Long.valueOf(p4.getPoint().getPointId()));
                this.cargoAtoBEntry.setBind_point_name(p4.getPoint().getPointName());
                this.cargoAtoBEntry.setBind_map_id(Long.valueOf(this.mapId));
                this.cargoAtoBEntry.setBind_map_name(this.currentMapName);
                android.util.Log.d(this.TAG, new StringBuilder().append("cargoAtoBEntry4:").append(this.cargoAtoBEntry).toString());
                break;
            default:
        }
        return;
    }

    private void setupFloorMapData(com.boat.support.slam.entity.floors.MapList p10)
    {
        this.floorDefaultMaps.clear();
        this.floorNameList.clear();
        this.floorIdMap.clear();
        this.localMapList = p10;
        if (p10.getFloors() != null) {
            java.util.Iterator v0_2 = p10.getFloors().iterator();
            while (v0_2.hasNext()) {
                com.boat.support.slam.entity.floors.Floors v1_2 = ((com.boat.support.slam.entity.floors.Floors) v0_2.next());
                this.floorIdMap.put(Long.valueOf(v1_2.getFloorId()), v1_2);
                long v2_1 = v1_2.getDefaultmap();
                com.boat.support.slam.entity.floors.MapInfo v4_1 = v1_2.getMaps().iterator();
                while (v4_1.hasNext()) {
                    String v5_2 = ((com.boat.support.slam.entity.floors.Maps) v4_1.next());
                    if (v5_2.getMapId() == v2_1) {
                        com.boat.support.slam.entity.floors.MapInfo v4_3 = new com.boat.support.slam.entity.floors.MapInfo();
                        v4_3.setFloorId(v1_2.getFloorId());
                        v4_3.setFloorName(v1_2.getFloorName());
                        v4_3.setMapId(v5_2.getMapId());
                        v4_3.setMapName(v5_2.getMapName());
                        v4_3.setPoints(v5_2.getPoints());
                        this.floorDefaultMaps.put(v1_2.getFloorName(), v4_3);
                        break;
                    }
                }
                this.floorNameList.add(v1_2.getFloorName());
            }
            return;
        } else {
            return;
        }
    }

    private void updateNaviQueueRv()
    {
        this.runOnUiThread(new com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment$$ExternalSyntheticLambda0(this));
        return;
    }

    public void getMaps()
    {
        this.spiritServiceClient.getMapsService(new com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment$5(this));
        return;
    }

    public void initTopic()
    {
        this.targetGoalEntryLists = new com.boat.jrosbridge.Topic("/add_target_goals", com.jlboat.phone.message.map_msgs.TargetGoalEntryList, com.jlboat.phone.application.BoatSlamApplication.client);
        this.targetGoalEntryLists.advertise();
        this.delQueueEntry = new com.boat.jrosbridge.Topic("/del_target_goal", com.boat.jrosbridge.message.std_msgs.Int32, com.jlboat.phone.application.BoatSlamApplication.client);
        this.delQueueEntry.advertise();
        this.getNaviQueueListEntries = new com.boat.jrosbridge.Topic("/navi_target_goal_list", com.jlboat.phone.message.map_msgs.TargetGoalEntryRunList, com.jlboat.phone.application.BoatSlamApplication.client);
        try {
            this.getNaviQueueListEntries.subscribe(new com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment$4(this));
        } catch (Exception v0_6) {
            android.util.Log.e(this.TAG, "\u8ba2\u9605\u5931\u8d25", v0_6);
        }
        return;
    }

    synthetic void lambda$updateNaviQueueRv$0$com-jlboat-phone-fragment-settingfragment-NavigationQueueFragment()
    {
        if (this.naviQueueListEntrys != null) {
            com.jlboat.phone.message.map_msgs.NaviQueueListEntry[] v0_4 = this.naviQueueListEntrys.getNaviQueueListEntrys();
            if (v0_4 != null) {
                this.liftQueueAdapter.setData(java.util.Arrays.asList(v0_4));
                this.liftQueueAdapter.notifyDataSetChanged();
                return;
            } else {
                android.util.Log.e(this.TAG, "\u961f\u5217\u6570\u7ec4\u4e3a\u7a7a");
                this.liftQueueAdapter.setData(0);
                this.liftQueueAdapter.notifyDataSetChanged();
                return;
            }
        } else {
            android.util.Log.e(this.TAG, "naviQueueListEntrys \u4e3a null");
            this.liftQueueAdapter.setData(0);
            this.liftQueueAdapter.notifyDataSetChanged();
            return;
        }
    }

    public void onCheckedChanged(android.widget.CompoundButton p1, boolean p2)
    {
        return;
    }

    public void onClick(android.view.View p1)
    {
        return;
    }

    public void onCreate(android.os.Bundle p4)
    {
        super.onCreate(p4);
        this.initTitleBar(2131361864, 2131493323);
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        this.floorSpinner = ((android.widget.Spinner) this.findViewById(2131231259));
        this.navCurrentmapNameTv = ((android.widget.TextView) this.findViewById(2131231032));
        this.navAllPointRv = ((android.support.v7.widget.RecyclerView) this.findViewById(2131231031));
        this.naviQueueRv = ((android.support.v7.widget.RecyclerView) this.findViewById(2131231288));
        this.addQueueBtu = ((android.widget.Button) this.findViewById(2131230751));
        this.navAllPointRv.setLayoutManager(new android.support.v7.widget.GridLayoutManager(this, 6));
        this.testPointListAdapter = new com.jlboat.phone.adapter.TestPointListAdapter();
        this.testPointListAdapter.setOnItemClickListener(new com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment$MyNavRvItemClick(this));
        this.navAllPointRv.setAdapter(this.testPointListAdapter);
        this.naviQueueRv.setLayoutManager(new android.support.v7.widget.GridLayoutManager(this, 8));
        this.liftQueueAdapter = new com.jlboat.phone.adapter.LiftQueueAdapter(this);
        this.naviQueueRv.setAdapter(this.liftQueueAdapter);
        this.initTopic();
        this.addQueueBtu.setOnClickListener(new com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment$2(this));
        this.liftQueueAdapter.setOnItemDeleteListener(new com.jlboat.phone.fragment.settingfragment.NavigationQueueFragment$3(this));
        this.naviQueueRv.setLayoutManager(new android.support.v7.widget.LinearLayoutManager(this));
        this.naviQueueRv.setAdapter(this.liftQueueAdapter);
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

    public void onPointerCaptureChanged(boolean p1)
    {
        super.onPointerCaptureChanged(p1);
        return;
    }

    protected void onResume()
    {
        super.onResume();
        this.getMaps();
        this.updateNaviQueueRv();
        return;
    }
}
