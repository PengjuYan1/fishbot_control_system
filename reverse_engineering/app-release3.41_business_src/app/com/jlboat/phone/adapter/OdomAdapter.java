package com.jlboat.phone.adapter;
public class OdomAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private static String TAG;
    private android.os.Handler handler;
    private java.util.List listData;
    private com.jlboat.phone.adapter.ConfigListener listener;
    private final android.content.Context mContext;
    private String name;
    private long status;
    private com.jlboat.phone.communication.StatusServiceClient statusServiceClient;

    static OdomAdapter()
    {
        com.jlboat.phone.adapter.OdomAdapter.TAG = "OdomAdapter";
        return;
    }

    public OdomAdapter(android.content.Context p2, com.jlboat.phone.adapter.ConfigListener p3)
    {
        this.listData = new java.util.ArrayList();
        this.statusServiceClient = new com.jlboat.phone.communication.StatusServiceClient();
        this.handler = new com.jlboat.phone.adapter.OdomAdapter$3(this);
        this.mContext = p2;
        this.listener = p3;
        return;
    }

    private void SetOrDelConfigsService(java.util.List p4)
    {
        android.util.Log.d(com.jlboat.phone.adapter.OdomAdapter.TAG, new StringBuilder().append("SetOrDelConfigsService: ").append(((com.jlboat.phone.message.map_msgs.Config) p4.get(0)).getConfigValue()).toString());
        this.statusServiceClient.setOrDelConfigsService(p4, 6, new com.jlboat.phone.adapter.OdomAdapter$2(this));
        return;
    }

    static synthetic String access$100(com.jlboat.phone.adapter.OdomAdapter p1)
    {
        return p1.name;
    }

    static synthetic com.jlboat.phone.adapter.ConfigListener access$1000(com.jlboat.phone.adapter.OdomAdapter p1)
    {
        return p1.listener;
    }

    static synthetic String access$102(com.jlboat.phone.adapter.OdomAdapter p0, String p1)
    {
        p0.name = p1;
        return p1;
    }

    static synthetic android.content.Context access$300(com.jlboat.phone.adapter.OdomAdapter p1)
    {
        return p1.mContext;
    }

    static synthetic java.util.List access$400(com.jlboat.phone.adapter.OdomAdapter p1)
    {
        return p1.listData;
    }

    static synthetic void access$500(com.jlboat.phone.adapter.OdomAdapter p0, java.util.List p1)
    {
        p0.SetOrDelConfigsService(p1);
        return;
    }

    static synthetic String access$700()
    {
        return com.jlboat.phone.adapter.OdomAdapter.TAG;
    }

    static synthetic long access$800(com.jlboat.phone.adapter.OdomAdapter p2)
    {
        return p2.status;
    }

    static synthetic long access$802(com.jlboat.phone.adapter.OdomAdapter p0, long p1)
    {
        p0.status = p1;
        return p1;
    }

    static synthetic android.os.Handler access$900(com.jlboat.phone.adapter.OdomAdapter p1)
    {
        return p1.handler;
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
        ((com.jlboat.phone.adapter.OdomAdapter$MsgViewHolder) p3).setData(((com.jlboat.phone.message.map_msgs.Config) this.listData.get(p4)));
        com.jlboat.phone.adapter.OdomAdapter$MsgViewHolder.access$600(((com.jlboat.phone.adapter.OdomAdapter$MsgViewHolder) p3)).setOnClickListener(new com.jlboat.phone.adapter.OdomAdapter$1(this, p3, p4));
        return;
    }

    public android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.OdomAdapter$MsgViewHolder(android.view.LayoutInflater.from(p4.getContext()).inflate(2131361924, p4, 0));
    }

    public void setMdata(java.util.List p1)
    {
        this.listData = p1;
        this.notifyDataSetChanged();
        return;
    }
}
