package com.jlboat.phone.adapter;
public class ConfigListAdapter$MsgViewHolder extends android.support.v7.widget.RecyclerView$ViewHolder {
    private android.widget.LinearLayout config_item;
    private android.widget.TextView config_name;
    private android.widget.TextView config_value;

    public ConfigListAdapter$MsgViewHolder(android.view.View p2)
    {
        super(p2);
        super.config_name = ((android.widget.TextView) p2.findViewById(2131230858));
        super.config_value = ((android.widget.TextView) p2.findViewById(2131230859));
        super.config_item = ((android.widget.LinearLayout) p2.findViewById(2131230857));
        return;
    }

    static synthetic android.widget.TextView access$000(com.jlboat.phone.adapter.ConfigListAdapter$MsgViewHolder p1)
    {
        return p1.config_value;
    }

    static synthetic android.widget.TextView access$200(com.jlboat.phone.adapter.ConfigListAdapter$MsgViewHolder p1)
    {
        return p1.config_name;
    }

    static synthetic android.widget.LinearLayout access$600(com.jlboat.phone.adapter.ConfigListAdapter$MsgViewHolder p1)
    {
        return p1.config_item;
    }

    public void setData(com.jlboat.phone.message.map_msgs.Config p3)
    {
        this.config_name.setText(p3.getConfigName());
        this.config_value.setText(p3.getConfigValue());
        return;
    }
}
