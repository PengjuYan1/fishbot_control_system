package com.jlboat.phone.activity;
 class MapActivity$10 extends android.os.Handler {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;

    MapActivity$10(com.jlboat.phone.activity.MapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p9)
    {
        super.handleMessage(p9);
        switch (p9.what) {
            case 1:
                com.jlboat.phone.activity.MapActivity.access$3500(this.this$0).setListData(com.jlboat.phone.activity.MapActivity.access$1200(this.this$0));
                com.jlboat.phone.activity.MapActivity.access$3600(this.this$0).setListData(com.jlboat.phone.activity.MapActivity.access$1200(this.this$0));
                if ((com.jlboat.phone.activity.MapActivity.access$900(this.this$0) == null) || (com.jlboat.phone.activity.MapActivity.access$800(this.this$0) != 0)) {
                } else {
                    com.jlboat.phone.activity.MapActivity.access$900(this.this$0).setPoints(com.jlboat.phone.activity.MapActivity.access$1800(this.this$0));
                }
                break;
            case 2:
                if ((p9.obj instanceof Object[])) {
                    android.os.Handler v0_27 = ((Object[]) p9.obj);
                    if (((v0_27[0] instanceof CharSequence)) && ((v0_27[1] instanceof CharSequence))) {
                        com.jlboat.phone.activity.MapActivity.access$3700(this.this$0, ((CharSequence) v0_27[0]), ((CharSequence) v0_27[1]));
                    }
                }
                com.jlboat.phone.activity.MapActivity.access$2000(this.this$0).sendEmptyMessageDelayed(31, 30000);
                break;
            case 3:
                com.jlboat.phone.activity.MapActivity.access$600(this.this$0);
                break;
            case 4:
                com.jlboat.phone.activity.MapActivity.access$3600(this.this$0).setListData(com.jlboat.phone.activity.MapActivity.access$1200(this.this$0));
                break;
            case 5:
                if (com.jlboat.phone.activity.MapActivity.access$2700(this.this$0)) {
                    if ((System.currentTimeMillis() - com.jlboat.phone.activity.MapActivity.access$2600(this.this$0)) >= 2000) {
                        com.jlboat.phone.activity.MapActivity.access$3400(this.this$0).setText(new StringBuilder().append(this.this$0.getResString(2131493095)).append(" \u6b63\u5728\u524d\u5f80 ").toString());
                    }
                    com.jlboat.phone.activity.MapActivity.access$2000(this.this$0).postDelayed(new com.jlboat.phone.activity.MapActivity$10$1(this), 1000);
                } else {
                }
                break;
            case 11:
                com.jlboat.phone.activity.MapActivity.access$2000(this.this$0).sendEmptyMessageDelayed(11, 1000);
                break;
            case 12:
                com.jlboat.phone.activity.MapActivity.access$2000(this.this$0).sendEmptyMessageDelayed(12, 100);
                break;
            case 31:
                this.this$0.toast(2131493304);
                com.jlboat.phone.activity.MapActivity.access$600(this.this$0);
                break;
            default:
                throw new IllegalStateException(new StringBuilder().append("Unexpected value: ").append(p9.what).toString());
        }
        return;
    }
}
