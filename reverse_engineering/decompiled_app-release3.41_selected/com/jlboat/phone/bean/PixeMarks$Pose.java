package com.jlboat.phone.bean;
public class PixeMarks$Pose {
    double x;
    double y;
    double z;

    public PixeMarks$Pose()
    {
        return;
    }

    public PixeMarks$Pose(double p1, double p3, double p5)
    {
        this.x = p1;
        this.y = p3;
        this.z = p5;
        return;
    }

    public double getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }

    public double getZ()
    {
        return this.z;
    }

    public void setX(double p1)
    {
        this.x = p1;
        return;
    }

    public void setY(double p1)
    {
        this.y = p1;
        return;
    }

    public void setZ(double p1)
    {
        this.z = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("Pose{x=").append(this.x).append(", y=").append(this.y).append(", z=").append(this.z).append(125).toString();
    }
}
