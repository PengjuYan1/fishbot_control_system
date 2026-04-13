package com.jlboat.phone.message.map_msgs;
public class PointRenameRequest extends com.boat.jrosbridge.message.Message {
    public long floor_id;
    public long map_id;
    public String new_name;
    public long point_id;
    public int type;

    public PointRenameRequest()
    {
        return;
    }

    public long getFloorId()
    {
        return this.floor_id;
    }

    public long getMapId()
    {
        return this.map_id;
    }

    public String getNewName()
    {
        return this.new_name;
    }

    public long getPointid()
    {
        return this.point_id;
    }

    public int getType()
    {
        return this.type;
    }

    public void setFloorId(long p1)
    {
        this.floor_id = p1;
        return;
    }

    public void setMapId(long p1)
    {
        this.map_id = p1;
        return;
    }

    public void setNewName(String p1)
    {
        this.new_name = p1;
        return;
    }

    public void setPointId(long p1)
    {
        this.point_id = p1;
        return;
    }

    public void setType(int p1)
    {
        this.type = p1;
        return;
    }
}
