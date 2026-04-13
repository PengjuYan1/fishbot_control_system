package com.jlboat.phone.adapter;
 class RvFloorPointListAdapter$GroupViewHolder extends android.support.v7.widget.RecyclerView$ViewHolder implements android.view.View$OnClickListener {
    private com.boat.support.slam.entity.floors.Floors group;
    final synthetic com.jlboat.phone.adapter.RvFloorPointListAdapter this$0;
    private android.widget.TextView tv_count;
    private android.widget.TextView tv_name;

    private RvFloorPointListAdapter$GroupViewHolder(com.jlboat.phone.adapter.RvFloorPointListAdapter p1, android.view.View p2)
    {
        this.this$0 = p1;
        super(p2);
        super.tv_name = ((android.widget.TextView) p2.findViewById(2131231338));
        super.tv_count = ((android.widget.TextView) p2.findViewById(2131231327));
        p2.setOnClickListener(super);
        return;
    }

    synthetic RvFloorPointListAdapter$GroupViewHolder(com.jlboat.phone.adapter.RvFloorPointListAdapter p1, android.view.View p2, com.jlboat.phone.adapter.RvFloorPointListAdapter$1 p3)
    {
        this(p1, p2);
        return;
    }

    public void onClick(android.view.View p7)
    {
        java.util.List v0_1 = com.jlboat.phone.adapter.RvFloorPointListAdapter.access$500(this.this$0, this.group);
        if ((v0_1 != null) && (!v0_1.isEmpty())) {
            int v2 = (this.getAdapterPosition() + 1);
            boolean v3 = 0;
            if (v2 < com.jlboat.phone.adapter.RvFloorPointListAdapter.access$600(this.this$0).size()) {
                v3 = (com.jlboat.phone.adapter.RvFloorPointListAdapter.access$600(this.this$0).get(v2) instanceof com.boat.support.slam.entity.floors.Points);
            }
            if (v3) {
                int v4_6 = 0;
                while (v4_6 < v0_1.size()) {
                    if ((v2 < com.jlboat.phone.adapter.RvFloorPointListAdapter.access$600(this.this$0).size()) && ((com.jlboat.phone.adapter.RvFloorPointListAdapter.access$600(this.this$0).get(v2) instanceof com.boat.support.slam.entity.floors.Points))) {
                        com.jlboat.phone.adapter.RvFloorPointListAdapter.access$600(this.this$0).remove(v2);
                    }
                    v4_6++;
                }
                this.this$0.notifyItemRangeRemoved(v2, v0_1.size());
            } else {
                com.jlboat.phone.adapter.RvFloorPointListAdapter.access$600(this.this$0).addAll(v2, v0_1);
                this.this$0.notifyItemRangeInserted(v2, v0_1.size());
            }
            return;
        } else {
            return;
        }
    }

    public void setData(com.boat.support.slam.entity.floors.Floors p8)
    {
        this.group = p8;
        this.tv_name.setText(p8.getFloorName());
        android.widget.TextView v0_9 = p8.getMaps().iterator();
        while (v0_9.hasNext()) {
            int v1_2 = ((com.boat.support.slam.entity.floors.Maps) v0_9.next());
            if (v1_2.getMapId() == p8.getDefaultmap()) {
                this.tv_count.setText(v1_2.getMapName());
                break;
            }
        }
        if (com.jlboat.phone.adapter.RvFloorPointListAdapter.access$300(this.this$0) != p8.getFloorId()) {
            this.tv_name.setTextColor(com.jlboat.phone.adapter.RvFloorPointListAdapter.access$400(this.this$0).getResources().getColor(2131034182));
            this.tv_count.setTextColor(com.jlboat.phone.adapter.RvFloorPointListAdapter.access$400(this.this$0).getResources().getColor(2131034182));
        } else {
            this.tv_name.setTextColor(com.jlboat.phone.adapter.RvFloorPointListAdapter.access$400(this.this$0).getResources().getColor(2131034165));
            this.tv_count.setTextColor(com.jlboat.phone.adapter.RvFloorPointListAdapter.access$400(this.this$0).getResources().getColor(2131034165));
        }
        return;
    }
}
