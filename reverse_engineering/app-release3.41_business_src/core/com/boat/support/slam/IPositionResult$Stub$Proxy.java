package com.boat.support.slam;
 class IPositionResult$Stub$Proxy implements com.boat.support.slam.IPositionResult {
    private android.os.IBinder mRemote;

    IPositionResult$Stub$Proxy(android.os.IBinder p1)
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
        return "com.boat.support.slam.IPositionResult";
    }

    public void onPosition(com.boat.support.slam.entity.floors.Points p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.IPositionResult");
            com.boat.support.slam.IPositionResult$_Parcel.access$100(v0, p6, 0);
            this.mRemote.transact(1, v0, v1, 0);
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
