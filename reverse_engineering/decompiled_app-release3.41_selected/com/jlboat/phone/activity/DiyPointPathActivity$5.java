package com.jlboat.phone.activity;
 class DiyPointPathActivity$5 implements android.widget.RadioGroup$OnCheckedChangeListener {
    final synthetic com.jlboat.phone.activity.DiyPointPathActivity this$0;

    DiyPointPathActivity$5(com.jlboat.phone.activity.DiyPointPathActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onCheckedChanged(android.widget.RadioGroup p4, int p5)
    {
        switch (p5) {
            case 2131231201:
                com.jlboat.phone.activity.DiyPointPathActivity.access$1200(this.this$0).setVisibility(8);
                com.jlboat.phone.activity.DiyPointPathActivity.access$1302(this.this$0, 0);
                com.jlboat.phone.activity.DiyPointPathActivity.access$400(this.this$0).setDIYLineMode(com.jlboat.phone.activity.DiyPointPathActivity.access$1300(this.this$0));
                break;
            case 2131231229:
                com.jlboat.phone.activity.DiyPointPathActivity.access$1200(this.this$0).setVisibility(0);
                com.jlboat.phone.activity.DiyPointPathActivity.access$1302(this.this$0, 1);
                com.jlboat.phone.activity.DiyPointPathActivity.access$400(this.this$0).setDIYLineMode(com.jlboat.phone.activity.DiyPointPathActivity.access$1300(this.this$0));
                break;
            default:
        }
        return;
    }
}
