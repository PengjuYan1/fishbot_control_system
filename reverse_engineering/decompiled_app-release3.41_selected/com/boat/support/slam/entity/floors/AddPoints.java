package com.boat.support.slam.entity.floors;
public class AddPoints implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    private long x;
    private long y;

    static AddPoints()
    {
        com.boat.support.slam.entity.floors.AddPoints.CREATOR = new com.boat.support.slam.entity.floors.AddPoints$1();
        return;
    }

    protected AddPoints(android.os.Parcel p3)
    {
        this.y = p3.readLong();
        this.x = p3.readLong();
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

    public String toString()
    {
        return new StringBuilder().append("AddPoints{y=").append(this.y).append(", x=").append(this.x).append(125).toString();
    }

    public void writeToParcel(android.os.Parcel p3, int p4)
    {
        p3.writeLong(this.y);
        p3.writeLong(this.x);
        return;
    }
}
