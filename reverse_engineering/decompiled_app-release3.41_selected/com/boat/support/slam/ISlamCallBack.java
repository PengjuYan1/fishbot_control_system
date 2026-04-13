package com.boat.support.slam;
public interface ISlamCallBack implements android.os.IInterface {
    public static final String DESCRIPTOR = "com.boat.support.slam.ISlamCallBack";

    public abstract void onBatteryChange();

    public abstract void onChangeMotionMode();

    public abstract void onChargeChanged();

    public abstract void onEmergencyStop();

    public abstract void onLocalizationLost();

    public abstract void onLocalizationStatus();

    public abstract void onMachineSignal();

    public abstract void onMapUpdate();

    public abstract void onMotorLock();

    public abstract void onMoveStatusChange();

    public abstract void onNaviGoalCallback();

    public abstract void onNaviNetWorkStatus();

    public abstract void onNaviToNameCallback();

    public abstract void onOutChangeStatus();

    public abstract void onResponseDatas();

    public abstract void onResponseString();

    public abstract void onSlamDownMapSucc();

    public abstract void onSlamInit();
}
