package com.jlboat.phone.adapter;
public class DiyPathListAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private com.boat.support.slam.entity.floors.GlobalPlans globalPlan;
    private int mId;
    private com.jlboat.phone.adapter.DiyPathListAdapter$OnItemClickListener mItemClickListener;
    private com.jlboat.phone.adapter.DiyPathListAdapter$OnItemLongClickListener mItemLongClickListener;
    private java.util.List mPointList;

    public DiyPathListAdapter()
    {
        this.mPointList = new java.util.ArrayList();
        return;
    }

    static synthetic com.jlboat.phone.adapter.DiyPathListAdapter$OnItemClickListener access$000(com.jlboat.phone.adapter.DiyPathListAdapter p1)
    {
        return p1.mItemClickListener;
    }

    static synthetic int access$100(com.jlboat.phone.adapter.DiyPathListAdapter p1)
    {
        return p1.mId;
    }

    static synthetic com.jlboat.phone.adapter.DiyPathListAdapter$OnItemLongClickListener access$200(com.jlboat.phone.adapter.DiyPathListAdapter p1)
    {
        return p1.mItemLongClickListener;
    }

    public int getItemCount()
    {
        return this.mPointList.size();
    }

    public int getItemViewType(int p1)
    {
        return p1;
    }

    public bridge synthetic void onBindViewHolder(android.support.v7.widget.RecyclerView$ViewHolder p1, int p2)
    {
        this.onBindViewHolder(((com.jlboat.phone.adapter.DiyPathListAdapter$MyHolder) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.adapter.DiyPathListAdapter$MyHolder p4, int p5)
    {
        this.globalPlan = ((com.boat.support.slam.entity.floors.GlobalPlans) this.mPointList.get(p5));
        if (this.mId != p5) {
            p4.tv.setTextColor(android.graphics.Color.parseColor("#333333"));
            if (this.globalPlan.getDir() != 1) {
                p4.iv.setBackgroundResource(2131427343);
            } else {
                p4.iv.setBackgroundResource(2131427342);
            }
        } else {
            p4.tv.setTextColor(android.graphics.Color.parseColor("#ff8700"));
            if (this.globalPlan.getDir() != 1) {
                p4.iv.setBackgroundResource(2131427345);
            } else {
                p4.iv.setBackgroundResource(2131427344);
            }
        }
        if (!this.globalPlan.getGlobalplanName().trim().equals("")) {
            p4.tv.setText(this.globalPlan.getGlobalplanName());
        } else {
            p4.tv.setText(new StringBuilder().append("\u672a\u547d\u540d\u8def\u7ebf").append(p5).toString());
        }
        p4.itemView.setOnClickListener(new com.jlboat.phone.adapter.DiyPathListAdapter$1(this, p5));
        p4.itemView.setOnLongClickListener(new com.jlboat.phone.adapter.DiyPathListAdapter$2(this, p5));
        return;
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.adapter.DiyPathListAdapter$MyHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.DiyPathListAdapter$MyHolder(this, android.view.LayoutInflater.from(p4.getContext()).inflate(2131361842, p4, 0));
    }

    public void setData(java.util.List p1, int p2)
    {
        this.mPointList = p1;
        this.mId = p2;
        this.notifyDataSetChanged();
        return;
    }

    public void setOnItemClickListener(com.jlboat.phone.adapter.DiyPathListAdapter$OnItemClickListener p1)
    {
        this.mItemClickListener = p1;
        return;
    }

    public void setOnLongItemClickListener(com.jlboat.phone.adapter.DiyPathListAdapter$OnItemLongClickListener p1)
    {
        this.mItemLongClickListener = p1;
        return;
    }
}
