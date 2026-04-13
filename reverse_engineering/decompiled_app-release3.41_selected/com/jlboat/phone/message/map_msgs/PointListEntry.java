package com.jlboat.phone.message.map_msgs;
public class PointListEntry extends com.boat.jrosbridge.message.Message {
    public String point_id;
    public String point_name;
    public String session_id;
    public float x;
    public float y;
    public float z;

    public PointListEntry()
    {
        return;
    }

    public String getPointId()
    {
        return this.point_id;
    }

    public String getPointName()
    {
        return this.point_name;
    }

    public String getSessionId()
    {
        return this.session_id;
    }

    public float getX()
    {
        return this.x;
    }

    public float getY()
    {
        return this.y;
    }

    public float getZ()
    {
        return this.z;
    }

    public void setPointId(String p1)
    {
        this.point_id = p1;
        return;
    }

    public void setPointName(String p1)
    {
        this.point_name = p1;
        return;
    }

    public void setSessionId(String p1)
    {
        this.session_id = p1;
        return;
    }

    public void setX(float p1)
    {
        this.x = p1;
        return;
    }

    public void setY(float p1)
    {
        this.y = p1;
        return;
    }

    public void setZ(float p1)
    {
        this.z = p1;
        return;
    }
}
