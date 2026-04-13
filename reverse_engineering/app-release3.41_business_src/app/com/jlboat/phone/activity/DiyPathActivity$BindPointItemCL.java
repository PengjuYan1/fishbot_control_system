package com.jlboat.phone.activity;
 class DiyPathActivity$BindPointItemCL implements com.jlboat.phone.adapter.BindPointListAdapter$OnItemClickListener {
    final synthetic com.jlboat.phone.activity.DiyPathActivity this$0;

    private DiyPathActivity$BindPointItemCL(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    synthetic DiyPathActivity$BindPointItemCL(com.jlboat.phone.activity.DiyPathActivity p1, com.jlboat.phone.activity.DiyPathActivity$1 p2)
    {
        this(p1);
        return;
    }

    public void onClick(int p11, String p12)
    {
        com.jlboat.phone.view.MyPopupWindow v0_0 = this.this$0;
        com.jlboat.phone.view.MyPopupWindow v9 = new com.jlboat.phone.view.MyPopupWindow;
        v9(this.this$0, this.this$0.getResString(2131493085), new StringBuilder().append(this.this$0.getResString(2131493083)).append(p12).append(this.this$0.getResString(2131493082)).toString(), this.this$0.getResString(2131493080), 1, new com.jlboat.phone.activity.DiyPathActivity$BindPointItemCL$1(this, p11), new com.jlboat.phone.activity.DiyPathActivity$BindPointItemCL$2(this));
        com.jlboat.phone.activity.DiyPathActivity.access$3302(v0_0, v9);
        com.jlboat.phone.activity.DiyPathActivity.access$3300(this.this$0).showAtLocation(com.jlboat.phone.activity.DiyPathActivity.access$3000(this.this$0), 17, 0, 0);
        return;
    }
}
