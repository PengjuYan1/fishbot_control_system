package com.boat.support.slam.entity.floors;
public class Maps implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    private long chargeId;
    private java.util.List cleanAreas;
    private java.util.List customPathList;
    private java.util.List globalPlans;
    private long initialId;
    private String mapFile;
    private long mapId;
    private String mapMd5;
    private String mapName;
    private com.boat.support.slam.entity.floors.NglobalPlans nglobalPlans;
    private java.util.List points;
    private java.util.List regionList;
    private java.util.List shapeAreas;
    private java.util.List systemPoints;
    private long workPointId;

    static Maps()
    {
        com.boat.support.slam.entity.floors.Maps.CREATOR = new com.boat.support.slam.entity.floors.Maps$1();
        return;
    }

    protected Maps(android.os.Parcel p3)
    {
        this.mapMd5 = p3.readString();
        this.mapFile = p3.readString();
        this.initialId = p3.readLong();
        this.chargeId = p3.readLong();
        this.workPointId = p3.readLong();
        this.mapId = p3.readLong();
        this.shapeAreas = p3.createTypedArrayList(com.boat.support.slam.entity.floors.ShapeAreas.CREATOR);
        this.cleanAreas = p3.createTypedArrayList(com.boat.support.slam.entity.floors.CleanArea.CREATOR);
        this.mapName = p3.readString();
        this.points = p3.createTypedArrayList(com.boat.support.slam.entity.floors.Points.CREATOR);
        this.customPathList = p3.createTypedArrayList(com.boat.support.slam.entity.floors.CustomPath.CREATOR);
        this.systemPoints = p3.createTypedArrayList(com.boat.support.slam.entity.floors.Points.CREATOR);
        this.globalPlans = p3.createTypedArrayList(com.boat.support.slam.entity.floors.GlobalPlans.CREATOR);
        this.nglobalPlans = ((com.boat.support.slam.entity.floors.NglobalPlans) p3.readParcelable(com.boat.support.slam.entity.floors.NglobalPlans.getClassLoader()));
        this.regionList = p3.createTypedArrayList(com.boat.support.slam.entity.floors.Region.CREATOR);
        return;
    }

    public int describeContents()
    {
        return 0;
    }

    public long getChargeId()
    {
        return this.chargeId;
    }

    public java.util.List getCleanAreas()
    {
        return this.cleanAreas;
    }

    public java.util.List getCustomPathList()
    {
        return this.customPathList;
    }

    public java.util.List getGlobalPlans()
    {
        return this.globalPlans;
    }

    public long getInitialId()
    {
        return this.initialId;
    }

    public String getMapFile()
    {
        return this.mapFile;
    }

    public long getMapId()
    {
        return this.mapId;
    }

    public String getMapMd5()
    {
        return this.mapMd5;
    }

    public String getMapName()
    {
        return this.mapName;
    }

    public com.boat.support.slam.entity.floors.NglobalPlans getNglobalPlans()
    {
        return this.nglobalPlans;
    }

    public java.util.List getPoints()
    {
        return this.points;
    }

    public java.util.List getRegionList()
    {
        return this.regionList;
    }

    public java.util.List getShapeAreas()
    {
        return this.shapeAreas;
    }

    public java.util.List getSystemPoints()
    {
        return this.systemPoints;
    }

    public long getWorkPointId()
    {
        return this.workPointId;
    }

    public void setChargeId(long p1)
    {
        this.chargeId = p1;
        return;
    }

    public void setCleanAreas(java.util.List p1)
    {
        this.cleanAreas = p1;
        return;
    }

    public void setCustomPathList(java.util.List p1)
    {
        this.customPathList = p1;
        return;
    }

    public void setGlobalPlans(java.util.List p1)
    {
        this.globalPlans = p1;
        return;
    }

    public void setInitialId(long p1)
    {
        this.initialId = p1;
        return;
    }

    public void setMapFile(String p1)
    {
        this.mapFile = p1;
        return;
    }

    public void setMapId(long p1)
    {
        this.mapId = p1;
        return;
    }

    public void setMapMd5(String p1)
    {
        this.mapMd5 = p1;
        return;
    }

    public void setMapName(String p1)
    {
        this.mapName = p1;
        return;
    }

    public void setNglobalPlans(com.boat.support.slam.entity.floors.NglobalPlans p1)
    {
        this.nglobalPlans = p1;
        return;
    }

    public void setPoints(java.util.List p1)
    {
        this.points = p1;
        return;
    }

    public void setRegionList(java.util.List p1)
    {
        this.regionList = p1;
        return;
    }

    public void setShapeAreas(java.util.List p1)
    {
        this.shapeAreas = p1;
        return;
    }

    public void setSystemPoints(java.util.List p1)
    {
        this.systemPoints = p1;
        return;
    }

    public void setWorkPointId(long p1)
    {
        this.workPointId = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("Maps{mapMd5=\'").append(this.mapMd5).append(39).append(", mapFile=\'").append(this.mapFile).append(39).append(", initialId=").append(this.initialId).append(", chargeId=").append(this.chargeId).append(", workPointId=").append(this.workPointId).append(", mapId=").append(this.mapId).append(", shapeAreas=").append(this.shapeAreas).append(", cleanAreas=").append(this.cleanAreas).append(", mapName=\'").append(this.mapName).append(39).append(", points=").append(this.points).append(", customPathList=").append(this.customPathList).append(", systemPoints=").append(this.systemPoints).append(", globalPlans=").append(this.globalPlans).append(", nglobalPlans=").append(this.nglobalPlans).append(", regionList=").append(this.regionList).append(125).toString();
    }

    public void writeToParcel(android.os.Parcel p3, int p4)
    {
        p3.writeString(this.mapMd5);
        p3.writeString(this.mapFile);
        p3.writeLong(this.initialId);
        p3.writeLong(this.chargeId);
        p3.writeLong(this.workPointId);
        p3.writeLong(this.mapId);
        p3.writeTypedList(this.shapeAreas);
        p3.writeTypedList(this.cleanAreas);
        p3.writeString(this.mapName);
        p3.writeTypedList(this.points);
        p3.writeTypedList(this.customPathList);
        p3.writeTypedList(this.systemPoints);
        p3.writeTypedList(this.globalPlans);
        p3.writeParcelable(this.nglobalPlans, p4);
        p3.writeTypedList(this.regionList);
        return;
    }
}
