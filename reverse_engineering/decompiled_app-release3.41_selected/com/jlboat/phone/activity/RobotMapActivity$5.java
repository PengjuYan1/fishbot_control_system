package com.jlboat.phone.activity;
 class RobotMapActivity$5 extends android.os.Handler {
    final synthetic com.jlboat.phone.activity.RobotMapActivity this$0;

    RobotMapActivity$5(com.jlboat.phone.activity.RobotMapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p5)
    {
        super.handleMessage(p5);
        switch (p5.what) {
            case 1:
                com.jlboat.phone.activity.RobotMapActivity.access$1900(this.this$0).setListData(com.jlboat.phone.activity.RobotMapActivity.access$600(this.this$0));
                if ((com.jlboat.phone.activity.RobotMapActivity.access$500(this.this$0) == null) || (com.jlboat.phone.activity.RobotMapActivity.access$900() != 0)) {
                } else {
                    com.jlboat.phone.activity.RobotMapActivity.access$500(this.this$0).setPoints(com.jlboat.phone.activity.RobotMapActivity.access$1100(this.this$0));
                }
                break;
            case 2:
                if ((p5.obj instanceof Object[])) {
                    com.jlboat.phone.view.MapView v0_4 = ((Object[]) p5.obj);
                    if (((v0_4[0] instanceof CharSequence)) && ((v0_4[1] instanceof CharSequence))) {
                        com.jlboat.phone.activity.RobotMapActivity.access$2000(this.this$0, ((CharSequence) v0_4[0]), ((CharSequence) v0_4[1]));
                    }
                }
                com.jlboat.phone.activity.RobotMapActivity.access$1300(this.this$0).sendEmptyMessageDelayed(31, 30000);
                break;
            case 3:
                com.jlboat.phone.activity.RobotMapActivity.access$400(this.this$0);
                break;
            case 4:
                break;
            case 31:
                this.this$0.toast(2131493304);
                com.jlboat.phone.activity.RobotMapActivity.access$400(this.this$0);
                break;
            default:
                throw new IllegalStateException(new StringBuilder().append("Unexpected value: ").append(p5.what).toString());
        }
        return;
    }
}
