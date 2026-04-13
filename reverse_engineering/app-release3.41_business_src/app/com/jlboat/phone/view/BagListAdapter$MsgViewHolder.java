package com.jlboat.phone.view;
public class BagListAdapter$MsgViewHolder extends android.support.v7.widget.RecyclerView$ViewHolder {
    private android.widget.TextView service_bagname;
    private android.widget.ImageView upload;

    public BagListAdapter$MsgViewHolder(android.view.View p2)
    {
        super(p2);
        super.service_bagname = ((android.widget.TextView) p2.findViewById(2131231244));
        super.upload = ((android.widget.ImageView) p2.findViewById(2131231355));
        return;
    }

    static synthetic android.widget.TextView access$000(com.jlboat.phone.view.BagListAdapter$MsgViewHolder p1)
    {
        return p1.service_bagname;
    }

    static synthetic android.widget.ImageView access$100(com.jlboat.phone.view.BagListAdapter$MsgViewHolder p1)
    {
        return p1.upload;
    }

    public void setData(String p2)
    {
        this.service_bagname.setText(p2);
        return;
    }
}
