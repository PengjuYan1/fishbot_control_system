package com.jlboat.phone.bean;
public class NgNline {
    private double endX;
    private double endY;
    private com.boat.support.slam.entity.floors.NLine nLine;
    private double startX;
    private double startY;

    public NgNline()
    {
        return;
    }

    public double getEndX()
    {
        return this.endX;
    }

    public double getEndY()
    {
        return this.endY;
    }

    public double getStartX()
    {
        return this.startX;
    }

    public double getStartY()
    {
        return this.startY;
    }

    public com.boat.support.slam.entity.floors.NLine getnLine()
    {
        return this.nLine;
    }

    public void setEndX(double p1)
    {
        this.endX = p1;
        return;
    }

    public void setEndY(double p1)
    {
        this.endY = p1;
        return;
    }

    public void setStartX(double p1)
    {
        this.startX = p1;
        return;
    }

    public void setStartY(double p1)
    {
        this.startY = p1;
        return;
    }

    public void setnLine(com.boat.support.slam.entity.floors.NLine p1)
    {
        this.nLine = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("NgNline{nLine=").append(this.nLine).append(", startX=").append(this.startX).append(", startY=").append(this.startY).append(", endX=").append(this.endX).append(", endY=").append(this.endY).append(125).toString();
    }
}
