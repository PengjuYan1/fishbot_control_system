package com.jlboat.phone.base;
 class BaseFullActivity$3 extends android.content.BroadcastReceiver {
    final synthetic com.jlboat.phone.base.BaseFullActivity this$0;

    BaseFullActivity$3(com.jlboat.phone.base.BaseFullActivity p1)
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
                    case -1361636432:
                        if (!v0.equals("change")) {
                            v1_0 = -1;
                        } else {
                            v1_0 = 1;
                        }
                        break;
                    case -92976154:
                        if (!v0.equals("WIFICONNECTED_STATE")) {
                        } else {
                            v1_0 = 3;
                        }
                        break;
                    case 3539835:
                        if (!v0.equals("ssid")) {
                        } else {
                            v1_0 = 2;
                        }
                        break;
                    case 70687340:
                        if (!v0.equals("ERRMSG_UPDATE")) {
                        } else {
                            v1_0 = 4;
                        }
                        break;
                    case 106858757:
                        if (!v0.equals("power")) {
                        } else {
                            v1_0 = 0;
                        }
                        break;
                    default:
                }
                switch (v1_0) {
                    case 0:
                    case 1:
                    case 2:
                        com.jlboat.phone.base.BaseFullActivity.access$200(this.this$0);
                        break;
                    case 3:
                        break;
                    case 4:
                        com.jlboat.phone.base.BaseFullActivity.access$300(this.this$0);
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
