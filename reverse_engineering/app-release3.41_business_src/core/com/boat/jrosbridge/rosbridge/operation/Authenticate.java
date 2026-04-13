package com.boat.jrosbridge.rosbridge.operation;
public class Authenticate extends com.boat.jrosbridge.rosbridge.operation.Operation {
    public String client;
    public String dest;
    public int end;
    public String level;
    public String mac;
    public String rand;
    public int t;

    public Authenticate()
    {
        return;
    }

    public Authenticate(String p2, String p3, String p4, String p5, int p6, String p7, int p8)
    {
        this.mac = p2;
        this.client = p3;
        this.dest = p4;
        this.rand = p5;
        this.t = p6;
        this.level = p7;
        this.end = p8;
        this.id = 0;
        return;
    }
}
