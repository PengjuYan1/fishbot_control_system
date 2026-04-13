package com.jlboat.phone.adapter;
public class NgLineListAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private android.content.Context context;
    private String displayString;
    private java.util.List ngNlineList;
    private com.jlboat.phone.adapter.NgLineListAdapter$OnLongClick onLongClick;
    private com.jlboat.phone.adapter.NgLineListAdapter$OnClick onclick;

    public NgLineListAdapter(android.content.Context p2)
    {
        this.ngNlineList = new java.util.ArrayList();
        this.context = p2;
        return;
    }

    static synthetic com.jlboat.phone.adapter.NgLineListAdapter$OnClick access$100(com.jlboat.phone.adapter.NgLineListAdapter p1)
    {
        return p1.onclick;
    }

    static synthetic com.jlboat.phone.adapter.NgLineListAdapter$OnLongClick access$200(com.jlboat.phone.adapter.NgLineListAdapter p1)
    {
        return p1.onLongClick;
    }

    public int getItemCount()
    {
        int v0_3;
        if (this.ngNlineList != null) {
            v0_3 = Integer.valueOf(this.ngNlineList.size());
        } else {
            v0_3 = 0;
        }
        return v0_3.intValue();
    }

    public bridge synthetic void onBindViewHolder(android.support.v7.widget.RecyclerView$ViewHolder p1, int p2)
    {
        this.onBindViewHolder(((com.jlboat.phone.adapter.NgLineListAdapter$MapViewHolder) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.adapter.NgLineListAdapter$MapViewHolder p7, int p8)
    {
        long v0_4 = ((com.jlboat.phone.bean.NgNline) this.ngNlineList.get(p8)).getnLine().getId();
        int v2 = (p8 + 1);
        String v3_3 = new StringBuilder().append(v2).append("").toString();
        if ((v3_3 != null) && (!v3_3.equals(""))) {
            this.displayString = new StringBuilder().append("\u8def\u7ebf: ").append(v3_3).toString();
        }
        com.jlboat.phone.adapter.NgLineListAdapter$MapViewHolder.access$000(p7).setText(this.displayString);
        com.jlboat.phone.adapter.NgLineListAdapter$MapViewHolder.access$000(p7).setOnClickListener(new com.jlboat.phone.adapter.NgLineListAdapter$1(this, v0_4, v2));
        com.jlboat.phone.adapter.NgLineListAdapter$MapViewHolder.access$000(p7).setOnLongClickListener(new com.jlboat.phone.adapter.NgLineListAdapter$2(this, v0_4, v2));
        return;
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.adapter.NgLineListAdapter$MapViewHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.NgLineListAdapter$MapViewHolder(this, android.view.LayoutInflater.from(p4.getContext()).inflate(2131361907, p4, 0));
    }

    public void setListData(java.util.List p1)
    {
        this.ngNlineList = p1;
        this.notifyDataSetChanged();
        return;
    }

    public void setOnLingclickItem(com.jlboat.phone.adapter.NgLineListAdapter$OnLongClick p1)
    {
        this.onLongClick = p1;
        return;
    }

    public void setOnclickItem(com.jlboat.phone.adapter.NgLineListAdapter$OnClick p1)
    {
        this.onclick = p1;
        return;
    }
}
