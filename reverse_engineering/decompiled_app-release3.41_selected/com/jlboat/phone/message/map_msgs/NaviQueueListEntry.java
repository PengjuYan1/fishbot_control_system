package com.jlboat.phone.message.map_msgs;
public class NaviQueueListEntry extends com.boat.jrosbridge.message.Message {
    public com.jlboat.phone.message.map_msgs.CargoAtoBEntry cargoAtoBEntry;
    public Long creatTime;
    public Long endTime;
    public String notes;
    public int status;
    public int type;

    public NaviQueueListEntry()
    {
        return;
    }

    public com.jlboat.phone.message.map_msgs.CargoAtoBEntry getCargoAtoBEntry()
    {
        return this.cargoAtoBEntry;
    }

    public Long getCreatTime()
    {
        return this.creatTime;
    }

    public Long getEndTime()
    {
        return this.endTime;
    }

    public String getNotes()
    {
        return this.notes;
    }

    public int getStatus()
    {
        return this.status;
    }

    public int getType()
    {
        return this.type;
    }

    public void setCargoAtoBEntry(com.jlboat.phone.message.map_msgs.CargoAtoBEntry p1)
    {
        this.cargoAtoBEntry = p1;
        return;
    }

    public void setCreatTime(Long p1)
    {
        this.creatTime = p1;
        return;
    }

    public void setEndTime(Long p1)
    {
        this.endTime = p1;
        return;
    }

    public void setNotes(String p1)
    {
        this.notes = p1;
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
        return new StringBuilder().append("NaviQueueListEntry{cargoAtoBEntry=").append(this.cargoAtoBEntry).append(", type=").append(this.type).append(", status=").append(this.status).append(", creatTime=").append(this.creatTime).append(", endTime=").append(this.endTime).append(", notes=\'").append(this.notes).append(39).append(125).toString();
    }
}
