package com.boat.jrosbridge;
public abstract class ROSClient {

    public ROSClient()
    {
        return;
    }

    public static com.boat.jrosbridge.ROSClient create(String p1)
    {
        return new com.boat.jrosbridge.rosbridge.ROSBridgeClient(p1);
    }

    public abstract boolean connect();

    public abstract boolean connect();

    public abstract void disconnect();

    public abstract String[] getNodes();

    public abstract com.boat.jrosbridge.message.rosapi.TypeDef getServiceRequestDetails();

    public abstract com.boat.jrosbridge.message.rosapi.TypeDef getServiceResponseDetails();

    public abstract String[] getServices();

    public abstract com.boat.jrosbridge.message.rosapi.TypeDef getTopicMessageDetails();

    public abstract String[] getTopics();

    public abstract com.boat.jrosbridge.message.rosapi.TypeDef getTypeDetails();

    public abstract Object getUnderlyingClient();

    public abstract void register();

    public abstract void send();

    public abstract void setDebug();

    public abstract void typeMatch();

    public abstract void unregister();
}
