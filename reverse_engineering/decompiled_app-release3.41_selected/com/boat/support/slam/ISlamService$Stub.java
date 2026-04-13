package com.boat.support.slam;
public abstract class ISlamService$Stub extends android.os.Binder implements com.boat.support.slam.ISlamService {
    static final int TRANSACTION_addCurrentPosition = 11;
    static final int TRANSACTION_addPosition = 59;
    static final int TRANSACTION_dance = 57;
    static final int TRANSACTION_deleteMap = 27;
    static final int TRANSACTION_deletePosition = 12;
    static final int TRANSACTION_downLoadMapData = 60;
    static final int TRANSACTION_downloadBag = 51;
    static final int TRANSACTION_getAllFloor = 33;
    static final int TRANSACTION_getBagList = 41;
    static final int TRANSACTION_getBattery = 46;
    static final int TRANSACTION_getCurrentPositionInfo = 14;
    static final int TRANSACTION_getIsDebug = 55;
    static final int TRANSACTION_getListMaps = 35;
    static final int TRANSACTION_getLocalFloors = 34;
    static final int TRANSACTION_getLocalMapPoints = 37;
    static final int TRANSACTION_getLocalMaps = 36;
    static final int TRANSACTION_getMap = 30;
    static final int TRANSACTION_getMapStatus = 19;
    static final int TRANSACTION_getVersion = 53;
    static final int TRANSACTION_goCharging = 8;
    static final int TRANSACTION_isCharged = 42;
    static final int TRANSACTION_isEmergencyStop = 43;
    static final int TRANSACTION_isInGoCharging = 9;
    static final int TRANSACTION_isInNavigation = 7;
    static final int TRANSACTION_isLocationLoss = 45;
    static final int TRANSACTION_isMotorEnabled = 44;
    static final int TRANSACTION_isNaviNetWork = 48;
    static final int TRANSACTION_isNavigationInited = 47;
    static final int TRANSACTION_move = 15;
    static final int TRANSACTION_moveAlways = 16;
    static final int TRANSACTION_moveTo = 17;
    static final int TRANSACTION_naviTargetGoalPlan = 5;
    static final int TRANSACTION_navigationTo = 3;
    static final int TRANSACTION_navigationTo2 = 4;
    static final int TRANSACTION_reNameMap = 28;
    static final int TRANSACTION_reachPointStatus = 64;
    static final int TRANSACTION_recordBag = 40;
    static final int TRANSACTION_registCallBack = 1;
    static final int TRANSACTION_relocalization = 56;
    static final int TRANSACTION_relocation = 58;
    static final int TRANSACTION_requestData = 38;
    static final int TRANSACTION_requestString = 61;
    static final int TRANSACTION_rotateTo = 18;
    static final int TRANSACTION_saveEraseMap = 26;
    static final int TRANSACTION_saveMap = 25;
    static final int TRANSACTION_setErase = 23;
    static final int TRANSACTION_setEraseMode = 22;
    static final int TRANSACTION_setInGoCharging = 10;
    static final int TRANSACTION_setIsDebug = 54;
    static final int TRANSACTION_setMapReBuild = 21;
    static final int TRANSACTION_setMapStatusBuild = 20;
    static final int TRANSACTION_setOutofChange = 62;
    static final int TRANSACTION_setShapArea = 29;
    static final int TRANSACTION_setWarnLedStatus = 63;
    static final int TRANSACTION_setWifiConfig = 31;
    static final int TRANSACTION_startRecordBag = 49;
    static final int TRANSACTION_stopNavigation = 6;
    static final int TRANSACTION_stopRecordBag = 50;
    static final int TRANSACTION_stopRequestData = 39;
    static final int TRANSACTION_unregistCallBack = 2;
    static final int TRANSACTION_updateHareware = 52;
    static final int TRANSACTION_updateMap = 24;
    static final int TRANSACTION_updatePositionName = 13;
    static final int TRANSACTION_updateStatus = 32;

