package com.jlboat.phone.message.map_msgs;
public class SetWifiRequest extends com.boat.jrosbridge.message.Message {
    public String wifi_name;
    public String wifi_pass;

    public SetWifiRequest()
    {
        return;
    }

    public String getWifiName()
    {
        return this.wifi_name;
    }

    public String getWifiPass()
    {
        return this.wifi_pass;
    }

    public void setWifiName(String p1)
    {
        this.wifi_name = p1;
        return;
    }

    public void setWifiPass(String p1)
    {
        this.wifi_pass = p1;
        return;
    }
}
