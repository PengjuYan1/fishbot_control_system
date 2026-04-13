package com.jlboat.phone.adapter;
public class NavPointListAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private com.jlboat.phone.adapter.NavPointListAdapter$OnItemClickListener mItemClickListener;
    private java.util.List mPointList;
    private com.boat.support.slam.entity.floors.Points point;

    public NavPointListAdapter()
    {
        this.mPointList = new java.util.ArrayList();
        return;
    }

    static synthetic com.jlboat.phone.adapter.NavPointListAdapter$OnItemClickListener access$000(com.jlboat.phone.adapter.NavPointListAdapter p1)
    {
        return p1.mItemClickListener;
    }

    public int getItemCount()
    {
        return this.mPointList.size();
    }

    public int getItemViewType(int p1)
    {
        return p1;
    }

    public bridge synthetic void onBindViewHolder(android.support.v7.widget.RecyclerView$ViewHolder p1, int p2)
    {
        this.onBindViewHolder(((com.jlboat.phone.adapter.NavPointListAdapter$MyHolder) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.adapter.NavPointListAdapter$MyHolder p4, int p5)
    {
        this.point = ((com.boat.support.slam.entity.floors.Points) this.mPointList.get(p5));
        if (!this.point.getPointName().trim().equals("")) {
            p4.tv.setText(this.point.getPointName());
        } else {
            p4.tv.setText(new StringBuilder().append("\u672a\u547d\u540d\u5bfc\u822a\u70b9").append(p5).toString());
        }
        p4.itemView.setOnClickListener(new com.jlboat.phone.adapter.NavPointListAdapter$1(this, p5));
        return;
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.adapter.NavPointListAdapter$MyHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.NavPointListAdapter$MyHolder(this, android.view.LayoutInflater.from(p4.getContext()).inflate(2131361903, p4, 0));
    }

    public void setData(java.util.List p1)
    {
        this.mPointList = p1;
        this.notifyDataSetChanged();
        return;
    }

    public void setOnItemClickListener(com.jlboat.phone.adapter.NavPointListAdapter$OnItemClickListener p1)
    {
        this.mItemClickListener = p1;
        return;
    }
}
