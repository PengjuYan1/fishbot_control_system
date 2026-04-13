package com.boat.jrosbridge.rosbridge;
public class ROSBridgeClient extends com.boat.jrosbridge.ROSClient {
    com.boat.jrosbridge.rosbridge.implementation.ROSBridgeWebSocketClient client;
    String uriString;

    public ROSBridgeClient(String p1)
    {
        this.uriString = p1;
        return;
    }

    private com.boat.jrosbridge.message.rosapi.TypeDef findType(String p6, com.boat.jrosbridge.message.rosapi.TypeDef[] p7)
    {
        com.boat.jrosbridge.message.rosapi.TypeDef v0 = 0;
        int v2 = 0;
        while (v2 < p7.length) {
            com.boat.jrosbridge.message.rosapi.TypeDef v3 = p7[v2];
            if (!v3.type.equals(p6)) {
                v2++;
            } else {
                v0 = v3;
                break;
            }
        }
        return v0;
    }

    private String getServiceType(String p5)
    {
        return ((com.boat.jrosbridge.message.rosapi.Type) new com.boat.jrosbridge.Service("/rosapi/service_type", com.boat.jrosbridge.message.rosapi.Service, com.boat.jrosbridge.message.rosapi.Type, this).callBlocking(new com.boat.jrosbridge.message.rosapi.Service(p5))).type;
    }

    private String getTopicType(String p5)
    {
        return ((com.boat.jrosbridge.message.rosapi.Type) new com.boat.jrosbridge.Service("/rosapi/topic_type", com.boat.jrosbridge.message.rosapi.Topic, com.boat.jrosbridge.message.rosapi.Type, this).callBlocking(new com.boat.jrosbridge.message.rosapi.Topic(p5))).type;
    }

    private com.boat.jrosbridge.message.rosapi.TypeDef getTypeDetails(String p4, String p5, String p6)
    {
        return this.findType(new StringBuilder().append(p4).append(p5).toString(), ((com.boat.jrosbridge.message.rosapi.MessageDetails) new com.boat.jrosbridge.Service(p6, com.boat.jrosbridge.message.rosapi.Type, com.boat.jrosbridge.message.rosapi.MessageDetails, this).callBlocking(new com.boat.jrosbridge.message.rosapi.Type(p4))).typedefs);
    }

    private void typeMatchError(com.boat.jrosbridge.message.rosapi.TypeDef p4, Class p5, String p6, String p7, String p8)
    {
        throw new RuntimeException(new StringBuilder().append("Type match error between ").append(p4.type).append(" and ").append(p5.getName()).append(": ").append(p6).append(": \'").append(p7).append("\' does not match \'").append(p8).append("\'.").toString());
    }

    public boolean connect()
    {
        return this.connect(0);
    }

    public boolean connect(com.boat.jrosbridge.ROSClient$ConnectionStatusListener p5)
    {
        boolean v0 = 0;
        this.client = com.boat.jrosbridge.rosbridge.implementation.ROSBridgeWebSocketClient.create(this.uriString);
        if (this.client == null) {
            if (p5 != null) {
                p5.onDisconnect(0, "", -1);
            }
        } else {
            this.client.setListener(p5);
            try {
                v0 = this.client.connectBlocking();
            } catch (InterruptedException v1_4) {
                v1_4.printStackTrace();
            }
        }
        return v0;
    }

    public void disconnect()
    {
        if ((!this.client.isClosing()) && (!this.client.isClosed())) {
            try {
                this.client.closeBlocking();
            } catch (InterruptedException v0) {
            }
            return;
        } else {
            return;
        }
    }

    public String[] getNodes()
    {
        return ((com.boat.jrosbridge.message.rosapi.Nodes) new com.boat.jrosbridge.Service("/rosapi/nodes", com.boat.jrosbridge.message.std_srvs.Empty, com.boat.jrosbridge.message.rosapi.Nodes, this).callBlocking(new com.boat.jrosbridge.message.std_srvs.Empty())).nodes;
    }

    public com.boat.jrosbridge.message.rosapi.TypeDef getServiceRequestDetails(String p4)
    {
        return this.getTypeDetails(this.getServiceType(p4), "Request", "/rosapi/service_request_details");
    }

    public com.boat.jrosbridge.message.rosapi.TypeDef getServiceResponseDetails(String p4)
    {
        return this.getTypeDetails(this.getServiceType(p4), "Response", "/rosapi/service_response_details");
    }

