package com.jlboat.phone.activity;
 class DiyPointPathActivity$14 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.DiyPointPathActivity this$0;
    final synthetic android.app.AlertDialog val$alertDialog;
    final synthetic android.widget.EditText val$etSpeedtDialogDppa;
    final synthetic android.widget.EditText val$etWeightDialogDppa;
    final synthetic android.widget.RadioGroup val$rgDirDialogDppa;
    final synthetic android.widget.Spinner val$spLineTypeDialogDppa;

    DiyPointPathActivity$14(com.jlboat.phone.activity.DiyPointPathActivity p1, android.widget.RadioGroup p2, android.widget.EditText p3, android.widget.EditText p4, android.widget.Spinner p5, android.app.AlertDialog p6)
    {
        this.this$0 = p1;
        this.val$rgDirDialogDppa = p2;
        this.val$etSpeedtDialogDppa = p3;
        this.val$etWeightDialogDppa = p4;
        this.val$spLineTypeDialogDppa = p5;
        this.val$alertDialog = p6;
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
            com.jlboat.phone.activity.DiyPointPathActivity v3_7 = Float.parseFloat(new StringBuilder().append(this.val$etSpeedtDialogDppa.getText()).append("").toString());
            int v4_8 = Float.parseFloat(new StringBuilder().append(this.val$etWeightDialogDppa.getText()).append("").toString());
            com.jlboat.phone.message.map_msgs.Config v5_3 = new com.jlboat.phone.message.map_msgs.Config();
            v5_3.setType(1);
            v5_3.setConfigName("ng_path_df_type");
            v5_3.setConfigValue(new StringBuilder().append(this.val$spLineTypeDialogDppa.getSelectedItemPosition()).append("").toString());
            com.jlboat.phone.message.map_msgs.Config v7_7 = new com.jlboat.phone.message.map_msgs.Config();
            v7_7.setType(1);
            v7_7.setConfigName("ng_path_df_direction");
            v7_7.setConfigValue(new StringBuilder().append(v2).append("").toString());
            com.jlboat.phone.message.map_msgs.Config v8_9 = new com.jlboat.phone.message.map_msgs.Config();
            v8_9.setType(1);
            v8_9.setConfigName("ng_path_df_speed");
            v8_9.setConfigValue(new StringBuilder().append(v3_7).append("").toString());
            com.jlboat.phone.message.map_msgs.Config v9_7 = new com.jlboat.phone.message.map_msgs.Config();
            v9_7.setType(1);
            v9_7.setConfigName("ng_path_df_weight");
            v9_7.setConfigValue(new StringBuilder().append(v4_8).append("").toString());
            Exception v0_2 = new java.util.LinkedList();
            v0_2.add(v5_3);
            v0_2.add(v7_7);
            v0_2.add(v8_9);
            v0_2.add(v9_7);
            com.jlboat.phone.activity.DiyPointPathActivity.access$2600(this.this$0, v0_2);
            this.val$alertDialog.dismiss();
            return;
        } catch (Exception v0) {
            this.this$0.toast(2131493264);
            return;
        }
    }
}
