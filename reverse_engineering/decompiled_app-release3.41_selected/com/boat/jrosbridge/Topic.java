package com.boat.jrosbridge;
public class Topic extends java.util.concurrent.LinkedBlockingQueue implements com.boat.jrosbridge.rosbridge.FullMessageHandler {
    String TAG;
    private com.boat.jrosbridge.ROSClient client;
    private String compression;
    private Thread handlerThread;
    private boolean hascompression;
    private String messageType;
    protected String topic;
    private Class type;

    public Topic(String p2, Class p3, com.boat.jrosbridge.ROSClient p4)
    {
        this.TAG = "RosTopic";
        this.topic = p2;
        this.client = p4;
        this.type = p3;
        this.messageType = com.boat.jrosbridge.message.Message.getMessageType(p3);
        this.handlerThread = 0;
        return;
    }

    private void send(com.boat.jrosbridge.rosbridge.operation.Operation p2)
    {
        this.client.send(p2);
        return;
    }

    private void startRunner(com.boat.jrosbridge.MessageListener p4)
    {
        this.stopRunner();
        this.handlerThread = new Thread(new com.boat.jrosbridge.Topic$MessageRunner(this, p4));
        this.handlerThread.setName(new StringBuilder().append("Message handler for ").append(this.topic).toString());
        this.handlerThread.start();
        return;
    }

    private void stopRunner()
    {
        if (this.handlerThread != null) {
            this.handlerThread.interrupt();
            this.clear();
            this.handlerThread = 0;
        }
        return;
    }

    public void advertise()
    {
        this.send(new com.boat.jrosbridge.rosbridge.operation.Advertise(this.topic, this.messageType));
        return;
    }

    public void onMessage(String p1, com.boat.jrosbridge.message.Message p2)
    {
        this.add(p2);
        return;
    }

    public void publish(com.boat.jrosbridge.message.Message p3)
    {
        this.send(new com.boat.jrosbridge.rosbridge.operation.Publish(this.topic, p3));
        return;
    }

    public void setCompression(String p2)
    {
        this.hascompression = 1;
        this.compression = p2;
        return;
    }

    public void subscribe()
    {
        this.client.register(com.boat.jrosbridge.rosbridge.operation.Publish, this.topic, this.type, this);
        if (!this.hascompression) {
            this.send(new com.boat.jrosbridge.rosbridge.operation.Subscribe(this.topic, this.messageType));
        } else {
            this.send(new com.boat.jrosbridge.rosbridge.operation.Subscribe(this.topic, this.messageType, this.compression));
        }
        return;
    }

    public void subscribe(com.boat.jrosbridge.MessageListener p1)
    {
        this.startRunner(p1);
        this.subscribe();
        return;
    }

    public void unadvertise()
    {
        this.send(new com.boat.jrosbridge.rosbridge.operation.Unadvertise(this.topic));
        return;
    }

    public void unsubscribe()
    {
        this.send(new com.boat.jrosbridge.rosbridge.operation.Unsubscribe(this.topic));
        this.client.unregister(com.boat.jrosbridge.rosbridge.operation.Publish, this.topic);
        this.stopRunner();
        return;
    }

    public void verify()
    {
        int v0 = 0;
        RuntimeException v1_3 = this.client.getTopics();
        String v3_0 = 0;
        while (v3_0 < v1_3.length) {
            if (!v1_3[v3_0].equals(this.topic)) {
                v3_0++;
            } else {
                v0 = 1;
                break;
            }
        }
        if (v0 == 0) {
            throw new RuntimeException(new StringBuilder().append("Topic \'").append(this.topic).append("\' not available.").toString());
        } else {
            this.client.typeMatch(this.client.getTopicMessageDetails(this.topic), this.type);
            return;
        }
    }
}
