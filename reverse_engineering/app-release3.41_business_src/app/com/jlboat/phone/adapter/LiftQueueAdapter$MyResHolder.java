package com.jlboat.phone.adapter;
 class LiftQueueAdapter$MyResHolder extends android.support.v7.widget.RecyclerView$ViewHolder {
    android.widget.TextView bindFloorsTv;
    android.widget.TextView bindNameTv;
    android.widget.Button delQueueBtu;
    android.widget.TextView floorsTv;
    android.view.View line;
    android.widget.TextView nameTv;
    android.widget.TextView notesTv;
    android.widget.TextView stateTv;
    final synthetic com.jlboat.phone.adapter.LiftQueueAdapter this$0;
    android.widget.TextView typeTv;

    public LiftQueueAdapter$MyResHolder(com.jlboat.phone.adapter.LiftQueueAdapter p3, android.view.View p4)
    {
        this.this$0 = p3;
        super(p4);
        super.nameTv = ((android.widget.TextView) p4.findViewById(2131231157));
        super.floorsTv = ((android.widget.TextView) p4.findViewById(2131231153));
        super.stateTv = ((android.widget.TextView) p4.findViewById(2131231159));
        super.bindNameTv = ((android.widget.TextView) p4.findViewById(2131231148));
        super.bindFloorsTv = ((android.widget.TextView) p4.findViewById(2131231147));
        super.notesTv = ((android.widget.TextView) p4.findViewById(2131231162));
        super.typeTv = ((android.widget.TextView) p4.findViewById(2131231163));
        super.delQueueBtu = ((android.widget.Button) p4.findViewById(2131231158));
        super.delQueueBtu.setOnClickListener(new com.jlboat.phone.adapter.LiftQueueAdapter$MyResHolder$1(super, p3));
        super.line = p4.findViewById(2131231155);
        return;
    }
}
