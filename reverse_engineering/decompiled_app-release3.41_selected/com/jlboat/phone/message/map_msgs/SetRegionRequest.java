package com.jlboat.phone.message.map_msgs;
public class SetRegionRequest extends com.boat.jrosbridge.message.Message {
    public long end_point_id;
    public com.boat.jrosbridge.message.geometry_msgs.Point point;
    public com.boat.jrosbridge.message.geometry_msgs.Point[] points;
    public long region_id;
    public int region_property1;
    public int region_property2;
    public long start_point_id;
    public int type;
    public long wait_point_id;

    public SetRegionRequest()
    {
        return;
    }

    public long getEndPointId()
    {
        return this.end_point_id;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Point getPoint()
    {
        return this.point;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Point[] getPoints()
    {
        return this.points;
    }

    public long getRegionId()
    {
        return this.region_id;
    }

    public int getRegionProperty1()
    {
        return this.region_property1;
    }

    public int getRegionProperty2()
    {
        return this.region_property2;
    }

    public long getStartPointId()
    {
        return this.start_point_id;
    }

    public int getType()
    {
        return this.type;
    }

    public long getWaitPointId()
    {
        return this.wait_point_id;
    }

    public void setEndPointId(long p1)
    {
        this.end_point_id = p1;
        return;
    }

    public void setPoint(com.boat.jrosbridge.message.geometry_msgs.Point p1)
    {
        this.point = p1;
        return;
    }

    public void setPoints(java.util.List p2)
    {
        com.boat.jrosbridge.message.geometry_msgs.Point[] v0_1 = new com.boat.jrosbridge.message.geometry_msgs.Point[0];
        this.points = ((com.boat.jrosbridge.message.geometry_msgs.Point[]) p2.toArray(v0_1));
        return;
    }

    public void setPoints(com.boat.jrosbridge.message.geometry_msgs.Point[] p1)
    {
        this.points = p1;
        return;
    }

    public void setRegionId(long p1)
    {
        this.region_id = p1;
        return;
    }

    public void setRegionProperty1(int p1)
    {
        this.region_property1 = p1;
        return;
    }

    public void setRegionProperty2(int p1)
    {
        this.region_property2 = p1;
        return;
    }

    public void setStartPointId(long p1)
    {
        this.start_point_id = p1;
        return;
    }

    public void setType(int p1)
    {
        this.type = p1;
        return;
    }

    public void setWaitPointId(long p1)
    {
        this.wait_point_id = p1;
        return;
    }
}
