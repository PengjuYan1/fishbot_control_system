package com.jlboat.phone.adapter;
 class RvFloorMapListAdapter$GroupViewHolder extends android.support.v7.widget.RecyclerView$ViewHolder implements android.view.View$OnClickListener {
    private com.boat.support.slam.entity.floors.Floors group;
    final synthetic com.jlboat.phone.adapter.RvFloorMapListAdapter this$0;
    private android.widget.TextView tv_count;
    private android.widget.TextView tv_name;

    private RvFloorMapListAdapter$GroupViewHolder(com.jlboat.phone.adapter.RvFloorMapListAdapter p2, android.view.View p3)
    {
        this.this$0 = p2;
        super(p3);
        super.tv_name = ((android.widget.TextView) p3.findViewById(2131231338));
        super.tv_count = ((android.widget.TextView) p3.findViewById(2131231327));
        p3.setOnClickListener(super);
        p3.setOnLongClickListener(new com.jlboat.phone.adapter.RvFloorMapListAdapter$GroupViewHolder$1(super, p2));
        return;
    }

    synthetic RvFloorMapListAdapter$GroupViewHolder(com.jlboat.phone.adapter.RvFloorMapListAdapter p1, android.view.View p2, com.jlboat.phone.adapter.RvFloorMapListAdapter$1 p3)
    {
        this(p1, p2);
        return;
    }

    static synthetic com.boat.support.slam.entity.floors.Floors access$400(com.jlboat.phone.adapter.RvFloorMapListAdapter$GroupViewHolder p1)
    {
        return p1.group;
    }

    public void onClick(android.view.View p11)
    {
        java.util.List v0_1 = this.group.getMaps();
        if (!v0_1.isEmpty()) {
            int v2 = 1;
            int v1_2 = (this.getAdapterPosition() + 1);
            if ((v1_2 >= com.jlboat.phone.adapter.RvFloorMapListAdapter.access$800(this.this$0).size()) || (this.this$0.getItemViewType(v1_2) != com.jlboat.phone.adapter.RvFloorMapListAdapter.access$900(this.this$0))) {
                v2 = 0;
            }
            if (v2 != 0) {
                com.jlboat.phone.adapter.RvFloorMapListAdapter.access$502(this.this$0, -1);
                com.jlboat.phone.adapter.RvFloorMapListAdapter.access$1002(this.this$0, -1);
                com.jlboat.phone.adapter.RvFloorMapListAdapter v3_7 = 0;
                while (v3_7 < v0_1.size()) {
                    com.jlboat.phone.adapter.RvFloorMapListAdapter.access$800(this.this$0).remove(v1_2);
                    v3_7++;
                }
                this.this$0.notifyItemRangeRemoved(v1_2, v0_1.size());
            } else {
                com.jlboat.phone.adapter.RvFloorMapListAdapter.access$502(this.this$0, this.group.getFloorId());
                com.jlboat.phone.adapter.RvFloorMapListAdapter v3_10 = v0_1.iterator();
                while (v3_10.hasNext()) {
                    int v4_11 = ((com.boat.support.slam.entity.floors.Maps) v3_10.next());
                    if (v4_11.getMapId() == this.group.getDefaultmap()) {
                        com.jlboat.phone.adapter.RvFloorMapListAdapter.access$1002(this.this$0, v4_11.getMapId());
                        break;
                    }
                }
                com.jlboat.phone.adapter.RvFloorMapListAdapter.access$800(this.this$0).addAll(v1_2, v0_1);
                this.this$0.notifyItemRangeInserted(v1_2, v0_1.size());
            }
            return;
        } else {
            return;
        }
    }

    public void setData(com.boat.support.slam.entity.floors.Floors p6)
    {
        this.group = p6;
        this.tv_name.setText(p6.getFloorName());
        this.tv_count.setText(String.valueOf(p6.getMaps().size()));
        if ((p6.getFloorId() != com.jlboat.phone.adapter.RvFloorMapListAdapter.access$500(this.this$0)) && (p6.getFloorId() != com.jlboat.phone.adapter.RvFloorMapListAdapter.access$600(this.this$0))) {
            this.tv_name.setTextColor(com.jlboat.phone.adapter.RvFloorMapListAdapter.access$700(this.this$0).getResources().getColor(2131034182));
            this.tv_count.setTextColor(com.jlboat.phone.adapter.RvFloorMapListAdapter.access$700(this.this$0).getResources().getColor(2131034182));
        } else {
            this.tv_name.setTextColor(com.jlboat.phone.adapter.RvFloorMapListAdapter.access$700(this.this$0).getResources().getColor(2131034165));
            this.tv_count.setTextColor(com.jlboat.phone.adapter.RvFloorMapListAdapter.access$700(this.this$0).getResources().getColor(2131034165));
        }
        return;
    }
}
