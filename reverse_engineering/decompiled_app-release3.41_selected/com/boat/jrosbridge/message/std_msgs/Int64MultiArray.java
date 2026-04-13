package com.boat.jrosbridge.message.std_msgs;
public class Int64MultiArray extends com.boat.jrosbridge.message.Message {
    public long[] data;
    public com.boat.jrosbridge.message.std_msgs.MultiArrayLayout layout;

    public Int64MultiArray()
    {
        return;
    }

    public long[] getData()
    {
        return this.data;
    }

    public com.boat.jrosbridge.message.std_msgs.MultiArrayLayout getLayout()
    {
        return this.layout;
    }

    public void setData(long[] p1)
    {
        this.data = p1;
        return;
    }

    public void setLayout(com.boat.jrosbridge.message.std_msgs.MultiArrayLayout p1)
    {
        this.layout = p1;
        return;
    }
}
