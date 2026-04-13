package com.boat.jrosbridge;
public class Service implements com.boat.jrosbridge.rosbridge.FullMessageHandler {
    private Class callType;
    private java.util.Map calls;
    private com.boat.jrosbridge.ROSClient client;
    private Class responseType;
    private String service;

    public Service(String p2, Class p3, Class p4, com.boat.jrosbridge.ROSClient p5)
    {
        this.service = p2;
        this.client = p5;
        this.responseType = p4;
        this.callType = p3;
        this.calls = new java.util.HashMap();
        return;
    }

    private String call(com.boat.jrosbridge.message.Message p2)
    {
        return this.callImpl(p2, 0);
    }

    private String callImpl(com.boat.jrosbridge.message.Message p5, com.boat.jrosbridge.MessageListener p6)
    {
        this.client.register(com.boat.jrosbridge.rosbridge.operation.ServiceResponse, this.service, this.responseType, this);
        com.boat.jrosbridge.rosbridge.operation.CallService v0_2 = new com.boat.jrosbridge.rosbridge.operation.CallService(this.service, p5);
        String v1_2 = v0_2.id;
        this.calls.put(v1_2, new com.boat.jrosbridge.Service$CallRecord(this, p6));
        this.client.send(v0_2);
        return v1_2;
    }

    public com.boat.jrosbridge.message.Message callBlocking(com.boat.jrosbridge.message.Message p2)
    {
        return this.take(this.call(p2));
    }

    public void callWithHandler(com.boat.jrosbridge.message.Message p1, com.boat.jrosbridge.MessageListener p2)
    {
        this.callImpl(p1, p2);
        return;
    }

    public void onMessage(String p3, com.boat.jrosbridge.message.Message p4)
    {
        com.boat.jrosbridge.Service$CallRecord v0_2 = ((com.boat.jrosbridge.Service$CallRecord) this.calls.get(p3));
        if (v0_2.handler == null) {
            v0_2.result = p4;
            v0_2.latch.countDown();
        } else {
            this.calls.remove(p3);
            v0_2.handler.onNewMessage(p4);
        }
        return;
    }

    public com.boat.jrosbridge.message.Message poll(String p3)
    {
        com.boat.jrosbridge.Service$CallRecord v0_2 = ((com.boat.jrosbridge.Service$CallRecord) this.calls.get(p3));
        if (v0_2.result != null) {
            this.calls.remove(p3);
        }
        return v0_2.result;
    }

    public com.boat.jrosbridge.message.Message take(String p3)
    {
        com.boat.jrosbridge.Service$CallRecord v0_2 = ((com.boat.jrosbridge.Service$CallRecord) this.calls.get(p3));
        v0_2.latch.await();
        this.calls.remove(p3);
        return v0_2.result;
    }

    public void verify()
    {
        int v0 = 0;
        RuntimeException v1_3 = this.client.getServices();
        String v3_0 = 0;
        while (v3_0 < v1_3.length) {
            if (!v1_3[v3_0].equals(this.service)) {
                v3_0++;
            } else {
                v0 = 1;
                break;
            }
        }
        if (v0 == 0) {
            throw new RuntimeException(new StringBuilder().append("Service \'").append(this.service).append("\' not available.").toString());
        } else {
            this.client.typeMatch(this.client.getServiceRequestDetails(this.service), this.callType);
            this.client.typeMatch(this.client.getServiceResponseDetails(this.service), this.responseType);
            return;
        }
    }
}
