package com.jlboat.phone.message.map_msgs;
public class SetShapeRequest extends com.boat.jrosbridge.message.Message {
    public boolean closed;
    public com.boat.jrosbridge.message.geometry_msgs.Point point;
    public com.boat.jrosbridge.message.geometry_msgs.Point[] points;
    public float radius;
    public long shape_id;
    public String type;

    public SetShapeRequest()
    {
        return;
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

    public long getShapeId()
    {
        return this.shape_id;
    }

    public String getType()
    {
        return this.type;
    }

    public boolean isClosed()
    {
        return this.closed;
    }

    public void setClosed(boolean p1)
    {
        this.closed = p1;
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

    public void setShapeId(long p1)
    {
        this.shape_id = p1;
        return;
    }

    public void setType(String p1)
    {
        this.type = p1;
        return;
    }
}
