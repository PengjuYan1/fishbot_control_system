package com.jlboat.phone.message.map_msgs;
public class RobotSonarEntry extends com.boat.jrosbridge.message.Message {
    public float max_range;
    public float min_range;
    public String name;
    public float range;
    public long sonar_switch;

    public RobotSonarEntry()
    {
        return;
    }

    public float getMaxRange()
    {
        return this.max_range;
    }

    public float getMinRange()
    {
        return this.min_range;
    }

    public String getName()
    {
        return this.name;
    }

    public float getRange()
    {
        return this.range;
    }

    public long getSonarSwitch()
    {
        return this.sonar_switch;
    }

    public void setMaxRange(float p1)
    {
        this.max_range = p1;
        return;
    }

    public void setMinRange(float p1)
    {
        this.min_range = p1;
        return;
    }

    public void setName(String p1)
    {
        this.name = p1;
        return;
    }

    public void setRange(float p1)
    {
        this.range = p1;
        return;
    }

    public void setSonarSwitch(long p1)
    {
        this.sonar_switch = p1;
        return;
    }
}
