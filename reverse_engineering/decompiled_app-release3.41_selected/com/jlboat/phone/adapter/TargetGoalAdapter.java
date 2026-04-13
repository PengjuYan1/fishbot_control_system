package com.jlboat.phone.adapter;
public class TargetGoalAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private android.content.Context mContext;
    private java.util.List mList;
    private com.jlboat.phone.message.map_msgs.TargetGoalEntry navi;
    private com.jlboat.phone.adapter.TargetGoalAdapter$OnItemDeleteListener onItemDeleteListener;
    private com.jlboat.phone.message.map_msgs.CargoAtoBEntry point;

    public TargetGoalAdapter(android.content.Context p2)
    {
        this.mList = 0;
        this.mContext = p2;
        return;
    }

    static synthetic com.jlboat.phone.adapter.TargetGoalAdapter$OnItemDeleteListener access$000(com.jlboat.phone.adapter.TargetGoalAdapter p1)
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
        this.onBindViewHolder(((com.jlboat.phone.adapter.TargetGoalAdapter$MyResHolder) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.adapter.TargetGoalAdapter$MyResHolder p4, int p5)
    {
        if (p5 == (this.mList.size() - 1)) {
            p4.line.setVisibility(8);
        }
        this.navi = ((com.jlboat.phone.message.map_msgs.TargetGoalEntry) this.mList.get(p5));
        p4.floorsTv.setText(this.navi.getFloorName());
        p4.nameTv.setText(this.navi.getPointName());
        p4.notesTv.setText(this.navi.getNotes());
        switch (this.navi.status) {
            case 0:
                p4.stateTv.setText("\u672a\u8fd0\u884c");
                p4.stateTv.setTextColor(this.mContext.getResources().getColor(2131034214));
                break;
            case 1:
                p4.stateTv.setText("\u8fd0\u884c\u4e2d");
                p4.stateTv.setTextColor(this.mContext.getResources().getColor(2131034214));
                break;
            case 2:
                p4.stateTv.setText("\u8fd0\u884c\u7ed3\u675f");
                p4.stateTv.setTextColor(this.mContext.getResources().getColor(2131034214));
                break;
            case 3:
                p4.stateTv.setText("\u9876\u8fd0\u884c\u4e2d");
                p4.stateTv.setTextColor(this.mContext.getResources().getColor(2131034214));
                break;
            case 4:
                p4.stateTv.setText("\u653e\u8fd0\u884c\u4e2d");
                p4.stateTv.setTextColor(this.mContext.getResources().getColor(2131034214));
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            default:
                p4.stateTv.setText("\u8fd0\u884c\u5f02\u5e38");
                p4.stateTv.setTextColor(this.mContext.getResources().getColor(2131034149));
                break;
            case 10:
                p4.stateTv.setText("\u8fd0\u884c\u5931\u8d25");
                p4.stateTv.setTextColor(this.mContext.getResources().getColor(2131034214));
                break;
        }
        switch (this.navi.getType()) {
            case 0:
                p4.typeTv.setText("\u5bfc\u822a\u70b9");
                break;
            default:
        }
        return;
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.adapter.TargetGoalAdapter$MyResHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.TargetGoalAdapter$MyResHolder(this, android.view.LayoutInflater.from(p4.getContext()).inflate(2131361938, p4, 0));
    }

    public void setData(java.util.List p1)
    {
        this.mList = p1;
        this.notifyDataSetChanged();
        return;
    }

    public void setOnItemDeleteListener(com.jlboat.phone.adapter.TargetGoalAdapter$OnItemDeleteListener p1)
    {
        this.onItemDeleteListener = p1;
        return;
    }
}
