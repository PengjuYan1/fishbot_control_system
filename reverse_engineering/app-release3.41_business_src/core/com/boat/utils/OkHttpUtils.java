package com.boat.utils;
public class OkHttpUtils {

    public OkHttpUtils()
    {
        return;
    }

    public void enqueue(okhttp3.Call p1, okhttp3.Callback p2)
    {
        p1.enqueue(p2);
        return;
    }

    public okhttp3.Call getCall(okhttp3.OkHttpClient p2, okhttp3.Request p3)
    {
        return p2.newCall(p3);
    }

    public okhttp3.OkHttpClient getClient()
    {
        return new okhttp3.OkHttpClient();
    }

    public okhttp3.Request getJsonRequest(String p2, okhttp3.RequestBody p3)
    {
        return new okhttp3.Request$Builder().url(p2).post(p3).build();
    }

    public okhttp3.Request getJsonRequestAboutGet(String p2)
    {
        return new okhttp3.Request$Builder().url(p2).get().build();
    }

    public okhttp3.RequestBody getRequestBody(String p2)
    {
        return okhttp3.RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), p2);
    }

    public okhttp3.RequestBody getRequestBody(org.json.JSONObject p3)
    {
        return okhttp3.RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), p3.toString());
    }
}
