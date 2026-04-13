package com.boat.support.slam;
public class IPositionResult$_Parcel {

    public IPositionResult$_Parcel()
    {
        return;
    }

    static synthetic Object access$000(android.os.Parcel p1, android.os.Parcelable$Creator p2)
    {
        return com.boat.support.slam.IPositionResult$_Parcel.readTypedObject(p1, p2);
    }

    static synthetic void access$100(android.os.Parcel p0, android.os.Parcelable p1, int p2)
    {
        com.boat.support.slam.IPositionResult$_Parcel.writeTypedObject(p0, p1, p2);
        return;
    }

    private static Object readTypedObject(android.os.Parcel p1, android.os.Parcelable$Creator p2)
    {
        if (p1.readInt() == 0) {
            return 0;
        } else {
            return p2.createFromParcel(p1);
        }
    }

    private static void writeTypedObject(android.os.Parcel p1, android.os.Parcelable p2, int p3)
    {
        if (p2 == null) {
            p1.writeInt(0);
        } else {
            p1.writeInt(1);
            p2.writeToParcel(p1, p3);
        }
        return;
    }
}
