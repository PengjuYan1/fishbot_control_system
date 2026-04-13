package com.boat.jrosbridge.message.nav_msgs;
public class MapMetaData extends com.boat.jrosbridge.message.Message {
    public int height;
    public com.boat.jrosbridge.message.Time map_load_time;
    public com.boat.jrosbridge.message.geometry_msgs.Pose origin;
    public float resolution;
    public int width;

    public MapMetaData()
    {
        return;
    }

    public int getHeight()
    {
        return this.height;
    }

    public com.boat.jrosbridge.message.Time getMapLoadTime()
    {
        return this.map_load_time;
    }

    public com.boat.jrosbridge.message.geometry_msgs.Pose getOrigin()
    {
        return this.origin;
    }

    public float getResolution()
    {
        return this.resolution;
    }

    public int getWidth()
    {
        return this.width;
    }

    public void setHeight(int p1)
    {
        this.height = p1;
        return;
    }

    public void setMapLoadTime(com.boat.jrosbridge.message.Time p1)
    {
        this.map_load_time = p1;
        return;
    }

    public void setOrigin(com.boat.jrosbridge.message.geometry_msgs.Pose p1)
    {
        this.origin = p1;
        return;
    }

    public void setResolution(float p1)
    {
        this.resolution = p1;
        return;
    }

    public void setWidth(int p1)
    {
        this.width = p1;
        return;
    }
}
