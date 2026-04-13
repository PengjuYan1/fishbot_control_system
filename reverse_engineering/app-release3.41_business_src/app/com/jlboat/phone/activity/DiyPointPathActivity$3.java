package com.jlboat.phone.activity;
 class DiyPointPathActivity$3 implements com.jlboat.phone.adapter.NgLineListAdapter$OnLongClick {
    final synthetic com.jlboat.phone.activity.DiyPointPathActivity this$0;

    DiyPointPathActivity$3(com.jlboat.phone.activity.DiyPointPathActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void longclick(long p23, int p25)
    {
        android.view.View v11 = this.this$0.getLayoutInflater().inflate(2131361850, 0);
        android.app.AlertDialog$Builder v12 = new android.app.AlertDialog$Builder(this.this$0);
        v12.setView(v11);
        android.app.AlertDialog v13 = v12.create();
        android.widget.Spinner v15_1 = ((android.widget.Spinner) v11.findViewById(2131231260));
        android.widget.Spinner v8_2 = ((android.widget.RadioGroup) v11.findViewById(2131231169));
        long v6_2 = ((android.widget.EditText) v11.findViewById(2131230910));
        android.widget.EditText v7_1 = ((android.widget.EditText) v11.findViewById(2131230911));
        android.app.AlertDialog v5_2 = ((android.widget.Button) v11.findViewById(2131230798));
        android.widget.EditText v4_2 = ((android.widget.Button) v11.findViewById(2131230796));
        android.widget.EditText v3_3 = ((android.widget.Button) v11.findViewById(2131230827));
        ((android.widget.TextView) v11.findViewById(2131231342)).setText(new StringBuilder().append("\u8def\u7ebf: ").append(p25).toString());
        v15_1.setSelection(((com.jlboat.phone.bean.NgNline) com.jlboat.phone.activity.DiyPointPathActivity.access$500(this.this$0).get((p25 - 1))).getnLine().getType());
        android.widget.RadioGroup v2_10 = ((com.jlboat.phone.bean.NgNline) com.jlboat.phone.activity.DiyPointPathActivity.access$500(this.this$0).get((p25 - 1))).getnLine().getDirection();
        if (v2_10 == null) {
            v8_2.check(2131231124);
        }
        if (v2_10 == 1) {
            v8_2.check(2131231125);
        }
        if (v2_10 == 2) {
            v8_2.check(2131231126);
        }
        v6_2.setText(new StringBuilder().append(((com.jlboat.phone.bean.NgNline) com.jlboat.phone.activity.DiyPointPathActivity.access$500(this.this$0).get((p25 - 1))).getnLine().getSpeed()).append("").toString());
        android.widget.Button v17 = v3_3;
        v7_1.setText(new StringBuilder().append(((com.jlboat.phone.bean.NgNline) com.jlboat.phone.activity.DiyPointPathActivity.access$500(this.this$0).get((p25 - 1))).getnLine().getWeight()).append("").toString());
        v15_1.setOnItemSelectedListener(new com.jlboat.phone.activity.DiyPointPathActivity$3$1(this));
        v8_2.setOnCheckedChangeListener(new com.jlboat.phone.activity.DiyPointPathActivity$3$2(this));
        v5_2.setOnClickListener(new com.jlboat.phone.activity.DiyPointPathActivity$3$3(this, v13, p23));
        v4_2.setOnClickListener(new com.jlboat.phone.activity.DiyPointPathActivity$3$4(this, v13));
        com.jlboat.phone.activity.DiyPointPathActivity$3 v1_8 = new com.jlboat.phone.activity.DiyPointPathActivity$3$5;
        com.jlboat.phone.activity.DiyPointPathActivity$3$5 v9_1 = v1_8;
        android.widget.Button v10_1 = v17;
        android.widget.EditText v20 = v7_1;
        v1_8(this, v8_2, v6_2, v7_1, v13, p23, v15_1);
        v10_1.setOnClickListener(v9_1);
        v13.show();
        return;
    }
}
