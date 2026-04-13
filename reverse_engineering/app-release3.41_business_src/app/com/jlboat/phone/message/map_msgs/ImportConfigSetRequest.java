package com.jlboat.phone.message.map_msgs;
public class ImportConfigSetRequest extends com.boat.jrosbridge.message.Message {
    public String files_site;

    public ImportConfigSetRequest()
    {
        return;
    }

    public String getFiles_site()
    {
        return this.files_site;
    }

    public void setFiles_site(String p1)
    {
        this.files_site = p1;
        return;
    }
}
