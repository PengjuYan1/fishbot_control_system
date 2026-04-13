package com.boat.jrosbridge.rosbridge.operation;
public class ServiceResponse extends com.boat.jrosbridge.rosbridge.operation.Operation {
    public boolean result;
    public String service;
    public com.boat.jrosbridge.message.Message values;

    public ServiceResponse()
    {
        return;
    }

    public ServiceResponse(String p1)
    {
        this.service = p1;
        return;
    }
}
