package com.jlboat.phone.adapter;
public class NewBindPointListAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private com.boat.support.slam.entity.floors.Points end;
    private com.jlboat.phone.adapter.NewBindPointListAdapter$OnItemClickListener mItemClickListener;
    private java.util.List mPointList;
    private com.boat.support.slam.entity.floors.Points start;
    private java.util.Map stringPointsMap;

    public NewBindPointListAdapter()
    {
        this.mPointList = new java.util.ArrayList();
        return;
    }

    static synthetic com.jlboat.phone.adapter.NewBindPointListAdapter$OnItemClickListener access$000(com.jlboat.phone.adapter.NewBindPointListAdapter p1)
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
        this.onBindViewHolder(((com.jlboat.phone.adapter.NewBindPointListAdapter$MyHolder) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.adapter.NewBindPointListAdapter$MyHolder p5, int p6)
    {
        this.stringPointsMap = ((java.util.Map) this.mPointList.get(p6));
        if ((!this.stringPointsMap.containsKey("start")) || (this.stringPointsMap.containsKey("end"))) {
            if ((this.stringPointsMap.containsKey("start")) && (this.stringPointsMap.containsKey("end"))) {
                this.start = ((com.boat.support.slam.entity.floors.Points) this.stringPointsMap.get("start"));
                this.end = ((com.boat.support.slam.entity.floors.Points) this.stringPointsMap.get("end"));
                p5.tv.setText(new StringBuilder().append(this.start.getPointName()).append(" -> ").append(this.end.getPointName()).toString());
            }
        } else {
            this.start = ((com.boat.support.slam.entity.floors.Points) this.stringPointsMap.get("start"));
            p5.tv.setText(new StringBuilder().append(this.start.getPointName()).append(" -> ").toString());
        }
        p5.itemView.setOnClickListener(new com.jlboat.phone.adapter.NewBindPointListAdapter$1(this, p6));
        return;
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.adapter.NewBindPointListAdapter$MyHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.NewBindPointListAdapter$MyHolder(this, android.view.LayoutInflater.from(p4.getContext()).inflate(2131361928, p4, 0));
    }

    public void setData(java.util.List p1)
    {
        this.mPointList = p1;
        this.notifyDataSetChanged();
        return;
    }

    public void setOnItemClickListener(com.jlboat.phone.adapter.NewBindPointListAdapter$OnItemClickListener p1)
    {
        this.mItemClickListener = p1;
        return;
    }
}
