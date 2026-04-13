package com.boat.support.slam.entity.floors;
public class Circle implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    private com.boat.support.slam.entity.floors.Position position;
    private double radius;

    static Circle()
    {
        com.boat.support.slam.entity.floors.Circle.CREATOR = new com.boat.support.slam.entity.floors.Circle$1();
        return;
    }

    protected Circle(android.os.Parcel p3)
    {
        this.position = ((com.boat.support.slam.entity.floors.Position) p3.readParcelable(com.boat.support.slam.entity.floors.Position.getClassLoader()));
        this.radius = p3.readDouble();
        return;
    }

    public int describeContents()
    {
        return 0;
    }

    public com.boat.support.slam.entity.floors.Position getPosition()
    {
        return this.position;
    }

    public double getRadius()
    {
        return this.radius;
    }

    public void setPosition(com.boat.support.slam.entity.floors.Position p1)
    {
        this.position = p1;
        return;
    }

    public void setRadius(double p1)
    {
        this.radius = p1;
        return;
    }

    public void writeToParcel(android.os.Parcel p3, int p4)
    {
        p3.writeParcelable(this.position, p4);
        p3.writeDouble(this.radius);
        return;
    }
}
