package com.jlboat.phone.activity;
public class MapEditChargeActivity extends com.jlboat.phone.base.BaseFullActivity implements android.view.View$OnClickListener {
    private static final String TAG = "MapEditChargeActivity";
    android.widget.Button bt_yes;
    private java.util.List chargingPrioritys;
    private java.util.List currentFloors;
    private com.boat.support.slam.entity.floors.MapList localMapList;
    java.util.List mapPointList;
    android.support.v7.widget.RecyclerView navAllPointRv;
    android.widget.LinearLayout navNopointTipLl;
    android.support.v7.widget.RecyclerView navSelectedPointRv;
    java.util.List selectedPointList;
    private com.jlboat.phone.communication.SpiritServiceClient spiritServiceClient;
    private com.jlboat.phone.communication.SpiritTopicListener spiritTopicListener;
    com.jlboat.phone.adapter.MapActDlFloorListAdapter testPointListAdapter;
    com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter testPointSelectedListAdapter;

    public MapEditChargeActivity()
    {
        this.spiritServiceClient = new com.jlboat.phone.communication.SpiritServiceClient();
        this.spiritTopicListener = new com.jlboat.phone.communication.SpiritTopicListener();
        this.chargingPrioritys = new java.util.LinkedList();
        this.currentFloors = new java.util.ArrayList();
        this.mapPointList = new java.util.ArrayList();
        this.selectedPointList = new java.util.ArrayList();
        return;
    }

    static synthetic void access$000(com.jlboat.phone.activity.MapEditChargeActivity p0)
    {
        p0.updateVisibility();
        return;
    }

    static synthetic java.util.List access$100(com.jlboat.phone.activity.MapEditChargeActivity p1)
    {
        return p1.chargingPrioritys;
    }

    static synthetic java.util.List access$102(com.jlboat.phone.activity.MapEditChargeActivity p0, java.util.List p1)
    {
        p0.chargingPrioritys = p1;
        return p1;
    }

    static synthetic java.util.List access$200(com.jlboat.phone.activity.MapEditChargeActivity p1)
    {
        return p1.currentFloors;
    }

    static synthetic java.util.List access$202(com.jlboat.phone.activity.MapEditChargeActivity p0, java.util.List p1)
    {
        p0.currentFloors = p1;
        return p1;
    }

    private void updateVisibility()
    {
        this.runOnUiThread(new com.jlboat.phone.activity.MapEditChargeActivity$$ExternalSyntheticLambda0(this));
        return;
    }

    public void initTopic()
    {
        android.util.Log.e("MapEditChargeActivity", "initTopic");
        this.spiritServiceClient.getMapsService(new com.jlboat.phone.activity.MapEditChargeActivity$3(this));
        return;
    }

    synthetic void lambda$updateVisibility$0$com-jlboat-phone-activity-MapEditChargeActivity()
    {
        this.testPointListAdapter.setData(this.mapPointList, this.selectedPointList);
        this.testPointSelectedListAdapter.setData(this.selectedPointList);
        if (this.selectedPointList.size() <= 0) {
            this.navNopointTipLl.setVisibility(0);
            this.navSelectedPointRv.setVisibility(8);
        } else {
            this.navSelectedPointRv.setVisibility(0);
            this.navNopointTipLl.setVisibility(8);
        }
        return;
    }

    public void onClick(android.view.View p8)
    {
        switch (p8.getId()) {
            case 2131230821:
                android.util.Log.d("MapEditChargeActivity", "ok:");
                java.util.LinkedList v2_1 = new java.util.LinkedList();
                StringBuilder v3_0 = this.selectedPointList.iterator();
                while (v3_0.hasNext()) {
                    v2_1.add(Long.valueOf(((com.boat.support.slam.entity.floors.Floors) v3_0.next()).getFloorId()));
                }
                if (v2_1.size() == 0) {
                    v2_1.add(Long.valueOf(0));
                }
                android.util.Log.d("MapEditChargeActivity", new StringBuilder().append("ok:").append(v2_1).toString());
                this.spiritServiceClient.setChargingPriority(v2_1, new com.jlboat.phone.activity.MapEditChargeActivity$4(this));
                break;
            default:
        }
        return;
    }

    protected void onCreate(android.os.Bundle p9)
    {
        android.util.Log.e("MapEditChargeActivity", "onCreate");
        super.onCreate(p9);
        this.initTitleBar(2131361844, 2131492933);
        this.navNopointTipLl = ((android.widget.LinearLayout) this.findViewById(2131231034));
        this.navAllPointRv = ((android.support.v7.widget.RecyclerView) this.findViewById(2131231031));
        this.navSelectedPointRv = ((android.support.v7.widget.RecyclerView) this.findViewById(2131231036));
        this.bt_yes = ((android.widget.Button) this.findViewById(2131230821));
        this.bt_yes.setOnClickListener(this);
        this.testPointListAdapter = new com.jlboat.phone.adapter.MapActDlFloorListAdapter();
        this.navAllPointRv.setLayoutManager(new android.support.v7.widget.GridLayoutManager(this, 6));
        this.navAllPointRv.setAdapter(this.testPointListAdapter);
        this.testPointSelectedListAdapter = new com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter();
        this.navSelectedPointRv.setLayoutManager(new android.support.v7.widget.GridLayoutManager(this, 6));
        this.navSelectedPointRv.setAdapter(this.testPointSelectedListAdapter);
        this.testPointSelectedListAdapter.setOnItemClickListener(new com.jlboat.phone.activity.MapEditChargeActivity$1(this));
        this.testPointListAdapter.setOnItemClickListener(new com.jlboat.phone.activity.MapEditChargeActivity$2(this));
        this.mapPointList.addAll(this.currentFloors);
        if (this.chargingPrioritys != null) {
            java.util.Iterator v0_26 = this.chargingPrioritys.iterator();
            while (v0_26.hasNext()) {
                long v1_16 = ((Long) v0_26.next()).longValue();
                java.util.List v3_1 = this.currentFloors.iterator();
                while (v3_1.hasNext()) {
                    com.boat.support.slam.entity.floors.Floors v4_2 = ((com.boat.support.slam.entity.floors.Floors) v3_1.next());
                    if (v4_2.getFloorId() == v1_16) {
                        this.selectedPointList.add(v4_2);
                        break;
                    }
                }
            }
        }
        this.updateVisibility();
        return;
    }

    protected void onResume()
    {
        android.util.Log.e("MapEditChargeActivity", "onResume");
        super.onResume();
        this.initTopic();
        return;
    }
}
