package com.boat.jrosbridge.message.std_msgs;
public class Float32MultiArray extends com.boat.jrosbridge.message.Message {
    public float[] data;
    public com.boat.jrosbridge.message.std_msgs.MultiArrayLayout layout;

    public Float32MultiArray()
    {
        return;
    }

    public float[] getData()
    {
        return this.data;
    }

    public com.boat.jrosbridge.message.std_msgs.MultiArrayLayout getLayout()
    {
        return this.layout;
    }

    public void setData(float[] p1)
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
