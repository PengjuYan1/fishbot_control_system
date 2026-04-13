package com.jlboat.phone.bean;
public class TestStatePoint {
    private int chargeState;
    private String name;
    private int state;
    private int type;

    public TestStatePoint()
    {
        return;
    }

    public int getChargeState()
    {
        return this.chargeState;
    }

    public String getName()
    {
        return this.name;
    }

    public int getState()
    {
        return this.state;
    }

    public int getType()
    {
        return this.type;
    }

    public void setChargeState(int p1)
    {
        this.chargeState = p1;
        return;
    }

    public void setName(String p1)
    {
        this.name = p1;
        return;
    }

    public void setState(int p1)
    {
        this.state = p1;
        return;
    }

    public void setType(int p1)
    {
        this.type = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("TestStatePoint{name=\'").append(this.name).append(39).append(", state=").append(this.state).append(125).toString();
    }
}
