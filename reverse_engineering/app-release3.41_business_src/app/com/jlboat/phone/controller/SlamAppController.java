package com.jlboat.phone.controller;
public class SlamAppController extends com.boat.controller.AppController {
    private com.jlboat.phone.controller.JlNaviManager jlNaviManager;
    private com.jlboat.phone.manager.BoatNaviManager navigationManager;

    public SlamAppController(com.boat.base.BaseApplication p1)
    {
        super(p1);
        return;
    }

    public com.jlboat.phone.controller.JlNaviManager getJlNaviManager()
    {
        if (this.jlNaviManager == null) {
            this.jlNaviManager = new com.jlboat.phone.controller.JlNaviManager(this.getApp());
        }
        return this.jlNaviManager;
    }

    public com.jlboat.phone.manager.BoatNaviManager getNavigationManager()
    {
        if (this.navigationManager == null) {
            this.navigationManager = new com.jlboat.phone.manager.BoatNaviManager(this.getApp());
        }
        return this.navigationManager;
    }
}
