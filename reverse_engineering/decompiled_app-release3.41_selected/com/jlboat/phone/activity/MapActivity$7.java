package com.jlboat.phone.activity;
 class MapActivity$7 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.activity.MapActivity this$0;

    MapActivity$7(com.jlboat.phone.activity.MapActivity p1)
    {
        this.this$0 = p1;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_msgs.Int16) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_msgs.Int16 p7)
    {
        short v0 = p7.getData();
        android.util.Log.d("MapActivity", new StringBuilder().append("topic \u5bfc\u822a\u72b6\u6001: status = ").append(v0).toString());
        String v1_1 = "";
        switch (v0) {
            case 1:
                v1_1 = "\u6b63\u5728\u524d\u5f80";
                break;
            case 2:
                v1_1 = "\u5230\u8fbe\u76ee\u7684\u5730";
                com.jlboat.phone.activity.MapActivity.access$2502(this.this$0, 1);
                break;
            case 3:
                v1_1 = "\u5bfc\u822a\u5931\u8d25";
                break;
            case 4:
            case 5:
                break;
            case 6:
                v1_1 = "\u627e\u4e0d\u5230\u5bfc\u822a\u70b9";
                break;
            case 7:
                v1_1 = "\u505c\u6b62\u5bfc\u822a";
                break;
            case 8:
                v1_1 = "\u78b0\u5230\u969c\u788d\u7269";
                com.jlboat.phone.activity.MapActivity.access$2602(this.this$0, System.currentTimeMillis());
                com.jlboat.phone.activity.MapActivity.access$2702(this.this$0, 1);
                com.jlboat.phone.activity.MapActivity.access$2800(this.this$0);
                break;
            case 51:
                v1_1 = "\u5145\u7535\u5bfc\u822a\u5931\u8d25";
                break;
            case 52:
                v1_1 = "\u6ca1\u8bbe\u7f6e\u5145\u7535\u6869";
                break;
            case 72:
                v1_1 = "\u6b63\u5728\u524d\u5f80";
                break;
            case 81:
                break;
            case 82:
                break;
            case 83:
                if (!com.jlboat.phone.activity.MapActivity.access$2500(this.this$0)) {
                    v1_1 = "\u5bfc\u822a\u53d6\u6d88";
                } else {
                    v1_1 = "\u5230\u8fbe\u76ee\u7684\u5730";
                }
                break;
            case 84:
                v1_1 = "\u4f4d\u7f6e\u4e22\u5931";
                break;
            case 85:
                v1_1 = "\u5230\u8fbe\u5145\u7535\u6869";
                break;
            case 86:
                v1_1 = "\u5bf9\u6869\u6210\u529f";
                break;
            case 87:
                v1_1 = "\u5bf9\u6869\u5931\u8d25";
                break;
            case 88:
                v1_1 = "\u5f00\u59cb\u9876\u5347";
                break;
            case 89:
                v1_1 = "\u9876\u5347\u5931\u8d25";
                break;
            case 90:
                v1_1 = "\u9876\u5347\u5b8c\u6210";
                break;
            case 91:
                v1_1 = "\u5f00\u59cb\u5378\u8d27";
                break;
            case 92:
                v1_1 = "\u5378\u8d27\u5931\u8d25";
                break;
            case 93:
                v1_1 = "\u5378\u8d27\u5b8c\u6210";
                break;
            case 94:
                v1_1 = "\u5f00\u59cb\u5f00\u95e8";
                break;
            case 95:
                v1_1 = "\u5f00\u95e8\u5931\u8d25";
                break;
            case 96:
                v1_1 = "\u51fa\u7535\u68af\u4e2d";
                break;
            case 98:
                v1_1 = "\u547c\u53eb\u7535\u68af\u4e2d";
                break;
            case 99:
                v1_1 = "\u8fdb\u7535\u68af\u4e2d";
                break;
            case 100:
                v1_1 = "\u547c\u53eb\u7535\u68af\u5931\u8d25";
                break;
            default:
        }
        this.this$0.runOnUiThread(new com.jlboat.phone.activity.MapActivity$7$1(this, v0, v1_1));
        return;
    }
}
