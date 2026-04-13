package com.jlboat.phone.message.map_msgs;
public class PathList extends com.boat.jrosbridge.message.Message {
    public com.boat.jrosbridge.message.geometry_msgs.PoseStamped[] data;
    public String map_name;
    public String path_name;

    public PathList()
    {
        return;
    }

    public com.boat.jrosbridge.message.geometry_msgs.PoseStamped[] getData()
    {
        return this.data;
    }

    public String getMap_name()
    {
        return this.map_name;
    }

    public String getPath_name()
    {
        return this.path_name;
    }

    public void setData(com.boat.jrosbridge.message.geometry_msgs.PoseStamped[] p1)
    {
        this.data = p1;
        return;
    }

    public void setMap_name(String p1)
    {
        this.map_name = p1;
        return;
    }

    public void setPath_name(String p1)
    {
        this.path_name = p1;
        return;
    }
}
