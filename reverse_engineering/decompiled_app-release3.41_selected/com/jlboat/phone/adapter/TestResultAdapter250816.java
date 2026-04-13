package com.jlboat.phone.adapter;
public class TestResultAdapter250816 extends android.support.v7.widget.RecyclerView$Adapter {
    private int cycleCount;
    private boolean isCycle;
    private android.content.Context mContext;
    private com.boat.support.slam.entity.floors.MapList mMapList;
    private java.util.List mWrappedList;
    private com.jlboat.phone.message.map_msgs.TargetGoalType mtype;
    private com.jlboat.phone.adapter.TestResultAdapter250816$OnItemDeleteListener onItemDeleteListener;

    public TestResultAdapter250816(android.content.Context p2)
    {
        this.mWrappedList = 0;
        this.mMapList = 0;
        this.mContext = p2;
        return;
    }

    private String findFloorsName(long p16, com.jlboat.phone.message.map_msgs.TargetGoalEntry p18)
    {
        if ((this.mMapList != null) && ((this.mMapList.getFloors() != null) && (p18 != null))) {
            long v5 = p18.getMapId();
            long v7 = p18.getPointId();
            String v1_3 = this.mMapList.getFloors().iterator();
            while (v1_3.hasNext()) {
                com.boat.support.slam.entity.floors.Floors v9_2 = ((com.boat.support.slam.entity.floors.Floors) v1_3.next());
                if ((v9_2.getFloorId() == p16) && (v9_2.getMaps() != null)) {
                    String v1_5 = v9_2.getMaps().iterator();
                    while (v1_5.hasNext()) {
                        com.boat.support.slam.entity.floors.Maps v2_3 = ((com.boat.support.slam.entity.floors.Maps) v1_5.next());
                        if ((v2_3.getMapId() == v5) && (v2_3.getPoints() != null)) {
                            String v10_5 = v2_3.getPoints().iterator();
                            while (v10_5.hasNext()) {
                                if (((com.boat.support.slam.entity.floors.Points) v10_5.next()).getPointId() == v7) {
                                    com.boat.jrosbridge.message.Log.d("TAG", new StringBuilder().append("floorName:").append(v9_2.getFloorName()).toString());
                                    return v9_2.getFloorName();
                                }
                            }
                        }
                    }
                    return v9_2.getFloorName();
                }
            }
            return "";
        } else {
            return "";
        }
    }

