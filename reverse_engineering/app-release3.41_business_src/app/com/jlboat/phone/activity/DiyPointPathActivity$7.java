package com.jlboat.phone.activity;
 class DiyPointPathActivity$7 implements android.widget.CompoundButton$OnCheckedChangeListener {
    final synthetic com.jlboat.phone.activity.DiyPointPathActivity this$0;

    DiyPointPathActivity$7(com.jlboat.phone.activity.DiyPointPathActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onCheckedChanged(android.widget.CompoundButton p3, boolean p4)
    {
        java.util.List v1_2;
        android.util.Log.d("DiyPointPathActivity", new StringBuilder().append("onCheckedChanged: 111 ").append(p4).toString());
        com.jlboat.phone.activity.DiyPointPathActivity.access$400(this.this$0).setShowDiYP(p4);
        com.jlboat.phone.adapter.NaviListAdapter v0_5 = com.jlboat.phone.activity.DiyPointPathActivity.access$300(this.this$0);
        java.util.List v1_0 = this.this$0;
        if (!p4) {
            v1_2 = com.jlboat.phone.activity.DiyPointPathActivity.access$200(v1_0);
        } else {
            v1_2 = com.jlboat.phone.activity.DiyPointPathActivity.access$100(v1_0);
        }
        v0_5.setListData(v1_2);
        return;
    }
}
