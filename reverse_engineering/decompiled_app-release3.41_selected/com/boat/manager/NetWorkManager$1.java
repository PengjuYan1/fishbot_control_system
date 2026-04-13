package com.boat.manager;
 class NetWorkManager$1 implements okhttp3.Callback {
    final synthetic com.boat.manager.NetWorkManager this$0;
    final synthetic com.boat.manager.NetWorkManager$CallBack val$callback;
    final synthetic Class val$resultClass;

    NetWorkManager$1(com.boat.manager.NetWorkManager p1, com.boat.manager.NetWorkManager$CallBack p2, Class p3)
    {
        this.this$0 = p1;
        this.val$callback = p2;
        this.val$resultClass = p3;
        return;
    }

    public void onFailure(okhttp3.Call p2, java.io.IOException p3)
    {
        if (this.val$callback != null) {
            this.val$callback.onError();
        }
        return;
    }

    public void onResponse(okhttp3.Call p4, okhttp3.Response p5)
    {
        if (this.val$callback != null) {
            if (p5.code() != 200) {
                this.val$callback.onError();
            } else {
                com.boat.manager.NetWorkManager$CallBack v0_1 = p5.body().string();
                if (this.val$resultClass != String) {
                    try {
                        this.val$callback.onSuccess(new com.google.gson.Gson().fromJson(v0_1, this.val$resultClass));
                    } catch (Exception v1_4) {
                        v1_4.printStackTrace();
                        this.val$callback.onError();
                    }
                } else {
                    this.val$callback.onSuccess(v0_1);
                }
            }
        }
        return;
    }
}
