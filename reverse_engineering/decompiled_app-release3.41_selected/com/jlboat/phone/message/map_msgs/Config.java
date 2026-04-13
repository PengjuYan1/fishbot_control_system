package com.jlboat.phone.message.map_msgs;
public class Config extends com.boat.jrosbridge.message.Message {
    public String config_name;
    public String config_value;
    public int type;

    public Config()
    {
        return;
    }

    public String getConfigName()
    {
        return this.config_name;
    }

    public String getConfigValue()
    {
        return this.config_value;
    }

    public int getType()
    {
        return this.type;
    }

    public void setConfigName(String p1)
    {
        this.config_name = p1;
        return;
    }

    public void setConfigValue(String p1)
    {
        this.config_value = p1;
        return;
    }

    public void setType(int p1)
    {
        this.type = p1;
        return;
    }

    public String toString()
    {
        return new StringBuilder().append("Config{type=").append(this.type).append(", config_name=\'").append(this.config_name).append(39).append(", config_value=\'").append(this.config_value).append(39).append(125).toString();
    }
}
