package com.jlboat.phone.activity;
 class RobotMapActivity$8 implements android.widget.RadioGroup$OnCheckedChangeListener {
    final synthetic com.jlboat.phone.activity.RobotMapActivity this$0;
    final synthetic android.widget.EditText val$editFloorText;
    final synthetic android.widget.Spinner val$spinner_floors;

    RobotMapActivity$8(com.jlboat.phone.activity.RobotMapActivity p1, android.widget.Spinner p2, android.widget.EditText p3)
    {
        this.this$0 = p1;
        this.val$spinner_floors = p2;
        this.val$editFloorText = p3;
        return;
    }

    public void onCheckedChanged(android.widget.RadioGroup p4, int p5)
    {
        android.util.Log.d("RobotMapActivity", new StringBuilder().append("mapAdd Dialog onCheckedChanged: i ").append(p5).toString());
        if (p5 == 2131231121) {
            this.val$spinner_floors.setVisibility(8);
            this.val$editFloorText.setVisibility(8);
        }
        if (p5 == 2131231122) {
            this.val$spinner_floors.setVisibility(0);
            this.val$editFloorText.setVisibility(8);
        }
        if (p5 == 2131231123) {
            this.val$spinner_floors.setVisibility(8);
            this.val$editFloorText.setVisibility(0);
        }
        return;
    }
}
