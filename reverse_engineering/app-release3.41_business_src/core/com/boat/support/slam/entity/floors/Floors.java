package com.boat.support.slam.entity.floors;
public class Floors implements android.provider.BaseColumns, android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    private long defaultmap;
    private long floorId;
    private String floorName;
    private java.util.List maps;

    static Floors()
    {
        com.boat.support.slam.entity.floors.Floors.CREATOR = new com.boat.support.slam.entity.floors.Floors$1();
        return;
    }

    public Floors()
    {
        return;
    }

    protected Floors(android.os.Parcel p3)
    {
        this.floorName = p3.readString();
        this.floorId = p3.readLong();
        this.defaultmap = p3.readLong();
        this.maps = p3.createTypedArrayList(com.boat.support.slam.entity.floors.Maps.CREATOR);
        return;
    }

    public int describeContents()
    {
        return 0;
    }

    public long getDefaultmap()
    {
        return this.defaultmap;
    }

    public long getFloorId()
    {
        return this.floorId;
    }

    public String getFloorName()
    {
        return this.floorName;
    }

    public java.util.List getMaps()
    {
        return this.maps;
    }

    public void setDefaultmap(long p1)
    {
        this.defaultmap = p1;
        return;
    }

    public void setFloorId(long p1)
    {
        this.floorId = p1;
        return;
    }

    public void setFloorName(String p1)
    {
        this.floorName = p1;
        return;
    }

    public void setMaps(java.util.List p1)
    {
        this.maps = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("Floors{floorName=\'").append(this.floorName).append(39).append(", floorId=").append(this.floorId).append(", defaultmap=").append(this.defaultmap).append(", maps=").append(this.maps).append(125).toString();
    }

    public void writeToParcel(android.os.Parcel p3, int p4)
    {
        p3.writeString(this.floorName);
        p3.writeLong(this.floorId);
        p3.writeLong(this.defaultmap);
        p3.writeTypedList(this.maps);
        return;
    }
}
