package com.jlboat.phone.activity;
 class MapExpansionActivity$6 extends android.os.Handler {
    final synthetic com.jlboat.phone.activity.MapExpansionActivity this$0;

    MapExpansionActivity$6(com.jlboat.phone.activity.MapExpansionActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p5)
    {
        super.handleMessage(p5);
        switch (p5.what) {
            case 1:
                com.jlboat.phone.activity.MapExpansionActivity.access$2200(this.this$0).setListData(com.jlboat.phone.activity.MapExpansionActivity.access$600(this.this$0));
                com.jlboat.phone.activity.MapExpansionActivity.access$2300(this.this$0).setListData(com.jlboat.phone.activity.MapExpansionActivity.access$600(this.this$0));
                break;
            case 2:
                if ((p5.obj instanceof Object[])) {
                    android.os.Handler v0_6 = ((Object[]) p5.obj);
                    if (((v0_6[0] instanceof CharSequence)) && ((v0_6[1] instanceof CharSequence))) {
                        com.jlboat.phone.activity.MapExpansionActivity.access$2400(this.this$0, ((CharSequence) v0_6[0]), ((CharSequence) v0_6[1]));
                    }
                }
                com.jlboat.phone.activity.MapExpansionActivity.access$1300(this.this$0).sendEmptyMessageDelayed(31, 30000);
                break;
            case 3:
                com.jlboat.phone.activity.MapExpansionActivity.access$400(this.this$0);
                break;
            case 4:
                com.jlboat.phone.activity.MapExpansionActivity.access$2300(this.this$0).setListData(com.jlboat.phone.activity.MapExpansionActivity.access$600(this.this$0));
                break;
            case 31:
                this.this$0.toast(2131493304);
                com.jlboat.phone.activity.MapExpansionActivity.access$400(this.this$0);
                break;
            default:
                throw new IllegalStateException(new StringBuilder().append("Unexpected value: ").append(p5.what).toString());
        }
        return;
    }
}
