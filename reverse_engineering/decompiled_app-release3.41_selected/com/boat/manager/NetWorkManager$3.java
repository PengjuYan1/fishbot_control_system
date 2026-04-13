package com.boat.manager;
 class NetWorkManager$3 implements okhttp3.Callback {
    final synthetic com.boat.manager.NetWorkManager this$0;
    final synthetic com.boat.manager.NetWorkManager$CallBack val$callback;
    final synthetic Class val$resultClass;

    NetWorkManager$3(com.boat.manager.NetWorkManager p1, com.boat.manager.NetWorkManager$CallBack p2, Class p3)
    {
        this.this$0 = p1;
        this.val$callback = p2;
        this.val$resultClass = p3;
        return;
    }

    public void onFailure(okhttp3.Call p3, java.io.IOException p4)
    {
        if (this.val$callback != null) {
            android.util.Log.d("catalpa ", new StringBuilder().append("onFailure: onError response  ").append(p4.toString()).toString());
            this.val$callback.onError();
        }
        return;
    }

    public void onResponse(okhttp3.Call p4, okhttp3.Response p5)
    {
        if (this.val$callback != null) {
            if (p5.code() != 200) {
                this.val$callback.onError();
                android.util.Log.d("catalpa ", new StringBuilder().append("onFailure: onError response  ").append(p5.toString()).toString());
            } else {
                String v0_5 = p5.body().string();
                if (this.val$resultClass != String) {
                    try {
                        this.val$callback.onSuccess(new com.google.gson.Gson().fromJson(v0_5, this.val$resultClass));
                    } catch (Exception v1_7) {
                        v1_7.printStackTrace();
                    }
                } else {
                    this.val$callback.onSuccess(v0_5);
                }
            }
        }
        return;
    }
}
