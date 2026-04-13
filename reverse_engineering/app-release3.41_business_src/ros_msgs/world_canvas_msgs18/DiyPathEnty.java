package world_canvas_msgs18;
public class DiyPathEnty {
    public com.jlboat.phone.message.map_msgs.GlobalPlanPoints addPoint;
    public com.jlboat.phone.message.map_msgs.GlobalPlanPoints[] addPoints;
    public long dir;
    public long globalplanId;
    public String globalplanName;
    public java.util.List linesList;
    public long op;
    public java.util.List planPoints;

    public DiyPathEnty()
    {
        return;
    }

    public com.jlboat.phone.message.map_msgs.GlobalPlanPoints getAddPoint()
    {
        return this.addPoint;
    }

    public com.jlboat.phone.message.map_msgs.GlobalPlanPoints[] getAddPoints()
    {
        return this.addPoints;
    }

    public long getDir()
    {
        return this.dir;
    }

    public long getGlobalplanId()
    {
        return this.globalplanId;
    }

    public String getGlobalplanName()
    {
        return this.globalplanName;
    }

    public java.util.List getLinesList()
    {
        return this.linesList;
    }

    public long getOp()
    {
        return this.op;
    }

    public java.util.List getPlanPoints()
    {
        return this.planPoints;
    }

    public void setAddPoint(com.jlboat.phone.message.map_msgs.GlobalPlanPoints p1)
    {
        this.addPoint = p1;
        return;
    }

    public void setAddPoints(com.jlboat.phone.message.map_msgs.GlobalPlanPoints[] p1)
    {
        this.addPoints = p1;
        return;
    }

    public void setDir(long p1)
    {
        this.dir = p1;
        return;
    }

    public void setGlobalplanId(long p1)
    {
        this.globalplanId = p1;
        return;
    }

    public void setGlobalplanName(String p1)
    {
        this.globalplanName = p1;
        return;
    }

    public void setLinesList(java.util.List p1)
    {
        this.linesList = p1;
        return;
    }

    public void setOp(long p1)
    {
        this.op = p1;
        return;
    }

    public void setPlanPoints(java.util.List p1)
    {
        this.planPoints = p1;
        return;
    }
}
