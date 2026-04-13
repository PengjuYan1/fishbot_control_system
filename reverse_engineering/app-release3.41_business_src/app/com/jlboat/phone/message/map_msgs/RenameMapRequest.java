package com.jlboat.phone.message.map_msgs;
public class RenameMapRequest extends com.boat.jrosbridge.message.Message {
    public long floor_id;
    public long map_id;
    public String new_name;

    public RenameMapRequest()
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
}
