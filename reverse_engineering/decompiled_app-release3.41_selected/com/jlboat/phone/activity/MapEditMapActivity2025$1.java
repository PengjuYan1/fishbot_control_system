package com.jlboat.phone.activity;
 class MapEditMapActivity2025$1 extends android.os.Handler {
    final synthetic com.jlboat.phone.activity.MapEditMapActivity2025 this$0;

    MapEditMapActivity2025$1(com.jlboat.phone.activity.MapEditMapActivity2025 p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p5)
    {
        super.handleMessage(p5);
        switch (p5.what) {
            case 2:
                if ((p5.obj instanceof Object[])) {
                    android.os.Handler v0_4 = ((Object[]) p5.obj);
                    if (((v0_4[0] instanceof CharSequence)) && ((v0_4[1] instanceof CharSequence))) {
                        com.jlboat.phone.activity.MapEditMapActivity2025.access$000(this.this$0, ((CharSequence) v0_4[0]), ((CharSequence) v0_4[1]));
                    }
                }
                com.jlboat.phone.activity.MapEditMapActivity2025.access$100(this.this$0).sendEmptyMessageDelayed(31, 30000);
                break;
            case 3:
                com.jlboat.phone.activity.MapEditMapActivity2025.access$200(this.this$0);
                break;
            case 31:
                this.this$0.toast(2131493304);
                com.jlboat.phone.activity.MapEditMapActivity2025.access$200(this.this$0);
                break;
            default:
        }
        return;
    }
}