    public String[] getServices()
    {
        return ((com.boat.jrosbridge.message.rosapi.Services) new com.boat.jrosbridge.Service("/rosapi/services", com.boat.jrosbridge.message.std_srvs.Empty, com.boat.jrosbridge.message.rosapi.Services, this).callBlocking(new com.boat.jrosbridge.message.std_srvs.Empty())).services;
    }

    public com.boat.jrosbridge.message.rosapi.TypeDef getTopicMessageDetails(String p2)
    {
        return this.getTypeDetails(this.getTopicType(p2));
    }

    public String[] getTopics()
    {
        return ((com.boat.jrosbridge.message.rosapi.Topics) new com.boat.jrosbridge.Service("/rosapi/topics", com.boat.jrosbridge.message.std_srvs.Empty, com.boat.jrosbridge.message.rosapi.Topics, this).callBlocking(new com.boat.jrosbridge.message.std_srvs.Empty())).topics;
    }

    public com.boat.jrosbridge.message.rosapi.TypeDef getTypeDetails(String p3)
    {
        return this.getTypeDetails(p3, "", "/rosapi/message_details");
    }

    public Object getUnderlyingClient()
    {
        return this.client;
    }

    public boolean isConnect()
    {
        if ((this.client.isClosing()) && (this.client.isClosed())) {
            int v0_4 = 0;
        } else {
            v0_4 = 1;
        }
        return v0_4;
    }

    public void register(Class p2, String p3, Class p4, com.boat.jrosbridge.rosbridge.FullMessageHandler p5)
    {
        this.client.register(p2, p3, p4, p5);
        return;
    }

    public void send(com.boat.jrosbridge.rosbridge.operation.Operation p2)
    {
        this.client.send(p2);
        return;
    }

    public void setDebug(boolean p2)
    {
        this.client.setDebug(p2);
        return;
    }

    public void typeMatch(com.boat.jrosbridge.message.rosapi.TypeDef p18, Class p19)
    {
        if (p19 == null) {
            throw new RuntimeException(new StringBuilder().append("No registered message type found for: ").append(p18.type).toString());
        } else {
            reflect.Field[] v8 = p19.getFields();
            int v9 = 0;
            while (v9 < p18.fieldnames.length) {
                String v10 = v8[v9].getName();
                String v11 = p18.fieldnames[v9];
                if (!v10.equals(v11)) {
                    this.typeMatchError(p18, p19, "field name", v11, v10);
                }
                com.boat.jrosbridge.message.rosapi.TypeDef v0_19;
                if (p18.fieldarraylen[v9] < 0) {
                    v0_19 = 0;
                } else {
                    v0_19 = 1;
                }
                int v12 = v0_19;
                boolean v13 = v8[v9].getType().isArray();
                if (v12 != v13) {
                    this.typeMatchError(p18, p19, "array mismatch", v11, v10);
                }
                Class v14;
                Class vtmp9 = v8[v9].getType();
                if (!v13) {
                    v14 = vtmp9;
                } else {
                    v14 = v8[v9].getType().getComponentType();
                }
                String v15 = p18.fieldtypes[v9];
                if (!com.boat.jrosbridge.message.Message.isPrimitive(v14)) {
                    if (!com.boat.jrosbridge.message.Message.isAssignableFrom(v14)) {
                        throw new RuntimeException(new StringBuilder().append("Member ").append(v10).append(" of class ").append(v14.getName()).append(" does not extend Message.").toString());
                    } else {
                        String v5_0 = ((com.boat.jrosbridge.message.MessageType) v14.getAnnotation(com.boat.jrosbridge.message.MessageType)).string();
                        if (!v15.equals(v5_0)) {
                            com.boat.jrosbridge.message.rosapi.TypeDef v0 = this.typeMatchError(p18, p19, "message type mismatch", v15, v5_0);
                        }
                        this.typeMatch(this.getTypeDetails(v15), v14);
                    }
                } else {
                    if (!com.boat.jrosbridge.message.rosapi.TypeDef.match(v15, v14)) {
                        this.typeMatchError(p18, p19, "type mismatch", v15, v14.getName());
                    }
                }
                v9++;
            }
            return;
        }
    }

    public void unregister(Class p2, String p3)
    {
        this.client.unregister(p2, p3);
        return;
    }
}
