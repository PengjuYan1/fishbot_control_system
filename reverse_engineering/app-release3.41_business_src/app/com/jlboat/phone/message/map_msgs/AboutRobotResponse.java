package com.jlboat.phone.message.map_msgs;
public class AboutRobotResponse extends com.boat.jrosbridge.message.Message {
    public String nav_info;
    public int status;

    public AboutRobotResponse()
    {
        return;
    }

    public String getNavInfo()
    {
        return this.nav_info;
    }

    public int getStatus()
    {
        return this.status;
    }

    public void setNavInfo(String p1)
    {
        this.nav_info = p1;
        return;
    }

    public void setStatus(int p1)
    {
        this.status = p1;
        return;
    }
}
