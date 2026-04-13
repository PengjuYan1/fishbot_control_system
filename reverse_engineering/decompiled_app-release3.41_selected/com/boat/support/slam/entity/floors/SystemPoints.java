package com.boat.support.slam.entity.floors;
public class SystemPoints implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    private long pointId;
    private String pointName;
    private double positionX;
    private double positionY;
    private double positionYaw;

    static SystemPoints()
    {
        com.boat.support.slam.entity.floors.SystemPoints.CREATOR = new com.boat.support.slam.entity.floors.SystemPoints$1();
        return;
    }

    protected SystemPoints(android.os.Parcel p3)
    {
        this.positionYaw = p3.readDouble();
        this.positionX = p3.readDouble();
        this.positionY = p3.readDouble();
        this.pointId = p3.readLong();
        this.pointName = p3.readString();
        return;
    }

    public int describeContents()
    {
        return 0;
    }

    public long getPointId()
    {
        return this.pointId;
    }

    public String getPointName()
    {
        return this.pointName;
    }

    public double getPositionX()
    {
        return this.positionX;
    }

    public double getPositionY()
    {
        return this.positionY;
    }

    public double getPositionYaw()
    {
        return this.positionYaw;
    }

    public void setPointId(long p1)
    {
        this.pointId = p1;
        return;
    }

    public void setPointName(String p1)
    {
        this.pointName = p1;
        return;
    }

    public void setPositionX(double p1)
    {
        this.positionX = p1;
        return;
    }

    public void setPositionY(double p1)
    {
        this.positionY = p1;
        return;
    }

    public void setPositionYaw(double p1)
    {
        this.positionYaw = p1;
        return;
    }

    public void writeToParcel(android.os.Parcel p3, int p4)
    {
        p3.writeDouble(this.positionYaw);
        p3.writeDouble(this.positionX);
        p3.writeDouble(this.positionY);
        p3.writeLong(this.pointId);
        p3.writeString(this.pointName);
        return;
    }
}