    public ISlamService$Stub()
    {
        this.attachInterface(this, "com.boat.support.slam.ISlamService");
        return;
    }

    public static com.boat.support.slam.ISlamService asInterface(android.os.IBinder p2)
    {
        if (p2 != null) {
            android.os.IInterface v0_2 = p2.queryLocalInterface("com.boat.support.slam.ISlamService");
            if ((v0_2 == null) || (!(v0_2 instanceof com.boat.support.slam.ISlamService))) {
                return new com.boat.support.slam.ISlamService$Stub$Proxy(p2);
            } else {
                return ((com.boat.support.slam.ISlamService) v0_2);
            }
        } else {
            return 0;
        }
    }

    public android.os.IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int p32, android.os.Parcel p33, android.os.Parcel p34, int p35)
    {
        if ((p32 >= 1) && (p32 <= 16777215)) {
            p33.enforceInterface("com.boat.support.slam.ISlamService");
        }
        switch (p32) {
            case 1598968902:
                p34.writeString("com.boat.support.slam.ISlamService");
                return 1;
            default:
                int v10_0;
                double v0_2 = 0;
                switch (p32) {
                    case 1:
                        android.os.Parcel v11 = p33;
                        v10_0 = 1;
                        this.registCallBack(com.boat.support.slam.ISlamCallBack$Stub.asInterface(p33.readStrongBinder()));
                        p34.writeNoException();
                        break;
                    case 2:
                        v11 = p33;
                        v10_0 = 1;
                        this.unregistCallBack(com.boat.support.slam.ISlamCallBack$Stub.asInterface(p33.readStrongBinder()));
                        p34.writeNoException();
                        break;
                    case 3:
                        v11 = p33;
                        v10_0 = 1;
                        this.navigationTo(p33.readInt(), p33.readString(), p33.readString(), com.boat.support.slam.IResponseListener$Stub.asInterface(p33.readStrongBinder()));
                        p34.writeNoException();
                        break;
                    case 4:
                        v11 = p33;
                        v10_0 = 1;
                        this.navigationTo2(p33.readString());
                        p34.writeNoException();
                        break;
                    case 5:
                        v11 = p33;
                        v10_0 = 1;
                        this.naviTargetGoalPlan(p33.readLong(), p33.readLong(), p33.readLong(), p33.readInt(), com.boat.support.slam.IResponseListener$Stub.asInterface(p33.readStrongBinder()));
                        p34.writeNoException();
                        break;
                    case 6:
                        v11 = p33;
                        v10_0 = 1;
                        this.stopNavigation();
                        p34.writeNoException();
                        break;
                    case 7:
                        v11 = p33;
                        v10_0 = 1;
                        double v0_60 = this.isInNavigation();
                        p34.writeNoException();
                        p34.writeInt(v0_60);
                        break;
                    case 8:
                        v11 = p33;
                        v10_0 = 1;
                        int v1_26 = this.goCharging(com.boat.support.slam.IResponseListener$Stub.asInterface(p33.readStrongBinder()));
                        p34.writeNoException();
                        p34.writeInt(v1_26);
                        break;
                    case 9:
                        v11 = p33;
                        v10_0 = 1;
                        double v0_57 = this.isInGoCharging();
                        p34.writeNoException();
                        p34.writeInt(v0_57);
                        break;
                    case 10:
                        v11 = p33;
                        v10_0 = 1;
                        if (p33.readInt() != 0) {
                            v0_2 = 1;
                        }
                        this.setInGoCharging(v0_2);
                        p34.writeNoException();
                        break;
                    case 11:
                        v11 = p33;
                        v10_0 = 1;
                        this.addCurrentPosition(p33.readString(), com.boat.support.slam.IResponseListener$Stub.asInterface(p33.readStrongBinder()));
                        p34.writeNoException();
                        break;
                    case 12:
                        v11 = p33;
                        v10_0 = 1;
                        this.deletePosition(p33.readString(), com.boat.support.slam.IResponseListener$Stub.asInterface(p33.readStrongBinder()));
                        p34.writeNoException();
                        break;
                    case 13:
                        v11 = p33;
                        v10_0 = 1;
                        this.updatePositionName(p33.readString(), p33.readString(), com.boat.support.slam.IResponseListener$Stub.asInterface(p33.readStrongBinder()));
                        p34.writeNoException();
                        break;
                    case 14:
                        v11 = p33;
                        v10_0 = 1;
                        this.getCurrentPositionInfo(com.boat.support.slam.IPositionResult$Stub.asInterface(p33.readStrongBinder()));
                        p34.writeNoException();
                        break;
                    case 15:
                        v11 = p33;
                        v10_0 = 1;
                        this.move(p33.readDouble(), p33.readDouble());
                        p34.writeNoException();
                        break;
                    case 16:
                        v11 = p33;
                        v10_0 = 1;
                        this.moveAlways(p33.readDouble(), p33.readDouble());
                        p34.writeNoException();
                        break;
                    case 17:
                        v11 = p33;
                        v10_0 = 1;
                        this.moveTo(p33.readDouble(), p33.readDouble());
                        p34.writeNoException();
                        break;
                    case 18:
                        v11 = p33;
                        v10_0 = 1;
                        this.rotateTo(p33.readInt(), p33.readDouble());
                        p34.writeNoException();
                        break;
                    case 19:
                        v11 = p33;
                        v10_0 = 1;
                        double v0_46 = this.getMapStatus();
                        p34.writeNoException();
                        p34.writeInt(v0_46);
                        break;
                    case 20:
                        v11 = p33;
                        v10_0 = 1;
                        this.setMapStatusBuild();
                        p34.writeNoException();
                        break;
                    case 21:
                        v11 = p33;
                        v10_0 = 1;
                        this.setMapReBuild();
                        p34.writeNoException();
                        break;
                    case 22:
                        v11 = p33;
                        v10_0 = 1;
                        this.setEraseMode(p33.readInt(), com.boat.support.slam.IResponseListener$Stub.asInterface(p33.readStrongBinder()));
                        p34.writeNoException();
                        break;
                    case 23:
                        v11 = p33;
                        v10_0 = 1;
                        this.setErase(p33.readDouble(), p33.readDouble());
                        p34.writeNoException();
                        break;
                    case 24:
                        v11 = p33;
                        v10_0 = 1;
                        this.updateMap(p33.readString());
                        p34.writeNoException();
                        break;
                    case 25:
                        v11 = p33;
                        v10_0 = 1;
                        this.saveMap(p33.readString());
                        p34.writeNoException();
                        break;
                    case 26:
                        v11 = p33;
                        v10_0 = 1;
                        this.saveEraseMap();
                        p34.writeNoException();
                        break;
                    case 27:
                        v11 = p33;
                        v10_0 = 1;
                        int v1_15 = this.deleteMap(p33.readString());
                        p34.writeNoException();
                        p34.writeInt(v1_15);
                        break;
                    case 28:
                        v11 = p33;
                        v10_0 = 1;
                        double v2_1 = this.reNameMap(p33.readString(), p33.readString());
                        p34.writeNoException();
                        p34.writeInt(v2_1);
                        break;
                    case 29:
                        double v9 = p34;
                        v10_0 = 1;
                        this.setShapArea(((com.boat.support.slam.entity.floors.ShapeAreas) com.boat.support.slam.ISlamService$_Parcel.access$000(p33, com.boat.support.slam.entity.floors.ShapeAreas.CREATOR)), com.boat.support.slam.IResponseListener$Stub.asInterface(p33.readStrongBinder()));
                        p34.writeNoException();
                        break;
                    case 30:
                        v9 = p34;
                        v10_0 = 1;
                        this.getMap(com.boat.support.slam.IResponseListener$Stub.asInterface(p33.readStrongBinder()));
                        p34.writeNoException();
                        break;
                    case 31:
                        v9 = p34;
                        v10_0 = 1;
                        this.setWifiConfig(p33.readString(), p33.readString());
                        p34.writeNoException();
                        break;
                    case 32:
                        v9 = p34;
                        v10_0 = 1;
                        this.updateStatus();
                        p34.writeNoException();
                        break;
                    case 33:
                        v10_0 = 1;
                        double v0_32 = this.getAllFloor();
                        p34.writeNoException();
                        com.boat.support.slam.ISlamService$_Parcel.access$100(p34, v0_32, 1);
                        break;
                    case 34:
                        v10_0 = 1;
                        double v0_31 = this.getLocalFloors();
                        p34.writeNoException();
                        com.boat.support.slam.ISlamService$_Parcel.access$100(p34, v0_31, 1);
                        break;
                    case 35:
                        v10_0 = 1;
                        double v0_30 = this.getListMaps();
                        p34.writeNoException();
                        com.boat.support.slam.ISlamService$_Parcel.access$200(p34, v0_30, 1);
                        break;
                    case 36:
                        v10_0 = 1;
                        double v0_29 = this.getLocalMaps();
                        p34.writeNoException();
                        com.boat.support.slam.ISlamService$_Parcel.access$100(p34, v0_29, 1);
                        break;
                    case 37:
                        double v0_28 = this.getLocalMapPoints();
                        p34.writeNoException();
                        v10_0 = 1;
                        com.boat.support.slam.ISlamService$_Parcel.access$200(p34, v0_28, 1);
                        break;
                    case 38:
                        v9 = p34;
                        this.requestData(p33.readInt());
                        p34.writeNoException();
                        v10_0 = 1;
                        break;
                    case 39:
                        v9 = p34;
                        this.stopRequestData(p33.readInt());
                        p34.writeNoException();
                        v10_0 = 1;
                        break;
                    case 40:
                        v9 = p34;
                        this.recordBag(p33.readInt(), p33.readString(), p33.createStringArrayList());
                        p34.writeNoException();
                        v10_0 = 1;
                        break;
                    case 41:
                        v9 = p34;
                        this.getBagList(com.boat.support.slam.IResponseListener$Stub.asInterface(p33.readStrongBinder()));
                        p34.writeNoException();
                        v10_0 = 1;
                        break;
                    case 42:
                        double v0_22 = this.isCharged();
                        p34.writeNoException();
                        p34.writeInt(v0_22);
                        v10_0 = 1;
                        break;
                    case 43:
                        double v0_21 = this.isEmergencyStop();
                        p34.writeNoException();
                        p34.writeInt(v0_21);
                        v10_0 = 1;
                        break;
                    case 44:
                        double v0_20 = this.isMotorEnabled();
                        p34.writeNoException();
                        p34.writeInt(v0_20);
                        v10_0 = 1;
                        break;
                    case 45:
                        double v0_19 = this.isLocationLoss();
                        p34.writeNoException();
                        p34.writeInt(v0_19);
                        v10_0 = 1;
                        break;
                    case 46:
                        double v0_18 = this.getBattery();
                        p34.writeNoException();
                        p34.writeInt(v0_18);
                        v10_0 = 1;
                        break;
                    case 47:
                        double v0_17 = this.isNavigationInited();
                        p34.writeNoException();
                        p34.writeInt(v0_17);
                        v10_0 = 1;
                        break;
                    case 48:
                        double v0_16 = this.isNaviNetWork();
                        p34.writeNoException();
                        p34.writeInt(v0_16);
                        v10_0 = 1;
                        break;
                    case 49:
                        int v1_8 = this.startRecordBag(com.boat.support.slam.IResponseListener$Stub.asInterface(p33.readStrongBinder()));
                        p34.writeNoException();
                        p34.writeString(v1_8);
                        v10_0 = 1;
                        break;
                    case 50:
                        int v1_7 = this.stopRecordBag(com.boat.support.slam.IResponseListener$Stub.asInterface(p33.readStrongBinder()));
                        p34.writeNoException();
                        p34.writeString(v1_7);
                        v10_0 = 1;
                        break;
                    case 51:
                        v9 = p34;
                        this.downloadBag(com.boat.support.slam.IResponseListener$Stub.asInterface(p33.readStrongBinder()));
                        p34.writeNoException();
                        v10_0 = 1;
                        break;
                    case 52:
                        v9 = p34;
                        this.updateHareware(com.boat.support.slam.IResponseListener$Stub.asInterface(p33.readStrongBinder()));
                        p34.writeNoException();
                        v10_0 = 1;
                        break;
                    case 53:
                        v9 = p34;
                        this.getVersion(com.boat.support.slam.IResponseListener$Stub.asInterface(p33.readStrongBinder()));
                        p34.writeNoException();
                        v10_0 = 1;
                        break;
                    case 54:
                        android.os.Parcel v11_1;
                        v9 = p34;
                        if (p33.readInt() == 0) {
                            v11_1 = 0;
                        } else {
                            v11_1 = 1;
                        }
                        this.setIsDebug(v11_1);
                        p34.writeNoException();
                        v10_0 = 1;
                        break;
                    case 55:
                        double v0_4 = this.getIsDebug();
                        p34.writeNoException();
                        p34.writeInt(v0_4);
                        v10_0 = 1;
                        break;
                    case 56:
                        this.relocalization(p33.readString(), com.boat.support.slam.IResponseListener$Stub.asInterface(p33.readStrongBinder()));
                        p34.writeNoException();
                        v9 = p34;
                        v10_0 = 1;
                        break;
                    case 57:
                        this.dance(p33.readInt(), com.boat.support.slam.IResponseListener$Stub.asInterface(p33.readStrongBinder()));
                        p34.writeNoException();
                        v9 = p34;
                        v10_0 = 1;
                        break;
                    case 58:
                        this.relocation(p33.readDouble(), p33.readDouble(), p33.readDouble(), p33.readDouble(), p33.readDouble(), p33.readDouble());
                        p34.writeNoException();
                        v9 = p34;
                        v10_0 = 1;
                        break;
                    case 59:
                        this.addPosition(p33.readString(), p33.readDouble(), p33.readDouble(), p33.readDouble(), p33.readDouble(), p33.readDouble(), p33.readDouble(), com.boat.support.slam.IResponseListener$Stub.asInterface(p33.readStrongBinder()));
                        p34.writeNoException();
                        v9 = p34;
                        v10_0 = 1;
                        break;
                    case 60:
                        this.downLoadMapData(p33.readString());
                        p34.writeNoException();
                        v11 = p33;
                        v10_0 = 1;
                        break;
                    case 61:
                        this.requestString(p33.readString(), p33.readString());
                        p34.writeNoException();
                        v11 = p33;
                        v10_0 = 1;
                        break;
                    case 62:
                        this.setOutofChange();
                        p34.writeNoException();
                        v11 = p33;
                        v10_0 = 1;
                        break;
                    case 63:
                        if (p33.readInt() != 0) {
                            v0_2 = 1;
                        }
                        this.setWarnLedStatus(v0_2);
                        p34.writeNoException();
                        v11 = p33;
                        v10_0 = 1;
                        break;
                    case 64:
                        if (p33.readInt() != 0) {
                            v0_2 = 1;
                        }
                        this.reachPointStatus(v0_2);
                        p34.writeNoException();
                        v11 = p33;
                        v10_0 = 1;
                        break;
                    default:
                        v9 = p34;
                        return super.onTransact(p32, p33, p34, p35);
                }
                return v10_0;
        }
    }
}
