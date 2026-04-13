package com.jlboat.phone.manager;
public class BoatNaviManager extends com.boat.support.slam.ISlamService$Stub {
    private com.jlboat.phone.application.BoatSlamApplication mApp;

    public BoatNaviManager(com.boat.base.BaseApplication p2)
    {
        this.mApp = ((com.jlboat.phone.application.BoatSlamApplication) p2);
        return;
    }

    public void addCurrentPosition(String p2, com.boat.support.slam.IResponseListener p3)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().addCurrentPosition(p2, p3);
        return;
    }

    public void addPosition(String p1, double p2, double p4, double p6, double p8, double p10, double p12, com.boat.support.slam.IResponseListener p14)
    {
        return;
    }

    public void dance(int p1, com.boat.support.slam.IResponseListener p2)
    {
        return;
    }

    public void deleteBag()
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().deleteBag();
        return;
    }

    public void deleteLog()
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().deleteLog();
        return;
    }

    public boolean deleteMap(String p2)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().deleteMap(p2);
        return 0;
    }

    public void deletePosition(String p2, com.boat.support.slam.IResponseListener p3)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().deletePosition(p2, p3);
        return;
    }

    public void downLoadMapData(String p1)
    {
        return;
    }

    public void downloadBag(com.boat.support.slam.IResponseListener p1)
    {
        return;
    }

    public com.boat.support.slam.entity.floors.MapList getAllFloor()
    {
        return ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().getAllFloor();
    }

    public void getAndUploadBag()
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().getAndUploadBag();
        return;
    }

    public void getAndUploadLog()
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().getAndUploadLog();
        return;
    }

    public void getBagList(com.boat.support.slam.IResponseListener p2)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().getBag(p2);
        return;
    }

    public int getBattery()
    {
        return ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().getBattery();
    }

    public void getCurrentPositionInfo(com.boat.support.slam.IPositionResult p2)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().getCurrentPositionInfo(p2);
        return;
    }

    public boolean getIsDebug()
    {
        return 0;
    }

    public java.util.List getListMaps()
    {
        return ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().getMapList();
    }

    public com.boat.support.slam.entity.floors.Floors getLocalFloors()
    {
        return ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().getLocalFloors();
    }

    public java.util.List getLocalMapPoints()
    {
        return ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().getLocalMapPoints();
    }

    public com.boat.support.slam.entity.floors.Maps getLocalMaps()
    {
        return ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().getLocalMaps();
    }

    public void getMap(com.boat.support.slam.IResponseListener p1)
    {
        return;
    }

    public int getMapStatus()
    {
        return ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().getMapBuildStatus();
    }

    public void getVersion(com.boat.support.slam.IResponseListener p2)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().getVersion(p2);
        return;
    }

    public boolean goCharging(com.boat.support.slam.IResponseListener p2)
    {
        return ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().goCharging(p2);
    }

    public boolean isCharged()
    {
        return ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().isCharged();
    }

    public boolean isEmergencyStop()
    {
        return ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().isEmergencyStop();
    }

    public boolean isInGoCharging()
    {
        return ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().isInGoCharging();
    }

    public boolean isInNavigation()
    {
        return (((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().isNaviTaskFinished() ^ 1);
    }

    public boolean isLocationLoss()
    {
        return ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().isLocationLoss();
    }

    public boolean isMotorEnabled()
    {
        return ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().isMotorEnabled();
    }

    public boolean isNaviNetWork()
    {
        return ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().isNaviNetWork();
    }

    public boolean isNavigationInited()
    {
        return ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().isNavigationInited();
    }

    public void move(double p2, double p4)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().move(p2, p4);
        return;
    }

    public void moveAlways(double p4, double p6)
    {
        android.util.Log.d("baotnavimanager", new StringBuilder().append("moveAlways: linearSpeed\uff1a").append(p4).append(" angularSpeed: ").append(p6).toString());
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().setNavicmd(5, 0);
        return;
    }

    public void moveTo(double p6, double p8)
    {
        android.util.Log.d("baotnavimanager", new StringBuilder().append("moveTo: distance\uff1a").append(p6).append(" linearSpeed: ").append(p8).toString());
        if ((p8 != 0) || (p6 != 0)) {
            int v3_1;
            com.jlboat.phone.controller.JlNaviManager v2_5 = ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager();
            if (p8 <= 0) {
                v3_1 = 2;
            } else {
                v3_1 = 1;
            }
            int v0_5;
            if (p8 <= 0) {
                v0_5 = 50;
            } else {
                v0_5 = 80;
            }
            v2_5.setNavicmd(v3_1, v0_5);
            return;
        } else {
            return;
        }
    }

    public void naviTargetGoalPlan(long p12, long p14, long p16, int p18, com.boat.support.slam.IResponseListener p19)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().naviTargetGoalPlan(p12, p14, p16, p18, p19);
        return;
    }

    public void navigationTo(int p2, String p3, String p4, com.boat.support.slam.IResponseListener p5)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().navigationTo(p2, p3, p4, p5);
        return;
    }

    public void navigationTo2(String p2)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().navigationTo2(p2);
        return;
    }

    public void onDestroy()
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().onDestroy();
        return;
    }

    public boolean reNameMap(String p2, String p3)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().reNameMap(p2, p3);
        return 0;
    }

    public void reachPointStatus(boolean p2)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().reachPointStatus(p2);
        return;
    }

    public void recordBag(int p2, String p3, java.util.List p4)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().recordBag(p2, p3, p4);
        return;
    }

    public void registCallBack(com.boat.support.slam.ISlamCallBack p2)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().registerCallback(p2);
        return;
    }

    public void relocalization(String p1, com.boat.support.slam.IResponseListener p2)
    {
        return;
    }

    public void relocation(double p1, double p3, double p5, double p7, double p9, double p11)
    {
        return;
    }

    public void requestData(int p2)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().requestData1(p2);
        return;
    }

    public void requestString(String p1, String p2)
    {
        return;
    }

    public void rotateTo(int p3, double p4)
    {
        android.util.Log.d("baotnavimanager", new StringBuilder().append("rotateTo: angle\uff1a").append(p3).append(" angularSpeed: ").append(p4).toString());
        if (p3 != 0) {
            int v1_2;
            com.jlboat.phone.controller.JlNaviManager v0_7 = ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager();
            if (p3 <= 0) {
                v1_2 = 4;
            } else {
                v1_2 = 3;
            }
            v0_7.setNavicmd(v1_2, p3);
            return;
        } else {
            return;
        }
    }

    public void saveEraseMap()
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().saveEraseMap();
        return;
    }

    public void saveMap(String p2)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().saveMap(p2);
        return;
    }

    public void setErase(double p2, double p4)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().setErase(p2, p4);
        return;
    }

    public void setEraseMode(int p2, com.boat.support.slam.IResponseListener p3)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().setEraseMode(p2, p3);
        return;
    }

    public void setInGoCharging(boolean p2)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().setInCharging(p2);
        return;
    }

    public void setIsDebug(boolean p1)
    {
        return;
    }

    public void setMapReBuild()
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().setMapReBuild();
        return;
    }

    public void setMapStatusBuild()
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().clearMap();
        return;
    }

    public void setOutofChange()
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().setOutofChange();
        return;
    }

    public void setShapArea(com.boat.support.slam.entity.floors.ShapeAreas p2, com.boat.support.slam.IResponseListener p3)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().setShapArea(p2, p3);
        return;
    }

    public void setWarnLedStatus(boolean p2)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().setWarnLedStatus(p2);
        return;
    }

    public void setWifiConfig(String p2, String p3)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().setWifiConfig(p2, p3);
        return;
    }

    public void ssh(String p2)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().robotSsh(p2);
        return;
    }

    public String startRecordBag(com.boat.support.slam.IResponseListener p2)
    {
        return 0;
    }

    public void stopNavigation()
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().stopNavigation();
        return;
    }

    public String stopRecordBag(com.boat.support.slam.IResponseListener p2)
    {
        return 0;
    }

    public void stopRequestData(int p2)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().stopRequestData(p2);
        return;
    }

    public void unregistCallBack(com.boat.support.slam.ISlamCallBack p2)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().unregisterCallback(p2);
        return;
    }

    public void updateHareware(com.boat.support.slam.IResponseListener p1)
    {
        return;
    }

    public void updateMap(String p3)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().updateMap(p3, 1);
        return;
    }

    public void updatePositionName(String p4, String p5, com.boat.support.slam.IResponseListener p6)
    {
        ((com.jlboat.phone.controller.SlamAppController) this.mApp.getAppController()).getJlNaviManager().changePositionName(Long.parseLong(p4), p5, p6);
        return;
    }

    public void updateStatus()
    {
        android.util.Log.d("TAG", "updateStatus: ");
        return;
    }
}
