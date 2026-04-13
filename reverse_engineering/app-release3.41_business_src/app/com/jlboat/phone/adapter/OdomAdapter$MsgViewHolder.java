package com.jlboat.phone.adapter;
public class OdomAdapter$MsgViewHolder extends android.support.v7.widget.RecyclerView$ViewHolder {
    private android.widget.LinearLayout odom_item;
    private android.widget.TextView odom_name;
    private android.widget.TextView odom_value;

    public OdomAdapter$MsgViewHolder(android.view.View p2)
    {
        super(p2);
        super.odom_name = ((android.widget.TextView) p2.findViewById(2131231051));
        super.odom_value = ((android.widget.TextView) p2.findViewById(2131231053));
        super.odom_item = ((android.widget.LinearLayout) p2.findViewById(2131231050));
        return;
    }

    static synthetic android.widget.TextView access$000(com.jlboat.phone.adapter.OdomAdapter$MsgViewHolder p1)
    {
        return p1.odom_value;
    }

    static synthetic android.widget.TextView access$200(com.jlboat.phone.adapter.OdomAdapter$MsgViewHolder p1)
    {
        return p1.odom_name;
    }

    static synthetic android.widget.LinearLayout access$600(com.jlboat.phone.adapter.OdomAdapter$MsgViewHolder p1)
    {
        return p1.odom_item;
    }

    public void setData(com.jlboat.phone.message.map_msgs.Config p4)
    {
        android.util.Log.d(com.jlboat.phone.adapter.OdomAdapter.access$700(), new StringBuilder().append("setData: ").append(p4.getType()).toString());
        this.odom_name.setText(p4.getConfigName());
        this.odom_value.setText(p4.getConfigValue());
        return;
    }
}
