package com.boat.jrosbridge;
 class Service$CallRecord {
    public com.boat.jrosbridge.MessageListener handler;
    public java.util.concurrent.CountDownLatch latch;
    public com.boat.jrosbridge.message.Message result;
    final synthetic com.boat.jrosbridge.Service this$0;

    public Service$CallRecord(com.boat.jrosbridge.Service p2, com.boat.jrosbridge.MessageListener p3)
    {
        this.this$0 = p2;
        this.result = 0;
        this.latch = new java.util.concurrent.CountDownLatch(1);
        this.handler = p3;
        return;
    }
}
