package com.jlboat.phone.activity;
 class BasicSettingActivity$2 extends android.os.Handler {
    final synthetic com.jlboat.phone.activity.BasicSettingActivity this$0;

    BasicSettingActivity$2(com.jlboat.phone.activity.BasicSettingActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p5)
    {
        super.handleMessage(p5);
        switch (p5.what) {
            case 0:
                com.jlboat.phone.activity.BasicSettingActivity.access$2200(this.this$0);
                break;
            case 1:
                com.jlboat.phone.activity.BasicSettingActivity.access$1400(this.this$0).data(com.jlboat.phone.activity.BasicSettingActivity.access$500(this.this$0));
                com.jlboat.phone.activity.BasicSettingActivity.access$1500(this.this$0).data(com.jlboat.phone.activity.BasicSettingActivity.access$600(this.this$0));
                com.jlboat.phone.activity.BasicSettingActivity.access$1600(this.this$0).date(com.jlboat.phone.activity.BasicSettingActivity.access$700(this.this$0));
                com.jlboat.phone.activity.BasicSettingActivity.access$1700(this.this$0).data(com.jlboat.phone.activity.BasicSettingActivity.access$800(this.this$0));
                com.jlboat.phone.activity.BasicSettingActivity.access$1800(this.this$0).data(com.jlboat.phone.activity.BasicSettingActivity.access$900(this.this$0));
                com.jlboat.phone.activity.BasicSettingActivity.access$1900(this.this$0).data(com.jlboat.phone.activity.BasicSettingActivity.access$1000(this.this$0));
                com.jlboat.phone.activity.BasicSettingActivity.access$2000(this.this$0).data(com.jlboat.phone.activity.BasicSettingActivity.access$1100(this.this$0));
                break;
            case 2:
            case 3:
            default:
                break;
            case 4:
                if (!(p5.obj instanceof Object[])) {
                } else {
                    Object[] v0_18 = ((Object[]) p5.obj);
                    if ((!(v0_18[0] instanceof CharSequence)) || (!(v0_18[1] instanceof CharSequence))) {
                    } else {
                        com.jlboat.phone.activity.BasicSettingActivity.access$2100(this.this$0, ((CharSequence) v0_18[0]), ((CharSequence) v0_18[1]));
                    }
                }
                break;
        }
        return;
    }
}
