package com.jlboat.phone.activity;
 class DiyPointPathActivity$4 implements com.jlboat.phone.adapter.NaviListAdapter$OnClick {
    final synthetic com.jlboat.phone.activity.DiyPointPathActivity this$0;

    DiyPointPathActivity$4(com.jlboat.phone.activity.DiyPointPathActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void longclick(android.view.View p21)
    {
        com.jlboat.phone.activity.DiyPointPathActivity$4$3 v0_52;
        int v7 = ((Integer) p21.getTag()).intValue();
        com.jlboat.phone.activity.DiyPointPathActivity$4$2 v8_0 = this.this$0.getLayoutInflater().inflate(2131361843, 0);
        android.widget.TextView v9_1 = ((android.widget.TextView) v8_0.findViewById(2131231328));
        android.widget.EditText v10_1 = ((android.widget.EditText) v8_0.findViewById(2131230904));
        android.widget.EditText v11_1 = ((android.widget.EditText) v8_0.findViewById(2131230891));
        android.widget.Button v12_1 = ((android.widget.Button) v8_0.findViewById(2131230801));
        android.widget.Button v13_1 = ((android.widget.Button) v8_0.findViewById(2131230803));
        android.widget.Button v14_1 = ((android.widget.Button) v8_0.findViewById(2131230799));
        v12_1.setVisibility(8);
        if (!com.jlboat.phone.activity.DiyPointPathActivity.access$000(this.this$0).isChecked()) {
            v0_52 = ((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.activity.DiyPointPathActivity.access$200(this.this$0).get(v7)).getPointName();
        } else {
            if (!((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.activity.DiyPointPathActivity.access$100(this.this$0).get(v7)).getPointName().equals(com.jlboat.phone.application.BoatSlamApplication.CANCLEPOINTNAME)) {
                v0_52 = ((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.activity.DiyPointPathActivity.access$100(this.this$0).get(v7)).getPointName();
            } else {
                v0_52 = new StringBuilder().append(((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.activity.DiyPointPathActivity.access$100(this.this$0).get(v7)).getPointId()).append("").toString();
            }
        }
        v9_1.setText(v0_52);
        v10_1.setHint(this.this$0.getResString(2131493039));
        v11_1.setHint(this.this$0.getResString(2131493038));
        if (!((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.activity.DiyPointPathActivity.access$100(this.this$0).get(v7)).getPointName().equals(com.jlboat.phone.application.BoatSlamApplication.CANCLEPOINTNAME)) {
            v10_1.setText(((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.activity.DiyPointPathActivity.access$100(this.this$0).get(v7)).getPointName());
        }
        v11_1.setText(new StringBuilder().append(((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.activity.DiyPointPathActivity.access$100(this.this$0).get(v7)).getPositionYaw()).append("").toString());
        android.app.AlertDialog$Builder v15 = new android.app.AlertDialog$Builder(this.this$0);
        v15.setView(v8_0);
        android.widget.EditText v3_0 = v15.create();
        v12_1.setOnClickListener(new com.jlboat.phone.activity.DiyPointPathActivity$4$1(this));
        android.widget.EditText v2_3 = new com.jlboat.phone.activity.DiyPointPathActivity$4$2;
        com.jlboat.phone.activity.DiyPointPathActivity$4$2 v8_1 = v2_3;
        android.app.AlertDialog v17 = v3_0;
        v2_3(this, v10_1, v11_1, v7, v17);
        v13_1.setOnClickListener(v8_1);
        android.app.AlertDialog v1_2 = v17;
        v14_1.setOnClickListener(new com.jlboat.phone.activity.DiyPointPathActivity$4$3(this, v1_2));
        v1_2.show();
        return;
    }

    public void onClick(android.view.View p6)
    {
        if (!com.jlboat.phone.activity.DiyPointPathActivity.access$000(this.this$0).isChecked()) {
            com.jlboat.phone.activity.DiyPointPathActivity.access$1000(this.this$0, com.jlboat.phone.activity.DiyPointPathActivity.access$800(this.this$0), com.jlboat.phone.activity.DiyPointPathActivity.access$900(this.this$0), ((com.boat.support.slam.entity.floors.Points) com.jlboat.phone.activity.DiyPointPathActivity.access$200(this.this$0).get(((Integer) p6.getTag()).intValue())));
        }
        return;
    }
}
