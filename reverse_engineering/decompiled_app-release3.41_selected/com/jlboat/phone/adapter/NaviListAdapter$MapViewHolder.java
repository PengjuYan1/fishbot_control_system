package com.jlboat.phone.adapter;
public class NaviListAdapter$MapViewHolder extends android.support.v7.widget.RecyclerView$ViewHolder implements android.view.View$OnClickListener, android.view.View$OnLongClickListener {
    android.widget.RelativeLayout rl_bn;
    final synthetic com.jlboat.phone.adapter.NaviListAdapter this$0;
    private android.widget.TextView tv;

    public NaviListAdapter$MapViewHolder(com.jlboat.phone.adapter.NaviListAdapter p2, android.view.View p3)
    {
        this.this$0 = p2;
        super(p3);
        super.rl_bn = ((android.widget.RelativeLayout) p3.findViewById(2131231180));
        super.tv = ((android.widget.TextView) p3.findViewById(2131231338));
        super.rl_bn.setOnLongClickListener(super);
        super.rl_bn.setOnClickListener(super);
        return;
    }

    static synthetic android.widget.TextView access$000(com.jlboat.phone.adapter.NaviListAdapter$MapViewHolder p1)
    {
        return p1.tv;
    }

    public void onClick(android.view.View p2)
    {
        com.jlboat.phone.adapter.NaviListAdapter.access$100(this.this$0).onClick(p2);
        return;
    }

    public boolean onLongClick(android.view.View p2)
    {
        com.jlboat.phone.adapter.NaviListAdapter.access$100(this.this$0).longclick(p2);
        return 0;
    }
}
