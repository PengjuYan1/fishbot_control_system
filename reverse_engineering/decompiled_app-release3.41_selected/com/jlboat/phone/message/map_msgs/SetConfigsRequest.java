package com.jlboat.phone.message.map_msgs;
public class SetConfigsRequest extends com.boat.jrosbridge.message.Message {
    public com.jlboat.phone.message.map_msgs.Config[] configs;
    public int type;

    public SetConfigsRequest()
    {
        return;
    }

    public java.util.List getConfigs()
    {
        return java.util.Arrays.asList(this.configs);
    }

    public int getType()
    {
        return this.type;
    }

    public void setConfigs(java.util.List p2)
    {
        com.jlboat.phone.message.map_msgs.Config[] v0_1 = new com.jlboat.phone.message.map_msgs.Config[0];
        this.configs = ((com.jlboat.phone.message.map_msgs.Config[]) p2.toArray(v0_1));
        return;
    }

    public void setType(int p1)
    {
        this.type = p1;
        return;
    }
}
