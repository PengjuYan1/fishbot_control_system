package com.jlboat.phone.bean;
public class PixeMarks {
    long id;
    java.util.List poseList;

    public PixeMarks()
    {
        return;
    }

    public long getId()
    {
        return this.id;
    }

    public java.util.List getPoseList()
    {
        return this.poseList;
    }

    public void setId(long p1)
    {
        this.id = p1;
        return;
    }

    public void setPoseList(java.util.List p1)
    {
        this.poseList = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("PixeMarks{\nid=").append(this.id).append("\nposeList=").append(this.poseList).append(125).toString();
    }
}
