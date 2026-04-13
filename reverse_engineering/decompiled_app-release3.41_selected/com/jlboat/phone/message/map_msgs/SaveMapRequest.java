package com.jlboat.phone.message.map_msgs;
public class SaveMapRequest extends com.boat.jrosbridge.message.Message {
    public long floor_id;
    public String floor_name;
    public String map_name;
    public int type;

    public SaveMapRequest()
    {
        return;
    }

    public long getFloorId()
    {
        return this.floor_id;
    }

    public String getFloorName()
    {
        return this.floor_name;
    }

    public String getMapName()
    {
        return this.map_name;
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

    public void setFloorName(String p1)
    {
        this.floor_name = p1;
        return;
    }

    public void setMapName(String p1)
    {
        this.map_name = p1;
        return;
    }

    public void setType(int p1)
    {
        this.type = p1;
        return;
    }
}
