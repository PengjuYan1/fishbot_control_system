package com.boat.jrosbridge.rosbridge.operation;
public class Operation extends com.boat.jrosbridge.message.Message implements java.io.Serializable {
    private static Long uid;
    public String id;
    public String op;

    static Operation()
    {
        com.boat.jrosbridge.rosbridge.operation.Operation.uid = Long.valueOf(0);
        return;
    }

    public Operation()
    {
        this.op = com.boat.jrosbridge.rosbridge.operation.Operation.getMessageType(this.getClass());
        this.id = com.boat.jrosbridge.rosbridge.operation.Operation.nextId();
        return;
    }

    private static void initClass(com.boat.jrosbridge.rosbridge.implementation.Registry p2, Class p3)
    {
        p2.register(com.boat.jrosbridge.message.Message, com.boat.jrosbridge.message.Message.getMessageType(p3), p3);
        return;
    }

    public static void initialize(com.boat.jrosbridge.rosbridge.implementation.Registry p3)
    {
        com.boat.jrosbridge.rosbridge.operation.Operation.initClass(p3, com.boat.jrosbridge.rosbridge.operation.Advertise);
        com.boat.jrosbridge.rosbridge.operation.Operation.initClass(p3, com.boat.jrosbridge.rosbridge.operation.Authenticate);
        com.boat.jrosbridge.rosbridge.operation.Operation.initClass(p3, com.boat.jrosbridge.rosbridge.operation.CallService);
        com.boat.jrosbridge.rosbridge.operation.Operation.initClass(p3, com.boat.jrosbridge.rosbridge.operation.Fragment);
        com.boat.jrosbridge.rosbridge.operation.Operation.initClass(p3, com.boat.jrosbridge.rosbridge.operation.Operation);
        com.boat.jrosbridge.rosbridge.operation.Operation.initClass(p3, com.boat.jrosbridge.rosbridge.operation.PNG);
        com.boat.jrosbridge.rosbridge.operation.Operation.initClass(p3, com.boat.jrosbridge.rosbridge.operation.Publish);
        com.boat.jrosbridge.rosbridge.operation.Operation.initClass(p3, com.boat.jrosbridge.rosbridge.operation.ServiceResponse);
        com.boat.jrosbridge.rosbridge.operation.Operation.initClass(p3, com.boat.jrosbridge.rosbridge.operation.SetStatusLevel);
        com.boat.jrosbridge.rosbridge.operation.Operation.initClass(p3, com.boat.jrosbridge.rosbridge.operation.Status);
        com.boat.jrosbridge.rosbridge.operation.Operation.initClass(p3, com.boat.jrosbridge.rosbridge.operation.Subscribe);
        com.boat.jrosbridge.rosbridge.operation.Operation.initClass(p3, com.boat.jrosbridge.rosbridge.operation.Unadvertise);
        com.boat.jrosbridge.rosbridge.operation.Operation.initClass(p3, com.boat.jrosbridge.rosbridge.operation.Unsubscribe);
        com.boat.jrosbridge.rosbridge.operation.Operation.initClass(p3, com.boat.jrosbridge.rosbridge.operation.Wrapper);
        p3.register(com.boat.jrosbridge.rosbridge.operation.Wrapper, com.boat.jrosbridge.message.Message.getMessageType(com.boat.jrosbridge.rosbridge.operation.Publish), com.boat.jrosbridge.rosbridge.operation.Publish);
        p3.register(com.boat.jrosbridge.rosbridge.operation.Wrapper, com.boat.jrosbridge.message.Message.getMessageType(com.boat.jrosbridge.rosbridge.operation.CallService), com.boat.jrosbridge.rosbridge.operation.CallService);
        p3.register(com.boat.jrosbridge.rosbridge.operation.Wrapper, com.boat.jrosbridge.message.Message.getMessageType(com.boat.jrosbridge.rosbridge.operation.ServiceResponse), com.boat.jrosbridge.rosbridge.operation.ServiceResponse);
        return;
    }

    private static declared_synchronized String nextId()
    {
        try {
            Throwable v1_2 = com.boat.jrosbridge.rosbridge.operation.Operation.uid.toString();
            com.boat.jrosbridge.rosbridge.operation.Operation.uid = Long.valueOf((com.boat.jrosbridge.rosbridge.operation.Operation.uid.longValue() + 1));
            return v1_2;
        } catch (Throwable v1_1) {
            throw v1_1;
        }
    }

    public static com.boat.jrosbridge.rosbridge.operation.Operation toOperation(String p2, com.boat.jrosbridge.rosbridge.implementation.Registry p3)
    {
        int v1;
        com.boat.jrosbridge.rosbridge.operation.Wrapper v0_2 = ((com.boat.jrosbridge.rosbridge.operation.Wrapper) com.boat.jrosbridge.rosbridge.implementation.JSON.toMessage(p2, com.boat.jrosbridge.rosbridge.operation.Wrapper, p3));
        if (v0_2 == null) {
            v1 = 0;
        } else {
            v1 = v0_2.msg;
        }
        return v1;
    }

    public String toJSON()
    {
        return com.boat.jrosbridge.rosbridge.implementation.JSON.toJSON(this);
    }
}
