package com.jlboat.phone.adapter;
public class MoveResultAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private java.util.List mList;
    private int mType;
    private com.jlboat.phone.bean.MoveRes res;

    public MoveResultAdapter()
    {
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

    public int getItemViewType(int p1)
    {
        return p1;
    }

    public bridge synthetic void onBindViewHolder(android.support.v7.widget.RecyclerView$ViewHolder p1, int p2)
    {
        this.onBindViewHolder(((com.jlboat.phone.adapter.MoveResultAdapter$MyResHolder) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.adapter.MoveResultAdapter$MyResHolder p6, int p7)
    {
        this.res = ((com.jlboat.phone.bean.MoveRes) this.mList.get(p7));
        if (this.res.getValue() != 1176255488) {
            if (this.res.getValue() != 1176256512) {
                p6.timeTv.setText(new StringBuilder().append(this.res.getTime()).append("___").append(p7).toString());
                p6.endTv.setVisibility(8);
                if ((this.mType != 2) && ((this.mType != 4) && (this.mType != 5))) {
                    p6.valueTv.setText(new StringBuilder().append(this.res.getValue()).append("\u00b0").toString());
                } else {
                    android.widget.TextView v0_17 = p6.valueTv;
                    String v1_19 = new StringBuilder();
                    Object[] v4_4 = new Object[1];
                    v4_4[0] = Float.valueOf(this.res.getValue());
                    v0_17.setText(v1_19.append(String.format("%.2f", v4_4)).append("m").toString());
                }
            } else {
                p6.timeTv.setVisibility(8);
                p6.endTv.setVisibility(0);
                p6.valueTv.setVisibility(8);
                p6.endTv.setText("\u6d4b\u8bd5\u53d6\u6d88");
                p6.endTv.setTextColor(android.graphics.Color.parseColor("#eeb300"));
            }
        } else {
            p6.timeTv.setVisibility(8);
            p6.valueTv.setVisibility(8);
            p6.endTv.setVisibility(0);
            p6.endTv.setText("\u6d4b\u8bd5\u5b8c\u6210");
            p6.endTv.setTextColor(android.graphics.Color.parseColor("#6ccc4b"));
        }
        return;
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.adapter.MoveResultAdapter$MyResHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.MoveResultAdapter$MyResHolder(this, android.view.LayoutInflater.from(p4.getContext()).inflate(2131361901, p4, 0));
    }

    public void setData(java.util.List p1, int p2)
    {
        this.mList = p1;
        this.mType = p2;
        this.notifyDataSetChanged();
        return;
    }
}
