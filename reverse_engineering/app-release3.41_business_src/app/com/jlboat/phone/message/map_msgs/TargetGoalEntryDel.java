package com.jlboat.phone.message.map_msgs;
public class TargetGoalEntryDel extends com.boat.jrosbridge.message.Message {
    public int index;
    public int type;

    public TargetGoalEntryDel()
    {
        return;
    }

    public int getIndex()
    {
        return this.index;
    }

    public int getType()
    {
        return this.type;
    }

    public void setIndex(int p1)
    {
        this.index = p1;
        return;
    }

    public void setType(int p1)
    {
        this.type = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("TargetGoalEntryDel{type=").append(this.type).append(", index=").append(this.index).append(125).toString();
    }
}
