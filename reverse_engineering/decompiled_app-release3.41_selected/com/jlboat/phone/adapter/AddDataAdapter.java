package com.jlboat.phone.adapter;
public class AddDataAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private java.util.List addViewed;

    public AddDataAdapter(java.util.List p1)
    {
        this.addViewed = p1;
        return;
    }

    public int getItemCount()
    {
        int v0_2;
        if (this.addViewed != null) {
            v0_2 = this.addViewed.size();
        } else {
            v0_2 = 0;
        }
        return v0_2;
    }

    public bridge synthetic void onBindViewHolder(android.support.v7.widget.RecyclerView$ViewHolder p1, int p2)
    {
        this.onBindViewHolder(((com.jlboat.phone.adapter.AddDataAdapter$VH) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.adapter.AddDataAdapter$VH p3, int p4)
    {
        com.jlboat.phone.adapter.AddDataAdapter$VH.access$000(p3).setText(((CharSequence) this.addViewed.get(p4)));
        return;
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.adapter.AddDataAdapter$VH onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.AddDataAdapter$VH(this, android.view.View.inflate(p4.getContext(), 2131361881, 0));
    }
}
