package com.jlboat.phone.adapter;
public class LoraStatusAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private android.content.Context mContext;
    private java.util.List mList;

    public LoraStatusAdapter(android.content.Context p2)
    {
        this.mList = new java.util.ArrayList();
        this.mContext = p2;
        return;
    }

    public int getItemCount()
    {
        int v0_1;
        if (this.mList == null) {
            v0_1 = 0;
        } else {
            v0_1 = this.mList.size();
        }
        return v0_1;
    }

    public bridge synthetic void onBindViewHolder(android.support.v7.widget.RecyclerView$ViewHolder p1, int p2)
    {
        this.onBindViewHolder(((com.jlboat.phone.adapter.LoraStatusAdapter$MyResHolder) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.adapter.LoraStatusAdapter$MyResHolder p6, int p7)
    {
        com.boat.support.slam.entity.floors.LoraInfo v0_2 = ((com.boat.support.slam.entity.floors.LoraInfo) this.mList.get(p7));
        if (v0_2 != null) {
            p6.indexTv.setText(new StringBuilder().append((p7 + 1)).append("").toString());
            p6.loraTv.setText(v0_2.getDeviceID());
            p6.floorTv.setText(v0_2.getFloorName());
            p6.pointTv.setText(v0_2.getPointName());
            String v1_5 = "";
            if (v0_2.getDeviceType() == 21) {
                v1_5 = this.mContext.getResources().getString(2131493013);
            }
            if (v0_2.getDeviceType() == 22) {
                v1_5 = this.mContext.getResources().getString(2131493014);
            }
            p6.typeTv.setText(v1_5);
            return;
        } else {
            p6.loraTv.setText("");
            p6.floorTv.setText("");
            p6.pointTv.setText("");
            p6.typeTv.setText("");
            return;
        }
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.adapter.LoraStatusAdapter$MyResHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.LoraStatusAdapter$MyResHolder(this, android.view.LayoutInflater.from(this.mContext).inflate(2131361887, p4, 0));
    }

    public void setData(java.util.List p4)
    {
        this.mList.clear();
        if (p4 != null) {
            java.util.Iterator v0_1 = p4.iterator();
            while (v0_1.hasNext()) {
                com.boat.support.slam.entity.floors.LoraInfo v1_1 = ((com.boat.support.slam.entity.floors.LoraInfo) v0_1.next());
                if (v1_1 != null) {
                    this.mList.add(v1_1);
                }
            }
        }
        this.notifyDataSetChanged();
        return;
    }
}
