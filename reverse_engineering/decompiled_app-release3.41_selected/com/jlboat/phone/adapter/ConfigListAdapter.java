package com.jlboat.phone.adapter;
public class ConfigListAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private com.jlboat.phone.activity.BasicSettingActivity basicSettingActivity;
    private android.os.Handler handler;
    private java.util.List listData;
    private final android.content.Context mContext;
    private String name;
    private long status;
    private int type;
    ref.WeakReference weak;

    public ConfigListAdapter(android.content.Context p3)
    {
        this.listData = new java.util.ArrayList();
        this.handler = new com.jlboat.phone.adapter.ConfigListAdapter$3(this);
        this.mContext = p3;
        this.weak = new ref.WeakReference(((com.jlboat.phone.activity.BasicSettingActivity) p3));
        return;
    }

    private void SetOrDelConfigsService(java.util.List p4)
    {
        this.basicSettingActivity.statusServiceClient.setOrDelConfigsService(p4, this.type, new com.jlboat.phone.adapter.ConfigListAdapter$2(this));
        return;
    }

    static synthetic String access$100(com.jlboat.phone.adapter.ConfigListAdapter p1)
    {
        return p1.name;
    }

    static synthetic String access$102(com.jlboat.phone.adapter.ConfigListAdapter p0, String p1)
    {
        p0.name = p1;
        return p1;
    }

    static synthetic android.content.Context access$300(com.jlboat.phone.adapter.ConfigListAdapter p1)
    {
        return p1.mContext;
    }

    static synthetic java.util.List access$400(com.jlboat.phone.adapter.ConfigListAdapter p1)
    {
        return p1.listData;
    }

    static synthetic void access$500(com.jlboat.phone.adapter.ConfigListAdapter p0, java.util.List p1)
    {
        p0.SetOrDelConfigsService(p1);
        return;
    }

    static synthetic long access$700(com.jlboat.phone.adapter.ConfigListAdapter p2)
    {
        return p2.status;
    }

    static synthetic long access$702(com.jlboat.phone.adapter.ConfigListAdapter p0, long p1)
    {
        p0.status = p1;
        return p1;
    }

    static synthetic android.os.Handler access$800(com.jlboat.phone.adapter.ConfigListAdapter p1)
    {
        return p1.handler;
    }

    static synthetic com.jlboat.phone.activity.BasicSettingActivity access$900(com.jlboat.phone.adapter.ConfigListAdapter p1)
    {
        return p1.basicSettingActivity;
    }

    public static void showToast(android.content.Context p2, String p3)
    {
        android.widget.Toast.makeText(p2.getApplicationContext(), p3, 0).show();
        return;
    }

    public int getItemCount()
    {
        return this.listData.size();
    }

    public void onBindViewHolder(android.support.v7.widget.RecyclerView$ViewHolder p3, int p4)
    {
        ((com.jlboat.phone.adapter.ConfigListAdapter$MsgViewHolder) p3).setData(((com.jlboat.phone.message.map_msgs.Config) this.listData.get(p4)));
        com.jlboat.phone.adapter.ConfigListAdapter$MsgViewHolder.access$600(((com.jlboat.phone.adapter.ConfigListAdapter$MsgViewHolder) p3)).setOnClickListener(new com.jlboat.phone.adapter.ConfigListAdapter$1(this, p3, p4));
        return;
    }

    public android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        com.jlboat.phone.adapter.ConfigListAdapter$MsgViewHolder v1_2 = new com.jlboat.phone.adapter.ConfigListAdapter$MsgViewHolder(android.view.LayoutInflater.from(p4.getContext()).inflate(2131361840, p4, 0));
        this.basicSettingActivity = ((com.jlboat.phone.activity.BasicSettingActivity) this.weak.get());
        return v1_2;
    }

    public void setMdata(java.util.List p1, int p2)
    {
        this.listData = p1;
        this.type = p2;
        return;
    }
}
