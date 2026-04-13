package com.boat.support.slam;
public class SlamManager {
    private static final double MOVE_BACKWARD_SPEED = 4596373779694328218;
    private static final double MOVE_FORWARD_SPEED = 4599075939470750515;
    private static final double MOVE_ROTATE_SPEED = 4600877379321698714;
    private static final String TAG = "SlamManager";
    private android.content.ServiceConnection connection;
    private com.boat.support.slam.callback.IInitCallback initCallback;
    private com.boat.support.slam.callback.NaviCallback slamCallBack;
    private com.boat.support.slam.ISlamService slamService;

    public SlamManager(android.content.Context p2, com.boat.support.slam.callback.NaviCallback p3, com.boat.support.slam.callback.IInitCallback p4)
    {
        this.connection = new com.boat.support.slam.SlamManager$1(this);
        this.slamCallBack = p3;
        this.initCallback = p4;
        this.bindService(p2);
        return;
    }

    static synthetic com.boat.support.slam.ISlamService access$002(com.boat.support.slam.SlamManager p0, com.boat.support.slam.ISlamService p1)
    {
        p0.slamService = p1;
        return p1;
    }

    static synthetic com.boat.support.slam.callback.IInitCallback access$100(com.boat.support.slam.SlamManager p1)
    {
        return p1.initCallback;
    }

    static synthetic void access$200(com.boat.support.slam.SlamManager p0)
    {
        p0.unregist();
        return;
    }

    private void bindService(android.content.Context p4)
    {
        android.util.Log.d("SlamManager", "bindService: start");
        android.content.Intent v0_2 = new android.content.Intent();
        v0_2.setClassName("com.jlboat.phone", "com.jlboat.phone.service.JlBoatService");
        p4.bindService(v0_2, this.connection, 1);
        return;
    }

    private void moveAlways(double p4, double p6)
    {
        if (this.isNavigationInited()) {
            if (this.slamService != null) {
                try {
                    this.slamService.moveAlways(p4, p6);
                } catch (android.os.RemoteException v0_3) {
                    android.util.Log.w("SlamManager", "moveAlways: ", v0_3);
                }
            }
            return;
        } else {
            return;
        }
    }

    private void moveTo(double p4, double p6)
    {
        if (this.isNavigationInited()) {
            if (this.slamService != null) {
                try {
                    this.slamService.moveTo(p4, p6);
                } catch (android.os.RemoteException v0_3) {
                    android.util.Log.w("SlamManager", "moveTo: ", v0_3);
                }
            }
            return;
        } else {
            return;
        }
    }

    private void rotateTo(int p4, double p5)
    {
        if (this.isNavigationInited()) {
            if (this.slamService != null) {
                try {
                    this.slamService.rotateTo(p4, 4600877379321698714);
                } catch (android.os.RemoteException v0_3) {
                    android.util.Log.w("SlamManager", "rotateTo: ", v0_3);
                }
            }
            return;
        } else {
            return;
        }
    }

    private void unregist()
    {
        android.util.Log.d("SlamManager", "unregist: ");
        if ((this.slamService != null) && (this.slamCallBack != null)) {
            try {
                this.slamService.unregistCallBack(this.slamCallBack);
            } catch (android.os.RemoteException v2_0) {
                android.util.Log.w("SlamManager", "unregist: ", v2_0);
            }
            this.slamCallBack = 0;
        }
        return;
    }

    public void addCurrentPosition(String p4, com.boat.support.slam.IResponseListener p5)
    {
        if (this.slamService != null) {
            try {
                this.slamService.addCurrentPosition(p4, p5);
            } catch (Exception v0_2) {
                android.util.Log.w("SlamManager", "addPosition: ", v0_2);
            }
        }
        return;
    }

    public void addPosition(String p18, double p19, double p21, double p23, double p25, double p27, double p29, com.boat.support.slam.IResponseListener p31)
    {
        if (this.slamService != null) {
            try {
                this.slamService.addPosition(p18, p19, p21, p23, p25, p27, p29, p31);
            } catch (Exception v0_1) {
                android.util.Log.w("SlamManager", "addPosition: ", v0_1);
            }
        }
        return;
    }

    public void backward()
    {
        this.move(-4626998257160447590, 0);
        return;
    }

