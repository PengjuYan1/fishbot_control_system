package com.jlboat.phone.adapter;
public class BindPointListAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private com.jlboat.phone.adapter.BindPointListAdapter$OnItemClickListener mItemClickListener;
    private java.util.List mNavPoints;
    private java.util.List mPointList;
    private com.boat.support.slam.entity.floors.AddPoints point;
    private String str;

    public BindPointListAdapter()
    {
        this.mPointList = new java.util.ArrayList();
        this.mNavPoints = new java.util.ArrayList();
        return;
    }

    static synthetic com.jlboat.phone.adapter.BindPointListAdapter$OnItemClickListener access$000(com.jlboat.phone.adapter.BindPointListAdapter p1)
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
        this.onBindViewHolder(((com.jlboat.phone.adapter.BindPointListAdapter$MyHolder) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.adapter.BindPointListAdapter$MyHolder p8, int p9)
    {
        this.point = ((com.boat.support.slam.entity.floors.AddPoints) this.mPointList.get(p9));
        this.str = "";
        android.view.View v0_9 = this.mNavPoints.iterator();
        while (v0_9.hasNext()) {
            com.jlboat.phone.adapter.BindPointListAdapter$1 v1_8 = ((com.boat.support.slam.entity.floors.Points) v0_9.next());
            if (this.point.getX() == v1_8.getPointId()) {
                this.str = new StringBuilder().append(v1_8.getPointName()).append(" -> ").toString();
            }
        }
        android.view.View v0_2 = this.mNavPoints.iterator();
        while (v0_2.hasNext()) {
            com.jlboat.phone.adapter.BindPointListAdapter$1 v1_6 = ((com.boat.support.slam.entity.floors.Points) v0_2.next());
            if (this.point.getY() == v1_6.getPointId()) {
                this.str = new StringBuilder().append(this.str).append(v1_6.getPointName()).toString();
            }
        }
        p8.tv.setText(this.str);
        p8.itemView.setOnClickListener(new com.jlboat.phone.adapter.BindPointListAdapter$1(this, p9, p8));
        return;
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.adapter.BindPointListAdapter$MyHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.BindPointListAdapter$MyHolder(this, android.view.LayoutInflater.from(p4.getContext()).inflate(2131361928, p4, 0));
    }

    public void setData(java.util.List p1, java.util.List p2)
    {
        this.mPointList = p1;
        this.mNavPoints = p2;
        this.notifyDataSetChanged();
        return;
    }

    public void setOnItemClickListener(com.jlboat.phone.adapter.BindPointListAdapter$OnItemClickListener p1)
    {
        this.mItemClickListener = p1;
        return;
    }
}
