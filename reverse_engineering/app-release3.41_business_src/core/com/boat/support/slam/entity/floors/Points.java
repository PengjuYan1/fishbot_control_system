package com.boat.support.slam.entity.floors;
public class Points implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    private String alias;
    private long bindFloorId;
    private long bindMapId;
    private long bindPointId;
    private String cargoRegionType;
    private String deviceID;
    private int deviceType;
    private int isAliasOpen;
    private int isCircle;
    private int isGo;
    private int isWaitOpen;
    private String ledWarnID;
    private String naviPointWords;
    private long navipointResid;
    private int naviwordsOrRes;
    private long pointId;
    private String pointName;
    private String pointWords;
    private double positionX;
    private double positionY;
    private double positionYaw;
    private long resId;
    private java.util.List waitPoints;
    private int waitTime;
    private int wordOrRes;

    static Points()
    {
        com.boat.support.slam.entity.floors.Points.CREATOR = new com.boat.support.slam.entity.floors.Points$1();
        return;
    }

    public Points()
    {
        this.deviceType = 0;
        this.naviwordsOrRes = 0;
        this.wordOrRes = 0;
        return;
    }

    protected Points(android.os.Parcel p3)
    {
        this.deviceType = 0;
        this.naviwordsOrRes = 0;
        this.wordOrRes = 0;
        this.positionYaw = p3.readDouble();
        this.positionX = p3.readDouble();
        this.positionY = p3.readDouble();
        this.pointName = p3.readString();
        this.deviceType = p3.readInt();
        this.deviceID = p3.readString();
        this.waitPoints = p3.createTypedArrayList(com.boat.support.slam.entity.floors.Position.CREATOR);
        this.bindPointId = p3.readLong();
        this.bindMapId = p3.readLong();
        this.bindFloorId = p3.readLong();
        this.cargoRegionType = p3.readString();
        this.ledWarnID = p3.readString();
        this.pointId = p3.readLong();
        this.resId = p3.readLong();
        this.pointWords = p3.readString();
        this.naviPointWords = p3.readString();
        this.navipointResid = p3.readLong();
        this.isCircle = p3.readInt();
        this.alias = p3.readString();
        this.isGo = p3.readInt();
        this.waitTime = p3.readInt();
        this.naviwordsOrRes = p3.readInt();
        this.wordOrRes = p3.readInt();
        this.isWaitOpen = p3.readInt();
        this.isAliasOpen = p3.readInt();
        return;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAlias()
    {
        return this.alias;
    }

    public long getBindFloorId()
    {
        return this.bindFloorId;
    }

    public long getBindMapId()
    {
        return this.bindMapId;
    }

    public long getBindPointId()
    {
        return this.bindPointId;
    }

    public String getCargoRegionType()
    {
        return this.cargoRegionType;
    }

    public String getDeviceID()
    {
        return this.deviceID;
    }

    public int getDeviceType()
    {
        return this.deviceType;
    }

    public int getIsAliasOpen()
    {
        return this.isAliasOpen;
    }

    public int getIsCircle()
    {
        return this.isCircle;
    }

    public int getIsGo()
    {
        return this.isGo;
    }

    public int getIsWaitOpen()
    {
        return this.isWaitOpen;
    }

    public String getLedWarnID()
    {
        return this.ledWarnID;
    }

    public String getNaviPointWords()
    {
        return this.naviPointWords;
    }

    public long getNavipointResid()
    {
        return this.navipointResid;
    }

    public int getNaviwordsOrRes()
    {
        return this.naviwordsOrRes;
    }

    public long getPointId()
    {
        return this.pointId;
    }

    public String getPointName()
    {
        return this.pointName;
    }

    public String getPointWords()
    {
        return this.pointWords;
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

    public long getResId()
    {
        return this.resId;
    }

    public java.util.List getWaitPoints()
    {
        return this.waitPoints;
    }

    public int getWaitTime()
    {
        return this.waitTime;
    }

    public int getWordOrRes()
    {
        return this.wordOrRes;
    }

    public void setAlias(String p1)
    {
        this.alias = p1;
        return;
    }

    public void setBindFloorId(long p1)
    {
        this.bindFloorId = p1;
        return;
    }

    public void setBindMapId(long p1)
    {
        this.bindMapId = p1;
        return;
    }

    public void setBindPointId(long p1)
    {
        this.bindPointId = p1;
        return;
    }

    public void setCargoRegionType(String p1)
    {
        this.cargoRegionType = p1;
        return;
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

    public void setIsAliasOpen(int p1)
    {
        this.isAliasOpen = p1;
        return;
    }

    public void setIsCircle(int p1)
    {
        this.isCircle = p1;
        return;
    }

    public void setIsGo(int p1)
    {
        this.isGo = p1;
        return;
    }

    public void setIsWaitOpen(int p1)
    {
        this.isWaitOpen = p1;
        return;
    }

    public void setLedWarnID(String p1)
    {
        this.ledWarnID = p1;
        return;
    }

    public void setNaviPointWords(String p1)
    {
        this.naviPointWords = p1;
        return;
    }

    public void setNavipointResid(long p1)
    {
        this.navipointResid = p1;
        return;
    }

    public void setNaviwordsOrRes(int p1)
    {
        this.naviwordsOrRes = p1;
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

    public void setPointWords(String p1)
    {
        this.pointWords = p1;
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

    public void setResId(long p1)
    {
        this.resId = p1;
        return;
    }

    public void setWaitPoints(java.util.List p1)
    {
        this.waitPoints = p1;
        return;
    }

    public void setWaitTime(int p1)
    {
        this.waitTime = p1;
        return;
    }

    public void setWordOrRes(int p1)
    {
        this.wordOrRes = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("Points{positionYaw=").append(this.positionYaw).append(", positionX=").append(this.positionX).append(", positionY=").append(this.positionY).append(", pointName=\'").append(this.pointName).append(39).append(", deviceType=").append(this.deviceType).append(", deviceID=\'").append(this.deviceID).append(39).append(", waitPoints=").append(this.waitPoints).append(", bindPointId=").append(this.bindPointId).append(", bindFloorId=").append(this.bindFloorId).append(", bindMapId=").append(this.bindMapId).append(", cargoRegionType=\'").append(this.cargoRegionType).append(int v1_19).append(", ledWarnID=\'").append(this.ledWarnID).append(39).append(", pointId=").append(this.pointId).append(", resId=").append(this.resId).append(", pointWords=\'").append(this.pointWords).append(39).append(", naviPointWords=\'").append(this.naviPointWords).append(39).append(", navipointResid=").append(this.navipointResid).append(", isCircle=").append(this.isCircle).append(", alias=\'").append(this.alias).append(39).append(", isGo=").append(this.isGo).append(", waitTime=").append(this.waitTime).append(", naviwordsOrRes=").append(this.naviwordsOrRes).append(", wordOrRes=").append(this.wordOrRes).append(", isWaitOpen=").append(this.isWaitOpen).append(", isAliasOpen=").append(this.isAliasOpen).append(125).toString();
    }

    public void writeToParcel(android.os.Parcel p3, int p4)
    {
        p3.writeDouble(this.positionYaw);
        p3.writeDouble(this.positionX);
        p3.writeDouble(this.positionY);
        p3.writeString(this.pointName);
        p3.writeInt(this.deviceType);
        p3.writeString(this.deviceID);
        p3.writeTypedList(this.waitPoints);
        p3.writeLong(this.bindPointId);
        p3.writeLong(this.bindFloorId);
        p3.writeLong(this.bindMapId);
        p3.writeString(this.cargoRegionType);
        p3.writeLong(this.pointId);
        p3.writeLong(this.resId);
        p3.writeString(this.pointWords);
        p3.writeString(this.naviPointWords);
        p3.writeLong(this.navipointResid);
        p3.writeString(this.ledWarnID);
        p3.writeInt(this.isCircle);
        p3.writeString(this.alias);
        p3.writeInt(this.isGo);
        p3.writeInt(this.waitTime);
        p3.writeInt(this.naviwordsOrRes);
        p3.writeInt(this.wordOrRes);
        p3.writeInt(this.isWaitOpen);
        p3.writeInt(this.isAliasOpen);
        return;
    }
}
