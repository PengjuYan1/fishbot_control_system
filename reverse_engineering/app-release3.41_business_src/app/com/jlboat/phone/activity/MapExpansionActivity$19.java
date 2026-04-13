package com.jlboat.phone.activity;
 class MapExpansionActivity$19 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.MapExpansionActivity this$0;
    final synthetic android.app.AlertDialog val$alertDialog;
    final synthetic android.widget.EditText val$editText;

    MapExpansionActivity$19(com.jlboat.phone.activity.MapExpansionActivity p1, android.widget.EditText p2, android.app.AlertDialog p3)
    {
        this.this$0 = p1;
        this.val$editText = p2;
        this.val$alertDialog = p3;
        return;
    }

    public void onClick(android.view.View p6)
    {
        String v0_2 = this.val$editText.getText().toString();
        if (!v0_2.replace(" ", "").equals("")) {
            com.jlboat.phone.activity.MapExpansionActivity v1_3 = com.jlboat.phone.activity.MapExpansionActivity.access$1600(this.this$0).iterator();
            while (v1_3.hasNext()) {
                if (v0_2.equals(((com.boat.support.slam.entity.floors.Points) v1_3.next()).getPointName())) {
                    this.this$0.toast(2131493287);
                    return;
                }
            }
            com.jlboat.phone.activity.MapExpansionActivity.access$2800(this.this$0, 0, this.val$editText.getText().toString());
            this.val$alertDialog.dismiss();
            return;
        } else {
            this.this$0.toast(this.this$0.getResString(2131493286));
            return;
        }
    }
}
