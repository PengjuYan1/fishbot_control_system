package com.jlboat.phone.message.map_msgs;
public class TargetGoalPlanResponse extends com.boat.jrosbridge.message.Message {
    public double distance;
    public long local_floor_id;
    public long local_map_id;
    public double local_x;
    public double local_y;
    public double local_yaw;
    public String msg;
    public int status;
    public long target_floor_id;
    public long target_map_id;
    public long target_point_id;

    public TargetGoalPlanResponse()
    {
        return;
    }

    public double getDistance()
    {
        return this.distance;
    }

    public long getLocalFloorId()
    {
        return this.local_floor_id;
    }

    public long getLocalMapId()
    {
        return this.local_map_id;
    }

    public double getLocalX()
    {
        return this.local_x;
    }

    public double getLocalY()
    {
        return this.local_y;
    }

    public double getLocalYaw()
    {
        return this.local_yaw;
    }

    public String getMsg()
    {
        return this.msg;
    }

    public int getStatus()
    {
        return this.status;
    }

    public long getTargetFloorId()
    {
        return this.target_floor_id;
    }

    public long getTargetMapId()
    {
        return this.target_map_id;
    }

    public long getTargetPointId()
    {
        return this.target_point_id;
    }

    public void setDistance(double p1)
    {
        this.distance = p1;
        return;
    }

    public void setLocalFloorId(long p1)
    {
        this.local_floor_id = p1;
        return;
    }

    public void setLocalMapId(long p1)
    {
        this.local_map_id = p1;
        return;
    }

    public void setLocalX(double p1)
    {
        this.local_x = p1;
        return;
    }

    public void setLocalY(double p1)
    {
        this.local_y = p1;
        return;
    }

    public void setLocalYaw(double p1)
    {
        this.local_yaw = p1;
        return;
    }

    public void setMsg(String p1)
    {
        this.msg = p1;
        return;
    }

    public void setStatus(int p1)
    {
        this.status = p1;
        return;
    }

    public void setTargetFloorId(long p1)
    {
        this.target_floor_id = p1;
        return;
    }

    public void setTargetMapId(long p1)
    {
        this.target_map_id = p1;
        return;
    }

    public void setTargetPointId(long p1)
    {
        this.target_point_id = p1;
        return;
    }
}
