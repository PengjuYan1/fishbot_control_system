package com.jlboat.phone.message.map_msgs;
public class DeleteAllbagsResponse extends com.boat.jrosbridge.message.Message {
    String _DEFINITION;
    public int status;

    public DeleteAllbagsResponse()
    {
        this._DEFINITION = "int32 status";
        return;
    }

    public int getStatus()
    {
        return this.status;
    }

    public void setStatus(int p1)
    {
        this.status = p1;
        return;
    }
}
