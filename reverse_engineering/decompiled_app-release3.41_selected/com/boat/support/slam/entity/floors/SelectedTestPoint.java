package com.boat.support.slam.entity.floors;
public class SelectedTestPoint {
    private Long floorId;
    private Long mapId;
    private com.boat.support.slam.entity.floors.Points point;

    public SelectedTestPoint(com.boat.support.slam.entity.floors.Points p1, Long p2, Long p3)
    {
        this.point = p1;
        this.floorId = p2;
        this.mapId = p3;
        return;
    }

    public boolean equals(Object p4)
    {
        if (this != p4) {
            if ((p4 != null) && (this.getClass() == p4.getClass())) {
                return this.point.equals(((com.boat.support.slam.entity.floors.SelectedTestPoint) p4).point);
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }

    public Long getFloorId()
    {
        return this.floorId;
    }

    public Long getMapId()
    {
        return this.mapId;
    }

    public com.boat.support.slam.entity.floors.Points getPoint()
    {
        return this.point;
    }

    public int hashCode()
    {
        Object[] v1_1 = new Object[1];
        v1_1[0] = this.point;
        return java.util.Objects.hash(v1_1);
    }

    public String toString()
    {
        return new StringBuilder().append("SelectedTestPoint{point=").append(this.point).append(", floorId=").append(this.floorId).append(", mapId=").append(this.mapId).append(125).toString();
    }
}
