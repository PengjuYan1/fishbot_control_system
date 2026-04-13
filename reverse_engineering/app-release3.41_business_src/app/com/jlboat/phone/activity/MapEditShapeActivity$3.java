package com.jlboat.phone.activity;
 class MapEditShapeActivity$3 implements android.widget.RadioGroup$OnCheckedChangeListener {
    final synthetic com.jlboat.phone.activity.MapEditShapeActivity this$0;

    MapEditShapeActivity$3(com.jlboat.phone.activity.MapEditShapeActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onCheckedChanged(android.widget.RadioGroup p4, int p5)
    {
        this.this$0.linesList.clear();
        this.this$0.ivMark.setVisibility(8);
        this.this$0.ok.setVisibility(8);
        this.this$0.addpoint.setVisibility(8);
        this.this$0.cancel.setVisibility(8);
        this.this$0.llOk.setVisibility(8);
        this.this$0.ivRectangle.setVisibility(8);
        this.this$0.ivRound.setVisibility(8);
        switch (p5) {
            case 2131231130:
                com.jlboat.phone.activity.MapEditShapeActivity.access$102(this.this$0, 0);
                this.this$0.ivMark.setVisibility(0);
                this.this$0.addpoint.setVisibility(0);
                this.this$0.llOk.setVisibility(0);
                break;
            case 2131231141:
                com.jlboat.phone.activity.MapEditShapeActivity.access$102(this.this$0, 1);
                this.this$0.ivRectangle.setVisibility(0);
                this.this$0.llOk.setVisibility(0);
                this.this$0.ok.setVisibility(0);
                break;
            case 2131231142:
                com.jlboat.phone.activity.MapEditShapeActivity.access$102(this.this$0, 2);
                this.this$0.ivRound.setVisibility(0);
                this.this$0.llOk.setVisibility(0);
                this.this$0.ok.setVisibility(0);
                break;
            default:
        }
        return;
    }
}
