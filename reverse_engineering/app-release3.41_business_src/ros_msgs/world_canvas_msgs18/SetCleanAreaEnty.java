package world_canvas_msgs18;
public class SetCleanAreaEnty {
    long cleanAreaId;
    boolean closed;
    String name;
    java.util.List points;
    float radius;
    String type;

    public SetCleanAreaEnty()
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

    public java.util.List getPoints()
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

    public void setType(String p1)
    {
        this.type = p1;
        return;
    }
}
