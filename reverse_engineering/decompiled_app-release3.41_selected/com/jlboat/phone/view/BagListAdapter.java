package com.jlboat.phone.view;
public class BagListAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private android.os.Handler handler;
    private java.util.List listData;
    private android.content.Context mContext;
    private int status;

    public BagListAdapter(android.content.Context p2)
    {
        this.listData = new java.util.ArrayList();
        this.handler = new com.jlboat.phone.view.BagListAdapter$2(this);
        this.mContext = p2;
        return;
    }

    static synthetic int access$200(com.jlboat.phone.view.BagListAdapter p1)
    {
        return p1.status;
    }

    static synthetic android.content.Context access$300(com.jlboat.phone.view.BagListAdapter p1)
    {
        return p1.mContext;
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

    public void onBindViewHolder(android.support.v7.widget.RecyclerView$ViewHolder p4, int p5)
    {
        ((com.jlboat.phone.view.BagListAdapter$MsgViewHolder) p4).setData(((String) this.listData.get(p5)));
        com.jlboat.phone.view.BagListAdapter$MsgViewHolder.access$100(((com.jlboat.phone.view.BagListAdapter$MsgViewHolder) p4)).setOnClickListener(new com.jlboat.phone.view.BagListAdapter$1(this, com.jlboat.phone.view.BagListAdapter$MsgViewHolder.access$000(((com.jlboat.phone.view.BagListAdapter$MsgViewHolder) p4)).getText().toString()));
        return;
    }

    public android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.view.BagListAdapter$MsgViewHolder(android.view.LayoutInflater.from(p4.getContext()).inflate(2131361835, p4, 0));
    }

    public void setMdata(java.util.List p3)
    {
        android.util.Log.d("TAG", new StringBuilder().append("setMdata: ").append(p3).toString());
        this.listData = p3;
        this.notifyDataSetChanged();
        return;
    }
}
