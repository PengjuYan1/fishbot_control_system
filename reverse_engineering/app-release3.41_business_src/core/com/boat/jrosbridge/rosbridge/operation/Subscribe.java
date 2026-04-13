package com.boat.jrosbridge.rosbridge.operation;
public class Subscribe extends com.boat.jrosbridge.rosbridge.operation.Operation {
    public String compression;
    public Integer fragment_size;
    public Integer queue_length;
    public Integer throttle_rate;
    public String topic;
    public String type;

    public Subscribe()
    {
        this.queue_length = Integer.valueOf(10);
        return;
    }

    public Subscribe(String p2, String p3)
    {
        this.queue_length = Integer.valueOf(10);
        this.topic = p2;
        this.type = p3;
        return;
    }

    public Subscribe(String p2, String p3, String p4)
    {
        this.queue_length = Integer.valueOf(10);
        this.topic = p2;
        this.type = p3;
        this.compression = p4;
        return;
    }
}
