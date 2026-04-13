package com.boat.jrosbridge.rosbridge.operation;
public class Publish extends com.boat.jrosbridge.rosbridge.operation.Operation {
    public com.boat.jrosbridge.message.Message msg;
    public String topic;

    public Publish()
    {
        return;
    }

    public Publish(String p1, com.boat.jrosbridge.message.Message p2)
    {
        this.topic = p1;
        this.msg = p2;
        return;
    }
}
