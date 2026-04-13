package com.boat.support.slam.entity.floors;
public class NPoint implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    private long nId;
    private String nName;
    private long x;
    private long y;

    static NPoint()
    {
        com.boat.support.slam.entity.floors.NPoint.CREATOR = new com.boat.support.slam.entity.floors.NPoint$1();
        return;
    }

    protected NPoint(android.os.Parcel p3)
    {
        this.nId = p3.readLong();
        this.nName = p3.readString();
        this.x = p3.readLong();
        this.y = p3.readLong();
        return;
    }

    public int describeContents()
    {
        return 0;
    }

    public long getX()
    {
        return this.x;
    }

    public long getY()
    {
        return this.y;
    }

    public long getnId()
    {
        return this.nId;
    }

    public String getnName()
    {
        return this.nName;
    }

    public void setX(long p1)
    {
        this.x = p1;
        return;
    }

    public void setY(long p1)
    {
        this.y = p1;
        return;
    }

    public void setnId(long p1)
    {
        this.nId = p1;
        return;
    }

    public void setnName(String p1)
    {
        this.nName = p1;
        return;
    }

    public void writeToParcel(android.os.Parcel p3, int p4)
    {
        p3.writeLong(this.nId);
        p3.writeString(this.nName);
        p3.writeLong(this.x);
        p3.writeLong(this.y);
        return;
    }
}
