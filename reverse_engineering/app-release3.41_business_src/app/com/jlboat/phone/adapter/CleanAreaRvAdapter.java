package com.jlboat.phone.adapter;
public class CleanAreaRvAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private java.util.List cleanAreas;
    private android.content.Context context;
    private com.jlboat.phone.adapter.CleanAreaRvAdapter$OnCheckedChangeListener onCheckedChangeListener;
    private com.jlboat.phone.adapter.CleanAreaRvAdapter$OnLongClick onLongClick;
    private com.jlboat.phone.adapter.CleanAreaRvAdapter$OnClick onclick;

    public CleanAreaRvAdapter(android.content.Context p2)
    {
        this.cleanAreas = new java.util.ArrayList();
        this.context = p2;
        return;
    }

    static synthetic com.jlboat.phone.adapter.CleanAreaRvAdapter$OnClick access$100(com.jlboat.phone.adapter.CleanAreaRvAdapter p1)
    {
        return p1.onclick;
    }

    static synthetic com.jlboat.phone.adapter.CleanAreaRvAdapter$OnCheckedChangeListener access$300(com.jlboat.phone.adapter.CleanAreaRvAdapter p1)
    {
        return p1.onCheckedChangeListener;
    }

    static synthetic com.jlboat.phone.adapter.CleanAreaRvAdapter$OnLongClick access$500(com.jlboat.phone.adapter.CleanAreaRvAdapter p1)
    {
        return p1.onLongClick;
    }

    public int getItemCount()
    {
        int v0_3;
        if (this.cleanAreas != null) {
            v0_3 = Integer.valueOf(this.cleanAreas.size());
        } else {
            v0_3 = 0;
        }
        return v0_3.intValue();
    }

    public bridge synthetic void onBindViewHolder(android.support.v7.widget.RecyclerView$ViewHolder p1, int p2)
    {
        this.onBindViewHolder(((com.jlboat.phone.adapter.CleanAreaRvAdapter$MapViewHolder) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.adapter.CleanAreaRvAdapter$MapViewHolder p6, int p7)
    {
        long v0_3 = ((com.boat.support.slam.entity.floors.CleanArea) this.cleanAreas.get(p7)).getCleanAreaId();
        String v2_0 = ((com.boat.support.slam.entity.floors.CleanArea) this.cleanAreas.get(p7)).getCleanAreaName();
        if (v2_0 != null) {
            com.jlboat.phone.adapter.CleanAreaRvAdapter$MapViewHolder.access$000(p6).setText(v2_0);
        }
        com.jlboat.phone.adapter.CleanAreaRvAdapter$MapViewHolder.access$200(p6).setOnClickListener(new com.jlboat.phone.adapter.CleanAreaRvAdapter$1(this, v0_3, v2_0));
        com.jlboat.phone.adapter.CleanAreaRvAdapter$MapViewHolder.access$400(p6).setOnCheckedChangeListener(new com.jlboat.phone.adapter.CleanAreaRvAdapter$2(this, v0_3));
        com.jlboat.phone.adapter.CleanAreaRvAdapter$MapViewHolder.access$200(p6).setOnLongClickListener(new com.jlboat.phone.adapter.CleanAreaRvAdapter$3(this, v0_3, v2_0));
        return;
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.adapter.CleanAreaRvAdapter$MapViewHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.CleanAreaRvAdapter$MapViewHolder(this, android.view.LayoutInflater.from(p4.getContext()).inflate(2131361839, p4, 0));
    }

    public void setListData(java.util.List p1)
    {
        this.cleanAreas = p1;
        this.notifyDataSetChanged();
        return;
    }

    public void setOnCheckedChangeListener(com.jlboat.phone.adapter.CleanAreaRvAdapter$OnCheckedChangeListener p1)
    {
        this.onCheckedChangeListener = p1;
        return;
    }

    public void setOnLingclickItem(com.jlboat.phone.adapter.CleanAreaRvAdapter$OnLongClick p1)
    {
        this.onLongClick = p1;
        return;
    }

    public void setOnclickItem(com.jlboat.phone.adapter.CleanAreaRvAdapter$OnClick p1)
    {
        this.onclick = p1;
        return;
    }
}
