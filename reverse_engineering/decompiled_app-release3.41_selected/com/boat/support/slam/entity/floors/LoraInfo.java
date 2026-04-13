package com.boat.support.slam.entity.floors;
public class LoraInfo {
    private String deviceID;
    private int deviceType;
    private long floorId;
    private String floorName;
    private long pointId;
    private String pointName;

    public LoraInfo()
    {
        return;
    }

    public String getDeviceID()
    {
        return this.deviceID;
    }

    public int getDeviceType()
    {
        return this.deviceType;
    }

    public long getFloorId()
    {
        return this.floorId;
    }

    public String getFloorName()
    {
        return this.floorName;
    }

    public long getPointId()
    {
        return this.pointId;
    }

    public String getPointName()
    {
        return this.pointName;
    }

    public void setDeviceID(String p1)
    {
        this.deviceID = p1;
        return;
    }

    public void setDeviceType(int p1)
    {
        this.deviceType = p1;
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

    public String toString()
    {
        return new StringBuilder().append("LoraInfo{floorId=").append(this.floorId).append(", floorName=\'").append(this.floorName).append(39).append(", pointId=").append(this.pointId).append(", pointName=\'").append(this.pointName).append(39).append(", deviceType=").append(this.deviceType).append(", deviceID=\'").append(this.deviceID).append(39).append(125).toString();
    }
}
