package com.boat.jrosbridge.rosbridge.operation;
public class Status extends com.boat.jrosbridge.rosbridge.operation.Operation {
    String level;
    String msg;

    public Status()
    {
        return;
    }

    public Status(String p1, String p2)
    {
        this.level = p1;
        this.msg = p2;
        return;
    }
}
