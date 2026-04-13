package com.jlboat.phone;
 class LoginActivity$1 extends android.content.BroadcastReceiver {
    final synthetic com.jlboat.phone.LoginActivity this$0;

    LoginActivity$1(com.jlboat.phone.LoginActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public void onReceive(android.content.Context p7, android.content.Intent p8)
    {
        if (p8 != null) {
            String v0 = p8.getAction();
            if (v0 != null) {
                com.jlboat.phone.LoginActivity v1_11;
                android.util.Log.d("LoginActivity", new StringBuilder().append("onReceive: \u6536\u5230 ").append(v0).toString());
                switch (v0.hashCode()) {
                    case -1747645096:
                        if (!v0.equals("login_succ")) {
                            v1_11 = -1;
                        } else {
                            v1_11 = 0;
                        }
                        break;
                    case 2022760137:
                        if (!v0.equals("login_re")) {
                        } else {
                            v1_11 = 1;
                        }
                        break;
                    default:
                }
                switch (v1_11) {
                    case 0:
                        this.this$0.isConnecting = 0;
                        if (this.this$0.actionCode != 1) {
                            if (this.this$0.actionCode != 11) {
                                if (this.this$0.actionCode != 111) {
                                    if (this.this$0.actionCode != 112) {
                                        if (this.this$0.actionCode != 113) {
                                            if (this.this$0.actionCode != 114) {
                                                if (this.this$0.actionCode != 115) {
                                                    if (this.this$0.actionCode != 116) {
                                                        if (this.this$0.actionCode != 117) {
                                                            this.this$0.startActivity(new android.content.Intent(this.this$0.mContext, com.jlboat.phone.MainActivity));
                                                        } else {
                                                            this.this$0.startActivity(new android.content.Intent(this.this$0.mContext, com.jlboat.phone.activity.DiyPointPathActivity));
                                                        }
                                                    } else {
                                                        this.this$0.startActivity(new android.content.Intent(this.this$0.mContext, com.jlboat.phone.activity.MapRepositionActivity));
                                                    }
                                                } else {
                                                    this.this$0.startActivity(new android.content.Intent(this.this$0.mContext, com.jlboat.phone.activity.MapExpansionActivity));
                                                }
                                            } else {
                                                this.this$0.startActivity(new android.content.Intent(this.this$0.mContext, com.jlboat.phone.activity.MapActivity).putExtra("isCreate", 1));
                                            }
                                        } else {
                                            this.this$0.startActivity(new android.content.Intent(this.this$0.mContext, com.jlboat.phone.activity.MapEditRegionActivity));
                                        }
                                    } else {
                                        this.this$0.startActivity(new android.content.Intent(this.this$0.mContext, com.jlboat.phone.activity.MapEditShapeActivity));
                                    }
                                } else {
                                    this.this$0.startActivity(new android.content.Intent(this.this$0.mContext, com.jlboat.phone.activity.MapEditMapActivity2025));
                                }
                            } else {
                                this.this$0.startActivity(new android.content.Intent(this.this$0.mContext, com.jlboat.phone.activity.MapEditActivity));
                            }
                        } else {
                            this.this$0.startActivity(new android.content.Intent(this.this$0.mContext, com.jlboat.phone.activity.MapActivity));
                        }
                        break;
                    case 1:
                        android.util.Log.d("LoginActivity", "onReceive: \u6536\u5230");
                        this.this$0.isConnecting = 0;
                        this.this$0.toast(2131493272);
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
