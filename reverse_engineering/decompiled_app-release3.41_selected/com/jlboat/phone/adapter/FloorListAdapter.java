package com.jlboat.phone.adapter;
public class FloorListAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private android.content.Context context;
    private java.util.List floorsList;
    private com.jlboat.phone.adapter.FloorListAdapter$OnMultiSelectListener onMultiSelectListener;
    private java.util.Set selectedPositions;

    public FloorListAdapter(android.content.Context p2)
    {
        this.floorsList = new java.util.ArrayList();
        this.selectedPositions = new java.util.HashSet();
        this.context = p2;
        return;
    }

    private java.util.List getSelectedFloors()
    {
        java.util.ArrayList v0_1 = new java.util.ArrayList();
        java.util.Iterator v1_1 = this.selectedPositions.iterator();
        while (v1_1.hasNext()) {
            int v2_2 = ((Integer) v1_1.next()).intValue();
            if (v2_2 < this.floorsList.size()) {
                v0_1.add(((Integer) this.floorsList.get(v2_2)));
            }
        }
        return v0_1;
    }

    static synthetic boolean lambda$onBindViewHolder$1(android.view.View p1)
    {
        return 1;
    }

    private void toggleSelection(int p3)
    {
        if (!this.selectedPositions.contains(Integer.valueOf(p3))) {
            this.selectedPositions.add(Integer.valueOf(p3));
        } else {
            this.selectedPositions.remove(Integer.valueOf(p3));
        }
        this.notifyItemChanged(p3);
        return;
    }

    public int getItemCount()
    {
        int v0_2;
        if (this.floorsList != null) {
            v0_2 = this.floorsList.size();
        } else {
            v0_2 = 0;
        }
        return v0_2;
    }

    synthetic void lambda$onBindViewHolder$0$com-jlboat-phone-adapter-FloorListAdapter(int p3, android.view.View p4)
    {
        this.toggleSelection(p3);
        if (this.onMultiSelectListener != null) {
            this.onMultiSelectListener.onSelectionChanged(this.getSelectedFloors());
        }
        return;
    }

    public bridge synthetic void onBindViewHolder(android.support.v7.widget.RecyclerView$ViewHolder p1, int p2)
    {
        this.onBindViewHolder(((com.jlboat.phone.adapter.FloorListAdapter$MapViewHolder) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.adapter.FloorListAdapter$MapViewHolder p6, int p7)
    {
        p6.floorTv.setText(String.valueOf(((Integer) this.floorsList.get(p7)).intValue()));
        if (!this.selectedPositions.contains(Integer.valueOf(p7))) {
            p6.rl_bn.setBackgroundColor(this.context.getResources().getColor(2131034240));
            p6.floorTv.setTextColor(this.context.getResources().getColor(2131034147));
        } else {
            p6.rl_bn.setBackgroundColor(this.context.getResources().getColor(2131034221));
            p6.floorTv.setTextColor(this.context.getResources().getColor(2131034240));
        }
        p6.rl_bn.setOnClickListener(new com.jlboat.phone.adapter.FloorListAdapter$$ExternalSyntheticLambda0(this, p7));
        p6.rl_bn.setOnLongClickListener(new com.jlboat.phone.adapter.FloorListAdapter$$ExternalSyntheticLambda1());
        return;
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.adapter.FloorListAdapter$MapViewHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.FloorListAdapter$MapViewHolder(this, android.view.LayoutInflater.from(this.context).inflate(2131361882, p4, 0));
    }

    public void setListData(java.util.List p1)
    {
        this.floorsList = p1;
        this.notifyDataSetChanged();
        return;
    }

    public void setOnMultiSelectListener(com.jlboat.phone.adapter.FloorListAdapter$OnMultiSelectListener p1)
    {
        this.onMultiSelectListener = p1;
        return;
    }
}
