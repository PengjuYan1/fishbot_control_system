package com.boat.jrosbridge.rosbridge.operation;
public class Unsubscribe extends com.boat.jrosbridge.rosbridge.operation.Operation {
    public String topic;

    public Unsubscribe()
    {
        return;
    }

    public Unsubscribe(String p1)
    {
        this.topic = p1;
        return;
    }
}
