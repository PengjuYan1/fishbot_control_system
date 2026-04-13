package com.jlboat.phone.message.map_msgs;
public class PointUpdateRequest extends com.boat.jrosbridge.message.Message {
    public String data;
    public long floor_id;
    public long map_id;
    public long point_id;
    public int type;

    public PointUpdateRequest()
    {
        return;
    }

    public String getData()
    {
        return this.data;
    }

    public long getFloorId()
    {
        return this.floor_id;
    }

    public long getMapId()
    {
        return this.map_id;
    }

    public long getPointid()
    {
        return this.point_id;
    }

    public int getType()
    {
        return this.type;
    }

    public void setData(String p1)
    {
        this.data = p1;
        return;
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
