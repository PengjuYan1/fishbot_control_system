package com.jlboat.phone.message.map_msgs;
public class NavigationCreamSetResponse extends com.boat.jrosbridge.message.Message {
    public long result;

    public NavigationCreamSetResponse()
    {
        return;
    }

    public long getResult()
    {
        return this.result;
    }

    public void setResult(long p1)
    {
        this.result = p1;
        return;
    }
}
