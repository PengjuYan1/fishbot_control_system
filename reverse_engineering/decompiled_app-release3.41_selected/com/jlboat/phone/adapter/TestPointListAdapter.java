package com.jlboat.phone.adapter;
public class TestPointListAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private java.util.List mCheckPointList;
    private com.jlboat.phone.adapter.TestPointListAdapter$OnItemClickListener mItemClickListener;
    private java.util.List mPointList;
    private String pointName;

    public TestPointListAdapter()
    {
        this.mPointList = new java.util.ArrayList();
        this.mCheckPointList = new java.util.ArrayList();
        return;
    }

    static synthetic com.jlboat.phone.adapter.TestPointListAdapter$OnItemClickListener access$000(com.jlboat.phone.adapter.TestPointListAdapter p1)
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
        this.onBindViewHolder(((com.jlboat.phone.adapter.TestPointListAdapter$MyHolder) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.adapter.TestPointListAdapter$MyHolder p4, int p5)
    {
        this.pointName = ((com.boat.support.slam.entity.floors.Points) this.mPointList.get(p5)).getPointName();
        if (!this.pointName.trim().equals("")) {
            p4.tv.setText(this.pointName);
        } else {
            p4.tv.setText(new StringBuilder().append("\u672a\u547d\u540d\u5bfc\u822a\u70b9").append(p5).toString());
        }
        if (!this.mCheckPointList.contains(this.mPointList.get(p5))) {
            p4.iv.setBackgroundResource(2131427383);
            p4.tv.setTextColor(android.graphics.Color.parseColor("#1296db"));
        } else {
            p4.iv.setBackgroundResource(2131427338);
            p4.tv.setTextColor(android.graphics.Color.parseColor("#f00f61"));
        }
        p4.itemView.setOnClickListener(new com.jlboat.phone.adapter.TestPointListAdapter$1(this, p5));
        return;
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.adapter.TestPointListAdapter$MyHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.TestPointListAdapter$MyHolder(this, android.view.LayoutInflater.from(p4.getContext()).inflate(2131361905, p4, 0));
    }

    public void setData(java.util.List p1, java.util.List p2)
    {
        this.mPointList = p1;
        this.mCheckPointList = p2;
        this.notifyDataSetChanged();
        return;
    }

    public void setOnItemClickListener(com.jlboat.phone.adapter.TestPointListAdapter$OnItemClickListener p1)
    {
        this.mItemClickListener = p1;
        return;
    }
}
