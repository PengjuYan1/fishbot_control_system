package com.jlboat.phone.message.map_msgs;
public class DeleteMapRequest extends com.boat.jrosbridge.message.Message {
    public long floor_id;
    public long map_id;

    public DeleteMapRequest()
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
}
