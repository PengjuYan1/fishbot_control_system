package com.boat.support.slam.entity.floors;
public class Position implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    private double x;
    private double y;

    static Position()
    {
        com.boat.support.slam.entity.floors.Position.CREATOR = new com.boat.support.slam.entity.floors.Position$1();
        return;
    }

    public Position()
    {
        return;
    }

    protected Position(android.os.Parcel p3)
    {
        this.y = p3.readDouble();
        this.x = p3.readDouble();
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

    public void setY(Double p3)
    {
        this.y = p3.doubleValue();
        return;
    }

    public String toString()
    {
        String v0_7 = new StringBuilder().append("{");
        Double v3_3 = new Object[1];
        v3_3[0] = Double.valueOf(this.x);
        String v0_3 = v0_7.append(String.format("%.2f", v3_3)).append(", ");
        Object[] v2_0 = new Object[1];
        v2_0[0] = Double.valueOf(this.y);
        return v0_3.append(String.format("%.2f", v2_0)).append("}").toString();
    }

    public void writeToParcel(android.os.Parcel p3, int p4)
    {
        p3.writeDouble(this.y);
        p3.writeDouble(this.x);
        return;
    }
}
