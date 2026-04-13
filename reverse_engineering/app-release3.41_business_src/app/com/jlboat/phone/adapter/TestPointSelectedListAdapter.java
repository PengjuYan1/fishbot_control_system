package com.jlboat.phone.adapter;
public class TestPointSelectedListAdapter extends android.support.v7.widget.RecyclerView$Adapter {
    private com.jlboat.phone.adapter.TestPointSelectedListAdapter$OnItemClickListener mItemClickListener;
    private java.util.List mPointsList;
    private String pointName;

    public TestPointSelectedListAdapter()
    {
        return;
    }

    static synthetic com.jlboat.phone.adapter.TestPointSelectedListAdapter$OnItemClickListener access$200(com.jlboat.phone.adapter.TestPointSelectedListAdapter p1)
    {
        return p1.mItemClickListener;
    }

    public int getItemCount()
    {
        return this.mPointsList.size();
    }

    public int getItemViewType(int p1)
    {
        return p1;
    }

    public bridge synthetic void onBindViewHolder(android.support.v7.widget.RecyclerView$ViewHolder p1, int p2)
    {
        this.onBindViewHolder(((com.jlboat.phone.adapter.TestPointSelectedListAdapter$MyHolder) p1), p2);
        return;
    }

    public void onBindViewHolder(com.jlboat.phone.adapter.TestPointSelectedListAdapter$MyHolder p4, int p5)
    {
        if ((p5 == 0) && (this.mPointsList.size() == 1)) {
            com.jlboat.phone.adapter.TestPointSelectedListAdapter$MyHolder.access$000(p4).setVisibility(8);
        }
        if (p5 != (this.mPointsList.size() - 1)) {
            com.jlboat.phone.adapter.TestPointSelectedListAdapter$MyHolder.access$000(p4).setVisibility(0);
        } else {
            com.jlboat.phone.adapter.TestPointSelectedListAdapter$MyHolder.access$000(p4).setVisibility(8);
        }
        this.pointName = ((com.boat.support.slam.entity.floors.Points) this.mPointsList.get(p5)).getPointName();
        if (!this.pointName.trim().equals("")) {
            com.jlboat.phone.adapter.TestPointSelectedListAdapter$MyHolder.access$100(p4).setText(this.pointName);
        } else {
            com.jlboat.phone.adapter.TestPointSelectedListAdapter$MyHolder.access$100(p4).setText(new StringBuilder().append("\u672a\u547d\u540d\u5bfc\u822a\u70b9").append(p5).toString());
        }
        p4.itemView.setOnClickListener(new com.jlboat.phone.adapter.TestPointSelectedListAdapter$1(this, p5));
        return;
    }

    public bridge synthetic android.support.v7.widget.RecyclerView$ViewHolder onCreateViewHolder(android.view.ViewGroup p1, int p2)
    {
        return this.onCreateViewHolder(p1, p2);
    }

    public com.jlboat.phone.adapter.TestPointSelectedListAdapter$MyHolder onCreateViewHolder(android.view.ViewGroup p4, int p5)
    {
        return new com.jlboat.phone.adapter.TestPointSelectedListAdapter$MyHolder(this, android.view.LayoutInflater.from(p4.getContext()).inflate(2131361904, p4, 0));
    }

    public void setData(java.util.List p1)
    {
        this.mPointsList = p1;
        this.notifyDataSetChanged();
        return;
    }

    public void setOnItemClickListener(com.jlboat.phone.adapter.TestPointSelectedListAdapter$OnItemClickListener p1)
    {
        this.mItemClickListener = p1;
        return;
    }
}
