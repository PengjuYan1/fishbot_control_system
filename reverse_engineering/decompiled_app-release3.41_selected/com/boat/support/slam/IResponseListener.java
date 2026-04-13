package com.boat.support.slam;
public interface IResponseListener implements android.os.IInterface {
    public static final String DESCRIPTOR = "com.boat.support.slam.IResponseListener";

    public abstract void onFailed();

    public abstract void onSuccess();
}
