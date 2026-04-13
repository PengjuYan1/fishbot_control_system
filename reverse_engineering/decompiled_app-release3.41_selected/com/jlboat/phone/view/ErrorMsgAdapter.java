package com.jlboat.phone.view;
public class ErrorMsgAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private java.util.List listData;
    private android.content.Context mContext;

    public ErrorMsgAdapter(android.content.Context p2)
    {
        this.listData = new java.util.ArrayList();
        this.mContext = p2;
        return;
    }

    static synthetic android.content.Context access$000(com.jlboat.phone.view.ErrorMsgAdapter p1)
    {
        return p1.mContext;
    }

    public int getItemCount()
    {
        return this.listData.size();
    }

    public bridge synthetic void onBindViewHolder(android.support.v7.widget.RecyclerView$ViewHolder p1, int p2)
    {
        this.onBindViewHolder(((com.jlboat.phone.view.ErrorMsgAdapter$MsgViewHolder) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.view.ErrorMsgAdapter$MsgViewHolder p2, int p3)
    {
        p2.setData(((com.jlboat.phone.view.Err) this.listData.get(p3)));
        return;
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.view.ErrorMsgAdapter$MsgViewHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.view.ErrorMsgAdapter$MsgViewHolder(this, android.view.LayoutInflater.from(p4.getContext()).inflate(2131361855, p4, 0));
    }

    public void setMdata(java.util.List p1)
    {
        java.util.Collections.reverse(p1);
        this.listData = p1;
        this.notifyDataSetChanged();
        return;
    }
}
