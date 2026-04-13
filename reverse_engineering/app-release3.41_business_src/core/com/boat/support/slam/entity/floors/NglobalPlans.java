package com.boat.support.slam.entity.floors;
public class NglobalPlans implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    private java.util.List nLines;
    private java.util.List nPoints;

    static NglobalPlans()
    {
        com.boat.support.slam.entity.floors.NglobalPlans.CREATOR = new com.boat.support.slam.entity.floors.NglobalPlans$1();
        return;
    }

    protected NglobalPlans(android.os.Parcel p2)
    {
        this.nPoints = p2.createTypedArrayList(com.boat.support.slam.entity.floors.NPoint.CREATOR);
        this.nLines = p2.createTypedArrayList(com.boat.support.slam.entity.floors.NLine.CREATOR);
        return;
    }

    public int describeContents()
    {
        return 0;
    }

    public java.util.List getnLines()
    {
        return this.nLines;
    }

    public java.util.List getnPoints()
    {
        return this.nPoints;
    }

    public void setnLines(java.util.List p1)
    {
        this.nLines = p1;
        return;
    }

    public void setnPoints(java.util.List p1)
    {
        this.nPoints = p1;
        return;
    }

    public void writeToParcel(android.os.Parcel p2, int p3)
    {
        p2.writeTypedList(this.nPoints);
        p2.writeTypedList(this.nLines);
        return;
    }
}
