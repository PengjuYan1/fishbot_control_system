package com.boat.jrosbridge;
 class Topic$MessageRunner implements java.lang.Runnable {
    private com.boat.jrosbridge.MessageListener handler;
    final synthetic com.boat.jrosbridge.Topic this$0;

    public Topic$MessageRunner(com.boat.jrosbridge.Topic p1, com.boat.jrosbridge.MessageListener p2)
    {
        this.this$0 = p1;
        this.handler = p2;
        return;
    }

    public void run()
    {
        while (!Thread.interrupted()) {
            try {
                this.handler.onNewMessage(((com.boat.jrosbridge.message.Message) this.this$0.take()));
            } catch (InterruptedException v0) {
                break;
            }
        }
        return;
    }
}
