package com.boat.jrosbridge.rosbridge.implementation;
public class Registry extends java.util.HashMap {

    public Registry()
    {
        return;
    }

    public Object lookup(Class p3, String p4)
    {
        Object v0 = 0;
        java.util.Map v1_1 = ((java.util.Map) this.get(p3));
        if (v1_1 != null) {
            v0 = v1_1.get(p4);
        }
        return v0;
    }

    public void register(Class p3, String p4, Object p5)
    {
        java.util.HashMap v0_1 = ((java.util.Map) this.get(p3));
        if (v0_1 == null) {
            v0_1 = new java.util.HashMap();
            this.put(p3, v0_1);
        }
        v0_1.put(p4, p5);
        return;
    }

    public void unregister(Class p2, String p3)
    {
        java.util.Map v0_1 = ((java.util.Map) this.get(p2));
        if (v0_1 != null) {
            v0_1.remove(p3);
        }
        return;
    }
}
