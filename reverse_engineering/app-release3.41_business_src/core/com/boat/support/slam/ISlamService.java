package com.boat.support.slam;
public interface ISlamService implements android.os.IInterface {
    public static final String DESCRIPTOR = "com.boat.support.slam.ISlamService";

    public abstract void addCurrentPosition();

    public abstract void addPosition();

    public abstract void dance();

    public abstract boolean deleteMap();

    public abstract void deletePosition();

    public abstract void downLoadMapData();

    public abstract void downloadBag();

    public abstract com.boat.support.slam.entity.floors.MapList getAllFloor();

    public abstract void getBagList();

    public abstract int getBattery();

    public abstract void getCurrentPositionInfo();

    public abstract boolean getIsDebug();

    public abstract java.util.List getListMaps();

    public abstract com.boat.support.slam.entity.floors.Floors getLocalFloors();

    public abstract java.util.List getLocalMapPoints();

    public abstract com.boat.support.slam.entity.floors.Maps getLocalMaps();

    public abstract void getMap();

    public abstract int getMapStatus();

    public abstract void getVersion();

    public abstract boolean goCharging();

    public abstract boolean isCharged();

    public abstract boolean isEmergencyStop();

    public abstract boolean isInGoCharging();

    public abstract boolean isInNavigation();

    public abstract boolean isLocationLoss();

    public abstract boolean isMotorEnabled();

    public abstract boolean isNaviNetWork();

    public abstract boolean isNavigationInited();

    public abstract void move();

    public abstract void moveAlways();

    public abstract void moveTo();

    public abstract void naviTargetGoalPlan();

    public abstract void navigationTo();

    public abstract void navigationTo2();

    public abstract boolean reNameMap();

    public abstract void reachPointStatus();

    public abstract void recordBag();

    public abstract void registCallBack();

    public abstract void relocalization();

    public abstract void relocation();

    public abstract void requestData();

    public abstract void requestString();

    public abstract void rotateTo();

    public abstract void saveEraseMap();

    public abstract void saveMap();

    public abstract void setErase();

    public abstract void setEraseMode();

    public abstract void setInGoCharging();

    public abstract void setIsDebug();

    public abstract void setMapReBuild();

    public abstract void setMapStatusBuild();

    public abstract void setOutofChange();

    public abstract void setShapArea();

    public abstract void setWarnLedStatus();

    public abstract void setWifiConfig();

    public abstract String startRecordBag();

    public abstract void stopNavigation();

    public abstract String stopRecordBag();

    public abstract void stopRequestData();

    public abstract void unregistCallBack();

    public abstract void updateHareware();

    public abstract void updateMap();

    public abstract void updatePositionName();

    public abstract void updateStatus();
}
