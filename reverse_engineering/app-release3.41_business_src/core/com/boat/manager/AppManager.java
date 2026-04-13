package com.boat.manager;
public class AppManager extends com.boat.base.BaseAppManager {
    private com.boat.manager.NetWorkManager mNetWorkManager;

    public AppManager(com.boat.base.BaseApplication p1)
    {
        super(p1);
        return;
    }

    public com.boat.manager.NetWorkManager getNetWorkManager()
    {
        if (this.mNetWorkManager == null) {
            this.mNetWorkManager = new com.boat.manager.NetWorkManager(this.getApp());
        }
        return this.mNetWorkManager;
    }
}
