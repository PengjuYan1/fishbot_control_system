package world_canvas_msgs18;
public class SetRegionRequestEnty {
    long endPointId;
    java.util.List points;
    long regionId;
    int regionProperty1;
    int regionProperty2;
    long startPointId;
    int type;
    long waitPointId;

    public SetRegionRequestEnty()
    {
        return;
    }

    public long getEndPointId()
    {
        return this.endPointId;
    }

    public java.util.List getPoints()
    {
        return this.points;
    }

    public long getRegionId()
    {
        return this.regionId;
    }

    public int getRegionProperty1()
    {
        return this.regionProperty1;
    }

    public int getRegionProperty2()
    {
        return this.regionProperty2;
    }

    public long getStartPointId()
    {
        return this.startPointId;
    }

    public int getType()
    {
        return this.type;
    }

    public long getWaitPointId()
    {
        return this.waitPointId;
    }

    public void setEndPointId(long p1)
    {
        this.endPointId = p1;
        return;
    }

    public void setPoints(java.util.List p1)
    {
        this.points = p1;
        return;
    }

    public void setRegionId(long p1)
    {
        this.regionId = p1;
        return;
    }

    public void setRegionProperty1(int p1)
    {
        this.regionProperty1 = p1;
        return;
    }

    public void setRegionProperty2(int p1)
    {
        this.regionProperty2 = p1;
        return;
    }

    public void setStartPointId(long p1)
    {
        this.startPointId = p1;
        return;
    }

    public void setType(int p1)
    {
        this.type = p1;
        return;
    }

    public void setWaitPointId(long p1)
    {
        this.waitPointId = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("SetRegionRequestEnty{regionId=").append(this.regionId).append(", type=").append(this.type).append(", startPointId=").append(this.startPointId).append(", endPointId=").append(this.endPointId).append(", waitPointId=").append(this.waitPointId).append(", points=").append(this.points).append(", regionProperty1=").append(this.regionProperty1).append(", regionProperty2=").append(this.regionProperty2).append(125).toString();
    }
}
