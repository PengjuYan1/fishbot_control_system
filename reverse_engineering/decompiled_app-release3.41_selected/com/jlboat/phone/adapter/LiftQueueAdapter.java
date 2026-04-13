package com.jlboat.phone.adapter;
public class LiftQueueAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private android.content.Context mContext;
    private java.util.List mList;
    private com.jlboat.phone.message.map_msgs.NaviQueueListEntry navi;
    private com.jlboat.phone.adapter.LiftQueueAdapter$OnItemDeleteListener onItemDeleteListener;
    private com.jlboat.phone.message.map_msgs.CargoAtoBEntry point;

    public LiftQueueAdapter(android.content.Context p2)
    {
        this.mList = 0;
        this.mContext = p2;
        return;
    }

    static synthetic com.jlboat.phone.adapter.LiftQueueAdapter$OnItemDeleteListener access$000(com.jlboat.phone.adapter.LiftQueueAdapter p1)
    {
        return p1.onItemDeleteListener;
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
        this.onBindViewHolder(((com.jlboat.phone.adapter.LiftQueueAdapter$MyResHolder) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.adapter.LiftQueueAdapter$MyResHolder p5, int p6)
    {
        if (p6 == (this.mList.size() - 1)) {
            p5.line.setVisibility(8);
        }
        this.navi = ((com.jlboat.phone.message.map_msgs.NaviQueueListEntry) this.mList.get(p6));
        p5.floorsTv.setText(this.navi.getCargoAtoBEntry().getFloor_name());
        p5.nameTv.setText(this.navi.getCargoAtoBEntry().point_name);
        p5.bindFloorsTv.setText(this.navi.getCargoAtoBEntry().getBind_floor_name());
        p5.notesTv.setText(this.navi.getNotes());
        p5.bindNameTv.setText(this.navi.getCargoAtoBEntry().getBind_point_name());
        switch (this.navi.status) {
            case 0:
                p5.stateTv.setText("\u672a\u8fd0\u884c");
                p5.stateTv.setTextColor(this.mContext.getResources().getColor(2131034214));
                break;
            case 1:
                p5.stateTv.setText("\u8fd0\u884c\u4e2d");
                p5.stateTv.setTextColor(this.mContext.getResources().getColor(2131034214));
                break;
            case 2:
                p5.stateTv.setText("\u8fd0\u884c\u7ed3\u675f");
                p5.stateTv.setTextColor(this.mContext.getResources().getColor(2131034214));
                break;
            default:
                p5.stateTv.setText("\u8fd0\u884c\u5f02\u5e38");
                p5.stateTv.setTextColor(this.mContext.getResources().getColor(2131034149));
        }
        if (this.navi.getType() == 1) {
            switch (this.navi.getType()) {
                case 1:
                    p5.typeTv.setText("\u9876\u5347\u70b9");
                    break;
                default:
            }
        }
        return;
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.adapter.LiftQueueAdapter$MyResHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.LiftQueueAdapter$MyResHolder(this, android.view.LayoutInflater.from(p4.getContext()).inflate(2131361884, p4, 0));
    }

    public void setData(java.util.List p1)
    {
        this.mList = p1;
        this.notifyDataSetChanged();
        return;
    }

    public void setOnItemDeleteListener(com.jlboat.phone.adapter.LiftQueueAdapter$OnItemDeleteListener p1)
    {
        this.onItemDeleteListener = p1;
        return;
    }
}