    public void backwardTo(double p3)
    {
        this.moveTo(p3, -4626998257160447590);
        return;
    }

    public void changePosition(String p4, String p5, com.boat.support.slam.IResponseListener p6)
    {
        if (this.slamService != null) {
            try {
                this.slamService.updatePositionName(p4, p5, p6);
            } catch (android.os.RemoteException v0_2) {
                android.util.Log.w("SlamManager", "changePosition: ", v0_2);
            }
        }
        return;
    }

    public boolean dance(int p2, com.boat.support.slam.IResponseListener p3)
    {
        if ((this.isNavigationInited()) && (!this.isInNavigation())) {
            if (this.slamService != null) {
                try {
                    this.slamService.dance(p2, p3);
                } catch (android.os.RemoteException v0_1) {
                    v0_1.printStackTrace();
                }
            }
            return 1;
        } else {
            return 0;
        }
    }

    public boolean deleteMap(String p2)
    {
        if (this.slamService != null) {
            try {
                return this.slamService.deleteMap(p2);
            } catch (android.os.RemoteException v0_3) {
                v0_3.printStackTrace();
            }
        }
        return 0;
    }

    public void deletePosition(String p4, com.boat.support.slam.IResponseListener p5)
    {
        if (this.slamService != null) {
            try {
                this.slamService.deletePosition(p4, p5);
            } catch (Exception v0_2) {
                android.util.Log.w("SlamManager", "deletePosition: ", v0_2);
            }
        }
        return;
    }

