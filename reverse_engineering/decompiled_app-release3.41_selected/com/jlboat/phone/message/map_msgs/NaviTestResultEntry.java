package com.jlboat.phone.message.map_msgs;
public class NaviTestResultEntry extends com.boat.jrosbridge.message.Message {
    public long charge_result;
    public Long floor_id;
    public String goal_name;
    public long goal_result;
    public Long map_id;
    public Long point_id;
    public long test_type;

    public NaviTestResultEntry()
    {
        return;
    }

    public long getChargeResult()
    {
        return this.charge_result;
    }

    public long getCharge_result()
    {
        return this.charge_result;
    }

    public Long getFloor_id()
    {
        return this.floor_id;
    }

    public String getGoalName()
    {
        return this.goal_name;
    }

    public long getGoalResult()
    {
        return this.goal_result;
    }

    public String getGoal_name()
    {
        return this.goal_name;
    }

    public long getGoal_result()
    {
        return this.goal_result;
    }

    public Long getMap_id()
    {
        return this.map_id;
    }

    public Long getPoint_id()
    {
        return this.point_id;
    }

    public long getTestType()
    {
        return this.test_type;
    }

    public long getTest_type()
    {
        return this.test_type;
    }

    public void setChargeResult(long p1)
    {
        this.charge_result = p1;
        return;
    }

    public void setCharge_result(long p1)
    {
        this.charge_result = p1;
        return;
    }

    public void setFloor_id(Long p1)
    {
        this.floor_id = p1;
        return;
    }

    public void setGoalName(String p1)
    {
        this.goal_name = p1;
        return;
    }

    public void setGoalResult(long p1)
    {
        this.goal_result = p1;
        return;
    }

    public void setGoal_name(String p1)
    {
        this.goal_name = p1;
        return;
    }

    public void setGoal_result(long p1)
    {
        this.goal_result = p1;
        return;
    }

    public void setMap_id(Long p1)
    {
        this.map_id = p1;
        return;
    }

    public void setPoint_id(Long p1)
    {
        this.point_id = p1;
        return;
    }

    public void setTestType(long p1)
    {
        this.test_type = p1;
        return;
    }

    public void setTest_type(long p1)
    {
        this.test_type = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("NaviTestResultEntry{floor_id=").append(this.floor_id).append(", map_id=").append(this.map_id).append(", point_id=").append(this.point_id).append(", goal_name=\'").append(this.goal_name).append(39).append(", goal_result=").append(this.goal_result).append(", charge_result=").append(this.charge_result).append(", test_type=").append(this.test_type).append(125).toString();
    }
}
