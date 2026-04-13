package com.jlboat.phone.message.map_msgs;
public class CalculateOdomResponse extends com.boat.jrosbridge.message.Message {
    public float diff_distance;
    public float leftmotor_ratio;
    public float rightmotor_ratio;
    public int status;

    public CalculateOdomResponse()
    {
        return;
    }

    public float getDiff_distance()
    {
        return this.diff_distance;
    }

    public float getLeftmotor_ratio()
    {
        return this.leftmotor_ratio;
    }

    public float getRightmotor_ratio()
    {
        return this.rightmotor_ratio;
    }

    public int getStatus()
    {
        return this.status;
    }

    public void setDiff_distance(float p1)
    {
        this.diff_distance = p1;
        return;
    }

    public void setLeftmotor_ratio(float p1)
    {
        this.leftmotor_ratio = p1;
        return;
    }

    public void setRightmotor_ratio(float p1)
    {
        this.rightmotor_ratio = p1;
        return;
    }

    public void setStatus(int p1)
    {
        this.status = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("CalculateOdomResponse{status=").append(this.status).append(", diff_distance=").append(this.diff_distance).append(", leftmotor_ratio=").append(this.leftmotor_ratio).append(", rightmotor_ratio=").append(this.rightmotor_ratio).append(125).toString();
    }
}
