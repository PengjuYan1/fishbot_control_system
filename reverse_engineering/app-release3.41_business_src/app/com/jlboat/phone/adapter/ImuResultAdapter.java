package com.jlboat.phone.adapter;
public class ImuResultAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private java.util.List mList;
    private int mNum;
    private int mType;
    private com.jlboat.phone.message.map_msgs.CalculateOdomResponse res;

    public ImuResultAdapter()
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

    public bridge synthetic void onBindViewHolder(android.support.v7.widget.RecyclerView$ViewHolder p1, int p2)
    {
        this.onBindViewHolder(((com.jlboat.phone.adapter.ImuResultAdapter$MyResHolder) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.adapter.ImuResultAdapter$MyResHolder p7, int p8)
    {
        this.res = ((com.jlboat.phone.message.map_msgs.CalculateOdomResponse) this.mList.get(p8));
        p7.leftTv.setVisibility(8);
        p7.rightTv.setVisibility(8);
        if (this.mNum >= p8) {
            p7.leftTv.setVisibility(0);
            p7.rightTv.setVisibility(0);
        }
        p7.numTv.setText(new StringBuilder().append("\u7b2c").append((p8 + 1)).append("\u6b21").toString());
        android.widget.TextView v0_7 = p7.valueTv;
        Float v2_7 = new StringBuilder();
        Object[] v5_0 = new Object[1];
        v5_0[0] = Float.valueOf(this.res.getDiff_distance());
        v0_7.setText(v2_7.append(String.format("%.2f", v5_0)).append("m").toString());
        android.widget.TextView v0_9 = p7.leftTv;
        Object[] v5_3 = new Object[1];
        v5_3[0] = Float.valueOf(this.res.getLeftmotor_ratio());
        v0_9.setText(String.format("%.2f", v5_3));
        android.widget.TextView v0_10 = p7.rightTv;
        Object[] v4_1 = new Object[1];
        v4_1[0] = Float.valueOf(this.res.getRightmotor_ratio());
        v0_10.setText(String.format("%.2f", v4_1));
        return;
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.adapter.ImuResultAdapter$MyResHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.ImuResultAdapter$MyResHolder(this, android.view.LayoutInflater.from(p4.getContext()).inflate(2131361836, p4, 0));
    }

    public void setData(java.util.List p1, int p2, int p3)
    {
        this.mList = p1;
        this.mType = p2;
        this.mNum = p3;
        this.notifyDataSetChanged();
        return;
    }
}