    private String findpointName(long p17, com.jlboat.phone.message.map_msgs.TargetGoalEntry p19)
    {
        if ((this.mMapList != null) && ((this.mMapList.getFloors() != null) && (p19 != null))) {
            long v3 = p19.getFloor_id_putdown();
            long v5 = p19.getMapId();
            String v1_3 = this.mMapList.getFloors().iterator();
            while (v1_3.hasNext()) {
                com.boat.support.slam.entity.floors.Floors v9_2 = ((com.boat.support.slam.entity.floors.Floors) v1_3.next());
                if ((v9_2.getFloorId() == v3) && (v9_2.getMaps() != null)) {
                    String v1_5 = v9_2.getMaps().iterator();
                    while (v1_5.hasNext()) {
                        com.boat.support.slam.entity.floors.Maps v10_4 = ((com.boat.support.slam.entity.floors.Maps) v1_5.next());
                        if ((v10_4.getMapId() == v5) && (v10_4.getPoints() != null)) {
                            java.util.Iterator v11_3 = v10_4.getPoints().iterator();
                            while (v11_3.hasNext()) {
                                com.boat.support.slam.entity.floors.Points v12_3 = ((com.boat.support.slam.entity.floors.Points) v11_3.next());
                                if (v12_3.getPointId() == p17) {
                                    return v12_3.getPointName();
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

    private boolean isEntryCompleted(com.jlboat.phone.message.map_msgs.TargetGoalEntry p7)
    {
        int v0 = 0;
        if (p7 != null) {
            if (((long) p7.getStatus()) == 2) {
                v0 = 1;
            }
            return v0;
        } else {
            return 0;
        }
    }

    public int getItemCount()
    {
        int v0_1;
        if (this.mWrappedList == null) {
            v0_1 = 0;
        } else {
            v0_1 = this.mWrappedList.size();
        }
        return v0_1;
    }

    synthetic int lambda$setData$0$com-jlboat-phone-adapter-TestResultAdapter250816(com.jlboat.phone.message.map_msgs.TargetGoalEntry p4, com.jlboat.phone.message.map_msgs.TargetGoalEntry p5)
    {
        boolean v0 = this.isEntryCompleted(p4);
        boolean v1 = this.isEntryCompleted(p5);
        if ((!v0) || (v1)) {
            if ((v0) || (!v1)) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return 1;
        }
    }

    public bridge synthetic void onBindViewHolder(android.support.v7.widget.RecyclerView$ViewHolder p1, int p2)
    {
        this.onBindViewHolder(((com.jlboat.phone.adapter.TestResultAdapter250816$MyResHolder) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.adapter.TestResultAdapter250816$MyResHolder p12, int p13)
    {
        if (p13 != (this.mWrappedList.size() - 1)) {
            p12.line.setVisibility(0);
        } else {
            p12.line.setVisibility(8);
        }
        com.jlboat.phone.adapter.GoalEntryWithIndex v0_3 = ((com.jlboat.phone.adapter.GoalEntryWithIndex) this.mWrappedList.get(p13));
        com.jlboat.phone.message.map_msgs.TargetGoalEntry v2_0 = v0_3.entry;
        if (v2_0 != null) {
            if (v0_3.completedIndex == -1) {
                p12.indexTv.setText("");
            } else {
                p12.indexTv.setText(String.valueOf(v0_3.completedIndex));
            }
            p12.floorsTv.setText(this.findFloorsName(v2_0.getFloorId(), v2_0));
            if (v2_0.getType() != 24) {
                p12.nameTv.setText(v2_0.getPointName());
            } else {
                p12.nameTv.setText("\u5145\u7535\u6869");
            }
            switch (v2_0.getType()) {
                case 0:
                case 20:
                    p12.typeTv.setText("\u5bfc\u822a");
                    break;
                case 1:
                    p12.typeTv.setText("\u7535\u68af");
                    break;
                case 2:
                    p12.typeTv.setText("\u7a84\u901a\u9053");
                    break;
                case 3:
                    p12.typeTv.setText("\u659c\u5761");
                    break;
                case 6:
                    p12.typeTv.setText("\u95e8\u7981");
                    break;
                case 10:
                    p12.typeTv.setText("\u9ad8\u901f");
                    break;
                case 21:
                    p12.typeTv.setText("\u547c\u53eb\u5668");
                    break;
                case 22:
                    p12.typeTv.setText("\u9876\u5347");
                    break;
                case 23:
                    p12.typeTv.setText("\u4e0b\u843d");
                    break;
                case 24:
                    p12.typeTv.setText("\u5145\u7535");
                    break;
                case 26:
                    p12.typeTv.setText("\u51fa\u6869");
                    break;
                case 28:
                    p12.typeTv.setText("\u5f85\u547d\u533a");
                    break;
                default:
                    p12.typeTv.setText("\u672a\u77e5\u7c7b\u578b");
            }
            if (v2_0.getType() != 24) {
                switch (v2_0.getStatus()) {
                    case 0:
                        p12.stateTv.setText("\u7b49\u5f85\u4e2d");
                        p12.stateTv.setTextColor(this.mContext.getResources().getColor(2131034159));
                        break;
                    case 1:
                        p12.stateTv.setText("\u6b63\u5728\u6d4b\u8bd5");
                        p12.stateTv.setTextColor(this.mContext.getResources().getColor(2131034138));
                        break;
                    case 2:
                        p12.stateTv.setText("\u6d4b\u8bd5\u5b8c\u6210");
                        p12.stateTv.setTextColor(this.mContext.getResources().getColor(2131034149));
                        break;
                    case 100:
                        p12.stateTv.setText("\u5145\u7535\u5b8c\u6210");
                        p12.stateTv.setTextColor(this.mContext.getResources().getColor(2131034159));
                        break;
                    default:
                        p12.stateTv.setText("\u6d4b\u8bd5\u5f02\u5e38");
                        p12.stateTv.setTextColor(this.mContext.getResources().getColor(2131034149));
                }
            } else {
                switch (v2_0.getStatus()) {
                    case 0:
                        p12.stateTv.setText("\u7b49\u5f85\u4e2d");
                        p12.stateTv.setTextColor(this.mContext.getResources().getColor(2131034159));
                        break;
                    case 1:
                        p12.stateTv.setText("\u6b63\u5728\u56de\u5145");
                        p12.stateTv.setTextColor(this.mContext.getResources().getColor(2131034138));
                        break;
                    case 2:
                        p12.stateTv.setText("\u5145\u7535\u5b8c\u6210");
                        p12.stateTv.setTextColor(this.mContext.getResources().getColor(2131034149));
                        break;
                    default:
                        p12.stateTv.setText("\u6d4b\u8bd5\u5f02\u5e38");
                        p12.stateTv.setTextColor(this.mContext.getResources().getColor(2131034149));
                }
            }
            p12.rlchangeMsg.setVisibility(8);
            return;
        } else {
            p12.indexTv.setText("");
            return;
        }
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.adapter.TestResultAdapter250816$MyResHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.TestResultAdapter250816$MyResHolder(this, android.view.LayoutInflater.from(p4.getContext()).inflate(2131361939, p4, 0));
    }

    public void setData(java.util.List p8)
    {
        com.boat.jrosbridge.message.Log.d("TAG", new StringBuilder().append("floorName2:").append(p8.toString()).toString());
        this.mWrappedList = new java.util.ArrayList();
        if (p8 != null) {
            java.util.ArrayList v0_6 = new java.util.ArrayList(p8);
            java.util.Collections.sort(v0_6, new com.jlboat.phone.adapter.TestResultAdapter250816$$ExternalSyntheticLambda0(this));
            int v1_4 = 0;
            java.util.Iterator v2 = v0_6.iterator();
            while (v2.hasNext()) {
                com.jlboat.phone.message.map_msgs.TargetGoalEntry v3_2 = ((com.jlboat.phone.message.map_msgs.TargetGoalEntry) v2.next());
                if (!this.isEntryCompleted(v3_2)) {
                    this.mWrappedList.add(new com.jlboat.phone.adapter.GoalEntryWithIndex(v3_2, -1));
                } else {
                    v1_4++;
                    this.mWrappedList.add(new com.jlboat.phone.adapter.GoalEntryWithIndex(v3_2, v1_4));
                }
            }
            this.notifyDataSetChanged();
            return;
        } else {
            this.notifyDataSetChanged();
            return;
        }
    }

    public void setData2(com.boat.support.slam.entity.floors.MapList p1)
    {
        this.mMapList = p1;
        this.notifyDataSetChanged();
        return;
    }

    public void setData3(boolean p1, int p2)
    {
        this.isCycle = p1;
        this.cycleCount = p2;
        this.notifyDataSetChanged();
        return;
    }

    public void setOnItemDeleteListener(com.jlboat.phone.adapter.TestResultAdapter250816$OnItemDeleteListener p1)
    {
        this.onItemDeleteListener = p1;
        return;
    }
}
