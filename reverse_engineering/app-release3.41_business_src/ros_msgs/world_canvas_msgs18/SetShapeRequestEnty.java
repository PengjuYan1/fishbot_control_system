package world_canvas_msgs18;
public class SetShapeRequestEnty {
    boolean closed;
    java.util.List points;
    float radius;
    long shapeId;
    String type;

    public SetShapeRequestEnty()
    {
        return;
    }

    public java.util.List getPoints()
    {
        return this.points;
    }

    public float getRadius()
    {
        return this.radius;
    }

    public long getShapeId()
    {
        return this.shapeId;
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

    public void setPoints(java.util.List p1)
    {
        this.points = p1;
        return;
    }

    public void setRadius(float p1)
    {
        this.radius = p1;
        return;
    }

    public void setShapeId(long p1)
    {
        this.shapeId = p1;
        return;
    }

    public void setType(String p1)
    {
        this.type = p1;
        return;
    }
}
