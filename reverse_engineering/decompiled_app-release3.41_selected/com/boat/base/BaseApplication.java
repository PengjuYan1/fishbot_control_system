package com.boat.base;
public class BaseApplication extends android.app.Application {
    public final String TAG;
    private com.boat.controller.AppController mAc;
    private com.boat.manager.AppManager mAp;

    public BaseApplication()
    {
        this.TAG = this.getClass().getSimpleName();
        return;
    }

    public final com.boat.controller.AppController getAppController()
    {
        return this.mAc;
    }

    public final com.boat.manager.AppManager getAppManager()
    {
        return this.mAp;
    }

    public com.boat.manager.AppManager initAppManager()
    {
        return new com.boat.manager.AppManager(this);
    }

    public com.boat.controller.AppController initController()
    {
        return new com.boat.controller.AppController(this);
    }

    public void onCreate()
    {
        super.onCreate();
        this.mAp = this.initAppManager();
        this.mAc = this.initController();
        return;
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        return;
    }

    public void onTerminate()
    {
        super.onTerminate();
        return;
    }

    public void onTrimMemory(int p1)
    {
        super.onTrimMemory(p1);
        return;
    }
}
