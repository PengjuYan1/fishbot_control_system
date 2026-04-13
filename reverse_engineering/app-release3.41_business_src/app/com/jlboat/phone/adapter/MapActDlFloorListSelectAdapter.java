package com.jlboat.phone.adapter;
public class MapActDlFloorListSelectAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    String TAG;
    private com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter$OnItemClickListener mItemClickListener;
    private java.util.List mPointsList;
    private String pointName;

    public MapActDlFloorListSelectAdapter()
    {
        this.TAG = this.getClass().getSimpleName();
        return;
    }

    static synthetic com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter$OnItemClickListener access$100(com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter p1)
    {
        return p1.mItemClickListener;
    }

    public int getItemCount()
    {
        return this.mPointsList.size();
    }

    public int getItemViewType(int p1)
    {
        return p1;
    }

    public bridge synthetic void onBindViewHolder(android.support.v7.widget.RecyclerView$ViewHolder p1, int p2)
    {
        this.onBindViewHolder(((com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter$MyHolder) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter$MyHolder p4, int p5)
    {
        this.pointName = ((com.boat.support.slam.entity.floors.Floors) this.mPointsList.get(p5)).getFloorName();
        if (!this.pointName.trim().equals("")) {
            com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter$MyHolder.access$000(p4).setText(this.pointName);
        } else {
            com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter$MyHolder.access$000(p4).setText(new StringBuilder().append("\u672a\u547d\u540d\u5bfc\u822a\u70b9").append(p5).toString());
        }
        p4.itemView.setOnClickListener(new com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter$1(this, p5));
        return;
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter$MyHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter$MyHolder(this, android.view.LayoutInflater.from(p4.getContext()).inflate(2131361845, p4, 0));
    }

    public void setData(java.util.List p1)
    {
        this.mPointsList = p1;
        this.notifyDataSetChanged();
        return;
    }

    public void setOnItemClickListener(com.jlboat.phone.adapter.MapActDlFloorListSelectAdapter$OnItemClickListener p1)
    {
        this.mItemClickListener = p1;
        return;
    }
}
