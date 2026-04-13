package com.jlboat.phone.message.map_msgs;
public class NGlobalPlan extends com.boat.jrosbridge.message.Message {
    public int direction;
    public long endNid;
    public long id;
    public float speed;
    public long startNid;
    public int type;
    public float weight;

    public NGlobalPlan()
    {
        return;
    }

    public int getDirection()
    {
        return this.direction;
    }

    public long getEndNid()
    {
        return this.endNid;
    }

    public long getId()
    {
        return this.id;
    }

    public float getSpeed()
    {
        return this.speed;
    }

    public long getStartNid()
    {
        return this.startNid;
    }

    public int getType()
    {
        return this.type;
    }

    public float getWeight()
    {
        return this.weight;
    }

    public void setDirection(int p1)
    {
        this.direction = p1;
        return;
    }

    public void setEndNid(long p1)
    {
        this.endNid = p1;
        return;
    }

    public void setId(long p1)
    {
        this.id = p1;
        return;
    }

    public void setSpeed(float p1)
    {
        this.speed = p1;
        return;
    }

    public void setStartNid(long p1)
    {
        this.startNid = p1;
        return;
    }

    public void setType(int p1)
    {
        this.type = p1;
        return;
    }

    public void setWeight(float p1)
    {
        this.weight = p1;
        return;
    }
}
