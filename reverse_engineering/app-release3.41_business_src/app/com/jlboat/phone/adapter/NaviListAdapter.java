package com.jlboat.phone.adapter;
public class NaviListAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private android.content.Context context;
    private com.jlboat.phone.adapter.NaviListAdapter$OnClick onLongClick;
    private java.util.List pointsList;

    public NaviListAdapter(android.content.Context p2)
    {
        this.pointsList = new java.util.ArrayList();
        this.context = p2;
        return;
    }

    static synthetic com.jlboat.phone.adapter.NaviListAdapter$OnClick access$100(com.jlboat.phone.adapter.NaviListAdapter p1)
    {
        return p1.onLongClick;
    }

    public int getItemCount()
    {
        int v0_2;
        if (this.pointsList != null) {
            v0_2 = this.pointsList.size();
        } else {
            v0_2 = 0;
        }
        return v0_2;
    }

    public bridge synthetic void onBindViewHolder(android.support.v7.widget.RecyclerView$ViewHolder p1, int p2)
    {
        this.onBindViewHolder(((com.jlboat.phone.adapter.NaviListAdapter$MapViewHolder) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.adapter.NaviListAdapter$MapViewHolder p5, int p6)
    {
        Integer v1_4;
        android.widget.RelativeLayout v0_0 = com.jlboat.phone.adapter.NaviListAdapter$MapViewHolder.access$000(p5);
        if (!((com.boat.support.slam.entity.floors.Points) this.pointsList.get(p6)).getPointName().equals(com.jlboat.phone.application.BoatSlamApplication.CANCLEPOINTNAME)) {
            v1_4 = ((com.boat.support.slam.entity.floors.Points) this.pointsList.get(p6)).getPointName();
        } else {
            v1_4 = new StringBuilder().append(((com.boat.support.slam.entity.floors.Points) this.pointsList.get(p6)).getPointId()).append("").toString();
        }
        v0_0.setText(v1_4);
        p5.rl_bn.setTag(Integer.valueOf(p6));
        return;
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.adapter.NaviListAdapter$MapViewHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.NaviListAdapter$MapViewHolder(this, android.view.LayoutInflater.from(p4.getContext()).inflate(2131361882, p4, 0));
    }

    public void setListData(java.util.List p1)
    {
        this.pointsList = p1;
        this.notifyDataSetChanged();
        return;
    }

    public void setOnLingclickItem(com.jlboat.phone.adapter.NaviListAdapter$OnClick p1)
    {
        this.onLongClick = p1;
        return;
    }
}
