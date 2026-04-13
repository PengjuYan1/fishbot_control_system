package com.jlboat.phone.adapter;
public class MapListAdapter$MapViewHolder extends android.support.v7.widget.RecyclerView$ViewHolder implements android.view.View$OnClickListener, android.view.View$OnLongClickListener {
    android.widget.RelativeLayout rl_bn;
    final synthetic com.jlboat.phone.adapter.MapListAdapter this$0;
    private android.widget.TextView tv;
    private android.widget.TextView tv_mapid;

    public MapListAdapter$MapViewHolder(com.jlboat.phone.adapter.MapListAdapter p2, android.view.View p3)
    {
        this.this$0 = p2;
        super(p3);
        super.rl_bn = ((android.widget.RelativeLayout) p3.findViewById(2131231180));
        super.tv = ((android.widget.TextView) p3.findViewById(2131231338));
        super.tv_mapid = ((android.widget.TextView) p3.findViewById(2131231337));
        super.rl_bn.setOnClickListener(super);
        super.rl_bn.setOnLongClickListener(super);
        return;
    }

    static synthetic android.widget.TextView access$000(com.jlboat.phone.adapter.MapListAdapter$MapViewHolder p1)
    {
        return p1.tv;
    }

    static synthetic android.widget.TextView access$100(com.jlboat.phone.adapter.MapListAdapter$MapViewHolder p1)
    {
        return p1.tv_mapid;
    }

    public void onClick(android.view.View p2)
    {
        if (com.jlboat.phone.adapter.MapListAdapter.access$200(this.this$0) != null) {
            com.jlboat.phone.adapter.MapListAdapter.access$200(this.this$0).click(p2);
        }
        return;
    }

    public boolean onLongClick(android.view.View p2)
    {
        if (com.jlboat.phone.adapter.MapListAdapter.access$200(this.this$0) != null) {
            com.jlboat.phone.adapter.MapListAdapter.access$200(this.this$0).longlick(p2);
        }
        return 0;
    }
}
