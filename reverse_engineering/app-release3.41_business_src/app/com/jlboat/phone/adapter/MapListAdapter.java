package com.jlboat.phone.adapter;
public class MapListAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private android.content.Context context;
    long currentMapId;
    private String displayString;
    private java.util.List mapsList;
    private com.jlboat.phone.adapter.MapListAdapter$OnClick onclick;

    public MapListAdapter(android.content.Context p3)
    {
        this.mapsList = new java.util.ArrayList();
        this.currentMapId = 0;
        this.context = p3;
        return;
    }

    static synthetic com.jlboat.phone.adapter.MapListAdapter$OnClick access$200(com.jlboat.phone.adapter.MapListAdapter p1)
    {
        return p1.onclick;
    }

    public int getItemCount()
    {
        int v0_2;
        if (this.mapsList != null) {
            v0_2 = this.mapsList.size();
        } else {
            v0_2 = 0;
        }
        return v0_2;
    }

    public bridge synthetic void onBindViewHolder(android.support.v7.widget.RecyclerView$ViewHolder p1, int p2)
    {
        this.onBindViewHolder(((com.jlboat.phone.adapter.MapListAdapter$MapViewHolder) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.adapter.MapListAdapter$MapViewHolder p8, int p9)
    {
        p8.rl_bn.setTag(Integer.valueOf(p9));
        com.jlboat.phone.adapter.MapListAdapter$MapViewHolder.access$000(p8).setText(((com.boat.support.slam.entity.floors.Maps) this.mapsList.get(p9)).getMapName());
        com.jlboat.phone.adapter.MapListAdapter$MapViewHolder.access$100(p8).setText(java.text.DateFormat.getDateTimeInstance(2, 3).format(new java.util.Date((((com.boat.support.slam.entity.floors.Maps) this.mapsList.get(p9)).getMapId() * 1000))));
        if (((com.boat.support.slam.entity.floors.Maps) this.mapsList.get(p9)).getMapId() != this.currentMapId) {
            com.jlboat.phone.adapter.MapListAdapter$MapViewHolder.access$000(p8).setTextColor(this.context.getResources().getColor(2131034182));
            com.jlboat.phone.adapter.MapListAdapter$MapViewHolder.access$100(p8).setTextColor(this.context.getResources().getColor(2131034182));
        } else {
            com.jlboat.phone.adapter.MapListAdapter$MapViewHolder.access$000(p8).setTextColor(this.context.getResources().getColor(2131034165));
            com.jlboat.phone.adapter.MapListAdapter$MapViewHolder.access$100(p8).setTextColor(this.context.getResources().getColor(2131034165));
        }
        return;
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.adapter.MapListAdapter$MapViewHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.MapListAdapter$MapViewHolder(this, android.view.LayoutInflater.from(p4.getContext()).inflate(2131361880, p4, 0));
    }

    public void setListData(java.util.List p1, long p2)
    {
        this.currentMapId = p2;
        this.mapsList = p1;
        this.notifyDataSetChanged();
        return;
    }

    public void setOnclickItem(com.jlboat.phone.adapter.MapListAdapter$OnClick p1)
    {
        this.onclick = p1;
        return;
    }
}
