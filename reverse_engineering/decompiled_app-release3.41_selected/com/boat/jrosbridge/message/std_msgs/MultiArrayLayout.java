package com.boat.jrosbridge.message.std_msgs;
public class MultiArrayLayout extends com.boat.jrosbridge.message.Message {
    public int data_offset;
    public com.boat.jrosbridge.message.std_msgs.MultiArrayDimension[] dim;

    public MultiArrayLayout()
    {
        return;
    }

    public int getDataOffset()
    {
        return this.data_offset;
    }

    public java.util.List getDim()
    {
        return java.util.Arrays.asList(this.dim);
    }

    public void setDataOffset(int p1)
    {
        this.data_offset = p1;
        return;
    }

    public void setDim(java.util.List p2)
    {
        com.boat.jrosbridge.message.std_msgs.MultiArrayDimension[] v0_1 = new com.boat.jrosbridge.message.std_msgs.MultiArrayDimension[0];
        this.dim = ((com.boat.jrosbridge.message.std_msgs.MultiArrayDimension[]) p2.toArray(v0_1));
        return;
    }
}
