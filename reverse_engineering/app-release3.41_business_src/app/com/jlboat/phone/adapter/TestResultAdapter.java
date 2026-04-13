package com.jlboat.phone.adapter;
public class TestResultAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private android.content.Context mContext;
    private java.util.List mList;
    private com.boat.support.slam.entity.floors.MapList mMapList;
    private java.util.List mMapLists;
    private com.boat.support.slam.entity.floors.MapList map;
    private com.jlboat.phone.message.map_msgs.NaviTestResultEntry point;

    public TestResultAdapter(android.content.Context p2)
    {
        this.mList = 0;
        this.mMapLists = 0;
        this.mMapList = 0;
        this.mContext = p2;
        return;
    }

    private String findFloorsName()
    {
        if ((this.mMapList != null) && ((this.mMapList.getFloors() != null) && (this.point != null))) {
            long v8;
            long v2 = 0;
            String v0_2 = this.point.getGoalName();
            if (this.point.getFloor_id() != null) {
                v8 = this.point.getFloor_id().longValue();
                v2 = this.point.getMap_id().longValue();
                this.point.getPoint_id().longValue();
            } else {
                com.boat.jrosbridge.message.Log.d("TAG", "\u6211\u662f\u8001\u7248\u672c");
                v8 = this.mMapList.getDefaultFloor();
                String v6_14 = this.mMapList.getFloors().iterator();
                if (v6_14.hasNext()) {
                    String v6_16 = ((com.boat.support.slam.entity.floors.Floors) v6_14.next());
                    if (v8 == v6_16.getDefaultmap()) {
                        v2 = v6_16.getDefaultmap();
                    }
                }
            }
            String v6_19 = this.mMapList.getFloors().iterator();
            while (v6_19.hasNext()) {
                com.boat.support.slam.entity.floors.Floors v10_4 = ((com.boat.support.slam.entity.floors.Floors) v6_19.next());
                if ((v10_4.getFloorId() == v8) && (v10_4.getMaps() != null)) {
                    String v6_21 = v10_4.getMaps().iterator();
                    while (v6_21.hasNext()) {
                        com.boat.support.slam.entity.floors.Maps v11_4 = ((com.boat.support.slam.entity.floors.Maps) v6_21.next());
                        if ((v11_4.getMapId() == v2) && (v11_4.getPoints() != null)) {
                            java.util.Iterator v12_4 = v11_4.getPoints().iterator();
                            while (v12_4.hasNext()) {
                                if (((com.boat.support.slam.entity.floors.Points) v12_4.next()).getPointName().equals(v0_2)) {
                                    com.boat.jrosbridge.message.Log.d("TAG", new StringBuilder().append("floorName:").append(v10_4.getFloorName()).toString());
                                    return v10_4.getFloorName();
                                }
                            }
                        }
                    }
                }
            }
            return "";
        } else {
            return "";
        }
    }

    public int getItemCount()
    {
        int v0_1;
        if (this.mList == null) {
            v0_1 = 0;
        } else {
            v0_1 = this.mList.size();
        }
        return v0_1;
    }

    public int getItemViewType(int p1)
    {
        return p1;
    }

    public bridge synthetic void onBindViewHolder(android.support.v7.widget.RecyclerView$ViewHolder p1, int p2)
    {
        this.onBindViewHolder(((com.jlboat.phone.adapter.TestResultAdapter$MyResHolder) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.adapter.TestResultAdapter$MyResHolder p13, int p14)
    {
        if (p14 == (this.mList.size() - 1)) {
            p13.line.setVisibility(8);
        }
        this.point = ((com.jlboat.phone.message.map_msgs.NaviTestResultEntry) this.mList.get(p14));
        p13.floorsTv.setText(this.findFloorsName());
        p13.nameTv.setText(this.point.getGoalName());
        switch (((int) this.point.getGoalResult())) {
            case -1:
                p13.stateTv.setText("\u7b49\u5f85\u4e2d");
                p13.stateTv.setTextColor(this.mContext.getResources().getColor(2131034234));
                break;
            case 0:
                p13.stateTv.setText("\u6d4b\u8bd5\u5b8c\u6210");
                p13.stateTv.setTextColor(this.mContext.getResources().getColor(2131034159));
                break;
            case 1:
                p13.stateTv.setText("\u6d4b\u8bd5\u5931\u8d25");
                p13.stateTv.setTextColor(this.mContext.getResources().getColor(2131034138));
                break;
            case 2:
                p13.stateTv.setText("\u53d6\u6d88\u6d4b\u8bd5");
                p13.stateTv.setTextColor(this.mContext.getResources().getColor(2131034149));
                break;
            case 3:
                p13.stateTv.setText("\u6b63\u5728\u6d4b\u8bd5");
                p13.stateTv.setTextColor(this.mContext.getResources().getColor(2131034214));
                break;
            case 100:
                p13.stateTv.setText("\u5145\u7535\u5b8c\u6210");
                p13.stateTv.setTextColor(this.mContext.getResources().getColor(2131034159));
                break;
            default:
                p13.stateTv.setText("\u6d4b\u8bd5\u5f02\u5e38");
                p13.stateTv.setTextColor(this.mContext.getResources().getColor(2131034149));
        }
        if ((((int) this.point.getTestType()) != 1) && (((int) this.point.getTestType()) != 2)) {
            p13.rlchangeMsg.setVisibility(0);
            switch (((int) this.point.getChargeResult())) {
                case -1:
                    p13.chargeState.setText("\u672a\u5145\u7535");
                    p13.chargeState.setTextColor(this.mContext.getResources().getColor(2131034234));
                    break;
                case 0:
                    p13.chargeState.setText("\u5145\u7535\u5b8c\u6210");
                    p13.chargeState.setTextColor(this.mContext.getResources().getColor(2131034159));
                    break;
                case 1:
                    p13.chargeState.setText("\u5145\u7535\u5931\u8d25");
                    p13.chargeState.setTextColor(this.mContext.getResources().getColor(2131034138));
                    break;
                case 2:
                    p13.chargeState.setText("\u5145\u7535\u53d6\u6d88");
                    p13.chargeState.setTextColor(this.mContext.getResources().getColor(2131034149));
                    break;
                case 3:
                    p13.chargeState.setText("\u6b63\u5728\u6d4b\u8bd5");
                    p13.chargeState.setTextColor(this.mContext.getResources().getColor(2131034214));
                    break;
                default:
                    p13.chargeState.setText("\u5145\u7535\u5f02\u5e38");
                    p13.chargeState.setTextColor(this.mContext.getResources().getColor(2131034149));
            }
            return;
        } else {
            p13.rlchangeMsg.setVisibility(8);
            return;
        }
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.adapter.TestResultAdapter$MyResHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.TestResultAdapter$MyResHolder(this, android.view.LayoutInflater.from(p4.getContext()).inflate(2131361939, p4, 0));
    }

    public void setData(java.util.List p1)
    {
        this.mList = p1;
        this.notifyDataSetChanged();
        return;
    }

    public void setData2(com.boat.support.slam.entity.floors.MapList p1)
    {
        this.mMapList = p1;
        this.notifyDataSetChanged();
        return;
    }
}
