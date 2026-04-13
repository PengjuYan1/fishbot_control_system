package com.boat.support.slam.entity.floors;
public class F1 implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    private String x;
    private String y;

    static F1()
    {
        com.boat.support.slam.entity.floors.F1.CREATOR = new com.boat.support.slam.entity.floors.F1$1();
        return;
    }

    protected F1(android.os.Parcel p2)
    {
        this.y = p2.readString();
        this.x = p2.readString();
        return;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getX()
    {
        return this.x;
    }

    public String getY()
    {
        return this.y;
    }

    public void setX(String p1)
    {
        this.x = p1;
        return;
    }

    public void setY(String p1)
    {
        this.y = p1;
        return;
    }

    public void writeToParcel(android.os.Parcel p2, int p3)
    {
        p2.writeString(this.y);
        p2.writeString(this.x);
        return;
    }
}
