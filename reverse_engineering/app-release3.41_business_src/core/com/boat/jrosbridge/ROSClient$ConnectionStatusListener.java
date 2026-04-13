package com.boat.jrosbridge;
public interface ROSClient$ConnectionStatusListener {

    public abstract void onConnect();

    public abstract void onDisconnect();

    public abstract void onError();
}
