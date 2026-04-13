package com.jlboat.phone.activity;
 class MapActivity$1 implements com.jlboat.phone.adapter.RvFloorMapListAdapter$OnClick {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;

    MapActivity$1(com.jlboat.phone.activity.MapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void click(android.view.View p16, com.boat.support.slam.entity.floors.Floors p17, com.boat.support.slam.entity.floors.Maps p18)
    {
        if ((p17.getFloorId() != com.jlboat.phone.activity.MapActivity.access$000(this.this$0)) || (p18.getMapId() != com.jlboat.phone.activity.MapActivity.access$100(this.this$0))) {
            android.app.AlertDialog$Builder v7 = new android.app.AlertDialog$Builder(this.this$0);
            android.view.View v8 = this.this$0.getLayoutInflater().inflate(2131361847, 0);
            android.widget.RadioGroup v10_1 = ((android.widget.RadioGroup) v8.findViewById(2131231167));
            android.widget.Button v11_1 = ((android.widget.Button) v8.findViewById(2131230802));
            android.widget.Button v12_1 = ((android.widget.Button) v8.findViewById(2131230799));
            ((android.widget.TextView) v8.findViewById(2131231328)).setText(new StringBuilder().append(this.this$0.getResString(2131492986)).append("?\n").append(this.this$0.getResString(2131492995)).append(p17.getFloorName()).append("\n").append(this.this$0.getResString(2131493002)).append(p18.getMapName()).toString());
            v7.setView(v8);
            android.app.AlertDialog v13 = v7.create();
            v10_1.check(2131231119);
            if (p17.getFloorId() == com.jlboat.phone.activity.MapActivity.access$000(this.this$0)) {
                v10_1.setEnabled(0);
                int v2_3 = 0;
                while (v2_3 < v10_1.getChildCount()) {
                    android.view.View v3_1 = v10_1.getChildAt(v2_3);
                    if (v3_1.getId() != 2131231119) {
                        v3_1.setEnabled(0);
                    }
                    v2_3++;
                }
            }
            com.jlboat.phone.activity.MapActivity$1$1 v14 = new com.jlboat.phone.activity.MapActivity$1$1;
            v14(this, v10_1, p17, p18, v13);
            v11_1.setOnClickListener(v14);
            v12_1.setOnClickListener(new com.jlboat.phone.activity.MapActivity$1$2(this, v13));
            v13.show();
            return;
        } else {
            return;
        }
    }

    public void longlick(android.view.View p3, com.boat.support.slam.entity.floors.Floors p4, com.boat.support.slam.entity.floors.Maps p5)
    {
        android.util.Log.d("MapActivity", "longlick: maplist");
        if (p5 == null) {
            this.this$0.FloorAndDeleteorRename(p4);
        }
        this.this$0.MapAndDeleteorRename(p4, p5);
        return;
    }
}
