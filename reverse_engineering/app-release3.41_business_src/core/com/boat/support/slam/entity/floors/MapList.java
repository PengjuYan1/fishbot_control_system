package com.boat.support.slam.entity.floors;
public class MapList implements android.provider.BaseColumns, android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    private long[] chargingPrioritys;
    private long defaultFloor;
    private java.util.List floors;

    static MapList()
    {
        com.boat.support.slam.entity.floors.MapList.CREATOR = new com.boat.support.slam.entity.floors.MapList$1();
        return;
    }

    public MapList()
    {
        return;
    }

    protected MapList(android.os.Parcel p3)
    {
        this.floors = p3.createTypedArrayList(com.boat.support.slam.entity.floors.Floors.CREATOR);
        this.defaultFloor = p3.readLong();
        this.chargingPrioritys = p3.createLongArray();
        return;
    }

    public int describeContents()
    {
        return 0;
    }

    public java.util.List getChargingPrioritys()
    {
        if (this.chargingPrioritys != null) {
            java.util.ArrayList v0_3 = new java.util.ArrayList();
            long[] v1 = this.chargingPrioritys;
            int v2 = v1.length;
            int v3 = 0;
            while (v3 < v2) {
                v0_3.add(Long.valueOf(v1[v3]));
                v3++;
            }
            return v0_3;
        } else {
            return 0;
        }
    }

    public long getDefaultFloor()
    {
        return this.defaultFloor;
    }

    public java.util.List getFloors()
    {
        return this.floors;
    }

    public void setChargingPrioritys(long[] p1)
    {
        this.chargingPrioritys = p1;
        return;
    }

    public void setDefaultFloor(long p1)
    {
        this.defaultFloor = p1;
        return;
    }

    public void setFloors(java.util.List p1)
    {
        this.floors = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("MapList{floors=").append(this.floors).append(", defaultFloor=").append(this.defaultFloor).append(125).toString();
    }

    public void writeToParcel(android.os.Parcel p3, int p4)
    {
        p3.writeTypedList(this.floors);
        p3.writeLong(this.defaultFloor);
        p3.writeLongArray(this.chargingPrioritys);
        return;
    }
}
