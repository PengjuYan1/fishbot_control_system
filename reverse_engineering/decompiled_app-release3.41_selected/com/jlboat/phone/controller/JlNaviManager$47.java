package com.jlboat.phone.controller;
 class JlNaviManager$47 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$47(com.jlboat.phone.controller.JlNaviManager p1)
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
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic \u5bfc\u822a\u72b6\u6001: status = ").append(v0).append(", currentNaviMsgStatus = ").append(com.jlboat.phone.controller.JlNaviManager.access$5200(this.this$0)).toString());
        String v1_0 = "";
        String v2_1 = "";
        if ((v0 == 52) && (com.jlboat.phone.controller.JlNaviManager.access$3500(this.this$0) != null)) {
            try {
                android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("\u53d1\u9001chargepoint_not_set\u6d88\u606f\uff1a ").append("").toString());
                com.jlboat.phone.controller.JlNaviManager.access$3500(this.this$0).onSuccess("chargepoint_not_set");
                com.jlboat.phone.controller.JlNaviManager.access$3502(this.this$0, 0);
            } catch (android.os.RemoteException v3_27) {
                v3_27.printStackTrace();
            }
        }
        if (v0 != com.jlboat.phone.controller.JlNaviManager.access$5200(this.this$0)) {
            com.jlboat.phone.controller.JlNaviManager.access$5202(this.this$0, v0);
            switch (v0) {
                case 1:
                    v2_1 = "\u673a\u5668\u4eba\u5f00\u59cb\u5bfc\u822a\u5230\u76ee\u7684\u5730\u3002";
                    v1_0 = "HEADING";
                    break;
                case 2:
                    v2_1 = "\u673a\u5668\u4eba\u5bfc\u822a\u5230\u76ee\u7684\u5730\u6210\u529f\uff0cGoal Reached\uff01";
                    if (!com.jlboat.phone.controller.JlNaviManager.access$5300(this.this$0)) {
                        com.jlboat.phone.controller.JlNaviManager.access$5302(this.this$0, 1);
                        com.jlboat.phone.controller.JlNaviManager.access$5400(this.this$0, 0);
                    }
                    v1_0 = "REACHED";
                    if (com.jlboat.phone.controller.JlNaviManager.access$3400(this.this$0) == null) {
                    } else {
                        try {
                            com.jlboat.phone.controller.JlNaviManager.access$3400(this.this$0).onSuccess("navigation success");
                        } catch (android.os.RemoteException v3_6) {
                            v3_6.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    v2_1 = "\u673a\u5668\u4eba\u5bfc\u822a\u5230\u76ee\u7684\u5730\u7ecf\u8fc7\u5404\u79cd\u5c1d\u8bd5\u540e\u5931\u8d25\uff0c\u5bfc\u822a\u505c\u6b62\uff01\u8bf7\u4fee\u590d\uff01";
                    v1_0 = "UNREACHABLE";
                    if (com.jlboat.phone.controller.JlNaviManager.access$3400(this.this$0) == null) {
                    } else {
                        try {
                            com.jlboat.phone.controller.JlNaviManager.access$3400(this.this$0).onFailed("navigation failed");
                        } catch (android.os.RemoteException v3_42) {
                            v3_42.printStackTrace();
                        }
                    }
                    break;
                case 4:
                case 5:
                    break;
                case 6:
                    v2_1 = "\u673a\u5668\u4eba\u627e\u4e0d\u5230\u5bfc\u822a\u70b9\uff0c\u5bfc\u822a\u505c\u6b62\uff01\u8bf7\u4fee\u590d\uff01";
                    v1_0 = "NOT_AVAILABLE";
                    break;
                case 7:
                    v2_1 = "\u673a\u5668\u4eba\u505c\u6b62\u5bfc\u822a\uff01";
                    break;
                case 8:
                    v2_1 = "\u673a\u5668\u4eba\u5168\u5c40\u8def\u5f84\u89c4\u5212\u8d85\u65f6\uff0c\u9677\u5165\u56f0\u5883\uff0c\u63d0\u793a\uff1a\u201c\u8bf7\u8ba9\u4e00\u8ba9\u201d\uff01";
                    v1_0 = "GOAL_NOT_SAFE";
                    break;
                case 51:
                    v2_1 = "\u673a\u5668\u4eba\u5145\u7535\u8fc7\u7a0b\u4e2d\uff0c\u5bfc\u822a\u5230\u5145\u7535\u6869\u8fc7\u7a0b\u4e2d\u5bfc\u822a\u5931\u8d25\uff0c\u5bfc\u81f4\u5145\u7535\u5931\u8d25\uff01!";
                    break;
                case 52:
                    v2_1 = "\u673a\u5668\u4eba\u6ca1\u6709\u8bbe\u7f6e\u5145\u7535\u6869\uff01!";
                    break;
                case 81:
                    com.boat.utils.ReportExceptionInformationUtils.upload(this.this$0.getApp(), v0, "\u673a\u5668\u4eba\u5bfc\u822a\u9a8c\u8bc1\u6210\u529f!");
                    break;
                case 82:
                    com.boat.utils.ReportExceptionInformationUtils.upload(this.this$0.getApp(), v0, "\u673a\u5668\u4eba\u5bfc\u822a\u9a8c\u8bc1\u5931\u8d25!");
                    break;
                case 83:
                    com.boat.utils.ReportExceptionInformationUtils.upload(this.this$0.getApp(), v0, "\u673a\u5668\u4eba\u5bfc\u822a\u53d6\u6d88!");
                    break;
                default:
            }
            android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("\u6536\u5230\u5bfc\u822a\u6d88\u606f\u53cd\u9988\uff1a ").append(v2_1).toString());
            if (!v2_1.isEmpty()) {
                com.boat.utils.ReportExceptionInformationUtils.upload(this.this$0.getApp(), v0, v2_1);
            }
            if (!v1_0.isEmpty()) {
                com.jlboat.phone.controller.JlNaviManager.access$1402(this.this$0, v1_0);
                com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessage(8);
                return;
            } else {
                return;
            }
        } else {
            return;
        }
    }
}
