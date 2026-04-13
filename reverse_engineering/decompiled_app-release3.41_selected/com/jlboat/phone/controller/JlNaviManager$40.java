package com.jlboat.phone.controller;
 class JlNaviManager$40 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;

    JlNaviManager$40(com.jlboat.phone.controller.JlNaviManager p1)
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
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("topic getChageMsg\u5145\u7535\u72b6\u6001: ").append(p7.getData()).toString());
        switch (p7.getData()) {
            case 41:
                com.jlboat.phone.controller.JlNaviManager.access$4800(this.this$0, 0, "41");
                com.boat.utils.ReportExceptionInformationUtils.uploadCharge(this.this$0.getApp(), p7.getData(), "\u6ca1\u6709\u5145\u7535\uff01");
                break;
            case 42:
            case 43:
                com.jlboat.phone.controller.JlNaviManager.access$4902(this.this$0, 0);
                break;
            case 44:
                com.jlboat.phone.controller.JlNaviManager.access$4800(this.this$0, 0, "44");
                com.boat.utils.ReportExceptionInformationUtils.uploadCharge(this.this$0.getApp(), p7.getData(), "\u673a\u5668\u4eba\u5145\u7535\u5931\u8d25\uff0c\u672a\u5145\u7535\uff01\u8bf7\u53ca\u65f6\u4fee\u590d\uff0c\u4ee5\u9632\u4f4e\u7535\u5173\u673a!");
                if (!com.jlboat.phone.controller.JlNaviManager.access$4900(this.this$0)) {
                } else {
                    com.jlboat.phone.controller.JlNaviManager.access$4902(this.this$0, 0);
                    if (com.jlboat.phone.controller.JlNaviManager.access$3500(this.this$0) == null) {
                    } else {
                        try {
                            com.jlboat.phone.controller.JlNaviManager.access$3500(this.this$0).onSuccess("finish");
                            com.jlboat.phone.controller.JlNaviManager.access$3502(this.this$0, 0);
                        } catch (android.os.RemoteException v0_34) {
                            v0_34.printStackTrace();
                        }
                    }
                }
                break;
            case 45:
                com.jlboat.phone.controller.JlNaviManager.access$4800(this.this$0, 1, "45");
                com.jlboat.phone.controller.JlNaviManager.access$4902(this.this$0, 0);
                com.boat.utils.ReportExceptionInformationUtils.uploadCharge(this.this$0.getApp(), p7.getData(), "\u673a\u5668\u4eba\u5904\u4e8e\u81ea\u52a8\u5145\u7535\u72b6\u6001\u3002");
                break;
            case 46:
                com.boat.utils.ReportExceptionInformationUtils.uploadCharge(this.this$0.getApp(), p7.getData(), "\u673a\u5668\u4eba\u5904\u4e8e\u624b\u52a8\u5145\u7535\u72b6\u6001\u3002");
                com.jlboat.phone.controller.JlNaviManager.access$4800(this.this$0, 1, "46");
                com.jlboat.phone.controller.JlNaviManager.access$4902(this.this$0, 0);
                break;
            case 47:
                com.jlboat.phone.controller.JlNaviManager.access$4800(this.this$0, 1, "47");
                com.jlboat.phone.controller.JlNaviManager.access$4902(this.this$0, 0);
                com.boat.utils.ReportExceptionInformationUtils.uploadCharge(this.this$0.getApp(), p7.getData(), "\u673a\u5668\u4eba\u81ea\u52a8\u5145\u7535\u5df2\u7ecf\u5b8c\u6210\uff0c\u7535\u91cf100%\u3002");
                break;
            case 48:
                com.jlboat.phone.controller.JlNaviManager.access$4800(this.this$0, 1, "48");
                com.jlboat.phone.controller.JlNaviManager.access$4902(this.this$0, 0);
                com.boat.utils.ReportExceptionInformationUtils.uploadCharge(this.this$0.getApp(), p7.getData(), "\u673a\u5668\u4eba\u624b\u52a8\u5145\u7535\u5df2\u7ecf\u5b8c\u6210\uff0c\u7535\u91cf100%\u3002");
                break;
            default:
        }
        android.os.RemoteException v0_4 = p7.getData();
        android.util.Log.d(com.jlboat.phone.controller.JlNaviManager.access$000(this.this$0), new StringBuilder().append("onNewMessage: change ").append(v0_4).toString());
        if ((v0_4 != 45) && ((v0_4 != 46) && ((v0_4 != 47) && (v0_4 != 48)))) {
            com.jlboat.phone.application.BoatSlamApplication.change = 0;
        } else {
            com.jlboat.phone.application.BoatSlamApplication.change = 1;
        }
        android.content.Intent v1_3 = new android.content.Intent();
        v1_3.setAction("change");
        v1_3.putExtra("value", com.jlboat.phone.application.BoatSlamApplication.change);
        com.jlboat.phone.application.BoatSlamApplication.mApplication.sendBroadcast(v1_3);
        return;
    }
}
