package com.jlboat.phone.activity;
 class DiyPointPathActivity$4$2 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.DiyPointPathActivity$4 this$1;
    final synthetic android.app.AlertDialog val$alertDialog;
    final synthetic android.widget.EditText val$editTextangle;
    final synthetic android.widget.EditText val$editTextcler;
    final synthetic int val$position;

    DiyPointPathActivity$4$2(com.jlboat.phone.activity.DiyPointPathActivity$4 p1, android.widget.EditText p2, android.widget.EditText p3, int p4, android.app.AlertDialog p5)
    {
        this.this$1 = p1;
        this.val$editTextcler = p2;
        this.val$editTextangle = p3;
        this.val$position = p4;
        this.val$alertDialog = p5;
        return;
    }

    public void onClick(android.view.View p23)
    {
        String v15 = this.val$editTextcler.getText().toString();
        double v13_0 = this.val$editTextangle.getText().toString();
        android.util.Log.d("DiyPointPathActivity", new StringBuilder().append("onClick: \u8f93\u5165\u7684\u540d\u5b57 ").append(v15).toString());
        if (v15.replace(" ", "").equals("")) {
            String v2 = v15;
        } else {
            if (!v13_0.replace(" ", "").equals("")) {
                try {
                    double v10 = this.this$1.this$0.degreeToRadian(Double.parseDouble(v13_0));
                } catch (android.app.AlertDialog v0) {
                    v2 = v15;
                    this.this$1.this$0.toast(2131493265);
                    return;
                }
                if (!com.jlboat.phone.activity.DiyPointPathActivity.access$000(this.this$1.this$0).isChecked()) {
                    com.jlboat.phone.activity.DiyPointPathActivity.access$1100(this.this$1.this$0, ((double) ((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.activity.DiyPointPathActivity.access$200(this.this$1.this$0).get(this.val$position)).getPointId()), v15, ((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.activity.DiyPointPathActivity.access$200(this.this$1.this$0).get(this.val$position)).getPositionX(), ((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.activity.DiyPointPathActivity.access$200(this.this$1.this$0).get(this.val$position)).getPositionY(), v10);
                } else {
                    com.jlboat.phone.activity.DiyPointPathActivity.access$1100(this.this$1.this$0, ((double) ((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.activity.DiyPointPathActivity.access$100(this.this$1.this$0).get(this.val$position)).getPointId()), v15, ((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.activity.DiyPointPathActivity.access$100(this.this$1.this$0).get(this.val$position)).getPositionX(), ((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.activity.DiyPointPathActivity.access$100(this.this$1.this$0).get(this.val$position)).getPositionY(), v10);
                    v2 = v15;
                }
                this.val$alertDialog.cancel();
                return;
            } else {
                v2 = v15;
            }
        }
        this.this$1.this$0.toast(2131493267);
        return;
    }
}
