package com.jlboat.phone.message.map_msgs;
public class ListNaviPointsResponse extends com.boat.jrosbridge.message.Message {
    public com.jlboat.phone.message.map_msgs.PointListEntry[] list_navi_points;
    public com.jlboat.phone.message.map_msgs.PointListEntry[] list_system_points;

    public ListNaviPointsResponse()
    {
        return;
    }

    public java.util.List getListNaviPoints()
    {
        return java.util.Arrays.asList(this.list_navi_points);
    }

    public java.util.List getListSystemPoints()
    {
        return java.util.Arrays.asList(this.list_system_points);
    }

    public void setListNaviPoints(com.jlboat.phone.message.map_msgs.PointListEntry[] p1)
    {
        this.list_navi_points = p1;
        return;
    }

    public void setListSystemPoints(com.jlboat.phone.message.map_msgs.PointListEntry[] p1)
    {
        this.list_system_points = p1;
        return;
    }
}
