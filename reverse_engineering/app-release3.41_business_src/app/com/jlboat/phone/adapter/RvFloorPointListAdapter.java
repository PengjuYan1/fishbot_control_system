package com.jlboat.phone.adapter;
public class RvFloorPointListAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private int TYPE_FRIEND;
    private int TYPE_GROUP;
    private android.content.Context context;
    private long defFloorId;
    private java.util.List listData;
    private com.boat.support.slam.entity.floors.Floors localFloor;
    private com.boat.support.slam.entity.floors.Maps localMap;
    private com.boat.support.slam.entity.floors.Points localPoint;
    private com.jlboat.phone.adapter.RvFloorPointListAdapter$OnClick onclick;

    public RvFloorPointListAdapter(android.content.Context p2)
    {
        this.listData = new java.util.ArrayList();
        this.TYPE_GROUP = 0;
        this.TYPE_FRIEND = 1;
        this.context = p2;
        return;
    }

    static synthetic long access$300(com.jlboat.phone.adapter.RvFloorPointListAdapter p2)
    {
        return p2.defFloorId;
    }

    static synthetic android.content.Context access$400(com.jlboat.phone.adapter.RvFloorPointListAdapter p1)
    {
        return p1.context;
    }

    static synthetic java.util.List access$500(com.jlboat.phone.adapter.RvFloorPointListAdapter p1, com.boat.support.slam.entity.floors.Floors p2)
    {
        return p1.getFilteredPoints(p2);
    }

    static synthetic java.util.List access$600(com.jlboat.phone.adapter.RvFloorPointListAdapter p1)
    {
        return p1.listData;
    }

    static synthetic com.jlboat.phone.adapter.RvFloorPointListAdapter$OnClick access$700(com.jlboat.phone.adapter.RvFloorPointListAdapter p1)
    {
        return p1.onclick;
    }

    private void expandDefaultFloor(java.util.List p8)
    {
        int v0 = 0;
        while (v0 < p8.size()) {
            com.boat.support.slam.entity.floors.Floors v1_2 = ((com.boat.support.slam.entity.floors.Floors) p8.get(v0));
            if (v1_2.getFloorId() != this.defFloorId) {
                v0++;
            } else {
                this.localFloor = v1_2;
                java.util.List v2_0 = this.getFilteredPoints(v1_2);
                if ((v2_0 == null) || (v2_0.isEmpty())) {
                    break;
                }
                int v3_1 = (v0 + 1);
                this.listData.addAll(v3_1, v2_0);
                this.notifyItemRangeInserted(v3_1, v2_0.size());
                break;
            }
        }
        return;
    }

    private com.boat.support.slam.entity.floors.Floors findParentFloorOfPoint(int p4)
    {
        int v0_0 = (p4 - 1);
        while (v0_0 >= 0) {
            Object v1_1 = this.listData.get(v0_0);
            if (!(v1_1 instanceof com.boat.support.slam.entity.floors.Floors)) {
                v0_0--;
            } else {
                return ((com.boat.support.slam.entity.floors.Floors) v1_1);
            }
        }
        return 0;
    }

    private java.util.List getFilteredPoints(com.boat.support.slam.entity.floors.Floors p8)
    {
        java.util.List v0_3 = p8.getMaps().iterator();
        while (v0_3.hasNext()) {
            com.boat.support.slam.entity.floors.Maps v1_1 = ((com.boat.support.slam.entity.floors.Maps) v0_3.next());
            if (v1_1.getMapId() == p8.getDefaultmap()) {
                this.localMap = v1_1;
                return this.removeOOO(v1_1.getPoints());
            }
        }
        return 0;
    }

    private java.util.List removeOOO(java.util.List p6)
    {
        java.util.ArrayList v0_1 = new java.util.ArrayList();
        java.util.Iterator v1 = p6.iterator();
        while (v1.hasNext()) {
            com.boat.support.slam.entity.floors.Points v2_0 = ((com.boat.support.slam.entity.floors.Points) v1.next());
            if (!v2_0.getPointName().equals(com.jlboat.phone.application.BoatSlamApplication.CANCLEPOINTNAME)) {
                v0_1.add(v2_0);
            }
        }
        return v0_1;
    }

    public int getItemCount()
    {
        return this.listData.size();
    }

    public int getItemViewType(int p3)
    {
        Object v0_1 = this.listData.get(p3);
        if (!(v0_1 instanceof com.boat.support.slam.entity.floors.Floors)) {
            if (!(v0_1 instanceof com.boat.support.slam.entity.floors.Points)) {
                return -1;
            } else {
                return this.TYPE_FRIEND;
            }
        } else {
            return this.TYPE_GROUP;
        }
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView$ViewHolder p4, int p5)
    {
        if (!(p4 instanceof com.jlboat.phone.adapter.RvFloorPointListAdapter$GroupViewHolder)) {
            if (!(p4 instanceof com.jlboat.phone.adapter.RvFloorPointListAdapter$FrdViewHolder)) {
            } else {
                com.jlboat.phone.adapter.RvFloorPointListAdapter$FrdViewHolder.access$200(((com.jlboat.phone.adapter.RvFloorPointListAdapter$FrdViewHolder) p4), ((com.boat.support.slam.entity.floors.Points) this.listData.get(p5)), this.findParentFloorOfPoint(p5));
            }
        } else {
            ((com.jlboat.phone.adapter.RvFloorPointListAdapter$GroupViewHolder) p4).setData(((com.boat.support.slam.entity.floors.Floors) this.listData.get(p5)));
        }
        return;
    }

    public android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p5, int p6)
    {
        if (p6 != this.TYPE_GROUP) {
            if (p6 != this.TYPE_FRIEND) {
                return 0;
            } else {
                return new com.jlboat.phone.adapter.RvFloorPointListAdapter$FrdViewHolder(this, android.view.LayoutInflater.from(p5.getContext()).inflate(2131361879, p5, 0), 0);
            }
        } else {
            return new com.jlboat.phone.adapter.RvFloorPointListAdapter$GroupViewHolder(this, android.view.LayoutInflater.from(p5.getContext()).inflate(2131361878, p5, 0), 0);
        }
    }

    public void setListData(com.boat.support.slam.entity.floors.MapList p3)
    {
        android.util.Log.e("111", "setListData");
        this.listData.clear();
        if (p3 != null) {
            this.defFloorId = p3.getDefaultFloor();
            java.util.List v0_1 = p3.getFloors();
            this.listData.addAll(v0_1);
            this.expandDefaultFloor(v0_1);
        }
        this.notifyDataSetChanged();
        return;
    }

    public void setOnclickItem(com.jlboat.phone.adapter.RvFloorPointListAdapter$OnClick p1)
    {
        this.onclick = p1;
        return;
    }
}
