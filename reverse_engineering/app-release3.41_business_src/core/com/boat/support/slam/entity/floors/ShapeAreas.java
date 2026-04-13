package com.boat.support.slam.entity.floors;
public class ShapeAreas implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    private com.boat.support.slam.entity.floors.Circle circle;
    private boolean closed;
    private com.boat.support.slam.entity.floors.Ellipse ellipse;
    private java.util.List lines;
    private int orderNum;
    private long shapeId;
    private String type;

    static ShapeAreas()
    {
        com.boat.support.slam.entity.floors.ShapeAreas.CREATOR = new com.boat.support.slam.entity.floors.ShapeAreas$1();
        return;
    }

    protected ShapeAreas(android.os.Parcel p3)
    {
        com.boat.support.slam.entity.floors.Ellipse v0_1;
        this.shapeId = p3.readLong();
        this.orderNum = p3.readInt();
        this.lines = p3.createTypedArrayList(com.boat.support.slam.entity.floors.Lines.CREATOR);
        if (p3.readByte() == 0) {
            v0_1 = 0;
        } else {
            v0_1 = 1;
        }
        this.closed = v0_1;
        this.circle = ((com.boat.support.slam.entity.floors.Circle) p3.readParcelable(com.boat.support.slam.entity.floors.Circle.getClassLoader()));
        this.type = p3.readString();
        this.ellipse = ((com.boat.support.slam.entity.floors.Ellipse) p3.readParcelable(com.boat.support.slam.entity.floors.Ellipse.getClassLoader()));
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

    public int getOrderNum()
    {
        return this.orderNum;
    }

    public long getShapeId()
    {
        return this.shapeId;
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

    public void setOrderNum(int p1)
    {
        this.orderNum = p1;
        return;
    }

    public void setShapeId(int p3)
    {
        this.shapeId = ((long) p3);
        return;
    }

    public void setType(String p1)
    {
        this.type = p1;
        return;
    }

    public void writeToParcel(android.os.Parcel p3, int p4)
    {
        p3.writeLong(this.shapeId);
        p3.writeInt(this.orderNum);
        p3.writeTypedList(this.lines);
        p3.writeByte(((byte) this.closed));
        p3.writeParcelable(this.circle, p4);
        p3.writeString(this.type);
        p3.writeParcelable(this.ellipse, p4);
        return;
    }
}
