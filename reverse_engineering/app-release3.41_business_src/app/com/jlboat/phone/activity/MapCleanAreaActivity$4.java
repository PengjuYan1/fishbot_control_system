package com.jlboat.phone.activity;
 class MapCleanAreaActivity$4 implements android.widget.RadioGroup$OnCheckedChangeListener {
    final synthetic com.jlboat.phone.activity.MapCleanAreaActivity this$0;

    MapCleanAreaActivity$4(com.jlboat.phone.activity.MapCleanAreaActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onCheckedChanged(android.widget.RadioGroup p4, int p5)
    {
        this.this$0.linesList.clear();
        this.this$0.llOk.setVisibility(8);
        this.this$0.ok.setVisibility(8);
        this.this$0.ivCleanRectangle.setVisibility(8);
        switch (p5) {
            case 2131231130:
                com.jlboat.phone.activity.MapCleanAreaActivity.access$302(this.this$0, 0);
                break;
            case 2131231141:
                com.jlboat.phone.activity.MapCleanAreaActivity.access$302(this.this$0, 1);
                this.this$0.ivCleanRectangle.setVisibility(0);
                this.this$0.llOk.setVisibility(0);
                this.this$0.ok.setVisibility(0);
                break;
            case 2131231142:
                com.jlboat.phone.activity.MapCleanAreaActivity.access$302(this.this$0, 2);
                break;
            default:
        }
        return;
    }
}
