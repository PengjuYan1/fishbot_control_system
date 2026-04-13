package com.jlboat.phone.message.map_msgs;
public class BagListResponse extends com.boat.jrosbridge.message.Message {
    public String[] bag_names;
    public int status;

    public BagListResponse()
    {
        return;
    }

    public java.util.List getBagNames()
    {
        return java.util.Arrays.asList(this.bag_names);
    }

    public int getStatus()
    {
        return this.status;
    }

    public void setBagNames(String[] p1)
    {
        this.bag_names = p1;
        return;
    }

    public void setStatus(int p1)
    {
        this.status = p1;
        return;
    }
}
