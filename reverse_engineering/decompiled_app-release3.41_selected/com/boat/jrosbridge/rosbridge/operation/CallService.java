package com.boat.jrosbridge.rosbridge.operation;
public class CallService extends com.boat.jrosbridge.rosbridge.operation.Operation {
    public com.boat.jrosbridge.message.Message args;
    public String compression;
    public Integer fragment_size;
    public String service;

    public CallService()
    {
        return;
    }

    public CallService(String p1, com.boat.jrosbridge.message.Message p2)
    {
        this.service = p1;
        this.args = p2;
        return;
    }
}
