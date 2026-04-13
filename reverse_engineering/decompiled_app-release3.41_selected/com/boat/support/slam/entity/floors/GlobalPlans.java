package com.boat.support.slam.entity.floors;
public class GlobalPlans implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    private java.util.List addPoints;
    private int dir;
    private long globalplanId;
    private String globalplanName;
    private java.util.List lines;
    private int orderNum;

    static GlobalPlans()
    {
        com.boat.support.slam.entity.floors.GlobalPlans.CREATOR = new com.boat.support.slam.entity.floors.GlobalPlans$1();
        return;
    }

    protected GlobalPlans(android.os.Parcel p3)
    {
        this.lines = p3.createTypedArrayList(com.boat.support.slam.entity.floors.Lines.CREATOR);
        this.globalplanName = p3.readString();
        this.orderNum = p3.readInt();
        this.globalplanId = p3.readLong();
        this.dir = p3.readInt();
        return;
    }

    public int describeContents()
    {
        return 0;
    }

    public java.util.List getAddPoints()
    {
        return this.addPoints;
    }

    public int getDir()
    {
        return this.dir;
    }

    public long getGlobalplanId()
    {
        return this.globalplanId;
    }

    public String getGlobalplanName()
    {
        return this.globalplanName;
    }

    public java.util.List getLines()
    {
        return this.lines;
    }

    public int getOrderNum()
    {
        return this.orderNum;
    }

    public void setAddPoints(java.util.List p1)
    {
        this.addPoints = p1;
        return;
    }

    public void setDir(int p1)
    {
        this.dir = p1;
        return;
    }

    public void setGlobalplanId(long p1)
    {
        this.globalplanId = p1;
        return;
    }

    public void setGlobalplanName(String p1)
    {
        this.globalplanName = p1;
        return;
    }

    public void setLines(java.util.List p1)
    {
        this.lines = p1;
        return;
    }

    public void setOrderNum(int p1)
    {
        this.orderNum = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("GlobalPlans{addPoints=").append(this.addPoints).append(", lines=").append(this.lines).append(", globalplanName=\'").append(this.globalplanName).append(39).append(", orderNum=").append(this.orderNum).append(", globalplanId=").append(this.globalplanId).append(", dir=").append(this.dir).append(125).toString();
    }

    public void writeToParcel(android.os.Parcel p3, int p4)
    {
        p3.writeTypedList(this.lines);
        p3.writeString(this.globalplanName);
        p3.writeInt(this.orderNum);
        p3.writeLong(this.globalplanId);
        p3.writeInt(this.dir);
        return;
    }
}
