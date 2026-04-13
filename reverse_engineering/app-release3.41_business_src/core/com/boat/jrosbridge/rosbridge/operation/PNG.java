package com.boat.jrosbridge.rosbridge.operation;
public class PNG extends com.boat.jrosbridge.rosbridge.operation.Operation {
    public String data;
    public Integer num;
    public Integer total;

    public PNG()
    {
        return;
    }

    public PNG(String p1)
    {
        this.data = p1;
        return;
    }

    public PNG(String p2, int p3, int p4)
    {
        this.data = p2;
        this.num = Integer.valueOf(p3);
        this.total = Integer.valueOf(p4);
        return;
    }
}
