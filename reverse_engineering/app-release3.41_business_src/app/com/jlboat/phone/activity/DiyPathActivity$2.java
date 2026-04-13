package com.jlboat.phone.activity;
 class DiyPathActivity$2 implements android.widget.RadioGroup$OnCheckedChangeListener {
    final synthetic com.jlboat.phone.activity.DiyPathActivity this$0;

    DiyPathActivity$2(com.jlboat.phone.activity.DiyPathActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onCheckedChanged(android.widget.RadioGroup p4, int p5)
    {
        switch (p5) {
            case 2131231200:
                com.jlboat.phone.activity.DiyPathActivity.access$1600(this.this$0).setVisibility(8);
                com.jlboat.phone.activity.DiyPathActivity.access$1702(this.this$0, 0);
                com.jlboat.phone.activity.DiyPathActivity.access$1800(this.this$0).setDIYLineMode(com.jlboat.phone.activity.DiyPathActivity.access$1700(this.this$0));
                break;
            case 2131231228:
                com.jlboat.phone.activity.DiyPathActivity.access$1600(this.this$0).setVisibility(0);
                com.jlboat.phone.activity.DiyPathActivity.access$1702(this.this$0, 1);
                com.jlboat.phone.activity.DiyPathActivity.access$1800(this.this$0).setDIYLineMode(com.jlboat.phone.activity.DiyPathActivity.access$1700(this.this$0));
                break;
            default:
        }
        return;
    }
}
