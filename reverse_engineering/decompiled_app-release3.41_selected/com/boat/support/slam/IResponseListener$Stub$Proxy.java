package com.boat.support.slam;
 class IResponseListener$Stub$Proxy implements com.boat.support.slam.IResponseListener {
    private android.os.IBinder mRemote;

    IResponseListener$Stub$Proxy(android.os.IBinder p1)
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
        return "com.boat.support.slam.IResponseListener";
    }

    public void onFailed(String p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.IResponseListener");
            v0.writeString(p6);
            this.mRemote.transact(2, v0, v1, 0);
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

    public void onSuccess(String p6)
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.IResponseListener");
            v0.writeString(p6);
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
