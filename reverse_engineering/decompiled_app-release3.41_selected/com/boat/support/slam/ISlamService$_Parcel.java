package com.boat.support.slam;
public class ISlamService$_Parcel {

    public ISlamService$_Parcel()
    {
        return;
    }

    static synthetic Object access$000(android.os.Parcel p1, android.os.Parcelable$Creator p2)
    {
        return com.boat.support.slam.ISlamService$_Parcel.readTypedObject(p1, p2);
    }

    static synthetic void access$100(android.os.Parcel p0, android.os.Parcelable p1, int p2)
    {
        com.boat.support.slam.ISlamService$_Parcel.writeTypedObject(p0, p1, p2);
        return;
    }

    static synthetic void access$200(android.os.Parcel p0, java.util.List p1, int p2)
    {
        com.boat.support.slam.ISlamService$_Parcel.writeTypedList(p0, p1, p2);
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

    private static void writeTypedList(android.os.Parcel p3, java.util.List p4, int p5)
    {
        if (p4 != null) {
            int v0_1 = p4.size();
            int v1 = 0;
            p3.writeInt(v0_1);
            while (v1 < v0_1) {
                com.boat.support.slam.ISlamService$_Parcel.writeTypedObject(p3, ((android.os.Parcelable) p4.get(v1)), p5);
                v1++;
            }
        } else {
            p3.writeInt(-1);
        }
        return;
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