    public void downloadBag(com.boat.support.slam.IResponseListener p2)
    {
        if (this.slamService != null) {
            try {
                this.slamService.downloadBag(p2);
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }

    public void downloadMapData(String p2)
    {
        if (this.slamService != null) {
            try {
                this.slamService.downLoadMapData(p2);
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }

    public void forward()
    {
        this.move(4599075939470750515, 0);
        return;
    }

    public void forwardTo(double p3)
    {
        this.moveTo(p3, 4599075939470750515);
        return;
    }

    public com.boat.support.slam.entity.floors.MapList getAllFloor()
    {
        if (this.slamService != null) {
            try {
                return this.slamService.getAllFloor();
            } catch (android.os.RemoteException v0_3) {
                v0_3.printStackTrace();
            }
        }
        return 0;
    }

    public void getBagList(com.boat.support.slam.IResponseListener p2)
    {
        if (this.slamService != null) {
            try {
                this.slamService.getBagList(p2);
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }

    public int getBattery()
    {
        if (this.slamService != null) {
            try {
                return this.slamService.getBattery();
            } catch (android.os.RemoteException v0_4) {
                android.util.Log.w("SlamManager", "getBattery: ", v0_4);
            }
        }
        return -1;
    }

    public void getCurrentPositionInfo(com.boat.support.slam.IPositionResult p4)
    {
        if (this.slamService != null) {
            try {
                this.slamService.getCurrentPositionInfo(p4);
            } catch (android.os.RemoteException v0_2) {
                android.util.Log.w("SlamManager", "getPosition: ", v0_2);
            }
        }
        return;
    }

    public boolean getIsDebug()
    {
        if (this.slamService != null) {
            try {
                return this.slamService.getIsDebug();
            } catch (android.os.RemoteException v0_3) {
                v0_3.printStackTrace();
            }
        }
        return 0;
    }

    public com.boat.support.slam.entity.floors.Floors getLocalFloor()
    {
        if (this.slamService != null) {
            try {
                return this.slamService.getLocalFloors();
            } catch (android.os.RemoteException v0_3) {
                v0_3.printStackTrace();
            }
        }
        return 0;
    }

    public com.boat.support.slam.entity.floors.Maps getLocalMap()
    {
        if (this.slamService != null) {
            try {
                return this.slamService.getLocalMaps();
            } catch (android.os.RemoteException v0_3) {
                v0_3.printStackTrace();
            }
        }
        return 0;
    }

    public java.util.List getLocalMapPoint()
    {
        if (this.slamService != null) {
            try {
                return this.slamService.getLocalMapPoints();
            } catch (android.os.RemoteException v0_3) {
                v0_3.printStackTrace();
            }
        }
        return 0;
    }

    public void getMap(com.boat.support.slam.IResponseListener p4)
    {
        if (this.slamService != null) {
            try {
                this.slamService.getMap(p4);
            } catch (Exception v0_2) {
                android.util.Log.w("SlamManager", "addPosition: ", v0_2);
            }
        }
        return;
    }

    public int getMapStatus()
    {
        if (this.slamService != null) {
            try {
                return this.slamService.getMapStatus();
            } catch (android.os.RemoteException v0_3) {
                v0_3.printStackTrace();
            }
        }
        return 0;
    }

    public void getNaviVersion(com.boat.support.slam.IResponseListener p2)
    {
        if (this.slamService != null) {
            try {
                this.slamService.getVersion(p2);
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }

    public boolean goCharging(com.boat.support.slam.IResponseListener p5)
    {
        if (this.isNavigationInited()) {
            boolean v0_2 = 0;
            if (this.slamService != null) {
                try {
                    v0_2 = this.slamService.goCharging(p5);
                } catch (android.os.RemoteException v1_0) {
                    android.util.Log.w("SlamManager", "goCharging: ", v1_0);
                }
            }
            return v0_2;
        } else {
            return 0;
        }
    }

    public boolean isCharged()
    {
        if (this.slamService != null) {
            try {
                return this.slamService.isCharged();
            } catch (android.os.RemoteException v0_4) {
                android.util.Log.w("SlamManager", "isCharged: ", v0_4);
            }
        }
        return 0;
    }

    public boolean isEmergencyStop()
    {
        if (this.slamService != null) {
            try {
                return this.slamService.isEmergencyStop();
            } catch (android.os.RemoteException v0_4) {
                android.util.Log.w("SlamManager", "isEmergencyStop: ", v0_4);
            }
        }
        return 0;
    }

    public boolean isInGoCharging()
    {
        boolean v0 = 0;
        if (this.slamService != null) {
            try {
                v0 = this.slamService.isInGoCharging();
            } catch (android.os.RemoteException v1_3) {
                android.util.Log.w("SlamManager", "isInGoCharging: ", v1_3);
            }
        }
        return v0;
    }

    public boolean isInNavigation()
    {
        boolean v0 = 0;
        if (this.slamService != null) {
            try {
                v0 = this.slamService.isInNavigation();
            } catch (android.os.RemoteException v1_3) {
                android.util.Log.w("SlamManager", "isInNavigation: ", v1_3);
            }
        }
        return v0;
    }

    public boolean isLocationLoss()
    {
        if (this.slamService != null) {
            try {
                return this.slamService.isLocationLoss();
            } catch (android.os.RemoteException v0_4) {
                android.util.Log.w("SlamManager", "isLocationLoss: ", v0_4);
            }
        }
        return 0;
    }

    public boolean isMotorEnabled()
    {
        if (this.slamService != null) {
            try {
                return this.slamService.isMotorEnabled();
            } catch (android.os.RemoteException v0_4) {
                android.util.Log.w("SlamManager", "isMotorEnabled: ", v0_4);
            }
        }
        return 0;
    }

    public boolean isNaviNetWork()
    {
        if (this.slamService != null) {
            try {
                return this.slamService.isNaviNetWork();
            } catch (android.os.RemoteException v0_4) {
                android.util.Log.w("SlamManager", "isNaviNetWork: ", v0_4);
            }
        }
        return 0;
    }

    public boolean isNavigationInited()
    {
        if (this.slamService != null) {
            try {
                return this.slamService.isNavigationInited();
            } catch (android.os.RemoteException v0_3) {
                v0_3.printStackTrace();
            }
        }
        return 1;
    }

    public void move(double p4, double p6)
    {
        if (this.isNavigationInited()) {
            if (this.slamService != null) {
                try {
                    this.slamService.move(p4, p6);
                } catch (android.os.RemoteException v0_3) {
                    android.util.Log.w("SlamManager", "move: ", v0_3);
                }
            }
            return;
        } else {
            return;
        }
    }

    public void moveBackward()
    {
        this.moveAlways(-4626998257160447590, 0);
        return;
    }

    public void moveForward()
    {
        this.moveAlways(4599075939470750515, 0);
        return;
    }

    public void moveLeft()
    {
        this.moveAlways(0, 4600877379321698714);
        return;
    }

    public void moveRight()
    {
        this.moveAlways(0, -4622494657533077094);
        return;
    }

    public void moveStop()
    {
        this.moveAlways(0, 0);
        return;
    }

    public void naviTargetGoalPlanSlam(long p12, long p14, long p16, int p18, com.boat.support.slam.IResponseListener p19)
    {
        if (this.isNavigationInited()) {
            if (this.slamService != null) {
                try {
                    this.slamService.naviTargetGoalPlan(p12, p14, p16, p18, p19);
                } catch (android.os.RemoteException v0_0) {
                    android.util.Log.w("SlamManager", "navigationTo2: ", v0_0);
                }
            }
            return;
        } else {
            return;
        }
    }

    public void navigationTo(int p4, String p5, String p6, com.boat.support.slam.IResponseListener p7)
    {
        if (this.isNavigationInited()) {
            if (this.slamService != null) {
                try {
                    this.slamService.navigationTo(p4, p5, p6, p7);
                } catch (android.os.RemoteException v0_3) {
                    android.util.Log.w("SlamManager", "navigationTo: ", v0_3);
                }
            }
            return;
        } else {
            return;
        }
    }

    public void navigationTo2(String p4)
    {
        if (this.isNavigationInited()) {
            if (this.slamService != null) {
                try {
                    this.slamService.navigationTo2(p4);
                } catch (android.os.RemoteException v0_3) {
                    android.util.Log.w("SlamManager", "navigationTo2: ", v0_3);
                }
            }
            return;
        } else {
            return;
        }
    }

    public void onDestroy(android.content.Context p2)
    {
        if (this.connection != null) {
            this.unregist();
            p2.unbindService(this.connection);
        }
        return;
    }

    public void reNameMap(String p2, String p3)
    {
        if (this.slamService != null) {
            try {
                this.slamService.reNameMap(p2, p3);
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }

    public void reachPointStatus(boolean p4)
    {
        if (this.slamService != null) {
            try {
                this.slamService.reachPointStatus(p4);
            } catch (android.os.RemoteException v0_2) {
                android.util.Log.w("SlamManager", "reachPointStatus: ", v0_2);
            }
        }
        return;
    }

    public void recordBag(int p2, String p3, java.util.List p4)
    {
        if (this.slamService != null) {
            try {
                this.slamService.recordBag(p2, p3, p4);
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }

    public void regist()
    {
        if ((this.slamService != null) && (this.slamCallBack != null)) {
            try {
                this.slamService.registCallBack(this.slamCallBack);
            } catch (android.os.RemoteException v0_3) {
                android.util.Log.w("SlamManager", "regist: ", v0_3);
            }
        }
        return;
    }

    public void relocalization(String p2, com.boat.support.slam.IResponseListener p3)
    {
        if (this.slamService != null) {
            try {
                this.slamService.relocalization(p2, p3);
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }

    public void relocation(double p16, double p18, double p20, double p22, double p24, double p26)
    {
        if (this.slamService != null) {
            try {
                this.slamService.relocation(p16, p18, p20, p22, p24, p26);
            } catch (android.os.RemoteException v0_1) {
                v0_1.printStackTrace();
            }
        }
        return;
    }

    public void requestData(int p2)
    {
        if (this.slamService != null) {
            try {
                this.slamService.requestData(p2);
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }

    public void requestStopData(int p2)
    {
        if (this.slamService != null) {
            try {
                this.slamService.stopRequestData(p2);
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }

    public void requestString(String p2, String p3)
    {
        if (this.slamService != null) {
            try {
                this.slamService.requestString(p2, p3);
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }

    public void rotateAngle(int p4)
    {
        int v0_1;
        if (p4 >= 180) {
            v0_1 = (p4 + -360);
        } else {
            v0_1 = p4;
        }
        this.rotateTo(v0_1, 4600877379321698714);
        return;
    }

    public void rotateLeft()
    {
        this.move(0, 4600877379321698714);
        return;
    }

    public void rotateLeftTo(int p3)
    {
        this.rotateTo(p3, 4600877379321698714);
        return;
    }

    public void rotateRight()
    {
        this.move(0, -4622494657533077094);
        return;
    }

    public void rotateRightTo(int p4)
    {
        this.rotateTo((- p4), 4600877379321698714);
        return;
    }

    public void saveEraseMap()
    {
        if (this.slamService != null) {
            try {
                this.slamService.saveEraseMap();
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }

    public void saveMap(String p2)
    {
        if (this.slamService != null) {
            try {
                this.slamService.saveMap(p2);
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }

    public void setErase(double p2, double p4)
    {
        if (this.slamService != null) {
            try {
                this.slamService.setErase(p2, p4);
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }

    public void setEraseMode(int p2, com.boat.support.slam.IResponseListener p3)
    {
        if (this.slamService != null) {
            try {
                this.slamService.setEraseMode(p2, p3);
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }

    public void setInGoCharging(boolean p4)
    {
        if (this.slamService != null) {
            try {
                this.slamService.setInGoCharging(p4);
            } catch (android.os.RemoteException v0_2) {
                android.util.Log.w("SlamManager", "isInGoCharging: ", v0_2);
            }
        }
        return;
    }

    public void setIsDebug(boolean p2)
    {
        if (this.slamService != null) {
            try {
                this.slamService.setIsDebug(p2);
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }

    public void setMapRebuild()
    {
        if (this.slamService != null) {
            try {
                this.slamService.setMapReBuild();
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }

    public void setMapStatusBuild()
    {
        if (this.slamService != null) {
            try {
                this.slamService.setMapStatusBuild();
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }

    public void setOutofChange()
    {
        if (this.slamService != null) {
            try {
                this.slamService.setOutofChange();
            } catch (android.os.RemoteException v0_2) {
                android.util.Log.w("SlamManager", "setOutofChange: ", v0_2);
            }
        }
        return;
    }

    public void setShapArea(com.boat.support.slam.entity.floors.ShapeAreas p2, com.boat.support.slam.IResponseListener p3)
    {
        if (this.slamService != null) {
            try {
                this.slamService.setShapArea(p2, p3);
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }

    public void setWarnLedStatus(boolean p4)
    {
        if (this.slamService != null) {
            try {
                this.slamService.setWarnLedStatus(p4);
            } catch (android.os.RemoteException v0_2) {
                android.util.Log.w("SlamManager", "setWarnLedStatus: ", v0_2);
            }
        }
        return;
    }

    public void setWifiConfig(String p4, String p5)
    {
        if (this.slamService != null) {
            try {
                this.slamService.setWifiConfig(p4, p5);
            } catch (Exception v0_2) {
                android.util.Log.w("SlamManager", "setWifiConfig: ", v0_2);
            }
        }
        return;
    }

    public String startRecordBag(com.boat.support.slam.IResponseListener p2)
    {
        if (this.slamService != null) {
            try {
                return this.slamService.startRecordBag(p2);
            } catch (android.os.RemoteException v0_3) {
                v0_3.printStackTrace();
            }
        }
        return 0;
    }

    public void stop()
    {
        this.move(0, 0);
        return;
    }

    public void stopNavigation()
    {
        if (this.isNavigationInited()) {
            if (this.slamService != null) {
                try {
                    this.slamService.stopNavigation();
                } catch (android.os.RemoteException v0_3) {
                    android.util.Log.w("SlamManager", "stopNavigation: ", v0_3);
                }
            }
            return;
        } else {
            return;
        }
    }

    public String stopRecordBag(com.boat.support.slam.IResponseListener p2)
    {
        if (this.slamService != null) {
            try {
                return this.slamService.stopRecordBag(p2);
            } catch (android.os.RemoteException v0_3) {
                v0_3.printStackTrace();
            }
        }
        return 0;
    }

    public void updateHareware(com.boat.support.slam.IResponseListener p2)
    {
        if (this.slamService != null) {
            try {
                this.slamService.updateHareware(p2);
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }

    public void updateMap(String p2)
    {
        if (this.slamService != null) {
            try {
                this.slamService.updateMap(p2);
            } catch (android.os.RemoteException v0_2) {
                v0_2.printStackTrace();
            }
        }
        return;
    }

    public void updateStatus()
    {
        if (this.slamService != null) {
            try {
                this.slamService.updateStatus();
            } catch (Exception v0_2) {
                android.util.Log.w("SlamManager", "updateStatus: ", v0_2);
            }
        }
        return;
    }
}
