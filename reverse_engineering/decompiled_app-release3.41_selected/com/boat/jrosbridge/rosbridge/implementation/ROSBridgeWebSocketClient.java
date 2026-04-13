package com.boat.jrosbridge.rosbridge.implementation;
public class ROSBridgeWebSocketClient extends org.java_websocket.client.WebSocketClient {
    static final String TAG = "ROSWebSocketClient";
    private int a;
    private com.boat.jrosbridge.rosbridge.implementation.Registry classes;
    private boolean debug;
    private com.boat.jrosbridge.rosbridge.implementation.Registry handlers;
    private com.boat.jrosbridge.ROSClient$ConnectionStatusListener listener;

    ROSBridgeWebSocketClient(java.net.URI p2)
    {
        super(p2);
        super.a = 0;
        super.classes = new com.boat.jrosbridge.rosbridge.implementation.Registry();
        super.handlers = new com.boat.jrosbridge.rosbridge.implementation.Registry();
        com.boat.jrosbridge.rosbridge.operation.Operation.initialize(super.classes);
        super.listener = 0;
        return;
    }

    public static com.boat.jrosbridge.rosbridge.implementation.ROSBridgeWebSocketClient create(String p3)
    {
        try {
            com.boat.jrosbridge.rosbridge.implementation.ROSBridgeWebSocketClient v0 = new com.boat.jrosbridge.rosbridge.implementation.ROSBridgeWebSocketClient(new java.net.URI(p3));
        } catch (java.net.URISyntaxException v1_2) {
            v1_2.printStackTrace();
        }
        return v0;
    }

    public static String decodePNG(String p11)
    {
        android.graphics.Bitmap v2 = android.graphics.BitmapFactory.decodeStream(new java.io.ByteArrayInputStream(android.util.Base64.decode(p11, 0)));
        StringBuilder v3_1 = new StringBuilder();
        int v4_1 = 0;
        while (v4_1 < v2.getHeight()) {
            int v5_1 = 0;
            while (v5_1 < v2.getWidth()) {
                int v6_1 = v2.getPixel(v5_1, v4_1);
                int v7 = android.graphics.Color.red(v6_1);
                int v8 = android.graphics.Color.green(v6_1);
                int v9 = android.graphics.Color.blue(v6_1);
                if ((v7 != 10) || ((v8 != 10) || (v9 != 10))) {
                    v3_1.append(((char) v7));
                    v3_1.append(((char) v8));
                    v3_1.append(((char) v9));
                }
                v5_1++;
            }
            v4_1++;
        }
        return v3_1.toString();
    }

    public void closeBlocking()
    {
        super.closeBlocking();
        try {
            Exception v0_3 = this.getClass().getSuperclass().getDeclaredField("channel");
            v0_3.setAccessible(1);
            String v1_1 = ((java.nio.channels.SocketChannel) v0_3.get(this));
        } catch (Exception v0_1) {
            android.util.Log.d("ROSWebSocketClient", "closeBlocking: Exception in Websocket close hack.");
            v0_1.printStackTrace();
            return;
        }
        if ((v1_1 == null) || (!v1_1.isOpen())) {
            return;
        } else {
            java.net.Socket v2_1 = v1_1.socket();
            if (v2_1 == null) {
                return;
            } else {
                v2_1.close();
                return;
            }
        }
    }

    public Class getRegisteredMessage(String p3)
    {
        return ((Class) this.classes.lookup(com.boat.jrosbridge.message.Message, p3));
    }

    public void onClose(int p3, String p4, boolean p5)
    {
        if (this.listener != null) {
            if ((!p5) && (p3 != 1000)) {
                int v0_2 = 0;
            } else {
                v0_2 = 1;
            }
            this.listener.onDisconnect(v0_2, p4, p3);
        }
        return;
    }

    public void onError(Exception p2)
    {
        if (this.listener == null) {
            p2.printStackTrace();
        } else {
            this.listener.onError(p2);
        }
        return;
    }

