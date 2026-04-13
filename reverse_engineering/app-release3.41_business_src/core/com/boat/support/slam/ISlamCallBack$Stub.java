package com.boat.support.slam;
public abstract class ISlamCallBack$Stub extends android.os.Binder implements com.boat.support.slam.ISlamCallBack {
    static final int TRANSACTION_onBatteryChange = 4;
    static final int TRANSACTION_onChangeMotionMode = 16;
    static final int TRANSACTION_onChargeChanged = 1;
    static final int TRANSACTION_onEmergencyStop = 2;
    static final int TRANSACTION_onLocalizationLost = 5;
    static final int TRANSACTION_onLocalizationStatus = 15;
    static final int TRANSACTION_onMachineSignal = 18;
    static final int TRANSACTION_onMapUpdate = 14;
    static final int TRANSACTION_onMotorLock = 13;
    static final int TRANSACTION_onMoveStatusChange = 3;
    static final int TRANSACTION_onNaviGoalCallback = 9;
    static final int TRANSACTION_onNaviNetWorkStatus = 10;
    static final int TRANSACTION_onNaviToNameCallback = 8;
    static final int TRANSACTION_onOutChangeStatus = 17;
    static final int TRANSACTION_onResponseDatas = 6;
    static final int TRANSACTION_onResponseString = 12;
    static final int TRANSACTION_onSlamDownMapSucc = 11;
    static final int TRANSACTION_onSlamInit = 7;

    public ISlamCallBack$Stub()
    {
        this.attachInterface(this, "com.boat.support.slam.ISlamCallBack");
        return;
    }

    public static com.boat.support.slam.ISlamCallBack asInterface(android.os.IBinder p2)
    {
        if (p2 != null) {
            android.os.IInterface v0_2 = p2.queryLocalInterface("com.boat.support.slam.ISlamCallBack");
            if ((v0_2 == null) || (!(v0_2 instanceof com.boat.support.slam.ISlamCallBack))) {
                return new com.boat.support.slam.ISlamCallBack$Stub$Proxy(p2);
            } else {
                return ((com.boat.support.slam.ISlamCallBack) v0_2);
            }
        } else {
            return 0;
        }
    }

    public android.os.IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int p20, android.os.Parcel p21, android.os.Parcel p22, int p23)
    {
        if ((p20 >= 1) && (p20 <= 16777215)) {
            p21.enforceInterface("com.boat.support.slam.ISlamCallBack");
        }
        switch (p20) {
            case 1598968902:
                p22.writeString("com.boat.support.slam.ISlamCallBack");
                return 1;
            default:
                int v0_0 = 0;
                switch (p20) {
                    case 1:
                        if (p21.readInt() != 0) {
                            v0_0 = 1;
                        }
                        this.onChargeChanged(v0_0);
                        p22.writeNoException();
                        break;
                    case 2:
                        if (p21.readInt() != 0) {
                            v0_0 = 1;
                        }
                        this.onEmergencyStop(v0_0);
                        p22.writeNoException();
                        break;
                    case 3:
                        this.onMoveStatusChange(p21.readString());
                        p22.writeNoException();
                        break;
                    case 4:
                        this.onBatteryChange(p21.readInt());
                        p22.writeNoException();
                        break;
                    case 5:
                        this.onLocalizationLost();
                        p22.writeNoException();
                        break;
                    case 6:
                        this.onResponseDatas(p21.readInt(), p21.readString());
                        p22.writeNoException();
                        break;
                    case 7:
                        this.onSlamInit();
                        p22.writeNoException();
                        break;
                    case 8:
                        this.onNaviToNameCallback(p21.readString());
                        p22.writeNoException();
                        break;
                    case 9:
                        this.onNaviGoalCallback(p21.readLong(), p21.readLong(), p21.readLong());
                        p22.writeNoException();
                        break;
                    case 10:
                        if (p21.readInt() != 0) {
                            v0_0 = 1;
                        }
                        this.onNaviNetWorkStatus(v0_0);
                        p22.writeNoException();
                        break;
                    case 11:
                        this.onSlamDownMapSucc();
                        p22.writeNoException();
                        break;
                    case 12:
                        this.onResponseString(p21.readString(), p21.readString());
                        p22.writeNoException();
                        break;
                    case 13:
                        if (p21.readInt() != 0) {
                            v0_0 = 1;
                        }
                        this.onMotorLock(v0_0);
                        p22.writeNoException();
                        break;
                    case 14:
                        this.onMapUpdate();
                        p22.writeNoException();
                        break;
                    case 15:
                        this.onLocalizationStatus(p21.readInt());
                        p22.writeNoException();
                        break;
                    case 16:
                        this.onChangeMotionMode(p21.readInt());
                        p22.writeNoException();
                        break;
                    case 17:
                        this.onOutChangeStatus(p21.readInt());
                        p22.writeNoException();
                        break;
                    case 18:
                        if (p21.readInt() != 0) {
                            v0_0 = 1;
                        }
                        this.onMachineSignal(v0_0);
                        p22.writeNoException();
                        break;
                    default:
                        return super.onTransact(p20, p21, p22, p23);
                }
                return 1;
        }
    }
}
