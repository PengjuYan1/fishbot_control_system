package com.boat.support.slam.entity.floors;
public class Lines implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    private double x;
    private double y;

    static Lines()
    {
        com.boat.support.slam.entity.floors.Lines.CREATOR = new com.boat.support.slam.entity.floors.Lines$1();
        return;
    }

    public Lines()
    {
        return;
    }

    protected Lines(android.os.Parcel p3)
    {
        this.x = p3.readDouble();
        this.y = p3.readDouble();
        return;
    }

    public int describeContents()
    {
        return 0;
    }

    public double getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }

    public void setX(double p1)
    {
        this.x = p1;
        return;
    }

    public void setY(double p1)
    {
        this.y = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("Lines{x=").append(this.x).append(", y=").append(this.y).append(125).toString();
    }

    public void writeToParcel(android.os.Parcel p3, int p4)
    {
        p3.writeDouble(this.x);
        p3.writeDouble(this.y);
        return;
    }
}
