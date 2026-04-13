package com.jlboat.phone.message.map_msgs;
public class RecordBag extends com.boat.jrosbridge.message.Message {
    public String bag_name;
    public String config;
    public String[] topic_list;
    public int type;

    public RecordBag()
    {
        return;
    }

    public String getBagName()
    {
        return this.bag_name;
    }

    public String getConfig()
    {
        return this.config;
    }

    public java.util.List getTopicList()
    {
        return java.util.Arrays.asList(this.topic_list);
    }

    public int getType()
    {
        return this.type;
    }

    public void setBagName(String p1)
    {
        this.bag_name = p1;
        return;
    }

    public void setConfig(String p1)
    {
        this.config = p1;
        return;
    }

    public void setTopicList(java.util.List p2)
    {
        String[] v0_1 = new String[0];
        this.topic_list = ((String[]) p2.toArray(v0_1));
        return;
    }

    public void setType(int p1)
    {
        this.type = p1;
        return;
    }
}
