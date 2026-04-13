package com.boat.support.slam.entity.floors;
public class CustomPath implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    private boolean closed;
    private java.util.List lines;
    private String name;
    private long pathId;
    private int state;

    static CustomPath()
    {
        com.boat.support.slam.entity.floors.CustomPath.CREATOR = new com.boat.support.slam.entity.floors.CustomPath$1();
        return;
    }

    protected CustomPath(android.os.Parcel p3)
    {
        String v0_1;
        this.pathId = p3.readLong();
        this.state = p3.readInt();
        this.lines = p3.createTypedArrayList(com.boat.support.slam.entity.floors.Lines.CREATOR);
        if (p3.readByte() == 0) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        this.closed = v0_1;
        this.name = p3.readString();
        return;
    }

    public int describeContents()
    {
        return 0;
    }

    public java.util.List getLines()
    {
        return this.lines;
    }

    public String getName()
    {
        return this.name;
    }

    public long getPathId()
    {
        return this.pathId;
    }

    public int getState()
    {
        return this.state;
    }

    public boolean isClosed()
    {
        return this.closed;
    }

    public void setClosed(boolean p1)
    {
        this.closed = p1;
        return;
    }

    public void setLines(java.util.List p1)
    {
        this.lines = p1;
        return;
    }

    public void setName(String p1)
    {
        this.name = p1;
        return;
    }

    public void setPathId(long p1)
    {
        this.pathId = p1;
        return;
    }

    public void setState(int p1)
    {
        this.state = p1;
        return;
    }

    public void writeToParcel(android.os.Parcel p3, int p4)
    {
        p3.writeLong(this.pathId);
        p3.writeInt(this.state);
        p3.writeTypedList(this.lines);
        p3.writeByte(((byte) this.closed));
        p3.writeString(this.name);
        return;
    }
}
