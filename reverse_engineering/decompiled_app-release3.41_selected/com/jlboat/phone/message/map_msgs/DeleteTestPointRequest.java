package com.jlboat.phone.message.map_msgs;
public class DeleteTestPointRequest extends com.boat.jrosbridge.message.Message {
    public long floor_id;
    public long map_id;
    public long point_id;

    public DeleteTestPointRequest()
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

    public long getPointId()
    {
        return this.point_id;
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
}
