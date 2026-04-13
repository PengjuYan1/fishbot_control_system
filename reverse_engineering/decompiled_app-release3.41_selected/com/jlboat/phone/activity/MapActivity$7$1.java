package com.jlboat.phone.activity;
 class MapActivity$7$1 implements java.lang.Runnable {
    final synthetic com.jlboat.phone.activity.MapActivity$7 this$1;
    final synthetic String val$finalMsg;
    final synthetic int val$s;

    MapActivity$7$1(com.jlboat.phone.activity.MapActivity$7 p1, int p2, String p3)
    {
        this.this$1 = p1;
        this.val$s = p2;
        this.val$finalMsg = p3;
        return;
    }

    public void run()
    {
        if (8 == com.jlboat.phone.activity.MapActivity.access$2900(this.this$1.this$0).getVisibility()) {
            com.jlboat.phone.activity.MapActivity.access$3000(this.this$1.this$0).setVisibility(0);
        }
        switch (this.val$s) {
            case 2:
            case 83:
                com.jlboat.phone.activity.MapActivity.access$3100(this.this$1.this$0).setVisibility(8);
                com.jlboat.phone.activity.MapActivity.access$3200(this.this$1.this$0).setVisibility(8);
                com.jlboat.phone.activity.MapActivity.access$400(this.this$1.this$0).setVisibility(8);
                break;
            case 85:
            case 86:
            case 87:
                com.jlboat.phone.activity.MapActivity.access$3100(this.this$1.this$0).setVisibility(8);
                com.jlboat.phone.activity.MapActivity.access$3200(this.this$1.this$0).setVisibility(8);
                com.jlboat.phone.activity.MapActivity.access$400(this.this$1.this$0).setVisibility(8);
                com.jlboat.phone.activity.MapActivity.access$3300(this.this$1.this$0).setVisibility(8);
                break;
            default:
        }
        if ((this.val$s != 2) && ((this.val$s != 85) && ((this.val$s != 83) && ((this.val$s != 86) && (this.val$s != 87))))) {
            com.jlboat.phone.activity.MapActivity.access$3100(this.this$1.this$0).setVisibility(0);
            com.jlboat.phone.activity.MapActivity.access$3200(this.this$1.this$0).setVisibility(0);
            com.jlboat.phone.activity.MapActivity.access$400(this.this$1.this$0).setVisibility(0);
        }
        if (this.val$s != 8) {
            com.jlboat.phone.activity.MapActivity.access$2702(this.this$1.this$0, 0);
        }
        if (this.val$s != 2) {
            com.jlboat.phone.activity.MapActivity.access$2502(this.this$1.this$0, 0);
        }
        com.jlboat.phone.activity.MapActivity.access$3400(this.this$1.this$0).setText(new StringBuilder().append(this.this$1.this$0.getResString(2131493095)).append(" ").append(this.val$finalMsg).append(" ").toString());
        android.util.Log.d("MapActivity", new StringBuilder().append("topic \u5bfc\u822a\u4fe1\u606f: msg = ").append(this.val$finalMsg).toString());
        return;
    }
}
