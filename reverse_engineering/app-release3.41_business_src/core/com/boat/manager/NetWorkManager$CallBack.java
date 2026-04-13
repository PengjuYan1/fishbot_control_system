package com.boat.manager;
public interface NetWorkManager$CallBack {

    public abstract void onError();

    public abstract void onNetworkDisconnected();

    public abstract void onSuccess();
}
