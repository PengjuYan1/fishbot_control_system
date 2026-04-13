package com.jlboat.phone.base;
 class BaseFullActivity$2 extends android.content.BroadcastReceiver {
    final synthetic com.jlboat.phone.base.BaseFullActivity this$0;

    BaseFullActivity$2(com.jlboat.phone.base.BaseFullActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onReceive(android.content.Context p3, android.content.Intent p4)
    {
        if (p4 != null) {
            String v0 = p4.getAction();
            if (v0 != null) {
                com.jlboat.phone.base.BaseFullActivity v1_0;
                switch (v0.hashCode()) {
                    case 2104391859:
                        if (!v0.equals("Finish")) {
                            v1_0 = -1;
                        } else {
                            v1_0 = 0;
                        }
                        break;
                    default:
                }
                switch (v1_0) {
                    case 0:
                        this.this$0.finish();
                        break;
                    default:
                }
                return;
            } else {
                return;
            }
        } else {
            return;
        }
    }
}
