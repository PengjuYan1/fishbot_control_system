package com.jlboat.phone.activity;
 class DiyPointPathActivity$3$5 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.DiyPointPathActivity$3 this$1;
    final synthetic android.app.AlertDialog val$alertDialog;
    final synthetic android.widget.EditText val$etSpeedtDialogDppa;
    final synthetic android.widget.EditText val$etWeightDialogDppa;
    final synthetic android.widget.RadioGroup val$rgDirDialogDppa;
    final synthetic long val$shapeId;
    final synthetic android.widget.Spinner val$spLineTypeDialogDppa;

    DiyPointPathActivity$3$5(com.jlboat.phone.activity.DiyPointPathActivity$3 p1, android.widget.RadioGroup p2, android.widget.EditText p3, android.widget.EditText p4, android.app.AlertDialog p5, long p6, android.widget.Spinner p8)
    {
        this.this$1 = p1;
        this.val$rgDirDialogDppa = p2;
        this.val$etSpeedtDialogDppa = p3;
        this.val$etWeightDialogDppa = p4;
        this.val$alertDialog = p5;
        this.val$shapeId = p6;
        this.val$spLineTypeDialogDppa = p8;
        return;
    }

    public void onClick(android.view.View p11)
    {
        int v1_1 = this.val$rgDirDialogDppa.getCheckedRadioButtonId();
        int v2 = 0;
        if (v1_1 == 2131231125) {
            v2 = 1;
        }
        if (v1_1 == 2131231126) {
            v2 = 2;
        }
        try {
            float v8 = Float.parseFloat(new StringBuilder().append(this.val$etSpeedtDialogDppa.getText()).append("").toString());
            float v9 = Float.parseFloat(new StringBuilder().append(this.val$etWeightDialogDppa.getText()).append("").toString());
            this.val$alertDialog.dismiss();
            com.jlboat.phone.activity.DiyPointPathActivity.access$700(this.this$1.this$0, this.val$shapeId, this.val$spLineTypeDialogDppa.getSelectedItemPosition(), v2, v8, v9);
            return;
        } catch (Exception v0) {
            this.this$1.this$0.toast(2131493264);
            return;
        }
    }
}
