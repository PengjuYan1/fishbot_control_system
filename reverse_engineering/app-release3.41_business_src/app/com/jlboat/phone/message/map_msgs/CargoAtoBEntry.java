package com.jlboat.phone.message.map_msgs;
public class CargoAtoBEntry extends com.boat.jrosbridge.message.Message {
    public Long bind_floor_id;
    public String bind_floor_name;
    public Long bind_map_id;
    public String bind_map_name;
    public Long bind_point_id;
    public String bind_point_name;
    public long floor_id;
    public String floor_name;
    public Long map_id;
    public String map_name;
    public Long point_id;
    public String point_name;

    public CargoAtoBEntry()
    {
        return;
    }

    public Long getBind_floor_id()
    {
        return this.bind_floor_id;
    }

    public String getBind_floor_name()
    {
        return this.bind_floor_name;
    }

    public Long getBind_map_id()
    {
        return this.bind_map_id;
    }

    public String getBind_map_name()
    {
        return this.bind_map_name;
    }

    public Long getBind_point_id()
    {
        return this.bind_point_id;
    }

    public String getBind_point_name()
    {
        return this.bind_point_name;
    }

    public Long getFloor_id()
    {
        return Long.valueOf(this.floor_id);
    }

    public String getFloor_name()
    {
        return this.floor_name;
    }

    public Long getMap_id()
    {
        return this.map_id;
    }

    public String getMap_name()
    {
        return this.map_name;
    }

    public Long getPoint_id()
    {
        return this.point_id;
    }

    public String getPoint_name()
    {
        return this.point_name;
    }

    public void setBind_floor_id(Long p1)
    {
        this.bind_floor_id = p1;
        return;
    }

    public void setBind_floor_name(String p1)
    {
        this.bind_floor_name = p1;
        return;
    }

    public void setBind_map_id(Long p1)
    {
        this.bind_map_id = p1;
        return;
    }

    public void setBind_map_name(String p1)
    {
        this.bind_map_name = p1;
        return;
    }

    public void setBind_point_id(Long p1)
    {
        this.bind_point_id = p1;
        return;
    }

    public void setBind_point_name(String p1)
    {
        this.bind_point_name = p1;
        return;
    }

    public void setFloor_id(Long p3)
    {
        this.floor_id = p3.longValue();
        return;
    }

    public void setFloor_name(String p1)
    {
        this.floor_name = p1;
        return;
    }

    public void setMap_id(Long p1)
    {
        this.map_id = p1;
        return;
    }

    public void setMap_name(String p1)
    {
        this.map_name = p1;
        return;
    }

    public void setPoint_id(Long p1)
    {
        this.point_id = p1;
        return;
    }

    public void setPoint_name(String p1)
    {
        this.point_name = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("CargoAtoBEntry{floor_id=").append(this.floor_id).append(", map_id=").append(this.map_id).append(", point_id=").append(this.point_id).append(", point_name=\'").append(this.point_name).append(39).append(", floor_name=\'").append(this.floor_name).append(39).append(", map_name=\'").append(this.map_name).append(39).append(", bind_floor_id=").append(this.bind_floor_id).append(", bind_map_id=").append(this.bind_map_id).append(", bind_point_id=").append(this.bind_point_id).append(", bind_point_name=\'").append(this.bind_point_name).append(39).append(", bind_floor_name=\'").append(this.bind_floor_name).append(39).append(", bind_map_name=\'").append(this.bind_map_name).append(39).append(125).toString();
    }
}
