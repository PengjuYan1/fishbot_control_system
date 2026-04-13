package com.boat.jrosbridge.message.sensor_msgs;
public class LaserScan extends com.boat.jrosbridge.message.Message {
    public float angle_increment;
    public float angle_max;
    public float angle_min;
    public com.boat.jrosbridge.message.std_msgs.Header header;
    public float[] intensities;
    public float range_max;
    public float range_min;
    public float[] ranges;
    public float scan_time;
    public float time_increment;

    public LaserScan()
    {
        return;
    }

    public float getAngleIncrement()
    {
        return this.angle_increment;
    }

    public float getAngleMax()
    {
        return this.angle_max;
    }

    public float getAngleMin()
    {
        return this.angle_min;
    }

    public com.boat.jrosbridge.message.std_msgs.Header getHeader()
    {
        return this.header;
    }

    public float[] getIntensities()
    {
        return this.intensities;
    }

    public float getRangeMax()
    {
        return this.range_max;
    }

    public float getRangeMin()
    {
        return this.range_min;
    }

    public float[] getRanges()
    {
        return this.ranges;
    }

    public float getScanTime()
    {
        return this.scan_time;
    }

    public float getTimeIncrement()
    {
        return this.time_increment;
    }

    public void setAngleIncrement(float p1)
    {
        this.angle_increment = p1;
        return;
    }

    public void setAngleMax(float p1)
    {
        this.angle_max = p1;
        return;
    }

    public void setAngleMin(float p1)
    {
        this.angle_min = p1;
        return;
    }

    public void setHeader(com.boat.jrosbridge.message.std_msgs.Header p1)
    {
        this.header = p1;
        return;
    }

    public void setIntensities(float[] p1)
    {
        this.intensities = p1;
        return;
    }

    public void setRangeMax(float p1)
    {
        this.range_max = p1;
        return;
    }

    public void setRangeMin(float p1)
    {
        this.range_min = p1;
        return;
    }

    public void setRanges(float[] p1)
    {
        this.ranges = p1;
        return;
    }

    public void setScanTime(float p1)
    {
        this.scan_time = p1;
        return;
    }

    public void setTimeIncrement(float p1)
    {
        this.time_increment = p1;
        return;
    }
}
