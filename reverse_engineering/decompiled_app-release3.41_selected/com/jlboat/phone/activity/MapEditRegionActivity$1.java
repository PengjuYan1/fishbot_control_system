package com.jlboat.phone.activity;
 class MapEditRegionActivity$1 implements android.text.TextWatcher {
    final synthetic com.jlboat.phone.activity.MapEditRegionActivity this$0;

    MapEditRegionActivity$1(com.jlboat.phone.activity.MapEditRegionActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void afterTextChanged(android.text.Editable p4)
    {
        if (p4.length() > 2) {
            p4.delete(2, p4.length());
        }
        try {
            int v2_3;
            NumberFormatException v1_1 = this.this$0;
        } catch (NumberFormatException v1) {
            com.jlboat.phone.activity.MapEditRegionActivity.access$002(this.this$0, 0);
            if (p4.toString().isEmpty()) {
                p4.append("0");
            }
            com.jlboat.phone.activity.MapEditRegionActivity.access$100(this.this$0);
            return;
        }
        if (!p4.toString().isEmpty()) {
            v2_3 = Integer.parseInt(p4.toString());
        } else {
            v2_3 = 0;
        }
        com.jlboat.phone.activity.MapEditRegionActivity.access$002(v1_1, v2_3);
    }

    public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4)
    {
        return;
    }

    public void onTextChanged(CharSequence p1, int p2, int p3, int p4)
    {
        return;
    }
}
