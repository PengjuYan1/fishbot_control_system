package com.boat.support.slam;
public abstract class IBitmapService$Stub extends android.os.Binder implements com.boat.support.slam.IBitmapService {
    static final int TRANSACTION_getIntentBitmap = 1;
    static final int TRANSACTION_getOriginX = 3;
    static final int TRANSACTION_getOriginY = 4;
    static final int TRANSACTION_getResolution = 2;

    public IBitmapService$Stub()
    {
        this.attachInterface(this, "com.boat.support.slam.IBitmapService");
        return;
    }

    public static com.boat.support.slam.IBitmapService asInterface(android.os.IBinder p2)
    {
        if (p2 != null) {
            android.os.IInterface v0_2 = p2.queryLocalInterface("com.boat.support.slam.IBitmapService");
            if ((v0_2 == null) || (!(v0_2 instanceof com.boat.support.slam.IBitmapService))) {
                return new com.boat.support.slam.IBitmapService$Stub$Proxy(p2);
            } else {
                return ((com.boat.support.slam.IBitmapService) v0_2);
            }
        } else {
            return 0;
        }
    }

    public android.os.IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int p5, android.os.Parcel p6, android.os.Parcel p7, int p8)
    {
        if ((p5 >= 1) && (p5 <= 16777215)) {
            p6.enforceInterface("com.boat.support.slam.IBitmapService");
        }
        switch (p5) {
            case 1598968902:
                p7.writeString("com.boat.support.slam.IBitmapService");
                return 1;
            default:
                switch (p5) {
                    case 1:
                        double v2_3 = this.getIntentBitmap();
                        p7.writeNoException();
                        com.boat.support.slam.IBitmapService$_Parcel.access$000(p7, v2_3, 1);
                        break;
                    case 2:
                        double v2_2 = this.getResolution();
                        p7.writeNoException();
                        p7.writeFloat(v2_2);
                        break;
                    case 3:
                        double v2_1 = this.getOriginX();
                        p7.writeNoException();
                        p7.writeDouble(v2_1);
                        break;
                    case 4:
                        double v2_0 = this.getOriginY();
                        p7.writeNoException();
                        p7.writeDouble(v2_0);
                        break;
                    default:
                        return super.onTransact(p5, p6, p7, p8);
                }
                return 1;
        }
    }
}
