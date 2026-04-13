package com.jlboat.phone.activity;
 class PointBindPathActivity$BindPointItemCL implements com.jlboat.phone.adapter.BindPointListAdapter$OnItemClickListener {
    final synthetic com.jlboat.phone.activity.PointBindPathActivity this$0;

    private PointBindPathActivity$BindPointItemCL(com.jlboat.phone.activity.PointBindPathActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    synthetic PointBindPathActivity$BindPointItemCL(com.jlboat.phone.activity.PointBindPathActivity p1, com.jlboat.phone.activity.PointBindPathActivity$1 p2)
    {
        this(p1);
        return;
    }

    public void onClick(int p11, String p12)
    {
        android.view.View v0_0 = this.this$0;
        com.jlboat.phone.view.MyPopupWindow v9 = new com.jlboat.phone.view.MyPopupWindow;
        v9(this.this$0, this.this$0.getResString(2131493085), new StringBuilder().append(this.this$0.getResString(2131493083)).append(p12).append(this.this$0.getResString(2131493082)).toString(), this.this$0.getResString(2131493080), 1, new com.jlboat.phone.activity.PointBindPathActivity$BindPointItemCL$1(this, p11), new com.jlboat.phone.activity.PointBindPathActivity$BindPointItemCL$2(this));
        com.jlboat.phone.activity.PointBindPathActivity.access$2002(v0_0, v9);
        com.jlboat.phone.activity.PointBindPathActivity.access$2000(this.this$0).showAtLocation(android.view.LayoutInflater.from(this.this$0).inflate(2131361929, 0), 17, 0, 0);
        return;
    }
}
