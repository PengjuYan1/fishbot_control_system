package com.boat.support.slam;
public abstract class IResponseListener$Stub extends android.os.Binder implements com.boat.support.slam.IResponseListener {
    static final int TRANSACTION_onFailed = 2;
    static final int TRANSACTION_onSuccess = 1;

    public IResponseListener$Stub()
    {
        this.attachInterface(this, "com.boat.support.slam.IResponseListener");
        return;
    }

    public static com.boat.support.slam.IResponseListener asInterface(android.os.IBinder p2)
    {
        if (p2 != null) {
            android.os.IInterface v0_2 = p2.queryLocalInterface("com.boat.support.slam.IResponseListener");
            if ((v0_2 == null) || (!(v0_2 instanceof com.boat.support.slam.IResponseListener))) {
                return new com.boat.support.slam.IResponseListener$Stub$Proxy(p2);
            } else {
                return ((com.boat.support.slam.IResponseListener) v0_2);
            }
        } else {
            return 0;
        }
    }

    public android.os.IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int p4, android.os.Parcel p5, android.os.Parcel p6, int p7)
    {
        if ((p4 >= 1) && (p4 <= 16777215)) {
            p5.enforceInterface("com.boat.support.slam.IResponseListener");
        }
        switch (p4) {
            case 1598968902:
                p6.writeString("com.boat.support.slam.IResponseListener");
                return 1;
            default:
                switch (p4) {
                    case 1:
                        this.onSuccess(p5.readString());
                        p6.writeNoException();
                        break;
                    case 2:
                        this.onFailed(p5.readString());
                        p6.writeNoException();
                        break;
                    default:
                        return super.onTransact(p4, p5, p6, p7);
                }
                return 1;
        }
    }
}
