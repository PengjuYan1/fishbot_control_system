package com.boat.support.slam;
 class ISlamCallBack$Stub$Proxy implements com.boat.support.slam.ISlamCallBack {
    private android.os.IBinder mRemote;

    ISlamCallBack$Stub$Proxy(android.os.IBinder p1)
    {
        this.mRemote = p1;
        return;
    }

    public android.os.IBinder asBinder()
    {
        return this.mRemote;
    }

    public String getInterfaceDescriptor()
    {
        return "com.boat.support.slam.ISlamCallBack";
    }

    public void onBatteryChange(int p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamCallBack");
            v0.writeInt(p6);
            this.mRemote.transact(4, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void onChangeMotionMode(int p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamCallBack");
            v0.writeInt(p6);
            this.mRemote.transact(16, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void onChargeChanged(boolean p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            android.os.IBinder v4_0;
            v0.writeInterfaceToken("com.boat.support.slam.ISlamCallBack");
        } catch (boolean v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
        if (!p6) {
            v4_0 = 0;
        } else {
            v4_0 = 1;
        }
        v0.writeInt(v4_0);
        this.mRemote.transact(1, v0, v1, 0);
        v1.readException();
        v1.recycle();
        v0.recycle();
        return;
    }

    public void onEmergencyStop(boolean p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            android.os.IBinder v3_1;
            v0.writeInterfaceToken("com.boat.support.slam.ISlamCallBack");
        } catch (boolean v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
        if (!p6) {
            v3_1 = 0;
        } else {
            v3_1 = 1;
        }
        v0.writeInt(v3_1);
        this.mRemote.transact(2, v0, v1, 0);
        v1.readException();
        v1.recycle();
        v0.recycle();
        return;
    }

    public void onLocalizationLost()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamCallBack");
            this.mRemote.transact(5, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void onLocalizationStatus(int p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamCallBack");
            v0.writeInt(p6);
            this.mRemote.transact(15, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void onMachineSignal(boolean p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            android.os.IBinder v3_1;
            v0.writeInterfaceToken("com.boat.support.slam.ISlamCallBack");
        } catch (boolean v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
        if (!p6) {
            v3_1 = 0;
        } else {
            v3_1 = 1;
        }
        v0.writeInt(v3_1);
        this.mRemote.transact(18, v0, v1, 0);
        v1.readException();
        v1.recycle();
        v0.recycle();
        return;
    }

    public void onMapUpdate()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamCallBack");
            this.mRemote.transact(14, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void onMotorLock(boolean p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            android.os.IBinder v3_1;
            v0.writeInterfaceToken("com.boat.support.slam.ISlamCallBack");
        } catch (boolean v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
        if (!p6) {
            v3_1 = 0;
        } else {
            v3_1 = 1;
        }
        v0.writeInt(v3_1);
        this.mRemote.transact(13, v0, v1, 0);
        v1.readException();
        v1.recycle();
        v0.recycle();
        return;
    }

    public void onMoveStatusChange(String p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamCallBack");
            v0.writeString(p6);
            this.mRemote.transact(3, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void onNaviGoalCallback(long p6, long p8, long p10)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamCallBack");
            v0.writeLong(p6);
            v0.writeLong(p8);
            v0.writeLong(p10);
            this.mRemote.transact(9, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void onNaviNetWorkStatus(boolean p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            android.os.IBinder v3_1;
            v0.writeInterfaceToken("com.boat.support.slam.ISlamCallBack");
        } catch (boolean v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
        if (!p6) {
            v3_1 = 0;
        } else {
            v3_1 = 1;
        }
        v0.writeInt(v3_1);
        this.mRemote.transact(10, v0, v1, 0);
        v1.readException();
        v1.recycle();
        v0.recycle();
        return;
    }

    public void onNaviToNameCallback(String p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamCallBack");
            v0.writeString(p6);
            this.mRemote.transact(8, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void onOutChangeStatus(int p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamCallBack");
            v0.writeInt(p6);
            this.mRemote.transact(17, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void onResponseDatas(int p6, String p7)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamCallBack");
            v0.writeInt(p6);
            v0.writeString(p7);
            this.mRemote.transact(6, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void onResponseString(String p6, String p7)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamCallBack");
            v0.writeString(p6);
            v0.writeString(p7);
            this.mRemote.transact(12, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void onSlamDownMapSucc()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamCallBack");
            this.mRemote.transact(11, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }

    public void onSlamInit()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.ISlamCallBack");
            this.mRemote.transact(7, v0, v1, 0);
            v1.readException();
            v1.recycle();
            v0.recycle();
            return;
        } catch (Throwable v2_0) {
            v1.recycle();
            v0.recycle();
            throw v2_0;
        }
    }
}
