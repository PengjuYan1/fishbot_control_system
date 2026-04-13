package com.jlboat.phone.activity;
 class GrabBagActivity$1$1 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.GrabBagActivity$1 this$1;

    GrabBagActivity$1$1(com.jlboat.phone.activity.GrabBagActivity$1 p1)
    {
        this.this$1 = p1;
        return;
    }

    public void onClick(android.view.View p5)
    {
        com.jlboat.phone.activity.GrabBagActivity.access$100(this.this$1.this$0).setType(1, new StringBuilder().append(System.currentTimeMillis()).append("_").append(com.jlboat.phone.util.Utils.getCTFileName(new java.util.Date())).append(".bag").toString(), com.jlboat.phone.application.BoatSlamApplication.bugTopic);
        com.jlboat.phone.activity.GrabBagActivity.access$000(this.this$1.this$0).dismiss();
        com.jlboat.phone.activity.GrabBagActivity.access$200(this.this$1.this$0).sendEmptyMessage(1);
        this.this$1.this$0.toast(2131493136);
        return;
    }
}