    public void onMessage(String p9)
    {
        if (p9.contains("\"op\": \"png\"")) {
            try {
                p9 = com.boat.jrosbridge.rosbridge.implementation.ROSBridgeWebSocketClient.decodePNG(new org.json.JSONObject(p9).getString("data"));
            } catch (String v1_3) {
                v1_3.printStackTrace();
            }
        }
        if (this.debug) {
            android.util.Log.d("ROSWebSocketClient", new StringBuilder().append("onMessage: ROS>>>> ").append(p9).toString());
        }
        com.boat.jrosbridge.rosbridge.operation.Operation v0_9 = com.boat.jrosbridge.rosbridge.operation.Operation.toOperation(p9, this.classes);
        com.boat.jrosbridge.rosbridge.FullMessageHandler v2_1 = 0;
        com.boat.jrosbridge.message.Message v3 = 0;
        if (!(v0_9 instanceof com.boat.jrosbridge.rosbridge.operation.Publish)) {
            if ((v0_9 instanceof com.boat.jrosbridge.rosbridge.operation.ServiceResponse)) {
                String v4_4 = ((com.boat.jrosbridge.rosbridge.operation.ServiceResponse) v0_9);
                v2_1 = ((com.boat.jrosbridge.rosbridge.FullMessageHandler) this.handlers.lookup(com.boat.jrosbridge.rosbridge.operation.ServiceResponse, v4_4.service));
                v3 = v4_4.values;
            }
        } else {
            String v4_6 = ((com.boat.jrosbridge.rosbridge.operation.Publish) v0_9);
            v2_1 = ((com.boat.jrosbridge.rosbridge.FullMessageHandler) this.handlers.lookup(com.boat.jrosbridge.rosbridge.operation.Publish, v4_6.topic));
            v3 = v4_6.msg;
        }
        if (v2_1 == null) {
            if (this.debug) {
                if (!(v0_9 instanceof com.boat.jrosbridge.rosbridge.operation.Publish)) {
                    if ((v0_9 instanceof com.boat.jrosbridge.rosbridge.operation.ServiceResponse)) {
                        android.util.Log.d("ROSWebSocketClient", new StringBuilder().append("onMessage: No handler: id# ").append(v0_9.id).append(", Service Response ").append(((com.boat.jrosbridge.rosbridge.operation.ServiceResponse) v0_9).service).toString());
                    }
                } else {
                    android.util.Log.d("ROSWebSocketClient", new StringBuilder().append("onMessage: No handler: id# ").append(v0_9.id).append(", Publish ").append(((com.boat.jrosbridge.rosbridge.operation.Publish) v0_9).topic).toString());
                }
            }
        } else {
            v2_1.onMessage(v0_9.id, v3);
        }
        return;
    }

    public void onOpen(org.java_websocket.handshake.ServerHandshake p2)
    {
        if (this.listener != null) {
            this.listener.onConnect();
        }
        return;
    }

    public void register(Class p3, String p4, Class p5, com.boat.jrosbridge.rosbridge.FullMessageHandler p6)
    {
        com.boat.jrosbridge.message.Message.register(p5, ((java.util.Map) this.classes.get(com.boat.jrosbridge.message.Message)));
        this.classes.register(p3, p4, p5);
        if (p6 != null) {
            this.handlers.register(p3, p4, p6);
        }
        return;
    }

    public void send(com.boat.jrosbridge.rosbridge.operation.Operation p5)
    {
        String v0 = p5.toJSON();
        if (this.debug) {
            android.util.Log.d("ROSWebSocketClient", new StringBuilder().append(" ROS<<<<<< ").append(v0).toString());
        }
        if (!this.isClosed()) {
            this.send(v0);
            return;
        } else {
            android.util.Log.w("ROSWebSocketClient", new StringBuilder().append(" \u53d1\u9001\u6570\u636e\u5931\u8d25 ").append(v0).toString());
            return;
        }
    }

    public void setDebug(boolean p1)
    {
        this.debug = p1;
        return;
    }

    public void setListener(com.boat.jrosbridge.ROSClient$ConnectionStatusListener p1)
    {
        this.listener = p1;
        return;
    }

    public void unregister(Class p2, String p3)
    {
        this.handlers.unregister(p2, p3);
        return;
    }
}
