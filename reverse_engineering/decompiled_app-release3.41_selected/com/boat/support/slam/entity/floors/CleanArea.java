package com.boat.support.slam.entity.floors;
public class CleanArea implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    private com.boat.support.slam.entity.floors.Circle circle;
    private long cleanAreaId;
    private String cleanAreaName;
    private boolean closed;
    private com.boat.support.slam.entity.floors.Ellipse ellipse;
    private java.util.List lines;
    private int sequenceId;
    private String type;

    static CleanArea()
    {
        com.boat.support.slam.entity.floors.CleanArea.CREATOR = new com.boat.support.slam.entity.floors.CleanArea$1();
        return;
    }

    public CleanArea(android.os.Parcel p3)
    {
        com.boat.support.slam.entity.floors.Ellipse v0_1;
        this.cleanAreaId = p3.readLong();
        this.sequenceId = p3.readInt();
        this.lines = p3.createTypedArrayList(com.boat.support.slam.entity.floors.Lines.CREATOR);
        if (p3.readByte() == 0) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        this.closed = v0_1;
        this.circle = ((com.boat.support.slam.entity.floors.Circle) p3.readParcelable(com.boat.support.slam.entity.floors.Circle.getClassLoader()));
        this.type = p3.readString();
        this.cleanAreaName = p3.readString();
        this.ellipse = ((com.boat.support.slam.entity.floors.Ellipse) p3.readParcelable(com.boat.support.slam.entity.floors.Ellipse.getClassLoader()));
        return;
    }

    public CleanArea(String p1)
    {
        this.type = p1;
        return;
    }

    public int describeContents()
    {
        return 0;
    }

    public com.boat.support.slam.entity.floors.Circle getCircle()
    {
        return this.circle;
    }

    public long getCleanAreaId()
    {
        return this.cleanAreaId;
    }

    public String getCleanAreaName()
    {
        return this.cleanAreaName;
    }

    public boolean getClosed()
    {
        return this.closed;
    }

    public com.boat.support.slam.entity.floors.Ellipse getEllipse()
    {
        return this.ellipse;
    }

    public java.util.List getLines()
    {
        return this.lines;
    }

    public int getSequenceId()
    {
        return this.sequenceId;
    }

    public String getType()
    {
        return this.type;
    }

    public void setCircle(com.boat.support.slam.entity.floors.Circle p1)
    {
        this.circle = p1;
        return;
    }

    public void setCleanAreaId(long p1)
    {
        this.cleanAreaId = p1;
        return;
    }

    public void setCleanAreaName(String p1)
    {
        this.cleanAreaName = p1;
        return;
    }

    public void setClosed(boolean p1)
    {
        this.closed = p1;
        return;
    }

    public void setEllipse(com.boat.support.slam.entity.floors.Ellipse p1)
    {
        this.ellipse = p1;
        return;
    }

    public void setLines(java.util.List p1)
    {
        this.lines = p1;
        return;
    }

    public void setSequenceId(int p1)
    {
        this.sequenceId = p1;
        return;
    }

    public void setType(String p1)
    {
        this.type = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("CleanArea{cleanAreaId=").append(this.cleanAreaId).append(", sequenceId=").append(this.sequenceId).append(", lines=").append(this.lines).append(", closed=").append(this.closed).append(", circle=").append(this.circle).append(", type=\'").append(this.type).append(39).append(", cleanAreaName=\'").append(this.cleanAreaName).append(39).append(", ellipse=").append(this.ellipse).append(125).toString();
    }

    public void writeToParcel(android.os.Parcel p3, int p4)
    {
        p3.writeLong(this.cleanAreaId);
        p3.writeInt(this.sequenceId);
        p3.writeTypedList(this.lines);
        p3.writeByte(((byte) this.closed));
        p3.writeParcelable(this.circle, p4);
        p3.writeString(this.type);
        p3.writeString(this.cleanAreaName);
        p3.writeParcelable(this.ellipse, p4);
        return;
    }
}
