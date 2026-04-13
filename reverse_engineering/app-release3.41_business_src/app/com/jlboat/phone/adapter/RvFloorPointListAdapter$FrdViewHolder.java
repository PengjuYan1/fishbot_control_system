package com.jlboat.phone.adapter;
 class RvFloorPointListAdapter$FrdViewHolder extends android.support.v7.widget.RecyclerView$ViewHolder {
    final synthetic com.jlboat.phone.adapter.RvFloorPointListAdapter this$0;
    private android.widget.TextView tv_name;

    private RvFloorPointListAdapter$FrdViewHolder(com.jlboat.phone.adapter.RvFloorPointListAdapter p1, android.view.View p2)
    {
        this.this$0 = p1;
        super(p2);
        super.tv_name = ((android.widget.TextView) p2.findViewById(2131231338));
        return;
    }

    synthetic RvFloorPointListAdapter$FrdViewHolder(com.jlboat.phone.adapter.RvFloorPointListAdapter p1, android.view.View p2, com.jlboat.phone.adapter.RvFloorPointListAdapter$1 p3)
    {
        this(p1, p2);
        return;
    }

    static synthetic void access$200(com.jlboat.phone.adapter.RvFloorPointListAdapter$FrdViewHolder p0, com.boat.support.slam.entity.floors.Points p1, com.boat.support.slam.entity.floors.Floors p2)
    {
        p0.setData(p1, p2);
        return;
    }

    private void setData(com.boat.support.slam.entity.floors.Points p4, com.boat.support.slam.entity.floors.Floors p5)
    {
        this.tv_name.setText(p4.getPointName());
        this.tv_name.setTextColor(com.jlboat.phone.adapter.RvFloorPointListAdapter.access$400(this.this$0).getResources().getColor(2131034165));
        this.itemView.setOnClickListener(new com.jlboat.phone.adapter.RvFloorPointListAdapter$FrdViewHolder$1(this, p5, p4));
        this.itemView.setOnLongClickListener(new com.jlboat.phone.adapter.RvFloorPointListAdapter$FrdViewHolder$2(this, p5, p4));
        return;
    }
}
