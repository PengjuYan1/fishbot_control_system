package com.boat.support.slam.entity.floors;
public class NLine implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    private int direction;
    private long endNid;
    private long id;
    private float speed;
    private long startNid;
    private int type;
    private float weight;

    static NLine()
    {
        com.boat.support.slam.entity.floors.NLine.CREATOR = new com.boat.support.slam.entity.floors.NLine$1();
        return;
    }

    public NLine()
    {
        return;
    }

    protected NLine(android.os.Parcel p3)
    {
        this.id = p3.readLong();
        this.startNid = p3.readLong();
        this.endNid = p3.readLong();
        this.type = p3.readInt();
        this.direction = p3.readInt();
        this.weight = p3.readFloat();
        this.speed = p3.readFloat();
        return;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getDirection()
    {
        return this.direction;
    }

    public long getEndNid()
    {
        return this.endNid;
    }

    public long getId()
    {
        return this.id;
    }

    public float getSpeed()
    {
        return this.speed;
    }

    public long getStartNid()
    {
        return this.startNid;
    }

    public int getType()
    {
        return this.type;
    }

    public float getWeight()
    {
        return this.weight;
    }

    public void setDirection(int p1)
    {
        this.direction = p1;
        return;
    }

    public void setEndNid(long p1)
    {
        this.endNid = p1;
        return;
    }

    public void setId(long p1)
    {
        this.id = p1;
        return;
    }

    public void setSpeed(float p1)
    {
        this.speed = p1;
        return;
    }

    public void setStartNid(long p1)
    {
        this.startNid = p1;
        return;
    }

    public void setType(int p1)
    {
        this.type = p1;
        return;
    }

    public void setWeight(float p1)
    {
        this.weight = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("NLine{id=").append(this.id).append(", startNid=").append(this.startNid).append(", endNid=").append(this.endNid).append(", type=").append(this.type).append(", direction=").append(this.direction).append(", weight=").append(this.weight).append(", speed=").append(this.speed).append(125).toString();
    }

    public void writeToParcel(android.os.Parcel p3, int p4)
    {
        p3.writeLong(this.id);
        p3.writeLong(this.startNid);
        p3.writeLong(this.endNid);
        p3.writeInt(this.type);
        p3.writeInt(this.direction);
        p3.writeFloat(this.weight);
        p3.writeFloat(this.speed);
        return;
    }
}
