package com.jlboat.phone.message.map_msgs;
public class GetConfigsResponse extends com.boat.jrosbridge.message.Message {
    public com.jlboat.phone.message.map_msgs.Config[] configs;
    public int status;

    public GetConfigsResponse()
    {
        return;
    }

    public java.util.List getConfigs()
    {
        return java.util.Arrays.asList(this.configs);
    }

    public int getStatus()
    {
        return this.status;
    }

    public void setConfigs(java.util.List p2)
    {
        com.jlboat.phone.message.map_msgs.Config[] v0_1 = new com.jlboat.phone.message.map_msgs.Config[0];
        this.configs = ((com.jlboat.phone.message.map_msgs.Config[]) p2.toArray(v0_1));
        return;
    }

    public void setStatus(int p1)
    {
        this.status = p1;
        return;
    }
}
