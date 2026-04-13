package com.boat.support.slam;
public abstract class IPositionResult$Stub extends android.os.Binder implements com.boat.support.slam.IPositionResult {
    static final int TRANSACTION_onPosition = 1;

    public IPositionResult$Stub()
    {
        this.attachInterface(this, "com.boat.support.slam.IPositionResult");
        return;
    }

    public static com.boat.support.slam.IPositionResult asInterface(android.os.IBinder p2)
    {
        if (p2 != null) {
            android.os.IInterface v0_2 = p2.queryLocalInterface("com.boat.support.slam.IPositionResult");
            if ((v0_2 == null) || (!(v0_2 instanceof com.boat.support.slam.IPositionResult))) {
                return new com.boat.support.slam.IPositionResult$Stub$Proxy(p2);
            } else {
                return ((com.boat.support.slam.IPositionResult) v0_2);
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
            p5.enforceInterface("com.boat.support.slam.IPositionResult");
        }
        switch (p4) {
            case 1598968902:
                p6.writeString("com.boat.support.slam.IPositionResult");
                return 1;
            default:
                switch (p4) {
                    case 1:
                        this.onPosition(((com.boat.support.slam.entity.floors.Points) com.boat.support.slam.IPositionResult$_Parcel.access$000(p5, com.boat.support.slam.entity.floors.Points.CREATOR)));
                        p6.writeNoException();
                        return 1;
                    default:
                        return super.onTransact(p4, p5, p6, p7);
                }
        }
    }
}
