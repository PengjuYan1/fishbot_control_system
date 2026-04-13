package com.jlboat.phone.message.map_msgs;
public class DeleteAlllogsResponse extends com.boat.jrosbridge.message.Message {
    public int status;

    public DeleteAlllogsResponse()
    {
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
