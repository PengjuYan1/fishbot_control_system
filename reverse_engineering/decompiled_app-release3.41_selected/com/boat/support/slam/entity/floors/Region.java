package com.boat.support.slam.entity.floors;
public class Region implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    private long endPointId;
    private int orderNum;
    private java.util.List points;
    private long regionId;
    private int regionProperty1;
    private int regionProperty2;
    private long startPointId;
    private int type;
    private long waitPointId;

    static Region()
    {
        com.boat.support.slam.entity.floors.Region.CREATOR = new com.boat.support.slam.entity.floors.Region$1();
        return;
    }

    protected Region(android.os.Parcel p3)
    {
        this.regionId = p3.readLong();
        this.type = p3.readInt();
        this.orderNum = p3.readInt();
        this.startPointId = p3.readLong();
        this.endPointId = p3.readLong();
        this.waitPointId = p3.readLong();
        this.points = p3.createTypedArrayList(com.boat.support.slam.entity.floors.Lines.CREATOR);
        this.regionProperty1 = p3.readInt();
        this.regionProperty2 = p3.readInt();
        return;
    }

    public int describeContents()
    {
        return 0;
    }

    public long getEndPointId()
    {
        return this.endPointId;
    }

    public int getOrderNum()
    {
        return this.orderNum;
    }

    public java.util.List getPoints()
    {
        return this.points;
    }

    public long getRegionId()
    {
        return this.regionId;
    }

    public int getRegionProperty1()
    {
        return this.regionProperty1;
    }

    public int getRegionProperty2()
    {
        return this.regionProperty2;
    }

    public long getStartPointId()
    {
        return this.startPointId;
    }

    public int getType()
    {
        return this.type;
    }

    public long getWaitPointId()
    {
        return this.waitPointId;
    }

    public void setEndPointId(long p1)
    {
        this.endPointId = p1;
        return;
    }

    public void setOrderNum(int p1)
    {
        this.orderNum = p1;
        return;
    }

    public void setPoints(java.util.List p1)
    {
        this.points = p1;
        return;
    }

    public void setRegionId(long p1)
    {
        this.regionId = p1;
        return;
    }

    public void setRegionProperty1(int p1)
    {
        this.regionProperty1 = p1;
        return;
    }

    public void setRegionProperty2(int p1)
    {
        this.regionProperty2 = p1;
        return;
    }

    public void setStartPointId(long p1)
    {
        this.startPointId = p1;
        return;
    }

    public void setType(int p1)
    {
        this.type = p1;
        return;
    }

    public void setWaitPointId(long p1)
    {
        this.waitPointId = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("Region{regionId=").append(this.regionId).append(", type=").append(this.type).append(", orderNum=").append(this.orderNum).append(", startPointId=").append(this.startPointId).append(", endPointId=").append(this.endPointId).append(", waitPointId=").append(this.waitPointId).append(", regionProperty2=").append(this.regionProperty2).append(", regionProperty1=").append(this.regionProperty1).append(", points=").append(this.points).append(125).toString();
    }

    public void writeToParcel(android.os.Parcel p3, int p4)
    {
        p3.writeLong(this.regionId);
        p3.writeInt(this.type);
        p3.writeInt(this.orderNum);
        p3.writeLong(this.startPointId);
        p3.writeLong(this.endPointId);
        p3.writeLong(this.waitPointId);
        p3.writeTypedList(this.points);
        p3.writeInt(this.regionProperty1);
        p3.writeInt(this.regionProperty2);
        return;
    }
}
