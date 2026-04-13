package com.jlboat.phone.activity;
 class DiyPointPathActivity$3$3 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.DiyPointPathActivity$3 this$1;
    final synthetic android.app.AlertDialog val$alertDialog;
    final synthetic long val$shapeId;

    DiyPointPathActivity$3$3(com.jlboat.phone.activity.DiyPointPathActivity$3 p1, android.app.AlertDialog p2, long p3)
    {
        this.this$1 = p1;
        this.val$alertDialog = p2;
        this.val$shapeId = p3;
        return;
    }

    public void onClick(android.view.View p4)
    {
        this.val$alertDialog.dismiss();
        com.jlboat.phone.activity.DiyPointPathActivity.access$600(this.this$1.this$0, this.val$shapeId);
        return;
    }
}
