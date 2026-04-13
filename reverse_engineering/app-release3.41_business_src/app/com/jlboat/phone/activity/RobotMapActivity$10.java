package com.jlboat.phone.activity;
 class RobotMapActivity$10 implements android.view.View$OnClickListener {
    final synthetic com.jlboat.phone.activity.RobotMapActivity this$0;
    final synthetic android.app.AlertDialog val$alertDialog;
    final synthetic android.widget.EditText val$editFloorText;
    final synthetic android.widget.EditText val$editText;
    final synthetic android.widget.RadioGroup val$radioGroup;
    final synthetic int[] val$selectFloorIndex;

    RobotMapActivity$10(com.jlboat.phone.activity.RobotMapActivity p1, android.widget.EditText p2, android.widget.RadioGroup p3, android.widget.EditText p4, int[] p5, android.app.AlertDialog p6)
    {
        this.this$0 = p1;
        this.val$editFloorText = p2;
        this.val$radioGroup = p3;
        this.val$editText = p4;
        this.val$selectFloorIndex = p5;
        this.val$alertDialog = p6;
        return;
    }

    public void onClick(android.view.View p11)
    {
        String vtmp2 = this.val$editFloorText.getText().toString();
        if ((this.val$radioGroup.getCheckedRadioButtonId() != 2131231123) || (!vtmp2.replace(" ", "").equals(""))) {
            com.jlboat.phone.activity.RobotMapActivity v1_5 = this.val$editText.getText().toString();
            if (!v1_5.replace(" ", "").equals("")) {
                int v2_5 = 0;
                if (this.val$radioGroup.getCheckedRadioButtonId() == 2131231122) {
                    v2_5 = 1;
                }
                if (this.val$radioGroup.getCheckedRadioButtonId() == 2131231123) {
                    v2_5 = 2;
                }
                if (v2_5 == 0) {
                    com.jlboat.phone.activity.RobotMapActivity v3_14 = com.jlboat.phone.activity.RobotMapActivity.access$1000(this.this$0).iterator();
                    while (v3_14.hasNext()) {
                        if (v1_5.equals(((com.boat.support.slam.entity.floors.Maps) v3_14.next()).getMapName())) {
                            this.this$0.toast(2131493284);
                            return;
                        }
                    }
                    com.jlboat.phone.activity.RobotMapActivity.access$2100(this.this$0, v2_5, com.jlboat.phone.activity.RobotMapActivity.access$000(this.this$0), com.jlboat.phone.activity.RobotMapActivity.access$800(this.this$0).getFloorName(), this.val$editText.getText().toString());
                }
                if (v2_5 == 1) {
                    com.jlboat.phone.activity.RobotMapActivity v3_22 = ((com.boat.support.slam.entity.floors.Floors) com.jlboat.phone.activity.RobotMapActivity.access$700(this.this$0).get(this.val$selectFloorIndex[0])).getMaps().iterator();
                    while (v3_22.hasNext()) {
                        if (v1_5.equals(((com.boat.support.slam.entity.floors.Maps) v3_22.next()).getMapName())) {
                            this.this$0.toast(2131493284);
                            return;
                        }
                    }
                    com.jlboat.phone.activity.RobotMapActivity.access$2100(this.this$0, v2_5, ((com.boat.support.slam.entity.floors.Floors) com.jlboat.phone.activity.RobotMapActivity.access$700(this.this$0).get(this.val$selectFloorIndex[0])).getFloorId(), ((com.boat.support.slam.entity.floors.Floors) com.jlboat.phone.activity.RobotMapActivity.access$700(this.this$0).get(this.val$selectFloorIndex[0])).getFloorName(), this.val$editText.getText().toString());
                }
                if (v2_5 == 2) {
                    com.jlboat.phone.activity.RobotMapActivity.access$2100(this.this$0, v2_5, 0, this.val$editFloorText.getText().toString(), this.val$editText.getText().toString());
                }
                this.val$alertDialog.dismiss();
                return;
            } else {
                this.this$0.toast(this.this$0.getResString(2131493283));
                return;
            }
        } else {
            this.this$0.toast(this.this$0.getResString(2131493275));
            return;
        }
    }
}
