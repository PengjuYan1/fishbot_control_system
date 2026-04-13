package com.jlboat.phone.adapter;
public class RvFloorMapListAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private final String TAG;
    private int TYPE_FRIEND;
    private int TYPE_GROUP;
    private android.content.Context context;
    private long currentDefaultMapId;
    private long currentExpandedFloorId;
    private long defFloorId;
    private java.util.List listData;
    private com.boat.support.slam.entity.floors.Floors localFloor;
    private com.boat.support.slam.entity.floors.Maps localMap;
    private com.jlboat.phone.adapter.RvFloorMapListAdapter$OnClick onclick;

    public RvFloorMapListAdapter(android.content.Context p3)
    {
        this.TAG = "RvFloorMapListAdapter";
        this.listData = new java.util.ArrayList();
        this.currentExpandedFloorId = -1;
        this.currentDefaultMapId = -1;
        this.TYPE_GROUP = 0;
        this.TYPE_FRIEND = 1;
        this.context = p3;
        return;
    }

    static synthetic long access$1002(com.jlboat.phone.adapter.RvFloorMapListAdapter p0, long p1)
    {
        p0.currentDefaultMapId = p1;
        return p1;
    }

    static synthetic com.jlboat.phone.adapter.RvFloorMapListAdapter$OnClick access$300(com.jlboat.phone.adapter.RvFloorMapListAdapter p1)
    {
        return p1.onclick;
    }

    static synthetic long access$500(com.jlboat.phone.adapter.RvFloorMapListAdapter p2)
    {
        return p2.currentExpandedFloorId;
    }

    static synthetic long access$502(com.jlboat.phone.adapter.RvFloorMapListAdapter p0, long p1)
    {
        p0.currentExpandedFloorId = p1;
        return p1;
    }

    static synthetic long access$600(com.jlboat.phone.adapter.RvFloorMapListAdapter p2)
    {
        return p2.defFloorId;
    }

    static synthetic android.content.Context access$700(com.jlboat.phone.adapter.RvFloorMapListAdapter p1)
    {
        return p1.context;
    }

    static synthetic java.util.List access$800(com.jlboat.phone.adapter.RvFloorMapListAdapter p1)
    {
        return p1.listData;
    }

    static synthetic int access$900(com.jlboat.phone.adapter.RvFloorMapListAdapter p1)
    {
        return p1.TYPE_FRIEND;
    }

    private com.boat.support.slam.entity.floors.Floors findFloorByMap(com.boat.support.slam.entity.floors.Maps p11)
    {
        int v0_1 = this.listData.iterator();
        while (v0_1.hasNext()) {
            Object v1_1 = v0_1.next();
            if ((v1_1 instanceof com.boat.support.slam.entity.floors.Floors)) {
                com.boat.support.slam.entity.floors.Floors v2_2 = ((com.boat.support.slam.entity.floors.Floors) v1_1);
                java.util.Iterator v3_1 = v2_2.getMaps().iterator();
                while (v3_1.hasNext()) {
                    if (((com.boat.support.slam.entity.floors.Maps) v3_1.next()).getMapId() == p11.getMapId()) {
                        return v2_2;
                    }
                }
            }
        }
        return 0;
    }

    public int getItemCount()
    {
        return this.listData.size();
    }

    public int getItemViewType(int p3)
    {
        Object v0_1 = this.listData.get(p3);
        if (!(v0_1 instanceof com.boat.support.slam.entity.floors.Floors)) {
            if (!(v0_1 instanceof com.boat.support.slam.entity.floors.Maps)) {
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
        if (!(p4 instanceof com.jlboat.phone.adapter.RvFloorMapListAdapter$GroupViewHolder)) {
            if ((p4 instanceof com.jlboat.phone.adapter.RvFloorMapListAdapter$FrdViewHolder)) {
                com.boat.support.slam.entity.floors.Maps v0_6 = ((com.boat.support.slam.entity.floors.Maps) this.listData.get(p5));
                com.jlboat.phone.adapter.RvFloorMapListAdapter$FrdViewHolder.access$200(((com.jlboat.phone.adapter.RvFloorMapListAdapter$FrdViewHolder) p4), v0_6, this.findFloorByMap(v0_6));
            }
        } else {
            ((com.jlboat.phone.adapter.RvFloorMapListAdapter$GroupViewHolder) p4).setData(((com.boat.support.slam.entity.floors.Floors) this.listData.get(p5)));
        }
        return;
    }

    public android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p5, int p6)
    {
        if (p6 != this.TYPE_GROUP) {
            if (p6 != this.TYPE_FRIEND) {
                return 0;
            } else {
                return new com.jlboat.phone.adapter.RvFloorMapListAdapter$FrdViewHolder(this, android.view.LayoutInflater.from(p5.getContext()).inflate(2131361876, p5, 0), 0);
            }
        } else {
            return new com.jlboat.phone.adapter.RvFloorMapListAdapter$GroupViewHolder(this, android.view.LayoutInflater.from(p5.getContext()).inflate(2131361877, p5, 0), 0);
        }
    }

    public void setListData(com.boat.support.slam.entity.floors.MapList p9)
    {
        this.listData.clear();
        if (p9 != null) {
            android.util.Log.d("RvFloorMapListAdapter", new StringBuilder().append("setListData: groups.size ").append(p9.getFloors().size()).toString());
            this.defFloorId = p9.getDefaultFloor();
            this.listData.addAll(p9.getFloors());
            java.util.Iterator v0_6 = p9.getFloors().iterator();
            while (v0_6.hasNext()) {
                com.boat.support.slam.entity.floors.Floors v1_5 = ((com.boat.support.slam.entity.floors.Floors) v0_6.next());
                if (v1_5.getFloorId() == this.defFloorId) {
                    this.currentExpandedFloorId = this.defFloorId;
                    java.util.Iterator v0_10 = v1_5.getMaps().iterator();
                    while (v0_10.hasNext()) {
                        com.boat.support.slam.entity.floors.Maps v2_4 = ((com.boat.support.slam.entity.floors.Maps) v0_10.next());
                        if (v2_4.getMapId() == v1_5.getDefaultmap()) {
                            this.currentDefaultMapId = v2_4.getMapId();
                            break;
                        }
                    }
                }
            }
        }
        this.notifyDataSetChanged();
        return;
    }

    public void setOnclickItem(com.jlboat.phone.adapter.RvFloorMapListAdapter$OnClick p1)
    {
        this.onclick = p1;
        return;
    }
}
