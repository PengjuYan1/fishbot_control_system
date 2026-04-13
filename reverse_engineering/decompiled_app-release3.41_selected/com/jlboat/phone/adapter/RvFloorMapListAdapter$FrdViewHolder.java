package com.jlboat.phone.adapter;
 class RvFloorMapListAdapter$FrdViewHolder extends android.support.v7.widget.RecyclerView$ViewHolder {
    final synthetic com.jlboat.phone.adapter.RvFloorMapListAdapter this$0;
    private android.widget.TextView tv_name;

    private RvFloorMapListAdapter$FrdViewHolder(com.jlboat.phone.adapter.RvFloorMapListAdapter p1, android.view.View p2)
    {
        this.this$0 = p1;
        super(p2);
        super.tv_name = ((android.widget.TextView) p2.findViewById(2131231338));
        return;
    }

    synthetic RvFloorMapListAdapter$FrdViewHolder(com.jlboat.phone.adapter.RvFloorMapListAdapter p1, android.view.View p2, com.jlboat.phone.adapter.RvFloorMapListAdapter$1 p3)
    {
        this(p1, p2);
        return;
    }

    static synthetic void access$200(com.jlboat.phone.adapter.RvFloorMapListAdapter$FrdViewHolder p0, com.boat.support.slam.entity.floors.Maps p1, com.boat.support.slam.entity.floors.Floors p2)
    {
        p0.setData(p1, p2);
        return;
    }

    private void setData(com.boat.support.slam.entity.floors.Maps p9, com.boat.support.slam.entity.floors.Floors p10)
    {
        int v2_0;
        this.tv_name.setText(p9.getMapName());
        int v0_1 = 1;
        if ((p10 == null) || (p9.getMapId() != p10.getDefaultmap())) {
            v2_0 = 0;
        } else {
            v2_0 = 1;
        }
        if ((p10 == null) || (p10.getFloorId() != com.jlboat.phone.adapter.RvFloorMapListAdapter.access$600(this.this$0))) {
            v0_1 = 0;
        }
        int v1_4;
        if (v2_0 == 0) {
            v1_4 = com.jlboat.phone.adapter.RvFloorMapListAdapter.access$700(this.this$0).getResources().getColor(2131034182);
        } else {
            if (v0_1 == 0) {
                v1_4 = com.jlboat.phone.adapter.RvFloorMapListAdapter.access$700(this.this$0).getResources().getColor(2131034163);
            } else {
                v1_4 = com.jlboat.phone.adapter.RvFloorMapListAdapter.access$700(this.this$0).getResources().getColor(2131034165);
            }
        }
        this.tv_name.setTextColor(v1_4);
        this.itemView.setOnClickListener(new com.jlboat.phone.adapter.RvFloorMapListAdapter$FrdViewHolder$1(this, p10, p9));
        this.itemView.setOnLongClickListener(new com.jlboat.phone.adapter.RvFloorMapListAdapter$FrdViewHolder$2(this, p10, p9));
        return;
    }
}
