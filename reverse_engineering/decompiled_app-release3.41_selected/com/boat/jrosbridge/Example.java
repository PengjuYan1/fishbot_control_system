package com.boat.jrosbridge;
public class Example {

    public Example()
    {
        return;
    }

    public static void main(String[] p2)
    {
        com.boat.jrosbridge.rosbridge.ROSBridgeClient v0_1 = new com.boat.jrosbridge.rosbridge.ROSBridgeClient("ws://162.243.238.80:9090");
        v0_1.connect();
        try {
            com.boat.jrosbridge.Example.testService(v0_1);
        } catch (Throwable v1_1) {
            v1_1.printStackTrace();
        } catch (Throwable v1_2) {
            v0_1.disconnect();
            throw v1_2;
        }
        v0_1.disconnect();
        return;
    }

    public static void testService(com.boat.jrosbridge.rosbridge.ROSBridgeClient p7)
    {
        try {
            new com.boat.jrosbridge.Service("/rosapi/get_time", com.boat.jrosbridge.message.std_srvs.Empty, com.boat.jrosbridge.message.rosapi.GetTime, p7).verify();
            String v2_0 = new com.boat.jrosbridge.Service("/rosapi/service_type", com.boat.jrosbridge.message.rosapi.Service, com.boat.jrosbridge.message.rosapi.Type, p7);
            v2_0.verify();
            v2_0.callBlocking(new com.boat.jrosbridge.message.rosapi.Service("/rosapi/service_response_details"));
            new com.boat.jrosbridge.Service("/rosapi/service_response_details", com.boat.jrosbridge.message.rosapi.Type, com.boat.jrosbridge.message.rosapi.MessageDetails, p7).verify();
            new com.boat.jrosbridge.Topic("/rosout", com.boat.jrosbridge.message.Log, p7).verify();
        } catch (InterruptedException v0) {
            System.out.println("Process was interrupted.");
        }
        return;
    }

    public static void testTopic(com.boat.jrosbridge.rosbridge.ROSBridgeClient p4)
    {
        com.boat.jrosbridge.Topic v0_1 = new com.boat.jrosbridge.Topic("/clock", com.boat.jrosbridge.message.Clock, p4);
        v0_1.subscribe();
        try {
            Thread.sleep(20000);
            try {
                com.boat.jrosbridge.message.Clock v1_1 = ((com.boat.jrosbridge.message.Clock) v0_1.take());
            } catch (com.boat.jrosbridge.message.Time v2) {
            }
            com.boat.jrosbridge.message.Time v2_2 = v1_1.clock;
            v2_2.nsecs = (v2_2.nsecs + 1);
            v0_1.unsubscribe();
            v0_1.advertise();
            v0_1.publish(v1_1);
            v0_1.unadvertise();
            return;
        } catch (com.boat.jrosbridge.message.Clock v1) {
        }
    }
}
