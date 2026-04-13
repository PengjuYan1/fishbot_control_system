package com.boat.support.slam.entity.floors;
public class Ellipse implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    private com.boat.support.slam.entity.floors.F1 f1;
    private com.boat.support.slam.entity.floors.F2 f2;
    private String p;

    static Ellipse()
    {
        com.boat.support.slam.entity.floors.Ellipse.CREATOR = new com.boat.support.slam.entity.floors.Ellipse$1();
        return;
    }

    protected Ellipse(android.os.Parcel p2)
    {
        this.p = p2.readString();
        this.f2 = ((com.boat.support.slam.entity.floors.F2) p2.readParcelable(com.boat.support.slam.entity.floors.F2.getClassLoader()));
        this.f1 = ((com.boat.support.slam.entity.floors.F1) p2.readParcelable(com.boat.support.slam.entity.floors.F1.getClassLoader()));
        return;
    }

    public int describeContents()
    {
        return 0;
    }

    public com.boat.support.slam.entity.floors.F1 getF1()
    {
        return this.f1;
    }

    public com.boat.support.slam.entity.floors.F2 getF2()
    {
        return this.f2;
    }

    public String getP()
    {
        return this.p;
    }

    public void setF1(com.boat.support.slam.entity.floors.F1 p1)
    {
        this.f1 = p1;
        return;
    }

    public void setF2(com.boat.support.slam.entity.floors.F2 p1)
    {
        this.f2 = p1;
        return;
    }

    public void setP(String p1)
    {
        this.p = p1;
        return;
    }

    public void writeToParcel(android.os.Parcel p2, int p3)
    {
        p2.writeString(this.p);
        p2.writeParcelable(this.f2, p3);
        p2.writeParcelable(this.f1, p3);
        return;
    }
}
