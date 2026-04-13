package com.jlboat.phone.message.map_msgs;
public class SetCleanAreaRequest extends com.boat.jrosbridge.message.Message {
    public long cleanAreaId;
    public boolean closed;
    public String name;
    public com.boat.jrosbridge.message.geometry_msgs.Point point;
    public com.boat.jrosbridge.message.geometry_msgs.Point[] points;
    public float radius;
    public String type;

    public SetCleanAreaRequest()
    {
        return;
    }

    public long getCleanAreaId()
    {
        return this.cleanAreaId;
    }

    public String getName()
    {
        return this.name;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Point getPoint()
    {
        return this.point;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Point[] getPoints()
    {
        return this.points;
    }

    public float getRadius()
    {
        return this.radius;
    }

    public String getType()
    {
        return this.type;
    }

    public boolean isClosed()
    {
        return this.closed;
    }

    public void setCleanAreaId(long p1)
    {
        this.cleanAreaId = p1;
        return;
    }

    public void setClosed(boolean p1)
    {
        this.closed = p1;
        return;
    }

    public void setName(String p1)
    {
        this.name = p1;
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

    public void setRadius(float p1)
    {
        this.radius = p1;
        return;
    }

    public void setType(String p1)
    {
        this.type = p1;
        return;
    }
}
