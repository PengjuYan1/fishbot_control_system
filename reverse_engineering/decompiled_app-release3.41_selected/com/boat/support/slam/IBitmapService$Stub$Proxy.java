package com.boat.support.slam;
 class IBitmapService$Stub$Proxy implements com.boat.support.slam.IBitmapService {
    private android.os.IBinder mRemote;

    IBitmapService$Stub$Proxy(android.os.IBinder p1)
    {
        this.mRemote = p1;
        return;
    }

    public android.os.IBinder asBinder()
    {
        return this.mRemote;
    }

    public android.graphics.Bitmap getIntentBitmap()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.IBitmapService");
            this.mRemote.transact(1, v0, v1, 0);
            v1.readException();
            Throwable v2_0 = ((android.graphics.Bitmap) com.boat.support.slam.IBitmapService$_Parcel.access$100(v1, android.graphics.Bitmap.CREATOR));
            v1.recycle();
            v0.recycle();
            return v2_0;
        } catch (Throwable v2_1) {
            v1.recycle();
            v0.recycle();
            throw v2_1;
        }
    }

    public String getInterfaceDescriptor()
    {
        return "com.boat.support.slam.IBitmapService";
    }

    public double getOriginX()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.IBitmapService");
            this.mRemote.transact(3, v0, v1, 0);
            v1.readException();
            Throwable v2_0 = v1.readDouble();
            v1.recycle();
            v0.recycle();
            return v2_0;
        } catch (Throwable v2_1) {
            v1.recycle();
            v0.recycle();
            throw v2_1;
        }
    }

    public double getOriginY()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.IBitmapService");
            this.mRemote.transact(4, v0, v1, 0);
            v1.readException();
            Throwable v2_0 = v1.readDouble();
            v1.recycle();
            v0.recycle();
            return v2_0;
        } catch (Throwable v2_1) {
            v1.recycle();
            v0.recycle();
            throw v2_1;
        }
    }

    public float getResolution()
    {
        android.os.Parcel v0 = android.os.Parcel.obtain();
        android.os.Parcel v1 = android.os.Parcel.obtain();
        try {
            v0.writeInterfaceToken("com.boat.support.slam.IBitmapService");
            this.mRemote.transact(2, v0, v1, 0);
            v1.readException();
            Throwable v2_0 = v1.readFloat();
            v1.recycle();
            v0.recycle();
            return v2_0;
        } catch (Throwable v2_1) {
            v1.recycle();
            v0.recycle();
            throw v2_1;
        }
    }
}
