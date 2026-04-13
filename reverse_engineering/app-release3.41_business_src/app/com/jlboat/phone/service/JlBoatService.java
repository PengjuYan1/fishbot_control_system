package com.jlboat.phone.service;
public class JlBoatService extends com.boat.base.BaseService {
    private String TAG;
    private com.jlboat.phone.manager.BoatNaviManager navigationManager;

    public JlBoatService()
    {
        this.TAG = "JlBoatService";
        return;
    }

    public com.boat.base.BaseApplication getMyApplication()
    {
        return ((com.jlboat.phone.application.BoatSlamApplication) this.getApplication());
    }

    public android.os.IBinder onBind(android.content.Intent p3)
    {
        android.util.Log.v(this.TAG, "bindServicewwoqidong2: onBind");
        ((com.jlboat.phone.controller.SlamAppController) ((com.jlboat.phone.application.BoatSlamApplication) this.getMyApplication()).getAppController()).getJlNaviManager().connect(this.getMyApplication());
        return this.navigationManager;
    }

    public void onCreate()
    {
        super.onCreate();
        this.navigationManager = new com.jlboat.phone.manager.BoatNaviManager(this.getMyApplication());
        return;
    }

    public void onDestroy()
    {
        super.onDestroy();
        this.navigationManager.onDestroy();
        return;
    }

    public int onStartCommand(android.content.Intent p2, int p3, int p4)
    {
        if ((p2 != null) && ((p2.getAction() != null) && (!p2.getAction().isEmpty()))) {
            return super.onStartCommand(p2, p3, p4);
        } else {
            return super.onStartCommand(p2, p3, p4);
        }
    }

    public void unbindService(android.content.ServiceConnection p2)
    {
        super.unbindService(p2);
        this.navigationManager.onDestroy();
        return;
    }
}
