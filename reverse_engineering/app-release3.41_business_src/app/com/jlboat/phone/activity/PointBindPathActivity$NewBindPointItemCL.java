package com.jlboat.phone.activity;
 class PointBindPathActivity$NewBindPointItemCL implements com.jlboat.phone.adapter.NewBindPointListAdapter$OnItemClickListener {
    final synthetic com.jlboat.phone.activity.PointBindPathActivity this$0;

    private PointBindPathActivity$NewBindPointItemCL(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    synthetic PointBindPathActivity$NewBindPointItemCL(com.jlboat.phone.activity.PointBindPathActivity p1, com.jlboat.phone.activity.PointBindPathActivity$1 p2)
    {
        this(p1);
        return;
    }

    public void onClick(int p3)
    {
        this.this$0.newAddPos.remove(p3);
        com.jlboat.phone.activity.PointBindPathActivity.access$1702(this.this$0, 0);
        com.jlboat.phone.activity.PointBindPathActivity.access$100(this.this$0).setData(this.this$0.newAddPos);
        com.jlboat.phone.activity.PointBindPathActivity.access$1900(this.this$0).setVerticalScrollbarPosition((this.this$0.newAddPos.size() - 1));
        this.this$0.toast(2131493293);
        return;
    }
}
