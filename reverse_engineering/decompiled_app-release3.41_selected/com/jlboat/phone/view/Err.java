package com.jlboat.phone.view;
public class Err implements java.lang.Comparable, android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
    private java.util.Date da;
    private int flag;
    private String msg;
    private int type;

    static Err()
    {
        com.jlboat.phone.view.Err.CREATOR = new com.jlboat.phone.view.Err$1();
        return;
    }

    public Err()
    {
        return;
    }

    protected Err(android.os.Parcel p6)
    {
        java.util.Date v2_0;
        this.msg = p6.readString();
        long v0_1 = p6.readLong();
        if (v0_1 != -1) {
            v2_0 = new java.util.Date(v0_1);
        } else {
            v2_0 = 0;
        }
        this.da = v2_0;
        return;
    }

    public int compareTo(com.jlboat.phone.view.Err p5)
    {
        return ((int) (p5.getDa().getTime() - this.getDa().getTime()));
    }

    public bridge synthetic int compareTo(Object p1)
    {
        return this.compareTo(((com.jlboat.phone.view.Err) p1));
    }

    public int describeContents()
    {
        return 0;
    }

    public java.util.Date getDa()
    {
        return this.da;
    }

    public int getFlag()
    {
        return this.flag;
    }

    public String getMsg()
    {
        return this.msg;
    }

    public int getType()
    {
        return this.type;
    }

    public void readFromParcel(android.os.Parcel p6)
    {
        java.util.Date v2_0;
        this.msg = p6.readString();
        long v0_1 = p6.readLong();
        if (v0_1 != -1) {
            v2_0 = new java.util.Date(v0_1);
        } else {
            v2_0 = 0;
        }
        this.da = v2_0;
        return;
    }

    public void setDa(java.util.Date p1)
    {
        this.da = p1;
        return;
    }

    public void setFlag(int p1)
    {
        this.flag = p1;
        return;
    }

    public void setMsg(String p1)
    {
        this.msg = p1;
        return;
    }

    public void setType(int p1)
    {
        this.type = p1;
        return;
    }

    public String toString()
    {
        return this.msg;
    }

    public void writeToParcel(android.os.Parcel p3, int p4)
    {
        long v0_2;
        p3.writeString(this.msg);
        if (this.da == null) {
            v0_2 = -1;
        } else {
            v0_2 = this.da.getTime();
        }
        p3.writeLong(v0_2);
        return;
    }
}
