package com.boat.jrosbridge.message.nav_msgs;
public class OccupancyGrid extends com.boat.jrosbridge.message.Message {
    public byte[] data;
    public String datas;
    public com.boat.jrosbridge.message.std_msgs.Header header;
    public com.boat.jrosbridge.message.nav_msgs.MapMetaData info;

    public OccupancyGrid()
    {
        return;
    }

    public byte[] getData()
    {
        return this.data;
    }

    public String getDataS()
    {
        return this.datas;
    }

    public com.boat.jrosbridge.message.std_msgs.Header getHeader()
    {
        return this.header;
    }

    public com.boat.jrosbridge.message.nav_msgs.MapMetaData getInfo()
    {
        return this.info;
    }

    public void setData(byte[] p1)
    {
        this.data = p1;
        return;
    }

    public void setDataS(String p1)
    {
        this.datas = p1;
        return;
    }

    public void setHeader(com.boat.jrosbridge.message.std_msgs.Header p1)
    {
        this.header = p1;
        return;
    }

    public void setInfo(com.boat.jrosbridge.message.nav_msgs.MapMetaData p1)
    {
        this.info = p1;
        return;
    }
}
