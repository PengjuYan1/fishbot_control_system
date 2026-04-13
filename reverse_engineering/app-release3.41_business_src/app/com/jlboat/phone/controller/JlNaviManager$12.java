package com.jlboat.phone.controller;
 class JlNaviManager$12 implements com.boat.jrosbridge.MessageListener {
    final synthetic com.jlboat.phone.controller.JlNaviManager this$0;
    final synthetic com.boat.support.slam.IResponseListener val$responseListener;

    JlNaviManager$12(com.jlboat.phone.controller.JlNaviManager p1, com.boat.support.slam.IResponseListener p2)
    {
        this.this$0 = p1;
        this.val$responseListener = p2;
        return;
    }

    public bridge synthetic void onNewMessage(com.boat.jrosbridge.message.Message p1)
    {
        this.onNewMessage(((com.boat.jrosbridge.message.std_srvs.TriggerResponse) p1));
        return;
    }

    public void onNewMessage(com.boat.jrosbridge.message.std_srvs.TriggerResponse p8)
    {
        if (!p8.getSuccess()) {
            if (this.val$responseListener != null) {
                try {
                    this.val$responseListener.onFailed(0);
                } catch (com.jlboat.phone.controller.JlNaviManager v0_25) {
                    v0_25.printStackTrace();
                }
            }
        } else {
            if (!p8.getMessage().isEmpty()) {
                if (this.val$responseListener != null) {
                    try {
                        this.val$responseListener.onSuccess(p8.getMessage());
                    } catch (com.jlboat.phone.controller.JlNaviManager v0_5) {
                        v0_5.printStackTrace();
                    }
                }
                com.jlboat.phone.controller.JlNaviManager.access$3002(this.this$0, new com.boat.support.slam.entity.floors.MapList());
                try {
                    com.jlboat.phone.controller.JlNaviManager.access$3002(this.this$0, ((com.boat.support.slam.entity.floors.MapList) new com.google.gson.Gson().fromJson(p8.getMessage(), new com.jlboat.phone.controller.JlNaviManager$12$1(this).getType())));
                } catch (com.jlboat.phone.controller.JlNaviManager v0_9) {
                    v0_9.printStackTrace();
                }
                if ((com.jlboat.phone.controller.JlNaviManager.access$3000(this.this$0) == null) || ((com.jlboat.phone.controller.JlNaviManager.access$3000(this.this$0).getFloors() == null) || (com.jlboat.phone.controller.JlNaviManager.access$3000(this.this$0).getFloors().isEmpty()))) {
                    this.this$0.toast("\u83b7\u53d6\u5730\u56fe\u6210\u529f\u4e3a\u7a7a");
                } else {
                    com.jlboat.phone.controller.JlNaviManager v0_24 = com.jlboat.phone.controller.JlNaviManager.access$3000(this.this$0).getFloors().iterator();
                    while (v0_24.hasNext()) {
                        com.boat.support.slam.entity.floors.Floors v1_11 = ((com.boat.support.slam.entity.floors.Floors) v0_24.next());
                        if (com.jlboat.phone.controller.JlNaviManager.access$3000(this.this$0).getDefaultFloor() == v1_11.getFloorId()) {
                            com.jlboat.phone.controller.JlNaviManager.access$3102(this.this$0, v1_11);
                            break;
                        }
                    }
                }
                com.jlboat.phone.controller.JlNaviManager.access$100(this.this$0).sendEmptyMessage(12);
                this.this$0.startBootHTTPService(p8.getMessage());
            } else {
                return;
            }
        }
        return;
    }
}
