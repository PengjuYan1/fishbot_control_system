package com.boat.jrosbridge.rosbridge.operation;
public class Advertise extends com.boat.jrosbridge.rosbridge.operation.Operation {
    public String topic;
    public String type;

    public Advertise()
    {
        return;
    }

    public Advertise(String p1, String p2)
    {
        this.topic = p1;
        this.type = p2;
        return;
    }
}
