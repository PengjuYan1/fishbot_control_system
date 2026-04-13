package com.jlboat.phone.message.map_msgs;
public class ImportConfigSetResponse extends com.boat.jrosbridge.message.Message {
    public boolean status;

    public ImportConfigSetResponse()
    {
        return;
    }

    public boolean isStatus()
    {
        return this.status;
    }

    public void setStatus(boolean p1)
    {
        this.status = p1;
        return;
    }
}
