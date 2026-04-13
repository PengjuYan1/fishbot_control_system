package com.boat.base;
public class BaseAppManager {
    private com.boat.base.BaseApplication mApp;

    public BaseAppManager(com.boat.base.BaseApplication p1)
    {
        this.mApp = p1;
        return;
    }

    public com.boat.base.BaseApplication getApp()
    {
        return this.mApp;
    }
}
