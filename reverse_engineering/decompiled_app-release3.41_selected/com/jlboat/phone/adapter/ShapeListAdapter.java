package com.jlboat.phone.adapter;
public class ShapeListAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private android.content.Context context;
    private String displayString;
    private com.jlboat.phone.adapter.ShapeListAdapter$OnLongClick onLongClick;
    private com.jlboat.phone.adapter.ShapeListAdapter$OnClick onclick;
    private java.util.List shapeAreas;

    public ShapeListAdapter(android.content.Context p2)
    {
        this.shapeAreas = new java.util.ArrayList();
        this.context = p2;
        return;
    }

    static synthetic com.jlboat.phone.adapter.ShapeListAdapter$OnClick access$100(com.jlboat.phone.adapter.ShapeListAdapter p1)
    {
        return p1.onclick;
    }

    static synthetic com.jlboat.phone.adapter.ShapeListAdapter$OnLongClick access$200(com.jlboat.phone.adapter.ShapeListAdapter p1)
    {
        return p1.onLongClick;
    }

    public int getItemCount()
    {
        int v0_3;
        if (this.shapeAreas != null) {
            v0_3 = Integer.valueOf(this.shapeAreas.size());
        } else {
            v0_3 = 0;
        }
        return v0_3.intValue();
    }

    public bridge synthetic void onBindViewHolder(android.support.v7.widget.RecyclerView$ViewHolder p1, int p2)
    {
        this.onBindViewHolder(((com.jlboat.phone.adapter.ShapeListAdapter$MapViewHolder) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.adapter.ShapeListAdapter$MapViewHolder p8, int p9)
    {
        long v0_3 = ((com.boat.support.slam.entity.floors.ShapeAreas) this.shapeAreas.get(p9)).getShapeId();
        int v2_0 = ((com.boat.support.slam.entity.floors.ShapeAreas) this.shapeAreas.get(p9)).getOrderNum();
        String v3_4 = new StringBuilder().append(v2_0).append("").toString();
        if ((v3_4 != null) && (!v3_4.equals(""))) {
            this.displayString = new StringBuilder().append(this.context.getResources().getString(2131493269)).append(v3_4).toString();
        }
        com.jlboat.phone.adapter.ShapeListAdapter$MapViewHolder.access$000(p8).setText(this.displayString);
        com.jlboat.phone.adapter.ShapeListAdapter$MapViewHolder.access$000(p8).setOnClickListener(new com.jlboat.phone.adapter.ShapeListAdapter$1(this, v0_3, v2_0));
        com.jlboat.phone.adapter.ShapeListAdapter$MapViewHolder.access$000(p8).setOnLongClickListener(new com.jlboat.phone.adapter.ShapeListAdapter$2(this, v0_3, v2_0));
        return;
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.adapter.ShapeListAdapter$MapViewHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.ShapeListAdapter$MapViewHolder(this, android.view.LayoutInflater.from(p4.getContext()).inflate(2131361936, p4, 0));
    }

    public void setListData(java.util.List p1)
    {
        this.shapeAreas = p1;
        this.notifyDataSetChanged();
        return;
    }

    public void setOnLingclickItem(com.jlboat.phone.adapter.ShapeListAdapter$OnLongClick p1)
    {
        this.onLongClick = p1;
        return;
    }

    public void setOnclickItem(com.jlboat.phone.adapter.ShapeListAdapter$OnClick p1)
    {
        this.onclick = p1;
        return;
    }
}
