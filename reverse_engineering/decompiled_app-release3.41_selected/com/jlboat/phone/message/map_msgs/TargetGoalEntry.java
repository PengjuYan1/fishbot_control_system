package com.jlboat.phone.message.map_msgs;
public class TargetGoalEntry extends com.boat.jrosbridge.message.Message {
    public long creatTime;
    public long endTime;
    public long floor_id;
    public long floor_id_putdown;
    public String floor_name;
    public String floor_name_putdown;
    public long map_id;
    public long map_id_putdown;
    public String map_name;
    public String map_name_putdown;
    public String notes;
    public long point_id;
    public long point_id_putdown;
    public String point_name;
    public String point_name_putdown;
    public int status;
    public int type;

    public TargetGoalEntry()
    {
        return;
    }

    public long getCreatTime()
    {
        return this.creatTime;
    }

    public long getEndTime()
    {
        return this.endTime;
    }

    public long getFloorId()
    {
        return this.floor_id;
    }

    public String getFloorName()
    {
        return this.floor_name;
    }

    public long getFloor_id_putdown()
    {
        return this.floor_id_putdown;
    }

    public String getFloor_name_putdown()
    {
        return this.floor_name_putdown;
    }

    public long getMapId()
    {
        return this.map_id;
    }

    public String getMapName()
    {
        return this.map_name;
    }

    public long getMap_id_putdown()
    {
        return this.map_id_putdown;
    }

    public String getMap_name_putdown()
    {
        return this.map_name_putdown;
    }

    public String getNotes()
    {
        return this.notes;
    }

    public long getPointId()
    {
        return this.point_id;
    }

    public String getPointName()
    {
        return this.point_name;
    }

    public long getPoint_id_putdown()
    {
        return this.point_id_putdown;
    }

    public String getPoint_name_putdown()
    {
        return this.point_name_putdown;
    }

    public int getStatus()
    {
        return this.status;
    }

    public int getType()
    {
        return this.type;
    }

    public void setCreatTime(long p1)
    {
        this.creatTime = p1;
        return;
    }

    public void setEndTime(long p1)
    {
        this.endTime = p1;
        return;
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

    public void setFloor_id_putdown(long p1)
    {
        this.floor_id_putdown = p1;
        return;
    }

    public void setFloor_name_putdown(String p1)
    {
        this.floor_name_putdown = p1;
        return;
    }

    public void setMapId(long p1)
    {
        this.map_id = p1;
        return;
    }

    public void setMapName(String p1)
    {
        this.map_name = p1;
        return;
    }

    public void setMap_id_putdown(long p1)
    {
        this.map_id_putdown = p1;
        return;
    }

    public void setMap_name_putdown(String p1)
    {
        this.map_name_putdown = p1;
        return;
    }

    public void setNotes(String p1)
    {
        this.notes = p1;
        return;
    }

    public void setPointId(long p1)
    {
        this.point_id = p1;
        return;
    }

    public void setPointName(String p1)
    {
        this.point_name = p1;
        return;
    }

    public void setPoint_id_putdown(long p1)
    {
        this.point_id_putdown = p1;
        return;
    }

    public void setPoint_name_putdown(String p1)
    {
        this.point_name_putdown = p1;
        return;
    }

    public void setStatus(int p1)
    {
        this.status = p1;
        return;
    }

    public void setType(int p1)
    {
        this.type = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("TargetGoalEntry{floor_id=").append(this.floor_id).append(", map_id=").append(this.map_id).append(", point_id=").append(this.point_id).append(", point_name=\'").append(this.point_name).append(39).append(", floor_name=\'").append(this.floor_name).append(39).append(", map_name=\'").append(this.map_name).append(39).append(", floor_id_putdown=").append(this.floor_id_putdown).append(", map_id_putdown=").append(this.map_id_putdown).append(", point_id_putdown=").append(this.point_id_putdown).append(", point_name_putdown=\'").append(this.point_name_putdown).append(39).append(", floor_name_putdown=\'").append(this.floor_name_putdown).append(39).append(", map_name_putdown=\'").append(this.map_name_putdown).append(39).append(", type=").append(this.type).append(", status=").append(this.status).append(", creatTime=").append(this.creatTime).append(", endTime=").append(this.endTime).append(", notes=\'").append(this.notes).append(39).append(125).toString();
    }
}
