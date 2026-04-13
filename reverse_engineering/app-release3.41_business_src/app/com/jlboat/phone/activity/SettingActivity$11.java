package com.jlboat.phone.activity;
 class SettingActivity$11 extends android.os.Handler {
    final synthetic com.jlboat.phone.activity.SettingActivity this$0;

    SettingActivity$11(com.jlboat.phone.activity.SettingActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void handleMessage(android.os.Message p11)
    {
        super.handleMessage(p11);
        switch (p11.what) {
            case 0:
                break;
            case 1:
                if (!(p11.obj instanceof Object[])) {
                } else {
                    android.widget.RadioButton v0_30 = ((Object[]) p11.obj);
                    if ((!(v0_30[0] instanceof CharSequence)) || (!(v0_30[1] instanceof CharSequence))) {
                    } else {
                        com.jlboat.phone.activity.SettingActivity.access$2500(this.this$0, ((CharSequence) v0_30[0]), ((CharSequence) v0_30[1]));
                    }
                }
                break;
            case 2:
                com.jlboat.phone.activity.SettingActivity.access$1100(this.this$0).setChecked(0);
                com.jlboat.phone.activity.SettingActivity.access$1200(this.this$0).setChecked(0);
                com.jlboat.phone.activity.SettingActivity.access$1300(this.this$0).setChecked(0);
                com.jlboat.phone.activity.SettingActivity.access$1400(this.this$0).setChecked(0);
                com.jlboat.phone.activity.SettingActivity.access$1500(this.this$0).setChecked(0);
                com.jlboat.phone.activity.SettingActivity.access$1600(this.this$0).setChecked(0);
                if (com.jlboat.phone.activity.SettingActivity.access$300(this.this$0) != 4) {
                    if (com.jlboat.phone.activity.SettingActivity.access$300(this.this$0) != 5) {
                        if (com.jlboat.phone.activity.SettingActivity.access$300(this.this$0) == 6) {
                            com.jlboat.phone.activity.SettingActivity.access$1600(this.this$0).setChecked(1);
                        }
                    } else {
                        com.jlboat.phone.activity.SettingActivity.access$1500(this.this$0).setChecked(1);
                    }
                } else {
                    com.jlboat.phone.activity.SettingActivity.access$1400(this.this$0).setChecked(1);
                }
                if (com.jlboat.phone.activity.SettingActivity.access$300(this.this$0) != 1) {
                    if (com.jlboat.phone.activity.SettingActivity.access$300(this.this$0) != 2) {
                        if (com.jlboat.phone.activity.SettingActivity.access$300(this.this$0) != 3) {
                        } else {
                            com.jlboat.phone.activity.SettingActivity.access$1300(this.this$0).setChecked(1);
                        }
                    } else {
                        com.jlboat.phone.activity.SettingActivity.access$1200(this.this$0).setChecked(1);
                    }
                } else {
                    com.jlboat.phone.activity.SettingActivity.access$1100(this.this$0).setChecked(1);
                }
                break;
            case 3:
                com.jlboat.phone.activity.SettingActivity.access$2100(this.this$0).setChecked(0);
                com.jlboat.phone.activity.SettingActivity.access$2400(this.this$0).setChecked(0);
                com.jlboat.phone.activity.SettingActivity.access$2200(this.this$0).setChecked(0);
                if (com.jlboat.phone.activity.SettingActivity.access$600(this.this$0) != 0) {
                    if (com.jlboat.phone.activity.SettingActivity.access$600(this.this$0) != 1) {
                        if (com.jlboat.phone.activity.SettingActivity.access$600(this.this$0) != 2) {
                        } else {
                            com.jlboat.phone.activity.SettingActivity.access$2200(this.this$0).setChecked(1);
                        }
                    } else {
                        com.jlboat.phone.activity.SettingActivity.access$2400(this.this$0).setChecked(1);
                    }
                } else {
                    com.jlboat.phone.activity.SettingActivity.access$2100(this.this$0).setChecked(1);
                }
                break;
            case 4:
            case 5:
            default:
                break;
            case 6:
                com.jlboat.phone.activity.SettingActivity.access$1900(this.this$0).setChecked(0);
                com.jlboat.phone.activity.SettingActivity.access$1800(this.this$0).setChecked(0);
                if (com.jlboat.phone.activity.SettingActivity.access$500(this.this$0) != 0) {
                    if (com.jlboat.phone.activity.SettingActivity.access$500(this.this$0) != 1) {
                    } else {
                        com.jlboat.phone.activity.SettingActivity.access$1900(this.this$0).setChecked(1);
                    }
                } else {
                    com.jlboat.phone.activity.SettingActivity.access$1800(this.this$0).setChecked(1);
                }
                break;
        }
        return;
    }
}
