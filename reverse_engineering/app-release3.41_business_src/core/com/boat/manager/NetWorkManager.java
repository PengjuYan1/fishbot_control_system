package com.boat.manager;
public class NetWorkManager extends com.boat.base.BaseAppManager {

    public NetWorkManager(com.boat.base.BaseApplication p1)
    {
        super(p1);
        return;
    }

    private void get(String p5, okhttp3.Callback p6)
    {
        com.boat.utils.OkHttpUtils v0_1 = new com.boat.utils.OkHttpUtils();
        v0_1.enqueue(v0_1.getCall(v0_1.getClient(), v0_1.getJsonRequestAboutGet(p5)), p6);
        return;
    }

    private void post(String p5, String p6, okhttp3.Callback p7)
    {
        com.boat.utils.OkHttpUtils v0_1 = new com.boat.utils.OkHttpUtils();
        v0_1.enqueue(v0_1.getCall(v0_1.getClient(), v0_1.getJsonRequest(p5, v0_1.getRequestBody(p6))), p7);
        return;
    }

    private void post(String p5, org.json.JSONObject p6, okhttp3.Callback p7)
    {
        com.boat.utils.OkHttpUtils v0_1 = new com.boat.utils.OkHttpUtils();
        v0_1.enqueue(v0_1.getCall(v0_1.getClient(), v0_1.getJsonRequest(p5, v0_1.getRequestBody(p6))), p7);
        return;
    }

    public void get(android.content.Context p2, String p3, Class p4, com.boat.manager.NetWorkManager$CallBack p5)
    {
        if (!com.boat.utils.NetworkUtils.isConnected(p2)) {
            if (p5 != null) {
                p5.onNetworkDisconnected();
            }
        } else {
            this.get(p3, new com.boat.manager.NetWorkManager$3(this, p5, p4));
        }
        return;
    }

    public byte[] get(String p8)
    {
        com.boat.utils.OkHttpUtils v0_1 = new com.boat.utils.OkHttpUtils();
        try {
            java.io.IOException v5_0 = v0_1.getCall(v0_1.getClient(), v0_1.getJsonRequestAboutGet(p8)).execute();
        } catch (java.io.IOException v5_1) {
            v5_1.printStackTrace();
            return 0;
        }
        if (v5_0 != null) {
            if (v5_0.body() != null) {
                return v5_0.body().bytes();
            } else {
            }
        }
        return 0;
    }

    public void post(android.content.Context p2, String p3, String p4, Class p5, com.boat.manager.NetWorkManager$CallBack p6)
    {
        if (!com.boat.utils.NetworkUtils.isConnected(p2)) {
            if (p6 != null) {
                p6.onNetworkDisconnected();
            }
        } else {
            this.post(p3, p4, new com.boat.manager.NetWorkManager$1(this, p6, p5));
        }
        return;
    }

    public void post(android.content.Context p2, String p3, org.json.JSONObject p4, Class p5, com.boat.manager.NetWorkManager$CallBack p6)
    {
        if (!com.boat.utils.NetworkUtils.isConnected(p2)) {
            if (p6 != null) {
                p6.onNetworkDisconnected();
            }
        } else {
            this.post(p3, p4, new com.boat.manager.NetWorkManager$2(this, p6, p5));
        }
        return;
    }
}
