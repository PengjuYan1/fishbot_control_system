package com.jlboat.phone.activity;
 class DiyPathActivity$12 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.DiyPathActivity this$0;
    final synthetic android.app.AlertDialog val$alertDialog;
    final synthetic android.widget.EditText val$et;
    final synthetic com.boat.support.slam.entity.floors.GlobalPlans val$globalPlans;

    DiyPathActivity$12(com.jlboat.phone.activity.DiyPathActivity p1, android.widget.EditText p2, com.boat.support.slam.entity.floors.GlobalPlans p3, android.app.AlertDialog p4)
    {
        this.this$0 = p1;
        this.val$et = p2;
        this.val$globalPlans = p3;
        this.val$alertDialog = p4;
        return;
    }

    public void onClick(android.view.View p9)
    {
        String v0_2 = this.val$et.getText().toString();
        android.util.Log.d("DiyPathActivity", new StringBuilder().append("onClick: \u8f93\u5165\u7684\u540d\u5b57 ").append(v0_2).toString());
        if (!v0_2.replace(" ", "").trim().equals("")) {
            com.jlboat.phone.activity.DiyPathActivity v1_8 = com.jlboat.phone.activity.DiyPathActivity.access$400(this.this$0).iterator();
            while (v1_8.hasNext()) {
                com.boat.support.slam.entity.floors.GlobalPlans v2_5 = ((com.boat.support.slam.entity.floors.GlobalPlans) v1_8.next());
                if ((v0_2.equals(v2_5.getGlobalplanName())) && (v2_5.getGlobalplanId() != this.val$globalPlans.getGlobalplanId())) {
                    this.this$0.toast(2131493260);
                    return;
                }
            }
            com.jlboat.phone.activity.DiyPathActivity.access$3200(this.this$0, this.val$globalPlans, v0_2, com.jlboat.phone.activity.DiyPathActivity.access$3100(this.this$0));
            this.val$alertDialog.dismiss();
            return;
        } else {
            this.this$0.toast(2131493261);
            return;
        }
    }
}
