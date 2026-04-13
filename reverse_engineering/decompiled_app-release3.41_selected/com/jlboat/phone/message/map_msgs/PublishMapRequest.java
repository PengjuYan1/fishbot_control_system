package com.jlboat.phone.message.map_msgs;
public class PublishMapRequest extends com.boat.jrosbridge.message.Message {
    public long floor_id;
    public long map_id;
    public int type;

    public PublishMapRequest()
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

    public void setType(int p1)
    {
        this.type = p1;
        return;
    }
}
