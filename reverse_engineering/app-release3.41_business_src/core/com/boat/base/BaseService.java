package com.boat.base;
public class BaseService extends android.app.Service {
    protected final String TAG;

    public BaseService()
    {
        this.TAG = this.getClass().getSimpleName();
        return;
    }

    public com.boat.base.BaseApplication getMyApplication()
    {
        return ((com.boat.base.BaseApplication) this.getApplication());
    }

    public android.os.IBinder onBind(android.content.Intent p2)
    {
        return 0;
    }

    public void onCreate()
    {
        super.onCreate();
        return;
    }

    public void onDestroy()
    {
        super.onDestroy();
        return;
    }

    public boolean onUnbind(android.content.Intent p2)
    {
        return super.onUnbind(p2);
    }
}
