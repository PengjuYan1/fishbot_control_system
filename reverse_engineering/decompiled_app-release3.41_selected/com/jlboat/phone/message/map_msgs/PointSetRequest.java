package com.jlboat.phone.message.map_msgs;
public class PointSetRequest extends com.boat.jrosbridge.message.Message {
    public long point_mode;
    public String point_name;

    public PointSetRequest()
    {
        return;
    }

    public long getPointMode()
    {
        return this.point_mode;
    }

    public String getPointName()
    {
        return this.point_name;
    }

    public void setPointMode(long p1)
    {
        this.point_mode = p1;
        return;
    }

    public void setPointName(String p1)
    {
        this.point_name = p1;
        return;
    }
}
