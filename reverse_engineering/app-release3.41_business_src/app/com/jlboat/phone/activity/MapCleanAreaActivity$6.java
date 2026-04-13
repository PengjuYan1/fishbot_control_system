package com.jlboat.phone.activity;
 class MapCleanAreaActivity$6 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.MapCleanAreaActivity this$0;
    final synthetic android.app.AlertDialog val$alertDialog;
    final synthetic android.widget.EditText val$editText;

    MapCleanAreaActivity$6(com.jlboat.phone.activity.MapCleanAreaActivity p1, android.widget.EditText p2, android.app.AlertDialog p3)
    {
        this.this$0 = p1;
        this.val$editText = p2;
        this.val$alertDialog = p3;
        return;
    }

    public void onClick(android.view.View p4)
    {
        String v0_2 = this.val$editText.getText().toString();
        if (!v0_2.replace(" ", "").equals("")) {
            com.jlboat.phone.activity.MapCleanAreaActivity.access$1300(this.this$0, v0_2);
            this.val$alertDialog.dismiss();
            return;
        } else {
            this.this$0.toast(2131493255);
            return;
        }
    }
}
