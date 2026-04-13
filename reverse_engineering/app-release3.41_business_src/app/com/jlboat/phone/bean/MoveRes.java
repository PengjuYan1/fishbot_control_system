package com.jlboat.phone.bean;
public class MoveRes {
    private String time;
    private int type;
    private float value;

    public MoveRes()
    {
        return;
    }

    public String getTime()
    {
        return this.time;
    }

    public int getType()
    {
        return this.type;
    }

    public float getValue()
    {
        return this.value;
    }

    public void setTime(String p1)
    {
        this.time = p1;
        return;
    }

    public void setType(int p1)
    {
        this.type = p1;
        return;
    }

    public void setValue(float p1)
    {
        this.value = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("MoveRes{time=\'").append(this.time).append(39).append(", value=").append(this.value).append(", type=").append(this.type).append(125).toString();
    }
}
