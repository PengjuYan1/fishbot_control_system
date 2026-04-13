package com.boat.support.slam.entity.floors;
public class NaviTest extends com.boat.jrosbridge.message.Message {
    public Long floor_id;
    public String goal_name;
    public Long map_id;
    public Long point_id;

    public NaviTest()
    {
        return;
    }

    public Long getFloorId()
    {
        return this.floor_id;
    }

    public String getGoal_name()
    {
        return this.goal_name;
    }

    public Long getMapId()
    {
        return this.map_id;
    }

    public Long getPointId()
    {
        return this.point_id;
    }

    public void setFloorId(Long p1)
    {
        this.floor_id = p1;
        return;
    }

    public void setGoal_name(String p1)
    {
        this.goal_name = p1;
        return;
    }

    public void setMapId(Long p1)
    {
        this.map_id = p1;
        return;
    }

    public void setPointId(Long p1)
    {
        this.point_id = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("NaviTest{floorId=").append(this.floor_id).append(", mapId=").append(this.map_id).append(", pointId=").append(this.point_id).append(", goal_name=").append(this.goal_name).append(125).toString();
    }
}
