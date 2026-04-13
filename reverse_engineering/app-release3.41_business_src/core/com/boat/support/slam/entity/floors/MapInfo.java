package com.boat.support.slam.entity.floors;
public class MapInfo {
    private long floorId;
    private String floorName;
    private long mapId;
    private String mapName;
    private java.util.List points;

    public MapInfo()
    {
        return;
    }

    public long getFloorId()
    {
        return this.floorId;
    }

    public String getFloorName()
    {
        return this.floorName;
    }

    public long getMapId()
    {
        return this.mapId;
    }

    public String getMapName()
    {
        return this.mapName;
    }

    public java.util.List getPoints()
    {
        return this.points;
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

    public void setMapId(long p1)
    {
        this.mapId = p1;
        return;
    }

    public void setMapName(String p1)
    {
        this.mapName = p1;
        return;
    }

    public void setPoints(java.util.List p1)
    {
        this.points = p1;
        return;
    }
}
