package com.boat.jrosbridge.rosbridge.operation;
public class Fragment extends com.boat.jrosbridge.rosbridge.operation.Operation {
    public String data;
    public int num;
    public int total;

    public Fragment()
    {
        return;
    }

    public Fragment(String p1, int p2, int p3)
    {
        this.data = p1;
        this.num = p2;
        this.total = p3;
        return;
    }
}
